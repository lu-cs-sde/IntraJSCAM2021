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
 * 7.5 Import Declarations
 * @ast node
 * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/grammar/StaticImports.ast:4
 * @production StaticImportDecl : {@link ImportDecl};

 */
public abstract class StaticImportDecl extends ImportDecl implements Cloneable {
  /**
   * @declaredat ASTNode:1
   */
  public StaticImportDecl() {
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
  }
  /**
   * @declaredat ASTNode:13
   */
  public StaticImportDecl(Access p0) {
    setChild(p0, 0);
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:19
   */
  protected int numChildren() {
    return 1;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:25
   */
  public boolean mayHaveRewrite() {
    return false;
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:31
   */
  public void flushCache() {
    super.flushCache();
    importedTypes_String_values = null;
    importedFields_String_values = null;
    importedMethods_String_values = null;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:40
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:46
   */
  public StaticImportDecl clone() throws CloneNotSupportedException {
    StaticImportDecl node = (StaticImportDecl) super.clone();
    node.importedTypes_String_values = null;
    node.importedFields_String_values = null;
    node.importedMethods_String_values = null;
    node.in$Circle(false);
    node.is$Final(false);
    return node;
  }
  /**
   * Replaces the Access child.
   * @param node The new node to replace the Access child.
   * @apilevel high-level
   */
  public void setAccess(Access node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the Access child.
   * @return The current node used as the Access child.
   * @apilevel high-level
   */
  public Access getAccess() {
    return (Access) getChild(0);
  }
  /**
   * Retrieves the Access child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Access child.
   * @apilevel low-level
   */
  public Access getAccessNoTransform() {
    return (Access) getChildNoTransform(0);
  }
  /**
   * @attribute syn
   * @aspect StaticImports
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/StaticImports.jrag:67
   */
  public abstract TypeDecl type();
  protected java.util.Map importedTypes_String_values;
  /**
   * @attribute syn
   * @aspect StaticImports
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/StaticImports.jrag:21
   */
  public SimpleSet importedTypes(String name) {
    Object _parameters = name;
    if (importedTypes_String_values == null) importedTypes_String_values = new org.jastadd.util.RobustMap(new java.util.HashMap());
    if(importedTypes_String_values.containsKey(_parameters)) {
      return (SimpleSet)importedTypes_String_values.get(_parameters);
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    SimpleSet importedTypes_String_value = importedTypes_compute(name);
    if (isFinal && num == state().boundariesCrossed) {
      importedTypes_String_values.put(_parameters, importedTypes_String_value);
    } else {
    }

    return importedTypes_String_value;
  }
  /**
   * @apilevel internal
   */
  private SimpleSet importedTypes_compute(String name) {
      SimpleSet set = SimpleSet.emptySet;
      for(Iterator iter = type().memberTypes(name).iterator(); iter.hasNext(); ) {
        TypeDecl decl = (TypeDecl)iter.next();
        if(decl.isStatic() && decl.accessibleFromPackage(packageName()))
          set = set.add(decl);
      }
      return set;
    }
  protected java.util.Map importedFields_String_values;
  /**
   * @attribute syn
   * @aspect StaticImports
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/StaticImports.jrag:31
   */
  public SimpleSet importedFields(String name) {
    Object _parameters = name;
    if (importedFields_String_values == null) importedFields_String_values = new org.jastadd.util.RobustMap(new java.util.HashMap());
    if(importedFields_String_values.containsKey(_parameters)) {
      return (SimpleSet)importedFields_String_values.get(_parameters);
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    SimpleSet importedFields_String_value = importedFields_compute(name);
    if (isFinal && num == state().boundariesCrossed) {
      importedFields_String_values.put(_parameters, importedFields_String_value);
    } else {
    }

    return importedFields_String_value;
  }
  /**
   * @apilevel internal
   */
  private SimpleSet importedFields_compute(String name) {
      SimpleSet set = SimpleSet.emptySet;
      for(Iterator iter = type().memberFields(name).iterator(); iter.hasNext(); ) {
        FieldDeclaration decl = (FieldDeclaration)iter.next();
        if(decl.isStatic() &&
           (decl.isPublic() || (!decl.isPrivate() && decl.hostType().topLevelType().packageName().equals(packageName()))))
          set = set.add(decl);
      }
      return set;
    }
  protected java.util.Map importedMethods_String_values;
  /**
   * @attribute syn
   * @aspect StaticImports
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/StaticImports.jrag:49
   */
  public Collection importedMethods(String name) {
    Object _parameters = name;
    if (importedMethods_String_values == null) importedMethods_String_values = new org.jastadd.util.RobustMap(new java.util.HashMap());
    if(importedMethods_String_values.containsKey(_parameters)) {
      return (Collection)importedMethods_String_values.get(_parameters);
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    Collection importedMethods_String_value = importedMethods_compute(name);
    if (isFinal && num == state().boundariesCrossed) {
      importedMethods_String_values.put(_parameters, importedMethods_String_value);
    } else {
    }

    return importedMethods_String_value;
  }
  /**
   * @apilevel internal
   */
  private Collection importedMethods_compute(String name) {
      Collection set = new HashSet();
      for(Iterator iter = type().memberMethods(name).iterator(); iter.hasNext(); ) {
        MethodDecl decl = (MethodDecl)iter.next();
        if(decl.isStatic() &&
           (decl.isPublic() || (!decl.isPrivate() && decl.hostType().topLevelType().packageName().equals(packageName()))))
          set.add(decl);
      }
      return set;
    }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {    return super.rewriteTo();
  }}
