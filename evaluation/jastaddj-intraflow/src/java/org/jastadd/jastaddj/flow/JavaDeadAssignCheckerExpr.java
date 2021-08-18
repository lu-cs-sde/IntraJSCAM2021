package org.jastadd.jastaddj.flow;

import AST.ASTNode;
import AST.BytecodeParser;
import AST.CFGNode;
import AST.CompilationUnit;
import AST.Frontend;
import AST.JavaParser;
import AST.SmallSet;
import AST.VariableDeclaration;
import java.io.FileNotFoundException;
import java.util.ArrayList;

class JavaDeadAssignChecker extends Frontend {

  private static boolean takeTime = false;
  private static long totalTime = 0;
  private static int n_iter = 0;

  private static String[] setEnv(String[] args) throws FileNotFoundException {
    ArrayList<String> FEOptions = new ArrayList<String>();
    for (int i = 0; i < args.length; i++) {
      String s = args[i];
      if (s.startsWith("-niter=")) {
        takeTime = true;
        String x = s.substring(s.indexOf("=") + 1, s.length());
        n_iter = Integer.parseInt(x);
      } else if (s.equals("-classpath")) {
        FEOptions.add("-classpath");
        FEOptions.add(args[++i]);
      } else {
        FEOptions.add(s);
      }
    }
    FEOptions.add("-nowarn");
    return FEOptions.toArray(new String[FEOptions.size()]);
  }

  public static void main(String args[]) throws FileNotFoundException {
    compile(setEnv(args));
  }

  public static int compile(String args[]) {
    for (int i = 0; i <= n_iter; ++i) {
      totalTime = 0;
      new JavaDeadAssignChecker().run(
          args, new BytecodeParser(), new JavaParser() {
            @Override
            public CompilationUnit parse(java.io.InputStream is,
                                         String fileName)
                throws java.io.IOException, beaver.Parser.Exception {
              return new parser.JavaParser().parse(is, fileName);
            }
          });
      if (takeTime) {
        System.out.println("Total time used for dead assignment analysis : " +
                           totalTime / 1000 + "." + totalTime % 1000 + "s");
      }
    }
    return 0;
  }

  protected void processNoErrors(CompilationUnit unit) {

    if (takeTime) {
      long startTime = System.currentTimeMillis();
      SmallSet<CFGNode> result = unit.deadAssignments();
      long dt = System.currentTimeMillis() - startTime;
      totalTime += dt;
    } else {
      for (CFGNode node : unit.deadAssignments()) {
        String packageName = node.hostType().fullName();
        int index = packageName.indexOf(".Anonymous");
        if (index != -1) {
          packageName = packageName.substring(0, index);
        }
        int kind = 1;
        if (node instanceof VariableDeclaration &&
            !((VariableDeclaration)node).hasInit()) {
          kind = 0;
        }
        String header = "[LVA - " + unit.pathName() + ":" +
                        ((ASTNode)node).location() + "]";
        System.out.println(header);
      }
    }
  }

  @Override
  protected String name() {
    return "JavaDeadAssignChecker";
  }

  @Override
  protected String version() {
    return "Temporary version";
  }
}