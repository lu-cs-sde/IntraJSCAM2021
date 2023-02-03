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
 * Abstract superclass for catch clauses.
 * @ast node
 * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/grammar/CatchClause.ast:4
 * @production CatchClause : {@link ASTNode} ::= <span class="component">{@link Block}</span>;

 */
public abstract class CatchClause extends ASTNode<ASTNode> implements Cloneable, VariableScope {
  /**
   * @declaredat ASTNode:1
   */
  public CatchClause() {
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
    children = new ASTNode[1];
  }
  /**
   * @declaredat ASTNode:13
   */
  public CatchClause(Block p0) {
    setChild(p0, 0);
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:19
   */
  protected int numChildren() {
    return 1;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:25
   */
  public boolean mayHaveRewrite() {
    return false;
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:31
   */
  public void flushCache() {
    super.flushCache();
    parameterDeclaration_String_values = null;
    handlesAllUncheckedExceptions_computed = false;
    handlesUncheckedException_computed = false;
    typeThrowable_computed = false;
    typeThrowable_value = null;
    lookupVariable_String_values = null;
    reachableCatchClause_TypeDecl_values = null;
    typeRuntimeException_computed = false;
    typeRuntimeException_value = null;
    typeError_computed = false;
    typeError_value = null;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:48
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:54
   */
  public CatchClause clone() throws CloneNotSupportedException {
    CatchClause node = (CatchClause) super.clone();
    node.parameterDeclaration_String_values = null;
    node.handlesAllUncheckedExceptions_computed = false;
    node.handlesUncheckedException_computed = false;
    node.typeThrowable_computed = false;
    node.typeThrowable_value = null;
    node.lookupVariable_String_values = null;
    node.reachableCatchClause_TypeDecl_values = null;
    node.typeRuntimeException_computed = false;
    node.typeRuntimeException_value = null;
    node.typeError_computed = false;
    node.typeError_value = null;
    node.in$Circle(false);
    node.is$Final(false);
    return node;
  }
  /**
   * Replaces the Block child.
   * @param node The new node to replace the Block child.
   * @apilevel high-level
   */
  public void setBlock(Block node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the Block child.
   * @return The current node used as the Block child.
   * @apilevel high-level
   */
  public Block getBlock() {
    return (Block) getChild(0);
  }
  /**
   * Retrieves the Block child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Block child.
   * @apilevel low-level
   */
  public Block getBlockNoTransform() {
    return (Block) getChildNoTransform(0);
  }
  /**
   * @attribute syn
   * @aspect ExceptionHandling
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ExceptionHandling.jrag:213
   */
  public boolean handles(TypeDecl exceptionType) {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  protected java.util.Map parameterDeclaration_String_values;
  /**
   * @attribute syn
   * @aspect VariableScope
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupVariable.jrag:111
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
  private SimpleSet parameterDeclaration_compute(String name) {  return SimpleSet.emptySet;  }
  /**
   * @apilevel internal
   */
  protected boolean handlesAllUncheckedExceptions_computed = false;
  /**
   * @apilevel internal
   */
  protected boolean handlesAllUncheckedExceptions_value;
  /**
   * @attribute syn
   * @aspect Java_CFG_1_4
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:730
   */
  public boolean handlesAllUncheckedExceptions() {
    if(handlesAllUncheckedExceptions_computed) {
      return handlesAllUncheckedExceptions_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    handlesAllUncheckedExceptions_value = handlesAllUncheckedExceptions_compute();
    if (isFinal && num == state().boundariesCrossed) {
      handlesAllUncheckedExceptions_computed = true;
    } else {
    }

    return handlesAllUncheckedExceptions_value;
  }
  /**
   * @apilevel internal
   */
  private boolean handlesAllUncheckedExceptions_compute() {  return handles(typeRuntimeException()) && handles(typeError());  }
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
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:736
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
  private boolean handlesUncheckedException_compute() {  return handles(typeRuntimeException()) || handles(typeError());  }
  /**
   * @attribute inh
   * @aspect SpecialClasses
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:68
   */
  public TypeDecl typeThrowable() {
    if(typeThrowable_computed) {
      return typeThrowable_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    typeThrowable_value = getParent().Define_TypeDecl_typeThrowable(this, null);
    if (isFinal && num == state().boundariesCrossed) {
      typeThrowable_computed = true;
    } else {
    }

    return typeThrowable_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean typeThrowable_computed = false;
  /**
   * @apilevel internal
   */
  protected TypeDecl typeThrowable_value;
  /**
   * @attribute inh
   * @aspect VariableScope
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupVariable.jrag:20
   */
  public SimpleSet lookupVariable(String name) {
    Object _parameters = name;
    if (lookupVariable_String_values == null) lookupVariable_String_values = new org.jastadd.util.RobustMap(new java.util.HashMap());
    if(lookupVariable_String_values.containsKey(_parameters)) {
      return (SimpleSet)lookupVariable_String_values.get(_parameters);
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    SimpleSet lookupVariable_String_value = getParent().Define_SimpleSet_lookupVariable(this, null, name);
    if (isFinal && num == state().boundariesCrossed) {
      lookupVariable_String_values.put(_parameters, lookupVariable_String_value);
    } else {
    }

    return lookupVariable_String_value;
  }
  protected java.util.Map lookupVariable_String_values;
  /**
   * @return true if an exception of type exceptionType is catchable by the catch clause
   * @attribute inh
   * @aspect UnreachableStatements
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/UnreachableStatements.jrag:127
   */
  public boolean reachableCatchClause(TypeDecl exceptionType) {
    Object _parameters = exceptionType;
    if (reachableCatchClause_TypeDecl_values == null) reachableCatchClause_TypeDecl_values = new org.jastadd.util.RobustMap(new java.util.HashMap());
    if(reachableCatchClause_TypeDecl_values.containsKey(_parameters)) {
      return ((Boolean)reachableCatchClause_TypeDecl_values.get(_parameters)).booleanValue();
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    boolean reachableCatchClause_TypeDecl_value = getParent().Define_boolean_reachableCatchClause(this, null, exceptionType);
    if (isFinal && num == state().boundariesCrossed) {
      reachableCatchClause_TypeDecl_values.put(_parameters, Boolean.valueOf(reachableCatchClause_TypeDecl_value));
    } else {
    }

    return reachableCatchClause_TypeDecl_value;
  }
  protected java.util.Map reachableCatchClause_TypeDecl_values;
  /**
   * @attribute inh
   * @aspect Java_CFG_1_4
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:727
   */
  public TypeDecl typeRuntimeException() {
    if(typeRuntimeException_computed) {
      return typeRuntimeException_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    typeRuntimeException_value = getParent().Define_TypeDecl_typeRuntimeException(this, null);
    if (isFinal && num == state().boundariesCrossed) {
      typeRuntimeException_computed = true;
    } else {
    }

    return typeRuntimeException_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean typeRuntimeException_computed = false;
  /**
   * @apilevel internal
   */
  protected TypeDecl typeRuntimeException_value;
  /**
   * @attribute inh
   * @aspect Java_CFG_1_4
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:728
   */
  public TypeDecl typeError() {
    if(typeError_computed) {
      return typeError_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    typeError_value = getParent().Define_TypeDecl_typeError(this, null);
    if (isFinal && num == state().boundariesCrossed) {
      typeError_computed = true;
    } else {
    }

    return typeError_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean typeError_computed = false;
  /**
   * @apilevel internal
   */
  protected TypeDecl typeError_value;
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupVariable.jrag:78
   * @apilevel internal
   */
  public SimpleSet Define_SimpleSet_lookupVariable(ASTNode caller, ASTNode child, String name) {
    if (caller == getBlockNoTransform()){
    SimpleSet set = parameterDeclaration(name);
    if(!set.isEmpty()) return set;
    return lookupVariable(name);
  }
    else {
      return getParent().Define_SimpleSet_lookupVariable(this, caller, name);
    }
  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {    return super.rewriteTo();
  }}
