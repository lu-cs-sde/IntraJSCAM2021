/* This file was generated with JastAdd2 (http://jastadd.org) version 2.1.4-36-g18008bb */
package AST;

import java.util.HashSet;
import java.io.File;
import java.util.Set;
import java.util.Collections;
import java.util.Collection;
import java.util.ArrayList;
import beaver.*;
import java.util.*;
import org.jastadd.util.*;
import java.util.zip.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
/**
 * The abstract base class for all literals.
 * @ast node
 * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/grammar/Literals.ast:4
 * @production Literal : {@link PrimaryExpr} ::= <span class="component">&lt;LITERAL:String&gt;</span>;

 */
public abstract class Literal extends PrimaryExpr implements Cloneable {
  /**
   * @aspect BytecodeCONSTANT
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/BytecodeCONSTANT.jrag:59
   */
  public static Literal buildDoubleLiteral(double value) {
    return new DoubleLiteral(Double.toString(value));
  }
  /**
   * @aspect BytecodeCONSTANT
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/BytecodeCONSTANT.jrag:63
   */
  public static Literal buildFloatLiteral(float value) {
    return new FloatingPointLiteral(Double.toString(value));
  }
  /**
   * @aspect BytecodeCONSTANT
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/BytecodeCONSTANT.jrag:67
   */
  public static Literal buildIntegerLiteral(int value) {
    return new IntegerLiteral("0x"+Integer.toHexString(value));
  }
  /**
   * @aspect BytecodeCONSTANT
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/BytecodeCONSTANT.jrag:71
   */
  public static Literal buildLongLiteral(long value) {
    return new LongLiteral("0x"+Long.toHexString(value));
  }
  /**
   * @aspect BytecodeCONSTANT
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/BytecodeCONSTANT.jrag:75
   */
  public static Literal buildBooleanLiteral(boolean value) {
    return new BooleanLiteral(value ? "true" : "false");
  }
  /**
   * @aspect BytecodeCONSTANT
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/BytecodeCONSTANT.jrag:79
   */
  public static Literal buildStringLiteral(String value) {
    return new StringLiteral(value);
  }
  /**
   * @aspect Literals
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Literals.jrag:41
   */
  static long parseLong(String s) {
    long x = 0L;
    s = s.toLowerCase();
    boolean neg = false;
    if(s.startsWith("-")) {
      s = s.substring(1);
      neg = true;
    }
    if(s.startsWith("0x")) {
      s = s.substring(2);
      if(s.length() > 16) {
        for(int i = 0; i < s.length()-16; i++)
          if(s.charAt(i) != '0')
            throw new NumberFormatException("");
      }
      for (int i = 0; i < s.length(); i++) {
        int c = s.charAt(i);
        if (c >= 'a' && c <= 'f')
          c = c - 'a' + 10;
        else if(c >= '0' && c <= '9')
          c = c - '0';
        else
          throw new NumberFormatException("");
        x = x * 16 + c;
      }
    }
    else if(s.startsWith("0")) {
      s = s.substring(1);
      // Octals larger than 01777777777777777777777L are not valid
      if(s.length() > 21) {
        for(int i = 0; i < s.length() - 21; i++)
          if(i == s.length() - 21 - 1) {
            if(s.charAt(i) != '0' && s.charAt(i) != '1')
              throw new NumberFormatException("");
          }
          else {
            if(s.charAt(i) != '0')
              throw new NumberFormatException("");
          }
      }
      for (int i = 0; i < s.length(); i++) {
        int c = s.charAt(i);
        if(c >= '0' && c <= '7')
          c = c - '0';
        else
          throw new NumberFormatException("");
        x = x * 8 + c;
      }
    }
    else {
      long oldx = 0;
      for (int i = 0; i < s.length(); i++) {
        int c = s.charAt(i);
        if(c >= '0' && c <= '9')
          c = c - '0';
        else
          throw new NumberFormatException("");
        x = x * 10 + c;
        if(x < oldx) {
          boolean negMinValue = i == (s.length()-1) && neg && x == Long.MIN_VALUE;
          if(!negMinValue)
            throw new NumberFormatException("");
        }
        oldx = x;
      }
      if(x == Long.MIN_VALUE)
        return x;
      if(x < 0)
        throw new NumberFormatException("");
    }
    return neg ? -x : x;
  }
  /**
   * @aspect PrettyPrint
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/PrettyPrint.jadd:279
   */
  public void prettyPrint(StringBuffer sb) {
    sb.append(getLITERAL());
  }
  /**
   * @aspect PrettyPrint
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/PrettyPrint.jadd:306
   */
  protected static String escape(String str) {
    StringBuffer sb = new StringBuffer();
    for (int i=0; i < str.length(); i++) {
      switch(str.charAt(i)) {
        case '\b': sb.append("\\b"); break;
        case '\t': sb.append("\\t"); break;
        case '\n': sb.append("\\n"); break;
        case '\f': sb.append("\\f"); break;
        case '\r': sb.append("\\r"); break;
        case '\"': sb.append("\\\""); break;
        case '\'': sb.append("\\\'"); break;
        case '\\': sb.append("\\\\"); break;
        default:
          int value = (int)str.charAt(i);
          if (value < 0x20 || (value > 0x7e)) {
            sb.append(asEscape(value));
          } else {
            sb.append(str.charAt(i));
          }
      }
    }
    return sb.toString();
  }
  /**
   * @aspect PrettyPrint
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/PrettyPrint.jadd:330
   */
  protected static String asEscape(int value) {
    StringBuffer sb = new StringBuffer("\\u");
    String hex = Integer.toHexString(value);
    for (int i = 0; i < 4-hex.length(); i++) {
      sb.append("0");
    }
    sb.append(hex);
    return sb.toString();
  }
  /**
   * @declaredat ASTNode:1
   */
  public Literal() {
    super();
  }
  /**
   * Initializes the child array to the correct size.
   * Initializes List and Opt nta children.
   * @apilevel internal
   * @ast method
   * @declaredat ASTNode:10
   */
  public void init$Children() {
  }
  /**
   * @declaredat ASTNode:12
   */
  public Literal(String p0) {
    setLITERAL(p0);
  }
  /**
   * @declaredat ASTNode:15
   */
  public Literal(beaver.Symbol p0) {
    setLITERAL(p0);
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:21
   */
  protected int numChildren() {
    return 0;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:27
   */
  public boolean mayHaveRewrite() {
    return false;
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:33
   */
  public void flushCache() {
    super.flushCache();
    constant_computed = false;
    constant_value = null;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:41
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:47
   */
  public Literal clone() throws CloneNotSupportedException {
    Literal node = (Literal) super.clone();
    node.constant_computed = false;
    node.constant_value = null;
    node.in$Circle(false);
    node.is$Final(false);
    return node;
  }
  /**
   * Replaces the lexeme LITERAL.
   * @param value The new value for the lexeme LITERAL.
   * @apilevel high-level
   */
  public void setLITERAL(String value) {
    tokenString_LITERAL = value;
  }
  /**
   * @apilevel internal
   */
  protected String tokenString_LITERAL;
  /**
   */
  public int LITERALstart;
  /**
   */
  public int LITERALend;
  /**
   * JastAdd-internal setter for lexeme LITERAL using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme LITERAL
   * @apilevel internal
   */
  public void setLITERAL(beaver.Symbol symbol) {
    if(symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setLITERAL is only valid for String lexemes");
    tokenString_LITERAL = (String)symbol.value;
    LITERALstart = symbol.getStart();
    LITERALend = symbol.getEnd();
  }
  /**
   * Retrieves the value for the lexeme LITERAL.
   * @return The value for the lexeme LITERAL.
   * @apilevel high-level
   */
  public String getLITERAL() {
    return tokenString_LITERAL != null ? tokenString_LITERAL : "";
  }
  /**
   * @apilevel internal
   */
  protected boolean constant_computed = false;
  /**
   * @apilevel internal
   */
  protected Constant constant_value;
  /**
   * @attribute syn
   * @aspect ConstantExpression
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ConstantExpression.jrag:16
   */
  public Constant constant() {
    if(constant_computed) {
      return constant_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    constant_value = constant_compute();
    if (isFinal && num == state().boundariesCrossed) {
      constant_computed = true;
    } else {
    }

    return constant_value;
  }
  /**
   * @apilevel internal
   */
  private Constant constant_compute() {
      throw new UnsupportedOperationException("ConstantExpression operation constant" +
        " not supported for type " + getClass().getName());
    }
  /**
   * @attribute syn
   * @aspect ConstantExpression
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ConstantExpression.jrag:227
   */
  public boolean isConstant() {
    ASTNode$State state = state();
    try {  return true;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect ConstantExpression
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ConstantExpression.jrag:256
   */
  public boolean isTrue() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect ConstantExpression
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ConstantExpression.jrag:257
   */
  public boolean isFalse() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect PrettyPrint
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/PrettyPrint.jadd:821
   */
  public String dumpString() {
    ASTNode$State state = state();
    try {  return getClass().getName() + " [" + getLITERAL() + "]";  }
    finally {
    }
  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {    return super.rewriteTo();
  }}
