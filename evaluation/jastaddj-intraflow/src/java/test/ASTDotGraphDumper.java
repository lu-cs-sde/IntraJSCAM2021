package test;

import AST.BytecodeParser;
import AST.CompilationUnit;
import AST.Frontend;
import AST.JavaParser;

/**
 * Prints a dot specification of the complete AST to System.out
 * @author dt09hg0
 *
 */
public class ASTDotGraphDumper extends Frontend {
	public static void main(String args[]) {
		dumpGraph(args);
	}

	public static int dumpGraph(String args[]) {
		int result = new ASTDotGraphDumper().run(
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
		System.out.println(unit.dotGraphAST());
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
