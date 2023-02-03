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
 * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/grammar/Java.ast:6
 * @production PrimitiveCompilationUnit : {@link CompilationUnit};

 */
public class PrimitiveCompilationUnit extends CompilationUnit implements Cloneable {
  /**
   * @declaredat ASTNode:1
   */
  public PrimitiveCompilationUnit() {
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
    setChild(new List(), 1);
  }
  /**
   * @declaredat ASTNode:15
   */
  public PrimitiveCompilationUnit(String p0, List<ImportDecl> p1, List<TypeDecl> p2) {
    setPackageDecl(p0);
    setChild(p1, 0);
    setChild(p2, 1);
  }
  /**
   * @declaredat ASTNode:20
   */
  public PrimitiveCompilationUnit(beaver.Symbol p0, List<ImportDecl> p1, List<TypeDecl> p2) {
    setPackageDecl(p0);
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
    typeBoolean_computed = false;
    typeBoolean_value = null;
    typeByte_computed = false;
    typeByte_value = null;
    typeShort_computed = false;
    typeShort_value = null;
    typeChar_computed = false;
    typeChar_value = null;
    typeInt_computed = false;
    typeInt_value = null;
    typeLong_computed = false;
    typeLong_value = null;
    typeFloat_computed = false;
    typeFloat_value = null;
    typeDouble_computed = false;
    typeDouble_value = null;
    typeVoid_computed = false;
    typeVoid_value = null;
    typeNull_computed = false;
    typeNull_value = null;
    unknownType_computed = false;
    unknownType_value = null;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:68
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:74
   */
  public PrimitiveCompilationUnit clone() throws CloneNotSupportedException {
    PrimitiveCompilationUnit node = (PrimitiveCompilationUnit) super.clone();
    node.typeBoolean_computed = false;
    node.typeBoolean_value = null;
    node.typeByte_computed = false;
    node.typeByte_value = null;
    node.typeShort_computed = false;
    node.typeShort_value = null;
    node.typeChar_computed = false;
    node.typeChar_value = null;
    node.typeInt_computed = false;
    node.typeInt_value = null;
    node.typeLong_computed = false;
    node.typeLong_value = null;
    node.typeFloat_computed = false;
    node.typeFloat_value = null;
    node.typeDouble_computed = false;
    node.typeDouble_value = null;
    node.typeVoid_computed = false;
    node.typeVoid_value = null;
    node.typeNull_computed = false;
    node.typeNull_value = null;
    node.unknownType_computed = false;
    node.unknownType_value = null;
    node.in$Circle(false);
    node.is$Final(false);
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:105
   */
  public PrimitiveCompilationUnit copy() {
    try {
      PrimitiveCompilationUnit node = (PrimitiveCompilationUnit) clone();
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
   * @declaredat ASTNode:123
   */
  public PrimitiveCompilationUnit fullCopy() {
    PrimitiveCompilationUnit tree = (PrimitiveCompilationUnit) copy();
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
   * Replaces the lexeme PackageDecl.
   * @param value The new value for the lexeme PackageDecl.
   * @apilevel high-level
   */
  public void setPackageDecl(String value) {
    tokenString_PackageDecl = value;
  }
  /**
   * JastAdd-internal setter for lexeme PackageDecl using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme PackageDecl
   * @apilevel internal
   */
  public void setPackageDecl(beaver.Symbol symbol) {
    if(symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setPackageDecl is only valid for String lexemes");
    tokenString_PackageDecl = (String)symbol.value;
    PackageDeclstart = symbol.getStart();
    PackageDeclend = symbol.getEnd();
  }
  /**
   * Retrieves the value for the lexeme PackageDecl.
   * @return The value for the lexeme PackageDecl.
   * @apilevel high-level
   */
  public String getPackageDecl() {
    return tokenString_PackageDecl != null ? tokenString_PackageDecl : "";
  }
  /**
   * Replaces the ImportDecl list.
   * @param list The new list node to be used as the ImportDecl list.
   * @apilevel high-level
   */
  public void setImportDeclList(List<ImportDecl> list) {
    setChild(list, 0);
  }
  /**
   * Retrieves the number of children in the ImportDecl list.
   * @return Number of children in the ImportDecl list.
   * @apilevel high-level
   */
  public int getNumImportDecl() {
    return getImportDeclList().getNumChild();
  }
  /**
   * Retrieves the number of children in the ImportDecl list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the ImportDecl list.
   * @apilevel low-level
   */
  public int getNumImportDeclNoTransform() {
    return getImportDeclListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the ImportDecl list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the ImportDecl list.
   * @apilevel high-level
   */
  public ImportDecl getImportDecl(int i) {
    return (ImportDecl) getImportDeclList().getChild(i);
  }
  /**
   * Check whether the ImportDecl list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasImportDecl() {
    return getImportDeclList().getNumChild() != 0;
  }
  /**
   * Append an element to the ImportDecl list.
   * @param node The element to append to the ImportDecl list.
   * @apilevel high-level
   */
  public void addImportDecl(ImportDecl node) {
    List<ImportDecl> list = (parent == null || state == null) ? getImportDeclListNoTransform() : getImportDeclList();
    list.addChild(node);
  }
  /**
   * @apilevel low-level
   */
  public void addImportDeclNoTransform(ImportDecl node) {
    List<ImportDecl> list = getImportDeclListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the ImportDecl list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setImportDecl(ImportDecl node, int i) {
    List<ImportDecl> list = getImportDeclList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the ImportDecl list.
   * @return The node representing the ImportDecl list.
   * @apilevel high-level
   */
  public List<ImportDecl> getImportDeclList() {
    List<ImportDecl> list = (List<ImportDecl>) getChild(0);
    list.getNumChild();
    return list;
  }
  /**
   * Retrieves the ImportDecl list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the ImportDecl list.
   * @apilevel low-level
   */
  public List<ImportDecl> getImportDeclListNoTransform() {
    return (List<ImportDecl>) getChildNoTransform(0);
  }
  /**
   * Retrieves the ImportDecl list.
   * @return The node representing the ImportDecl list.
   * @apilevel high-level
   */
  public List<ImportDecl> getImportDecls() {
    return getImportDeclList();
  }
  /**
   * Retrieves the ImportDecl list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the ImportDecl list.
   * @apilevel low-level
   */
  public List<ImportDecl> getImportDeclsNoTransform() {
    return getImportDeclListNoTransform();
  }
  /**
   * Replaces the TypeDecl list.
   * @param list The new list node to be used as the TypeDecl list.
   * @apilevel high-level
   */
  public void setTypeDeclList(List<TypeDecl> list) {
    setChild(list, 1);
  }
  /**
   * Retrieves the number of children in the TypeDecl list.
   * @return Number of children in the TypeDecl list.
   * @apilevel high-level
   */
  public int getNumTypeDecl() {
    return getTypeDeclList().getNumChild();
  }
  /**
   * Retrieves the number of children in the TypeDecl list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the TypeDecl list.
   * @apilevel low-level
   */
  public int getNumTypeDeclNoTransform() {
    return getTypeDeclListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the TypeDecl list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the TypeDecl list.
   * @apilevel high-level
   */
  public TypeDecl getTypeDecl(int i) {
    return (TypeDecl) getTypeDeclList().getChild(i);
  }
  /**
   * Check whether the TypeDecl list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasTypeDecl() {
    return getTypeDeclList().getNumChild() != 0;
  }
  /**
   * Append an element to the TypeDecl list.
   * @param node The element to append to the TypeDecl list.
   * @apilevel high-level
   */
  public void addTypeDecl(TypeDecl node) {
    List<TypeDecl> list = (parent == null || state == null) ? getTypeDeclListNoTransform() : getTypeDeclList();
    list.addChild(node);
  }
  /**
   * @apilevel low-level
   */
  public void addTypeDeclNoTransform(TypeDecl node) {
    List<TypeDecl> list = getTypeDeclListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the TypeDecl list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setTypeDecl(TypeDecl node, int i) {
    List<TypeDecl> list = getTypeDeclList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the TypeDecl list.
   * @return The node representing the TypeDecl list.
   * @apilevel high-level
   */
  public List<TypeDecl> getTypeDeclList() {
    List<TypeDecl> list = (List<TypeDecl>) getChild(1);
    list.getNumChild();
    return list;
  }
  /**
   * Retrieves the TypeDecl list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the TypeDecl list.
   * @apilevel low-level
   */
  public List<TypeDecl> getTypeDeclListNoTransform() {
    return (List<TypeDecl>) getChildNoTransform(1);
  }
  /**
   * Retrieves the TypeDecl list.
   * @return The node representing the TypeDecl list.
   * @apilevel high-level
   */
  public List<TypeDecl> getTypeDecls() {
    return getTypeDeclList();
  }
  /**
   * Retrieves the TypeDecl list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the TypeDecl list.
   * @apilevel low-level
   */
  public List<TypeDecl> getTypeDeclsNoTransform() {
    return getTypeDeclListNoTransform();
  }
  /**
   * @apilevel internal
   */
  protected boolean typeBoolean_computed = false;
  /**
   * @apilevel internal
   */
  protected TypeDecl typeBoolean_value;
  /**
   * @attribute syn
   * @aspect PrimitiveTypes
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/PrimitiveTypes.jrag:13
   */
  public TypeDecl typeBoolean() {
    if(typeBoolean_computed) {
      return typeBoolean_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    typeBoolean_value = typeBoolean_compute();
    typeBoolean_value.setParent(this);
    typeBoolean_value.is$Final = true;
    if (true) {
      typeBoolean_computed = true;
    } else {
    }

    return typeBoolean_value;
  }
  /**
   * @apilevel internal
   */
  private TypeDecl typeBoolean_compute() {
      BooleanType type = new BooleanType();
      type.setModifiers(new Modifiers(new List().add(new Modifier("public"))));
      type.setID("boolean");
      type.setSuperClass(unknownType().createQualifiedAccess());
      return type;
    }
  /**
   * @apilevel internal
   */
  protected boolean typeByte_computed = false;
  /**
   * @apilevel internal
   */
  protected TypeDecl typeByte_value;
  /**
   * @attribute syn
   * @aspect PrimitiveTypes
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/PrimitiveTypes.jrag:20
   */
  public TypeDecl typeByte() {
    if(typeByte_computed) {
      return typeByte_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    typeByte_value = typeByte_compute();
    typeByte_value.setParent(this);
    typeByte_value.is$Final = true;
    if (true) {
      typeByte_computed = true;
    } else {
    }

    return typeByte_value;
  }
  /**
   * @apilevel internal
   */
  private TypeDecl typeByte_compute() {
      ByteType type = new ByteType();
      type.setModifiers(new Modifiers(new List().add(new Modifier("public"))));
      type.setID("byte");
      type.setSuperClass(typeShort().createQualifiedAccess());
      return type;
    }
  /**
   * @apilevel internal
   */
  protected boolean typeShort_computed = false;
  /**
   * @apilevel internal
   */
  protected TypeDecl typeShort_value;
  /**
   * @attribute syn
   * @aspect PrimitiveTypes
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/PrimitiveTypes.jrag:27
   */
  public TypeDecl typeShort() {
    if(typeShort_computed) {
      return typeShort_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    typeShort_value = typeShort_compute();
    typeShort_value.setParent(this);
    typeShort_value.is$Final = true;
    if (true) {
      typeShort_computed = true;
    } else {
    }

    return typeShort_value;
  }
  /**
   * @apilevel internal
   */
  private TypeDecl typeShort_compute() {
      ShortType type = new ShortType();
      type.setModifiers(new Modifiers(new List().add(new Modifier("public"))));
      type.setID("short");
      type.setSuperClass(typeInt().createQualifiedAccess());
      return type;
    }
  /**
   * @apilevel internal
   */
  protected boolean typeChar_computed = false;
  /**
   * @apilevel internal
   */
  protected TypeDecl typeChar_value;
  /**
   * @attribute syn
   * @aspect PrimitiveTypes
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/PrimitiveTypes.jrag:34
   */
  public TypeDecl typeChar() {
    if(typeChar_computed) {
      return typeChar_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    typeChar_value = typeChar_compute();
    typeChar_value.setParent(this);
    typeChar_value.is$Final = true;
    if (true) {
      typeChar_computed = true;
    } else {
    }

    return typeChar_value;
  }
  /**
   * @apilevel internal
   */
  private TypeDecl typeChar_compute() {
      CharType type = new CharType();
      type.setModifiers(new Modifiers(new List().add(new Modifier("public"))));
      type.setID("char");
      type.setSuperClass(typeInt().createQualifiedAccess());
      return type;
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
   * @attribute syn
   * @aspect PrimitiveTypes
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/PrimitiveTypes.jrag:41
   */
  public TypeDecl typeInt() {
    if(typeInt_computed) {
      return typeInt_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    typeInt_value = typeInt_compute();
    typeInt_value.setParent(this);
    typeInt_value.is$Final = true;
    if (true) {
      typeInt_computed = true;
    } else {
    }

    return typeInt_value;
  }
  /**
   * @apilevel internal
   */
  private TypeDecl typeInt_compute() {
      IntType type = new IntType();
      type.setModifiers(new Modifiers(new List().add(new Modifier("public"))));
      type.setID("int");
      type.setSuperClass(typeLong().createQualifiedAccess());
      return type;
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
   * @attribute syn
   * @aspect PrimitiveTypes
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/PrimitiveTypes.jrag:48
   */
  public TypeDecl typeLong() {
    if(typeLong_computed) {
      return typeLong_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    typeLong_value = typeLong_compute();
    typeLong_value.setParent(this);
    typeLong_value.is$Final = true;
    if (true) {
      typeLong_computed = true;
    } else {
    }

    return typeLong_value;
  }
  /**
   * @apilevel internal
   */
  private TypeDecl typeLong_compute() {
      LongType type = new LongType();
      type.setModifiers(new Modifiers(new List().add(new Modifier("public"))));
      type.setID("long");
      // Float doesn't seem right here, keeping it because the old code does this
      type.setSuperClass(typeFloat().createQualifiedAccess());
      return type;
    }
  /**
   * @apilevel internal
   */
  protected boolean typeFloat_computed = false;
  /**
   * @apilevel internal
   */
  protected TypeDecl typeFloat_value;
  /**
   * @attribute syn
   * @aspect PrimitiveTypes
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/PrimitiveTypes.jrag:56
   */
  public TypeDecl typeFloat() {
    if(typeFloat_computed) {
      return typeFloat_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    typeFloat_value = typeFloat_compute();
    typeFloat_value.setParent(this);
    typeFloat_value.is$Final = true;
    if (true) {
      typeFloat_computed = true;
    } else {
    }

    return typeFloat_value;
  }
  /**
   * @apilevel internal
   */
  private TypeDecl typeFloat_compute() {
      FloatType type = new FloatType();
      type.setModifiers(new Modifiers(new List().add(new Modifier("public"))));
      type.setID("float");
      type.setSuperClass(typeDouble().createQualifiedAccess());
      return type;
    }
  /**
   * @apilevel internal
   */
  protected boolean typeDouble_computed = false;
  /**
   * @apilevel internal
   */
  protected TypeDecl typeDouble_value;
  /**
   * @attribute syn
   * @aspect PrimitiveTypes
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/PrimitiveTypes.jrag:63
   */
  public TypeDecl typeDouble() {
    if(typeDouble_computed) {
      return typeDouble_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    typeDouble_value = typeDouble_compute();
    typeDouble_value.setParent(this);
    typeDouble_value.is$Final = true;
    if (true) {
      typeDouble_computed = true;
    } else {
    }

    return typeDouble_value;
  }
  /**
   * @apilevel internal
   */
  private TypeDecl typeDouble_compute() {
      DoubleType type = new DoubleType();
      type.setModifiers(new Modifiers(new List().add(new Modifier("public"))));
      type.setID("double");
      type.setSuperClass(unknownType().createQualifiedAccess());
      return type;
    }
  /**
   * @apilevel internal
   */
  protected boolean typeVoid_computed = false;
  /**
   * @apilevel internal
   */
  protected TypeDecl typeVoid_value;
  /**
   * @attribute syn
   * @aspect PrimitiveTypes
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/PrimitiveTypes.jrag:70
   */
  public TypeDecl typeVoid() {
    if(typeVoid_computed) {
      return typeVoid_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    typeVoid_value = typeVoid_compute();
    typeVoid_value.setParent(this);
    typeVoid_value.is$Final = true;
    if (true) {
      typeVoid_computed = true;
    } else {
    }

    return typeVoid_value;
  }
  /**
   * @apilevel internal
   */
  private TypeDecl typeVoid_compute() {
      VoidType classDecl = new VoidType();
      classDecl.setModifiers(new Modifiers(new List().add(new Modifier("public"))));
      classDecl.setID("void");
      return classDecl;
    }
  /**
   * @apilevel internal
   */
  protected boolean typeNull_computed = false;
  /**
   * @apilevel internal
   */
  protected TypeDecl typeNull_value;
  /**
   * @attribute syn
   * @aspect PrimitiveTypes
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/PrimitiveTypes.jrag:76
   */
  public TypeDecl typeNull() {
    if(typeNull_computed) {
      return typeNull_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    typeNull_value = typeNull_compute();
    typeNull_value.setParent(this);
    typeNull_value.is$Final = true;
    if (true) {
      typeNull_computed = true;
    } else {
    }

    return typeNull_value;
  }
  /**
   * @apilevel internal
   */
  private TypeDecl typeNull_compute() {
      NullType classDecl = new NullType();
      classDecl.setModifiers(new Modifiers(new List().add(new Modifier("public"))));
      classDecl.setID("null");
      return classDecl;
    }
  /**
   * @apilevel internal
   */
  protected boolean unknownType_computed = false;
  /**
   * @apilevel internal
   */
  protected TypeDecl unknownType_value;
  /**
   * @attribute syn
   * @aspect PrimitiveTypes
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/PrimitiveTypes.jrag:82
   */
  public TypeDecl unknownType() {
    if(unknownType_computed) {
      return unknownType_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    unknownType_value = unknownType_compute();
    unknownType_value.setParent(this);
    unknownType_value.is$Final = true;
    if (true) {
      unknownType_computed = true;
    } else {
    }

    return unknownType_value;
  }
  /**
   * @apilevel internal
   */
  private TypeDecl unknownType_compute() {
      ClassDecl classDecl = new UnknownType();
      classDecl.setModifiers(new Modifiers(new List().add(new Modifier("public"))));
      classDecl.setID("Unknown");
      MethodDecl methodDecl = new MethodDecl(
          new Modifiers(new List().add(
            new Modifier("public")
          )),
          new PrimitiveTypeAccess("Unknown"),
          "unknown",
          new List(),
          new List(),
          new Opt()
      );
      classDecl.addBodyDecl(methodDecl);
      FieldDeclaration fieldDecl = new FieldDeclaration(
          new Modifiers(new List().add(
            new Modifier("public")
          )),
          new PrimitiveTypeAccess("Unknown"),
          "unknown",
          new Opt()
      );
      classDecl.addBodyDecl(fieldDecl);
      ConstructorDecl constrDecl = new ConstructorDecl(
        new Modifiers(new List().add(new Modifier("public"))),
        "Unknown",
        new List(),
        new List(),
        new Opt(),
        new Block()
      );
      classDecl.addBodyDecl(constrDecl);
      return classDecl;
    }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {    return super.rewriteTo();
  }}
