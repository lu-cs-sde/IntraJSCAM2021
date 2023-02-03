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
 * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/grammar/Java.ast:4
 * @production CompilationUnit : {@link ASTNode} ::= <span class="component">&lt;PackageDecl:String&gt;</span> <span class="component">{@link ImportDecl}*</span> <span class="component">{@link TypeDecl}*</span>;

 */
public class CompilationUnit extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @aspect ClassPath
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ClassPath.jrag:378
   */
  private ClassSource classSource = ClassSource.NONE;
  /**
   * @aspect ClassPath
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ClassPath.jrag:379
   */
  private boolean fromSource = false;
  /**
   * @aspect ClassPath
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ClassPath.jrag:381
   */
  public void setClassSource(ClassSource source) {
    this.classSource = source;
  }
  /**
   * @aspect ClassPath
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ClassPath.jrag:384
   */
  public ClassSource getClassSource() {
    return classSource;
  }
  /**
   * @aspect ClassPath
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ClassPath.jrag:387
   */
  public void setFromSource(boolean value) {
    this.fromSource = value;
  }
  /**
   * @aspect ErrorCheck
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ErrorCheck.jrag:79
   */
  protected
  java.util.ArrayList errors = new java.util.ArrayList();
  /**
   * @aspect ErrorCheck
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ErrorCheck.jrag:81
   */
  protected
  java.util.ArrayList warnings = new java.util.ArrayList();
  /**
   * @aspect ErrorCheck
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ErrorCheck.jrag:84
   */
  public
  Collection parseErrors() { return parseErrors; }
  /**
   * @aspect ErrorCheck
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ErrorCheck.jrag:86
   */
  public
  void addParseError(Problem msg) { parseErrors.add(msg); }
  /**
   * @aspect ErrorCheck
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ErrorCheck.jrag:88
   */
  protected
  Collection parseErrors = new ArrayList();
  /**
   * @aspect ErrorCheck
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ErrorCheck.jrag:301
   */
  public
  void errorCheck(Collection collection) {
    collectErrors();
    collection.addAll(errors);
  }
  /**
   * @aspect ErrorCheck
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ErrorCheck.jrag:306
   */
  public
  void errorCheck(Collection err, Collection warn) {
    collectErrors();
    err.addAll(errors);
    warn.addAll(warnings);
  }
  /**
   * @aspect NameCheck
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/NameCheck.jrag:56
   */
  public void refined_NameCheck_CompilationUnit_nameCheck() {
    for (int i = 0; i < getNumImportDecl(); i++) {
      ImportDecl decl = getImportDecl(i);
      if (decl instanceof SingleTypeImportDecl) {
        TypeDecl importedType = decl.getAccess().type();
        Iterator iter = localLookupType(importedType.name()).iterator();
        while (iter.hasNext()) {
          TypeDecl local = (TypeDecl) iter.next();
          if (local != importedType) {
            error("imported type " + decl.typeName() +
                " conflicts with visible type");
          }
        }
      }
    }
  }
  /**
   * @aspect PrettyPrint
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/PrettyPrint.jadd:48
   */
  public void prettyPrint(StringBuffer sb) {
    try {
      if (!getPackageDecl().equals("")) {
        sb.append("package " + getPackageDecl() + ";\n");
      }
      for (int i = 0; i < getNumImportDecl(); i++) {
        getImportDecl(i).prettyPrint(sb);
      }
      for (int i = 0; i < getNumTypeDecl(); i++) {
        getTypeDecl(i).prettyPrint(sb);
        sb.append("\n");
      }
    } catch (NullPointerException e) {
      System.out.print("Error in compilation unit hosting " + getTypeDecl(0).typeName());
      throw e;
    }
  }
  /**
   * @declaredat ASTNode:1
   */
  public CompilationUnit() {
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
  public CompilationUnit(String p0, List<ImportDecl> p1, List<TypeDecl> p2) {
    setPackageDecl(p0);
    setChild(p1, 0);
    setChild(p2, 1);
  }
  /**
   * @declaredat ASTNode:20
   */
  public CompilationUnit(beaver.Symbol p0, List<ImportDecl> p1, List<TypeDecl> p2) {
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
    packageName_computed = false;
    packageName_value = null;
    lookupType_String_values = null;
    CompilationUnit_candidates_computed = false;
    CompilationUnit_candidates_value = null;
        CompilationUnit_candidates_contributors = null;
    CompilationUnit_allAssigns_computed = false;
    CompilationUnit_allAssigns_value = null;
        CompilationUnit_allAssigns_contributors = null;
    CompilationUnit_descendingBodyDecls_computed = false;
    CompilationUnit_descendingBodyDecls_value = null;
        CompilationUnit_descendingBodyDecls_contributors = null;
    CompilationUnit_methods_computed = false;
    CompilationUnit_methods_value = null;
        CompilationUnit_methods_contributors = null;
    CompilationUnit_deadAssignments_computed = false;
    CompilationUnit_deadAssignments_value = null;
        CompilationUnit_deadAssignments_contributors = null;
        collect_contributors_CompilationUnit_candidates = false;
        collect_contributors_CompilationUnit_allAssigns = false;
        collect_contributors_CompilationUnit_descendingBodyDecls = false;
        collect_contributors_CompilationUnit_methods = false;
        collect_contributors_CompilationUnit_deadAssignments = false;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:69
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
    CompilationUnit_candidates_computed = false;
    CompilationUnit_candidates_value = null;
        CompilationUnit_candidates_contributors = null;
    CompilationUnit_allAssigns_computed = false;
    CompilationUnit_allAssigns_value = null;
        CompilationUnit_allAssigns_contributors = null;
    CompilationUnit_descendingBodyDecls_computed = false;
    CompilationUnit_descendingBodyDecls_value = null;
        CompilationUnit_descendingBodyDecls_contributors = null;
    CompilationUnit_methods_computed = false;
    CompilationUnit_methods_value = null;
        CompilationUnit_methods_contributors = null;
    CompilationUnit_deadAssignments_computed = false;
    CompilationUnit_deadAssignments_value = null;
        CompilationUnit_deadAssignments_contributors = null;
        collect_contributors_CompilationUnit_candidates = false;
        collect_contributors_CompilationUnit_allAssigns = false;
        collect_contributors_CompilationUnit_descendingBodyDecls = false;
        collect_contributors_CompilationUnit_methods = false;
        collect_contributors_CompilationUnit_deadAssignments = false;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:95
   */
  public CompilationUnit clone() throws CloneNotSupportedException {
    CompilationUnit node = (CompilationUnit) super.clone();
    node.packageName_computed = false;
    node.packageName_value = null;
    node.lookupType_String_values = null;
    node.in$Circle(false);
    node.is$Final(false);
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:107
   */
  public CompilationUnit copy() {
    try {
      CompilationUnit node = (CompilationUnit) clone();
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
   * @declaredat ASTNode:125
   */
  public CompilationUnit fullCopy() {
    CompilationUnit tree = (CompilationUnit) copy();
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
   * @apilevel internal
   */
  protected String tokenString_PackageDecl;
  /**
   */
  public int PackageDeclstart;
  /**
   */
  public int PackageDeclend;
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
   * @aspect StaticImports
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/StaticImports.jrag:195
   */
    public void nameCheck() {
    refined_NameCheck_CompilationUnit_nameCheck();
    for(int i = 0; i < getNumImportDecl(); i++) {
      if(getImportDecl(i) instanceof SingleStaticImportDecl) {
        SingleStaticImportDecl decl = (SingleStaticImportDecl)getImportDecl(i);
        String name = decl.name();
        if(!decl.importedTypes(name).isEmpty()) {
          TypeDecl type = (TypeDecl)decl.importedTypes(name).iterator().next();
          if(localLookupType(name).contains(type))
            decl.error(packageName() + "." + name + " is already defined in this compilation unit");
        }
      }
    }
  }
  /**
   * @aspect TypeScopePropagation
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:236
   */
  private SimpleSet refined_TypeScopePropagation_CompilationUnit_Child_lookupType_String(String name)
{
    // locally declared types in compilation unit
    SimpleSet set = localLookupType(name);
    if(!set.isEmpty()) return set;

    // imported types
    set = importedTypes(name);
    if(!set.isEmpty()) return set;

    // types in the same package
    TypeDecl result = lookupType(packageName(), name);
    if(result != null && result.accessibleFromPackage(packageName()))
      return SimpleSet.emptySet.add(result);

    // types imported on demand
    set = importedTypesOnDemand(name);
    if(!set.isEmpty()) return set;

    // include primitive types
    result = lookupType(PRIMITIVE_PACKAGE_NAME, name);
    if(result != null) return SimpleSet.emptySet.add(result);

    // 7.5.5 Automatic Imports
    result = lookupType("java.lang", name);
    if(result != null && result.accessibleFromPackage(packageName()))
      return SimpleSet.emptySet.add(result);
    return lookupType(name);
  }
  /**
   * @aspect <NoAspect>
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/Candidates.jrag:4
   */
    private boolean collect_contributors_CompilationUnit_candidates = false;
  protected void collect_contributors_CompilationUnit_candidates() {
    if(collect_contributors_CompilationUnit_candidates) return;
    super.collect_contributors_CompilationUnit_candidates();
    collect_contributors_CompilationUnit_candidates = true;
  }

  /**
   * @aspect <NoAspect>
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/CollectAssigns.jrag:4
   */
    private boolean collect_contributors_CompilationUnit_allAssigns = false;
  protected void collect_contributors_CompilationUnit_allAssigns() {
    if(collect_contributors_CompilationUnit_allAssigns) return;
    super.collect_contributors_CompilationUnit_allAssigns();
    collect_contributors_CompilationUnit_allAssigns = true;
  }

  /**
   * @aspect <NoAspect>
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/CollectAssigns.jrag:32
   */
    private boolean collect_contributors_CompilationUnit_descendingBodyDecls = false;
  protected void collect_contributors_CompilationUnit_descendingBodyDecls() {
    if(collect_contributors_CompilationUnit_descendingBodyDecls) return;
    super.collect_contributors_CompilationUnit_descendingBodyDecls();
    collect_contributors_CompilationUnit_descendingBodyDecls = true;
  }

  /**
   * @aspect <NoAspect>
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/Helpers.jrag:63
   */
    private boolean collect_contributors_CompilationUnit_methods = false;
  protected void collect_contributors_CompilationUnit_methods() {
    if(collect_contributors_CompilationUnit_methods) return;
    super.collect_contributors_CompilationUnit_methods();
    collect_contributors_CompilationUnit_methods = true;
  }

  /**
   * @aspect <NoAspect>
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/JavaDeadAssigns.jrag:15
   */
    private boolean collect_contributors_CompilationUnit_deadAssignments = false;
  protected void collect_contributors_CompilationUnit_deadAssignments() {
    if(collect_contributors_CompilationUnit_deadAssignments) return;
    super.collect_contributors_CompilationUnit_deadAssignments();
    collect_contributors_CompilationUnit_deadAssignments = true;
  }

  /**
   * @return The path to the source file, or the path to the file inside a Jar
   * file.
   * @attribute syn
   * @aspect ClassPath
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ClassPath.jrag:40
   */
  public String relativeName() {
    ASTNode$State state = state();
    try {  return getClassSource().relativeName();  }
    finally {
    }
  }
  /**
   * @return The path to the source file, or the enclosing Jar file.
   * @attribute syn
   * @aspect ClassPath
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ClassPath.jrag:45
   */
  public String pathName() {
    ASTNode$State state = state();
    try {  return getClassSource().pathName();  }
    finally {
    }
  }
  /**
   * @return {@code true} if this compilation unit was parsed from source.
   * @attribute syn
   * @aspect ClassPath
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ClassPath.jrag:50
   */
  public boolean fromSource() {
    ASTNode$State state = state();
    try {  return fromSource;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect TypeScopePropagation
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:265
   */
  public SimpleSet localLookupType(String name) {
    ASTNode$State state = state();
    try {
        for(int i = 0; i < getNumTypeDecl(); i++)
          if(getTypeDecl(i).name().equals(name))
            return SimpleSet.emptySet.add(getTypeDecl(i));
        return SimpleSet.emptySet;
      }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect TypeScopePropagation
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:272
   */
  public SimpleSet importedTypes(String name) {
    ASTNode$State state = state();
    try {
        SimpleSet set = SimpleSet.emptySet;
        for(int i = 0; i < getNumImportDecl(); i++)
          if(!getImportDecl(i).isOnDemand())
            for(Iterator iter = getImportDecl(i).importedTypes(name).iterator(); iter.hasNext(); )
              set = set.add(iter.next());
        return set;
      }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect TypeScopePropagation
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:280
   */
  public SimpleSet importedTypesOnDemand(String name) {
    ASTNode$State state = state();
    try {
        SimpleSet set = SimpleSet.emptySet;
        for(int i = 0; i < getNumImportDecl(); i++)
          if(getImportDecl(i).isOnDemand())
            for(Iterator iter = getImportDecl(i).importedTypes(name).iterator(); iter.hasNext(); )
              set = set.add(iter.next());
        return set;
      }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect PrettyPrint
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/PrettyPrint.jadd:821
   */
  public String dumpString() {
    ASTNode$State state = state();
    try {  return getClass().getName() + " [" + getPackageDecl() + "]";  }
    finally {
    }
  }
  /**
   * @apilevel internal
   */
  protected boolean packageName_computed = false;
  /**
   * @apilevel internal
   */
  protected String packageName_value;
  /**
   * @attribute syn
   * @aspect TypeName
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/QualifiedNames.jrag:93
   */
  public String packageName() {
    if(packageName_computed) {
      return packageName_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    packageName_value = packageName_compute();
    if (isFinal && num == state().boundariesCrossed) {
      packageName_computed = true;
    } else {
    }

    return packageName_value;
  }
  /**
   * @apilevel internal
   */
  private String packageName_compute() {return getPackageDecl();}
  /**
   * @attribute syn
   * @aspect StaticImports
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/StaticImports.jrag:126
   */
  public SimpleSet importedFields(String name) {
    ASTNode$State state = state();
    try {
        SimpleSet set = SimpleSet.emptySet;
        for(int i = 0; i < getNumImportDecl(); i++)
          if(!getImportDecl(i).isOnDemand())
            for(Iterator iter = getImportDecl(i).importedFields(name).iterator(); iter.hasNext(); )
              set = set.add(iter.next());
        return set;
      }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect StaticImports
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/StaticImports.jrag:134
   */
  public SimpleSet importedFieldsOnDemand(String name) {
    ASTNode$State state = state();
    try {
        SimpleSet set = SimpleSet.emptySet;
        for(int i = 0; i < getNumImportDecl(); i++)
          if(getImportDecl(i).isOnDemand())
            for(Iterator iter = getImportDecl(i).importedFields(name).iterator(); iter.hasNext(); )
              set = set.add(iter.next());
        return set;
      }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect StaticImports
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/StaticImports.jrag:155
   */
  public Collection importedMethods(String name) {
    ASTNode$State state = state();
    try {
        Collection list = new ArrayList();
        for(int i = 0; i < getNumImportDecl(); i++)
          if(!getImportDecl(i).isOnDemand())
            list.addAll(getImportDecl(i).importedMethods(name));
        return list;
      }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect StaticImports
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/StaticImports.jrag:162
   */
  public Collection importedMethodsOnDemand(String name) {
    ASTNode$State state = state();
    try {
        Collection list = new ArrayList();
        for(int i = 0; i < getNumImportDecl(); i++)
          if(getImportDecl(i).isOnDemand())
            list.addAll(getImportDecl(i).importedMethods(name));
        return list;
      }
    finally {
    }
  }
  /**
   * @attribute inh
   * @aspect LookupFullyQualifiedTypes
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:102
   */
  public TypeDecl lookupType(String packageName, String typeName) {
    ASTNode$State state = state();
    TypeDecl lookupType_String_String_value = getParent().Define_TypeDecl_lookupType(this, null, packageName, typeName);

    return lookupType_String_String_value;
  }
  /**
   * @attribute inh
   * @aspect TypeScopePropagation
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:225
   */
  public SimpleSet lookupType(String name) {
    Object _parameters = name;
    if (lookupType_String_values == null) lookupType_String_values = new org.jastadd.util.RobustMap(new java.util.HashMap());
    if(lookupType_String_values.containsKey(_parameters)) {
      return (SimpleSet)lookupType_String_values.get(_parameters);
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    SimpleSet lookupType_String_value = getParent().Define_SimpleSet_lookupType(this, null, name);
    if (isFinal && num == state().boundariesCrossed) {
      lookupType_String_values.put(_parameters, lookupType_String_value);
    } else {
    }

    return lookupType_String_value;
  }
  protected java.util.Map lookupType_String_values;
  /**
   * @attribute inh
   * @aspect StaticImports
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/StaticImports.jrag:125
   */
  public SimpleSet lookupVariable(String name) {
    ASTNode$State state = state();
    SimpleSet lookupVariable_String_value = getParent().Define_SimpleSet_lookupVariable(this, null, name);

    return lookupVariable_String_value;
  }
  /**
   * @attribute inh
   * @aspect StaticImports
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/StaticImports.jrag:154
   */
  public Collection lookupMethod(String name) {
    ASTNode$State state = state();
    Collection lookupMethod_String_value = getParent().Define_Collection_lookupMethod(this, null, name);

    return lookupMethod_String_value;
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ClassPath.jrag:53
   * @apilevel internal
   */
  public CompilationUnit Define_CompilationUnit_compilationUnit(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return this;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DefiniteAssignment.jrag:51
   * @apilevel internal
   */
  public boolean Define_boolean_isIncOrDec(ASTNode caller, ASTNode child) {
    if (caller == getTypeDeclListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
      return false;
    }
    else {
      return getParent().Define_boolean_isIncOrDec(this, caller);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/StaticImports.jrag:212
   * @apilevel internal
   */
  public boolean Define_boolean_handlesException(ASTNode caller, ASTNode child, TypeDecl exceptionType) {
    if (caller == getImportDeclListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
      {
    return !exceptionType.isUncheckedException();
  }
    }
    else if (caller == getTypeDeclListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
      return !exceptionType.isUncheckedException();
    }
    else {
      return getParent().Define_boolean_handlesException(this, caller, exceptionType);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:321
   * @apilevel internal
   */
  public SimpleSet Define_SimpleSet_lookupType(ASTNode caller, ASTNode child, String name) {
    if (caller == getImportDeclListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
      return lookupType(name);
    }
    else  {
      int childIndex = this.getIndexOfChild(caller);
{
    SimpleSet result = SimpleSet.emptySet;
    for(Iterator iter = refined_TypeScopePropagation_CompilationUnit_Child_lookupType_String(name).iterator(); iter.hasNext(); ) {
      TypeDecl typeDecl = (TypeDecl)iter.next();
      if(typeDecl instanceof ParTypeDecl)
        result = result.add(((ParTypeDecl)typeDecl).genericDecl());
      else
        result = result.add(typeDecl);
    }
    return result;
  }
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/NameCheck.jrag:48
   * @apilevel internal
   */
  public SimpleSet Define_SimpleSet_allImportedTypes(ASTNode caller, ASTNode child, String name) {
    if (caller == getImportDeclListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
      return importedTypes(name);
    }
    else {
      return getParent().Define_SimpleSet_allImportedTypes(this, caller, name);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/QualifiedNames.jrag:91
   * @apilevel internal
   */
  public String Define_String_packageName(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return packageName();
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/SyntacticClassification.jrag:69
   * @apilevel internal
   */
  public NameType Define_NameType_nameType(ASTNode caller, ASTNode child) {
    if (caller == getImportDeclListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
      return NameType.PACKAGE_NAME;
    }
    else {
      return getParent().Define_NameType_nameType(this, caller);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:498
   * @apilevel internal
   */
  public TypeDecl Define_TypeDecl_enclosingType(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return null;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:527
   * @apilevel internal
   */
  public boolean Define_boolean_isNestedType(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return false;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:537
   * @apilevel internal
   */
  public boolean Define_boolean_isMemberType(ASTNode caller, ASTNode child) {
    if (caller == getTypeDeclListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
      return false;
    }
    else {
      return getParent().Define_boolean_isMemberType(this, caller);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:549
   * @apilevel internal
   */
  public boolean Define_boolean_isLocalClass(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return false;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:571
   * @apilevel internal
   */
  public String Define_String_hostPackage(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return packageName();
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:588
   * @apilevel internal
   */
  public TypeDecl Define_TypeDecl_hostType(ASTNode caller, ASTNode child) {
    if (caller == getImportDeclListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
      return null;
    }
    else {
      return getParent().Define_TypeDecl_hostType(this, caller);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/StaticImports.jrag:118
   * @apilevel internal
   */
  public SimpleSet Define_SimpleSet_lookupVariable(ASTNode caller, ASTNode child, String name) {
    if (caller == getTypeDeclListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
      {
    SimpleSet set = importedFields(name);
    if(!set.isEmpty()) return set;
    set = importedFieldsOnDemand(name);
    if(!set.isEmpty()) return set;
    return lookupVariable(name);
  }
    }
    else {
      return getParent().Define_SimpleSet_lookupVariable(this, caller, name);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/StaticImports.jrag:147
   * @apilevel internal
   */
  public Collection Define_Collection_lookupMethod(ASTNode caller, ASTNode child, String name) {
    if (caller == getTypeDeclListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
      {
    Collection list = importedMethods(name);
    if(!list.isEmpty()) return list;
    list = importedMethodsOnDemand(name);
    if(!list.isEmpty()) return list;
    return lookupMethod(name);
  }
    }
    else {
      return getParent().Define_Collection_lookupMethod(this, caller, name);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/Helpers.jrag:68
   * @apilevel internal
   */
  public CompilationUnit Define_CompilationUnit_getCompUnit(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return this;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/JavaDeadAssigns.jrag:6
   * @apilevel internal
   */
  public CompilationUnit Define_CompilationUnit_enclosingCompilationUnit(ASTNode caller, ASTNode child) {
     {
      int i = this.getIndexOfChild(caller);
      return this;
    }
  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {    return super.rewriteTo();
  }  /**
   * @attribute coll
   * @aspect Candidates
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/Candidates.jrag:4
   */
  public SmallSet<CFGNode> candidates() {
    if(CompilationUnit_candidates_computed) {
      return CompilationUnit_candidates_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    CompilationUnit_candidates_value = candidates_compute();
    if (isFinal && num == state().boundariesCrossed) {
      CompilationUnit_candidates_computed = true;
    } else {
    }

    return CompilationUnit_candidates_value;
  }
  java.util.Set CompilationUnit_candidates_contributors;

  /**
   * @apilevel internal
   * @return the contributor set for candidates
   */
  public java.util.Set CompilationUnit_candidates_contributors() {
    if(CompilationUnit_candidates_contributors == null)
      CompilationUnit_candidates_contributors  = new ASTNode$State.IdentityHashSet(4);
    return CompilationUnit_candidates_contributors;
  }

  /**
   * @apilevel internal
   */
  private SmallSet<CFGNode> candidates_compute() {
    ASTNode node = this;
    while(node.getParent() != null && !(node instanceof CompilationUnit)) {
      node = node.getParent();
    }
    CompilationUnit root = (CompilationUnit) node;
    root.collect_contributors_CompilationUnit_candidates();
    CompilationUnit_candidates_value = SmallSet.mutable();
    if(CompilationUnit_candidates_contributors != null)
    for (java.util.Iterator iter = CompilationUnit_candidates_contributors.iterator(); iter.hasNext(); ) {
      ASTNode contributor = (ASTNode) iter.next();
      contributor.contributeTo_CompilationUnit_CompilationUnit_candidates(CompilationUnit_candidates_value);
    }
    // TODO: disabled temporarily since collections may not be cached
    //CompilationUnit_candidates_contributors = null;
    return CompilationUnit_candidates_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean CompilationUnit_candidates_computed = false;
  /**
   * @apilevel internal
   */
  protected SmallSet<CFGNode> CompilationUnit_candidates_value;
  /**
   * @attribute coll
   * @aspect CollectAssigns
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/CollectAssigns.jrag:4
   */
  public SmallSet<Stmt> allAssigns() {
    if(CompilationUnit_allAssigns_computed) {
      return CompilationUnit_allAssigns_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    CompilationUnit_allAssigns_value = allAssigns_compute();
    if (isFinal && num == state().boundariesCrossed) {
      CompilationUnit_allAssigns_computed = true;
    } else {
    }

    return CompilationUnit_allAssigns_value;
  }
  java.util.Set CompilationUnit_allAssigns_contributors;

  /**
   * @apilevel internal
   * @return the contributor set for allAssigns
   */
  public java.util.Set CompilationUnit_allAssigns_contributors() {
    if(CompilationUnit_allAssigns_contributors == null)
      CompilationUnit_allAssigns_contributors  = new ASTNode$State.IdentityHashSet(4);
    return CompilationUnit_allAssigns_contributors;
  }

  /**
   * @apilevel internal
   */
  private SmallSet<Stmt> allAssigns_compute() {
    ASTNode node = this;
    while(node.getParent() != null && !(node instanceof CompilationUnit)) {
      node = node.getParent();
    }
    CompilationUnit root = (CompilationUnit) node;
    root.collect_contributors_CompilationUnit_allAssigns();
    CompilationUnit_allAssigns_value = SmallSet.mutable();
    if(CompilationUnit_allAssigns_contributors != null)
    for (java.util.Iterator iter = CompilationUnit_allAssigns_contributors.iterator(); iter.hasNext(); ) {
      ASTNode contributor = (ASTNode) iter.next();
      contributor.contributeTo_CompilationUnit_CompilationUnit_allAssigns(CompilationUnit_allAssigns_value);
    }
    // TODO: disabled temporarily since collections may not be cached
    //CompilationUnit_allAssigns_contributors = null;
    return CompilationUnit_allAssigns_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean CompilationUnit_allAssigns_computed = false;
  /**
   * @apilevel internal
   */
  protected SmallSet<Stmt> CompilationUnit_allAssigns_value;
  /**
   * @attribute coll
   * @aspect CollectMethodSize
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/CollectAssigns.jrag:32
   */
  public SmallSet<BodyDecl> descendingBodyDecls() {
    if(CompilationUnit_descendingBodyDecls_computed) {
      return CompilationUnit_descendingBodyDecls_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    CompilationUnit_descendingBodyDecls_value = descendingBodyDecls_compute();
    if (isFinal && num == state().boundariesCrossed) {
      CompilationUnit_descendingBodyDecls_computed = true;
    } else {
    }

    return CompilationUnit_descendingBodyDecls_value;
  }
  java.util.Set CompilationUnit_descendingBodyDecls_contributors;

  /**
   * @apilevel internal
   * @return the contributor set for descendingBodyDecls
   */
  public java.util.Set CompilationUnit_descendingBodyDecls_contributors() {
    if(CompilationUnit_descendingBodyDecls_contributors == null)
      CompilationUnit_descendingBodyDecls_contributors  = new ASTNode$State.IdentityHashSet(4);
    return CompilationUnit_descendingBodyDecls_contributors;
  }

  /**
   * @apilevel internal
   */
  private SmallSet<BodyDecl> descendingBodyDecls_compute() {
    ASTNode node = this;
    while(node.getParent() != null && !(node instanceof CompilationUnit)) {
      node = node.getParent();
    }
    CompilationUnit root = (CompilationUnit) node;
    root.collect_contributors_CompilationUnit_descendingBodyDecls();
    CompilationUnit_descendingBodyDecls_value = SmallSet.mutable();
    if(CompilationUnit_descendingBodyDecls_contributors != null)
    for (java.util.Iterator iter = CompilationUnit_descendingBodyDecls_contributors.iterator(); iter.hasNext(); ) {
      ASTNode contributor = (ASTNode) iter.next();
      contributor.contributeTo_CompilationUnit_CompilationUnit_descendingBodyDecls(CompilationUnit_descendingBodyDecls_value);
    }
    // TODO: disabled temporarily since collections may not be cached
    //CompilationUnit_descendingBodyDecls_contributors = null;
    return CompilationUnit_descendingBodyDecls_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean CompilationUnit_descendingBodyDecls_computed = false;
  /**
   * @apilevel internal
   */
  protected SmallSet<BodyDecl> CompilationUnit_descendingBodyDecls_value;
  /**
   * @attribute coll
   * @aspect Helpers
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/Helpers.jrag:63
   */
  public Set<BodyDecl> methods() {
    if(CompilationUnit_methods_computed) {
      return CompilationUnit_methods_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    CompilationUnit_methods_value = methods_compute();
    if (isFinal && num == state().boundariesCrossed) {
      CompilationUnit_methods_computed = true;
    } else {
    }

    return CompilationUnit_methods_value;
  }
  java.util.Set CompilationUnit_methods_contributors;

  /**
   * @apilevel internal
   * @return the contributor set for methods
   */
  public java.util.Set CompilationUnit_methods_contributors() {
    if(CompilationUnit_methods_contributors == null)
      CompilationUnit_methods_contributors  = new ASTNode$State.IdentityHashSet(4);
    return CompilationUnit_methods_contributors;
  }

  /**
   * @apilevel internal
   */
  private Set<BodyDecl> methods_compute() {
    ASTNode node = this;
    while(node.getParent() != null && !(node instanceof CompilationUnit)) {
      node = node.getParent();
    }
    CompilationUnit root = (CompilationUnit) node;
    root.collect_contributors_CompilationUnit_methods();
    CompilationUnit_methods_value = new HashSet();
    if(CompilationUnit_methods_contributors != null)
    for (java.util.Iterator iter = CompilationUnit_methods_contributors.iterator(); iter.hasNext(); ) {
      ASTNode contributor = (ASTNode) iter.next();
      contributor.contributeTo_CompilationUnit_CompilationUnit_methods(CompilationUnit_methods_value);
    }
    // TODO: disabled temporarily since collections may not be cached
    //CompilationUnit_methods_contributors = null;
    return CompilationUnit_methods_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean CompilationUnit_methods_computed = false;
  /**
   * @apilevel internal
   */
  protected Set<BodyDecl> CompilationUnit_methods_value;
  /**
   * @attribute coll
   * @aspect JavaDeadAssigns
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/JavaDeadAssigns.jrag:15
   */
  public SmallSet<CFGNode> deadAssignments() {
    if(CompilationUnit_deadAssignments_computed) {
      return CompilationUnit_deadAssignments_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    CompilationUnit_deadAssignments_value = deadAssignments_compute();
    if (isFinal && num == state().boundariesCrossed) {
      CompilationUnit_deadAssignments_computed = true;
    } else {
    }

    return CompilationUnit_deadAssignments_value;
  }
  java.util.Set CompilationUnit_deadAssignments_contributors;

  /**
   * @apilevel internal
   * @return the contributor set for deadAssignments
   */
  public java.util.Set CompilationUnit_deadAssignments_contributors() {
    if(CompilationUnit_deadAssignments_contributors == null)
      CompilationUnit_deadAssignments_contributors  = new ASTNode$State.IdentityHashSet(4);
    return CompilationUnit_deadAssignments_contributors;
  }

  /**
   * @apilevel internal
   */
  private SmallSet<CFGNode> deadAssignments_compute() {
    ASTNode node = this;
    while(node.getParent() != null && !(node instanceof CompilationUnit)) {
      node = node.getParent();
    }
    CompilationUnit root = (CompilationUnit) node;
    root.collect_contributors_CompilationUnit_deadAssignments();
    CompilationUnit_deadAssignments_value = SmallSet.mutable();
    if(CompilationUnit_deadAssignments_contributors != null)
    for (java.util.Iterator iter = CompilationUnit_deadAssignments_contributors.iterator(); iter.hasNext(); ) {
      ASTNode contributor = (ASTNode) iter.next();
      contributor.contributeTo_CompilationUnit_CompilationUnit_deadAssignments(CompilationUnit_deadAssignments_value);
    }
    // TODO: disabled temporarily since collections may not be cached
    //CompilationUnit_deadAssignments_contributors = null;
    return CompilationUnit_deadAssignments_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean CompilationUnit_deadAssignments_computed = false;
  /**
   * @apilevel internal
   */
  protected SmallSet<CFGNode> CompilationUnit_deadAssignments_value;
}
