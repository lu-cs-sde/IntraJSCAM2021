package test;

import AST.BytecodeParser;
import AST.CompilationUnit;
import AST.Frontend;
import AST.JavaParser;

/**
 * Prints a dot specification of the CFG with control flow annotations to System.out
 * @author dt09hg0
 *
 */
public class DotGraphDumper extends Frontend {
	public static void main(String args[]) {
		dumpGraph(args);
	}

	public static int dumpGraph(String args[]) {
		int result = new DotGraphDumper().run(
				args,
				new BytecodeParser(),
				new JavaParser() {
					@Override
					public CompilationUnit parse(java.io.InputStream is,
							String fileName) throws java.io.IOException,
							beaver.Parser.Exception {

						return new parser.JavaParser().parse(is, fileName);
					}
				});
		return result;
	}

	protected void processNoErrors(CompilationUnit unit) {
		//TODO The body to be examined must be first in the input file (should be possible to select any one)
		System.out.println("digraph {");
		System.out.print(unit.getTypeDecl(0).getBodyDecl(0).dotGraphCFG());
		System.out.println("}");
  	}

	@Override
	protected String name() {
		return "JastAddJ-IntraFlow";
	}

	@Override
	protected String version() {
		return "To be added";
	}
}
