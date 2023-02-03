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
 * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/grammar/Java.ast:194
 * @production BranchTargetStmt : {@link Stmt};

 */
public abstract class BranchTargetStmt extends Stmt implements Cloneable {
  /**
   * @aspect BranchTarget
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/BranchTarget.jrag:87
   */
  public void collectBranches(Collection<Stmt> c) {
    c.addAll(escapedBranches());
  }
  /**
   * @declaredat ASTNode:1
   */
  public BranchTargetStmt() {
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
    targetBranches_computed = false;
    targetBranches_value = null;
    escapedBranches_computed = false;
    escapedBranches_value = null;
    branches_computed = false;
    branches_value = null;
    targetContinues_computed = false;
    targetContinues_value = null;
    targetBreaks_computed = false;
    targetBreaks_value = null;
    reachableBreak_computed = false;
    reachableContinue_computed = false;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:45
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:51
   */
  public BranchTargetStmt clone() throws CloneNotSupportedException {
    BranchTargetStmt node = (BranchTargetStmt) super.clone();
    node.targetBranches_computed = false;
    node.targetBranches_value = null;
    node.escapedBranches_computed = false;
    node.escapedBranches_value = null;
    node.branches_computed = false;
    node.branches_value = null;
    node.targetContinues_computed = false;
    node.targetContinues_value = null;
    node.targetBreaks_computed = false;
    node.targetBreaks_value = null;
    node.reachableBreak_computed = false;
    node.reachableContinue_computed = false;
    node.in$Circle(false);
    node.is$Final(false);
    return node;
  }
  /**
   * @apilevel internal
   */
  protected boolean targetBranches_computed = false;
  /**
   * @apilevel internal
   */
  protected Collection<Stmt> targetBranches_value;
  /**
   * The branches for which this node is the target.
   * @attribute syn
   * @aspect BranchTarget
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/BranchTarget.jrag:101
   */
  public Collection<Stmt> targetBranches() {
    if(targetBranches_computed) {
      return targetBranches_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    targetBranches_value = targetBranches_compute();
    if (isFinal && num == state().boundariesCrossed) {
      targetBranches_computed = true;
    } else {
    }

    return targetBranches_value;
  }
  /**
   * @apilevel internal
   */
  private Collection<Stmt> targetBranches_compute() {
      Collection<Stmt> set = new HashSet<Stmt>();
      for (Stmt branch : branches()) {
        if (potentialTargetOf(branch)) {
          set.add(branch);
        }
      }
      return set;
    }
  /**
   * @apilevel internal
   */
  protected boolean escapedBranches_computed = false;
  /**
   * @apilevel internal
   */
  protected Collection<Stmt> escapedBranches_value;
  /**
   * The branches that escape this node.
   * @attribute syn
   * @aspect BranchTarget
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/BranchTarget.jrag:114
   */
  public Collection<Stmt> escapedBranches() {
    if(escapedBranches_computed) {
      return escapedBranches_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    escapedBranches_value = escapedBranches_compute();
    if (isFinal && num == state().boundariesCrossed) {
      escapedBranches_computed = true;
    } else {
    }

    return escapedBranches_value;
  }
  /**
   * @apilevel internal
   */
  private Collection<Stmt> escapedBranches_compute() {
      Collection<Stmt> set = new HashSet<Stmt>();
      for (Stmt branch : branches()) {
        if (!potentialTargetOf(branch)) {
          set.add(branch);
        } else if(branch instanceof ReturnStmt) {
          set.add(branch);
        }
      }
      return set;
    }
  /**
   * @apilevel internal
   */
  protected boolean branches_computed = false;
  /**
   * @apilevel internal
   */
  protected Collection<Stmt> branches_value;
  /**
   * All branches that reach this node.
   * @attribute syn
   * @aspect BranchTarget
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/BranchTarget.jrag:129
   */
  public Collection<Stmt> branches() {
    if(branches_computed) {
      return branches_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    branches_value = branches_compute();
    if (isFinal && num == state().boundariesCrossed) {
      branches_computed = true;
    } else {
    }

    return branches_value;
  }
  /**
   * @apilevel internal
   */
  private Collection<Stmt> branches_compute() {
      Collection<Stmt> set = new HashSet<Stmt>();
      super.collectBranches(set);
      return set;
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
    try {  return false;  }
    finally {
    }
  }
  /**
   * @apilevel internal
   */
  protected boolean targetContinues_computed = false;
  /**
   * @apilevel internal
   */
  protected Collection<Stmt> targetContinues_value;
  /**
   * @attribute syn
   * @aspect BranchTarget
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/BranchTarget.jrag:268
   */
  public Collection<Stmt> targetContinues() {
    if(targetContinues_computed) {
      return targetContinues_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    targetContinues_value = targetContinues_compute();
    if (isFinal && num == state().boundariesCrossed) {
      targetContinues_computed = true;
    } else {
    }

    return targetContinues_value;
  }
  /**
   * @apilevel internal
   */
  private Collection<Stmt> targetContinues_compute() {
      HashSet<Stmt> set = new HashSet<Stmt>();
      for (Stmt branch : targetBranches()) {
        if (branch instanceof ContinueStmt)
          set.add(branch);
      }
      if (getParent() instanceof LabeledStmt) {
        for (Stmt branch : ((LabeledStmt)getParent()).targetBranches()) {
          if (branch instanceof ContinueStmt)
            set.add(branch);
        }
      }
      return set;
    }
  /**
   * @apilevel internal
   */
  protected boolean targetBreaks_computed = false;
  /**
   * @apilevel internal
   */
  protected Collection<Stmt> targetBreaks_value;
  /**
   * @attribute syn
   * @aspect BranchTarget
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/BranchTarget.jrag:284
   */
  public Collection<Stmt> targetBreaks() {
    if(targetBreaks_computed) {
      return targetBreaks_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    targetBreaks_value = targetBreaks_compute();
    if (isFinal && num == state().boundariesCrossed) {
      targetBreaks_computed = true;
    } else {
    }

    return targetBreaks_value;
  }
  /**
   * @apilevel internal
   */
  private Collection<Stmt> targetBreaks_compute() {
      HashSet<Stmt> set = new HashSet<Stmt>();
      for (Stmt branch : targetBranches()) {
        if (branch instanceof BreakStmt)
          set.add(branch);
      }
      return set;
    }
  /**
   * @apilevel internal
   */
  protected boolean reachableBreak_computed = false;
  /**
   * @apilevel internal
   */
  protected boolean reachableBreak_value;
  /**
   * @attribute syn
   * @aspect UnreachableStatements
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/UnreachableStatements.jrag:49
   */
  public boolean reachableBreak() {
    if(reachableBreak_computed) {
      return reachableBreak_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    reachableBreak_value = reachableBreak_compute();
    if (isFinal && num == state().boundariesCrossed) {
      reachableBreak_computed = true;
    } else {
    }

    return reachableBreak_value;
  }
  /**
   * @apilevel internal
   */
  private boolean reachableBreak_compute() {
      for(Iterator iter = targetBreaks().iterator(); iter.hasNext(); ) {
        BreakStmt stmt = (BreakStmt)iter.next();
        if(stmt.reachable())
          return true;
      }
      return false;
    }
  /**
   * @apilevel internal
   */
  protected boolean reachableContinue_computed = false;
  /**
   * @apilevel internal
   */
  protected boolean reachableContinue_value;
  /**
   * @attribute syn
   * @aspect UnreachableStatements
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/UnreachableStatements.jrag:91
   */
  public boolean reachableContinue() {
    if(reachableContinue_computed) {
      return reachableContinue_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    reachableContinue_value = reachableContinue_compute();
    if (isFinal && num == state().boundariesCrossed) {
      reachableContinue_computed = true;
    } else {
    }

    return reachableContinue_value;
  }
  /**
   * @apilevel internal
   */
  private boolean reachableContinue_compute() {
      for(Iterator iter = targetContinues().iterator(); iter.hasNext(); ) {
        Stmt stmt = (Stmt)iter.next();
        if(stmt.reachable())
          return true;
      }
      return false;
    }
  /*** ASTNode ***
   * 
   * API: SmallSet ASTNode.interceptedAbruptStmts()
   * 
   * We want to propagate interceptedAbruptStmts, i.e. return, break, continue and 
   * throw, upwards in the tree. We do this on ASTNode for a general 
   * traverse/collect implementation.
   * 
   * These statements add branches to the collection; ThrowStmt, ReturnStmt, 
   * BreakStmt and ContinueStmt. The following expressions may result in
   * branches: MethodAccess, ConstructorAccess and ClassInstanceExpr.
   * 
   * These statements remove branches from the collection; BranchTargetStmt, 
   * that is WhileStmt, DoStmt, ForStmt, LabeledStmt and SwitchStmt, may match
   * BreakStmt and ContinueStmt while TryStmt may matche ThrowStmts via its
   * catch clauses. More precisely TryStmt will pass on:
   * a) (try-catch) uncaught throws from block and uncaught throws from 
   * catch clauses.
   * b) (try-finally) uncaught throws from finally or uncaught throws 
   * from block
   * c) (try-catch-finally) (b) or (a) (in that order)
   * Branches in finally have precedence over branches from the try block and 
   * catch clauses.
   * @attribute syn
   * @aspect Java_CFG_1_4
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:633
   */
  public SmallSet<CFGNode> interceptedAbruptStmts() {
    ASTNode$State state = state();
    try {
    		SmallSet<CFGNode> branches = emptySmallSet();
    		Iterator itr = super.interceptedAbruptStmts().iterator();
    		while (itr.hasNext()) {
    			Stmt stmt = (Stmt)itr.next();
    			if (stmt.isBreakStmt() && potentialTargetOf((BreakStmt)stmt) || 
    				stmt.isContinueStmt() && potentialTargetOf((ContinueStmt)stmt)) {
    				continue;
    			} 
    			branches = branches.union(stmt);
    		}
    		return branches;
    	}
    finally {
    }
  }
  /**
   * @attribute inh
   * @aspect Java_CFG_1_4
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:262
   */
  public SmallSet<CFGNode> breakTarget(BreakStmt stmt) {
    ASTNode$State state = state();
    SmallSet<CFGNode> breakTarget_BreakStmt_value = getParent().Define_SmallSet_CFGNode__breakTarget(this, null, stmt);

    return breakTarget_BreakStmt_value;
  }
  /**
   * @attribute inh
   * @aspect Java_CFG_1_4
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:280
   */
  public SmallSet<CFGNode> continueTarget(ContinueStmt stmt) {
    ASTNode$State state = state();
    SmallSet<CFGNode> continueTarget_ContinueStmt_value = getParent().Define_SmallSet_CFGNode__continueTarget(this, null, stmt);

    return continueTarget_ContinueStmt_value;
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/BranchTarget.jrag:257
   * @apilevel internal
   */
  public FinallyHost Define_FinallyHost_enclosingFinally(ASTNode caller, ASTNode child, Stmt branch) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return potentialTargetOf(branch) ? null : enclosingFinally(branch);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:265
   * @apilevel internal
   */
  public SmallSet<CFGNode> Define_SmallSet_CFGNode__breakTarget(ASTNode caller, ASTNode child, BreakStmt stmt) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return potentialTargetOf(stmt) ? following() : breakTarget(stmt);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:283
   * @apilevel internal
   */
  public SmallSet<CFGNode> Define_SmallSet_CFGNode__continueTarget(ASTNode caller, ASTNode child, ContinueStmt stmt) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return potentialTargetOf(stmt) ? SmallSet.<CFGNode>singleton(targetForContinue()) 
		: continueTarget(stmt);
    }
  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {    return super.rewriteTo();
  }}
