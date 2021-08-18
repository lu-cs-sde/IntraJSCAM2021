/*
 * The JastAdd Extensible Java Compiler (http://jastadd.org) is covered
 * by the modified BSD License. You should have received a copy of the
 * modified BSD license with this compiler.
 *
 * Copyright (c) 2005-2008, Torbjorn Ekman
 *                    2014, Jesper Öqvist <jesper.oqvist@cs.lth.se>
 * All rights reserved.
 */
package org.jastadd.jastaddj;

import AST.*;

import java.util.*;

/**
 * Pretty-print some Java source files.
 */
class JavaPrettyPrinter extends Frontend {

	/**
	 * Entry point for the compiler frontend.
	 * @param args command-line arguments
	 */
	public static void main(String args[]) {
		int exitCode = new JavaPrettyPrinter().run(args);
		if (exitCode != 0) {
			System.exit(exitCode);
		}
	}

	private final JavaParser parser;
	private final BytecodeParser bytecodeParser;

	/**
	 * Initialize the compiler.
	 */
	public JavaPrettyPrinter() {
		super("JastAddJ Java Pretty Printer", JastAddJVersion.getVersion());
		parser = new JavaParser() {
			@Override
			public CompilationUnit parse(java.io.InputStream is,
					String fileName) throws java.io.IOException,
					beaver.Parser.Exception {
				return new parser.JavaParser().parse(is, fileName);
			}
		};
		bytecodeParser = new BytecodeParser();
	}

	/**
	 * @param args command-line arguments
	 * @return {@code true} on success, {@code false} on error
	 * @deprecated Use run instead!
	 */
	@Deprecated
	public static boolean compile(String args[]) {
		return 0 == new JavaPrettyPrinter().run(args);
	}

	/**
	 * Pretty print the source files.
	 * @param args command-line arguments
	 * @return 0 on success, 1 on error, 2 on configuration error, 3 on system
	 */
	public int run(String args[]) {
		return run(args, bytecodeParser, parser);
	}

	@SuppressWarnings("rawtypes")
	@Override
	protected void processErrors(Collection errors, CompilationUnit unit) {
		super.processErrors(errors, unit);
		System.out.println(unit.prettyPrint());
	}
	@Override
	protected void processNoErrors(CompilationUnit unit) {
		System.out.println(unit.prettyPrint());
	}
}
