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
 * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/grammar/Java.ast:223
 * @production TryStmt : {@link Stmt} ::= <span class="component">{@link Block}</span> <span class="component">{@link CatchClause}*</span> <span class="component">[Finally:{@link Block}]</span> <span class="component">ExceptionHandler:{@link Block}</span>;

 */
public class TryStmt extends Stmt implements Cloneable, FinallyHost {
  /**
   * @aspect BranchTarget
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/BranchTarget.jrag:91
   */
  public void collectBranches(Collection<Stmt> c) {
    c.addAll(escapedBranches());
  }
  /**
   * @aspect DU
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DefiniteAssignment.jrag:958
   */
  public Block getFinallyBlock() {
    return getFinally();
  }
  /**
   * @aspect ExceptionHandling
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ExceptionHandling.jrag:232
   */
  protected boolean reachedException(TypeDecl type) {
    boolean found = false;
    // found is true if the exception type is caught by a catch clause
    for(int i = 0; i < getNumCatchClause() && !found; i++)
      if(getCatchClause(i).handles(type))
        found = true;
    // if an exception is thrown in the block and the exception is not caught and
    // either there is no finally block or the finally block can complete normally
    if(!found && (!hasNonEmptyFinally() || getFinally().canCompleteNormally()) )
      if(getBlock().reachedException(type))
        return true;
    // even if the exception is caught by the catch clauses they may
    // throw new exceptions
    for(int i = 0; i < getNumCatchClause(); i++)
      if(getCatchClause(i).reachedException(type))
        return true;
    return hasNonEmptyFinally() && getFinally().reachedException(type);
  }
  /**
   * @aspect PrettyPrint
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/PrettyPrint.jadd:726
   */
  public void prettyPrint(StringBuffer sb) {
    sb.append(indent());
    sb.append("try ");
    getBlock().prettyPrint(sb);
    for(int i = 0; i < getNumCatchClause(); i++) {
      sb.append(indent());
      getCatchClause(i).prettyPrint(sb);
    }
    if(hasFinally()) {
      sb.append(indent());
      sb.append("finally ");
      getFinally().prettyPrint(sb);
    }
  }
  /**
   * @declaredat ASTNode:1
   */
  public TryStmt() {
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
    children = new ASTNode[4];
    setChild(new List(), 1);
    setChild(new Opt(), 2);
  }
  /**
   * @declaredat ASTNode:15
   */
  public TryStmt(Block p0, List<CatchClause> p1, Opt<Block> p2) {
    setChild(p0, 0);
    setChild(p1, 1);
    setChild(p2, 2);
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:23
   */
  protected int numChildren() {
    return 3;
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
    branches_computed = false;
    branches_value = null;
    escapedBranches_computed = false;
    escapedBranches_value = null;
    isDAafter_Variable_values = null;
    isDUbefore_Variable_values = null;
    isDUafter_Variable_values = null;
    hasNonEmptyFinally_computed = false;
    catchableException_TypeDecl_values = null;
    getExceptionHandler_computed = false;
    getExceptionHandler_value = null;
    canCompleteNormally_computed = false;
    succ_computed = false;
    succ_value = null;
    hasClauseHandlingThrow_ThrowStmt_values = null;
    handlesException_TypeDecl_values = null;
    typeError_computed = false;
    typeError_value = null;
    typeRuntimeException_computed = false;
    typeRuntimeException_value = null;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:61
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:67
   */
  public TryStmt clone() throws CloneNotSupportedException {
    TryStmt node = (TryStmt) super.clone();
    node.branches_computed = false;
    node.branches_value = null;
    node.escapedBranches_computed = false;
    node.escapedBranches_value = null;
    node.isDAafter_Variable_values = null;
    node.isDUbefore_Variable_values = null;
    node.isDUafter_Variable_values = null;
    node.hasNonEmptyFinally_computed = false;
    node.catchableException_TypeDecl_values = null;
    node.getExceptionHandler_computed = false;
    node.getExceptionHandler_value = null;
    node.canCompleteNormally_computed = false;
    node.succ_computed = false;
    node.succ_value = null;
    node.hasClauseHandlingThrow_ThrowStmt_values = null;
    node.handlesException_TypeDecl_values = null;
    node.typeError_computed = false;
    node.typeError_value = null;
    node.typeRuntimeException_computed = false;
    node.typeRuntimeException_value = null;
    node.in$Circle(false);
    node.is$Final(false);
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:96
   */
  public TryStmt copy() {
    try {
      TryStmt node = (TryStmt) clone();
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
   * @declaredat ASTNode:114
   */
  public TryStmt fullCopy() {
    TryStmt tree = (TryStmt) copy();
    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
        switch (i) {
        case 3:
          tree.children[i] = null;
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
   * Replaces the CatchClause list.
   * @param list The new list node to be used as the CatchClause list.
   * @apilevel high-level
   */
  public void setCatchClauseList(List<CatchClause> list) {
    setChild(list, 1);
  }
  /**
   * Retrieves the number of children in the CatchClause list.
   * @return Number of children in the CatchClause list.
   * @apilevel high-level
   */
  public int getNumCatchClause() {
    return getCatchClauseList().getNumChild();
  }
  /**
   * Retrieves the number of children in the CatchClause list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the CatchClause list.
   * @apilevel low-level
   */
  public int getNumCatchClauseNoTransform() {
    return getCatchClauseListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the CatchClause list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the CatchClause list.
   * @apilevel high-level
   */
  public CatchClause getCatchClause(int i) {
    return (CatchClause) getCatchClauseList().getChild(i);
  }
  /**
   * Check whether the CatchClause list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasCatchClause() {
    return getCatchClauseList().getNumChild() != 0;
  }
  /**
   * Append an element to the CatchClause list.
   * @param node The element to append to the CatchClause list.
   * @apilevel high-level
   */
  public void addCatchClause(CatchClause node) {
    List<CatchClause> list = (parent == null || state == null) ? getCatchClauseListNoTransform() : getCatchClauseList();
    list.addChild(node);
  }
  /**
   * @apilevel low-level
   */
  public void addCatchClauseNoTransform(CatchClause node) {
    List<CatchClause> list = getCatchClauseListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the CatchClause list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setCatchClause(CatchClause node, int i) {
    List<CatchClause> list = getCatchClauseList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the CatchClause list.
   * @return The node representing the CatchClause list.
   * @apilevel high-level
   */
  public List<CatchClause> getCatchClauseList() {
    List<CatchClause> list = (List<CatchClause>) getChild(1);
    list.getNumChild();
    return list;
  }
  /**
   * Retrieves the CatchClause list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the CatchClause list.
   * @apilevel low-level
   */
  public List<CatchClause> getCatchClauseListNoTransform() {
    return (List<CatchClause>) getChildNoTransform(1);
  }
  /**
   * Retrieves the CatchClause list.
   * @return The node representing the CatchClause list.
   * @apilevel high-level
   */
  public List<CatchClause> getCatchClauses() {
    return getCatchClauseList();
  }
  /**
   * Retrieves the CatchClause list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the CatchClause list.
   * @apilevel low-level
   */
  public List<CatchClause> getCatchClausesNoTransform() {
    return getCatchClauseListNoTransform();
  }
  /**
   * Replaces the optional node for the Finally child. This is the <code>Opt</code>
   * node containing the child Finally, not the actual child!
   * @param opt The new node to be used as the optional node for the Finally child.
   * @apilevel low-level
   */
  public void setFinallyOpt(Opt<Block> opt) {
    setChild(opt, 2);
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
   * Retrieves the optional node for the Finally child. This is the <code>Opt</code> node containing the child Finally, not the actual child!
   * @return The optional node for child the Finally child.
   * @apilevel low-level
   */
  public Opt<Block> getFinallyOpt() {
    return (Opt<Block>) getChild(2);
  }
  /**
   * Retrieves the optional node for child Finally. This is the <code>Opt</code> node containing the child Finally, not the actual child!
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The optional node for child Finally.
   * @apilevel low-level
   */
  public Opt<Block> getFinallyOptNoTransform() {
    return (Opt<Block>) getChildNoTransform(2);
  }
  /**
   * Replaces the ExceptionHandler child.
   * @param node The new node to replace the ExceptionHandler child.
   * @apilevel high-level
   */
  public void setExceptionHandler(Block node) {
    setChild(node, 3);
  }
  /**
   * Retrieves the ExceptionHandler child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the ExceptionHandler child.
   * @apilevel low-level
   */
  public Block getExceptionHandlerNoTransform() {
    return (Block) getChildNoTransform(3);
  }
  /**
   * Retrieves the child position of the optional child ExceptionHandler.
   * @return The the child position of the optional child ExceptionHandler.
   * @apilevel low-level
   */
  protected int getExceptionHandlerChildPosition() {
    return 3;
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
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/BranchTarget.jrag:138
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
      getBlock().collectBranches(set);
      for (int i = 0; i < getNumCatchClause(); i++) {
        getCatchClause(i).collectBranches(set);
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
   * All branches that escape this node
   * @attribute syn
   * @aspect BranchTarget
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/BranchTarget.jrag:150
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
      if (hasNonEmptyFinally()) {
        // branches from finally
        getFinally().collectBranches(set);
      }
      if (!hasFinally() || getFinally().canCompleteNormally()) {
        set.addAll(branches());
      }
      return set;
    }
  protected java.util.Map isDAafter_Variable_values;
  /**
   * @attribute syn
   * @aspect DA
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DefiniteAssignment.jrag:679
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
      // 16.2.15 4th bullet
      if(!hasNonEmptyFinally()) {
        if(!getBlock().isDAafter(v))
          return false;
        for(int i = 0; i < getNumCatchClause(); i++)
          if(!getCatchClause(i).getBlock().isDAafter(v))
            return false;
        return true;
      }
      else {
        // 16.2.15 5th bullet
        if(getFinally().isDAafter(v))
          return true;
        if(!getBlock().isDAafter(v))
          return false;
        for(int i = 0; i < getNumCatchClause(); i++)
          if(!getCatchClause(i).getBlock().isDAafter(v))
            return false;
        return true;
      }
    }
  /**
   * @attribute syn
   * @aspect DU
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DefiniteAssignment.jrag:966
   */
  public boolean isDUafterFinally(Variable v) {
    ASTNode$State state = state();
    try {  return getFinally().isDUafter(v);  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect DU
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DefiniteAssignment.jrag:969
   */
  public boolean isDAafterFinally(Variable v) {
    ASTNode$State state = state();
    try {  return getFinally().isDAafter(v);  }
    finally {
    }
  }
  protected java.util.Map isDUbefore_Variable_values;
  /**
   * @attribute syn
   * @aspect DU
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DefiniteAssignment.jrag:1243
   */
  public boolean isDUbefore(Variable v) {
    Object _parameters = v;
    if (isDUbefore_Variable_values == null) isDUbefore_Variable_values = new org.jastadd.util.RobustMap(new java.util.HashMap());
    ASTNode$State.CircularValue _value;
    if(isDUbefore_Variable_values.containsKey(_parameters)) {
      Object _o = isDUbefore_Variable_values.get(_parameters);
      if(!(_o instanceof ASTNode$State.CircularValue)) {
        return ((Boolean)_o).booleanValue();
      } else {
        _value = (ASTNode$State.CircularValue) _o;
      }
    } else {
      _value = new ASTNode$State.CircularValue();
      isDUbefore_Variable_values.put(_parameters, _value);
      _value.value = Boolean.valueOf(true);
    }
    ASTNode$State state = state();
    if (!state.IN_CIRCLE) {
      state.IN_CIRCLE = true;
      int num = state.boundariesCrossed;
      boolean isFinal = this.is$Final();
      // TODO: fixme
      // state().CIRCLE_INDEX = 1;
      boolean new_isDUbefore_Variable_value;
      do {
        _value.visited = new Integer(state.CIRCLE_INDEX);
        state.CHANGE = false;
        new_isDUbefore_Variable_value = isDUbefore_compute(v);
        if (new_isDUbefore_Variable_value != ((Boolean)_value.value).booleanValue()) {
          state.CHANGE = true;
          _value.value = Boolean.valueOf(new_isDUbefore_Variable_value);
        }
        state.CIRCLE_INDEX++;
      } while (state.CHANGE);
      if (isFinal && num == state().boundariesCrossed) {
        isDUbefore_Variable_values.put(_parameters, new_isDUbefore_Variable_value);
      } else {
        isDUbefore_Variable_values.remove(_parameters);
        state.RESET_CYCLE = true;
        isDUbefore_compute(v);
        state.RESET_CYCLE = false;
      }
      state.IN_CIRCLE = false;
      return new_isDUbefore_Variable_value;
    }
    if (!new Integer(state.CIRCLE_INDEX).equals(_value.visited)) {
      _value.visited = new Integer(state.CIRCLE_INDEX);
      boolean new_isDUbefore_Variable_value = isDUbefore_compute(v);
      if (state.RESET_CYCLE) {
        isDUbefore_Variable_values.remove(_parameters);
      }
      else if (new_isDUbefore_Variable_value != ((Boolean)_value.value).booleanValue()) {
        state.CHANGE = true;
        _value.value = new_isDUbefore_Variable_value;
      }
      return new_isDUbefore_Variable_value;
    }
    return ((Boolean)_value.value).booleanValue();
  }
  /**
   * @apilevel internal
   */
  private boolean isDUbefore_compute(Variable v) {  return super.isDUbefore(v);  }
  protected java.util.Map isDUafter_Variable_values;
  /**
   * @attribute syn
   * @aspect DU
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DefiniteAssignment.jrag:1279
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
      // 16.2.14 4th bullet
      if(!hasNonEmptyFinally()) {
        if(!getBlock().isDUafter(v))
          return false;
        for(int i = 0; i < getNumCatchClause(); i++)
          if(!getCatchClause(i).getBlock().isDUafter(v))
            return false;
        return true;
      }
      else
        return getFinally().isDUafter(v);
    }
  /**
   * @apilevel internal
   */
  protected boolean hasNonEmptyFinally_computed = false;
  /**
   * @apilevel internal
   */
  protected boolean hasNonEmptyFinally_value;
  /**
   * @return <code>true</code> if this TyStmt has a non-empty finally block
   * @attribute syn
   * @aspect ExceptionHandling
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ExceptionHandling.jrag:15
   */
  public boolean hasNonEmptyFinally() {
    if(hasNonEmptyFinally_computed) {
      return hasNonEmptyFinally_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    hasNonEmptyFinally_value = hasNonEmptyFinally_compute();
    if (isFinal && num == state().boundariesCrossed) {
      hasNonEmptyFinally_computed = true;
    } else {
    }

    return hasNonEmptyFinally_value;
  }
  /**
   * @apilevel internal
   */
  private boolean hasNonEmptyFinally_compute() {  return hasFinally() && getFinally().getNumStmt() > 0;  }
  protected java.util.Map catchableException_TypeDecl_values;
  /**
   * The block of the try statement can throw an exception of
   * a type assignable to the given type.
   * @attribute syn
   * @aspect ExceptionHandling
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ExceptionHandling.jrag:222
   */
  public boolean catchableException(TypeDecl type) {
    Object _parameters = type;
    if (catchableException_TypeDecl_values == null) catchableException_TypeDecl_values = new org.jastadd.util.RobustMap(new java.util.HashMap());
    if(catchableException_TypeDecl_values.containsKey(_parameters)) {
      return ((Boolean)catchableException_TypeDecl_values.get(_parameters)).booleanValue();
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    boolean catchableException_TypeDecl_value = catchableException_compute(type);
    if (isFinal && num == state().boundariesCrossed) {
      catchableException_TypeDecl_values.put(_parameters, Boolean.valueOf(catchableException_TypeDecl_value));
    } else {
    }

    return catchableException_TypeDecl_value;
  }
  /**
   * @apilevel internal
   */
  private boolean catchableException_compute(TypeDecl type) {  return getBlock().reachedException(type);  }
  /**
   * @apilevel internal
   */
  protected boolean getExceptionHandler_computed = false;
  /**
   * @apilevel internal
   */
  protected Block getExceptionHandler_value;
  /**
   * Copy of the finally block for catch-all exception handling.
   * @attribute syn nta
   * @aspect NTAFinally
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/NTAFinally.jrag:66
   */
  public Block getExceptionHandler() {
    if(getExceptionHandler_computed) {
      return (Block) getChild(getExceptionHandlerChildPosition());
    }
    if(getExceptionHandler_computed) {
      return getExceptionHandler_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    getExceptionHandler_value = getExceptionHandler_compute();
      setExceptionHandler(getExceptionHandler_value);
    if (isFinal && num == state().boundariesCrossed) {
      getExceptionHandler_computed = true;
    } else {
    }

    Block node = (Block) this.getChild(getExceptionHandlerChildPosition());
    return node;
  }
  /**
   * @apilevel internal
   */
  private Block getExceptionHandler_compute() {
      if (hasNonEmptyFinally()) {
        NTAFinallyBlock ntaBlock = new NTAFinallyBlock(this);
        ntaBlock.addStmt((Block) getFinally().fullCopy());
        return ntaBlock;
      } else {
        return new NTAFinallyBlock();
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
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/UnreachableStatements.jrag:113
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
  private boolean canCompleteNormally_compute() {
       boolean anyCatchClauseCompleteNormally = false;
       for(int i = 0; i < getNumCatchClause() && !anyCatchClauseCompleteNormally; i++)
         anyCatchClauseCompleteNormally = getCatchClause(i).getBlock().canCompleteNormally();
       return (getBlock().canCompleteNormally() || anyCatchClauseCompleteNormally) &&
         (!hasNonEmptyFinally() || getFinally().canCompleteNormally());
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
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:333
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
  private SmallSet<CFGNode> succ_compute() {  return SmallSet.<CFGNode>singleton(getBlock());  }
  protected java.util.Map hasClauseHandlingThrow_ThrowStmt_values;
  /**
   * @attribute syn
   * @aspect Java_CFG_1_4
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:356
   */
  public boolean hasClauseHandlingThrow(ThrowStmt stmt) {
    Object _parameters = stmt;
    if (hasClauseHandlingThrow_ThrowStmt_values == null) hasClauseHandlingThrow_ThrowStmt_values = new org.jastadd.util.RobustMap(new java.util.HashMap());
    if(hasClauseHandlingThrow_ThrowStmt_values.containsKey(_parameters)) {
      return ((Boolean)hasClauseHandlingThrow_ThrowStmt_values.get(_parameters)).booleanValue();
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    boolean hasClauseHandlingThrow_ThrowStmt_value = hasClauseHandlingThrow_compute(stmt);
    if (isFinal && num == state().boundariesCrossed) {
      hasClauseHandlingThrow_ThrowStmt_values.put(_parameters, Boolean.valueOf(hasClauseHandlingThrow_ThrowStmt_value));
    } else {
    }

    return hasClauseHandlingThrow_ThrowStmt_value;
  }
  /**
   * @apilevel internal
   */
  private boolean hasClauseHandlingThrow_compute(ThrowStmt stmt) {  return getClauseHandlingThrow(stmt.getExpr().type()) != null;  }
  /**
   * @attribute syn
   * @aspect Java_CFG_1_4
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:359
   */
  public CatchClause getClauseHandlingThrow(TypeDecl type) {
    ASTNode$State state = state();
    try {
    		for (CatchClause clause : getCatchClauses()) {
    			if (clause.handles(type)) {
    				return clause;
    			}
    		}
    		return null;
    	}
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
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:633
   */
  public SmallSet<CFGNode> interceptedAbruptStmts() {
    ASTNode$State state = state();
    try {
    		// Only pass on branches from finally if such exists
    		if (hasFinally() && !getFinally().canCompleteNormally()) {
    			return getFinally().interceptedAbruptStmts();
    		}
    		// Pass on branches from Block which cannot be matched to catch clauses
    		SmallSet<CFGNode> branches = emptySmallSet();
    		Iterator itr = getBlock().interceptedAbruptStmts().iterator();
    		while (itr.hasNext()) {
    			Stmt stmt = (Stmt)itr.next();
    			if (stmt.isThrowStmt() && hasClauseHandlingThrow((ThrowStmt)stmt)) {
    				continue;
    			} 
    			branches = branches.union(stmt);
    		}
    		// Pass on unhandled branches from catch clauses
    		for (int i = 0; i < getNumCatchClause(); i++) {
    			CatchClause clause = getCatchClause(i);
    			branches = branches.union(clause.interceptedAbruptStmts());
    		}
    		return branches;
    	}
    finally {
    }
  }
  /**
   * @attribute inh
   * @aspect ExceptionHandling
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ExceptionHandling.jrag:55
   */
  public boolean handlesException(TypeDecl exceptionType) {
    Object _parameters = exceptionType;
    if (handlesException_TypeDecl_values == null) handlesException_TypeDecl_values = new org.jastadd.util.RobustMap(new java.util.HashMap());
    if(handlesException_TypeDecl_values.containsKey(_parameters)) {
      return ((Boolean)handlesException_TypeDecl_values.get(_parameters)).booleanValue();
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    boolean handlesException_TypeDecl_value = getParent().Define_boolean_handlesException(this, null, exceptionType);
    if (isFinal && num == state().boundariesCrossed) {
      handlesException_TypeDecl_values.put(_parameters, Boolean.valueOf(handlesException_TypeDecl_value));
    } else {
    }

    return handlesException_TypeDecl_value;
  }
  protected java.util.Map handlesException_TypeDecl_values;
  /**
   * @attribute inh
   * @aspect UnreachableStatements
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/UnreachableStatements.jrag:138
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
   * @attribute inh
   * @aspect UnreachableStatements
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/UnreachableStatements.jrag:139
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
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:247
   */
  public SmallSet<CFGNode> returnTarget() {
    ASTNode$State state = state();
    SmallSet<CFGNode> returnTarget_value = getParent().Define_SmallSet_CFGNode__returnTarget(this, null);

    return returnTarget_value;
  }
  /**
   * @attribute inh
   * @aspect Java_CFG_1_4
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:263
   */
  public SmallSet<CFGNode> breakTarget(BreakStmt stmt) {
    ASTNode$State state = state();
    SmallSet<CFGNode> breakTarget_BreakStmt_value = getParent().Define_SmallSet_CFGNode__breakTarget(this, null, stmt);

    return breakTarget_BreakStmt_value;
  }
  /**
   * @attribute inh
   * @aspect Java_CFG_1_4
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:281
   */
  public SmallSet<CFGNode> continueTarget(ContinueStmt stmt) {
    ASTNode$State state = state();
    SmallSet<CFGNode> continueTarget_ContinueStmt_value = getParent().Define_SmallSet_CFGNode__continueTarget(this, null, stmt);

    return continueTarget_ContinueStmt_value;
  }
  /**
   * @attribute inh
   * @aspect Java_CFG_1_4
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:307
   */
  public SmallSet<CFGNode> throwTarget(TypeDecl type) {
    ASTNode$State state = state();
    SmallSet<CFGNode> throwTarget_TypeDecl_value = getParent().Define_SmallSet_CFGNode__throwTarget(this, null, type);

    return throwTarget_TypeDecl_value;
  }
  /**
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/BranchTarget.jrag:249
   * @apilevel internal
   */
  public FinallyHost Define_FinallyHost_enclosingFinally(ASTNode caller, ASTNode child, Stmt branch) {
    if (caller == getFinallyOptNoTransform()) {
      return enclosingFinally(branch);
    }
    else  {
      int childIndex = this.getIndexOfChild(caller);
      return hasNonEmptyFinally() ? this : enclosingFinally(branch);
    }
  }
  /**
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DefiniteAssignment.jrag:678
   * @apilevel internal
   */
  public boolean Define_boolean_isDAbefore(ASTNode caller, ASTNode child, Variable v) {
    if (caller == getFinallyOptNoTransform()) {
      return isDAbefore(v);
    }
    else if (caller == getCatchClauseListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
      return getBlock().isDAbefore(v);
    }
    else if (caller == getBlockNoTransform()) {
      return isDAbefore(v);
    }
    else {
      return getParent().Define_boolean_isDAbefore(this, caller, v);
    }
  }
  /**
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DefiniteAssignment.jrag:1270
   * @apilevel internal
   */
  public boolean Define_boolean_isDUbefore(ASTNode caller, ASTNode child, Variable v) {
    if (caller == getFinallyOptNoTransform()){
    if(!getBlock().isDUeverywhere(v))
      return false;
    for(int i = 0; i < getNumCatchClause(); i++)
      if(!getCatchClause(i).getBlock().unassignedEverywhere(v, this))
        return false;
    return true;
  }
    else if (caller == getCatchClauseListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
      {
    if(!getBlock().isDUafter(v))
      return false;
    if(!getBlock().isDUeverywhere(v))
      return false;
    return true;
  }
    }
    else if (caller == getBlockNoTransform()) {
      return isDUbefore(v);
    }
    else {
      return getParent().Define_boolean_isDUbefore(this, caller, v);
    }
  }
  /**
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ExceptionHandling.jrag:203
   * @apilevel internal
   */
  public boolean Define_boolean_handlesException(ASTNode caller, ASTNode child, TypeDecl exceptionType) {
    if (caller == getBlockNoTransform()){
    for(int i = 0; i < getNumCatchClause(); i++)
      if(getCatchClause(i).handles(exceptionType))
        return true;
    if(hasNonEmptyFinally() && !getFinally().canCompleteNormally())
      return true;
    return handlesException(exceptionType);
  }
    else if (caller == getCatchClauseListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
      {
    if(hasNonEmptyFinally() && !getFinally().canCompleteNormally())
      return true;
    return handlesException(exceptionType);
  }
    }
    else {
      return getParent().Define_boolean_handlesException(this, caller, exceptionType);
    }
  }
  /**
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/UnreachableStatements.jrag:121
   * @apilevel internal
   */
  public boolean Define_boolean_reachable(ASTNode caller, ASTNode child) {
    if (caller == getFinallyOptNoTransform()) {
      return reachable();
    }
    else if (caller == getBlockNoTransform()) {
      return reachable();
    }
    else {
      return getParent().Define_boolean_reachable(this, caller);
    }
  }
  /**
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/UnreachableStatements.jrag:128
   * @apilevel internal
   */
  public boolean Define_boolean_reachableCatchClause(ASTNode caller, ASTNode child, TypeDecl exceptionType) {
    if (caller == getCatchClauseListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
      {
    for(int i = 0; i < childIndex; i++)
      if(getCatchClause(i).handles(exceptionType))
        return false;
    if(catchableException(exceptionType))
      return true;
    if(exceptionType.mayCatch(typeError()) || exceptionType.mayCatch(typeRuntimeException()))
      return true;
    return false;
  }
    }
    else {
      return getParent().Define_boolean_reachableCatchClause(this, caller, exceptionType);
    }
  }
  /**
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/UnreachableStatements.jrag:156
   * @apilevel internal
   */
  public boolean Define_boolean_reportUnreachable(ASTNode caller, ASTNode child) {
    if (caller == getFinallyOptNoTransform()) {
      return reachable();
    }
    else if (caller == getCatchClauseListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
      return reachable();
    }
    else if (caller == getBlockNoTransform()) {
      return reachable();
    }
    else {
      return getParent().Define_boolean_reportUnreachable(this, caller);
    }
  }
  /**
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:251
   * @apilevel internal
   */
  public SmallSet<CFGNode> Define_SmallSet_CFGNode__returnTarget(ASTNode caller, ASTNode child) {
    if (caller == getCatchClauseListNoTransform()) {
      int i = caller.getIndexOfChild(child);
      return hasFinally() ? SmallSet.<CFGNode>singleton(getFinally()) : returnTarget();
    }
    else if (caller == getBlockNoTransform()) {
      return hasFinally() ? SmallSet.<CFGNode>singleton(getFinally()) : returnTarget();
    }
    else {
      return getParent().Define_SmallSet_CFGNode__returnTarget(this, caller);
    }
  }
  /**
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:267
   * @apilevel internal
   */
  public SmallSet<CFGNode> Define_SmallSet_CFGNode__breakTarget(ASTNode caller, ASTNode child, BreakStmt stmt) {
    if (caller == getBlockNoTransform()) {
      return hasFinally() ? SmallSet.<CFGNode>singleton(getFinally()) : breakTarget(stmt);
    }
    else {
      return getParent().Define_SmallSet_CFGNode__breakTarget(this, caller, stmt);
    }
  }
  /**
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:286
   * @apilevel internal
   */
  public SmallSet<CFGNode> Define_SmallSet_CFGNode__continueTarget(ASTNode caller, ASTNode child, ContinueStmt stmt) {
    if (caller == getBlockNoTransform()) {
      return hasFinally() ?
		SmallSet.<CFGNode>singleton(getFinally()) : continueTarget(stmt);
    }
    else {
      return getParent().Define_SmallSet_CFGNode__continueTarget(this, caller, stmt);
    }
  }
  /**
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:323
   * @apilevel internal
   */
  public SmallSet<CFGNode> Define_SmallSet_CFGNode__throwTarget(ASTNode caller, ASTNode child, TypeDecl type) {
    if (caller == getCatchClauseListNoTransform()) {
      int i = caller.getIndexOfChild(child);
      return hasFinally() ? SmallSet.<CFGNode>singleton(getFinally()) : throwTarget(type);
    }
    else if (caller == getBlockNoTransform()){
		CatchClause clause = getClauseHandlingThrow(type);
		if (clause != null) {
			return SmallSet.<CFGNode>singleton(clause.getBlock());
		} 
		return hasFinally() ? SmallSet.<CFGNode>singleton(getFinally()) 
			: throwTarget(type);
	}
    else {
      return getParent().Define_SmallSet_CFGNode__throwTarget(this, caller, type);
    }
  }
  /**
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:338
   * @apilevel internal
   */
  public SmallSet<CFGNode> Define_SmallSet_CFGNode__following(ASTNode caller, ASTNode child) {
    if (caller == getFinallyOptNoTransform()){
		SmallSet<CFGNode> succ = 
			getFinally().canCompleteNormally() ? 
			following() : emptySmallSet();
		Iterator itr = interceptedAbruptStmts().iterator();
		while (itr.hasNext()) {
			Stmt branch = (Stmt)itr.next();
			succ = succ.union(branch.targetAt(this));
		}
		return succ;
	}
    else if (caller == getCatchClauseListNoTransform()) {
      int i = caller.getIndexOfChild(child);
      return hasFinally() ? 
		SmallSet.<CFGNode>singleton(getFinally()) : following();
    }
    else if (caller == getBlockNoTransform()) {
      return hasFinally() ? 
		SmallSet.<CFGNode>singleton(getFinally()) : following();
    }
    else {
      return getParent().Define_SmallSet_CFGNode__following(this, caller);
    }
  }
  /**
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:712
   * @apilevel internal
   */
  public SmallSet<CFGNode> Define_SmallSet_CFGNode__uncheckedExceptionTarget(ASTNode caller, ASTNode child) {
    if (caller == getBlockNoTransform()){
		SmallSet<CFGNode> set = SmallSet.empty();
		for(CatchClause clause : getCatchClauses()) {
			if(clause.handlesAllUncheckedExceptions())
				return set.union(clause.getBlock());
			if(clause.handlesUncheckedException())
				set = set.union(clause.getBlock());
		}
		return set.union(uncheckedExceptionTarget());
	}
    else {
      return getParent().Define_SmallSet_CFGNode__uncheckedExceptionTarget(this, caller);
    }
  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {    return super.rewriteTo();
  }}
