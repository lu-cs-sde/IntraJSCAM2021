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
 * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/grammar/Java.ast:84
 * @production VariableDecl : {@link ASTNode} ::= <span class="component">&lt;ID:String&gt;</span> <span class="component">{@link Dims}*</span> <span class="component">[Init:{@link Expr}]</span>;

 */
public class VariableDecl extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @aspect VariableDeclarationTransformation
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/VariableDeclaration.jrag:182
   */
  public VariableDeclaration createVariableDeclarationFrom(Modifiers modifiers, Access type) {
    VariableDeclaration decl = new VariableDeclaration(
      modifiers,
      type.addArrayDims(getDimsList()),
      getID(),
      getInitOpt()
    );
    decl.setStart(start); // copy location information
    decl.setEnd(end); // copy location information
    decl.IDstart = IDstart;
    decl.IDend = IDend;
    return decl;
  }
  /**
   * @aspect VariableDeclarationTransformation
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/VariableDeclaration.jrag:196
   */
  public FieldDeclaration createFieldDeclarationFrom(Modifiers modifiers, Access type) {
    FieldDeclaration decl = new FieldDeclaration(
      modifiers,
      type.addArrayDims(getDimsList()),
      getID(),
      getInitOpt()
    );
    decl.setStart(start); // copy location information
    decl.setEnd(end); // copy location information
    decl.IDstart = IDstart;
    decl.IDend = IDend;
    return decl;
  }
  /**
   * @declaredat ASTNode:1
   */
  public VariableDecl() {
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
    setChild(new List(), 0);
    setChild(new Opt(), 1);
  }
  /**
   * @declaredat ASTNode:15
   */
  public VariableDecl(String p0, List<Dims> p1, Opt<Expr> p2) {
    setID(p0);
    setChild(p1, 0);
    setChild(p2, 1);
  }
  /**
   * @declaredat ASTNode:20
   */
  public VariableDecl(beaver.Symbol p0, List<Dims> p1, Opt<Expr> p2) {
    setID(p0);
    setChild(p1, 0);
    setChild(p2, 1);
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:28
   */
  protected int numChildren() {
    return 2;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:34
   */
  public boolean mayHaveRewrite() {
    return false;
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:40
   */
  public void flushCache() {
    super.flushCache();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:46
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:52
   */
  public VariableDecl clone() throws CloneNotSupportedException {
    VariableDecl node = (VariableDecl) super.clone();
    node.in$Circle(false);
    node.is$Final(false);
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:61
   */
  public VariableDecl copy() {
    try {
      VariableDecl node = (VariableDecl) clone();
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
   * @declaredat ASTNode:79
   */
  public VariableDecl fullCopy() {
    VariableDecl tree = (VariableDecl) copy();
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
   * Replaces the lexeme ID.
   * @param value The new value for the lexeme ID.
   * @apilevel high-level
   */
  public void setID(String value) {
    tokenString_ID = value;
  }
  /**
   * @apilevel internal
   */
  protected String tokenString_ID;
  /**
   */
  public int IDstart;
  /**
   */
  public int IDend;
  /**
   * JastAdd-internal setter for lexeme ID using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme ID
   * @apilevel internal
   */
  public void setID(beaver.Symbol symbol) {
    if(symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setID is only valid for String lexemes");
    tokenString_ID = (String)symbol.value;
    IDstart = symbol.getStart();
    IDend = symbol.getEnd();
  }
  /**
   * Retrieves the value for the lexeme ID.
   * @return The value for the lexeme ID.
   * @apilevel high-level
   */
  public String getID() {
    return tokenString_ID != null ? tokenString_ID : "";
  }
  /**
   * Replaces the Dims list.
   * @param list The new list node to be used as the Dims list.
   * @apilevel high-level
   */
  public void setDimsList(List<Dims> list) {
    setChild(list, 0);
  }
  /**
   * Retrieves the number of children in the Dims list.
   * @return Number of children in the Dims list.
   * @apilevel high-level
   */
  public int getNumDims() {
    return getDimsList().getNumChild();
  }
  /**
   * Retrieves the number of children in the Dims list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the Dims list.
   * @apilevel low-level
   */
  public int getNumDimsNoTransform() {
    return getDimsListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the Dims list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the Dims list.
   * @apilevel high-level
   */
  public Dims getDims(int i) {
    return (Dims) getDimsList().getChild(i);
  }
  /**
   * Check whether the Dims list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasDims() {
    return getDimsList().getNumChild() != 0;
  }
  /**
   * Append an element to the Dims list.
   * @param node The element to append to the Dims list.
   * @apilevel high-level
   */
  public void addDims(Dims node) {
    List<Dims> list = (parent == null || state == null) ? getDimsListNoTransform() : getDimsList();
    list.addChild(node);
  }
  /**
   * @apilevel low-level
   */
  public void addDimsNoTransform(Dims node) {
    List<Dims> list = getDimsListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the Dims list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setDims(Dims node, int i) {
    List<Dims> list = getDimsList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the Dims list.
   * @return The node representing the Dims list.
   * @apilevel high-level
   */
  public List<Dims> getDimsList() {
    List<Dims> list = (List<Dims>) getChild(0);
    list.getNumChild();
    return list;
  }
  /**
   * Retrieves the Dims list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Dims list.
   * @apilevel low-level
   */
  public List<Dims> getDimsListNoTransform() {
    return (List<Dims>) getChildNoTransform(0);
  }
  /**
   * Retrieves the Dims list.
   * @return The node representing the Dims list.
   * @apilevel high-level
   */
  public List<Dims> getDimss() {
    return getDimsList();
  }
  /**
   * Retrieves the Dims list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Dims list.
   * @apilevel low-level
   */
  public List<Dims> getDimssNoTransform() {
    return getDimsListNoTransform();
  }
  /**
   * Replaces the optional node for the Init child. This is the <code>Opt</code>
   * node containing the child Init, not the actual child!
   * @param opt The new node to be used as the optional node for the Init child.
   * @apilevel low-level
   */
  public void setInitOpt(Opt<Expr> opt) {
    setChild(opt, 1);
  }
  /**
   * Replaces the (optional) Init child.
   * @param node The new node to be used as the Init child.
   * @apilevel high-level
   */
  public void setInit(Expr node) {
    getInitOpt().setChild(node, 0);
  }
  /**
   * Check whether the optional Init child exists.
   * @return {@code true} if the optional Init child exists, {@code false} if it does not.
   * @apilevel high-level
   */
  public boolean hasInit() {
    return getInitOpt().getNumChild() != 0;
  }
  /**
   * Retrieves the (optional) Init child.
   * @return The Init child, if it exists. Returns {@code null} otherwise.
   * @apilevel low-level
   */
  public Expr getInit() {
    return (Expr) getInitOpt().getChild(0);
  }
  /**
   * Retrieves the optional node for the Init child. This is the <code>Opt</code> node containing the child Init, not the actual child!
   * @return The optional node for child the Init child.
   * @apilevel low-level
   */
  public Opt<Expr> getInitOpt() {
    return (Opt<Expr>) getChild(1);
  }
  /**
   * Retrieves the optional node for child Init. This is the <code>Opt</code> node containing the child Init, not the actual child!
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The optional node for child Init.
   * @apilevel low-level
   */
  public Opt<Expr> getInitOptNoTransform() {
    return (Opt<Expr>) getChildNoTransform(1);
  }
  /**
   * @attribute syn
   * @aspect Variables
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/VariableDeclaration.jrag:84
   */
  public String name() {
    ASTNode$State state = state();
    try {  return getID();  }
    finally {
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DefiniteAssignment.jrag:41
   * @apilevel internal
   */
  public boolean Define_boolean_isSource(ASTNode caller, ASTNode child) {
    if (caller == getInitOptNoTransform()) {
      return true;
    }
    else {
      return getParent().Define_boolean_isSource(this, caller);
    }
  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {    return super.rewriteTo();
  }}
