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
 * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/grammar/EnhancedFor.ast:1
 * @production EnhancedForStmt : {@link BranchTargetStmt} ::= <span class="component">{@link VariableDeclaration}</span> <span class="component">{@link Expr}</span> <span class="component">{@link Stmt}</span>;

 */
public class EnhancedForStmt extends BranchTargetStmt implements Cloneable, VariableScope {
  /**
   * @aspect EnhancedFor
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/EnhancedFor.jrag:20
   */
  public void typeCheck() {
    if (!getExpr().type().isArrayDecl() && !getExpr().type().isIterable()) {
      error("type " + getExpr().type().name() +
            " of expression in foreach is neither array type nor java.lang.Iterable");
    }
    else if(getExpr().type().isArrayDecl() && !getExpr().type().componentType().assignConversionTo(getVariableDeclaration().type(), null))
      error("parameter of type " + getVariableDeclaration().type().typeName() + " can not be assigned an element of type " + getExpr().type().componentType().typeName());
    else if(getExpr().type().isIterable() && !getExpr().type().isUnknown()) {
      MethodDecl iterator = (MethodDecl)getExpr().type().memberMethods("iterator").iterator().next();
      MethodDecl next = (MethodDecl)iterator.type().memberMethods("next").iterator().next();
      TypeDecl componentType = next.type();
      if(!componentType.assignConversionTo(getVariableDeclaration().type(), null))
        error("parameter of type " + getVariableDeclaration().type().typeName() + " can not be assigned an element of type " + componentType.typeName());
    }
  }
  /**
   * @aspect EnhancedFor
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/EnhancedFor.jrag:63
   */
  public void prettyPrint(StringBuffer sb) {
    sb.append(indent());
    sb.append("for (");
    getVariableDeclaration().getModifiers().prettyPrint(sb);
    getVariableDeclaration().getTypeAccess().prettyPrint(sb);
    sb.append(" " + getVariableDeclaration().name());
    sb.append(" : ");
    getExpr().prettyPrint(sb);
    sb.append(") ");
    getStmt().prettyPrint(sb);
  }
  /**
   * @declaredat ASTNode:1
   */
  public EnhancedForStmt() {
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
    children = new ASTNode[3];
  }
  /**
   * @declaredat ASTNode:13
   */
  public EnhancedForStmt(VariableDeclaration p0, Expr p1, Stmt p2) {
    setChild(p0, 0);
    setChild(p1, 1);
    setChild(p2, 2);
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:21
   */
  protected int numChildren() {
    return 3;
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
    canCompleteNormally_computed = false;
    isDAafter_Variable_values = null;
    isDUafter_Variable_values = null;
    succ_computed = false;
    succ_value = null;
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
  public EnhancedForStmt clone() throws CloneNotSupportedException {
    EnhancedForStmt node = (EnhancedForStmt) super.clone();
    node.canCompleteNormally_computed = false;
    node.isDAafter_Variable_values = null;
    node.isDUafter_Variable_values = null;
    node.succ_computed = false;
    node.succ_value = null;
    node.in$Circle(false);
    node.is$Final(false);
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:64
   */
  public EnhancedForStmt copy() {
    try {
      EnhancedForStmt node = (EnhancedForStmt) clone();
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
  public EnhancedForStmt fullCopy() {
    EnhancedForStmt tree = (EnhancedForStmt) copy();
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
   * Replaces the VariableDeclaration child.
   * @param node The new node to replace the VariableDeclaration child.
   * @apilevel high-level
   */
  public void setVariableDeclaration(VariableDeclaration node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the VariableDeclaration child.
   * @return The current node used as the VariableDeclaration child.
   * @apilevel high-level
   */
  public VariableDeclaration getVariableDeclaration() {
    return (VariableDeclaration) getChild(0);
  }
  /**
   * Retrieves the VariableDeclaration child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the VariableDeclaration child.
   * @apilevel low-level
   */
  public VariableDeclaration getVariableDeclarationNoTransform() {
    return (VariableDeclaration) getChildNoTransform(0);
  }
  /**
   * Replaces the Expr child.
   * @param node The new node to replace the Expr child.
   * @apilevel high-level
   */
  public void setExpr(Expr node) {
    setChild(node, 1);
  }
  /**
   * Retrieves the Expr child.
   * @return The current node used as the Expr child.
   * @apilevel high-level
   */
  public Expr getExpr() {
    return (Expr) getChild(1);
  }
  /**
   * Retrieves the Expr child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Expr child.
   * @apilevel low-level
   */
  public Expr getExprNoTransform() {
    return (Expr) getChildNoTransform(1);
  }
  /**
   * Replaces the Stmt child.
   * @param node The new node to replace the Stmt child.
   * @apilevel high-level
   */
  public void setStmt(Stmt node) {
    setChild(node, 2);
  }
  /**
   * Retrieves the Stmt child.
   * @return The current node used as the Stmt child.
   * @apilevel high-level
   */
  public Stmt getStmt() {
    return (Stmt) getChild(2);
  }
  /**
   * Retrieves the Stmt child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Stmt child.
   * @apilevel low-level
   */
  public Stmt getStmtNoTransform() {
    return (Stmt) getChildNoTransform(2);
  }
  /**
   * @attribute syn
   * @aspect EnhancedFor
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/EnhancedFor.jrag:55
   */
  public SimpleSet localLookupVariable(String name) {
    ASTNode$State state = state();
    try {
        if(getVariableDeclaration().name().equals(name)) {
          return SimpleSet.emptySet.add(getVariableDeclaration());
        }
        return lookupVariable(name);
      }
    finally {
    }
  }
  /**
   * @apilevel internal
   */
  protected boolean canCompleteNormally_computed = false;
  /**
   * @apilevel internal
   */
  protected boolean canCompleteNormally_value;
  /**
   * @attribute syn
   * @aspect EnhancedFor
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/EnhancedFor.jrag:81
   */
  public boolean canCompleteNormally() {
    if(canCompleteNormally_computed) {
      return canCompleteNormally_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    canCompleteNormally_value = canCompleteNormally_compute();
    if (isFinal && num == state().boundariesCrossed) {
      canCompleteNormally_computed = true;
    } else {
    }

    return canCompleteNormally_value;
  }
  /**
   * @apilevel internal
   */
  private boolean canCompleteNormally_compute() {  return reachable();  }
  protected java.util.Map isDAafter_Variable_values;
  /**
   * @attribute syn
   * @aspect EnhancedFor
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/EnhancedFor.jrag:85
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
  private boolean isDAafter_compute(Variable v) {
      if(!getExpr().isDAafter(v))
        return false;
      /*
      for(Iterator iter = targetBreaks().iterator(); iter.hasNext(); ) {
        BreakStmt stmt = (BreakStmt)iter.next();
        if(!stmt.isDAafterReachedFinallyBlocks(v))
          return false;
      }
      */
      return true;
    }
  protected java.util.Map isDUafter_Variable_values;
  /**
   * @attribute syn
   * @aspect EnhancedFor
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/EnhancedFor.jrag:101
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
  private boolean isDUafter_compute(Variable v) {
      if(!getExpr().isDUafter(v))
        return false;
      for(Iterator iter = targetBreaks().iterator(); iter.hasNext(); ) {
        BreakStmt stmt = (BreakStmt)iter.next();
        if(!stmt.isDUafterReachedFinallyBlocks(v))
          return false;
      }
      return true;
    }
  /**
   * @attribute syn
   * @aspect NameCheck
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/NameCheck.jrag:428
   */
  public boolean continueLabel() {
    ASTNode$State state = state();
    try {  return true;  }
    finally {
    }
  }
  /**
   * @apilevel internal
   */
  protected boolean succ_computed = false;
  /**
   * @apilevel internal
   */
  protected SmallSet<CFGNode> succ_value;
  /**
   * @attribute syn
   * @aspect Java_CFG_1_5
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.5.jrag:21
   */
  public SmallSet<CFGNode> succ() {
    if(succ_computed) {
      return succ_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    succ_value = succ_compute();
    if (isFinal && num == state().boundariesCrossed) {
      succ_computed = true;
    } else {
    }

    return succ_value;
  }
  /**
   * @apilevel internal
   */
  private SmallSet<CFGNode> succ_compute() {  return SmallSet.<CFGNode>singleton(getExpr());  }
  /**
   * @attribute inh
   * @aspect EnhancedFor
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/EnhancedFor.jrag:43
   */
  public SimpleSet lookupVariable(String name) {
    ASTNode$State state = state();
    SimpleSet lookupVariable_String_value = getParent().Define_SimpleSet_lookupVariable(this, null, name);

    return lookupVariable_String_value;
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/EnhancedFor.jrag:16
   * @apilevel internal
   */
  public Stmt Define_Stmt_branchTarget(ASTNode caller, ASTNode child, Stmt branch) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return branch.canBranchTo(this) ? this : branchTarget(branch);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/EnhancedFor.jrag:46
   * @apilevel internal
   */
  public SimpleSet Define_SimpleSet_lookupVariable(ASTNode caller, ASTNode child, String name) {
    if (caller == getStmtNoTransform()) {
      return localLookupVariable(name);
    }
    else if (caller == getExprNoTransform()) {
      return localLookupVariable(name);
    }
    else if (caller == getVariableDeclarationNoTransform()) {
      return localLookupVariable(name);
    }
    else {
      return getParent().Define_SimpleSet_lookupVariable(this, caller, name);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/EnhancedFor.jrag:48
   * @apilevel internal
   */
  public NameType Define_NameType_nameType(ASTNode caller, ASTNode child) {
    if (caller == getVariableDeclarationNoTransform()) {
      return NameType.TYPE_NAME;
    }
    else {
      return getParent().Define_NameType_nameType(this, caller);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/EnhancedFor.jrag:53
   * @apilevel internal
   */
  public VariableScope Define_VariableScope_outerScope(ASTNode caller, ASTNode child) {
    if (caller == getStmtNoTransform()) {
      return this;
    }
    else if (caller == getExprNoTransform()) {
      return this;
    }
    else if (caller == getVariableDeclarationNoTransform()) {
      return this;
    }
    else {
      return getParent().Define_VariableScope_outerScope(this, caller);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/EnhancedFor.jrag:76
   * @apilevel internal
   */
  public boolean Define_boolean_isMethodParameter(ASTNode caller, ASTNode child) {
    if (caller == getVariableDeclarationNoTransform()) {
      return false;
    }
    else {
      return getParent().Define_boolean_isMethodParameter(this, caller);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/EnhancedFor.jrag:77
   * @apilevel internal
   */
  public boolean Define_boolean_isConstructorParameter(ASTNode caller, ASTNode child) {
    if (caller == getVariableDeclarationNoTransform()) {
      return false;
    }
    else {
      return getParent().Define_boolean_isConstructorParameter(this, caller);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/EnhancedFor.jrag:78
   * @apilevel internal
   */
  public boolean Define_boolean_isExceptionHandlerParameter(ASTNode caller, ASTNode child) {
    if (caller == getVariableDeclarationNoTransform()) {
      return false;
    }
    else {
      return getParent().Define_boolean_isExceptionHandlerParameter(this, caller);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/EnhancedFor.jrag:82
   * @apilevel internal
   */
  public boolean Define_boolean_reachable(ASTNode caller, ASTNode child) {
    if (caller == getStmtNoTransform()) {
      return reachable();
    }
    else {
      return getParent().Define_boolean_reachable(this, caller);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/EnhancedFor.jrag:99
   * @apilevel internal
   */
  public boolean Define_boolean_isDAbefore(ASTNode caller, ASTNode child, Variable v) {
    if (caller == getStmtNoTransform()) {
      return getExpr().isDAafter(v);
    }
    else if (caller == getExprNoTransform()) {
      return v == getVariableDeclaration() || isDAbefore(v);
    }
    else {
      return getParent().Define_boolean_isDAbefore(this, caller, v);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/EnhancedFor.jrag:113
   * @apilevel internal
   */
  public boolean Define_boolean_isDUbefore(ASTNode caller, ASTNode child, Variable v) {
    if (caller == getStmtNoTransform()) {
      return getExpr().isDUafter(v);
    }
    else if (caller == getExprNoTransform()) {
      return v != getVariableDeclaration() && isDUbefore(v);
    }
    else {
      return getParent().Define_boolean_isDUbefore(this, caller, v);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/EnhancedFor.jrag:115
   * @apilevel internal
   */
  public boolean Define_boolean_insideLoop(ASTNode caller, ASTNode child) {
    if (caller == getStmtNoTransform()) {
      return true;
    }
    else {
      return getParent().Define_boolean_insideLoop(this, caller);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.5.jrag:22
   * @apilevel internal
   */
  public SmallSet<CFGNode> Define_SmallSet_CFGNode__followingWhenTrue(ASTNode caller, ASTNode child) {
    if (caller == getExprNoTransform()) {
      return SmallSet.<CFGNode>singleton(getVariableDeclaration());
    }
    else {
      return getParent().Define_SmallSet_CFGNode__followingWhenTrue(this, caller);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.5.jrag:24
   * @apilevel internal
   */
  public SmallSet<CFGNode> Define_SmallSet_CFGNode__followingWhenFalse(ASTNode caller, ASTNode child) {
    if (caller == getExprNoTransform()) {
      return following();
    }
    else {
      return getParent().Define_SmallSet_CFGNode__followingWhenFalse(this, caller);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.5.jrag:29
   * @apilevel internal
   */
  public SmallSet<CFGNode> Define_SmallSet_CFGNode__following(ASTNode caller, ASTNode child) {
    if (caller == getStmtNoTransform()) {
      return SmallSet.<CFGNode>singleton(getExpr());
    }
    else if (caller == getVariableDeclarationNoTransform()) {
      return SmallSet.<CFGNode>singleton(getStmt());
    }
    else if (caller == getExprNoTransform()) {
      return getExpr().followingWhenTrue().union(getExpr().followingWhenFalse());
    }
    else {
      return getParent().Define_SmallSet_CFGNode__following(this, caller);
    }
  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {    return super.rewriteTo();
  }}
