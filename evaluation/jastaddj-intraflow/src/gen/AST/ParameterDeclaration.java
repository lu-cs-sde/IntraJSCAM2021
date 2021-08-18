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
 * A parameter declaration as used in either method parameter lists
 * or as a catch clause parameter.
 * @ast node
 * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/grammar/Java.ast:90
 * @production ParameterDeclaration : {@link ASTNode} ::= <span class="component">{@link Modifiers}</span> <span class="component">TypeAccess:{@link Access}</span> <span class="component">&lt;ID:String&gt;</span>;

 */
public class ParameterDeclaration extends ASTNode<ASTNode> implements Cloneable, SimpleSet, Iterator, Variable, CFGNode {
  /**
   * @aspect DataStructures
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DataStructures.jrag:117
   */
  public SimpleSet add(Object o) {
    return new SimpleSetImpl().add(this).add(o);
  }
  /**
   * @aspect DataStructures
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DataStructures.jrag:121
   */
  public boolean isSingleton() { return true; }
  /**
   * @aspect DataStructures
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DataStructures.jrag:122
   */
  public boolean isSingleton(Object o) { return contains(o); }
  /**
   * @aspect DataStructures
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DataStructures.jrag:125
   */
  private ParameterDeclaration iterElem;
  /**
   * @aspect DataStructures
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DataStructures.jrag:126
   */
  public Iterator iterator() { iterElem = this; return this; }
  /**
   * @aspect DataStructures
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DataStructures.jrag:127
   */
  public boolean hasNext() { return iterElem != null; }
  /**
   * @aspect DataStructures
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DataStructures.jrag:128
   */
  public Object next() { Object o = iterElem; iterElem = null; return o; }
  /**
   * @aspect DataStructures
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DataStructures.jrag:129
   */
  public void remove() { throw new UnsupportedOperationException(); }
  /**
   * @aspect NameCheck
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/NameCheck.jrag:359
   */
  public void nameCheck() {
    SimpleSet decls = outerScope().lookupVariable(name());
    for(Iterator iter = decls.iterator(); iter.hasNext(); ) {
      Variable var = (Variable)iter.next();
      if(var instanceof VariableDeclaration) {
        VariableDeclaration decl = (VariableDeclaration)var;
        if(decl.enclosingBodyDecl() == enclosingBodyDecl())
          error("duplicate declaration of local variable " + name());
      }
      else if(var instanceof ParameterDeclaration) {
        ParameterDeclaration decl = (ParameterDeclaration)var;
        if(decl.enclosingBodyDecl() == enclosingBodyDecl())
          error("duplicate declaration of local variable " + name());
      }
    }

    // 8.4.1
    if(!lookupVariable(name()).contains(this)) {
      error("duplicate declaration of parameter " + name());
    }
  }
  /**
   * @aspect NodeConstructors
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/NodeConstructors.jrag:11
   */
  public ParameterDeclaration(Access type, String name) {
    this(new Modifiers(new List()), type, name);
  }
  /**
   * @aspect NodeConstructors
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/NodeConstructors.jrag:14
   */
  public ParameterDeclaration(TypeDecl type, String name) {
    this(new Modifiers(new List()), type.createQualifiedAccess(), name);
  }
  /**
   * @aspect PrettyPrint
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/PrettyPrint.jadd:249
   */
  public void prettyPrint(StringBuffer sb) {
    getModifiers().prettyPrint(sb);
    getTypeAccess().prettyPrint(sb);
    sb.append(" " + name());
  }
  /**
   * @aspect Java_CFG_1_4
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:30
   */
  public SmallSet<CFGNode> pred() { return collPred(); }
  /**
   * @aspect JavaLiveness14
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaLiveness1.4.jrag:16
   */
  public BitSet liveness_out() { return coll_liveness_out(); }
  /**
   * @declaredat ASTNode:1
   */
  public ParameterDeclaration() {
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
  }
  /**
   * @declaredat ASTNode:13
   */
  public ParameterDeclaration(Modifiers p0, Access p1, String p2) {
    setChild(p0, 0);
    setChild(p1, 1);
    setID(p2);
  }
  /**
   * @declaredat ASTNode:18
   */
  public ParameterDeclaration(Modifiers p0, Access p1, beaver.Symbol p2) {
    setChild(p0, 0);
    setChild(p1, 1);
    setID(p2);
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:26
   */
  protected int numChildren() {
    return 2;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:32
   */
  public boolean mayHaveRewrite() {
    return false;
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:38
   */
  public void flushCache() {
    super.flushCache();
    type_computed = false;
    type_value = null;
    sourceVariableDecl_computed = false;
    sourceVariableDecl_value = null;
    exceptionalSucc_computed = false;
    exceptionalSucc_value = null;
    succ_computed = false;
    succ_value = null;
    includeInDeadAssignAnalysis_computed = false;
    isDeadAssign_computed = false;
    isDead_computed = false;
    liveness_in_visited = -1;
    liveness_in_computed = false;
    liveness_in_initialized = false;
    liveness_in_value = null;
    emptySmallSet_computed = false;
    emptySmallSet_value = null;
    following_computed = false;
    following_value = null;
    enclosingCompilationUnit_computed = false;
    enclosingCompilationUnit_value = null;
    emptyBitSet_computed = false;
    emptyBitSet_value = null;
    CFGNode_collPred_computed = false;
    CFGNode_collPred_value = null;
        CFGNode_collPred_contributors = null;
    CFGNode_def_computed = false;
    CFGNode_def_value = null;
        CFGNode_def_contributors = null;
    CFGNode_coll_liveness_out_visited = -1;
    CFGNode_coll_liveness_out_computed = false;
    CFGNode_coll_liveness_out_initialized = false;
    CFGNode_coll_liveness_out_value = null;
        CFGNode_coll_liveness_out_contributors = null;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:78
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
    CFGNode_collPred_computed = false;
    CFGNode_collPred_value = null;
        CFGNode_collPred_contributors = null;
    CFGNode_def_computed = false;
    CFGNode_def_value = null;
        CFGNode_def_contributors = null;
    CFGNode_coll_liveness_out_visited = -1;
    CFGNode_coll_liveness_out_computed = false;
    CFGNode_coll_liveness_out_initialized = false;
    CFGNode_coll_liveness_out_value = null;
        CFGNode_coll_liveness_out_contributors = null;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:95
   */
  public ParameterDeclaration clone() throws CloneNotSupportedException {
    ParameterDeclaration node = (ParameterDeclaration) super.clone();
    node.type_computed = false;
    node.type_value = null;
    node.sourceVariableDecl_computed = false;
    node.sourceVariableDecl_value = null;
    node.exceptionalSucc_computed = false;
    node.exceptionalSucc_value = null;
    node.succ_computed = false;
    node.succ_value = null;
    node.includeInDeadAssignAnalysis_computed = false;
    node.isDeadAssign_computed = false;
    node.isDead_computed = false;
    node.liveness_in_visited = -1;
    node.liveness_in_computed = false;
    node.liveness_in_initialized = false;
    node.liveness_in_value = null;
    node.emptySmallSet_computed = false;
    node.emptySmallSet_value = null;
    node.following_computed = false;
    node.following_value = null;
    node.enclosingCompilationUnit_computed = false;
    node.enclosingCompilationUnit_value = null;
    node.emptyBitSet_computed = false;
    node.emptyBitSet_value = null;
    node.in$Circle(false);
    node.is$Final(false);
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:127
   */
  public ParameterDeclaration copy() {
    try {
      ParameterDeclaration node = (ParameterDeclaration) clone();
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
   * @declaredat ASTNode:145
   */
  public ParameterDeclaration fullCopy() {
    ParameterDeclaration tree = (ParameterDeclaration) copy();
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
   * Replaces the TypeAccess child.
   * @param node The new node to replace the TypeAccess child.
   * @apilevel high-level
   */
  public void setTypeAccess(Access node) {
    setChild(node, 1);
  }
  /**
   * Retrieves the TypeAccess child.
   * @return The current node used as the TypeAccess child.
   * @apilevel high-level
   */
  public Access getTypeAccess() {
    return (Access) getChild(1);
  }
  /**
   * Retrieves the TypeAccess child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the TypeAccess child.
   * @apilevel low-level
   */
  public Access getTypeAccessNoTransform() {
    return (Access) getChildNoTransform(1);
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
   * @attribute syn
   * @aspect DataStructures
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DataStructures.jrag:115
   */
  public int size() {
    ASTNode$State state = state();
    try {  return 1;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect DataStructures
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DataStructures.jrag:116
   */
  public boolean isEmpty() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect DataStructures
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DataStructures.jrag:120
   */
  public boolean contains(Object o) {
    ASTNode$State state = state();
    try {  return this == o;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect Modifiers
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:220
   */
  public boolean isSynthetic() {
    ASTNode$State state = state();
    try {  return getModifiers().isSynthetic();  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect PrettyPrint
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/PrettyPrint.jadd:821
   */
  public String dumpString() {
    ASTNode$State state = state();
    try {  return getClass().getName() + " [" + getID() + "]";  }
    finally {
    }
  }
  /**
   * @apilevel internal
   */
  protected boolean type_computed = false;
  /**
   * @apilevel internal
   */
  protected TypeDecl type_value;
  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:253
   */
  public TypeDecl type() {
    if(type_computed) {
      return type_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    type_value = type_compute();
    if (isFinal && num == state().boundariesCrossed) {
      type_computed = true;
    } else {
    }

    return type_value;
  }
  /**
   * @apilevel internal
   */
  private TypeDecl type_compute() {  return getTypeAccess().type();  }
  /**
   * @attribute syn
   * @aspect Variables
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/VariableDeclaration.jrag:47
   */
  public boolean isParameter() {
    ASTNode$State state = state();
    try {  return true;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect Variables
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/VariableDeclaration.jrag:50
   */
  public boolean isClassVariable() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect Variables
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/VariableDeclaration.jrag:51
   */
  public boolean isInstanceVariable() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect Variables
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/VariableDeclaration.jrag:55
   */
  public boolean isLocalVariable() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect Variables
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/VariableDeclaration.jrag:73
   */
  public boolean isFinal() {
    ASTNode$State state = state();
    try {  return getModifiers().isFinal();  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect Variables
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/VariableDeclaration.jrag:74
   */
  public boolean isVolatile() {
    ASTNode$State state = state();
    try {  return getModifiers().isVolatile();  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect Variables
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/VariableDeclaration.jrag:75
   */
  public boolean isBlank() {
    ASTNode$State state = state();
    try {  return true;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect Variables
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/VariableDeclaration.jrag:76
   */
  public boolean isStatic() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect Variables
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/VariableDeclaration.jrag:78
   */
  public String name() {
    ASTNode$State state = state();
    try {  return getID();  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect Variables
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/VariableDeclaration.jrag:80
   */
  public boolean hasInit() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect Variables
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/VariableDeclaration.jrag:81
   */
  public Expr getInit() {
    ASTNode$State state = state();
    try { throw new UnsupportedOperationException(); }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect Variables
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/VariableDeclaration.jrag:82
   */
  public Constant constant() {
    ASTNode$State state = state();
    try { throw new UnsupportedOperationException(); }
    finally {
    }
  }
  /**
   * @apilevel internal
   */
  protected boolean sourceVariableDecl_computed = false;
  /**
   * @apilevel internal
   */
  protected Variable sourceVariableDecl_value;
  /**
   * @attribute syn
   * @aspect SourceDeclarations
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Generics.jrag:1318
   */
  public Variable sourceVariableDecl() {
    if(sourceVariableDecl_computed) {
      return sourceVariableDecl_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    sourceVariableDecl_value = sourceVariableDecl_compute();
    if (isFinal && num == state().boundariesCrossed) {
      sourceVariableDecl_computed = true;
    } else {
    }

    return sourceVariableDecl_value;
  }
  /**
   * @apilevel internal
   */
  private Variable sourceVariableDecl_compute() {  return this;  }
  /**
   * @attribute syn
   * @aspect VariableArityParameters
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/VariableArityParameters.jrag:35
   */
  public boolean isVariableArity() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect DotGraphSpec
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/DotGraphSpec.jrag:40
   */
  public int getDotId() {
    ASTNode$State state = state();
    try {  return dotId;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect DotGraphSpec
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/DotGraphSpec.jrag:57
   */
  public String dotAttributes() {
    ASTNode$State state = state();
    try {  return "shape=record, label=\"<name> " + dumpString() + " | {<pred> pred | <succ> succ}\"";  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect JavaLiveness14
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaLiveness1.4.jrag:29
   */
  public BitSet liveness_def() {
    ASTNode$State state = state();
    try {  return emptyBitSet().mutable().union(this);  }
    finally {
    }
  }
  /**
   * @apilevel internal
   */
  protected boolean exceptionalSucc_computed = false;
  /**
   * @apilevel internal
   */
  protected SmallSet<CFGNode> exceptionalSucc_value;
  /**
   * @attribute syn
   * @aspect Java_CFG_1_4
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:110
   */
  public SmallSet<CFGNode> exceptionalSucc() {
    if(exceptionalSucc_computed) {
      return exceptionalSucc_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    exceptionalSucc_value = exceptionalSucc_compute();
    if (isFinal && num == state().boundariesCrossed) {
      exceptionalSucc_computed = true;
    } else {
    }

    return exceptionalSucc_value;
  }
  /**
   * @apilevel internal
   */
  private SmallSet<CFGNode> exceptionalSucc_compute() {  return SmallSet.<CFGNode>empty();  }
  /**
   * @apilevel internal
   */
  protected boolean succ_computed = false;
  /**
   * @apilevel internal
   */
  protected SmallSet<CFGNode> succ_value;
  /**
   * @attribute syn
   * @aspect Java_CFG_1_4
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:113
   */
  public SmallSet<CFGNode> succ() {
    if(succ_computed) {
      return succ_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    succ_value = succ_compute();
    if (isFinal && num == state().boundariesCrossed) {
      succ_computed = true;
    } else {
    }

    return succ_value;
  }
  /**
   * @apilevel internal
   */
  private SmallSet<CFGNode> succ_compute() {  return following().union(exceptionalSucc());  }
  /**
   * @apilevel internal
   */
  protected boolean includeInDeadAssignAnalysis_computed = false;
  /**
   * @apilevel internal
   */
  protected boolean includeInDeadAssignAnalysis_value;
  /**
   * @attribute syn
   * @aspect JavaDeadAssigns
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaDeadAssigns.jrag:24
   */
  public boolean includeInDeadAssignAnalysis() {
    if(includeInDeadAssignAnalysis_computed) {
      return includeInDeadAssignAnalysis_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    includeInDeadAssignAnalysis_value = includeInDeadAssignAnalysis_compute();
    if (isFinal && num == state().boundariesCrossed) {
      includeInDeadAssignAnalysis_computed = true;
    } else {
    }

    return includeInDeadAssignAnalysis_value;
  }
  /**
   * @apilevel internal
   */
  private boolean includeInDeadAssignAnalysis_compute() {  return false;  }
  /**
   * @apilevel internal
   */
  protected boolean isDeadAssign_computed = false;
  /**
   * @apilevel internal
   */
  protected boolean isDeadAssign_value;
  /**
   * @attribute syn
   * @aspect JavaDeadAssigns
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaDeadAssigns.jrag:38
   */
  public boolean isDeadAssign() {
    if(isDeadAssign_computed) {
      return isDeadAssign_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    isDeadAssign_value = isDeadAssign_compute();
    if (isFinal && num == state().boundariesCrossed) {
      isDeadAssign_computed = true;
    } else {
    }

    return isDeadAssign_value;
  }
  /**
   * @apilevel internal
   */
  private boolean isDeadAssign_compute() {  return false;  }
  /**
   * @apilevel internal
   */
  protected boolean isDead_computed = false;
  /**
   * @apilevel internal
   */
  protected boolean isDead_value;
  /**
   * @attribute syn
   * @aspect JavaLiveness14
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaLiveness1.4.jrag:9
   */
  public boolean isDead() {
    if(isDead_computed) {
      return isDead_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    isDead_value = isDead_compute();
    if (isFinal && num == state().boundariesCrossed) {
      isDead_computed = true;
    } else {
    }

    return isDead_value;
  }
  /**
   * @apilevel internal
   */
  private boolean isDead_compute() {  return !liveness_def().compl(liveness_out()).isEmpty();  }
  /**
   * @apilevel internal
   */
  protected int liveness_in_visited = -1;
  /**
   * @apilevel internal
   */
  protected boolean liveness_in_computed = false;
  /**
   * @apilevel internal
   */
  protected boolean liveness_in_initialized = false;
  /**
   * @apilevel internal
   */
  protected BitSet liveness_in_value;
  /**
   * @attribute syn
   * @aspect JavaLiveness14
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaLiveness1.4.jrag:13
   */
  public BitSet liveness_in() {
    if(liveness_in_computed) {
      return liveness_in_value;
    }
    ASTNode$State state = state();
    if (!liveness_in_initialized) {
      liveness_in_initialized = true;
      liveness_in_value = emptyBitSet();
    }
    if (!state.IN_CIRCLE) {
      state.IN_CIRCLE = true;
      int num = state.boundariesCrossed;
      boolean isFinal = this.is$Final();
      // TODO: fixme
      // state().CIRCLE_INDEX = 1;
      do {
        liveness_in_visited = state.CIRCLE_INDEX;
        state.CHANGE = false;
        BitSet new_liveness_in_value = liveness_in_compute();
        if ((new_liveness_in_value==null && liveness_in_value!=null) || (new_liveness_in_value!=null && !new_liveness_in_value.equals(liveness_in_value))) {
          state.CHANGE = true;
        }
        liveness_in_value = new_liveness_in_value;
        state.CIRCLE_INDEX++;
      } while (state.CHANGE);
      if (isFinal && num == state().boundariesCrossed) {
        liveness_in_computed = true;
      } else {
        state.RESET_CYCLE = true;
        liveness_in_compute();
        state.RESET_CYCLE = false;
        liveness_in_computed = false;
        liveness_in_initialized = false;
      }
      state.IN_CIRCLE = false;
      return liveness_in_value;
    }
    if(liveness_in_visited != state.CIRCLE_INDEX) {
      liveness_in_visited = state.CIRCLE_INDEX;
      if (state.RESET_CYCLE) {
        liveness_in_computed = false;
        liveness_in_initialized = false;
        liveness_in_visited = -1;
        return liveness_in_value;
      }
      BitSet new_liveness_in_value = liveness_in_compute();
      if ((new_liveness_in_value==null && liveness_in_value!=null) || (new_liveness_in_value!=null && !new_liveness_in_value.equals(liveness_in_value))) {
        state.CHANGE = true;
      }
      liveness_in_value = new_liveness_in_value;
      return liveness_in_value;
    }
    return liveness_in_value;
  }
  /**
   * @apilevel internal
   */
  private BitSet liveness_in_compute() {  return liveness_use().union(liveness_out().compl(liveness_def()));  }
  /**
   * @attribute syn
   * @aspect JavaLiveness14
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaLiveness1.4.jrag:39
   */
  public BitSet liveness_use() {
    ASTNode$State state = state();
    try {  return emptyBitSet().mutable();  }
    finally {
    }
  }
  /**
   * @attribute inh
   * @aspect VariableScope
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupVariable.jrag:22
   */
  public SimpleSet lookupVariable(String name) {
    ASTNode$State state = state();
    SimpleSet lookupVariable_String_value = getParent().Define_SimpleSet_lookupVariable(this, null, name);

    return lookupVariable_String_value;
  }
  /**
   * @attribute inh
   * @aspect NameCheck
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/NameCheck.jrag:319
   */
  public VariableScope outerScope() {
    ASTNode$State state = state();
    VariableScope outerScope_value = getParent().Define_VariableScope_outerScope(this, null);

    return outerScope_value;
  }
  /**
   * @attribute inh
   * @aspect NameCheck
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/NameCheck.jrag:381
   */
  public BodyDecl enclosingBodyDecl() {
    ASTNode$State state = state();
    BodyDecl enclosingBodyDecl_value = getParent().Define_BodyDecl_enclosingBodyDecl(this, null);

    return enclosingBodyDecl_value;
  }
  /**
   * @attribute inh
   * @aspect NestedTypes
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:594
   */
  public TypeDecl hostType() {
    ASTNode$State state = state();
    TypeDecl hostType_value = getParent().Define_TypeDecl_hostType(this, null);

    return hostType_value;
  }
  /**
   * @attribute inh
   * @aspect Variables
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/VariableDeclaration.jrag:52
   */
  public boolean isMethodParameter() {
    ASTNode$State state = state();
    boolean isMethodParameter_value = getParent().Define_boolean_isMethodParameter(this, null);

    return isMethodParameter_value;
  }
  /**
   * @attribute inh
   * @aspect Variables
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/VariableDeclaration.jrag:53
   */
  public boolean isConstructorParameter() {
    ASTNode$State state = state();
    boolean isConstructorParameter_value = getParent().Define_boolean_isConstructorParameter(this, null);

    return isConstructorParameter_value;
  }
  /**
   * @attribute inh
   * @aspect Variables
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/VariableDeclaration.jrag:54
   */
  public boolean isExceptionHandlerParameter() {
    ASTNode$State state = state();
    boolean isExceptionHandlerParameter_value = getParent().Define_boolean_isExceptionHandlerParameter(this, null);

    return isExceptionHandlerParameter_value;
  }
  /**
   * @attribute inh
   * @aspect Java_CFG_1_4
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:13
   */
  public SmallSet emptySmallSet() {
    if(emptySmallSet_computed) {
      return emptySmallSet_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    emptySmallSet_value = getParent().Define_SmallSet_emptySmallSet(this, null);
    if (isFinal && num == state().boundariesCrossed) {
      emptySmallSet_computed = true;
    } else {
    }

    return emptySmallSet_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean emptySmallSet_computed = false;
  /**
   * @apilevel internal
   */
  protected SmallSet emptySmallSet_value;
  /**
   * @attribute inh
   * @aspect Java_CFG_1_4
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:35
   */
  public SmallSet<CFGNode> following() {
    if(following_computed) {
      return following_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    following_value = getParent().Define_SmallSet_CFGNode__following(this, null);
    if (isFinal && num == state().boundariesCrossed) {
      following_computed = true;
    } else {
    }

    return following_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean following_computed = false;
  /**
   * @apilevel internal
   */
  protected SmallSet<CFGNode> following_value;
  /**
   * @attribute inh
   * @aspect JavaDeadAssigns
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaDeadAssigns.jrag:5
   */
  public CompilationUnit enclosingCompilationUnit() {
    if(enclosingCompilationUnit_computed) {
      return enclosingCompilationUnit_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    enclosingCompilationUnit_value = getParent().Define_CompilationUnit_enclosingCompilationUnit(this, null);
    if (isFinal && num == state().boundariesCrossed) {
      enclosingCompilationUnit_computed = true;
    } else {
    }

    return enclosingCompilationUnit_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean enclosingCompilationUnit_computed = false;
  /**
   * @apilevel internal
   */
  protected CompilationUnit enclosingCompilationUnit_value;
  /**
   * @attribute inh
   * @aspect JavaLiveness14
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaLiveness1.4.jrag:5
   */
  public BitSet emptyBitSet() {
    if(emptyBitSet_computed) {
      return emptyBitSet_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    emptyBitSet_value = getParent().Define_BitSet_emptyBitSet(this, null);
    if (isFinal && num == state().boundariesCrossed) {
      emptyBitSet_computed = true;
    } else {
    }

    return emptyBitSet_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean emptyBitSet_computed = false;
  /**
   * @apilevel internal
   */
  protected BitSet emptyBitSet_value;
  /**
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:288
   * @apilevel internal
   */
  public boolean Define_boolean_mayBeFinal(ASTNode caller, ASTNode child) {
    if (caller == getModifiersNoTransform()) {
      return true;
    }
    else {
      return getParent().Define_boolean_mayBeFinal(this, caller);
    }
  }
  /**
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Annotations.jrag:83
   * @apilevel internal
   */
  public boolean Define_boolean_mayUseAnnotationTarget(ASTNode caller, ASTNode child, String name) {
    if (caller == getModifiersNoTransform()) {
      return name.equals("PARAMETER");
    }
    else {
      return getParent().Define_boolean_mayUseAnnotationTarget(this, caller, name);
    }
  }
  /**
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Enums.jrag:79
   * @apilevel internal
   */
  public NameType Define_NameType_nameType(ASTNode caller, ASTNode child) {
    if (caller == getTypeAccessNoTransform()) {
      return NameType.TYPE_NAME;
    }
    else {
      return getParent().Define_NameType_nameType(this, caller);
    }
  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {    return super.rewriteTo();
  }  /**
   * @attribute coll
   * @aspect Java_CFG_1_4
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:19
   */
  public SmallSet<CFGNode> collPred() {
    if(CFGNode_collPred_computed) {
      return CFGNode_collPred_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    CFGNode_collPred_value = collPred_compute();
    if (isFinal && num == state().boundariesCrossed) {
      CFGNode_collPred_computed = true;
    } else {
    }

    return CFGNode_collPred_value;
  }
  java.util.Set CFGNode_collPred_contributors;

  /**
   * @apilevel internal
   * @return the contributor set for collPred
   */
  public java.util.Set CFGNode_collPred_contributors() {
    if(CFGNode_collPred_contributors == null)
      CFGNode_collPred_contributors  = new ASTNode$State.IdentityHashSet(4);
    return CFGNode_collPred_contributors;
  }

  /**
   * @apilevel internal
   */
  private SmallSet<CFGNode> collPred_compute() {
    ASTNode node = this;
    while(node.getParent() != null && !(node instanceof TypeDecl)) {
      node = node.getParent();
    }
    TypeDecl root = (TypeDecl) node;
    root.collect_contributors_CFGNode_collPred();
    CFGNode_collPred_value = SmallSet.mutable();
    if(CFGNode_collPred_contributors != null)
    for (java.util.Iterator iter = CFGNode_collPred_contributors.iterator(); iter.hasNext(); ) {
      ASTNode contributor = (ASTNode) iter.next();
      contributor.contributeTo_CFGNode_CFGNode_collPred(CFGNode_collPred_value);
    }
    // TODO: disabled temporarily since collections may not be cached
    //CFGNode_collPred_contributors = null;
    return CFGNode_collPred_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean CFGNode_collPred_computed = false;
  /**
   * @apilevel internal
   */
  protected SmallSet<CFGNode> CFGNode_collPred_value;
  /**
   * @attribute coll
   * @aspect JavaDeadAssigns
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaDeadAssigns.jrag:9
   */
  public BitSet def() {
    if(CFGNode_def_computed) {
      return CFGNode_def_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    CFGNode_def_value = def_compute();
    if (isFinal && num == state().boundariesCrossed) {
      CFGNode_def_computed = true;
    } else {
    }

    return CFGNode_def_value;
  }
  java.util.Set CFGNode_def_contributors;

  /**
   * @apilevel internal
   * @return the contributor set for def
   */
  public java.util.Set CFGNode_def_contributors() {
    if(CFGNode_def_contributors == null)
      CFGNode_def_contributors  = new ASTNode$State.IdentityHashSet(4);
    return CFGNode_def_contributors;
  }

  /**
   * @apilevel internal
   */
  private BitSet def_compute() {
    ASTNode node = this;
    while(node.getParent() != null && !(node instanceof BodyDecl)) {
      node = node.getParent();
    }
    BodyDecl root = (BodyDecl) node;
    root.collect_contributors_CFGNode_def();
    CFGNode_def_value = emptyBitSet().mutable();
    if(CFGNode_def_contributors != null)
    for (java.util.Iterator iter = CFGNode_def_contributors.iterator(); iter.hasNext(); ) {
      ASTNode contributor = (ASTNode) iter.next();
      contributor.contributeTo_CFGNode_CFGNode_def(CFGNode_def_value);
    }
    // TODO: disabled temporarily since collections may not be cached
    //CFGNode_def_contributors = null;
    return CFGNode_def_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean CFGNode_def_computed = false;
  /**
   * @apilevel internal
   */
  protected BitSet CFGNode_def_value;
  /**
   * @apilevel internal
   */
  protected int CFGNode_coll_liveness_out_visited = -1;
  /**
   * @apilevel internal
   */
  protected boolean CFGNode_coll_liveness_out_computed = false;

  /**
   * @apilevel internal
   */
  protected boolean CFGNode_coll_liveness_out_initialized = false;

  /**
   * @apilevel internal
   */
  protected BitSet CFGNode_coll_liveness_out_value;


  /**
   * @attribute coll
   * @aspect JavaLiveness14
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaLiveness1.4.jrag:17
   */
  public BitSet coll_liveness_out() {
    if(CFGNode_coll_liveness_out_computed) {
      return CFGNode_coll_liveness_out_value;
    }
    ASTNode node = this;
    while(node.getParent() != null && !(node instanceof TypeDecl))
      node = node.getParent();
    TypeDecl root = (TypeDecl) node;

    if(root.collecting_contributors_CFGNode_coll_liveness_out)
      throw new RuntimeException("Circularity during phase 1");
    root.collect_contributors_CFGNode_coll_liveness_out();

    if (!CFGNode_coll_liveness_out_initialized) {
      CFGNode_coll_liveness_out_initialized = true;
      CFGNode_coll_liveness_out_value = emptyBitSet().mutable();
    }

    if (!state().IN_CIRCLE) {
      state().IN_CIRCLE = true;
      int num = state.boundariesCrossed;
      boolean isFinal = this.is$Final();
      state().CIRCLE_INDEX = 1;
      do {
        CFGNode_coll_liveness_out_visited = state().CIRCLE_INDEX;
        state().CHANGE = false;

        BitSet new_CFGNode_coll_liveness_out_value = emptyBitSet().mutable();
        combine_CFGNode_coll_liveness_out_contributions(new_CFGNode_coll_liveness_out_value);
        if ((new_CFGNode_coll_liveness_out_value==null && CFGNode_coll_liveness_out_value!=null) || (new_CFGNode_coll_liveness_out_value!=null && !new_CFGNode_coll_liveness_out_value.equals(CFGNode_coll_liveness_out_value))) {
          state().CHANGE = true;
        }
        CFGNode_coll_liveness_out_value = new_CFGNode_coll_liveness_out_value;
        state().CIRCLE_INDEX++;
      } while (state().CHANGE);

      if (isFinal && num == state().boundariesCrossed) {
        CFGNode_coll_liveness_out_computed = true;
      } else {
        state.RESET_CYCLE = true;
        CFGNode_coll_liveness_out_value = combine_CFGNode_coll_liveness_out_contributions(emptyBitSet().mutable());
        state.RESET_CYCLE = false;
        CFGNode_coll_liveness_out_computed = false;
        CFGNode_coll_liveness_out_initialized = false;
      }
      state().IN_CIRCLE = false;
      return CFGNode_coll_liveness_out_value;
    }
    if(CFGNode_coll_liveness_out_visited != state().CIRCLE_INDEX) {
      CFGNode_coll_liveness_out_visited = state().CIRCLE_INDEX;
      if (state.RESET_CYCLE) {
        CFGNode_coll_liveness_out_computed = false;
        CFGNode_coll_liveness_out_initialized = false;
        CFGNode_coll_liveness_out_visited = -1;
        return CFGNode_coll_liveness_out_value;
      }
      BitSet new_CFGNode_coll_liveness_out_value = emptyBitSet().mutable();
      combine_CFGNode_coll_liveness_out_contributions(new_CFGNode_coll_liveness_out_value);
      if ((new_CFGNode_coll_liveness_out_value==null && CFGNode_coll_liveness_out_value!=null) || (new_CFGNode_coll_liveness_out_value!=null && !new_CFGNode_coll_liveness_out_value.equals(CFGNode_coll_liveness_out_value))) {
        state().CHANGE = true;
      }
      CFGNode_coll_liveness_out_value = new_CFGNode_coll_liveness_out_value;
      return CFGNode_coll_liveness_out_value;
    }
    return CFGNode_coll_liveness_out_value;
  }
  java.util.Set CFGNode_coll_liveness_out_contributors;

  /**
   * @apilevel internal
   * @return the contributor set for coll_liveness_out
   */
  public java.util.Set CFGNode_coll_liveness_out_contributors() {
    if(CFGNode_coll_liveness_out_contributors == null)
      CFGNode_coll_liveness_out_contributors  = new ASTNode$State.IdentityHashSet(4);
    return CFGNode_coll_liveness_out_contributors;
  }

  private BitSet combine_CFGNode_coll_liveness_out_contributions(BitSet h) {
    if(CFGNode_coll_liveness_out_contributors != null)
    for(java.util.Iterator iter = CFGNode_coll_liveness_out_contributors.iterator(); iter.hasNext(); ) {
      ASTNode contributor = (ASTNode) iter.next();
      contributor.contributeTo_CFGNode_CFGNode_coll_liveness_out(h);
    }
    // TODO: disabled temporarily since collections may not be cached
    //CFGNode_coll_liveness_out_contributors = null;
    return h;
  }
  protected void collect_contributors_CFGNode_collPred() {
  /**
   * @attribute coll
   * @aspect Java_CFG_1_4
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:22
   */
      for(java.util.Iterator iter = (succ()).iterator(); iter.hasNext(); ) {
        CFGNode ref = (CFGNode) iter.next();
        if (ref != null) {
          ref.CFGNode_collPred_contributors().add(this);
        }
      }
    super.collect_contributors_CFGNode_collPred();
  }
  protected void collect_contributors_CFGNode_def() {
  /**
   * @attribute coll
   * @aspect JavaDeadAssigns
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaDeadAssigns.jrag:12
   */
      {
        CFGNode ref = (CFGNode) (this);
        if (ref != null) {
          ref.CFGNode_def_contributors().add(this);
        }
      }
    super.collect_contributors_CFGNode_def();
  }
  protected void collect_contributors_CFGNode_coll_liveness_out() {
  /**
   * @attribute coll
   * @aspect JavaLiveness14
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaLiveness1.4.jrag:20
   */
      for(java.util.Iterator iter = (pred()).iterator(); iter.hasNext(); ) {
        CFGNode ref = (CFGNode) iter.next();
        if (ref != null) {
          ref.CFGNode_coll_liveness_out_contributors().add(this);
        }
      }
    super.collect_contributors_CFGNode_coll_liveness_out();
  }
  protected void contributeTo_CFGNode_CFGNode_collPred(SmallSet<CFGNode> collection) {
    super.contributeTo_CFGNode_CFGNode_collPred(collection);
    collection.add(this);
  }

  protected void contributeTo_CFGNode_CFGNode_def(BitSet collection) {
    super.contributeTo_CFGNode_CFGNode_def(collection);
    collection.add(this);
  }

  protected void contributeTo_CFGNode_CFGNode_coll_liveness_out(BitSet collection) {
    super.contributeTo_CFGNode_CFGNode_coll_liveness_out(collection);
    collection.add(liveness_in());
  }

}
