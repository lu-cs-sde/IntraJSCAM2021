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
 * A catch clause which can catch a single exception type.
 * @ast node
 * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/grammar/CatchClause.ast:9
 * @production BasicCatch : {@link CatchClause} ::= <span class="component">Parameter:{@link ParameterDeclaration}</span> <span class="component">{@link Block}</span>;

 */
public class BasicCatch extends CatchClause implements Cloneable {
  /**
   * @aspect PrettyPrint
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/PrettyPrint.jadd:741
   */
  public void prettyPrint(StringBuffer sb) {
    sb.append("catch (");
    getParameter().prettyPrint(sb);
    sb.append(") ");
    getBlock().prettyPrint(sb);
  }
  /**
   * @aspect TypeCheck
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeCheck.jrag:371
   */
  public void typeCheck() {
    if(!getParameter().type().instanceOf(typeThrowable()))
      error("*** The catch variable must extend Throwable");
  }
  /**
   * @declaredat ASTNode:1
   */
  public BasicCatch() {
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
    children = new ASTNode[2];
  }
  /**
   * @declaredat ASTNode:13
   */
  public BasicCatch(ParameterDeclaration p0, Block p1) {
    setChild(p0, 0);
    setChild(p1, 1);
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:20
   */
  protected int numChildren() {
    return 2;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:26
   */
  public boolean mayHaveRewrite() {
    return false;
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:32
   */
  public void flushCache() {
    super.flushCache();
    parameterDeclaration_String_values = null;
    handlesUncheckedException_computed = false;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:40
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:46
   */
  public BasicCatch clone() throws CloneNotSupportedException {
    BasicCatch node = (BasicCatch) super.clone();
    node.parameterDeclaration_String_values = null;
    node.handlesUncheckedException_computed = false;
    node.in$Circle(false);
    node.is$Final(false);
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:57
   */
  public BasicCatch copy() {
    try {
      BasicCatch node = (BasicCatch) clone();
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
   * @declaredat ASTNode:75
   */
  public BasicCatch fullCopy() {
    BasicCatch tree = (BasicCatch) copy();
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
   * Replaces the Parameter child.
   * @param node The new node to replace the Parameter child.
   * @apilevel high-level
   */
  public void setParameter(ParameterDeclaration node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the Parameter child.
   * @return The current node used as the Parameter child.
   * @apilevel high-level
   */
  public ParameterDeclaration getParameter() {
    return (ParameterDeclaration) getChild(0);
  }
  /**
   * Retrieves the Parameter child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Parameter child.
   * @apilevel low-level
   */
  public ParameterDeclaration getParameterNoTransform() {
    return (ParameterDeclaration) getChildNoTransform(0);
  }
  /**
   * Replaces the Block child.
   * @param node The new node to replace the Block child.
   * @apilevel high-level
   */
  public void setBlock(Block node) {
    setChild(node, 1);
  }
  /**
   * Retrieves the Block child.
   * @return The current node used as the Block child.
   * @apilevel high-level
   */
  public Block getBlock() {
    return (Block) getChild(1);
  }
  /**
   * Retrieves the Block child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Block child.
   * @apilevel low-level
   */
  public Block getBlockNoTransform() {
    return (Block) getChildNoTransform(1);
  }
  /**
   * @attribute syn
   * @aspect ExceptionHandling
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ExceptionHandling.jrag:213
   */
  public boolean handles(TypeDecl exceptionType) {
    ASTNode$State state = state();
    try {  return !getParameter().type().isUnknown()
        && exceptionType.instanceOf(getParameter().type());  }
    finally {
    }
  }
  protected java.util.Map parameterDeclaration_String_values;
  /**
   * @attribute syn
   * @aspect VariableScope
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupVariable.jrag:113
   */
  public SimpleSet parameterDeclaration(String name) {
    Object _parameters = name;
    if (parameterDeclaration_String_values == null) parameterDeclaration_String_values = new org.jastadd.util.RobustMap(new java.util.HashMap());
    if(parameterDeclaration_String_values.containsKey(_parameters)) {
      return (SimpleSet)parameterDeclaration_String_values.get(_parameters);
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    SimpleSet parameterDeclaration_String_value = parameterDeclaration_compute(name);
    if (isFinal && num == state().boundariesCrossed) {
      parameterDeclaration_String_values.put(_parameters, parameterDeclaration_String_value);
    } else {
    }

    return parameterDeclaration_String_value;
  }
  /**
   * @apilevel internal
   */
  private SimpleSet parameterDeclaration_compute(String name) {  return getParameter().name().equals(name) ? getParameter() : SimpleSet.emptySet;  }
  /**
   * @apilevel internal
   */
  protected boolean handlesUncheckedException_computed = false;
  /**
   * @apilevel internal
   */
  protected boolean handlesUncheckedException_value;
  /**
   * @attribute syn
   * @aspect Java_CFG_1_4
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:738
   */
  public boolean handlesUncheckedException() {
    if(handlesUncheckedException_computed) {
      return handlesUncheckedException_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    handlesUncheckedException_value = handlesUncheckedException_compute();
    if (isFinal && num == state().boundariesCrossed) {
      handlesUncheckedException_computed = true;
    } else {
    }

    return handlesUncheckedException_value;
  }
  /**
   * @apilevel internal
   */
  private boolean handlesUncheckedException_compute() {  return super.handlesUncheckedException() 
  		|| getParameter().type().instanceOf(typeRuntimeException())
  		|| getParameter().type().instanceOf(typeError());  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupVariable.jrag:83
   * @apilevel internal
   */
  public SimpleSet Define_SimpleSet_lookupVariable(ASTNode caller, ASTNode child, String name) {
    if (caller == getParameterNoTransform()) {
      return parameterDeclaration(name);
    }
    else {
      return super.Define_SimpleSet_lookupVariable(caller, child, name);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/NameCheck.jrag:321
   * @apilevel internal
   */
  public VariableScope Define_VariableScope_outerScope(ASTNode caller, ASTNode child) {
    if (caller == getParameterNoTransform()) {
      return this;
    }
    else {
      return getParent().Define_VariableScope_outerScope(this, caller);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/SyntacticClassification.jrag:86
   * @apilevel internal
   */
  public NameType Define_NameType_nameType(ASTNode caller, ASTNode child) {
    if (caller == getParameterNoTransform()) {
      return NameType.TYPE_NAME;
    }
    else {
      return getParent().Define_NameType_nameType(this, caller);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/UnreachableStatements.jrag:122
   * @apilevel internal
   */
  public boolean Define_boolean_reachable(ASTNode caller, ASTNode child) {
    if (caller == getBlockNoTransform()) {
      return reachableCatchClause(getParameter().type());
    }
    else {
      return getParent().Define_boolean_reachable(this, caller);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/VariableDeclaration.jrag:64
   * @apilevel internal
   */
  public boolean Define_boolean_isMethodParameter(ASTNode caller, ASTNode child) {
    if (caller == getParameterNoTransform()) {
      return false;
    }
    else {
      return getParent().Define_boolean_isMethodParameter(this, caller);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/VariableDeclaration.jrag:65
   * @apilevel internal
   */
  public boolean Define_boolean_isConstructorParameter(ASTNode caller, ASTNode child) {
    if (caller == getParameterNoTransform()) {
      return false;
    }
    else {
      return getParent().Define_boolean_isConstructorParameter(this, caller);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/VariableDeclaration.jrag:66
   * @apilevel internal
   */
  public boolean Define_boolean_isExceptionHandlerParameter(ASTNode caller, ASTNode child) {
    if (caller == getParameterNoTransform()) {
      return true;
    }
    else {
      return getParent().Define_boolean_isExceptionHandlerParameter(this, caller);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/VariableArityParameters.jrag:23
   * @apilevel internal
   */
  public boolean Define_boolean_variableArityValid(ASTNode caller, ASTNode child) {
    if (caller == getParameterNoTransform()) {
      return false;
    }
    else {
      return getParent().Define_boolean_variableArityValid(this, caller);
    }
  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {    return super.rewriteTo();
  }}
