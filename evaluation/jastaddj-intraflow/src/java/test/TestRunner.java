package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.StringTokenizer;

import test.core.Result;
import test.core.Util;

/**
 * Utility methods for running JastAddJ-Intraflow unit tests.
 * @author Jesper Öqvist <jesper.oqvist@cs.lth.se>
 * @author Harald Görtz <harald.gortz@gmail.com>
 */
public class TestRunner {
	
	public static void main(String[] args) {
		String testName = "block/block01";
		Properties props = new Properties();
		props.put("beaver-rt.jar", "../jastaddj/tools/beaver-rt.jar");
		TestRunner.runTest(testName, props);
	}

	private static String SYS_LINE_SEP = System.getProperty("line.separator");
	private static File BIN_DIR = new File("bin");

	/**
	 * Run the unit test in testDir with the given test suite properties.
	 * @param testName
	 * @param testSuiteProperties
	 */
	public static void runTest(String testName, Properties testSuiteProperties) {
		String testDir = Util.TEST_ROOT + "/" + testName;
		Properties testProperties = Util.getProperties(new File(testDir, "Test.properties"));
		Result expected = getExpectedResult(testProperties);

		File tmpDir = setupTemporaryDirectory(testDir);

		// Write the dot graph specification
		String stdErr = dumpGraphSpec(testSuiteProperties, testProperties, tmpDir, testDir, expected);
		if (!stdErr.isEmpty()) {
			fail("Standard error not empty:\n" + stdErr);
		}

		if (expected == Result.EXEC_PASSED ||
				expected == Result.EXEC_FAILED) {

			return;
		}
		//Generate png from graph spec
		generateGraphImage(tmpDir, "out", "out.png");
		
		// Compare the output with the expected output
		compareOutput(tmpDir, testDir);
	}

	/**
	 * Set up the temporary directory - create it if it does not exist
	 * and clean it if it does already exist.
	 * @param testDir The temporary directory
	 */
	private static File setupTemporaryDirectory(String testDir) {
		String tmpDirName = testDir;
		if (tmpDirName.startsWith("tests")) {
			tmpDirName = tmpDirName.substring(6);
		}

		File tmpDir = new File("testoutput" + File.separator + tmpDirName);

		if (!tmpDir.exists()) {
			// create directory with intermediate parent directories
			tmpDir.mkdirs();
		} else {
			// clean temporary directory
			cleanDirectory(tmpDir);
		}
		return tmpDir;
	}

	/**
	 * Recursively remove all files and folders in a directory
	 * @param dir The directory to nuke
	 */
	private static void cleanDirectory(File dir) {
		for (File file: dir.listFiles()) {
			if (!file.isDirectory()) {
				file.delete();
			} else {
				cleanDirectory(file);
				file.delete();
			}
		}
	}

	private static Result getExpectedResult(Properties props) {

		if (!props.containsKey("result"))
			return Result.OUTPUT_PASSED;

		String result = props.getProperty("result");
		if (result.equals("COMPILE_PASSED") || result.equals("COMPILE_PASS"))
			return Result.COMPILE_PASSED;
		else if (result.equals("COMPILE_FAILED") || result.equals("COMPILE_FAIL"))
			return Result.COMPILE_FAILED;
		else if (result.equals("EXEC_PASSED") || result.equals("EXEC_PASS"))
			return Result.EXEC_PASSED;
		else if (result.equals("EXEC_FAILED") || result.equals("EXEC_FAIL"))
			return Result.EXEC_FAILED;
		else if (result.equals("OUTPUT_PASSED") || result.equals("OUTPUT_PASS"))
			return Result.OUTPUT_PASSED;
		else {
			fail("Unknown result option: " + result);
			return Result.OUTPUT_PASSED;
		}
	}

	/**
	 * Compare the generated output to the expected output
	 */
	private static void compareOutput(File tmpDir, String testDir) {
		try {
			File expectedFile = new File(testDir, "out.expected");
			File actualFile = new File(tmpDir, "out");
			String expected = readFileToString(expectedFile);
			String actual = readFileToString(actualFile);
			boolean same = generateGraphDiff(tmpDir, testDir, expected, actual);
			if (!same) {
				assertEquals("Output files differ", expected, actual);
			}

			expectedFile = new File(testDir, "err.expected");
			actualFile = new File(tmpDir, "err");
			assertEquals("Error output files differ", readFileToString(expectedFile),
					readFileToString(actualFile));
		} catch (IOException e) {
			fail("IOException occurred while comparing output: " + e.getMessage());
		}
	}

	/**
	 * <p>Reads an entire file to a string object.
	 *
	 * <p>If the file does not exist an empty string is returned.
	 *
	 * <p>The system dependent line separator char sequence is replaced by
	 * the newline character.
	 *
	 * @param file
	 * @return
	 * @throws FileNotFoundException
	 */
	private static String readFileToString(File file) throws FileNotFoundException {
		if (!file.isFile())
			return "";

		Scanner scanner = new Scanner(file);
		scanner.useDelimiter("\\Z");
		String theString = scanner.hasNext() ? scanner.next() : "";
		theString = theString.replace(SYS_LINE_SEP, "\n").trim();
		scanner.close();
		return theString;
	}
	
	/**
	 * Write a dot graph specification of the test program
	 * @param testProps
	 * @param tmpDir
	 * @param testDir
	 * @param expected
	 * @return The standard error content
	 */
	private static String dumpGraphSpec(Properties testSuiteProps, Properties testProps, File tmpDir,
			String testDir, Result expected) {

		StringBuffer errors = new StringBuffer();

		StringBuffer classpath = new StringBuffer(tmpDir.getPath());
		classpath.append(File.pathSeparator).append(BIN_DIR);
		if (testProps.containsKey("classpath")) {
			classpath.append(File.pathSeparator).append(testProps.getProperty("classpath"));
		}
		classpath.append(File.pathSeparator).append(testSuiteProps.getProperty("beaver-rt.jar"));

		try {
			Process p = Runtime.getRuntime().exec("java -classpath " +
					classpath + " test.DotGraphDumper " + testDir + "/Test.input");
			// write output to file
			InputStream in = p.getInputStream();
			OutputStream out = new FileOutputStream(new File(tmpDir, "out"));
			InputStream errIn = p.getErrorStream();
			OutputStream errOut = new FileOutputStream(new File(tmpDir, "err"));
			int data;
			while ((data = in.read()) != -1) {
				out.write(data);
			}
			out.close();
			while ((data = errIn.read()) != -1) {
				errOut.write(data);
				errors.append((char) data);
			}
			errOut.close();
			int exitValue = p.waitFor();
			if (exitValue == 0) {
				if (expected == Result.EXEC_FAILED) {
					fail("Code execution passed when expected to fail");
				}
				return errors.toString();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (expected != Result.EXEC_FAILED) {
			fail("Code execution failed when expected to pass:\n" +
					errors.toString());
		}

		return errors.toString();
	}
	
	/**
	 * Write a dot graph specification of the test program with differences to the
	 * expected output marked in red.
	 * @param tmpDir the location of the graph specification and resulting file
	 * @param testDir
	 * @param expected
	 * @param actual
	 */
	private static boolean generateGraphDiff(File tmpDir, String testDir, String expected, String actual) {
		boolean ans = true;
		try {
			FileWriter out = new FileWriter(new File(tmpDir, "diffGraph.dot"));
			StringTokenizer stEx = new StringTokenizer(expected, SYS_LINE_SEP);
			StringTokenizer stAc = new StringTokenizer(actual, SYS_LINE_SEP);
			
			List<String> exLines = new LinkedList<String>();
			while (stEx.hasMoreTokens()) {
				String line = stEx.nextToken().trim();
				if (!ignore(line)) {
					exLines.add(line);
				}
			}
			//Remove one (e.g. the last) closing brace
			exLines.remove("}");
			
			out.write("digraph {");
			out.write(SYS_LINE_SEP);
			
			boolean foundRBrace = false;
			while (stAc.hasMoreTokens() && !exLines.isEmpty()) {
				String ac = stAc.nextToken().trim();
				if (!foundRBrace && ac.equals("}")) {
					foundRBrace = true;
					continue;
				}
				if (ignore(ac)) {
					continue;
				}
				if (exLines.contains(ac)) {
					out.write(ac);
					out.write(SYS_LINE_SEP);
					exLines.remove(ac);
				} else {
					ans = false;
					out.write(colorizeLine(ac));
					out.write(SYS_LINE_SEP);
				}
			}
			
			while (stAc.hasMoreTokens()) {
				String ac = stAc.nextToken().trim();
				if (!foundRBrace && ac.equals("}")) {
					foundRBrace = true;
					continue;
				}
				if (ignore(ac)) {
					continue;
				}
				ans = false;
				out.write(colorizeLine(ac));
				out.write(SYS_LINE_SEP);
			}
			
			for (String ex : exLines) {
				if (ignore(ex)) {
					continue;
				}
				ans = false;
				out.write(colorizeLine(ex));
				out.write(SYS_LINE_SEP);
			}
			out.write("}");
			out.close();
		} catch (IOException e) {
			System.err.println("Could not generate difference graph: " + e);
		}
		generateGraphImage(tmpDir, "diffGraph.dot", "diffGraph.png");
		return ans;
	}
	
	/**
	 * Test if a line should generate a visible artifact if it differs from the expected output.
	 * @param s the line to investigate
	 * @return true if the line is equal to some uninteresting line, and false otherwise
	 */
	private static boolean ignore(String s) {
		return s.equals("digraph {") || s.equals("node [shape=box];");
	}
	
	private static boolean isIgnored(String s) {
		return false;
	}
	
	/**
	 * Test if a line describes a node or an edge, i.e. describes a component that can be colored in the comparison image.
	 * Essentially, this methods tests whether a line describes a subgraph or not. (Only nodes and edges can be colored.)
	 * @param s the line to investigate
	 * @return true if the component described by the line can be colorized and false otherwise
	 */
	private static boolean canBeColorized(String s) {
		String trimmed = s.trim();
		return !trimmed.startsWith("{ rank") && !trimmed.equals("}");
	}

	/**
	 * Modifies a line so that its corresponding component will show up red in the comparison image, if possible.
	 * @param s the line to modify
	 * @return the modified line, or the same line if its component can not be colored
	 */
	private static String colorizeLine(String s) {
		StringBuffer sb = new StringBuffer("/* MISMATCHED LINE */ ");
		if (!canBeColorized(s)) {
			sb.append(s).append(" /* MISMATCHED LINE */");
			return sb.toString();
//			return s;
		}
		String[] split = s.split("\\[", 2);
		if (split.length > 1) {
			sb.append(split[0]);
			sb.append("[color=\"red\",");
			sb.append(split[1]);
		} else {
			sb.append(s, 0, s.length() - 1); //-1 for trailing semicolon
			sb.append("[color=\"red\"];");
		}
		sb.append(" /* MISMATCHED LINE */");
		return sb.toString();
	}

	/**
	 * Write a png image of the specified dot graph
	 * @param tmpDir the location of the graph specification and resulting file
	 * @param inFilename the dot graph specification
	 * @param outFilename the name of the resulting png file
	 */
	private static void generateGraphImage(File tmpDir, String inFilename, String outFilename) {
		try {
			Process p = Runtime.getRuntime().exec("dot -Tpng " + tmpDir + '/' + inFilename);
			// write output to file
			InputStream in = p.getInputStream();
			OutputStream out = new FileOutputStream(new File(tmpDir, outFilename));
			InputStream errIn = p.getErrorStream();
			int data;
			while ((data = in.read()) != -1) {
				out.write(data);
			}
			out.close();
			StringBuffer errors = new StringBuffer();
			while ((data = errIn.read()) != -1) {
				errors.append((char) data);
			}
			int exitValue = p.waitFor();
			if (exitValue != 0) {
				System.err.println("Could not write graph to " + tmpDir.getAbsolutePath() + '/' + outFilename);
				System.err.println(errors.toString());
			}
		} catch (IOException e) {
			System.err.println("Could not generate graph image: " + e);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Writes the actual line to the graph specification if it matches the expected line. Otherwise, both lines
	 * are modified to have a red color (if possible) in the comparison image. 
	 * @param out the file to write the specification to
	 * @param ex the expected line
	 * @param ac the actual line
	 * @throws IOException
	 */
	private static void compareAndWriteLine(FileWriter out, String ex, String ac) throws IOException {
		if (ex.equals(ac) && !isIgnored(ac)) {
			out.write(ac);
			out.write(SYS_LINE_SEP);
		} else if (!ex.equals(ac)) {
			if (!isIgnored(ex)) {
				out.write(colorizeLine(ex));
				out.write(SYS_LINE_SEP);
			}
			if (!isIgnored(ac)) {
				out.write(colorizeLine(ac));
				out.write(SYS_LINE_SEP);
			}
		}
	}

}
