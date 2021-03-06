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
 * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java5/grammar/Generics.ast:10
 * @production RawInterfaceDecl : {@link ParInterfaceDecl} ::= <span class="component">Argument:{@link Access}*</span>;

 */
public class RawInterfaceDecl extends ParInterfaceDecl implements Cloneable {
  /**
   * @aspect LookupParTypeDecl
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Generics.jrag:771
   */
  public Access substitute(Parameterization parTypeDecl) { return createBoundAccess(); }
  /**
   * @aspect LookupParTypeDecl
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Generics.jrag:826
   */
  public Access substituteReturnType(Parameterization parTypeDecl) { return createBoundAccess(); }
  /**
   * @aspect LookupParTypeDecl
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Generics.jrag:846
   */
  public Access substituteParameterType(Parameterization parTypeDecl) { return createBoundAccess(); }
  /**
   * @declaredat ASTNode:1
   */
  public RawInterfaceDecl() {
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
    setChild(new List(), 2);
    setChild(new List(), 3);
  }
  /**
   * @declaredat ASTNode:16
   */
  public RawInterfaceDecl(Modifiers p0, String p1) {
    setChild(p0, 0);
    setID(p1);
  }
  /**
   * @declaredat ASTNode:20
   */
  public RawInterfaceDecl(Modifiers p0, beaver.Symbol p1) {
    setChild(p0, 0);
    setID(p1);
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:27
   */
  protected int numChildren() {
    return 1;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:33
   */
  public boolean mayHaveRewrite() {
    return false;
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:39
   */
  public void flushCache() {
    super.flushCache();
    getArgumentList_computed = false;
    getArgumentList_value = null;
    subtype_TypeDecl_values = null;
    instanceOf_TypeDecl_values = null;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:49
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:55
   */
  public RawInterfaceDecl clone() throws CloneNotSupportedException {
    RawInterfaceDecl node = (RawInterfaceDecl) super.clone();
    node.getArgumentList_computed = false;
    node.getArgumentList_value = null;
    node.subtype_TypeDecl_values = null;
    node.instanceOf_TypeDecl_values = null;
    node.in$Circle(false);
    node.is$Final(false);
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:68
   */
  public RawInterfaceDecl copy() {
    try {
      RawInterfaceDecl node = (RawInterfaceDecl) clone();
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
   * @declaredat ASTNode:86
   */
  public RawInterfaceDecl fullCopy() {
    RawInterfaceDecl tree = (RawInterfaceDecl) copy();
    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
        switch (i) {
        case 1:
        case 2:
        case 3:
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
   * Replaces the lexeme ID.
   * @param value The new value for the lexeme ID.
   * @apilevel high-level
   */
  public void setID(String value) {
    tokenString_ID = value;
  }
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
   * Replaces the SuperInterface list.
   * @param list The new list node to be used as the SuperInterface list.
   * @apilevel high-level
   */
  public void setSuperInterfaceList(List<Access> list) {
    setChild(list, 1);
  }
  /**
   * Retrieves the number of children in the SuperInterface list.
   * @return Number of children in the SuperInterface list.
   * @apilevel high-level
   */
  public int getNumSuperInterface() {
    return getSuperInterfaceList().getNumChild();
  }
  /**
   * Retrieves the number of children in the SuperInterface list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the SuperInterface list.
   * @apilevel low-level
   */
  public int getNumSuperInterfaceNoTransform() {
    return getSuperInterfaceListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the SuperInterface list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the SuperInterface list.
   * @apilevel high-level
   */
  public Access getSuperInterface(int i) {
    return (Access) getSuperInterfaceList().getChild(i);
  }
  /**
   * Check whether the SuperInterface list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasSuperInterface() {
    return getSuperInterfaceList().getNumChild() != 0;
  }
  /**
   * Append an element to the SuperInterface list.
   * @param node The element to append to the SuperInterface list.
   * @apilevel high-level
   */
  public void addSuperInterface(Access node) {
    List<Access> list = (parent == null || state == null) ? getSuperInterfaceListNoTransform() : getSuperInterfaceList();
    list.addChild(node);
  }
  /**
   * @apilevel low-level
   */
  public void addSuperInterfaceNoTransform(Access node) {
    List<Access> list = getSuperInterfaceListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the SuperInterface list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setSuperInterface(Access node, int i) {
    List<Access> list = getSuperInterfaceList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the child position of the SuperInterface list.
   * @return The the child position of the SuperInterface list.
   * @apilevel low-level
   */
  protected int getSuperInterfaceListChildPosition() {
    return 1;
  }
  /**
   * Retrieves the SuperInterface list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the SuperInterface list.
   * @apilevel low-level
   */
  public List<Access> getSuperInterfaceListNoTransform() {
    return (List<Access>) getChildNoTransform(1);
  }
  /**
   * Retrieves the SuperInterface list.
   * @return The node representing the SuperInterface list.
   * @apilevel high-level
   */
  public List<Access> getSuperInterfaces() {
    return getSuperInterfaceList();
  }
  /**
   * Retrieves the SuperInterface list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the SuperInterface list.
   * @apilevel low-level
   */
  public List<Access> getSuperInterfacesNoTransform() {
    return getSuperInterfaceListNoTransform();
  }
  /**
   * Replaces the BodyDecl list.
   * @param list The new list node to be used as the BodyDecl list.
   * @apilevel high-level
   */
  public void setBodyDeclList(List<BodyDecl> list) {
    setChild(list, 2);
  }
  /**
   * Retrieves the number of children in the BodyDecl list.
   * @return Number of children in the BodyDecl list.
   * @apilevel high-level
   */
  public int getNumBodyDecl() {
    return getBodyDeclList().getNumChild();
  }
  /**
   * Retrieves the number of children in the BodyDecl list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the BodyDecl list.
   * @apilevel low-level
   */
  public int getNumBodyDeclNoTransform() {
    return getBodyDeclListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the BodyDecl list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the BodyDecl list.
   * @apilevel high-level
   */
  public BodyDecl getBodyDecl(int i) {
    return (BodyDecl) getBodyDeclList().getChild(i);
  }
  /**
   * Check whether the BodyDecl list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasBodyDecl() {
    return getBodyDeclList().getNumChild() != 0;
  }
  /**
   * Append an element to the BodyDecl list.
   * @param node The element to append to the BodyDecl list.
   * @apilevel high-level
   */
  public void addBodyDecl(BodyDecl node) {
    List<BodyDecl> list = (parent == null || state == null) ? getBodyDeclListNoTransform() : getBodyDeclList();
    list.addChild(node);
  }
  /**
   * @apilevel low-level
   */
  public void addBodyDeclNoTransform(BodyDecl node) {
    List<BodyDecl> list = getBodyDeclListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the BodyDecl list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setBodyDecl(BodyDecl node, int i) {
    List<BodyDecl> list = getBodyDeclList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the child position of the BodyDecl list.
   * @return The the child position of the BodyDecl list.
   * @apilevel low-level
   */
  protected int getBodyDeclListChildPosition() {
    return 2;
  }
  /**
   * Retrieves the BodyDecl list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the BodyDecl list.
   * @apilevel low-level
   */
  public List<BodyDecl> getBodyDeclListNoTransform() {
    return (List<BodyDecl>) getChildNoTransform(2);
  }
  /**
   * Retrieves the BodyDecl list.
   * @return The node representing the BodyDecl list.
   * @apilevel high-level
   */
  public List<BodyDecl> getBodyDecls() {
    return getBodyDeclList();
  }
  /**
   * Retrieves the BodyDecl list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the BodyDecl list.
   * @apilevel low-level
   */
  public List<BodyDecl> getBodyDeclsNoTransform() {
    return getBodyDeclListNoTransform();
  }
  /**
   * Replaces the Argument list.
   * @param list The new list node to be used as the Argument list.
   * @apilevel high-level
   */
  public void setArgumentList(List<Access> list) {
    setChild(list, 3);
  }
  /**
   * Retrieves the number of children in the Argument list.
   * @return Number of children in the Argument list.
   * @apilevel high-level
   */
  public int getNumArgument() {
    return getArgumentList().getNumChild();
  }
  /**
   * Retrieves the number of children in the Argument list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the Argument list.
   * @apilevel low-level
   */
  public int getNumArgumentNoTransform() {
    return getArgumentListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the Argument list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the Argument list.
   * @apilevel high-level
   */
  public Access getArgument(int i) {
    return (Access) getArgumentList().getChild(i);
  }
  /**
   * Check whether the Argument list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasArgument() {
    return getArgumentList().getNumChild() != 0;
  }
  /**
   * Append an element to the Argument list.
   * @param node The element to append to the Argument list.
   * @apilevel high-level
   */
  public void addArgument(Access node) {
    List<Access> list = (parent == null || state == null) ? getArgumentListNoTransform() : getArgumentList();
    list.addChild(node);
  }
  /**
   * @apilevel low-level
   */
  public void addArgumentNoTransform(Access node) {
    List<Access> list = getArgumentListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the Argument list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setArgument(Access node, int i) {
    List<Access> list = getArgumentList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the child position of the Argument list.
   * @return The the child position of the Argument list.
   * @apilevel low-level
   */
  protected int getArgumentListChildPosition() {
    return 3;
  }
  /**
   * Retrieves the Argument list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Argument list.
   * @apilevel low-level
   */
  public List<Access> getArgumentListNoTransform() {
    return (List<Access>) getChildNoTransform(3);
  }
  /**
   * Retrieves the Argument list.
   * @return The node representing the Argument list.
   * @apilevel high-level
   */
  public List<Access> getArguments() {
    return getArgumentList();
  }
  /**
   * Retrieves the Argument list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Argument list.
   * @apilevel low-level
   */
  public List<Access> getArgumentsNoTransform() {
    return getArgumentListNoTransform();
  }
  /**
   * @attribute syn
   * @aspect NestedTypes
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:577
   */
  public TypeDecl hostType() {
    ASTNode$State state = state();
    try {  return original();  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect Generics
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Generics.jrag:259
   */
  public boolean isRawType() {
    ASTNode$State state = state();
    try {  return true;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect LookupParTypeDecl
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Generics.jrag:590
   */
  public boolean sameSignature(Access a) {
    ASTNode$State state = state();
    try {  return a instanceof TypeAccess && a.type() == this;  }
    finally {
    }
  }
  /**
   * @apilevel internal
   */
  protected boolean getArgumentList_computed = false;
  /**
   * @apilevel internal
   */
  protected List getArgumentList_value;
  /**
   * @attribute syn nta
   * @aspect LookupParTypeDecl
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Generics.jrag:668
   */
  public List getArgumentList() {
    if(getArgumentList_computed) {
      return (List) getChild(getArgumentListChildPosition());
    }
    if(getArgumentList_computed) {
      return getArgumentList_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    getArgumentList_value = getArgumentList_compute();
    setArgumentList(getArgumentList_value);
    if (true) {
      getArgumentList_computed = true;
    } else {
    }

    List node = (List) this.getChild(getArgumentListChildPosition());
    return node;
  }
  /**
   * @apilevel internal
   */
  private List getArgumentList_compute() {  return ((GenericInterfaceDecl)genericDecl()).createArgumentList(new ArrayList());  }
  /**
   * @attribute syn
   * @aspect GenericsParTypeDecl
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/GenericsParTypeDecl.jrag:30
   */
  public String nameWithArgs() {
    ASTNode$State state = state();
    try {  return name();  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect GenericsSubtype
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/GenericsSubtype.jrag:20
   */
  public boolean supertypeGenericInterfaceDecl(GenericInterfaceDecl type) {
    ASTNode$State state = state();
    try {  return type.subtype(genericDecl().original());  }
    finally {
    }
  }
  protected java.util.Map subtype_TypeDecl_values;
  /**
   * @attribute syn
   * @aspect GenericsSubtype
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/GenericsSubtype.jrag:29
   */
  public boolean subtype(TypeDecl type) {
    Object _parameters = type;
    if (subtype_TypeDecl_values == null) subtype_TypeDecl_values = new org.jastadd.util.RobustMap(new java.util.HashMap());
    ASTNode$State.CircularValue _value;
    if(subtype_TypeDecl_values.containsKey(_parameters)) {
      Object _o = subtype_TypeDecl_values.get(_parameters);
      if(!(_o instanceof ASTNode$State.CircularValue)) {
        return ((Boolean)_o).booleanValue();
      } else {
        _value = (ASTNode$State.CircularValue) _o;
      }
    } else {
      _value = new ASTNode$State.CircularValue();
      subtype_TypeDecl_values.put(_parameters, _value);
      _value.value = Boolean.valueOf(true);
    }
    ASTNode$State state = state();
    if (!state.IN_CIRCLE) {
      state.IN_CIRCLE = true;
      int num = state.boundariesCrossed;
      boolean isFinal = this.is$Final();
      // TODO: fixme
      // state().CIRCLE_INDEX = 1;
      boolean new_subtype_TypeDecl_value;
      do {
        _value.visited = new Integer(state.CIRCLE_INDEX);
        state.CHANGE = false;
        new_subtype_TypeDecl_value = subtype_compute(type);
        if (new_subtype_TypeDecl_value != ((Boolean)_value.value).booleanValue()) {
          state.CHANGE = true;
          _value.value = Boolean.valueOf(new_subtype_TypeDecl_value);
        }
        state.CIRCLE_INDEX++;
      } while (state.CHANGE);
      if (isFinal && num == state().boundariesCrossed) {
        subtype_TypeDecl_values.put(_parameters, new_subtype_TypeDecl_value);
      } else {
        subtype_TypeDecl_values.remove(_parameters);
        state.RESET_CYCLE = true;
        subtype_compute(type);
        state.RESET_CYCLE = false;
      }
      state.IN_CIRCLE = false;
      return new_subtype_TypeDecl_value;
    }
    if (!new Integer(state.CIRCLE_INDEX).equals(_value.visited)) {
      _value.visited = new Integer(state.CIRCLE_INDEX);
      boolean new_subtype_TypeDecl_value = subtype_compute(type);
      if (state.RESET_CYCLE) {
        subtype_TypeDecl_values.remove(_parameters);
      }
      else if (new_subtype_TypeDecl_value != ((Boolean)_value.value).booleanValue()) {
        state.CHANGE = true;
        _value.value = new_subtype_TypeDecl_value;
      }
      return new_subtype_TypeDecl_value;
    }
    return ((Boolean)_value.value).booleanValue();
  }
  /**
   * @apilevel internal
   */
  private boolean subtype_compute(TypeDecl type) {  return type.supertypeRawInterfaceDecl(this);  }
  /**
   * @attribute syn
   * @aspect GenericsSubtype
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/GenericsSubtype.jrag:421
   */
  public boolean supertypeClassDecl(ClassDecl type) {
    ASTNode$State state = state();
    try {  return type.subtype(genericDecl().original());  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect GenericsSubtype
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/GenericsSubtype.jrag:439
   */
  public boolean supertypeInterfaceDecl(InterfaceDecl type) {
    ASTNode$State state = state();
    try {  return type.subtype(genericDecl().original());  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect GenericsSubtype
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/GenericsSubtype.jrag:129
   */
  public boolean supertypeParInterfaceDecl(ParInterfaceDecl type) {
    ASTNode$State state = state();
    try {  return type.genericDecl().original().subtype(genericDecl().original());  }
    finally {
    }
  }
  protected java.util.Map instanceOf_TypeDecl_values;
  /**
   * @attribute syn
   * @aspect GenericsSubtype
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/GenericsSubtype.jrag:399
   */
  public boolean instanceOf(TypeDecl type) {
    Object _parameters = type;
    if (instanceOf_TypeDecl_values == null) instanceOf_TypeDecl_values = new org.jastadd.util.RobustMap(new java.util.HashMap());
    if(instanceOf_TypeDecl_values.containsKey(_parameters)) {
      return ((Boolean)instanceOf_TypeDecl_values.get(_parameters)).booleanValue();
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    boolean instanceOf_TypeDecl_value = instanceOf_compute(type);
    if (isFinal && num == state().boundariesCrossed) {
      instanceOf_TypeDecl_values.put(_parameters, Boolean.valueOf(instanceOf_TypeDecl_value));
    } else {
    }

    return instanceOf_TypeDecl_value;
  }
  /**
   * @apilevel internal
   */
  private boolean instanceOf_compute(TypeDecl type) {  return subtype(type);  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {    return super.rewriteTo();
  }}
