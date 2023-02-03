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
 * @ast node
 * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/grammar/Java.ast:201
 * @production Case : {@link Stmt};

 */
public abstract class Case extends Stmt implements Cloneable {
  /**
   * @declaredat ASTNode:1
   */
  public Case() {
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
   * @apilevel low-level
   * @declaredat ASTNode:15
   */
  protected int numChildren() {
    return 0;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:21
   */
  public boolean mayHaveRewrite() {
    return false;
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:27
   */
  public void flushCache() {
    super.flushCache();
    isDAbefore_Variable_values = null;
    isDAafter_Variable_values = null;
    isDUafter_Variable_values = null;
    bind_Case_values = null;
    enclosingSwitchStmt_computed = false;
    enclosingSwitchStmt_value = null;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:39
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:45
   */
  public Case clone() throws CloneNotSupportedException {
    Case node = (Case) super.clone();
    node.isDAbefore_Variable_values = null;
    node.isDAafter_Variable_values = null;
    node.isDUafter_Variable_values = null;
    node.bind_Case_values = null;
    node.enclosingSwitchStmt_computed = false;
    node.enclosingSwitchStmt_value = null;
    node.in$Circle(false);
    node.is$Final(false);
    return node;
  }
  /**
   * @attribute syn
   * @aspect NameCheck
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/NameCheck.jrag:460
   */
  public abstract boolean constValue(Case c);
  protected java.util.Map isDAbefore_Variable_values;
  /**
   * @attribute syn
   * @aspect DA
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DefiniteAssignment.jrag:583
   */
  public boolean isDAbefore(Variable v) {
    Object _parameters = v;
    if (isDAbefore_Variable_values == null) isDAbefore_Variable_values = new org.jastadd.util.RobustMap(new java.util.HashMap());
    if(isDAbefore_Variable_values.containsKey(_parameters)) {
      return ((Boolean)isDAbefore_Variable_values.get(_parameters)).booleanValue();
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    boolean isDAbefore_Variable_value = isDAbefore_compute(v);
    if (isFinal && num == state().boundariesCrossed) {
      isDAbefore_Variable_values.put(_parameters, Boolean.valueOf(isDAbefore_Variable_value));
    } else {
    }

    return isDAbefore_Variable_value;
  }
  /**
   * @apilevel internal
   */
  private boolean isDAbefore_compute(Variable v) {  return getParent().getParent() instanceof Block && ((Block)getParent().getParent()).isDAbefore(v)
      && super.isDAbefore(v);  }
  protected java.util.Map isDAafter_Variable_values;
  /**
   * @attribute syn
   * @aspect DA
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DefiniteAssignment.jrag:587
   */
  public boolean isDAafter(Variable v) {
    Object _parameters = v;
    if (isDAafter_Variable_values == null) isDAafter_Variable_values = new org.jastadd.util.RobustMap(new java.util.HashMap());
    if(isDAafter_Variable_values.containsKey(_parameters)) {
      return ((Boolean)isDAafter_Variable_values.get(_parameters)).booleanValue();
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    boolean isDAafter_Variable_value = isDAafter_compute(v);
    if (isFinal && num == state().boundariesCrossed) {
      isDAafter_Variable_values.put(_parameters, Boolean.valueOf(isDAafter_Variable_value));
    } else {
    }

    return isDAafter_Variable_value;
  }
  /**
   * @apilevel internal
   */
  private boolean isDAafter_compute(Variable v) {  return isDAbefore(v);  }
  /**
   * @attribute syn
   * @aspect DU
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DefiniteAssignment.jrag:1083
   */
  public boolean isDUbefore(Variable v) {
    ASTNode$State state = state();
    try {  return getParent().getParent() instanceof Block && ((Block)getParent().getParent()).isDUbefore(v)
        && super.isDUbefore(v);  }
    finally {
    }
  }
  protected java.util.Map isDUafter_Variable_values;
  /**
   * @attribute syn
   * @aspect DU
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DefiniteAssignment.jrag:1087
   */
  public boolean isDUafter(Variable v) {
    Object _parameters = v;
    if (isDUafter_Variable_values == null) isDUafter_Variable_values = new org.jastadd.util.RobustMap(new java.util.HashMap());
    if(isDUafter_Variable_values.containsKey(_parameters)) {
      return ((Boolean)isDUafter_Variable_values.get(_parameters)).booleanValue();
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    boolean isDUafter_Variable_value = isDUafter_compute(v);
    if (isFinal && num == state().boundariesCrossed) {
      isDUafter_Variable_values.put(_parameters, Boolean.valueOf(isDUafter_Variable_value));
    } else {
    }

    return isDUafter_Variable_value;
  }
  /**
   * @apilevel internal
   */
  private boolean isDUafter_compute(Variable v) {  return isDUbefore(v);  }
  /**
   * @attribute syn
   * @aspect UnreachableStatements
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/UnreachableStatements.jrag:83
   */
  public boolean reachable() {
    ASTNode$State state = state();
    try {  return getParent().getParent() instanceof Block && ((Block)getParent().getParent()).reachable();  }
    finally {
    }
  }
  /**
   * @attribute inh
   * @aspect NameCheck
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/NameCheck.jrag:446
   */
  public Case bind(Case c) {
    Object _parameters = c;
    if (bind_Case_values == null) bind_Case_values = new org.jastadd.util.RobustMap(new java.util.HashMap());
    if(bind_Case_values.containsKey(_parameters)) {
      return (Case)bind_Case_values.get(_parameters);
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    Case bind_Case_value = getParent().Define_Case_bind(this, null, c);
    if (isFinal && num == state().boundariesCrossed) {
      bind_Case_values.put(_parameters, bind_Case_value);
    } else {
    }

    return bind_Case_value;
  }
  protected java.util.Map bind_Case_values;
  /**
   * @attribute inh
   * @aspect TypeCheck
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeCheck.jrag:361
   */
  public TypeDecl switchType() {
    ASTNode$State state = state();
    TypeDecl switchType_value = getParent().Define_TypeDecl_switchType(this, null);

    return switchType_value;
  }
  /**
   * @attribute inh
   * @aspect Java_CFG_1_4
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:182
   */
  public SwitchStmt enclosingSwitchStmt() {
    if(enclosingSwitchStmt_computed) {
      return enclosingSwitchStmt_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    enclosingSwitchStmt_value = getParent().Define_SwitchStmt_enclosingSwitchStmt(this, null);
    if (isFinal && num == state().boundariesCrossed) {
      enclosingSwitchStmt_computed = true;
    } else {
    }

    return enclosingSwitchStmt_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean enclosingSwitchStmt_computed = false;
  /**
   * @apilevel internal
   */
  protected SwitchStmt enclosingSwitchStmt_value;
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {    return super.rewriteTo();
  }  protected void collect_contributors_SwitchStmt_childCases() {
  /**
   * @attribute coll
   * @aspect Java_CFG_1_4
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:180
   */
      {
        SwitchStmt ref = (SwitchStmt) (enclosingSwitchStmt());
        if (ref != null) {
          ref.SwitchStmt_childCases_contributors().add(this);
        }
      }
    super.collect_contributors_SwitchStmt_childCases();
  }
  protected void contributeTo_SwitchStmt_SwitchStmt_childCases(SmallSet<CFGNode> collection) {
    super.contributeTo_SwitchStmt_SwitchStmt_childCases(collection);
    collection.add(this);
  }

}
