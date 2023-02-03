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
 * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/grammar/Enums.ast:5
 * @production EnumInstanceExpr : {@link ClassInstanceExpr} ::= <span class="component">{@link Access}</span> <span class="component">Arg:{@link Expr}*</span> <span class="component">[{@link TypeDecl}]</span>;

 */
public class EnumInstanceExpr extends ClassInstanceExpr implements Cloneable {
  /**
   * @declaredat ASTNode:1
   */
  public EnumInstanceExpr() {
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
    setChild(new Opt(), 0);
    setChild(new List(), 2);
  }
  /**
   * @declaredat ASTNode:15
   */
  public EnumInstanceExpr(Opt<TypeDecl> p0) {
    setChild(p0, 0);
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:21
   */
  protected int numChildren() {
    return 1;
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
    getAccess_computed = false;
    getAccess_value = null;
    getArgList_computed = false;
    getArgList_value = null;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:43
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:49
   */
  public EnumInstanceExpr clone() throws CloneNotSupportedException {
    EnumInstanceExpr node = (EnumInstanceExpr) super.clone();
    node.getAccess_computed = false;
    node.getAccess_value = null;
    node.getArgList_computed = false;
    node.getArgList_value = null;
    node.in$Circle(false);
    node.is$Final(false);
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:62
   */
  public EnumInstanceExpr copy() {
    try {
      EnumInstanceExpr node = (EnumInstanceExpr) clone();
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
   * @declaredat ASTNode:80
   */
  public EnumInstanceExpr fullCopy() {
    EnumInstanceExpr tree = (EnumInstanceExpr) copy();
    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
        switch (i) {
        case 1:
          tree.children[i] = null;
          continue;
        case 2:
          tree.children[i] = new List();
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
   * Replaces the optional node for the TypeDecl child. This is the <code>Opt</code>
   * node containing the child TypeDecl, not the actual child!
   * @param opt The new node to be used as the optional node for the TypeDecl child.
   * @apilevel low-level
   */
  public void setTypeDeclOpt(Opt<TypeDecl> opt) {
    setChild(opt, 0);
  }
  /**
   * Replaces the (optional) TypeDecl child.
   * @param node The new node to be used as the TypeDecl child.
   * @apilevel high-level
   */
  public void setTypeDecl(TypeDecl node) {
    getTypeDeclOpt().setChild(node, 0);
  }
  /**
   * Check whether the optional TypeDecl child exists.
   * @return {@code true} if the optional TypeDecl child exists, {@code false} if it does not.
   * @apilevel high-level
   */
  public boolean hasTypeDecl() {
    return getTypeDeclOpt().getNumChild() != 0;
  }
  /**
   * Retrieves the (optional) TypeDecl child.
   * @return The TypeDecl child, if it exists. Returns {@code null} otherwise.
   * @apilevel low-level
   */
  public TypeDecl getTypeDecl() {
    return (TypeDecl) getTypeDeclOpt().getChild(0);
  }
  /**
   * Retrieves the optional node for the TypeDecl child. This is the <code>Opt</code> node containing the child TypeDecl, not the actual child!
   * @return The optional node for child the TypeDecl child.
   * @apilevel low-level
   */
  public Opt<TypeDecl> getTypeDeclOpt() {
    return (Opt<TypeDecl>) getChild(0);
  }
  /**
   * Retrieves the optional node for child TypeDecl. This is the <code>Opt</code> node containing the child TypeDecl, not the actual child!
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The optional node for child TypeDecl.
   * @apilevel low-level
   */
  public Opt<TypeDecl> getTypeDeclOptNoTransform() {
    return (Opt<TypeDecl>) getChildNoTransform(0);
  }
  /**
   * Replaces the Access child.
   * @param node The new node to replace the Access child.
   * @apilevel high-level
   */
  public void setAccess(Access node) {
    setChild(node, 1);
  }
  /**
   * Retrieves the Access child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Access child.
   * @apilevel low-level
   */
  public Access getAccessNoTransform() {
    return (Access) getChildNoTransform(1);
  }
  /**
   * Retrieves the child position of the optional child Access.
   * @return The the child position of the optional child Access.
   * @apilevel low-level
   */
  protected int getAccessChildPosition() {
    return 1;
  }
  /**
   * Replaces the Arg list.
   * @param list The new list node to be used as the Arg list.
   * @apilevel high-level
   */
  public void setArgList(List<Expr> list) {
    setChild(list, 2);
  }
  /**
   * Retrieves the number of children in the Arg list.
   * @return Number of children in the Arg list.
   * @apilevel high-level
   */
  public int getNumArg() {
    return getArgList().getNumChild();
  }
  /**
   * Retrieves the number of children in the Arg list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the Arg list.
   * @apilevel low-level
   */
  public int getNumArgNoTransform() {
    return getArgListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the Arg list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the Arg list.
   * @apilevel high-level
   */
  public Expr getArg(int i) {
    return (Expr) getArgList().getChild(i);
  }
  /**
   * Check whether the Arg list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasArg() {
    return getArgList().getNumChild() != 0;
  }
  /**
   * Append an element to the Arg list.
   * @param node The element to append to the Arg list.
   * @apilevel high-level
   */
  public void addArg(Expr node) {
    List<Expr> list = (parent == null || state == null) ? getArgListNoTransform() : getArgList();
    list.addChild(node);
  }
  /**
   * @apilevel low-level
   */
  public void addArgNoTransform(Expr node) {
    List<Expr> list = getArgListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the Arg list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setArg(Expr node, int i) {
    List<Expr> list = getArgList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the child position of the Arg list.
   * @return The the child position of the Arg list.
   * @apilevel low-level
   */
  protected int getArgListChildPosition() {
    return 2;
  }
  /**
   * Retrieves the Arg list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Arg list.
   * @apilevel low-level
   */
  public List<Expr> getArgListNoTransform() {
    return (List<Expr>) getChildNoTransform(2);
  }
  /**
   * Retrieves the Arg list.
   * @return The node representing the Arg list.
   * @apilevel high-level
   */
  public List<Expr> getArgs() {
    return getArgList();
  }
  /**
   * Retrieves the Arg list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Arg list.
   * @apilevel low-level
   */
  public List<Expr> getArgsNoTransform() {
    return getArgListNoTransform();
  }
  /**
   * @apilevel internal
   */
  protected boolean getAccess_computed = false;
  /**
   * @apilevel internal
   */
  protected Access getAccess_value;
  /**
   * @attribute syn nta
   * @aspect Enums
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Enums.jrag:212
   */
  public Access getAccess() {
    if(getAccess_computed) {
      return (Access) getChild(getAccessChildPosition());
    }
    if(getAccess_computed) {
      return getAccess_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    getAccess_value = getAccess_compute();
      setAccess(getAccess_value);
    if (isFinal && num == state().boundariesCrossed) {
      getAccess_computed = true;
    } else {
    }

    Access node = (Access) this.getChild(getAccessChildPosition());
    return node;
  }
  /**
   * @apilevel internal
   */
  private Access getAccess_compute() {
      return hostType().createQualifiedAccess();
    }
  /**
   * @apilevel internal
   */
  protected boolean getArgList_computed = false;
  /**
   * @apilevel internal
   */
  protected List<Expr> getArgList_value;
  /**
   * @attribute syn nta
   * @aspect Enums
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Enums.jrag:216
   */
  public List<Expr> getArgList() {
    if(getArgList_computed) {
      return (List<Expr>) getChild(getArgListChildPosition());
    }
    if(getArgList_computed) {
      return getArgList_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    getArgList_value = getArgList_compute();
    setArgList(getArgList_value);
    if (isFinal && num == state().boundariesCrossed) {
      getArgList_computed = true;
    } else {
    }

    List<Expr> node = (List<Expr>) this.getChild(getArgListChildPosition());
    return node;
  }
  /**
   * @apilevel internal
   */
  private List<Expr> getArgList_compute() {
      EnumConstant ec = (EnumConstant)getParent().getParent();
      List<EnumConstant> ecs = (List<EnumConstant>)ec.getParent();
      int idx = ecs.getIndexOfChild(ec);
      if(idx == -1)
        throw new Error("internal: cannot determine numeric value of enum constant");
      List<Expr> argList = new List<Expr>();
      argList.add(Literal.buildStringLiteral(ec.name()));
      argList.add(Literal.buildIntegerLiteral(idx));
      for(Expr arg : ec.getArgs())
        argList.add((Expr)arg.fullCopy());
      return argList;
    }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {    return super.rewriteTo();
  }}
