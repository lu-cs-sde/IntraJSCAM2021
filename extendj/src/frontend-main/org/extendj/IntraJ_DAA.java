package org.extendj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import org.extendj.JavaChecker;
import org.extendj.ast.Analysis;
import org.extendj.ast.CFGNode;
import org.extendj.ast.CFGRoot;
import org.extendj.ast.CompilationUnit;
import org.extendj.ast.Frontend;
import org.extendj.ast.MethodDecl;
import org.extendj.ast.Program;
import org.extendj.ast.SmallSet;
import org.extendj.ast.WarningMsg;
import org.extendj.flow.utils.IJGraph;
import org.extendj.flow.utils.Utils;

/**
 * Perform static semantic checks on a Java program.
 */
public class IntraJ_DAA extends Frontend {

  private static Integer numb_warning = 0;
  private static int n_iter = 0;
  private static boolean takeTime = false;
  private static long totalTime = 0;

  public static ArrayList<Analysis> analysis = new ArrayList<>();

  private String[] setEnv(String[] args) throws FileNotFoundException {
    if (args.length < 1) {
      System.err.println("You must specify a source file on the command line!");
      printOptionsUsage();
      System.exit(1);
    }
    ArrayList<String> FEOptions = new ArrayList<>();
    for (int i = 0; i < args.length; ++i) {
      String opt = args[i];
      if (opt.contains(".java")) {
        FEOptions.add(args[i]);
        continue;
      } else if (opt.startsWith("-niter=")) {
        takeTime = true;
        String x = opt.substring(opt.indexOf("=") + 1, opt.length());
        n_iter = Integer.parseInt(x);
        continue;
      } else if (opt.equals("-classpath")) {
        FEOptions.add("-classpath");
        FEOptions.add(args[++i]);
      } else if (opt.equals("-help")) {
        printOptionsUsage();
        System.exit(0);
      } else if (opt.equals("-excludelit")) {
        IntraJ.excludeLiteralsAndNull = true;
      } else {
        System.err.println("Unrecognized option: " + opt);
        printOptionsUsage();
        System.exit(1);
      }
    }
    FEOptions.add("-nowarn");
    return FEOptions.toArray(new String[FEOptions.size()]);
  }

  /**
   * Entry point for the Java checker.
   * @param args command-line arguments
   */
  public static void main(String args[]) throws FileNotFoundException {
    IntraJ_DAA intrajp = new IntraJ_DAA();
    String[] jCheckerArgs = intrajp.setEnv(args);
    for (int i = 0; i <= n_iter; ++i) {
      totalTime = 0;
      intrajp = new IntraJ_DAA();
      intrajp.run(jCheckerArgs);
    }
    System.out.println(String.format("%.6f", totalTime / 1_000_000_000.0));
  }

  /**
   * Initialize the Java checker.
   */
  public IntraJ_DAA() { super("IntraJ_DAA", ExtendJVersion.getVersion()); }

  /**
   * @param args command-line arguments
   * @return {@code true} on success, {@code false} on error
   * @deprecated Use run instead!
   */
  @Deprecated
  public static boolean compile(String args[]) {
    return 0 == new JavaChecker().run(args);
  }

  /**
   * Run the Java checker.
   * @param args command-line arguments
   * @return 0 on success, 1 on error, 2 on configuration error, 3 on system
   */
  public int run(String args[]) {
    return run(args, Program.defaultBytecodeReader(),
               Program.defaultJavaParser());
  }

  public Program getEntryPoint() { return program; }

  /**
   * Called for each from-source compilation unit with no errors.
   */
  protected void processNoErrors(CompilationUnit unit) {
    long startTime = System.nanoTime();
    unit.DAA();
    totalTime += (System.nanoTime() - startTime);
  }

  @Override
  protected String name() {
    return "IntraJ";
  }

  @Override
  protected String version() {
    return "IEEE-SCAM2021";
  }

  void printOptionsUsage() {
    System.out.println(name() + " - Version:" + version());
    System.out.println(
        "The purpose of this JAR file is to compute first the DDA() attibute"
        + "for all the CompilationUnit in the AST.");
    System.out.println("Available options:");
    System.out.println(
        "    * -niter=N: the anaysis is triggered N times.\n"
        +
        "The execution time for the first N-1 iteration are discared and only the N-th iteration is reported to the user.");
    System.out.println("    * -classpath=path/to/classpath");
    System.out.println(
        "    * -help: prints the available options and a description of the the jar.");
  }
}
