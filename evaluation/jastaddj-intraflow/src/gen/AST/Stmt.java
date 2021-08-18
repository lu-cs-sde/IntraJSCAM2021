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
 * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/grammar/Java.ast:193
 * @production Stmt : {@link ASTNode};

 */
public abstract class Stmt extends ASTNode<ASTNode> implements Cloneable, CFGNode {
  /**
   * @return An Opt node containing the finally and monitor exit blocks
   * from the list of enclosing try-statements and synchronized blocks.
   * @aspect NTAFinally
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/NTAFinally.jrag:80
   */
  public Opt<Block> branchFinallyOpt() {
    FinallyHost enclosing = enclosingFinally(this);
    if (enclosing != null) {
      return new Opt<Block>(ntaFinallyBlock(enclosing, this, enclosing.getFinallyBlock()));
    } else {
      return new Opt<Block>();
    }
  }
  /**
   * @aspect UnreachableStatements
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/UnreachableStatements.jrag:14
   */
  void checkUnreachableStmt() {
    if(!reachable() && reportUnreachable())
      error("statement is unreachable");
  }
  /**
   * @aspect Java_CFG_1_4
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:30
   */
  public SmallSet<CFGNode> pred() { return collPred(); }
  /**
   * @aspect JavaLiveness14
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaLiveness1.4.jrag:16
   */
  public BitSet liveness_out() { return coll_liveness_out(); }
  /**
   * @declaredat ASTNode:1
   */
  public Stmt() {
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
    finallyIterator_computed = false;
    finallyIterator_value = null;
    isDAafter_Variable_values = null;
    isDUafter_Variable_values = null;
    canCompleteNormally_computed = false;
    exceptionalSucc_computed = false;
    exceptionalSucc_value = null;
    succ_computed = false;
    succ_value = null;
    includeInDeadAssignAnalysis_computed = false;
    isDeadAssign_computed = false;
    isDead_computed = false;
    liveness_in_visited = -1;
    liveness_in_computed = false;
    liveness_in_initialized = false;
    liveness_in_value = null;
    enclosingFinally_Stmt_values = null;
    entry_computed = false;
    entry_value = null;
    exit_computed = false;
    exit_value = null;
    uncheckedExceptionTarget_computed = false;
    uncheckedExceptionTarget_value = null;
    emptySmallSet_computed = false;
    emptySmallSet_value = null;
    following_computed = false;
    following_value = null;
    enclosingCompilationUnit_computed = false;
    enclosingCompilationUnit_value = null;
    emptyBitSet_computed = false;
    emptyBitSet_value = null;
    CFGNode_collPred_computed = false;
    CFGNode_collPred_value = null;
        CFGNode_collPred_contributors = null;
    CFGNode_def_computed = false;
    CFGNode_def_value = null;
        CFGNode_def_contributors = null;
    CFGNode_coll_liveness_out_visited = -1;
    CFGNode_coll_liveness_out_computed = false;
    CFGNode_coll_liveness_out_initialized = false;
    CFGNode_coll_liveness_out_value = null;
        CFGNode_coll_liveness_out_contributors = null;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:75
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
    CFGNode_collPred_computed = false;
    CFGNode_collPred_value = null;
        CFGNode_collPred_contributors = null;
    CFGNode_def_computed = false;
    CFGNode_def_value = null;
        CFGNode_def_contributors = null;
    CFGNode_coll_liveness_out_visited = -1;
    CFGNode_coll_liveness_out_computed = false;
    CFGNode_coll_liveness_out_initialized = false;
    CFGNode_coll_liveness_out_value = null;
        CFGNode_coll_liveness_out_contributors = null;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:92
   */
  public Stmt clone() throws CloneNotSupportedException {
    Stmt node = (Stmt) super.clone();
    node.finallyIterator_computed = false;
    node.finallyIterator_value = null;
    node.isDAafter_Variable_values = null;
    node.isDUafter_Variable_values = null;
    node.canCompleteNormally_computed = false;
    node.exceptionalSucc_computed = false;
    node.exceptionalSucc_value = null;
    node.succ_computed = false;
    node.succ_value = null;
    node.includeInDeadAssignAnalysis_computed = false;
    node.isDeadAssign_computed = false;
    node.isDead_computed = false;
    node.liveness_in_visited = -1;
    node.liveness_in_computed = false;
    node.liveness_in_initialized = false;
    node.liveness_in_value = null;
    node.enclosingFinally_Stmt_values = null;
    node.entry_computed = false;
    node.entry_value = null;
    node.exit_computed = false;
    node.exit_value = null;
    node.uncheckedExceptionTarget_computed = false;
    node.uncheckedExceptionTarget_value = null;
    node.emptySmallSet_computed = false;
    node.emptySmallSet_value = null;
    node.following_computed = false;
    node.following_value = null;
    node.enclosingCompilationUnit_computed = false;
    node.enclosingCompilationUnit_value = null;
    node.emptyBitSet_computed = false;
    node.emptyBitSet_value = null;
    node.in$Circle(false);
    node.is$Final(false);
    return node;
  }
  /**
   * @apilevel internal
   */
  protected boolean finallyIterator_computed = false;
  /**
   * @apilevel internal
   */
  protected Iterator<FinallyHost> finallyIterator_value;
  /**
   * Finds enclosing finally and monitor exit blocks.
   * @return an iterator for finally (and monitor exit) blocks that are
   * reached before the final target of this statement is reached
   * @attribute syn
   * @aspect BranchTarget
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/BranchTarget.jrag:59
   */
  public Iterator<FinallyHost> finallyIterator() {
    if(finallyIterator_computed) {
      return finallyIterator_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    finallyIterator_value = finallyIterator_compute();
    if (isFinal && num == state().boundariesCrossed) {
      finallyIterator_computed = true;
    } else {
    }

    return finallyIterator_value;
  }
  /**
   * @apilevel internal
   */
  private Iterator<FinallyHost> finallyIterator_compute() {
      return new LazyFinallyIterator(this);
    }
  /**
   * @return <code>true</code> if this statement can branch to
   * the target statement.
   * @attribute syn
   * @aspect BranchTarget
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/BranchTarget.jrag:166
   */
  public boolean canBranchTo(BranchTargetStmt target) {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect BranchTarget
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/BranchTarget.jrag:167
   */
  public boolean canBranchTo(LabeledStmt target) {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect BranchTarget
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/BranchTarget.jrag:168
   */
  public boolean canBranchTo(SwitchStmt target) {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  protected java.util.Map isDAafter_Variable_values;
  /**
   * @attribute syn
   * @aspect DA
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DefiniteAssignment.jrag:338
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
  protected java.util.Map isDUafter_Variable_values;
  /**
   * @attribute syn
   * @aspect DU
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DefiniteAssignment.jrag:802
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
      throw new Error("isDUafter in " + getClass().getName());
    }
  /**
   * @attribute syn
   * @aspect VariableScope
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupVariable.jrag:129
   */
  public boolean declaresVariable(String name) {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect NameCheck
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/NameCheck.jrag:428
   */
  public boolean continueLabel() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect PrettyPrint
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/PrettyPrint.jadd:777
   */
  public boolean addsIndentationLevel() {
    ASTNode$State state = state();
    try {  return true;  }
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
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/UnreachableStatements.jrag:29
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
  private boolean canCompleteNormally_compute() {  return true;  }
  /**
   * @attribute syn
   * @aspect CollectAssigns
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/CollectAssigns.jrag:18
   */
  public String liveness_printDefNames() {
    ASTNode$State state = state();
    try {
    		StringBuffer buf = new StringBuffer();
    		Iterator itr = def().iterator();
    		while (itr.hasNext()) {
    			Variable var = (Variable)itr.next();
    			buf.append(var.name() + ":");
    		}
    		return buf.toString();
    	}
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect DotGraphSpec
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/DotGraphSpec.jrag:38
   */
  public int getDotId() {
    ASTNode$State state = state();
    try {  return dotId;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect DotGraphSpec
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/DotGraphSpec.jrag:55
   */
  public String dotAttributes() {
    ASTNode$State state = state();
    try {  return "shape=record, label=\"<name> " + dumpString() + " | {<pred> pred | <succ> succ}\"";  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect Helpers
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/Helpers.jrag:23
   */
  public boolean isBreakStmt() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect Helpers
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/Helpers.jrag:27
   */
  public boolean isContinueStmt() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect Helpers
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/Helpers.jrag:31
   */
  public boolean isReturnStmt() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect Helpers
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/Helpers.jrag:35
   */
  public boolean isThrowStmt() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect Helpers
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/Helpers.jrag:39
   */
  public boolean isDefaultCase() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect Java_CFG_1_4
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:289
   */
  public CFGNode targetForContinue() {
    ASTNode$State state = state();
    try {  return this;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect Java_CFG_1_4
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:349
   */
  public SmallSet<CFGNode> targetAt(TryStmt s) {
    ASTNode$State state = state();
    try {  return s.following();  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect JavaLiveness14
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaLiveness1.4.jrag:29
   */
  public BitSet liveness_def() {
    ASTNode$State state = state();
    try {  return emptyBitSet().mutable();  }
    finally {
    }
  }
  /**
   * @apilevel internal
   */
  protected boolean exceptionalSucc_computed = false;
  /**
   * @apilevel internal
   */
  protected SmallSet<CFGNode> exceptionalSucc_value;
  /**
   * @attribute syn
   * @aspect Java_CFG_1_4
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:110
   */
  public SmallSet<CFGNode> exceptionalSucc() {
    if(exceptionalSucc_computed) {
      return exceptionalSucc_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    exceptionalSucc_value = exceptionalSucc_compute();
    if (isFinal && num == state().boundariesCrossed) {
      exceptionalSucc_computed = true;
    } else {
    }

    return exceptionalSucc_value;
  }
  /**
   * @apilevel internal
   */
  private SmallSet<CFGNode> exceptionalSucc_compute() {  return SmallSet.<CFGNode>empty();  }
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
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:113
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
  private SmallSet<CFGNode> succ_compute() {  return following().union(exceptionalSucc());  }
  /**
   * @apilevel internal
   */
  protected boolean includeInDeadAssignAnalysis_computed = false;
  /**
   * @apilevel internal
   */
  protected boolean includeInDeadAssignAnalysis_value;
  /**
   * @attribute syn
   * @aspect JavaDeadAssigns
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaDeadAssigns.jrag:24
   */
  public boolean includeInDeadAssignAnalysis() {
    if(includeInDeadAssignAnalysis_computed) {
      return includeInDeadAssignAnalysis_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    includeInDeadAssignAnalysis_value = includeInDeadAssignAnalysis_compute();
    if (isFinal && num == state().boundariesCrossed) {
      includeInDeadAssignAnalysis_computed = true;
    } else {
    }

    return includeInDeadAssignAnalysis_value;
  }
  /**
   * @apilevel internal
   */
  private boolean includeInDeadAssignAnalysis_compute() {  return false;  }
  /**
   * @apilevel internal
   */
  protected boolean isDeadAssign_computed = false;
  /**
   * @apilevel internal
   */
  protected boolean isDeadAssign_value;
  /**
   * @attribute syn
   * @aspect JavaDeadAssigns
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaDeadAssigns.jrag:38
   */
  public boolean isDeadAssign() {
    if(isDeadAssign_computed) {
      return isDeadAssign_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    isDeadAssign_value = isDeadAssign_compute();
    if (isFinal && num == state().boundariesCrossed) {
      isDeadAssign_computed = true;
    } else {
    }

    return isDeadAssign_value;
  }
  /**
   * @apilevel internal
   */
  private boolean isDeadAssign_compute() {  return false;  }
  /**
   * @apilevel internal
   */
  protected boolean isDead_computed = false;
  /**
   * @apilevel internal
   */
  protected boolean isDead_value;
  /**
   * @attribute syn
   * @aspect JavaLiveness14
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaLiveness1.4.jrag:9
   */
  public boolean isDead() {
    if(isDead_computed) {
      return isDead_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    isDead_value = isDead_compute();
    if (isFinal && num == state().boundariesCrossed) {
      isDead_computed = true;
    } else {
    }

    return isDead_value;
  }
  /**
   * @apilevel internal
   */
  private boolean isDead_compute() {  return !liveness_def().compl(liveness_out()).isEmpty();  }
  /**
   * @apilevel internal
   */
  protected int liveness_in_visited = -1;
  /**
   * @apilevel internal
   */
  protected boolean liveness_in_computed = false;
  /**
   * @apilevel internal
   */
  protected boolean liveness_in_initialized = false;
  /**
   * @apilevel internal
   */
  protected BitSet liveness_in_value;
  /**
   * @attribute syn
   * @aspect JavaLiveness14
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaLiveness1.4.jrag:13
   */
  public BitSet liveness_in() {
    if(liveness_in_computed) {
      return liveness_in_value;
    }
    ASTNode$State state = state();
    if (!liveness_in_initialized) {
      liveness_in_initialized = true;
      liveness_in_value = emptyBitSet();
    }
    if (!state.IN_CIRCLE) {
      state.IN_CIRCLE = true;
      int num = state.boundariesCrossed;
      boolean isFinal = this.is$Final();
      // TODO: fixme
      // state().CIRCLE_INDEX = 1;
      do {
        liveness_in_visited = state.CIRCLE_INDEX;
        state.CHANGE = false;
        BitSet new_liveness_in_value = liveness_in_compute();
        if ((new_liveness_in_value==null && liveness_in_value!=null) || (new_liveness_in_value!=null && !new_liveness_in_value.equals(liveness_in_value))) {
          state.CHANGE = true;
        }
        liveness_in_value = new_liveness_in_value;
        state.CIRCLE_INDEX++;
      } while (state.CHANGE);
      if (isFinal && num == state().boundariesCrossed) {
        liveness_in_computed = true;
      } else {
        state.RESET_CYCLE = true;
        liveness_in_compute();
        state.RESET_CYCLE = false;
        liveness_in_computed = false;
        liveness_in_initialized = false;
      }
      state.IN_CIRCLE = false;
      return liveness_in_value;
    }
    if(liveness_in_visited != state.CIRCLE_INDEX) {
      liveness_in_visited = state.CIRCLE_INDEX;
      if (state.RESET_CYCLE) {
        liveness_in_computed = false;
        liveness_in_initialized = false;
        liveness_in_visited = -1;
        return liveness_in_value;
      }
      BitSet new_liveness_in_value = liveness_in_compute();
      if ((new_liveness_in_value==null && liveness_in_value!=null) || (new_liveness_in_value!=null && !new_liveness_in_value.equals(liveness_in_value))) {
        state.CHANGE = true;
      }
      liveness_in_value = new_liveness_in_value;
      return liveness_in_value;
    }
    return liveness_in_value;
  }
  /**
   * @apilevel internal
   */
  private BitSet liveness_in_compute() {  return liveness_use().union(liveness_out().compl(liveness_def()));  }
  /**
   * @attribute syn
   * @aspect JavaLiveness14
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaLiveness1.4.jrag:39
   */
  public BitSet liveness_use() {
    ASTNode$State state = state();
    try {  return emptyBitSet().mutable();  }
    finally {
    }
  }
  /**
   * @return the target statement for a break or continue
   * @attribute inh
   * @aspect BranchTarget
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/BranchTarget.jrag:206
   */
  public Stmt branchTarget(Stmt branch) {
    ASTNode$State state = state();
    Stmt branchTarget_Stmt_value = getParent().Define_Stmt_branchTarget(this, null, branch);

    return branchTarget_Stmt_value;
  }
  /**
   * Find finally block of enclosing try-statement, or monitor exit
   * block of enclosing synchronized block.
   * @param branch the source branch
   * @return a finally block, or <code>null</code> if there is no
   * enclosing try-statement
   * @attribute inh
   * @aspect BranchTarget
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/BranchTarget.jrag:242
   */
  public FinallyHost enclosingFinally(Stmt branch) {
    Object _parameters = branch;
    if (enclosingFinally_Stmt_values == null) enclosingFinally_Stmt_values = new org.jastadd.util.RobustMap(new java.util.HashMap());
    if(enclosingFinally_Stmt_values.containsKey(_parameters)) {
      return (FinallyHost)enclosingFinally_Stmt_values.get(_parameters);
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    FinallyHost enclosingFinally_Stmt_value = getParent().Define_FinallyHost_enclosingFinally(this, null, branch);
    if (isFinal && num == state().boundariesCrossed) {
      enclosingFinally_Stmt_values.put(_parameters, enclosingFinally_Stmt_value);
    } else {
    }

    return enclosingFinally_Stmt_value;
  }
  protected java.util.Map enclosingFinally_Stmt_values;
  /**
   * @attribute inh
   * @aspect DA
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DefiniteAssignment.jrag:232
   */
  public boolean isDAbefore(Variable v) {
    ASTNode$State state = state();
    boolean isDAbefore_Variable_value = getParent().Define_boolean_isDAbefore(this, null, v);

    return isDAbefore_Variable_value;
  }
  /**
   * @attribute inh
   * @aspect DU
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DefiniteAssignment.jrag:704
   */
  public boolean isDUbefore(Variable v) {
    ASTNode$State state = state();
    boolean isDUbefore_Variable_value = getParent().Define_boolean_isDUbefore(this, null, v);

    return isDUbefore_Variable_value;
  }
  /**
   * @attribute inh
   * @aspect LookupMethod
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupMethod.jrag:44
   */
  public Collection lookupMethod(String name) {
    ASTNode$State state = state();
    Collection lookupMethod_String_value = getParent().Define_Collection_lookupMethod(this, null, name);

    return lookupMethod_String_value;
  }
  /**
   * @attribute inh
   * @aspect LookupFullyQualifiedTypes
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:99
   */
  public TypeDecl lookupType(String packageName, String typeName) {
    ASTNode$State state = state();
    TypeDecl lookupType_String_String_value = getParent().Define_TypeDecl_lookupType(this, null, packageName, typeName);

    return lookupType_String_String_value;
  }
  /**
   * @attribute inh
   * @aspect TypeScopePropagation
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:228
   */
  public SimpleSet lookupType(String name) {
    ASTNode$State state = state();
    SimpleSet lookupType_String_value = getParent().Define_SimpleSet_lookupType(this, null, name);

    return lookupType_String_value;
  }
  /**
   * @attribute inh
   * @aspect VariableScope
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupVariable.jrag:16
   */
  public SimpleSet lookupVariable(String name) {
    ASTNode$State state = state();
    SimpleSet lookupVariable_String_value = getParent().Define_SimpleSet_lookupVariable(this, null, name);

    return lookupVariable_String_value;
  }
  /**
   * @attribute inh
   * @aspect NestedTypes
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:519
   */
  public BodyDecl enclosingBodyDecl() {
    ASTNode$State state = state();
    BodyDecl enclosingBodyDecl_value = getParent().Define_BodyDecl_enclosingBodyDecl(this, null);

    return enclosingBodyDecl_value;
  }
  /**
   * @attribute inh
   * @aspect NestedTypes
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:592
   */
  public TypeDecl hostType() {
    ASTNode$State state = state();
    TypeDecl hostType_value = getParent().Define_TypeDecl_hostType(this, null);

    return hostType_value;
  }
  /**
   * @attribute inh
   * @aspect UnreachableStatements
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/UnreachableStatements.jrag:27
   */
  public boolean reachable() {
    ASTNode$State state = state();
    boolean reachable_value = getParent().Define_boolean_reachable(this, null);

    return reachable_value;
  }
  /**
   * @attribute inh
   * @aspect UnreachableStatements
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/UnreachableStatements.jrag:147
   */
  public boolean reportUnreachable() {
    ASTNode$State state = state();
    boolean reportUnreachable_value = getParent().Define_boolean_reportUnreachable(this, null);

    return reportUnreachable_value;
  }
  /**
   * @attribute inh
   * @aspect Java_CFG_1_4
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:119
   */
  public CFGEntry entry() {
    if(entry_computed) {
      return entry_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    entry_value = getParent().Define_CFGEntry_entry(this, null);
    if (isFinal && num == state().boundariesCrossed) {
      entry_computed = true;
    } else {
    }

    return entry_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean entry_computed = false;
  /**
   * @apilevel internal
   */
  protected CFGEntry entry_value;
  /**
   * @attribute inh
   * @aspect Java_CFG_1_4
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:122
   */
  public CFGExit exit() {
    if(exit_computed) {
      return exit_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    exit_value = getParent().Define_CFGExit_exit(this, null);
    if (isFinal && num == state().boundariesCrossed) {
      exit_computed = true;
    } else {
    }

    return exit_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean exit_computed = false;
  /**
   * @apilevel internal
   */
  protected CFGExit exit_value;
  /**
   * @attribute inh
   * @aspect Java_CFG_1_4
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:706
   */
  public SmallSet<CFGNode> uncheckedExceptionTarget() {
    if(uncheckedExceptionTarget_computed) {
      return uncheckedExceptionTarget_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    uncheckedExceptionTarget_value = getParent().Define_SmallSet_CFGNode__uncheckedExceptionTarget(this, null);
    if (isFinal && num == state().boundariesCrossed) {
      uncheckedExceptionTarget_computed = true;
    } else {
    }

    return uncheckedExceptionTarget_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean uncheckedExceptionTarget_computed = false;
  /**
   * @apilevel internal
   */
  protected SmallSet<CFGNode> uncheckedExceptionTarget_value;
  /**
   * @attribute inh
   * @aspect Java_CFG_1_4
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:13
   */
  public SmallSet emptySmallSet() {
    if(emptySmallSet_computed) {
      return emptySmallSet_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    emptySmallSet_value = getParent().Define_SmallSet_emptySmallSet(this, null);
    if (isFinal && num == state().boundariesCrossed) {
      emptySmallSet_computed = true;
    } else {
    }

    return emptySmallSet_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean emptySmallSet_computed = false;
  /**
   * @apilevel internal
   */
  protected SmallSet emptySmallSet_value;
  /**
   * @attribute inh
   * @aspect Java_CFG_1_4
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:35
   */
  public SmallSet<CFGNode> following() {
    if(following_computed) {
      return following_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    following_value = getParent().Define_SmallSet_CFGNode__following(this, null);
    if (isFinal && num == state().boundariesCrossed) {
      following_computed = true;
    } else {
    }

    return following_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean following_computed = false;
  /**
   * @apilevel internal
   */
  protected SmallSet<CFGNode> following_value;
  /**
   * @attribute inh
   * @aspect JavaDeadAssigns
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaDeadAssigns.jrag:5
   */
  public CompilationUnit enclosingCompilationUnit() {
    if(enclosingCompilationUnit_computed) {
      return enclosingCompilationUnit_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    enclosingCompilationUnit_value = getParent().Define_CompilationUnit_enclosingCompilationUnit(this, null);
    if (isFinal && num == state().boundariesCrossed) {
      enclosingCompilationUnit_computed = true;
    } else {
    }

    return enclosingCompilationUnit_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean enclosingCompilationUnit_computed = false;
  /**
   * @apilevel internal
   */
  protected CompilationUnit enclosingCompilationUnit_value;
  /**
   * @attribute inh
   * @aspect JavaLiveness14
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaLiveness1.4.jrag:5
   */
  public BitSet emptyBitSet() {
    if(emptyBitSet_computed) {
      return emptyBitSet_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    emptyBitSet_value = getParent().Define_BitSet_emptyBitSet(this, null);
    if (isFinal && num == state().boundariesCrossed) {
      emptyBitSet_computed = true;
    } else {
    }

    return emptyBitSet_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean emptyBitSet_computed = false;
  /**
   * @apilevel internal
   */
  protected BitSet emptyBitSet_value;
  /**
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/PrettyPrint.jadd:371
   * @apilevel internal
   */
  public String Define_String_typeDeclIndent(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return indent();
    }
  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {    return super.rewriteTo();
  }  /**
   * @attribute coll
   * @aspect Java_CFG_1_4
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:19
   */
  public SmallSet<CFGNode> collPred() {
    if(CFGNode_collPred_computed) {
      return CFGNode_collPred_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    CFGNode_collPred_value = collPred_compute();
    if (isFinal && num == state().boundariesCrossed) {
      CFGNode_collPred_computed = true;
    } else {
    }

    return CFGNode_collPred_value;
  }
  java.util.Set CFGNode_collPred_contributors;

  /**
   * @apilevel internal
   * @return the contributor set for collPred
   */
  public java.util.Set CFGNode_collPred_contributors() {
    if(CFGNode_collPred_contributors == null)
      CFGNode_collPred_contributors  = new ASTNode$State.IdentityHashSet(4);
    return CFGNode_collPred_contributors;
  }

  /**
   * @apilevel internal
   */
  private SmallSet<CFGNode> collPred_compute() {
    ASTNode node = this;
    while(node.getParent() != null && !(node instanceof TypeDecl)) {
      node = node.getParent();
    }
    TypeDecl root = (TypeDecl) node;
    root.collect_contributors_CFGNode_collPred();
    CFGNode_collPred_value = SmallSet.mutable();
    if(CFGNode_collPred_contributors != null)
    for (java.util.Iterator iter = CFGNode_collPred_contributors.iterator(); iter.hasNext(); ) {
      ASTNode contributor = (ASTNode) iter.next();
      contributor.contributeTo_CFGNode_CFGNode_collPred(CFGNode_collPred_value);
    }
    // TODO: disabled temporarily since collections may not be cached
    //CFGNode_collPred_contributors = null;
    return CFGNode_collPred_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean CFGNode_collPred_computed = false;
  /**
   * @apilevel internal
   */
  protected SmallSet<CFGNode> CFGNode_collPred_value;
  /**
   * @attribute coll
   * @aspect JavaDeadAssigns
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaDeadAssigns.jrag:9
   */
  public BitSet def() {
    if(CFGNode_def_computed) {
      return CFGNode_def_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    CFGNode_def_value = def_compute();
    if (isFinal && num == state().boundariesCrossed) {
      CFGNode_def_computed = true;
    } else {
    }

    return CFGNode_def_value;
  }
  java.util.Set CFGNode_def_contributors;

  /**
   * @apilevel internal
   * @return the contributor set for def
   */
  public java.util.Set CFGNode_def_contributors() {
    if(CFGNode_def_contributors == null)
      CFGNode_def_contributors  = new ASTNode$State.IdentityHashSet(4);
    return CFGNode_def_contributors;
  }

  /**
   * @apilevel internal
   */
  private BitSet def_compute() {
    ASTNode node = this;
    while(node.getParent() != null && !(node instanceof BodyDecl)) {
      node = node.getParent();
    }
    BodyDecl root = (BodyDecl) node;
    root.collect_contributors_CFGNode_def();
    CFGNode_def_value = emptyBitSet().mutable();
    if(CFGNode_def_contributors != null)
    for (java.util.Iterator iter = CFGNode_def_contributors.iterator(); iter.hasNext(); ) {
      ASTNode contributor = (ASTNode) iter.next();
      contributor.contributeTo_CFGNode_CFGNode_def(CFGNode_def_value);
    }
    // TODO: disabled temporarily since collections may not be cached
    //CFGNode_def_contributors = null;
    return CFGNode_def_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean CFGNode_def_computed = false;
  /**
   * @apilevel internal
   */
  protected BitSet CFGNode_def_value;
  /**
   * @apilevel internal
   */
  protected int CFGNode_coll_liveness_out_visited = -1;
  /**
   * @apilevel internal
   */
  protected boolean CFGNode_coll_liveness_out_computed = false;

  /**
   * @apilevel internal
   */
  protected boolean CFGNode_coll_liveness_out_initialized = false;

  /**
   * @apilevel internal
   */
  protected BitSet CFGNode_coll_liveness_out_value;


  /**
   * @attribute coll
   * @aspect JavaLiveness14
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaLiveness1.4.jrag:17
   */
  public BitSet coll_liveness_out() {
    if(CFGNode_coll_liveness_out_computed) {
      return CFGNode_coll_liveness_out_value;
    }
    ASTNode node = this;
    while(node.getParent() != null && !(node instanceof TypeDecl))
      node = node.getParent();
    TypeDecl root = (TypeDecl) node;

    if(root.collecting_contributors_CFGNode_coll_liveness_out)
      throw new RuntimeException("Circularity during phase 1");
    root.collect_contributors_CFGNode_coll_liveness_out();

    if (!CFGNode_coll_liveness_out_initialized) {
      CFGNode_coll_liveness_out_initialized = true;
      CFGNode_coll_liveness_out_value = emptyBitSet().mutable();
    }

    if (!state().IN_CIRCLE) {
      state().IN_CIRCLE = true;
      int num = state.boundariesCrossed;
      boolean isFinal = this.is$Final();
      state().CIRCLE_INDEX = 1;
      do {
        CFGNode_coll_liveness_out_visited = state().CIRCLE_INDEX;
        state().CHANGE = false;

        BitSet new_CFGNode_coll_liveness_out_value = emptyBitSet().mutable();
        combine_CFGNode_coll_liveness_out_contributions(new_CFGNode_coll_liveness_out_value);
        if ((new_CFGNode_coll_liveness_out_value==null && CFGNode_coll_liveness_out_value!=null) || (new_CFGNode_coll_liveness_out_value!=null && !new_CFGNode_coll_liveness_out_value.equals(CFGNode_coll_liveness_out_value))) {
          state().CHANGE = true;
        }
        CFGNode_coll_liveness_out_value = new_CFGNode_coll_liveness_out_value;
        state().CIRCLE_INDEX++;
      } while (state().CHANGE);

      if (isFinal && num == state().boundariesCrossed) {
        CFGNode_coll_liveness_out_computed = true;
      } else {
        state.RESET_CYCLE = true;
        CFGNode_coll_liveness_out_value = combine_CFGNode_coll_liveness_out_contributions(emptyBitSet().mutable());
        state.RESET_CYCLE = false;
        CFGNode_coll_liveness_out_computed = false;
        CFGNode_coll_liveness_out_initialized = false;
      }
      state().IN_CIRCLE = false;
      return CFGNode_coll_liveness_out_value;
    }
    if(CFGNode_coll_liveness_out_visited != state().CIRCLE_INDEX) {
      CFGNode_coll_liveness_out_visited = state().CIRCLE_INDEX;
      if (state.RESET_CYCLE) {
        CFGNode_coll_liveness_out_computed = false;
        CFGNode_coll_liveness_out_initialized = false;
        CFGNode_coll_liveness_out_visited = -1;
        return CFGNode_coll_liveness_out_value;
      }
      BitSet new_CFGNode_coll_liveness_out_value = emptyBitSet().mutable();
      combine_CFGNode_coll_liveness_out_contributions(new_CFGNode_coll_liveness_out_value);
      if ((new_CFGNode_coll_liveness_out_value==null && CFGNode_coll_liveness_out_value!=null) || (new_CFGNode_coll_liveness_out_value!=null && !new_CFGNode_coll_liveness_out_value.equals(CFGNode_coll_liveness_out_value))) {
        state().CHANGE = true;
      }
      CFGNode_coll_liveness_out_value = new_CFGNode_coll_liveness_out_value;
      return CFGNode_coll_liveness_out_value;
    }
    return CFGNode_coll_liveness_out_value;
  }
  java.util.Set CFGNode_coll_liveness_out_contributors;

  /**
   * @apilevel internal
   * @return the contributor set for coll_liveness_out
   */
  public java.util.Set CFGNode_coll_liveness_out_contributors() {
    if(CFGNode_coll_liveness_out_contributors == null)
      CFGNode_coll_liveness_out_contributors  = new ASTNode$State.IdentityHashSet(4);
    return CFGNode_coll_liveness_out_contributors;
  }

  private BitSet combine_CFGNode_coll_liveness_out_contributions(BitSet h) {
    if(CFGNode_coll_liveness_out_contributors != null)
    for(java.util.Iterator iter = CFGNode_coll_liveness_out_contributors.iterator(); iter.hasNext(); ) {
      ASTNode contributor = (ASTNode) iter.next();
      contributor.contributeTo_CFGNode_CFGNode_coll_liveness_out(h);
    }
    // TODO: disabled temporarily since collections may not be cached
    //CFGNode_coll_liveness_out_contributors = null;
    return h;
  }
  protected void collect_contributors_CFGNode_collPred() {
  /**
   * @attribute coll
   * @aspect Java_CFG_1_4
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:20
   */
      for(java.util.Iterator iter = (succ()).iterator(); iter.hasNext(); ) {
        CFGNode ref = (CFGNode) iter.next();
        if (ref != null) {
          ref.CFGNode_collPred_contributors().add(this);
        }
      }
    super.collect_contributors_CFGNode_collPred();
  }
  protected void collect_contributors_CFGNode_coll_liveness_out() {
  /**
   * @attribute coll
   * @aspect JavaLiveness14
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaLiveness1.4.jrag:18
   */
      for(java.util.Iterator iter = (pred()).iterator(); iter.hasNext(); ) {
        CFGNode ref = (CFGNode) iter.next();
        if (ref != null) {
          ref.CFGNode_coll_liveness_out_contributors().add(this);
        }
      }
    super.collect_contributors_CFGNode_coll_liveness_out();
  }
  protected void contributeTo_CFGNode_CFGNode_collPred(SmallSet<CFGNode> collection) {
    super.contributeTo_CFGNode_CFGNode_collPred(collection);
    collection.add(this);
  }

  protected void contributeTo_CFGNode_CFGNode_coll_liveness_out(BitSet collection) {
    super.contributeTo_CFGNode_CFGNode_coll_liveness_out(collection);
    collection.add(liveness_in());
  }

}
