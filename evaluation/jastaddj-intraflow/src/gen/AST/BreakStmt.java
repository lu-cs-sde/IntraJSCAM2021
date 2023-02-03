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
 * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/grammar/Java.ast:210
 * @production BreakStmt : {@link Stmt} ::= <span class="component">&lt;Label:String&gt;</span> <span class="component">[Finally:{@link Block}]</span>;

 */
public class BreakStmt extends Stmt implements Cloneable {
  /**
   * @aspect BranchTarget
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/BranchTarget.jrag:79
   */
  public void collectBranches(Collection<Stmt> c) {
    c.add(this);
  }
  /**
   * @aspect NameCheck
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/NameCheck.jrag:406
   */
  public void nameCheck() {
    if(!hasLabel() && !insideLoop() && !insideSwitch())
      error("break outside switch or loop");
    else if(hasLabel()) {
      LabeledStmt label = lookupLabel(getLabel());
      if(label == null)
        error("labeled break must have visible matching label");
    }
  }
  /**
   * @aspect PrettyPrint
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/PrettyPrint.jadd:686
   */
  public void prettyPrint(StringBuffer sb) {
    sb.append(indent());
    sb.append("break ");
    if(hasLabel())
      sb.append(getLabel());
    sb.append(";");
  }
  /**
   * @declaredat ASTNode:1
   */
  public BreakStmt() {
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
    setChild(new Opt(), 0);
  }
  /**
   * @declaredat ASTNode:14
   */
  public BreakStmt(String p0) {
    setLabel(p0);
  }
  /**
   * @declaredat ASTNode:17
   */
  public BreakStmt(beaver.Symbol p0) {
    setLabel(p0);
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:23
   */
  protected int numChildren() {
    return 0;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:29
   */
  public boolean mayHaveRewrite() {
    return false;
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:35
   */
  public void flushCache() {
    super.flushCache();
    targetStmt_computed = false;
    targetStmt_value = null;
    isDAafter_Variable_values = null;
    isDUafterReachedFinallyBlocks_Variable_values = null;
    isDAafterReachedFinallyBlocks_Variable_values = null;
    isDUafter_Variable_values = null;
    getFinallyOpt_computed = false;
    getFinallyOpt_value = null;
    canCompleteNormally_computed = false;
    succ_computed = false;
    succ_value = null;
    lookupLabel_String_values = null;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:53
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:59
   */
  public BreakStmt clone() throws CloneNotSupportedException {
    BreakStmt node = (BreakStmt) super.clone();
    node.targetStmt_computed = false;
    node.targetStmt_value = null;
    node.isDAafter_Variable_values = null;
    node.isDUafterReachedFinallyBlocks_Variable_values = null;
    node.isDAafterReachedFinallyBlocks_Variable_values = null;
    node.isDUafter_Variable_values = null;
    node.getFinallyOpt_computed = false;
    node.getFinallyOpt_value = null;
    node.canCompleteNormally_computed = false;
    node.succ_computed = false;
    node.succ_value = null;
    node.lookupLabel_String_values = null;
    node.in$Circle(false);
    node.is$Final(false);
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:80
   */
  public BreakStmt copy() {
    try {
      BreakStmt node = (BreakStmt) clone();
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
   * @declaredat ASTNode:98
   */
  public BreakStmt fullCopy() {
    BreakStmt tree = (BreakStmt) copy();
    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
        switch (i) {
        case 0:
          tree.children[i] = new Opt();
          continue;
        }
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
   * Replaces the lexeme Label.
   * @param value The new value for the lexeme Label.
   * @apilevel high-level
   */
  public void setLabel(String value) {
    tokenString_Label = value;
  }
  /**
   * @apilevel internal
   */
  protected String tokenString_Label;
  /**
   */
  public int Labelstart;
  /**
   */
  public int Labelend;
  /**
   * JastAdd-internal setter for lexeme Label using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme Label
   * @apilevel internal
   */
  public void setLabel(beaver.Symbol symbol) {
    if(symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setLabel is only valid for String lexemes");
    tokenString_Label = (String)symbol.value;
    Labelstart = symbol.getStart();
    Labelend = symbol.getEnd();
  }
  /**
   * Retrieves the value for the lexeme Label.
   * @return The value for the lexeme Label.
   * @apilevel high-level
   */
  public String getLabel() {
    return tokenString_Label != null ? tokenString_Label : "";
  }
  /**
   * Replaces the optional node for the Finally child. This is the <code>Opt</code>
   * node containing the child Finally, not the actual child!
   * @param opt The new node to be used as the optional node for the Finally child.
   * @apilevel low-level
   */
  public void setFinallyOpt(Opt<Block> opt) {
    setChild(opt, 0);
  }
  /**
   * Replaces the (optional) Finally child.
   * @param node The new node to be used as the Finally child.
   * @apilevel high-level
   */
  public void setFinally(Block node) {
    getFinallyOpt().setChild(node, 0);
  }
  /**
   * Check whether the optional Finally child exists.
   * @return {@code true} if the optional Finally child exists, {@code false} if it does not.
   * @apilevel high-level
   */
  public boolean hasFinally() {
    return getFinallyOpt().getNumChild() != 0;
  }
  /**
   * Retrieves the (optional) Finally child.
   * @return The Finally child, if it exists. Returns {@code null} otherwise.
   * @apilevel low-level
   */
  public Block getFinally() {
    return (Block) getFinallyOpt().getChild(0);
  }
  /**
   * Retrieves the optional node for child Finally. This is the <code>Opt</code> node containing the child Finally, not the actual child!
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The optional node for child Finally.
   * @apilevel low-level
   */
  public Opt<Block> getFinallyOptNoTransform() {
    return (Opt<Block>) getChildNoTransform(0);
  }
  /**
   * Retrieves the child position of the optional child Finally.
   * @return The the child position of the optional child Finally.
   * @apilevel low-level
   */
  protected int getFinallyOptChildPosition() {
    return 0;
  }
  /**
   * @attribute syn
   * @aspect BranchTarget
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/BranchTarget.jrag:96
   */
  public boolean hasLabel() {
    ASTNode$State state = state();
    try {  return !getLabel().equals("");  }
    finally {
    }
  }
  /**
   * @return <code>true</code> if this statement can branch to
   * the target statement.
   * @attribute syn
   * @aspect BranchTarget
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/BranchTarget.jrag:166
   */
  public boolean canBranchTo(BranchTargetStmt target) {
    ASTNode$State state = state();
    try {  return !hasLabel();  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect BranchTarget
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/BranchTarget.jrag:167
   */
  public boolean canBranchTo(LabeledStmt target) {
    ASTNode$State state = state();
    try {  return hasLabel() && target.getLabel().equals(getLabel());  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect BranchTarget
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/BranchTarget.jrag:168
   */
  public boolean canBranchTo(SwitchStmt target) {
    ASTNode$State state = state();
    try {  return !hasLabel();  }
    finally {
    }
  }
  /**
   * @apilevel internal
   */
  protected boolean targetStmt_computed = false;
  /**
   * @apilevel internal
   */
  protected Stmt targetStmt_value;
  /**
   * @attribute syn
   * @aspect BranchTarget
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/BranchTarget.jrag:189
   */
  public Stmt targetStmt() {
    if(targetStmt_computed) {
      return targetStmt_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    targetStmt_value = targetStmt_compute();
    if (isFinal && num == state().boundariesCrossed) {
      targetStmt_computed = true;
    } else {
    }

    return targetStmt_value;
  }
  /**
   * @apilevel internal
   */
  private Stmt targetStmt_compute() {  return branchTarget(this);  }
  protected java.util.Map isDAafter_Variable_values;
  /**
   * @attribute syn
   * @aspect DA
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DefiniteAssignment.jrag:660
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
  private boolean isDAafter_compute(Variable v) {  return true;  }
  protected java.util.Map isDUafterReachedFinallyBlocks_Variable_values;
  /**
   * @attribute syn
   * @aspect DU
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DefiniteAssignment.jrag:973
   */
  public boolean isDUafterReachedFinallyBlocks(Variable v) {
    Object _parameters = v;
    if (isDUafterReachedFinallyBlocks_Variable_values == null) isDUafterReachedFinallyBlocks_Variable_values = new org.jastadd.util.RobustMap(new java.util.HashMap());
    if(isDUafterReachedFinallyBlocks_Variable_values.containsKey(_parameters)) {
      return ((Boolean)isDUafterReachedFinallyBlocks_Variable_values.get(_parameters)).booleanValue();
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    boolean isDUafterReachedFinallyBlocks_Variable_value = isDUafterReachedFinallyBlocks_compute(v);
    if (isFinal && num == state().boundariesCrossed) {
      isDUafterReachedFinallyBlocks_Variable_values.put(_parameters, Boolean.valueOf(isDUafterReachedFinallyBlocks_Variable_value));
    } else {
    }

    return isDUafterReachedFinallyBlocks_Variable_value;
  }
  /**
   * @apilevel internal
   */
  private boolean isDUafterReachedFinallyBlocks_compute(Variable v) {
      Iterator<FinallyHost> iter = finallyIterator();
      if (!isDUbefore(v) && !iter.hasNext())
        return false;
      while (iter.hasNext()) {
        FinallyHost f = iter.next();
        if (!f.isDUafterFinally(v))
          return false;
      }
      return true;
    }
  protected java.util.Map isDAafterReachedFinallyBlocks_Variable_values;
  /**
   * @attribute syn
   * @aspect DU
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DefiniteAssignment.jrag:1008
   */
  public boolean isDAafterReachedFinallyBlocks(Variable v) {
    Object _parameters = v;
    if (isDAafterReachedFinallyBlocks_Variable_values == null) isDAafterReachedFinallyBlocks_Variable_values = new org.jastadd.util.RobustMap(new java.util.HashMap());
    if(isDAafterReachedFinallyBlocks_Variable_values.containsKey(_parameters)) {
      return ((Boolean)isDAafterReachedFinallyBlocks_Variable_values.get(_parameters)).booleanValue();
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    boolean isDAafterReachedFinallyBlocks_Variable_value = isDAafterReachedFinallyBlocks_compute(v);
    if (isFinal && num == state().boundariesCrossed) {
      isDAafterReachedFinallyBlocks_Variable_values.put(_parameters, Boolean.valueOf(isDAafterReachedFinallyBlocks_Variable_value));
    } else {
    }

    return isDAafterReachedFinallyBlocks_Variable_value;
  }
  /**
   * @apilevel internal
   */
  private boolean isDAafterReachedFinallyBlocks_compute(Variable v) {
      if(isDAbefore(v))
        return true;
      Iterator<FinallyHost> iter = finallyIterator();
      if (!iter.hasNext())
        return false;
      while (iter.hasNext()) {
        FinallyHost f = iter.next();
        if (!f.isDAafterFinally(v))
          return false;
      }
      return true;
    }
  protected java.util.Map isDUafter_Variable_values;
  /**
   * @attribute syn
   * @aspect DU
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DefiniteAssignment.jrag:1228
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
  private boolean isDUafter_compute(Variable v) {  return true;  }
  /**
   * @apilevel internal
   */
  protected boolean getFinallyOpt_computed = false;
  /**
   * @apilevel internal
   */
  protected Opt getFinallyOpt_value;
  /**
   * @attribute syn nta
   * @aspect NTAFinally
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/NTAFinally.jrag:51
   */
  public Opt getFinallyOpt() {
    if(getFinallyOpt_computed) {
      return (Opt) getChild(getFinallyOptChildPosition());
    }
    if(getFinallyOpt_computed) {
      return getFinallyOpt_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    getFinallyOpt_value = getFinallyOpt_compute();
    setFinallyOpt(getFinallyOpt_value);
    if (isFinal && num == state().boundariesCrossed) {
      getFinallyOpt_computed = true;
    } else {
    }

    Opt node = (Opt) this.getChild(getFinallyOptChildPosition());
    return node;
  }
  /**
   * @apilevel internal
   */
  private Opt getFinallyOpt_compute() {
      return branchFinallyOpt();
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
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/UnreachableStatements.jrag:105
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
  private boolean canCompleteNormally_compute() {  return false;  }
  /**
   * @attribute syn
   * @aspect Helpers
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/Helpers.jrag:23
   */
  public boolean isBreakStmt() {
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
   * @aspect Java_CFG_1_4
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:259
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
  private SmallSet<CFGNode> succ_compute() {  return breakTarget(this);  }
  /**
   * @attribute syn
   * @aspect Java_CFG_1_4
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:349
   */
  public SmallSet<CFGNode> targetAt(TryStmt s) {
    ASTNode$State state = state();
    try {  return s.breakTarget(this);  }
    finally {
    }
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
    try {  return SmallSet.<CFGNode>singleton(this);  }
    finally {
    }
  }
  /**
   * @attribute inh
   * @aspect BranchTarget
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/BranchTarget.jrag:229
   */
  public LabeledStmt lookupLabel(String name) {
    Object _parameters = name;
    if (lookupLabel_String_values == null) lookupLabel_String_values = new org.jastadd.util.RobustMap(new java.util.HashMap());
    if(lookupLabel_String_values.containsKey(_parameters)) {
      return (LabeledStmt)lookupLabel_String_values.get(_parameters);
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    LabeledStmt lookupLabel_String_value = getParent().Define_LabeledStmt_lookupLabel(this, null, name);
    if (isFinal && num == state().boundariesCrossed) {
      lookupLabel_String_values.put(_parameters, lookupLabel_String_value);
    } else {
    }

    return lookupLabel_String_value;
  }
  protected java.util.Map lookupLabel_String_values;
  /**
   * @attribute inh
   * @aspect NameCheck
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/NameCheck.jrag:392
   */
  public boolean insideLoop() {
    ASTNode$State state = state();
    boolean insideLoop_value = getParent().Define_boolean_insideLoop(this, null);

    return insideLoop_value;
  }
  /**
   * @attribute inh
   * @aspect NameCheck
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/NameCheck.jrag:401
   */
  public boolean insideSwitch() {
    ASTNode$State state = state();
    boolean insideSwitch_value = getParent().Define_boolean_insideSwitch(this, null);

    return insideSwitch_value;
  }
  /**
   * @attribute inh
   * @aspect Java_CFG_1_4
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:261
   */
  public SmallSet<CFGNode> breakTarget(BreakStmt stmt) {
    ASTNode$State state = state();
    SmallSet<CFGNode> breakTarget_BreakStmt_value = getParent().Define_SmallSet_CFGNode__breakTarget(this, null, stmt);

    return breakTarget_BreakStmt_value;
  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {    return super.rewriteTo();
  }}
