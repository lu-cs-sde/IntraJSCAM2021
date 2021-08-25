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
public class IntraJ_CFGNPA extends Frontend {

  private static Integer numb_warning = 0;
  private static int n_iter = 0;
  private static long totalTime = 0;

  public static ArrayList<Analysis> analysis = new ArrayList<>();

  private static String[] setEnv(String[] args) throws FileNotFoundException {
    if (args.length < 1) {
      System.err.println("You must specify a source file on the command line!");
      // printUsage();
      System.exit(1);
    }

    ArrayList<String> FEOptions = new ArrayList<>();
    for (int i = 0; i < args.length; ++i) {
      String opt = args[i];
      if (opt.contains(".java")) {
        FEOptions.add(args[i]);
        continue;
      } else if (opt.startsWith("-niter=")) {
        String x = opt.substring(opt.indexOf("=") + 1, opt.length());
        n_iter = Integer.parseInt(x);
        continue;
      } else if (opt.equals("-classpath")) {
        FEOptions.add("-classpath");
        FEOptions.add(args[++i]);
      }
    }
    FEOptions.add("-nowarn");
    return FEOptions.toArray(new String[FEOptions.size()]);
  }

  /**
   * Entry point for the Java checker.
   * @param args command-line arguments
   */
  public static void main(String args[])
      throws FileNotFoundException, InterruptedException, IOException {
    String[] jCheckerArgs = setEnv(args);
    for (int i = 0; i <= n_iter; ++i) {
      totalTime = 0;
      IntraJ_CFGNPA intrajp = new IntraJ_CFGNPA();
      intrajp.run(jCheckerArgs);
    }
    System.out.println(String.format("%.6f", totalTime / 1_000_000_000.0));
  }

  /**
   * Initialize the Java checker.
   */
  public IntraJ_CFGNPA() {
    super("IntraJ_CFGNPA", ExtendJVersion.getVersion());
  }

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
  void traverseCFG(CFGNode t, Set<CFGNode> nodes) {
    if (nodes.contains(t))
      return;
    nodes.add(t);
    for (CFGNode n : t.succ()) {
      traverseCFG(n, nodes);
    }
  }

  public Program getEntryPoint() { return program; }

  /**
   * Called for each from-source compilation unit with no errors.
   */
  protected void processNoErrors(CompilationUnit unit) {
    long startTime = System.nanoTime();
    for (CFGRoot t : unit.methods()) {
      traverseCFG(t.entry(), new HashSet<CFGNode>());
    }
    unit.NPA();
    totalTime += System.nanoTime() - startTime;
  }

  @Override
  protected String name() {
    return "IntraJ";
  }

  @Override
  protected String version() {
    return "0.9";
  }
}