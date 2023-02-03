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
 * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/grammar/Java.ast:1
 * @production Program : {@link ASTNode} ::= <span class="component">{@link CompilationUnit}*</span>;

 */
public class Program extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @aspect ClassPath
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ClassPath.jrag:26
   */
  protected BytecodeReader bytecodeReader;
  /**
   * @aspect ClassPath
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ClassPath.jrag:27
   */
  public void initBytecodeReader(BytecodeReader r) {
    bytecodeReader = r;
  }
  /**
   * @aspect ClassPath
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ClassPath.jrag:31
   */
  protected JavaParser javaParser;
  /**
   * @aspect ClassPath
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ClassPath.jrag:32
   */
  public void initJavaParser(JavaParser p) {
    javaParser = p;
  }
  /**
   * Parse the source file and add the compilation unit to the list of
   * compilation units in the program.
   * 
   * @param fileName file name of the source file
   * @return The CompilationUnit representing the source file,
   * or <code>null</code> if the source file could not be parsed
   * @aspect ClassPath
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ClassPath.jrag:63
   */
  public CompilationUnit addSourceFile(String fileName) {
    try {
      SourceFilePath pathPart = new SourceFilePath(fileName);
      CompilationUnit cu = pathPart.getCompilationUnit(this, fileName);
      if (cu != null) {
        classPath.addPackage(cu.packageName());
        addCompilationUnit(cu);
      }
      return cu;
    } catch (IOException e) {
      return null;
    }
  }
  /**
   * Iterate over all source files and on-demand loaded compilation units.
   * @aspect ClassPath
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ClassPath.jrag:80
   */
  public Iterator<CompilationUnit> compilationUnitIterator() {
    return new Iterator<CompilationUnit>() {
      int index = 0;
      public boolean hasNext() {
        return index < getNumCompilationUnit();
      }
      public CompilationUnit next() {
        if (getNumCompilationUnit() == index) {
          throw new java.util.NoSuchElementException();
        }
        return getCompilationUnit(index++);
      }
      public void remove() {
        throw new UnsupportedOperationException();
      }
    };
  }
  /**
   * Get the input stream for a compilation unit specified using a canonical
   * name. This is used by the bytecode reader to load nested types.
   * @param name The canonical name of the compilation unit.
   * @aspect ClassPath
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ClassPath.jrag:103
   */
  public InputStream getInputStream(String name) {
    return classPath.getInputStream(name);
  }
  /**
   * @aspect ClassPath
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ClassPath.jrag:107
   */
  private final ClassPath classPath = new ClassPath(this);
  /**
   * Load a compilation unit from disk, selecting a class file
   * if one exists that is not older than a corresponding source
   * file, otherwise the source file is selected.
   * 
   * This method is called by the LibCompilationUnit NTA.  We rely on the
   * result of this method being cached because it will return a newly parsed
   * compilation unit each time it is called.
   * 
   * @param name Qualified name of class to load.
   * @return the loaded compilation unit, or {@code null} if no compilation
   * unit was found
   * @aspect ClassPath
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ClassPath.jrag:366
   */
  public CompilationUnit getCompilationUnit(String name) {
    return classPath.getCompilationUnit(name);
  }
  /**
   * @return <code>true</code> if there is a package with the given name on
   * the classpath
   * @aspect ClassPath
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ClassPath.jrag:374
   */
  public boolean isPackage(String name) {
    return classPath.isPackage(name);
  }
  /**
   * Add a path part to the library class path.
   * @aspect ClassPath
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ClassPath.jrag:394
   */
  public void addClassPath(PathPart pathPart) {
    classPath.addClassPath(pathPart);
  }
  /**
   * Add a path part to the user class path.
   * @aspect ClassPath
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ClassPath.jrag:401
   */
  public void addSourcePath(PathPart pathPart) {
    classPath.addSourcePath(pathPart);
  }
  /**
   * @aspect ErrorCheck
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ErrorCheck.jrag:279
   */
  public
  void errorCheck(Collection collection) {
    for (Iterator iter = compilationUnitIterator(); iter.hasNext();) {
      CompilationUnit cu = (CompilationUnit)iter.next();
      if (cu.fromSource()) {
        cu.collectErrors();
        collection.addAll(cu.errors);
      }
    }
  }
  /**
   * @aspect ErrorCheck
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ErrorCheck.jrag:289
   */
  public
  void errorCheck(Collection collection, Collection warn) {
    for (Iterator iter = compilationUnitIterator(); iter.hasNext();) {
      CompilationUnit cu = (CompilationUnit)iter.next();
      if (cu.fromSource()) {
        cu.collectErrors();
        collection.addAll(cu.errors);
        warn.addAll(cu.warnings);
      }
    }
  }
  /**
   * @aspect ErrorCheck
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ErrorCheck.jrag:313
   */
  public
  boolean errorCheck() {
    Collection collection = new LinkedList();
    errorCheck(collection);
    if (collection.isEmpty())
      return false;
    System.err.println("Errors:");
    for (Iterator iter = collection.iterator(); iter.hasNext();) {
      String s = (String)iter.next();
      System.err.println(s);
    }
    return true;
  }
  /**
   * @aspect FrontendMain
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/FrontendMain.jrag:33
   */
  protected long javaParseTime;
  /**
   * @aspect FrontendMain
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/FrontendMain.jrag:34
   */
  protected long bytecodeParseTime;
  /**
   * @aspect FrontendMain
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/FrontendMain.jrag:35
   */
  protected long codeGenTime;
  /**
   * @aspect FrontendMain
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/FrontendMain.jrag:36
   */
  protected long errorCheckTime;
  /**
   * @aspect FrontendMain
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/FrontendMain.jrag:37
   */
  protected int numJavaFiles;
  /**
   * @aspect FrontendMain
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/FrontendMain.jrag:38
   */
  protected int numClassFiles;
  /**
   * @aspect LibraryCompilationUnits
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LibCompilationUnits.jadd:2
   */
  public Map<String, CompilationUnit> getLibCompilationUnitValueMap() {

		return getLibCompilationUnit_String_values;
	}
  /**
   * @aspect LookupFullyQualifiedTypes
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:104
   */
  public int classFileReadTime;
  /**
   * @aspect PrettyPrint
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/PrettyPrint.jadd:39
   */
  public void prettyPrint(StringBuffer sb) {
    for (Iterator iter = compilationUnitIterator(); iter.hasNext(); ) {
      CompilationUnit cu = (CompilationUnit) iter.next();
      if (cu.fromSource()) {
        cu.prettyPrint(sb);
      }
    }
  }
  /**
   * @aspect PrettyPrint
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/PrettyPrint.jadd:842
   */
  public String dumpTree() {
    StringBuffer sb = new StringBuffer();
    for (Iterator iter = compilationUnitIterator(); iter.hasNext(); ) {
      CompilationUnit cu = (CompilationUnit)iter.next();
      if (cu.fromSource()) {
        sb.append(cu.dumpTree());
      }
    }
    return sb.toString();
  }
  /**
   * @declaredat ASTNode:1
   */
  public Program() {
    super();
    is$Final(true);
  }
  /**
   * Initializes the child array to the correct size.
   * Initializes List and Opt nta children.
   * @apilevel internal
   * @ast method
   * @declaredat ASTNode:11
   */
  public void init$Children() {
    children = new ASTNode[1];
    setChild(new List(), 0);
  }
  /**
   * @declaredat ASTNode:15
   */
  public Program(List<CompilationUnit> p0) {
    setChild(p0, 0);
    is$Final(true);
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:22
   */
  protected int numChildren() {
    return 1;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:28
   */
  public boolean mayHaveRewrite() {
    return false;
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:34
   */
  public void flushCache() {
    super.flushCache();
    typeObject_computed = false;
    typeObject_value = null;
    typeCloneable_computed = false;
    typeCloneable_value = null;
    typeSerializable_computed = false;
    typeSerializable_value = null;
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
    typeString_computed = false;
    typeString_value = null;
    typeVoid_computed = false;
    typeVoid_value = null;
    typeNull_computed = false;
    typeNull_value = null;
    unknownType_computed = false;
    unknownType_value = null;
    hasPackage_String_values = null;
    lookupType_String_String_values = null;
    lookupLibType_String_String_values = null;
    getLibCompilationUnit_String_values = null;
    getLibCompilationUnit_String_list = null;getPrimitiveCompilationUnit_computed = false;
    getPrimitiveCompilationUnit_value = null;
    unknownConstructor_computed = false;
    unknownConstructor_value = null;
    wildcards_computed = false;
    wildcards_value = null;
        collect_contributors_ClassInstanceExpr_anonymousUses = false;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:81
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
        collect_contributors_ClassInstanceExpr_anonymousUses = false;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:88
   */
  public Program clone() throws CloneNotSupportedException {
    Program node = (Program) super.clone();
    node.typeObject_computed = false;
    node.typeObject_value = null;
    node.typeCloneable_computed = false;
    node.typeCloneable_value = null;
    node.typeSerializable_computed = false;
    node.typeSerializable_value = null;
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
    node.typeString_computed = false;
    node.typeString_value = null;
    node.typeVoid_computed = false;
    node.typeVoid_value = null;
    node.typeNull_computed = false;
    node.typeNull_value = null;
    node.unknownType_computed = false;
    node.unknownType_value = null;
    node.hasPackage_String_values = null;
    node.lookupType_String_String_values = null;
    node.lookupLibType_String_String_values = null;
    node.getLibCompilationUnit_String_values = null;
    node.getLibCompilationUnit_String_list = null;node.getPrimitiveCompilationUnit_computed = false;
    node.getPrimitiveCompilationUnit_value = null;
    node.unknownConstructor_computed = false;
    node.unknownConstructor_value = null;
    node.wildcards_computed = false;
    node.wildcards_value = null;
    node.in$Circle(false);
    node.is$Final(false);
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:137
   */
  public Program copy() {
    try {
      Program node = (Program) clone();
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
   * @declaredat ASTNode:155
   */
  public Program fullCopy() {
    Program tree = (Program) copy();
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
   * Replaces the CompilationUnit list.
   * @param list The new list node to be used as the CompilationUnit list.
   * @apilevel high-level
   */
  public void setCompilationUnitList(List<CompilationUnit> list) {
    setChild(list, 0);
  }
  /**
   * Retrieves the number of children in the CompilationUnit list.
   * @return Number of children in the CompilationUnit list.
   * @apilevel high-level
   */
  public int getNumCompilationUnit() {
    return getCompilationUnitList().getNumChild();
  }
  /**
   * Retrieves the number of children in the CompilationUnit list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the CompilationUnit list.
   * @apilevel low-level
   */
  public int getNumCompilationUnitNoTransform() {
    return getCompilationUnitListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the CompilationUnit list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the CompilationUnit list.
   * @apilevel high-level
   */
  public CompilationUnit getCompilationUnit(int i) {
    return (CompilationUnit) getCompilationUnitList().getChild(i);
  }
  /**
   * Check whether the CompilationUnit list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasCompilationUnit() {
    return getCompilationUnitList().getNumChild() != 0;
  }
  /**
   * Append an element to the CompilationUnit list.
   * @param node The element to append to the CompilationUnit list.
   * @apilevel high-level
   */
  public void addCompilationUnit(CompilationUnit node) {
    List<CompilationUnit> list = (parent == null || state == null) ? getCompilationUnitListNoTransform() : getCompilationUnitList();
    list.addChild(node);
  }
  /**
   * @apilevel low-level
   */
  public void addCompilationUnitNoTransform(CompilationUnit node) {
    List<CompilationUnit> list = getCompilationUnitListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the CompilationUnit list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setCompilationUnit(CompilationUnit node, int i) {
    List<CompilationUnit> list = getCompilationUnitList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the CompilationUnit list.
   * @return The node representing the CompilationUnit list.
   * @apilevel high-level
   */
  public List<CompilationUnit> getCompilationUnitList() {
    List<CompilationUnit> list = (List<CompilationUnit>) getChild(0);
    list.getNumChild();
    return list;
  }
  /**
   * Retrieves the CompilationUnit list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the CompilationUnit list.
   * @apilevel low-level
   */
  public List<CompilationUnit> getCompilationUnitListNoTransform() {
    return (List<CompilationUnit>) getChildNoTransform(0);
  }
  /**
   * Retrieves the CompilationUnit list.
   * @return The node representing the CompilationUnit list.
   * @apilevel high-level
   */
  public List<CompilationUnit> getCompilationUnits() {
    return getCompilationUnitList();
  }
  /**
   * Retrieves the CompilationUnit list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the CompilationUnit list.
   * @apilevel low-level
   */
  public List<CompilationUnit> getCompilationUnitsNoTransform() {
    return getCompilationUnitListNoTransform();
  }
  /**
   * @aspect <NoAspect>
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/Helpers.jrag:50
   */
    private boolean collect_contributors_ClassInstanceExpr_anonymousUses = false;
  protected void collect_contributors_ClassInstanceExpr_anonymousUses() {
    if(collect_contributors_ClassInstanceExpr_anonymousUses) return;
    super.collect_contributors_ClassInstanceExpr_anonymousUses();
    collect_contributors_ClassInstanceExpr_anonymousUses = true;
  }

  /**
   * @apilevel internal
   */
  protected boolean typeObject_computed = false;
  /**
   * @apilevel internal
   */
  protected TypeDecl typeObject_value;
  /**
   * @attribute syn
   * @aspect SpecialClasses
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:15
   */
  public TypeDecl typeObject() {
    if(typeObject_computed) {
      return typeObject_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    typeObject_value = typeObject_compute();
    if (isFinal && num == state().boundariesCrossed) {
      typeObject_computed = true;
    } else {
    }

    return typeObject_value;
  }
  /**
   * @apilevel internal
   */
  private TypeDecl typeObject_compute() {  return lookupType("java.lang", "Object");  }
  /**
   * @apilevel internal
   */
  protected boolean typeCloneable_computed = false;
  /**
   * @apilevel internal
   */
  protected TypeDecl typeCloneable_value;
  /**
   * @attribute syn
   * @aspect SpecialClasses
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:16
   */
  public TypeDecl typeCloneable() {
    if(typeCloneable_computed) {
      return typeCloneable_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    typeCloneable_value = typeCloneable_compute();
    if (isFinal && num == state().boundariesCrossed) {
      typeCloneable_computed = true;
    } else {
    }

    return typeCloneable_value;
  }
  /**
   * @apilevel internal
   */
  private TypeDecl typeCloneable_compute() {  return lookupType("java.lang", "Cloneable");  }
  /**
   * @apilevel internal
   */
  protected boolean typeSerializable_computed = false;
  /**
   * @apilevel internal
   */
  protected TypeDecl typeSerializable_value;
  /**
   * @attribute syn
   * @aspect SpecialClasses
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:17
   */
  public TypeDecl typeSerializable() {
    if(typeSerializable_computed) {
      return typeSerializable_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    typeSerializable_value = typeSerializable_compute();
    if (isFinal && num == state().boundariesCrossed) {
      typeSerializable_computed = true;
    } else {
    }

    return typeSerializable_value;
  }
  /**
   * @apilevel internal
   */
  private TypeDecl typeSerializable_compute() {  return lookupType("java.io", "Serializable");  }
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
   * @aspect SpecialClasses
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:22
   */
  public TypeDecl typeBoolean() {
    if(typeBoolean_computed) {
      return typeBoolean_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    typeBoolean_value = typeBoolean_compute();
    if (isFinal && num == state().boundariesCrossed) {
      typeBoolean_computed = true;
    } else {
    }

    return typeBoolean_value;
  }
  /**
   * @apilevel internal
   */
  private TypeDecl typeBoolean_compute() {  return lookupType(PRIMITIVE_PACKAGE_NAME, "boolean");  }
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
   * @aspect SpecialClasses
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:23
   */
  public TypeDecl typeByte() {
    if(typeByte_computed) {
      return typeByte_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    typeByte_value = typeByte_compute();
    if (isFinal && num == state().boundariesCrossed) {
      typeByte_computed = true;
    } else {
    }

    return typeByte_value;
  }
  /**
   * @apilevel internal
   */
  private TypeDecl typeByte_compute() {  return lookupType(PRIMITIVE_PACKAGE_NAME , "byte");  }
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
   * @aspect SpecialClasses
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:24
   */
  public TypeDecl typeShort() {
    if(typeShort_computed) {
      return typeShort_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    typeShort_value = typeShort_compute();
    if (isFinal && num == state().boundariesCrossed) {
      typeShort_computed = true;
    } else {
    }

    return typeShort_value;
  }
  /**
   * @apilevel internal
   */
  private TypeDecl typeShort_compute() {  return lookupType(PRIMITIVE_PACKAGE_NAME , "short");  }
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
   * @aspect SpecialClasses
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:25
   */
  public TypeDecl typeChar() {
    if(typeChar_computed) {
      return typeChar_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    typeChar_value = typeChar_compute();
    if (isFinal && num == state().boundariesCrossed) {
      typeChar_computed = true;
    } else {
    }

    return typeChar_value;
  }
  /**
   * @apilevel internal
   */
  private TypeDecl typeChar_compute() {  return lookupType(PRIMITIVE_PACKAGE_NAME , "char");  }
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
   * @aspect SpecialClasses
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:26
   */
  public TypeDecl typeInt() {
    if(typeInt_computed) {
      return typeInt_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    typeInt_value = typeInt_compute();
    if (isFinal && num == state().boundariesCrossed) {
      typeInt_computed = true;
    } else {
    }

    return typeInt_value;
  }
  /**
   * @apilevel internal
   */
  private TypeDecl typeInt_compute() {  return lookupType(PRIMITIVE_PACKAGE_NAME , "int");  }
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
   * @aspect SpecialClasses
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:27
   */
  public TypeDecl typeLong() {
    if(typeLong_computed) {
      return typeLong_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    typeLong_value = typeLong_compute();
    if (isFinal && num == state().boundariesCrossed) {
      typeLong_computed = true;
    } else {
    }

    return typeLong_value;
  }
  /**
   * @apilevel internal
   */
  private TypeDecl typeLong_compute() {  return lookupType(PRIMITIVE_PACKAGE_NAME , "long");  }
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
   * @aspect SpecialClasses
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:28
   */
  public TypeDecl typeFloat() {
    if(typeFloat_computed) {
      return typeFloat_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    typeFloat_value = typeFloat_compute();
    if (isFinal && num == state().boundariesCrossed) {
      typeFloat_computed = true;
    } else {
    }

    return typeFloat_value;
  }
  /**
   * @apilevel internal
   */
  private TypeDecl typeFloat_compute() {  return lookupType(PRIMITIVE_PACKAGE_NAME , "float");  }
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
   * @aspect SpecialClasses
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:29
   */
  public TypeDecl typeDouble() {
    if(typeDouble_computed) {
      return typeDouble_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    typeDouble_value = typeDouble_compute();
    if (isFinal && num == state().boundariesCrossed) {
      typeDouble_computed = true;
    } else {
    }

    return typeDouble_value;
  }
  /**
   * @apilevel internal
   */
  private TypeDecl typeDouble_compute() {  return lookupType(PRIMITIVE_PACKAGE_NAME , "double");  }
  /**
   * @apilevel internal
   */
  protected boolean typeString_computed = false;
  /**
   * @apilevel internal
   */
  protected TypeDecl typeString_value;
  /**
   * @attribute syn
   * @aspect SpecialClasses
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:30
   */
  public TypeDecl typeString() {
    if(typeString_computed) {
      return typeString_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    typeString_value = typeString_compute();
    if (isFinal && num == state().boundariesCrossed) {
      typeString_computed = true;
    } else {
    }

    return typeString_value;
  }
  /**
   * @apilevel internal
   */
  private TypeDecl typeString_compute() {  return lookupType("java.lang", "String");  }
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
   * @aspect SpecialClasses
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:41
   */
  public TypeDecl typeVoid() {
    if(typeVoid_computed) {
      return typeVoid_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    typeVoid_value = typeVoid_compute();
    if (isFinal && num == state().boundariesCrossed) {
      typeVoid_computed = true;
    } else {
    }

    return typeVoid_value;
  }
  /**
   * @apilevel internal
   */
  private TypeDecl typeVoid_compute() {  return lookupType(PRIMITIVE_PACKAGE_NAME, "void");  }
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
   * @aspect SpecialClasses
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:43
   */
  public TypeDecl typeNull() {
    if(typeNull_computed) {
      return typeNull_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    typeNull_value = typeNull_compute();
    if (isFinal && num == state().boundariesCrossed) {
      typeNull_computed = true;
    } else {
    }

    return typeNull_value;
  }
  /**
   * @apilevel internal
   */
  private TypeDecl typeNull_compute() {  return lookupType(PRIMITIVE_PACKAGE_NAME, "null");  }
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
   * @aspect SpecialClasses
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:46
   */
  public TypeDecl unknownType() {
    if(unknownType_computed) {
      return unknownType_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    unknownType_value = unknownType_compute();
    if (isFinal && num == state().boundariesCrossed) {
      unknownType_computed = true;
    } else {
    }

    return unknownType_value;
  }
  /**
   * @apilevel internal
   */
  private TypeDecl unknownType_compute() {  return lookupType(PRIMITIVE_PACKAGE_NAME, "Unknown");  }
  protected java.util.Map hasPackage_String_values;
  /**
   * @attribute syn
   * @aspect LookupFullyQualifiedTypes
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:77
   */
  public boolean hasPackage(String packageName) {
    Object _parameters = packageName;
    if (hasPackage_String_values == null) hasPackage_String_values = new org.jastadd.util.RobustMap(new java.util.HashMap());
    if(hasPackage_String_values.containsKey(_parameters)) {
      return ((Boolean)hasPackage_String_values.get(_parameters)).booleanValue();
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    boolean hasPackage_String_value = hasPackage_compute(packageName);
    if (isFinal && num == state().boundariesCrossed) {
      hasPackage_String_values.put(_parameters, Boolean.valueOf(hasPackage_String_value));
    } else {
    }

    return hasPackage_String_value;
  }
  /**
   * @apilevel internal
   */
  private boolean hasPackage_compute(String packageName) {
      return isPackage(packageName);
    }
  protected java.util.Map lookupType_String_String_values;
  /**
   * Checks from-source compilation units for the given type.
   * If no matching compilation unit is found the library compliation units
   * will be searched.
   * @attribute syn
   * @aspect LookupFullyQualifiedTypes
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:116
   */
  public TypeDecl lookupType(String packageName, String typeName) {
    java.util.List _parameters = new java.util.ArrayList(2);
    _parameters.add(packageName);
    _parameters.add(typeName);
    if (lookupType_String_String_values == null) lookupType_String_String_values = new org.jastadd.util.RobustMap(new java.util.HashMap());
    if(lookupType_String_String_values.containsKey(_parameters)) {
      return (TypeDecl)lookupType_String_String_values.get(_parameters);
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    TypeDecl lookupType_String_String_value = lookupType_compute(packageName, typeName);
    if (isFinal && num == state().boundariesCrossed) {
      lookupType_String_String_values.put(_parameters, lookupType_String_String_value);
    } else {
    }

    return lookupType_String_String_value;
  }
  /**
   * @apilevel internal
   */
  private TypeDecl lookupType_compute(String packageName, String typeName) {
      String fullName = packageName.equals("") ? typeName : packageName + "." + typeName;
      // Check for type in source
      for(int i = 0; i < getNumCompilationUnit(); i++) {
        for(int j = 0; j < getCompilationUnit(i).getNumTypeDecl(); j++) {
          TypeDecl type = getCompilationUnit(i).getTypeDecl(j);
          if(type.fullName().equals(fullName)) {
            return type;
          }
        }
      }
      // Check for type in library
      return lookupLibType(packageName, typeName);
    }
  protected java.util.Map lookupLibType_String_String_values;
  /**
   * Lookup types in the library
   * @attribute syn
   * @aspect LookupFullyQualifiedTypes
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:133
   */
  public TypeDecl lookupLibType(String packageName, String typeName) {
    java.util.List _parameters = new java.util.ArrayList(2);
    _parameters.add(packageName);
    _parameters.add(typeName);
    if (lookupLibType_String_String_values == null) lookupLibType_String_String_values = new org.jastadd.util.RobustMap(new java.util.HashMap());
    if(lookupLibType_String_String_values.containsKey(_parameters)) {
      return (TypeDecl)lookupLibType_String_String_values.get(_parameters);
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    TypeDecl lookupLibType_String_String_value = lookupLibType_compute(packageName, typeName);
    if (isFinal && num == state().boundariesCrossed) {
      lookupLibType_String_String_values.put(_parameters, lookupLibType_String_String_value);
    } else {
    }

    return lookupLibType_String_String_value;
  }
  /**
   * @apilevel internal
   */
  private TypeDecl lookupLibType_compute(String packageName, String typeName) {
      String fullName = packageName.equals("") ? typeName : packageName + "." + typeName;
      // Check the primitive types
      if (packageName.equals(PRIMITIVE_PACKAGE_NAME)) {
        PrimitiveCompilationUnit unit = getPrimitiveCompilationUnit();
        if (typeName.equals("boolean")) return unit.typeBoolean();
        if (typeName.equals("byte")) return unit.typeByte();
        if (typeName.equals("short")) return unit.typeShort();
        if (typeName.equals("char")) return unit.typeChar();
        if (typeName.equals("int")) return unit.typeInt();
        if (typeName.equals("long")) return unit.typeLong();
        if (typeName.equals("float")) return unit.typeFloat();
        if (typeName.equals("double")) return unit.typeDouble();
        if (typeName.equals("null")) return unit.typeNull();
        if (typeName.equals("void")) return unit.typeVoid();
        if (typeName.equals("Unknown")) return unit.unknownType(); // Is this needed?
      }
      // Check the library:
      //  A type may not be in the library but an NTA cannot map to null.
      //  We need to do some double work to step around this.
      //  We check the classpath directly (the same thing the library NTA does)
      //  to prevent that we call the nta for a name that gives null back
      //else if (getCompilationUnit(fullName) != null) {
  
      // Found a library unit, check it for type
      CompilationUnit libUnit = getLibCompilationUnit(fullName);
      if (libUnit != null) {
        for(int j = 0; j < libUnit.getNumTypeDecl(); j++) {
          TypeDecl type = libUnit.getTypeDecl(j);
          if(type.fullName().equals(fullName)) {
            return type;
          }
        }
      }
      // No type found in the library
      return null;
    }
  /**
   * @apilevel internal
   */
  protected java.util.Map getLibCompilationUnit_String_values;
  /**
   * @apilevel internal
   */
  protected List getLibCompilationUnit_String_list;
  /**
   * @attribute syn
   * @aspect LookupFullyQualifiedTypes
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:171
   */
  public CompilationUnit getLibCompilationUnit(String fullName) {
    Object _parameters = fullName;
    if (getLibCompilationUnit_String_values == null) getLibCompilationUnit_String_values = new org.jastadd.util.RobustMap(new java.util.HashMap());
    if(getLibCompilationUnit_String_values.containsKey(_parameters)) {
      return (CompilationUnit)getLibCompilationUnit_String_values.get(_parameters);
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    CompilationUnit getLibCompilationUnit_String_value = getLibCompilationUnit_compute(fullName);
    if(getLibCompilationUnit_String_list == null) {
      getLibCompilationUnit_String_list = new List();
      getLibCompilationUnit_String_list.is$Final = true;
      getLibCompilationUnit_String_list.setParent(this);
    }
    getLibCompilationUnit_String_list.add(getLibCompilationUnit_String_value);
    if(getLibCompilationUnit_String_value != null) {
      getLibCompilationUnit_String_value = (CompilationUnit) getLibCompilationUnit_String_list.getChild(getLibCompilationUnit_String_list.numChildren-1);
      getLibCompilationUnit_String_value.is$Final = true;
    }
    if (true) {
      getLibCompilationUnit_String_values.put(_parameters, getLibCompilationUnit_String_value);
    } else {
    }

    return getLibCompilationUnit_String_value;
  }
  /**
   * @apilevel internal
   */
  private CompilationUnit getLibCompilationUnit_compute(String fullName) {
      return getCompilationUnit(fullName);
    }
  /**
   * @apilevel internal
   */
  protected boolean getPrimitiveCompilationUnit_computed = false;
  /**
   * @apilevel internal
   */
  protected PrimitiveCompilationUnit getPrimitiveCompilationUnit_value;
  /**
   * @attribute syn
   * @aspect PrimitiveTypes
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/PrimitiveTypes.jrag:119
   */
  public PrimitiveCompilationUnit getPrimitiveCompilationUnit() {
    if(getPrimitiveCompilationUnit_computed) {
      return getPrimitiveCompilationUnit_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    getPrimitiveCompilationUnit_value = getPrimitiveCompilationUnit_compute();
    getPrimitiveCompilationUnit_value.setParent(this);
    getPrimitiveCompilationUnit_value.is$Final = true;
    if (true) {
      getPrimitiveCompilationUnit_computed = true;
    } else {
    }

    return getPrimitiveCompilationUnit_value;
  }
  /**
   * @apilevel internal
   */
  private PrimitiveCompilationUnit getPrimitiveCompilationUnit_compute() {
      PrimitiveCompilationUnit u = new PrimitiveCompilationUnit();
      u.setPackageDecl(PRIMITIVE_PACKAGE_NAME);
      return u;
    }
  /**
   * @apilevel internal
   */
  protected boolean unknownConstructor_computed = false;
  /**
   * @apilevel internal
   */
  protected ConstructorDecl unknownConstructor_value;
  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:245
   */
  public ConstructorDecl unknownConstructor() {
    if(unknownConstructor_computed) {
      return unknownConstructor_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    unknownConstructor_value = unknownConstructor_compute();
    if (isFinal && num == state().boundariesCrossed) {
      unknownConstructor_computed = true;
    } else {
    }

    return unknownConstructor_value;
  }
  /**
   * @apilevel internal
   */
  private ConstructorDecl unknownConstructor_compute() {
      return (ConstructorDecl)unknownType().constructors().iterator().next();
    }
  /**
   * @apilevel internal
   */
  protected boolean wildcards_computed = false;
  /**
   * @apilevel internal
   */
  protected WildcardsCompilationUnit wildcards_value;
  /**
   * @attribute syn
   * @aspect LookupParTypeDecl
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Generics.jrag:1150
   */
  public WildcardsCompilationUnit wildcards() {
    if(wildcards_computed) {
      return wildcards_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    wildcards_value = wildcards_compute();
    wildcards_value.setParent(this);
    wildcards_value.is$Final = true;
    if (true) {
      wildcards_computed = true;
    } else {
    }

    return wildcards_value;
  }
  /**
   * @apilevel internal
   */
  private WildcardsCompilationUnit wildcards_compute() {
      return new WildcardsCompilationUnit(
        "wildcards",
        new List(),
        new List()
      );
    }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/AnonymousClasses.jrag:14
   * @apilevel internal
   */
  public TypeDecl Define_TypeDecl_superType(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return null;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/AnonymousClasses.jrag:27
   * @apilevel internal
   */
  public ConstructorDecl Define_ConstructorDecl_constructorDecl(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return unknownConstructor();
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Arrays.jrag:19
   * @apilevel internal
   */
  public TypeDecl Define_TypeDecl_componentType(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return unknownType();
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/BranchTarget.jrag:233
   * @apilevel internal
   */
  public LabeledStmt Define_LabeledStmt_lookupLabel(ASTNode caller, ASTNode child, String name) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return null;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DefiniteAssignment.jrag:16
   * @apilevel internal
   */
  public boolean Define_boolean_isDest(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return false;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DefiniteAssignment.jrag:26
   * @apilevel internal
   */
  public boolean Define_boolean_isSource(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return true;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DefiniteAssignment.jrag:50
   * @apilevel internal
   */
  public boolean Define_boolean_isIncOrDec(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return false;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DefiniteAssignment.jrag:337
   * @apilevel internal
   */
  public boolean Define_boolean_isDAbefore(ASTNode caller, ASTNode child, Variable v) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return true;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DefiniteAssignment.jrag:722
   * @apilevel internal
   */
  public boolean Define_boolean_isDUbefore(ASTNode caller, ASTNode child, Variable v) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return true;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ExceptionHandling.jrag:19
   * @apilevel internal
   */
  public TypeDecl Define_TypeDecl_typeException(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return lookupType("java.lang", "Exception");
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ExceptionHandling.jrag:21
   * @apilevel internal
   */
  public TypeDecl Define_TypeDecl_typeRuntimeException(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return lookupType("java.lang", "RuntimeException");
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ExceptionHandling.jrag:23
   * @apilevel internal
   */
  public TypeDecl Define_TypeDecl_typeError(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return lookupType("java.lang", "Error");
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ExceptionHandling.jrag:25
   * @apilevel internal
   */
  public TypeDecl Define_TypeDecl_typeNullPointerException(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return lookupType("java.lang", "NullPointerException");
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ExceptionHandling.jrag:27
   * @apilevel internal
   */
  public TypeDecl Define_TypeDecl_typeThrowable(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return lookupType("java.lang", "Throwable");
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ExceptionHandling.jrag:138
   * @apilevel internal
   */
  public boolean Define_boolean_handlesException(ASTNode caller, ASTNode child, TypeDecl exceptionType) {
     {
      int childIndex = this.getIndexOfChild(caller);
{
    throw new Error("Operation handlesException not supported");
  }
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupConstructor.jrag:15
   * @apilevel internal
   */
  public Collection Define_Collection_lookupConstructor(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return Collections.EMPTY_LIST;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupConstructor.jrag:24
   * @apilevel internal
   */
  public Collection Define_Collection_lookupSuperConstructor(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return Collections.EMPTY_LIST;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupMethod.jrag:41
   * @apilevel internal
   */
  public Expr Define_Expr_nestedScope(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
{ throw new UnsupportedOperationException(); }
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupMethod.jrag:53
   * @apilevel internal
   */
  public Collection Define_Collection_lookupMethod(ASTNode caller, ASTNode child, String name) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return Collections.EMPTY_LIST;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:18
   * @apilevel internal
   */
  public TypeDecl Define_TypeDecl_typeObject(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return typeObject();
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:19
   * @apilevel internal
   */
  public TypeDecl Define_TypeDecl_typeCloneable(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return typeCloneable();
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:20
   * @apilevel internal
   */
  public TypeDecl Define_TypeDecl_typeSerializable(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return typeSerializable();
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:31
   * @apilevel internal
   */
  public TypeDecl Define_TypeDecl_typeBoolean(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return typeBoolean();
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:32
   * @apilevel internal
   */
  public TypeDecl Define_TypeDecl_typeByte(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return typeByte();
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:33
   * @apilevel internal
   */
  public TypeDecl Define_TypeDecl_typeShort(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return typeShort();
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:34
   * @apilevel internal
   */
  public TypeDecl Define_TypeDecl_typeChar(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return typeChar();
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:35
   * @apilevel internal
   */
  public TypeDecl Define_TypeDecl_typeInt(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return typeInt();
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:36
   * @apilevel internal
   */
  public TypeDecl Define_TypeDecl_typeLong(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return typeLong();
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:37
   * @apilevel internal
   */
  public TypeDecl Define_TypeDecl_typeFloat(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return typeFloat();
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:38
   * @apilevel internal
   */
  public TypeDecl Define_TypeDecl_typeDouble(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return typeDouble();
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:39
   * @apilevel internal
   */
  public TypeDecl Define_TypeDecl_typeString(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return typeString();
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:42
   * @apilevel internal
   */
  public TypeDecl Define_TypeDecl_typeVoid(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return typeVoid();
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:44
   * @apilevel internal
   */
  public TypeDecl Define_TypeDecl_typeNull(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return typeNull();
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:47
   * @apilevel internal
   */
  public TypeDecl Define_TypeDecl_unknownType(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return unknownType();
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:84
   * @apilevel internal
   */
  public boolean Define_boolean_hasPackage(ASTNode caller, ASTNode child, String packageName) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return hasPackage(packageName);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:109
   * @apilevel internal
   */
  public TypeDecl Define_TypeDecl_lookupType(ASTNode caller, ASTNode child, String packageName, String typeName) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return lookupType(packageName, typeName);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:232
   * @apilevel internal
   */
  public SimpleSet Define_SimpleSet_lookupType(ASTNode caller, ASTNode child, String name) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return SimpleSet.emptySet;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupVariable.jrag:24
   * @apilevel internal
   */
  public SimpleSet Define_SimpleSet_lookupVariable(ASTNode caller, ASTNode child, String name) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return SimpleSet.emptySet;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:290
   * @apilevel internal
   */
  public boolean Define_boolean_mayBePublic(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return false;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:291
   * @apilevel internal
   */
  public boolean Define_boolean_mayBeProtected(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return false;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:292
   * @apilevel internal
   */
  public boolean Define_boolean_mayBePrivate(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return false;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:293
   * @apilevel internal
   */
  public boolean Define_boolean_mayBeStatic(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return false;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:294
   * @apilevel internal
   */
  public boolean Define_boolean_mayBeFinal(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return false;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:295
   * @apilevel internal
   */
  public boolean Define_boolean_mayBeAbstract(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return false;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:296
   * @apilevel internal
   */
  public boolean Define_boolean_mayBeVolatile(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return false;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:297
   * @apilevel internal
   */
  public boolean Define_boolean_mayBeTransient(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return false;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:298
   * @apilevel internal
   */
  public boolean Define_boolean_mayBeStrictfp(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return false;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:299
   * @apilevel internal
   */
  public boolean Define_boolean_mayBeSynchronized(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return false;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:300
   * @apilevel internal
   */
  public boolean Define_boolean_mayBeNative(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return false;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/NameCheck.jrag:275
   * @apilevel internal
   */
  public ASTNode Define_ASTNode_enclosingBlock(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return null;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/NameCheck.jrag:326
   * @apilevel internal
   */
  public VariableScope Define_VariableScope_outerScope(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
{
    throw new UnsupportedOperationException("outerScope() not defined");
  }
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/NameCheck.jrag:395
   * @apilevel internal
   */
  public boolean Define_boolean_insideLoop(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return false;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/NameCheck.jrag:402
   * @apilevel internal
   */
  public boolean Define_boolean_insideSwitch(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return false;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/NameCheck.jrag:454
   * @apilevel internal
   */
  public Case Define_Case_bind(ASTNode caller, ASTNode child, Case c) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return null;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/PrettyPrint.jadd:373
   * @apilevel internal
   */
  public String Define_String_typeDeclIndent(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return "";
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/SyntacticClassification.jrag:64
   * @apilevel internal
   */
  public NameType Define_NameType_nameType(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return NameType.NO_NAME;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:219
   * @apilevel internal
   */
  public boolean Define_boolean_isAnonymous(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return false;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:233
   * @apilevel internal
   */
  public Variable Define_Variable_unknownField(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return unknownType().findSingleVariable("unknown");
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:237
   * @apilevel internal
   */
  public MethodDecl Define_MethodDecl_unknownMethod(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
{
    for(Iterator iter = unknownType().memberMethods("unknown").iterator(); iter.hasNext(); ) {
      MethodDecl m = (MethodDecl)iter.next();
      return m;
    }
    throw new Error("Could not find method unknown in type Unknown");
  }
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:244
   * @apilevel internal
   */
  public ConstructorDecl Define_ConstructorDecl_unknownConstructor(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return unknownConstructor();
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:256
   * @apilevel internal
   */
  public TypeDecl Define_TypeDecl_declType(ASTNode caller, ASTNode child) {
     {
      int i = this.getIndexOfChild(caller);
      return null;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:521
   * @apilevel internal
   */
  public BodyDecl Define_BodyDecl_enclosingBodyDecl(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return null;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:539
   * @apilevel internal
   */
  public boolean Define_boolean_isMemberType(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return false;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:587
   * @apilevel internal
   */
  public TypeDecl Define_TypeDecl_hostType(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return null;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeCheck.jrag:363
   * @apilevel internal
   */
  public TypeDecl Define_TypeDecl_switchType(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return unknownType();
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeCheck.jrag:409
   * @apilevel internal
   */
  public TypeDecl Define_TypeDecl_returnType(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return typeVoid();
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeCheck.jrag:510
   * @apilevel internal
   */
  public TypeDecl Define_TypeDecl_enclosingInstance(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return null;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeHierarchyCheck.jrag:14
   * @apilevel internal
   */
  public String Define_String_methodHost(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
{
    throw new Error("Needs extra equation for methodHost()");
  }
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeHierarchyCheck.jrag:147
   * @apilevel internal
   */
  public boolean Define_boolean_inExplicitConstructorInvocation(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return false;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeHierarchyCheck.jrag:156
   * @apilevel internal
   */
  public TypeDecl Define_TypeDecl_enclosingExplicitConstructorHostType(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return null;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeHierarchyCheck.jrag:164
   * @apilevel internal
   */
  public boolean Define_boolean_inStaticContext(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return false;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/UnreachableStatements.jrag:160
   * @apilevel internal
   */
  public boolean Define_boolean_reportUnreachable(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return true;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/VariableDeclaration.jrag:68
   * @apilevel internal
   */
  public boolean Define_boolean_isMethodParameter(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return false;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/VariableDeclaration.jrag:69
   * @apilevel internal
   */
  public boolean Define_boolean_isConstructorParameter(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return false;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/VariableDeclaration.jrag:70
   * @apilevel internal
   */
  public boolean Define_boolean_isExceptionHandlerParameter(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return false;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Annotations.jrag:94
   * @apilevel internal
   */
  public boolean Define_boolean_mayUseAnnotationTarget(ASTNode caller, ASTNode child, String name) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return false;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Annotations.jrag:188
   * @apilevel internal
   */
  public ElementValue Define_ElementValue_lookupElementTypeValue(ASTNode caller, ASTNode child, String name) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return null;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Annotations.jrag:278
   * @apilevel internal
   */
  public boolean Define_boolean_withinSuppressWarnings(ASTNode caller, ASTNode child, String annot) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return false;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Annotations.jrag:380
   * @apilevel internal
   */
  public boolean Define_boolean_withinDeprecatedAnnotation(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return false;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Annotations.jrag:440
   * @apilevel internal
   */
  public Annotation Define_Annotation_lookupAnnotation(ASTNode caller, ASTNode child, TypeDecl typeDecl) {
     {
      int i = this.getIndexOfChild(caller);
      return null;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Annotations.jrag:473
   * @apilevel internal
   */
  public TypeDecl Define_TypeDecl_enclosingAnnotationDecl(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return unknownType();
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/GenericMethodsInference.jrag:39
   * @apilevel internal
   */
  public TypeDecl Define_TypeDecl_assignConvertedType(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return typeNull();
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Generics.jrag:281
   * @apilevel internal
   */
  public boolean Define_boolean_inExtendsOrImplements(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return false;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Generics.jrag:1177
   * @apilevel internal
   */
  public TypeDecl Define_TypeDecl_typeWildcard(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return wildcards().typeWildcard();
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Generics.jrag:1188
   * @apilevel internal
   */
  public TypeDecl Define_TypeDecl_lookupWildcardExtends(ASTNode caller, ASTNode child, TypeDecl typeDecl) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return wildcards().lookupWildcardExtends(typeDecl);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Generics.jrag:1201
   * @apilevel internal
   */
  public TypeDecl Define_TypeDecl_lookupWildcardSuper(ASTNode caller, ASTNode child, TypeDecl typeDecl) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return wildcards().lookupWildcardSuper(typeDecl);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Generics.jrag:1223
   * @apilevel internal
   */
  public LUBType Define_LUBType_lookupLUBType(ASTNode caller, ASTNode child, Collection bounds) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return wildcards().lookupLUBType(bounds);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Generics.jrag:1263
   * @apilevel internal
   */
  public GLBType Define_GLBType_lookupGLBType(ASTNode caller, ASTNode child, ArrayList bounds) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return wildcards().lookupGLBType(bounds);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/GenericsParTypeDecl.jrag:47
   * @apilevel internal
   */
  public TypeDecl Define_TypeDecl_genericDecl(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return null;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/VariableArityParameters.jrag:24
   * @apilevel internal
   */
  public boolean Define_boolean_variableArityValid(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return false;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/Helpers.jrag:8
   * @apilevel internal
   */
  public SmallSet Define_SmallSet_emptySmallSet(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return SmallSet.empty();
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/Helpers.jrag:16
   * @apilevel internal
   */
  public BitSet Define_BitSet_emptyBitSet(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
{
    throw new UnsupportedOperationException();
  }
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/Helpers.jrag:61
   * @apilevel internal
   */
  public ClassInstanceExpr Define_ClassInstanceExpr_enclosingClassInstanceExpr(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return null;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/Helpers.jrag:69
   * @apilevel internal
   */
  public CompilationUnit Define_CompilationUnit_getCompUnit(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return null;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:37
   * @apilevel internal
   */
  public SmallSet<CFGNode> Define_SmallSet_CFGNode__following(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return SmallSet.empty();
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:183
   * @apilevel internal
   */
  public SwitchStmt Define_SwitchStmt_enclosingSwitchStmt(ASTNode caller, ASTNode child) {
     {
      int i = this.getIndexOfChild(caller);
      return null;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:312
   * @apilevel internal
   */
  public SmallSet<CFGNode> Define_SmallSet_CFGNode__throwTarget(ASTNode caller, ASTNode child, TypeDecl type) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return SmallSet.empty();
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:518
   * @apilevel internal
   */
  public SmallSet<CFGNode> Define_SmallSet_CFGNode__followingWhenTrue(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return SmallSet.empty();
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:519
   * @apilevel internal
   */
  public SmallSet<CFGNode> Define_SmallSet_CFGNode__followingWhenFalse(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return SmallSet.empty();
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:708
   * @apilevel internal
   */
  public SmallSet<CFGNode> Define_SmallSet_CFGNode__uncheckedExceptionTarget(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
{ 
        throw new UnsupportedOperationException("There is no unchedExceptionTarget outside of BodyDecl trees"); }
    }
  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {    return super.rewriteTo();
  }}
