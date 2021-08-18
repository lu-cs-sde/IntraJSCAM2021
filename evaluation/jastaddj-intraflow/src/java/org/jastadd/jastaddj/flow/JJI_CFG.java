package org.jastadd.jastaddj.flow;

import AST.ASTNode;
import AST.BodyDecl;
import AST.BytecodeParser;
import AST.CFGNode;
import AST.CompilationUnit;
import AST.Frontend;
import AST.JavaParser;
import AST.SmallSet;
import AST.VariableDeclaration;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class JJI_CFG extends Frontend {

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
      new JJI_CFG().run(args, new BytecodeParser(), new JavaParser() {
        @Override
        public CompilationUnit parse(java.io.InputStream is, String fileName)
            throws java.io.IOException, beaver.Parser.Exception {
          return new parser.JavaParser().parse(is, fileName);
        }
      });
    }
    if (takeTime) {
      System.out.println(totalTime / 1000 + "." + totalTime % 1000);
    }
    return 0;
  }

  void traverseCFG(CFGNode t, Set<CFGNode> nodes) {
    if (nodes.contains(t))
      return;
    nodes.add(t);
    for (CFGNode n : t.succ()) {
      traverseCFG(n, nodes);
    }
  }

  protected void processNoErrors(CompilationUnit unit) {
    long startTime = System.currentTimeMillis();
    SmallSet<CFGNode> result = unit.deadAssignments();
    for (BodyDecl t : unit.methods()) {
      traverseCFG(t.entry(), new HashSet<CFGNode>());
    }
    long dt = System.currentTimeMillis() - startTime;
    totalTime += dt;
  }

  @Override
  protected String name() {
    return "JJI_CFG";
  }

  @Override
  protected String version() {
    return "Temporary version";
  }
}
