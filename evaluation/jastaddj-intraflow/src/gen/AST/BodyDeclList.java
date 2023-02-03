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
 * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/grammar/Generics.ast:13
 * @production BodyDeclList : {@link List};

 */
public class BodyDeclList extends List implements Cloneable {
  /**
   * @declaredat ASTNode:1
   */
  public BodyDeclList() {
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
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:16
   */
  protected int numChildren() {
    return 0;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:22
   */
  public boolean mayHaveRewrite() {
    return false;
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:28
   */
  public void flushCache() {
    super.flushCache();
    localMethodSignatureCopy_MethodDecl_MemberSubstitutor_values = null;
    localMethodSignatureCopy_MethodDecl_MemberSubstitutor_list = null;localFieldCopy_FieldDeclaration_MemberSubstitutor_values = null;
    localFieldCopy_FieldDeclaration_MemberSubstitutor_list = null;localClassDeclCopy_ClassDecl_MemberSubstitutor_values = null;
    localClassDeclCopy_ClassDecl_MemberSubstitutor_list = null;localInterfaceDeclCopy_InterfaceDecl_MemberSubstitutor_values = null;
    localInterfaceDeclCopy_InterfaceDecl_MemberSubstitutor_list = null;constructorCopy_ConstructorDecl_MemberSubstitutor_values = null;
    constructorCopy_ConstructorDecl_MemberSubstitutor_list = null;
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
  public BodyDeclList clone() throws CloneNotSupportedException {
    BodyDeclList node = (BodyDeclList) super.clone();
    node.localMethodSignatureCopy_MethodDecl_MemberSubstitutor_values = null;
    node.localMethodSignatureCopy_MethodDecl_MemberSubstitutor_list = null;node.localFieldCopy_FieldDeclaration_MemberSubstitutor_values = null;
    node.localFieldCopy_FieldDeclaration_MemberSubstitutor_list = null;node.localClassDeclCopy_ClassDecl_MemberSubstitutor_values = null;
    node.localClassDeclCopy_ClassDecl_MemberSubstitutor_list = null;node.localInterfaceDeclCopy_InterfaceDecl_MemberSubstitutor_values = null;
    node.localInterfaceDeclCopy_InterfaceDecl_MemberSubstitutor_list = null;node.constructorCopy_ConstructorDecl_MemberSubstitutor_values = null;
    node.constructorCopy_ConstructorDecl_MemberSubstitutor_list = null;node.in$Circle(false);
    node.is$Final(false);
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:60
   */
  public BodyDeclList copy() {
    try {
      BodyDeclList node = (BodyDeclList) clone();
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
   * @declaredat ASTNode:78
   */
  public BodyDeclList fullCopy() {
    BodyDeclList tree = (BodyDeclList) copy();
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
   * @apilevel internal
   */
  protected java.util.Map localMethodSignatureCopy_MethodDecl_MemberSubstitutor_values;
  /**
   * @apilevel internal
   */
  protected List localMethodSignatureCopy_MethodDecl_MemberSubstitutor_list;
  /**
   * @attribute syn
   * @aspect LookupParTypeDecl
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Generics.jrag:966
   */
  public BodyDecl localMethodSignatureCopy(MethodDecl originalMethod, MemberSubstitutor m) {
    java.util.List _parameters = new java.util.ArrayList(2);
    _parameters.add(originalMethod);
    _parameters.add(m);
    if (localMethodSignatureCopy_MethodDecl_MemberSubstitutor_values == null) localMethodSignatureCopy_MethodDecl_MemberSubstitutor_values = new org.jastadd.util.RobustMap(new java.util.HashMap());
    if(localMethodSignatureCopy_MethodDecl_MemberSubstitutor_values.containsKey(_parameters)) {
      return (BodyDecl)localMethodSignatureCopy_MethodDecl_MemberSubstitutor_values.get(_parameters);
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    BodyDecl localMethodSignatureCopy_MethodDecl_MemberSubstitutor_value = localMethodSignatureCopy_compute(originalMethod, m);
    if(localMethodSignatureCopy_MethodDecl_MemberSubstitutor_list == null) {
      localMethodSignatureCopy_MethodDecl_MemberSubstitutor_list = new List();
      localMethodSignatureCopy_MethodDecl_MemberSubstitutor_list.is$Final = true;
      localMethodSignatureCopy_MethodDecl_MemberSubstitutor_list.setParent(this);
    }
    localMethodSignatureCopy_MethodDecl_MemberSubstitutor_list.add(localMethodSignatureCopy_MethodDecl_MemberSubstitutor_value);
    if(localMethodSignatureCopy_MethodDecl_MemberSubstitutor_value != null) {
      localMethodSignatureCopy_MethodDecl_MemberSubstitutor_value = (BodyDecl) localMethodSignatureCopy_MethodDecl_MemberSubstitutor_list.getChild(localMethodSignatureCopy_MethodDecl_MemberSubstitutor_list.numChildren-1);
      localMethodSignatureCopy_MethodDecl_MemberSubstitutor_value.is$Final = true;
    }
    if (true) {
      localMethodSignatureCopy_MethodDecl_MemberSubstitutor_values.put(_parameters, localMethodSignatureCopy_MethodDecl_MemberSubstitutor_value);
    } else {
    }

    return localMethodSignatureCopy_MethodDecl_MemberSubstitutor_value;
  }
  /**
   * @apilevel internal
   */
  private BodyDecl localMethodSignatureCopy_compute(MethodDecl originalMethod, MemberSubstitutor m) {
       return originalMethod.substitutedBodyDecl(m);
    }
  /**
   * @apilevel internal
   */
  protected java.util.Map localFieldCopy_FieldDeclaration_MemberSubstitutor_values;
  /**
   * @apilevel internal
   */
  protected List localFieldCopy_FieldDeclaration_MemberSubstitutor_list;
  /**
   * @attribute syn
   * @aspect LookupParTypeDecl
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Generics.jrag:985
   */
  public BodyDecl localFieldCopy(FieldDeclaration originalDecl, MemberSubstitutor m) {
    java.util.List _parameters = new java.util.ArrayList(2);
    _parameters.add(originalDecl);
    _parameters.add(m);
    if (localFieldCopy_FieldDeclaration_MemberSubstitutor_values == null) localFieldCopy_FieldDeclaration_MemberSubstitutor_values = new org.jastadd.util.RobustMap(new java.util.HashMap());
    if(localFieldCopy_FieldDeclaration_MemberSubstitutor_values.containsKey(_parameters)) {
      return (BodyDecl)localFieldCopy_FieldDeclaration_MemberSubstitutor_values.get(_parameters);
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    BodyDecl localFieldCopy_FieldDeclaration_MemberSubstitutor_value = localFieldCopy_compute(originalDecl, m);
    if(localFieldCopy_FieldDeclaration_MemberSubstitutor_list == null) {
      localFieldCopy_FieldDeclaration_MemberSubstitutor_list = new List();
      localFieldCopy_FieldDeclaration_MemberSubstitutor_list.is$Final = true;
      localFieldCopy_FieldDeclaration_MemberSubstitutor_list.setParent(this);
    }
    localFieldCopy_FieldDeclaration_MemberSubstitutor_list.add(localFieldCopy_FieldDeclaration_MemberSubstitutor_value);
    if(localFieldCopy_FieldDeclaration_MemberSubstitutor_value != null) {
      localFieldCopy_FieldDeclaration_MemberSubstitutor_value = (BodyDecl) localFieldCopy_FieldDeclaration_MemberSubstitutor_list.getChild(localFieldCopy_FieldDeclaration_MemberSubstitutor_list.numChildren-1);
      localFieldCopy_FieldDeclaration_MemberSubstitutor_value.is$Final = true;
    }
    if (true) {
      localFieldCopy_FieldDeclaration_MemberSubstitutor_values.put(_parameters, localFieldCopy_FieldDeclaration_MemberSubstitutor_value);
    } else {
    }

    return localFieldCopy_FieldDeclaration_MemberSubstitutor_value;
  }
  /**
   * @apilevel internal
   */
  private BodyDecl localFieldCopy_compute(FieldDeclaration originalDecl, MemberSubstitutor m) {
      return originalDecl.substitutedBodyDecl(m);
    }
  /**
   * @apilevel internal
   */
  protected java.util.Map localClassDeclCopy_ClassDecl_MemberSubstitutor_values;
  /**
   * @apilevel internal
   */
  protected List localClassDeclCopy_ClassDecl_MemberSubstitutor_list;
  /**
   * @attribute syn
   * @aspect LookupParTypeDecl
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Generics.jrag:1009
   */
  public MemberClassDecl localClassDeclCopy(ClassDecl originalDecl, MemberSubstitutor m) {
    java.util.List _parameters = new java.util.ArrayList(2);
    _parameters.add(originalDecl);
    _parameters.add(m);
    if (localClassDeclCopy_ClassDecl_MemberSubstitutor_values == null) localClassDeclCopy_ClassDecl_MemberSubstitutor_values = new org.jastadd.util.RobustMap(new java.util.HashMap());
    if(localClassDeclCopy_ClassDecl_MemberSubstitutor_values.containsKey(_parameters)) {
      return (MemberClassDecl)localClassDeclCopy_ClassDecl_MemberSubstitutor_values.get(_parameters);
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    MemberClassDecl localClassDeclCopy_ClassDecl_MemberSubstitutor_value = localClassDeclCopy_compute(originalDecl, m);
    if(localClassDeclCopy_ClassDecl_MemberSubstitutor_list == null) {
      localClassDeclCopy_ClassDecl_MemberSubstitutor_list = new List();
      localClassDeclCopy_ClassDecl_MemberSubstitutor_list.is$Final = true;
      localClassDeclCopy_ClassDecl_MemberSubstitutor_list.setParent(this);
    }
    localClassDeclCopy_ClassDecl_MemberSubstitutor_list.add(localClassDeclCopy_ClassDecl_MemberSubstitutor_value);
    if(localClassDeclCopy_ClassDecl_MemberSubstitutor_value != null) {
      localClassDeclCopy_ClassDecl_MemberSubstitutor_value = (MemberClassDecl) localClassDeclCopy_ClassDecl_MemberSubstitutor_list.getChild(localClassDeclCopy_ClassDecl_MemberSubstitutor_list.numChildren-1);
      localClassDeclCopy_ClassDecl_MemberSubstitutor_value.is$Final = true;
    }
    if (true) {
      localClassDeclCopy_ClassDecl_MemberSubstitutor_values.put(_parameters, localClassDeclCopy_ClassDecl_MemberSubstitutor_value);
    } else {
    }

    return localClassDeclCopy_ClassDecl_MemberSubstitutor_value;
  }
  /**
   * @apilevel internal
   */
  private MemberClassDecl localClassDeclCopy_compute(ClassDecl originalDecl, MemberSubstitutor m) {
      ClassDecl copy = originalDecl.substitutedClassDecl(m);
      return new MemberClassDecl(copy);
    }
  /**
   * @apilevel internal
   */
  protected java.util.Map localInterfaceDeclCopy_InterfaceDecl_MemberSubstitutor_values;
  /**
   * @apilevel internal
   */
  protected List localInterfaceDeclCopy_InterfaceDecl_MemberSubstitutor_list;
  /**
   * @attribute syn
   * @aspect LookupParTypeDecl
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Generics.jrag:1013
   */
  public MemberInterfaceDecl localInterfaceDeclCopy(InterfaceDecl originalDecl, MemberSubstitutor m) {
    java.util.List _parameters = new java.util.ArrayList(2);
    _parameters.add(originalDecl);
    _parameters.add(m);
    if (localInterfaceDeclCopy_InterfaceDecl_MemberSubstitutor_values == null) localInterfaceDeclCopy_InterfaceDecl_MemberSubstitutor_values = new org.jastadd.util.RobustMap(new java.util.HashMap());
    if(localInterfaceDeclCopy_InterfaceDecl_MemberSubstitutor_values.containsKey(_parameters)) {
      return (MemberInterfaceDecl)localInterfaceDeclCopy_InterfaceDecl_MemberSubstitutor_values.get(_parameters);
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    MemberInterfaceDecl localInterfaceDeclCopy_InterfaceDecl_MemberSubstitutor_value = localInterfaceDeclCopy_compute(originalDecl, m);
    if(localInterfaceDeclCopy_InterfaceDecl_MemberSubstitutor_list == null) {
      localInterfaceDeclCopy_InterfaceDecl_MemberSubstitutor_list = new List();
      localInterfaceDeclCopy_InterfaceDecl_MemberSubstitutor_list.is$Final = true;
      localInterfaceDeclCopy_InterfaceDecl_MemberSubstitutor_list.setParent(this);
    }
    localInterfaceDeclCopy_InterfaceDecl_MemberSubstitutor_list.add(localInterfaceDeclCopy_InterfaceDecl_MemberSubstitutor_value);
    if(localInterfaceDeclCopy_InterfaceDecl_MemberSubstitutor_value != null) {
      localInterfaceDeclCopy_InterfaceDecl_MemberSubstitutor_value = (MemberInterfaceDecl) localInterfaceDeclCopy_InterfaceDecl_MemberSubstitutor_list.getChild(localInterfaceDeclCopy_InterfaceDecl_MemberSubstitutor_list.numChildren-1);
      localInterfaceDeclCopy_InterfaceDecl_MemberSubstitutor_value.is$Final = true;
    }
    if (true) {
      localInterfaceDeclCopy_InterfaceDecl_MemberSubstitutor_values.put(_parameters, localInterfaceDeclCopy_InterfaceDecl_MemberSubstitutor_value);
    } else {
    }

    return localInterfaceDeclCopy_InterfaceDecl_MemberSubstitutor_value;
  }
  /**
   * @apilevel internal
   */
  private MemberInterfaceDecl localInterfaceDeclCopy_compute(InterfaceDecl originalDecl, MemberSubstitutor m) {
      InterfaceDecl copy = originalDecl.substitutedInterfaceDecl(m);
      return new MemberInterfaceDecl(copy);
    }
  /**
   * @apilevel internal
   */
  protected java.util.Map constructorCopy_ConstructorDecl_MemberSubstitutor_values;
  /**
   * @apilevel internal
   */
  protected List constructorCopy_ConstructorDecl_MemberSubstitutor_list;
  /**
   * @attribute syn
   * @aspect LookupParTypeDecl
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Generics.jrag:1030
   */
  public BodyDecl constructorCopy(ConstructorDecl originalDecl, MemberSubstitutor m) {
    java.util.List _parameters = new java.util.ArrayList(2);
    _parameters.add(originalDecl);
    _parameters.add(m);
    if (constructorCopy_ConstructorDecl_MemberSubstitutor_values == null) constructorCopy_ConstructorDecl_MemberSubstitutor_values = new org.jastadd.util.RobustMap(new java.util.HashMap());
    if(constructorCopy_ConstructorDecl_MemberSubstitutor_values.containsKey(_parameters)) {
      return (BodyDecl)constructorCopy_ConstructorDecl_MemberSubstitutor_values.get(_parameters);
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    BodyDecl constructorCopy_ConstructorDecl_MemberSubstitutor_value = constructorCopy_compute(originalDecl, m);
    if(constructorCopy_ConstructorDecl_MemberSubstitutor_list == null) {
      constructorCopy_ConstructorDecl_MemberSubstitutor_list = new List();
      constructorCopy_ConstructorDecl_MemberSubstitutor_list.is$Final = true;
      constructorCopy_ConstructorDecl_MemberSubstitutor_list.setParent(this);
    }
    constructorCopy_ConstructorDecl_MemberSubstitutor_list.add(constructorCopy_ConstructorDecl_MemberSubstitutor_value);
    if(constructorCopy_ConstructorDecl_MemberSubstitutor_value != null) {
      constructorCopy_ConstructorDecl_MemberSubstitutor_value = (BodyDecl) constructorCopy_ConstructorDecl_MemberSubstitutor_list.getChild(constructorCopy_ConstructorDecl_MemberSubstitutor_list.numChildren-1);
      constructorCopy_ConstructorDecl_MemberSubstitutor_value.is$Final = true;
    }
    if (true) {
      constructorCopy_ConstructorDecl_MemberSubstitutor_values.put(_parameters, constructorCopy_ConstructorDecl_MemberSubstitutor_value);
    } else {
    }

    return constructorCopy_ConstructorDecl_MemberSubstitutor_value;
  }
  /**
   * @apilevel internal
   */
  private BodyDecl constructorCopy_compute(ConstructorDecl originalDecl, MemberSubstitutor m) {
      return originalDecl.substitutedBodyDecl(m);
    }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {    return super.rewriteTo();
  }}
