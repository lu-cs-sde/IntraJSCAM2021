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
 * Java double-precision floating point literal.
 * Can store any value representable as an
 * IEEE 754 64-bit double-precision floating point number.
 * @ast node
 * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/grammar/Literals.ast:53
 * @production DoubleLiteral : {@link Literal};

 */
public class DoubleLiteral extends Literal implements Cloneable {
  /**
   * @aspect PrettyPrint
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/PrettyPrint.jadd:301
   */
  public void prettyPrint(StringBuffer sb) {
    sb.append(getLITERAL());
    sb.append("D");
  }
  /**
   * @aspect TypeCheck
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeCheck.jrag:591
   */
  public void typeCheck() {
    if (!isZero() && constant().doubleValue() == 0.0f)
      error("It is an error for nonzero floating-point " + getLITERAL() + " to round to zero");
    if (constant().doubleValue() == Double.NEGATIVE_INFINITY || constant().doubleValue() == Double.POSITIVE_INFINITY)
      error("It is an error for floating-point " + getLITERAL() + " to round to an infinity");
  }
  /**
   * @declaredat ASTNode:1
   */
  public DoubleLiteral() {
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
  public DoubleLiteral(String p0) {
    setLITERAL(p0);
  }
  /**
   * @declaredat ASTNode:15
   */
  public DoubleLiteral(beaver.Symbol p0) {
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
    isZero_computed = false;
    constant_computed = false;
    constant_value = null;
    type_computed = false;
    type_value = null;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:44
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:50
   */
  public DoubleLiteral clone() throws CloneNotSupportedException {
    DoubleLiteral node = (DoubleLiteral) super.clone();
    node.isZero_computed = false;
    node.constant_computed = false;
    node.constant_value = null;
    node.type_computed = false;
    node.type_value = null;
    node.in$Circle(false);
    node.is$Final(false);
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:64
   */
  public DoubleLiteral copy() {
    try {
      DoubleLiteral node = (DoubleLiteral) clone();
      node.parent = null;
      if(children != null) {
        node.children = (ASTNode[]) children.clone();
      }
      return node;
    } catch (CloneNotSupportedException e) {
      throw new Error("Error: clone not supported for " + getClass().getName());
    }
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:82
   */
  public DoubleLiteral fullCopy() {
    DoubleLiteral tree = (DoubleLiteral) copy();
    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
        ASTNode child = (ASTNode) children[i];
        if(child != null) {
          child = child.fullCopy();
          tree.setChild(child, i);
        }
      }
    }
    return tree;
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
  protected boolean isZero_computed = false;
  /**
   * @apilevel internal
   */
  protected boolean isZero_value;
  /**
   * @attribute syn
   * @aspect Literals
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Literals.jrag:28
   */
  public boolean isZero() {
    if(isZero_computed) {
      return isZero_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    isZero_value = isZero_compute();
    if (isFinal && num == state().boundariesCrossed) {
      isZero_computed = true;
    } else {
    }

    return isZero_value;
  }
  /**
   * @apilevel internal
   */
  private boolean isZero_compute() {
      String s = getLITERAL();
      for(int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if(c == 'E'  || c == 'e')
          break;
        if(Character.isDigit(c) && c != '0') {
          return false;
        }
      }
      return true;
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
   * @aspect Literals
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Literals.jrag:169
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
      try {
        return Constant.create(Double.parseDouble(getLITERAL()));
      }
      catch (NumberFormatException e) {
        Constant c = Constant.create(0.0d);
        c.error = true;
        return c;
      }
    }
  /**
   * @apilevel internal
   */
  protected boolean type_computed = false;
  /**
   * @apilevel internal
   */
  protected TypeDecl type_value;
  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:302
   */
  public TypeDecl type() {
    if(type_computed) {
      return type_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    type_value = type_compute();
    if (isFinal && num == state().boundariesCrossed) {
      type_computed = true;
    } else {
    }

    return type_value;
  }
  /**
   * @apilevel internal
   */
  private TypeDecl type_compute() {  return typeDouble();  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {    return super.rewriteTo();
  }}
