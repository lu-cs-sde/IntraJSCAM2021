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
 * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/grammar/Java.ast:200
 * @production SwitchStmt : {@link BranchTargetStmt} ::= <span class="component">{@link Expr}</span> <span class="component">{@link Block}</span>;

 */
public class SwitchStmt extends BranchTargetStmt implements Cloneable {
  /**
   * @aspect PrettyPrint
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/PrettyPrint.jadd:573
   */
  public void prettyPrint(StringBuffer sb) {
    sb.append(indent());
    sb.append("switch (");
    getExpr().prettyPrint(sb);
    sb.append(")");
    getBlock().prettyPrint(sb);
  }
  /**
   * @declaredat ASTNode:1
   */
  public SwitchStmt() {
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
  public SwitchStmt(Expr p0, Block p1) {
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
    isDAafter_Variable_values = null;
    isDUafter_Variable_values = null;
    canCompleteNormally_computed = false;
    succ_computed = false;
    succ_value = null;
    hasDefault_computed = false;
    typeInt_computed = false;
    typeInt_value = null;
    typeLong_computed = false;
    typeLong_value = null;
    SwitchStmt_childCases_computed = false;
    SwitchStmt_childCases_value = null;
        SwitchStmt_childCases_contributors = null;
        collect_contributors_SwitchStmt_childCases = false;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:52
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
    SwitchStmt_childCases_computed = false;
    SwitchStmt_childCases_value = null;
        SwitchStmt_childCases_contributors = null;
        collect_contributors_SwitchStmt_childCases = false;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:62
   */
  public SwitchStmt clone() throws CloneNotSupportedException {
    SwitchStmt node = (SwitchStmt) super.clone();
    node.isDAafter_Variable_values = null;
    node.isDUafter_Variable_values = null;
    node.canCompleteNormally_computed = false;
    node.succ_computed = false;
    node.succ_value = null;
    node.hasDefault_computed = false;
    node.typeInt_computed = false;
    node.typeInt_value = null;
    node.typeLong_computed = false;
    node.typeLong_value = null;
    node.in$Circle(false);
    node.is$Final(false);
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:81
   */
  public SwitchStmt copy() {
    try {
      SwitchStmt node = (SwitchStmt) clone();
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
   * @declaredat ASTNode:99
   */
  public SwitchStmt fullCopy() {
    SwitchStmt tree = (SwitchStmt) copy();
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
   * Replaces the Expr child.
   * @param node The new node to replace the Expr child.
   * @apilevel high-level
   */
  public void setExpr(Expr node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the Expr child.
   * @return The current node used as the Expr child.
   * @apilevel high-level
   */
  public Expr getExpr() {
    return (Expr) getChild(0);
  }
  /**
   * Retrieves the Expr child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Expr child.
   * @apilevel low-level
   */
  public Expr getExprNoTransform() {
    return (Expr) getChildNoTransform(0);
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
   * @aspect Enums
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Enums.jrag:494
   */
    public void typeCheck() {
     TypeDecl type = getExpr().type();
    if((!type.isIntegralType() || type.isLong()) && !type.isEnumDecl())
      error("Switch expression must be of char, byte, short, int, or enum type");
  }
  /**
   * @aspect <NoAspect>
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:164
   */
    private boolean collect_contributors_SwitchStmt_childCases = false;
  protected void collect_contributors_SwitchStmt_childCases() {
    if(collect_contributors_SwitchStmt_childCases) return;
    super.collect_contributors_SwitchStmt_childCases();
    collect_contributors_SwitchStmt_childCases = true;
  }

  /**
   * @return <code>true</code> if this statement is a potential
   * branch target of the given branch statement.
   * @attribute syn
   * @aspect BranchTarget
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/BranchTarget.jrag:196
   */
  public boolean potentialTargetOf(Stmt branch) {
    ASTNode$State state = state();
    try {  return branch.canBranchTo(this);  }
    finally {
    }
  }
  protected java.util.Map isDAafter_Variable_values;
  /**
   * @attribute syn
   * @aspect DA
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DefiniteAssignment.jrag:544
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
      if(!(!noDefaultLabel() || getExpr().isDAafter(v))) {
        return false;
      }
      if(!(!switchLabelEndsBlock() || getExpr().isDAafter(v))) {
        return false;
      }
      if(!assignedAfterLastStmt(v)) {
        return false;
      }
      for(Iterator iter = targetBreaks().iterator(); iter.hasNext(); ) {
        BreakStmt stmt = (BreakStmt)iter.next();
        if(!stmt.isDAafterReachedFinallyBlocks(v))
          return false;
      }
      return true;
    }
  /**
   * @attribute syn
   * @aspect DA
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DefiniteAssignment.jrag:562
   */
  public boolean assignedAfterLastStmt(Variable v) {
    ASTNode$State state = state();
    try {  return getBlock().isDAafter(v);  }
    finally {
    }
  }
  protected java.util.Map isDUafter_Variable_values;
  /**
   * @attribute syn
   * @aspect DU
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DefiniteAssignment.jrag:1058
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
      if(!(!noDefaultLabel() || getExpr().isDUafter(v)))
        return false;
      if(!(!switchLabelEndsBlock() || getExpr().isDUafter(v)))
        return false;
      if(!unassignedAfterLastStmt(v))
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
   * @aspect DU
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DefiniteAssignment.jrag:1073
   */
  public boolean unassignedAfterLastStmt(Variable v) {
    ASTNode$State state = state();
    try {  return getBlock().isDUafter(v);  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect DU
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DefiniteAssignment.jrag:1076
   */
  public boolean switchLabelEndsBlock() {
    ASTNode$State state = state();
    try {  return getBlock().getNumStmt() > 0 && getBlock().getStmt(getBlock().getNumStmt()-1) instanceof ConstCase;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect UnreachableStatements
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/UnreachableStatements.jrag:60
   */
  public boolean lastStmtCanCompleteNormally() {
    ASTNode$State state = state();
    try {  return getBlock().canCompleteNormally();  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect UnreachableStatements
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/UnreachableStatements.jrag:62
   */
  public boolean noStmts() {
    ASTNode$State state = state();
    try {
        for(int i = 0; i < getBlock().getNumStmt(); i++)
          if(!(getBlock().getStmt(i) instanceof Case))
            return false;
        return true;
      }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect UnreachableStatements
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/UnreachableStatements.jrag:69
   */
  public boolean noStmtsAfterLastLabel() {
    ASTNode$State state = state();
    try {  return getBlock().getNumStmt() > 0 && getBlock().getStmt(getBlock().getNumStmt()-1) instanceof Case;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect UnreachableStatements
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/UnreachableStatements.jrag:72
   */
  public boolean noDefaultLabel() {
    ASTNode$State state = state();
    try {
        for(int i = 0; i < getBlock().getNumStmt(); i++)
          if(getBlock().getStmt(i) instanceof DefaultCase)
            return false;
        return true;
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
   * @aspect UnreachableStatements
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/UnreachableStatements.jrag:79
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
  private boolean canCompleteNormally_compute() {  return lastStmtCanCompleteNormally() || noStmts() || noStmtsAfterLastLabel() || noDefaultLabel() || reachableBreak();  }
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
   * @aspect Java_CFG_1_4
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:160
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
   * @apilevel internal
   */
  protected boolean hasDefault_computed = false;
  /**
   * @apilevel internal
   */
  protected boolean hasDefault_value;
  /**
   * @attribute syn
   * @aspect Java_CFG_1_4
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:167
   */
  public boolean hasDefault() {
    if(hasDefault_computed) {
      return hasDefault_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    hasDefault_value = hasDefault_compute();
    if (isFinal && num == state().boundariesCrossed) {
      hasDefault_computed = true;
    } else {
    }

    return hasDefault_value;
  }
  /**
   * @apilevel internal
   */
  private boolean hasDefault_compute() {
  		for (CFGNode node : childCases()) {
  			if (node instanceof Case && ((Case)node).isDefaultCase())
  				return true;
  		}
  		return false;
  	}
  /**
   * @attribute inh
   * @aspect SpecialClasses
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:61
   */
  public TypeDecl typeInt() {
    if(typeInt_computed) {
      return typeInt_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    typeInt_value = getParent().Define_TypeDecl_typeInt(this, null);
    if (isFinal && num == state().boundariesCrossed) {
      typeInt_computed = true;
    } else {
    }

    return typeInt_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean typeInt_computed = false;
  /**
   * @apilevel internal
   */
  protected TypeDecl typeInt_value;
  /**
   * @attribute inh
   * @aspect SpecialClasses
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:63
   */
  public TypeDecl typeLong() {
    if(typeLong_computed) {
      return typeLong_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    typeLong_value = getParent().Define_TypeDecl_typeLong(this, null);
    if (isFinal && num == state().boundariesCrossed) {
      typeLong_computed = true;
    } else {
    }

    return typeLong_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean typeLong_computed = false;
  /**
   * @apilevel internal
   */
  protected TypeDecl typeLong_value;
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/BranchTarget.jrag:225
   * @apilevel internal
   */
  public Stmt Define_Stmt_branchTarget(ASTNode caller, ASTNode child, Stmt branch) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return branch.canBranchTo(this) ? this : branchTarget(branch);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DefiniteAssignment.jrag:581
   * @apilevel internal
   */
  public boolean Define_boolean_isDAbefore(ASTNode caller, ASTNode child, Variable v) {
    if (caller == getBlockNoTransform()) {
      return getExpr().isDAafter(v);
    }
    else if (caller == getExprNoTransform()){
    if(((ASTNode)v).isDescendantTo(this))
      return false;
    boolean result = isDAbefore(v);
    return result;
  }
    else {
      return getParent().Define_boolean_isDAbefore(this, caller, v);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DefiniteAssignment.jrag:1081
   * @apilevel internal
   */
  public boolean Define_boolean_isDUbefore(ASTNode caller, ASTNode child, Variable v) {
    if (caller == getBlockNoTransform()) {
      return getExpr().isDUafter(v);
    }
    else if (caller == getExprNoTransform()) {
      return isDUbefore(v);
    }
    else {
      return getParent().Define_boolean_isDUbefore(this, caller, v);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/NameCheck.jrag:404
   * @apilevel internal
   */
  public boolean Define_boolean_insideSwitch(ASTNode caller, ASTNode child) {
    if (caller == getBlockNoTransform()) {
      return true;
    }
    else {
      return getParent().Define_boolean_insideSwitch(this, caller);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/NameCheck.jrag:447
   * @apilevel internal
   */
  public Case Define_Case_bind(ASTNode caller, ASTNode child, Case c) {
    if (caller == getBlockNoTransform()){
    Block b = getBlock();
    for(int i = 0; i < b.getNumStmt(); i++)
      if(b.getStmt(i) instanceof Case && ((Case)b.getStmt(i)).constValue(c))
        return (Case)b.getStmt(i);
    return null;
  }
    else {
      return getParent().Define_Case_bind(this, caller, c);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeCheck.jrag:362
   * @apilevel internal
   */
  public TypeDecl Define_TypeDecl_switchType(ASTNode caller, ASTNode child) {
    if (caller == getBlockNoTransform()) {
      return getExpr().type();
    }
    else {
      return getParent().Define_TypeDecl_switchType(this, caller);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/UnreachableStatements.jrag:82
   * @apilevel internal
   */
  public boolean Define_boolean_reachable(ASTNode caller, ASTNode child) {
    if (caller == getBlockNoTransform()) {
      return reachable();
    }
    else {
      return getParent().Define_boolean_reachable(this, caller);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/UnreachableStatements.jrag:158
   * @apilevel internal
   */
  public boolean Define_boolean_reportUnreachable(ASTNode caller, ASTNode child) {
    if (caller == getBlockNoTransform()) {
      return reachable();
    }
    else {
      return getParent().Define_boolean_reportUnreachable(this, caller);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:161
   * @apilevel internal
   */
  public SmallSet<CFGNode> Define_SmallSet_CFGNode__following(ASTNode caller, ASTNode child) {
    if (caller == getExprNoTransform()) {
      return hasDefault() ? childCases() : childCases().union(following());
    }
    else {
      return getParent().Define_SmallSet_CFGNode__following(this, caller);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:184
   * @apilevel internal
   */
  public SwitchStmt Define_SwitchStmt_enclosingSwitchStmt(ASTNode caller, ASTNode child) {
    if (caller == getBlockNoTransform()) {
      return this;
    }
    else {
      return getParent().Define_SwitchStmt_enclosingSwitchStmt(this, caller);
    }
  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {    return super.rewriteTo();
  }  /**
   * @attribute coll
   * @aspect Java_CFG_1_4
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:164
   */
  public SmallSet<CFGNode> childCases() {
    if(SwitchStmt_childCases_computed) {
      return SwitchStmt_childCases_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    SwitchStmt_childCases_value = childCases_compute();
    if (isFinal && num == state().boundariesCrossed) {
      SwitchStmt_childCases_computed = true;
    } else {
    }

    return SwitchStmt_childCases_value;
  }
  java.util.Set SwitchStmt_childCases_contributors;

  /**
   * @apilevel internal
   * @return the contributor set for childCases
   */
  public java.util.Set SwitchStmt_childCases_contributors() {
    if(SwitchStmt_childCases_contributors == null)
      SwitchStmt_childCases_contributors  = new ASTNode$State.IdentityHashSet(4);
    return SwitchStmt_childCases_contributors;
  }

  /**
   * @apilevel internal
   */
  private SmallSet<CFGNode> childCases_compute() {
    ASTNode node = this;
    while(node.getParent() != null && !(node instanceof SwitchStmt)) {
      node = node.getParent();
    }
    SwitchStmt root = (SwitchStmt) node;
    root.collect_contributors_SwitchStmt_childCases();
    SwitchStmt_childCases_value = SmallSet.mutable();
    if(SwitchStmt_childCases_contributors != null)
    for (java.util.Iterator iter = SwitchStmt_childCases_contributors.iterator(); iter.hasNext(); ) {
      ASTNode contributor = (ASTNode) iter.next();
      contributor.contributeTo_SwitchStmt_SwitchStmt_childCases(SwitchStmt_childCases_value);
    }
    // TODO: disabled temporarily since collections may not be cached
    //SwitchStmt_childCases_contributors = null;
    return SwitchStmt_childCases_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean SwitchStmt_childCases_computed = false;
  /**
   * @apilevel internal
   */
  protected SmallSet<CFGNode> SwitchStmt_childCases_value;
}
