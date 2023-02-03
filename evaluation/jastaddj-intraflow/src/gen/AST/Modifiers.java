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
 * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/grammar/Java.ast:188
 * @production Modifiers : {@link ASTNode} ::= <span class="component">{@link Modifier}*</span>;

 */
public class Modifiers extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @aspect Modifiers
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:314
   */
  public void checkModifiers() {
    super.checkModifiers();
    if(numProtectionModifiers() > 1)
      error("only one public, protected, private allowed");
    if(numModifier("static") > 1)
      error("only one static allowed");
    // 8.4.3.1
    // 8.4.3.2
    // 8.1.1.2
    if(numCompletenessModifiers() > 1)
      error("only one of final, abstract, volatile allowed");
    if(numModifier("synchronized") > 1)
      error("only one synchronized allowed");
    if(numModifier("transient") > 1)
      error("only one transient allowed");
    if(numModifier("native") > 1)
      error("only one native allowed");
    if(numModifier("strictfp") > 1)
      error("only one strictfp allowed");

    if(isPublic() && !mayBePublic())
      error("modifier public not allowed in this context");
    if(isPrivate() && !mayBePrivate())
      error("modifier private not allowed in this context");
    if(isProtected() && !mayBeProtected())
      error("modifier protected not allowed in this context");
    if(isStatic() && !mayBeStatic())
      error("modifier static not allowed in this context");
    if(isFinal() && !mayBeFinal())
      error("modifier final not allowed in this context");
    if(isAbstract() && !mayBeAbstract())
      error("modifier abstract not allowed in this context");
    if(isVolatile() && !mayBeVolatile())
      error("modifier volatile not allowed in this context");
    if(isTransient() && !mayBeTransient())
      error("modifier transient not allowed in this context");
    if(isStrictfp() && !mayBeStrictfp())
      error("modifier strictfp not allowed in this context");
    if(isSynchronized() && !mayBeSynchronized())
      error("modifier synchronized not allowed in this context");
    if(isNative() && !mayBeNative())
      error("modifier native not allowed in this context");
  }
  /**
   * @aspect PrettyPrint
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/PrettyPrint.jadd:454
   */
  public void prettyPrint(StringBuffer sb) {
    for(int i = 0; i < getNumModifier(); i++) {
      getModifier(i).prettyPrint(sb);
      sb.append(" ");
    }
  }
  /**
   * @declaredat ASTNode:1
   */
  public Modifiers() {
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
    setChild(new List(), 0);
  }
  /**
   * @declaredat ASTNode:14
   */
  public Modifiers(List<Modifier> p0) {
    setChild(p0, 0);
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:20
   */
  protected int numChildren() {
    return 1;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:26
   */
  public boolean mayHaveRewrite() {
    return false;
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:32
   */
  public void flushCache() {
    super.flushCache();
    isPublic_computed = false;
    isPrivate_computed = false;
    isProtected_computed = false;
    isStatic_computed = false;
    isFinal_computed = false;
    isAbstract_computed = false;
    isVolatile_computed = false;
    isTransient_computed = false;
    isStrictfp_computed = false;
    isSynchronized_computed = false;
    isNative_computed = false;
    isSynthetic_computed = false;
    numModifier_String_values = null;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:51
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:57
   */
  public Modifiers clone() throws CloneNotSupportedException {
    Modifiers node = (Modifiers) super.clone();
    node.isPublic_computed = false;
    node.isPrivate_computed = false;
    node.isProtected_computed = false;
    node.isStatic_computed = false;
    node.isFinal_computed = false;
    node.isAbstract_computed = false;
    node.isVolatile_computed = false;
    node.isTransient_computed = false;
    node.isStrictfp_computed = false;
    node.isSynchronized_computed = false;
    node.isNative_computed = false;
    node.isSynthetic_computed = false;
    node.numModifier_String_values = null;
    node.in$Circle(false);
    node.is$Final(false);
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:79
   */
  public Modifiers copy() {
    try {
      Modifiers node = (Modifiers) clone();
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
   * @declaredat ASTNode:97
   */
  public Modifiers fullCopy() {
    Modifiers tree = (Modifiers) copy();
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
   * Replaces the Modifier list.
   * @param list The new list node to be used as the Modifier list.
   * @apilevel high-level
   */
  public void setModifierList(List<Modifier> list) {
    setChild(list, 0);
  }
  /**
   * Retrieves the number of children in the Modifier list.
   * @return Number of children in the Modifier list.
   * @apilevel high-level
   */
  public int getNumModifier() {
    return getModifierList().getNumChild();
  }
  /**
   * Retrieves the number of children in the Modifier list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the Modifier list.
   * @apilevel low-level
   */
  public int getNumModifierNoTransform() {
    return getModifierListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the Modifier list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the Modifier list.
   * @apilevel high-level
   */
  public Modifier getModifier(int i) {
    return (Modifier) getModifierList().getChild(i);
  }
  /**
   * Check whether the Modifier list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasModifier() {
    return getModifierList().getNumChild() != 0;
  }
  /**
   * Append an element to the Modifier list.
   * @param node The element to append to the Modifier list.
   * @apilevel high-level
   */
  public void addModifier(Modifier node) {
    List<Modifier> list = (parent == null || state == null) ? getModifierListNoTransform() : getModifierList();
    list.addChild(node);
  }
  /**
   * @apilevel low-level
   */
  public void addModifierNoTransform(Modifier node) {
    List<Modifier> list = getModifierListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the Modifier list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setModifier(Modifier node, int i) {
    List<Modifier> list = getModifierList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the Modifier list.
   * @return The node representing the Modifier list.
   * @apilevel high-level
   */
  public List<Modifier> getModifierList() {
    List<Modifier> list = (List<Modifier>) getChild(0);
    list.getNumChild();
    return list;
  }
  /**
   * Retrieves the Modifier list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Modifier list.
   * @apilevel low-level
   */
  public List<Modifier> getModifierListNoTransform() {
    return (List<Modifier>) getChildNoTransform(0);
  }
  /**
   * Retrieves the Modifier list.
   * @return The node representing the Modifier list.
   * @apilevel high-level
   */
  public List<Modifier> getModifiers() {
    return getModifierList();
  }
  /**
   * Retrieves the Modifier list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Modifier list.
   * @apilevel low-level
   */
  public List<Modifier> getModifiersNoTransform() {
    return getModifierListNoTransform();
  }
  /**
   * @apilevel internal
   */
  protected boolean isPublic_computed = false;
  /**
   * @apilevel internal
   */
  protected boolean isPublic_value;
  /**
   * @attribute syn
   * @aspect Modifiers
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:372
   */
  public boolean isPublic() {
    if(isPublic_computed) {
      return isPublic_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    isPublic_value = isPublic_compute();
    if (isFinal && num == state().boundariesCrossed) {
      isPublic_computed = true;
    } else {
    }

    return isPublic_value;
  }
  /**
   * @apilevel internal
   */
  private boolean isPublic_compute() {  return numModifier("public") != 0;  }
  /**
   * @apilevel internal
   */
  protected boolean isPrivate_computed = false;
  /**
   * @apilevel internal
   */
  protected boolean isPrivate_value;
  /**
   * @attribute syn
   * @aspect Modifiers
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:373
   */
  public boolean isPrivate() {
    if(isPrivate_computed) {
      return isPrivate_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    isPrivate_value = isPrivate_compute();
    if (isFinal && num == state().boundariesCrossed) {
      isPrivate_computed = true;
    } else {
    }

    return isPrivate_value;
  }
  /**
   * @apilevel internal
   */
  private boolean isPrivate_compute() {  return numModifier("private") != 0;  }
  /**
   * @apilevel internal
   */
  protected boolean isProtected_computed = false;
  /**
   * @apilevel internal
   */
  protected boolean isProtected_value;
  /**
   * @attribute syn
   * @aspect Modifiers
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:374
   */
  public boolean isProtected() {
    if(isProtected_computed) {
      return isProtected_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    isProtected_value = isProtected_compute();
    if (isFinal && num == state().boundariesCrossed) {
      isProtected_computed = true;
    } else {
    }

    return isProtected_value;
  }
  /**
   * @apilevel internal
   */
  private boolean isProtected_compute() {  return numModifier("protected") != 0;  }
  /**
   * @apilevel internal
   */
  protected boolean isStatic_computed = false;
  /**
   * @apilevel internal
   */
  protected boolean isStatic_value;
  /**
   * @attribute syn
   * @aspect Modifiers
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:375
   */
  public boolean isStatic() {
    if(isStatic_computed) {
      return isStatic_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    isStatic_value = isStatic_compute();
    if (isFinal && num == state().boundariesCrossed) {
      isStatic_computed = true;
    } else {
    }

    return isStatic_value;
  }
  /**
   * @apilevel internal
   */
  private boolean isStatic_compute() {  return numModifier("static") != 0;  }
  /**
   * @apilevel internal
   */
  protected boolean isFinal_computed = false;
  /**
   * @apilevel internal
   */
  protected boolean isFinal_value;
  /**
   * @attribute syn
   * @aspect Modifiers
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:376
   */
  public boolean isFinal() {
    if(isFinal_computed) {
      return isFinal_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    isFinal_value = isFinal_compute();
    if (isFinal && num == state().boundariesCrossed) {
      isFinal_computed = true;
    } else {
    }

    return isFinal_value;
  }
  /**
   * @apilevel internal
   */
  private boolean isFinal_compute() {  return numModifier("final") != 0;  }
  /**
   * @apilevel internal
   */
  protected boolean isAbstract_computed = false;
  /**
   * @apilevel internal
   */
  protected boolean isAbstract_value;
  /**
   * @attribute syn
   * @aspect Modifiers
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:377
   */
  public boolean isAbstract() {
    if(isAbstract_computed) {
      return isAbstract_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    isAbstract_value = isAbstract_compute();
    if (isFinal && num == state().boundariesCrossed) {
      isAbstract_computed = true;
    } else {
    }

    return isAbstract_value;
  }
  /**
   * @apilevel internal
   */
  private boolean isAbstract_compute() {  return numModifier("abstract") != 0;  }
  /**
   * @apilevel internal
   */
  protected boolean isVolatile_computed = false;
  /**
   * @apilevel internal
   */
  protected boolean isVolatile_value;
  /**
   * @attribute syn
   * @aspect Modifiers
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:378
   */
  public boolean isVolatile() {
    if(isVolatile_computed) {
      return isVolatile_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    isVolatile_value = isVolatile_compute();
    if (isFinal && num == state().boundariesCrossed) {
      isVolatile_computed = true;
    } else {
    }

    return isVolatile_value;
  }
  /**
   * @apilevel internal
   */
  private boolean isVolatile_compute() {  return numModifier("volatile") != 0;  }
  /**
   * @apilevel internal
   */
  protected boolean isTransient_computed = false;
  /**
   * @apilevel internal
   */
  protected boolean isTransient_value;
  /**
   * @attribute syn
   * @aspect Modifiers
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:379
   */
  public boolean isTransient() {
    if(isTransient_computed) {
      return isTransient_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    isTransient_value = isTransient_compute();
    if (isFinal && num == state().boundariesCrossed) {
      isTransient_computed = true;
    } else {
    }

    return isTransient_value;
  }
  /**
   * @apilevel internal
   */
  private boolean isTransient_compute() {  return numModifier("transient") != 0;  }
  /**
   * @apilevel internal
   */
  protected boolean isStrictfp_computed = false;
  /**
   * @apilevel internal
   */
  protected boolean isStrictfp_value;
  /**
   * @attribute syn
   * @aspect Modifiers
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:380
   */
  public boolean isStrictfp() {
    if(isStrictfp_computed) {
      return isStrictfp_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    isStrictfp_value = isStrictfp_compute();
    if (isFinal && num == state().boundariesCrossed) {
      isStrictfp_computed = true;
    } else {
    }

    return isStrictfp_value;
  }
  /**
   * @apilevel internal
   */
  private boolean isStrictfp_compute() {  return numModifier("strictfp") != 0;  }
  /**
   * @apilevel internal
   */
  protected boolean isSynchronized_computed = false;
  /**
   * @apilevel internal
   */
  protected boolean isSynchronized_value;
  /**
   * @attribute syn
   * @aspect Modifiers
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:381
   */
  public boolean isSynchronized() {
    if(isSynchronized_computed) {
      return isSynchronized_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    isSynchronized_value = isSynchronized_compute();
    if (isFinal && num == state().boundariesCrossed) {
      isSynchronized_computed = true;
    } else {
    }

    return isSynchronized_value;
  }
  /**
   * @apilevel internal
   */
  private boolean isSynchronized_compute() {  return numModifier("synchronized") != 0;  }
  /**
   * @apilevel internal
   */
  protected boolean isNative_computed = false;
  /**
   * @apilevel internal
   */
  protected boolean isNative_value;
  /**
   * @attribute syn
   * @aspect Modifiers
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:382
   */
  public boolean isNative() {
    if(isNative_computed) {
      return isNative_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    isNative_value = isNative_compute();
    if (isFinal && num == state().boundariesCrossed) {
      isNative_computed = true;
    } else {
    }

    return isNative_value;
  }
  /**
   * @apilevel internal
   */
  private boolean isNative_compute() {  return numModifier("native") != 0;  }
  /**
   * @apilevel internal
   */
  protected boolean isSynthetic_computed = false;
  /**
   * @apilevel internal
   */
  protected boolean isSynthetic_value;
  /**
   * @attribute syn
   * @aspect Modifiers
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:384
   */
  public boolean isSynthetic() {
    if(isSynthetic_computed) {
      return isSynthetic_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    isSynthetic_value = isSynthetic_compute();
    if (isFinal && num == state().boundariesCrossed) {
      isSynthetic_computed = true;
    } else {
    }

    return isSynthetic_value;
  }
  /**
   * @apilevel internal
   */
  private boolean isSynthetic_compute() {  return numModifier("synthetic") != 0;  }
  /**
   * @attribute syn
   * @aspect Modifiers
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:386
   */
  public int numProtectionModifiers() {
    ASTNode$State state = state();
    try {  return numModifier("public") + numModifier("protected") + numModifier("private");  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect Modifiers
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:389
   */
  public int numCompletenessModifiers() {
    ASTNode$State state = state();
    try {  return numModifier("abstract") + numModifier("final") + numModifier("volatile");  }
    finally {
    }
  }
  protected java.util.Map numModifier_String_values;
  /**
   * @attribute syn
   * @aspect Modifiers
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:392
   */
  public int numModifier(String name) {
    Object _parameters = name;
    if (numModifier_String_values == null) numModifier_String_values = new org.jastadd.util.RobustMap(new java.util.HashMap());
    if(numModifier_String_values.containsKey(_parameters)) {
      return ((Integer)numModifier_String_values.get(_parameters)).intValue();
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    int numModifier_String_value = numModifier_compute(name);
    if (isFinal && num == state().boundariesCrossed) {
      numModifier_String_values.put(_parameters, Integer.valueOf(numModifier_String_value));
    } else {
    }

    return numModifier_String_value;
  }
  /**
   * @apilevel internal
   */
  private int numModifier_compute(String name) {
      int n = 0;
      for(int i = 0; i < getNumModifier(); i++) {
        String s = getModifier(i).getID();
        if(s.equals(name))
          n++;
      }
      return n;
    }
  /**
   * @attribute syn
   * @aspect Annotations
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Annotations.jrag:222
   */
  public Annotation annotation(TypeDecl typeDecl) {
    ASTNode$State state = state();
    try {
        for(int i = 0; i < getNumModifier(); i++) {
          if(getModifier(i) instanceof Annotation) {
            Annotation a = (Annotation)getModifier(i);
            if(a.type() == typeDecl)
              return a;
          }
        }
        return null;
      }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect Annotations
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Annotations.jrag:298
   */
  public boolean hasAnnotationSuppressWarnings(String annot) {
    ASTNode$State state = state();
    try {
        Annotation a = annotation(lookupType("java.lang", "SuppressWarnings"));
        if(a != null && a.getNumElementValuePair() == 1 && a.getElementValuePair(0).getName().equals("value"))
          return a.getElementValuePair(0).getElementValue().hasValue(annot);
        return false;
      }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect Annotations
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Annotations.jrag:328
   */
  public boolean hasDeprecatedAnnotation() {
    ASTNode$State state = state();
    try {  return annotation(lookupType("java.lang", "Deprecated")) != null;  }
    finally {
    }
  }
  /**
   * @attribute inh
   * @aspect Modifiers
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:358
   */
  public TypeDecl hostType() {
    ASTNode$State state = state();
    TypeDecl hostType_value = getParent().Define_TypeDecl_hostType(this, null);

    return hostType_value;
  }
  /**
   * @attribute inh
   * @aspect Modifiers
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:360
   */
  public boolean mayBePublic() {
    ASTNode$State state = state();
    boolean mayBePublic_value = getParent().Define_boolean_mayBePublic(this, null);

    return mayBePublic_value;
  }
  /**
   * @attribute inh
   * @aspect Modifiers
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:361
   */
  public boolean mayBePrivate() {
    ASTNode$State state = state();
    boolean mayBePrivate_value = getParent().Define_boolean_mayBePrivate(this, null);

    return mayBePrivate_value;
  }
  /**
   * @attribute inh
   * @aspect Modifiers
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:362
   */
  public boolean mayBeProtected() {
    ASTNode$State state = state();
    boolean mayBeProtected_value = getParent().Define_boolean_mayBeProtected(this, null);

    return mayBeProtected_value;
  }
  /**
   * @attribute inh
   * @aspect Modifiers
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:363
   */
  public boolean mayBeStatic() {
    ASTNode$State state = state();
    boolean mayBeStatic_value = getParent().Define_boolean_mayBeStatic(this, null);

    return mayBeStatic_value;
  }
  /**
   * @attribute inh
   * @aspect Modifiers
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:364
   */
  public boolean mayBeFinal() {
    ASTNode$State state = state();
    boolean mayBeFinal_value = getParent().Define_boolean_mayBeFinal(this, null);

    return mayBeFinal_value;
  }
  /**
   * @attribute inh
   * @aspect Modifiers
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:365
   */
  public boolean mayBeAbstract() {
    ASTNode$State state = state();
    boolean mayBeAbstract_value = getParent().Define_boolean_mayBeAbstract(this, null);

    return mayBeAbstract_value;
  }
  /**
   * @attribute inh
   * @aspect Modifiers
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:366
   */
  public boolean mayBeVolatile() {
    ASTNode$State state = state();
    boolean mayBeVolatile_value = getParent().Define_boolean_mayBeVolatile(this, null);

    return mayBeVolatile_value;
  }
  /**
   * @attribute inh
   * @aspect Modifiers
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:367
   */
  public boolean mayBeTransient() {
    ASTNode$State state = state();
    boolean mayBeTransient_value = getParent().Define_boolean_mayBeTransient(this, null);

    return mayBeTransient_value;
  }
  /**
   * @attribute inh
   * @aspect Modifiers
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:368
   */
  public boolean mayBeStrictfp() {
    ASTNode$State state = state();
    boolean mayBeStrictfp_value = getParent().Define_boolean_mayBeStrictfp(this, null);

    return mayBeStrictfp_value;
  }
  /**
   * @attribute inh
   * @aspect Modifiers
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:369
   */
  public boolean mayBeSynchronized() {
    ASTNode$State state = state();
    boolean mayBeSynchronized_value = getParent().Define_boolean_mayBeSynchronized(this, null);

    return mayBeSynchronized_value;
  }
  /**
   * @attribute inh
   * @aspect Modifiers
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:370
   */
  public boolean mayBeNative() {
    ASTNode$State state = state();
    boolean mayBeNative_value = getParent().Define_boolean_mayBeNative(this, null);

    return mayBeNative_value;
  }
  /**
   * @attribute inh
   * @aspect Annotations
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Annotations.jrag:56
   */
  public TypeDecl lookupType(String packageName, String typeName) {
    ASTNode$State state = state();
    TypeDecl lookupType_String_String_value = getParent().Define_TypeDecl_lookupType(this, null, packageName, typeName);

    return lookupType_String_String_value;
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Annotations.jrag:434
   * @apilevel internal
   */
  public Annotation Define_Annotation_lookupAnnotation(ASTNode caller, ASTNode child, TypeDecl typeDecl) {
    if (caller == getModifierListNoTransform()) {
      int index = caller.getIndexOfChild(child);
      {
    return annotation(typeDecl);
  }
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
