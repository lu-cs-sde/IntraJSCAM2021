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
 * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/grammar/Java.ast:9
 * @production ImportDecl : {@link ASTNode} ::= <span class="component">{@link Access}</span>;

 */
public abstract class ImportDecl extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @declaredat ASTNode:1
   */
  public ImportDecl() {
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
  public ImportDecl(Access p0) {
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
  public ImportDecl clone() throws CloneNotSupportedException {
    ImportDecl node = (ImportDecl) super.clone();
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
  protected java.util.Map importedTypes_String_values;
  /**
   * @attribute syn
   * @aspect TypeScopePropagation
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:288
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
  private SimpleSet importedTypes_compute(String name) {  return SimpleSet.emptySet;  }
  /**
   * @attribute syn
   * @aspect TypeScopePropagation
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:317
   */
  public boolean isOnDemand() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect Names
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/QualifiedNames.jrag:52
   */
  public String typeName() {
    ASTNode$State state = state();
    try {
        Access a = getAccess().lastAccess();
        String name = a.isTypeAccess() ? ((TypeAccess)a).nameWithPackage() : "";
        while(a.hasPrevExpr() && a.prevExpr() instanceof Access) {
          Access pred = (Access)a.prevExpr();
          if(pred.isTypeAccess())
            name = ((TypeAccess)pred).nameWithPackage() + "." + name;
          a = pred;
        }
        return name;
      }
    finally {
    }
  }
  protected java.util.Map importedFields_String_values;
  /**
   * @attribute syn
   * @aspect StaticImports
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/StaticImports.jrag:30
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
  private SimpleSet importedFields_compute(String name) {  return SimpleSet.emptySet;  }
  protected java.util.Map importedMethods_String_values;
  /**
   * @attribute syn
   * @aspect StaticImports
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/StaticImports.jrag:48
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
  private Collection importedMethods_compute(String name) {  return Collections.EMPTY_LIST;  }
  /**
   * @attribute inh
   * @aspect TypeScopePropagation
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:315
   */
  public String packageName() {
    ASTNode$State state = state();
    String packageName_value = getParent().Define_String_packageName(this, null);

    return packageName_value;
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DefiniteAssignment.jrag:23
   * @apilevel internal
   */
  public boolean Define_boolean_isDest(ASTNode caller, ASTNode child) {
    if (caller == getAccessNoTransform()) {
      return false;
    }
    else {
      return getParent().Define_boolean_isDest(this, caller);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DefiniteAssignment.jrag:32
   * @apilevel internal
   */
  public boolean Define_boolean_isSource(ASTNode caller, ASTNode child) {
    if (caller == getAccessNoTransform()) {
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
