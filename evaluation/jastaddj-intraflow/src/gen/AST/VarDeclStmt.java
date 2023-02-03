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
 * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/grammar/Java.ast:81
 * @production VarDeclStmt : {@link Stmt} ::= <span class="component">{@link Modifiers}</span> <span class="component">TypeAccess:{@link Access}</span> <span class="component">{@link VariableDecl}*</span>;

 */
public class VarDeclStmt extends Stmt implements Cloneable {
  /**
   * @aspect VariableDeclarationTransformation
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/VariableDeclaration.jrag:163
   */
  private List createVariableDeclarationList() {
    List varList = new List();
    for(int j = 0; j < getNumVariableDecl(); j++) {
      VariableDeclaration v =
        getVariableDecl(j).createVariableDeclarationFrom(
          (Modifiers)getModifiers().fullCopy(),
          (Access)getTypeAccess().fullCopy()
        );
      if(j == 0)
        v.setStart(start);
      else {
        v.getModifiersNoTransform().clearLocations();
        v.getTypeAccessNoTransform().clearLocations();
      }
      varList.add(v);
    }
    return varList;
  }
  /**
   * @declaredat ASTNode:1
   */
  public VarDeclStmt() {
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
    setChild(new List(), 2);
  }
  /**
   * @declaredat ASTNode:14
   */
  public VarDeclStmt(Modifiers p0, Access p1, List<VariableDecl> p2) {
    setChild(p0, 0);
    setChild(p1, 1);
    setChild(p2, 2);
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:22
   */
  protected int numChildren() {
    return 3;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:28
   */
  public boolean mayHaveRewrite() {
    return true;
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:34
   */
  public void flushCache() {
    super.flushCache();
    canCompleteNormally_computed = false;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:41
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:47
   */
  public VarDeclStmt clone() throws CloneNotSupportedException {
    VarDeclStmt node = (VarDeclStmt) super.clone();
    node.canCompleteNormally_computed = false;
    node.in$Circle(false);
    node.is$Final(false);
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:57
   */
  public VarDeclStmt copy() {
    try {
      VarDeclStmt node = (VarDeclStmt) clone();
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
  public VarDeclStmt fullCopy() {
    VarDeclStmt tree = (VarDeclStmt) copy();
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
   * Replaces the Modifiers child.
   * @param node The new node to replace the Modifiers child.
   * @apilevel high-level
   */
  public void setModifiers(Modifiers node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the Modifiers child.
   * @return The current node used as the Modifiers child.
   * @apilevel high-level
   */
  public Modifiers getModifiers() {
    return (Modifiers) getChild(0);
  }
  /**
   * Retrieves the Modifiers child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Modifiers child.
   * @apilevel low-level
   */
  public Modifiers getModifiersNoTransform() {
    return (Modifiers) getChildNoTransform(0);
  }
  /**
   * Replaces the TypeAccess child.
   * @param node The new node to replace the TypeAccess child.
   * @apilevel high-level
   */
  public void setTypeAccess(Access node) {
    setChild(node, 1);
  }
  /**
   * Retrieves the TypeAccess child.
   * @return The current node used as the TypeAccess child.
   * @apilevel high-level
   */
  public Access getTypeAccess() {
    return (Access) getChild(1);
  }
  /**
   * Retrieves the TypeAccess child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the TypeAccess child.
   * @apilevel low-level
   */
  public Access getTypeAccessNoTransform() {
    return (Access) getChildNoTransform(1);
  }
  /**
   * Replaces the VariableDecl list.
   * @param list The new list node to be used as the VariableDecl list.
   * @apilevel high-level
   */
  public void setVariableDeclList(List<VariableDecl> list) {
    setChild(list, 2);
  }
  /**
   * Retrieves the number of children in the VariableDecl list.
   * @return Number of children in the VariableDecl list.
   * @apilevel high-level
   */
  public int getNumVariableDecl() {
    return getVariableDeclList().getNumChild();
  }
  /**
   * Retrieves the number of children in the VariableDecl list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the VariableDecl list.
   * @apilevel low-level
   */
  public int getNumVariableDeclNoTransform() {
    return getVariableDeclListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the VariableDecl list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the VariableDecl list.
   * @apilevel high-level
   */
  public VariableDecl getVariableDecl(int i) {
    return (VariableDecl) getVariableDeclList().getChild(i);
  }
  /**
   * Check whether the VariableDecl list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasVariableDecl() {
    return getVariableDeclList().getNumChild() != 0;
  }
  /**
   * Append an element to the VariableDecl list.
   * @param node The element to append to the VariableDecl list.
   * @apilevel high-level
   */
  public void addVariableDecl(VariableDecl node) {
    List<VariableDecl> list = (parent == null || state == null) ? getVariableDeclListNoTransform() : getVariableDeclList();
    list.addChild(node);
  }
  /**
   * @apilevel low-level
   */
  public void addVariableDeclNoTransform(VariableDecl node) {
    List<VariableDecl> list = getVariableDeclListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the VariableDecl list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setVariableDecl(VariableDecl node, int i) {
    List<VariableDecl> list = getVariableDeclList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the VariableDecl list.
   * @return The node representing the VariableDecl list.
   * @apilevel high-level
   */
  public List<VariableDecl> getVariableDeclList() {
    List<VariableDecl> list = (List<VariableDecl>) getChild(2);
    list.getNumChild();
    return list;
  }
  /**
   * Retrieves the VariableDecl list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the VariableDecl list.
   * @apilevel low-level
   */
  public List<VariableDecl> getVariableDeclListNoTransform() {
    return (List<VariableDecl>) getChildNoTransform(2);
  }
  /**
   * Retrieves the VariableDecl list.
   * @return The node representing the VariableDecl list.
   * @apilevel high-level
   */
  public List<VariableDecl> getVariableDecls() {
    return getVariableDeclList();
  }
  /**
   * Retrieves the VariableDecl list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the VariableDecl list.
   * @apilevel low-level
   */
  public List<VariableDecl> getVariableDeclsNoTransform() {
    return getVariableDeclListNoTransform();
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
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/UnreachableStatements.jrag:42
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
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/SyntacticClassification.jrag:84
   * @apilevel internal
   */
  public NameType Define_NameType_nameType(ASTNode caller, ASTNode child) {
    if (caller == getTypeAccessNoTransform()) {
      return NameType.TYPE_NAME;
    }
    else {
      return getParent().Define_NameType_nameType(this, caller);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:258
   * @apilevel internal
   */
  public TypeDecl Define_TypeDecl_declType(ASTNode caller, ASTNode child) {
    if (caller == getVariableDeclListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
      return null;
    }
    else {
      return getParent().Define_TypeDecl_declType(this, caller);
    }
  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {    // Declared at @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/VariableDeclaration.jrag:144
    if (getNumVariableDecl() == 1) {
      state().duringVariableDeclarationTransformation++;
      ASTNode result = rewriteRule0();
      state().duringVariableDeclarationTransformation--;
      return result;
    }    // Declared at @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/VariableDeclaration.jrag:155
    if (getParent().getParent() instanceof Block &&
        ((Block)getParent().getParent()).getStmtListNoTransform() == getParent() && getNumVariableDecl() > 1) {

      state().duringVariableDeclarationTransformation++;
      List list = (List) getParent();
      int i = list.getIndexOfChild(this);
      List newList = rewriteBlock_getStmt();
      // the first child is set by the normal rewrite loop
      //list.setChild(newList.getChildNoTransform(0), i);
      for(int j = 1; j < newList.getNumChildNoTransform(); j++)
        list.insertChild(newList.getChildNoTransform(j), ++i);

      state().duringVariableDeclarationTransformation--;
      return newList.getChildNoTransform(0);
    }    // Declared at @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/VariableDeclaration.jrag:159
    if (getParent().getParent() instanceof ForStmt &&
        ((ForStmt)getParent().getParent()).getInitStmtListNoTransform() == getParent() && getNumVariableDecl() > 1) {

      state().duringVariableDeclarationTransformation++;
      List list = (List) getParent();
      int i = list.getIndexOfChild(this);
      List newList = rewriteForStmt_getInitStmt();
      // the first child is set by the normal rewrite loop
      //list.setChild(newList.getChildNoTransform(0), i);
      for(int j = 1; j < newList.getNumChildNoTransform(); j++)
        list.insertChild(newList.getChildNoTransform(j), ++i);

      state().duringVariableDeclarationTransformation--;
      return newList.getChildNoTransform(0);
    }    return super.rewriteTo();
  }  /**
   * @declaredat @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/VariableDeclaration.jrag:144
   * @apilevel internal
   */  private VariableDeclaration rewriteRule0() {
{
      VariableDeclaration decl = getVariableDecl(0).createVariableDeclarationFrom(getModifiers(), getTypeAccess());
      decl.setStart(start); // copy location information
      decl.setEnd(end); // copy location information
      return decl;
    }  }
  /**
   * @declaredat @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/VariableDeclaration.jrag:155
   * @apilevel internal
   */  private List rewriteBlock_getStmt() {
    return createVariableDeclarationList();
  }
  /**
   * @declaredat @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/VariableDeclaration.jrag:159
   * @apilevel internal
   */  private List rewriteForStmt_getInitStmt() {
    return createVariableDeclarationList();
  }
}
