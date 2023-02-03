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
 * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/grammar/Annotations.ast:12
 * @production ElementAnnotationValue : {@link ElementValue} ::= <span class="component">{@link Annotation}</span>;

 */
public class ElementAnnotationValue extends ElementValue implements Cloneable {
  /**
   * @aspect AnnotationPrettyPrinting
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Annotations.jrag:629
   */
  public void prettyPrint(StringBuffer sb) {
    getAnnotation().prettyPrint(sb);
  }
  /**
   * @declaredat ASTNode:1
   */
  public ElementAnnotationValue() {
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
  public ElementAnnotationValue(Annotation p0) {
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
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:37
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:43
   */
  public ElementAnnotationValue clone() throws CloneNotSupportedException {
    ElementAnnotationValue node = (ElementAnnotationValue) super.clone();
    node.in$Circle(false);
    node.is$Final(false);
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:52
   */
  public ElementAnnotationValue copy() {
    try {
      ElementAnnotationValue node = (ElementAnnotationValue) clone();
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
   * @declaredat ASTNode:70
   */
  public ElementAnnotationValue fullCopy() {
    ElementAnnotationValue tree = (ElementAnnotationValue) copy();
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
   * Replaces the Annotation child.
   * @param node The new node to replace the Annotation child.
   * @apilevel high-level
   */
  public void setAnnotation(Annotation node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the Annotation child.
   * @return The current node used as the Annotation child.
   * @apilevel high-level
   */
  public Annotation getAnnotation() {
    return (Annotation) getChild(0);
  }
  /**
   * Retrieves the Annotation child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Annotation child.
   * @apilevel low-level
   */
  public Annotation getAnnotationNoTransform() {
    return (Annotation) getChildNoTransform(0);
  }
  /**
   * @attribute syn
   * @aspect Annotations
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Annotations.jrag:485
   */
  public boolean commensurateWithTypeDecl(TypeDecl type) {
    ASTNode$State state = state();
    try {
        return type() == type;
      }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect Annotations
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Annotations.jrag:527
   */
  public TypeDecl type() {
    ASTNode$State state = state();
    try {  return getAnnotation().type();  }
    finally {
    }
  }
  /**
   * @attribute inh
   * @aspect Annotations
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Annotations.jrag:433
   */
  public Annotation lookupAnnotation(TypeDecl typeDecl) {
    ASTNode$State state = state();
    Annotation lookupAnnotation_TypeDecl_value = getParent().Define_Annotation_lookupAnnotation(this, null, typeDecl);

    return lookupAnnotation_TypeDecl_value;
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Annotations.jrag:95
   * @apilevel internal
   */
  public boolean Define_boolean_mayUseAnnotationTarget(ASTNode caller, ASTNode child, String name) {
    if (caller == getAnnotationNoTransform()) {
      return true;
    }
    else {
      return getParent().Define_boolean_mayUseAnnotationTarget(this, caller, name);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Annotations.jrag:437
   * @apilevel internal
   */
  public Annotation Define_Annotation_lookupAnnotation(ASTNode caller, ASTNode child, TypeDecl typeDecl) {
    if (caller == getAnnotationNoTransform()) {
      return getAnnotation().type() == typeDecl ? getAnnotation() : lookupAnnotation(typeDecl);
    }
    else {
      return getParent().Define_Annotation_lookupAnnotation(this, caller, typeDecl);
    }
  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {    return super.rewriteTo();
  }}
