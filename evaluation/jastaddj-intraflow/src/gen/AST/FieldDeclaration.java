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
 * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/grammar/Java.ast:79
 * @production FieldDeclaration : {@link MemberDecl} ::= <span class="component">{@link Modifiers}</span> <span class="component">TypeAccess:{@link Access}</span> <span class="component">&lt;ID:String&gt;</span> <span class="component">[Init:{@link Expr}]</span>;

 */
public class FieldDeclaration extends MemberDecl implements Cloneable, SimpleSet, Iterator, Variable, CFGNode {
  /**
   * @aspect BoundNames
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/BoundNames.jrag:11
   */
  public Access createQualifiedBoundAccess() {
    if(isStatic())
      return hostType().createQualifiedAccess().qualifiesAccess(new BoundFieldAccess(this));
    else
      return new ThisAccess("this").qualifiesAccess(
        new BoundFieldAccess(this));
  }
  /**
   * @aspect BoundNames
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/BoundNames.jrag:86
   */
  public Access createBoundFieldAccess() {
    return createQualifiedBoundAccess();
  }
  /**
   * @aspect DataStructures
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DataStructures.jrag:81
   */
  public SimpleSet add(Object o) {
    return new SimpleSetImpl().add(this).add(o);
  }
  /**
   * @aspect DataStructures
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DataStructures.jrag:85
   */
  public boolean isSingleton() { return true; }
  /**
   * @aspect DataStructures
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DataStructures.jrag:86
   */
  public boolean isSingleton(Object o) { return contains(o); }
  /**
   * @aspect DataStructures
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DataStructures.jrag:89
   */
  private FieldDeclaration iterElem;
  /**
   * @aspect DataStructures
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DataStructures.jrag:90
   */
  public Iterator iterator() { iterElem = this; return this; }
  /**
   * @aspect DataStructures
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DataStructures.jrag:91
   */
  public boolean hasNext() { return iterElem != null; }
  /**
   * @aspect DataStructures
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DataStructures.jrag:92
   */
  public Object next() { Object o = iterElem; iterElem = null; return o; }
  /**
   * @aspect DataStructures
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DataStructures.jrag:93
   */
  public void remove() { throw new UnsupportedOperationException(); }
  /**
   * @aspect DefiniteAssignment
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DefiniteAssignment.jrag:177
   */
  public void definiteAssignment() {
    super.definiteAssignment();
    if(isBlank() && isFinal() && isClassVariable()) {
      boolean found = false;
      TypeDecl typeDecl = hostType();
      for(int i = 0; i < typeDecl.getNumBodyDecl(); i++) {
        if(typeDecl.getBodyDecl(i) instanceof StaticInitializer) {
          StaticInitializer s = (StaticInitializer)typeDecl.getBodyDecl(i);
          if(s.isDAafter(this))
            found = true;
        }

        else if(typeDecl.getBodyDecl(i) instanceof FieldDeclaration) {
          FieldDeclaration f = (FieldDeclaration)typeDecl.getBodyDecl(i);
          if(f.isStatic() && f.isDAafter(this))
            found = true;
        }

      }
      if(!found)
        error("blank final class variable " + name() + " in " + hostType().typeName() + " is not definitely assigned in static initializer");

    }
    if(isBlank() && isFinal() && isInstanceVariable()) {
      TypeDecl typeDecl = hostType();
      boolean found = false;
      for(int i = 0; !found && i < typeDecl.getNumBodyDecl(); i++) {
        if(typeDecl.getBodyDecl(i) instanceof FieldDeclaration) {
          FieldDeclaration f = (FieldDeclaration)typeDecl.getBodyDecl(i);
          if(!f.isStatic() && f.isDAafter(this))
            found = true;
        }
        else if(typeDecl.getBodyDecl(i) instanceof InstanceInitializer) {
          InstanceInitializer ii = (InstanceInitializer)typeDecl.getBodyDecl(i);
          if(ii.getBlock().isDAafter(this))
            found = true;
        }
      }
      for(Iterator iter = typeDecl.constructors().iterator(); !found && iter.hasNext(); ) {
        ConstructorDecl c = (ConstructorDecl)iter.next();
        if(!c.isDAafter(this)) {
          error("blank final instance variable " + name() + " in " + hostType().typeName() + " is not definitely assigned after " + c.signature());
          }
      }
    }
    if(isBlank() && hostType().isInterfaceDecl()) {
            error("variable  " + name() + " in " + hostType().typeName() + " which is an interface must have an initializer");
    }

  }
  /**
   * @aspect Modifiers
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:114
   */
  public void checkModifiers() {
    super.checkModifiers();
    if(hostType().isInterfaceDecl()) {
      if(isProtected())
        error("an interface field may not be protected");
      if(isPrivate())
        error("an interface field may not be private");
      if(isTransient())
        error("an interface field may not be transient");
      if(isVolatile())
        error("an interface field may not be volatile");
    }
  }
  /**
   * @aspect NameCheck
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/NameCheck.jrag:308
   */
  public void nameCheck() {
    super.nameCheck();
    // 8.3
    for(Iterator iter = hostType().memberFields(name()).iterator(); iter.hasNext(); ) {
      Variable v = (Variable)iter.next();
      if(v != this && v.hostType() == hostType())
        error("field named " + name() + " is multiply declared in type " + hostType().typeName());
    }

  }
  /**
   * @aspect NodeConstructors
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/NodeConstructors.jrag:86
   */
  public FieldDeclaration(Modifiers m, Access type, String name) {
    this(m, type, name, new Opt());
  }
  /**
   * @aspect NodeConstructors
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/NodeConstructors.jrag:90
   */
  public FieldDeclaration(Modifiers m, Access type, String name, Expr init) {
    this(m, type, name, new Opt(init));
  }
  /**
   * @aspect PrettyPrint
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/PrettyPrint.jadd:168
   */
  public void prettyPrint(StringBuffer sb) {
    sb.append(indent());
    getModifiers().prettyPrint(sb);
    getTypeAccess().prettyPrint(sb);
    sb.append(" " + name());
    if(hasInit()) {
      sb.append(" = ");
      getInit().prettyPrint(sb);
    }
    sb.append(";");
  }
  /**
   * @aspect TypeCheck
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeCheck.jrag:34
   */
  public void typeCheck() {
    if(hasInit()) {
      TypeDecl source = getInit().type();
      TypeDecl dest = type();
      if(!source.assignConversionTo(dest, getInit()))
        error("can not assign field " + name() + " of type " + dest.typeName() +
              " a value of type " + source.typeName());
    }
  }
  /**
   * @aspect VariableDeclarationTransformation
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/VariableDeclaration.jrag:91
   */
  private FieldDecl fieldDecl = null;
  /**
   * @aspect VariableDeclarationTransformation
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/VariableDeclaration.jrag:92
   */
  public FieldDecl getFieldDecl() {
    return fieldDecl;
  }
  /**
   * @aspect VariableDeclarationTransformation
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/VariableDeclaration.jrag:95
   */
  public void setFieldDecl(FieldDecl fieldDecl) {
    this.fieldDecl = fieldDecl;
  }
  /**
   * @aspect LookupParTypeDecl
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Generics.jrag:1091
   */
  public BodyDecl substitutedBodyDecl(Parameterization parTypeDecl) {
    FieldDeclaration f = new FieldDeclarationSubstituted(
      (Modifiers)getModifiers().fullCopy(),
      getTypeAccess().type().substituteReturnType(parTypeDecl),
      getID(),
      new Opt(),
      this
    );
    return f;
  }
  /**
   * @aspect Java_CFG_1_4
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:30
   */
  public SmallSet<CFGNode> pred() { return collPred(); }
  /**
   * @aspect JavaLiveness14
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/JavaLiveness1.4.jrag:16
   */
  public BitSet liveness_out() { return coll_liveness_out(); }
  /**
   * @declaredat ASTNode:1
   */
  public FieldDeclaration() {
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
    children = new ASTNode[3];
    setChild(new Opt(), 2);
  }
  /**
   * @declaredat ASTNode:14
   */
  public FieldDeclaration(Modifiers p0, Access p1, String p2, Opt<Expr> p3) {
    setChild(p0, 0);
    setChild(p1, 1);
    setID(p2);
    setChild(p3, 2);
  }
  /**
   * @declaredat ASTNode:20
   */
  public FieldDeclaration(Modifiers p0, Access p1, beaver.Symbol p2, Opt<Expr> p3) {
    setChild(p0, 0);
    setChild(p1, 1);
    setID(p2);
    setChild(p3, 2);
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:29
   */
  protected int numChildren() {
    return 3;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:35
   */
  public boolean mayHaveRewrite() {
    return false;
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:41
   */
  public void flushCache() {
    super.flushCache();
    accessibleFrom_TypeDecl_values = null;
    exceptions_computed = false;
    exceptions_value = null;
    isDAafter_Variable_values = null;
    isDUafter_Variable_values = null;
    constant_computed = false;
    constant_value = null;
    usesTypeVariable_computed = false;
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
   * @declaredat ASTNode:87
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
   * @declaredat ASTNode:104
   */
  public FieldDeclaration clone() throws CloneNotSupportedException {
    FieldDeclaration node = (FieldDeclaration) super.clone();
    node.accessibleFrom_TypeDecl_values = null;
    node.exceptions_computed = false;
    node.exceptions_value = null;
    node.isDAafter_Variable_values = null;
    node.isDUafter_Variable_values = null;
    node.constant_computed = false;
    node.constant_value = null;
    node.usesTypeVariable_computed = false;
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
   * @declaredat ASTNode:142
   */
  public FieldDeclaration copy() {
    try {
      FieldDeclaration node = (FieldDeclaration) clone();
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
   * @declaredat ASTNode:160
   */
  public FieldDeclaration fullCopy() {
    FieldDeclaration tree = (FieldDeclaration) copy();
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
   * Replaces the optional node for the Init child. This is the <code>Opt</code>
   * node containing the child Init, not the actual child!
   * @param opt The new node to be used as the optional node for the Init child.
   * @apilevel low-level
   */
  public void setInitOpt(Opt<Expr> opt) {
    setChild(opt, 2);
  }
  /**
   * Replaces the (optional) Init child.
   * @param node The new node to be used as the Init child.
   * @apilevel high-level
   */
  public void setInit(Expr node) {
    getInitOpt().setChild(node, 0);
  }
  /**
   * Check whether the optional Init child exists.
   * @return {@code true} if the optional Init child exists, {@code false} if it does not.
   * @apilevel high-level
   */
  public boolean hasInit() {
    return getInitOpt().getNumChild() != 0;
  }
  /**
   * Retrieves the (optional) Init child.
   * @return The Init child, if it exists. Returns {@code null} otherwise.
   * @apilevel low-level
   */
  public Expr getInit() {
    return (Expr) getInitOpt().getChild(0);
  }
  /**
   * Retrieves the optional node for the Init child. This is the <code>Opt</code> node containing the child Init, not the actual child!
   * @return The optional node for child the Init child.
   * @apilevel low-level
   */
  public Opt<Expr> getInitOpt() {
    return (Opt<Expr>) getChild(2);
  }
  /**
   * Retrieves the optional node for child Init. This is the <code>Opt</code> node containing the child Init, not the actual child!
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The optional node for child Init.
   * @apilevel low-level
   */
  public Opt<Expr> getInitOptNoTransform() {
    return (Opt<Expr>) getChildNoTransform(2);
  }
  protected java.util.Map accessibleFrom_TypeDecl_values;
  /**
   * @attribute syn
   * @aspect AccessControl
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/AccessControl.jrag:109
   */
  public boolean accessibleFrom(TypeDecl type) {
    Object _parameters = type;
    if (accessibleFrom_TypeDecl_values == null) accessibleFrom_TypeDecl_values = new org.jastadd.util.RobustMap(new java.util.HashMap());
    if(accessibleFrom_TypeDecl_values.containsKey(_parameters)) {
      return ((Boolean)accessibleFrom_TypeDecl_values.get(_parameters)).booleanValue();
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    boolean accessibleFrom_TypeDecl_value = accessibleFrom_compute(type);
    if (isFinal && num == state().boundariesCrossed) {
      accessibleFrom_TypeDecl_values.put(_parameters, Boolean.valueOf(accessibleFrom_TypeDecl_value));
    } else {
    }

    return accessibleFrom_TypeDecl_value;
  }
  /**
   * @apilevel internal
   */
  private boolean accessibleFrom_compute(TypeDecl type) {
      if(isPublic())
        return true;
      else if(isProtected()) {
        if(hostPackage().equals(type.hostPackage()))
          return true;
        if(type.withinBodyThatSubclasses(hostType()) != null)
          return true;
        return false;
      }
      else if(isPrivate())
        return hostType().topLevelType() == type.topLevelType();
      else
        return hostPackage().equals(type.hostPackage());
    }
  /**
   * @apilevel internal
   */
  protected boolean exceptions_computed = false;
  /**
   * @apilevel internal
   */
  protected Collection exceptions_value;
  /**
   * @attribute syn
   * @aspect AnonymousClasses
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/AnonymousClasses.jrag:72
   */
  public Collection exceptions() {
    if(exceptions_computed) {
      return exceptions_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    exceptions_value = exceptions_compute();
    if (isFinal && num == state().boundariesCrossed) {
      exceptions_computed = true;
    } else {
    }

    return exceptions_value;
  }
  /**
   * @apilevel internal
   */
  private Collection exceptions_compute() {
      HashSet set = new HashSet();
      if(isInstanceVariable() && hasInit()) {
        collectExceptions(set, this);
        for(Iterator iter = set.iterator(); iter.hasNext(); ) {
          TypeDecl typeDecl = (TypeDecl)iter.next();
          if(!getInit().reachedException(typeDecl))
            iter.remove();
        }
      }
      return set;
    }
  /**
   * @attribute syn
   * @aspect ConstantExpression
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ConstantExpression.jrag:223
   */
  public boolean isConstant() {
    ASTNode$State state = state();
    try {  return isFinal() && hasInit() && getInit().isConstant() && (type() instanceof PrimitiveType || type().isString());  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect DataStructures
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DataStructures.jrag:79
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
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DataStructures.jrag:80
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
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DataStructures.jrag:84
   */
  public boolean contains(Object o) {
    ASTNode$State state = state();
    try {  return this == o;  }
    finally {
    }
  }
  protected java.util.Map isDAafter_Variable_values;
  /**
   * @attribute syn
   * @aspect DA
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DefiniteAssignment.jrag:327
   */
  public boolean isDAafter(Variable v) {
    Object _parameters = v;
    if (isDAafter_Variable_values == null) isDAafter_Variable_values = new org.jastadd.util.RobustMap(new java.util.HashMap());
    if(isDAafter_Variable_values.containsKey(_parameters)) {
      return ((Boolean)isDAafter_Variable_values.get(_parameters)).booleanValue();
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    boolean isDAafter_Variable_value = isDAafter_compute(v);
    if (isFinal && num == state().boundariesCrossed) {
      isDAafter_Variable_values.put(_parameters, Boolean.valueOf(isDAafter_Variable_value));
    } else {
    }

    return isDAafter_Variable_value;
  }
  /**
   * @apilevel internal
   */
  private boolean isDAafter_compute(Variable v) {
      if(v == this)
        return hasInit();
      return hasInit() ? getInit().isDAafter(v) : isDAbefore(v);
    }
  protected java.util.Map isDUafter_Variable_values;
  /**
   * @attribute syn
   * @aspect DU
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DefiniteAssignment.jrag:796
   */
  public boolean isDUafter(Variable v) {
    Object _parameters = v;
    if (isDUafter_Variable_values == null) isDUafter_Variable_values = new org.jastadd.util.RobustMap(new java.util.HashMap());
    if(isDUafter_Variable_values.containsKey(_parameters)) {
      return ((Boolean)isDUafter_Variable_values.get(_parameters)).booleanValue();
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    boolean isDUafter_Variable_value = isDUafter_compute(v);
    if (isFinal && num == state().boundariesCrossed) {
      isDUafter_Variable_values.put(_parameters, Boolean.valueOf(isDUafter_Variable_value));
    } else {
    }

    return isDUafter_Variable_value;
  }
  /**
   * @apilevel internal
   */
  private boolean isDUafter_compute(Variable v) {
      if(v == this)
        return !hasInit();
      return hasInit() ? getInit().isDUafter(v) : isDUbefore(v);
    }
  /**
   * @attribute syn
   * @aspect Modifiers
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:214
   */
  public boolean isSynthetic() {
    ASTNode$State state = state();
    try {  return getModifiers().isSynthetic();  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect Modifiers
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:239
   */
  public boolean isPublic() {
    ASTNode$State state = state();
    try {  return getModifiers().isPublic() || hostType().isInterfaceDecl();  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect Modifiers
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:240
   */
  public boolean isPrivate() {
    ASTNode$State state = state();
    try {  return getModifiers().isPrivate();  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect Modifiers
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:241
   */
  public boolean isProtected() {
    ASTNode$State state = state();
    try {  return getModifiers().isProtected();  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect Modifiers
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:242
   */
  public boolean isStatic() {
    ASTNode$State state = state();
    try {  return getModifiers().isStatic() || hostType().isInterfaceDecl();  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect Modifiers
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:244
   */
  public boolean isFinal() {
    ASTNode$State state = state();
    try {  return getModifiers().isFinal() || hostType().isInterfaceDecl();  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect Modifiers
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:245
   */
  public boolean isTransient() {
    ASTNode$State state = state();
    try {  return getModifiers().isTransient();  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect Modifiers
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:246
   */
  public boolean isVolatile() {
    ASTNode$State state = state();
    try {  return getModifiers().isVolatile();  }
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
    try {  return getClass().getName() + " [" + getID() + "]";  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:251
   */
  public TypeDecl type() {
    ASTNode$State state = state();
    try {  return getTypeAccess().type();  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:271
   */
  public boolean isVoid() {
    ASTNode$State state = state();
    try {  return type().isVoid();  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect Variables
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/VariableDeclaration.jrag:32
   */
  public boolean isParameter() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect Variables
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/VariableDeclaration.jrag:34
   */
  public boolean isClassVariable() {
    ASTNode$State state = state();
    try {  return isStatic() || hostType().isInterfaceDecl();  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect Variables
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/VariableDeclaration.jrag:35
   */
  public boolean isInstanceVariable() {
    ASTNode$State state = state();
    try {  return (hostType().isClassDecl() || hostType().isAnonymous() )&& !isStatic();  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect Variables
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/VariableDeclaration.jrag:36
   */
  public boolean isMethodParameter() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect Variables
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/VariableDeclaration.jrag:37
   */
  public boolean isConstructorParameter() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect Variables
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/VariableDeclaration.jrag:38
   */
  public boolean isExceptionHandlerParameter() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect Variables
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/VariableDeclaration.jrag:39
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
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/VariableDeclaration.jrag:41
   */
  public boolean isBlank() {
    ASTNode$State state = state();
    try {  return !hasInit();  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect Variables
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/VariableDeclaration.jrag:43
   */
  public String name() {
    ASTNode$State state = state();
    try {  return getID();  }
    finally {
    }
  }
  /**
   * @apilevel internal
   */
  protected boolean constant_computed = false;
  /**
   * @apilevel internal
   */
  protected Constant constant_value;
  /**
   * @attribute syn
   * @aspect Variables
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/VariableDeclaration.jrag:44
   */
  public Constant constant() {
    if(constant_computed) {
      return constant_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    constant_value = constant_compute();
    if (isFinal && num == state().boundariesCrossed) {
      constant_computed = true;
    } else {
    }

    return constant_value;
  }
  /**
   * @apilevel internal
   */
  private Constant constant_compute() {  return type().cast(getInit().constant());  }
  /**
   * @attribute syn
   * @aspect Annotations
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Annotations.jrag:292
   */
  public boolean hasAnnotationSuppressWarnings(String annot) {
    ASTNode$State state = state();
    try {  return getModifiers().hasAnnotationSuppressWarnings(annot);  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect Annotations
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Annotations.jrag:334
   */
  public boolean isDeprecated() {
    ASTNode$State state = state();
    try {  return getModifiers().hasDeprecatedAnnotation();  }
    finally {
    }
  }
  /**
   * @apilevel internal
   */
  protected boolean usesTypeVariable_computed = false;
  /**
   * @apilevel internal
   */
  protected boolean usesTypeVariable_value;
  /**
   * @attribute syn
   * @aspect LookupParTypeDecl
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Generics.jrag:932
   */
  public boolean usesTypeVariable() {
    if(usesTypeVariable_computed) {
      return usesTypeVariable_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    usesTypeVariable_value = usesTypeVariable_compute();
    if (isFinal && num == state().boundariesCrossed) {
      usesTypeVariable_computed = true;
    } else {
    }

    return usesTypeVariable_value;
  }
  /**
   * @apilevel internal
   */
  private boolean usesTypeVariable_compute() {  return getTypeAccess().usesTypeVariable();  }
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
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Generics.jrag:1316
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
   * @aspect GenericsParTypeDecl
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/GenericsParTypeDecl.jrag:65
   */
  public boolean visibleTypeParameters() {
    ASTNode$State state = state();
    try {  return !isStatic();  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect DotGraphSpec
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/DotGraphSpec.jrag:41
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
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/DotGraphSpec.jrag:58
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
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/JavaLiveness1.4.jrag:29
   */
  public BitSet liveness_def() {
    ASTNode$State state = state();
    try {  return emptyBitSet().mutable();  }
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
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:110
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
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:113
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
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/JavaDeadAssigns.jrag:24
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
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/JavaDeadAssigns.jrag:38
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
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/JavaLiveness1.4.jrag:9
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
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/JavaLiveness1.4.jrag:13
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
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/JavaLiveness1.4.jrag:39
   */
  public BitSet liveness_use() {
    ASTNode$State state = state();
    try {  return emptyBitSet().mutable();  }
    finally {
    }
  }
  /**
   * @attribute inh
   * @aspect ExceptionHandling
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ExceptionHandling.jrag:54
   */
  public boolean handlesException(TypeDecl exceptionType) {
    ASTNode$State state = state();
    boolean handlesException_TypeDecl_value = getParent().Define_boolean_handlesException(this, null, exceptionType);

    return handlesException_TypeDecl_value;
  }
  /**
   * @attribute inh
   * @aspect Java_CFG_1_4
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:13
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
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:35
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
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/JavaDeadAssigns.jrag:5
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
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/JavaLiveness1.4.jrag:5
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
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DefiniteAssignment.jrag:39
   * @apilevel internal
   */
  public boolean Define_boolean_isSource(ASTNode caller, ASTNode child) {
    if (caller == getInitOptNoTransform()) {
      return true;
    }
    else {
      return getParent().Define_boolean_isSource(this, caller);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DefiniteAssignment.jrag:333
   * @apilevel internal
   */
  public boolean Define_boolean_isDAbefore(ASTNode caller, ASTNode child, Variable v) {
    if (caller == getInitOptNoTransform()){
    return isDAbefore(v);
  }
    else {
      return super.Define_boolean_isDAbefore(caller, child, v);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ExceptionHandling.jrag:167
   * @apilevel internal
   */
  public boolean Define_boolean_handlesException(ASTNode caller, ASTNode child, TypeDecl exceptionType) {
    if (caller == getInitOptNoTransform()){
    if(hostType().isAnonymous())
      return true;
    if(!exceptionType.isUncheckedException())
      return true;
    for(Iterator iter = hostType().constructors().iterator(); iter.hasNext(); ) {
      ConstructorDecl decl = (ConstructorDecl)iter.next();
      if(!decl.throwsException(exceptionType))
        return false;
    }
    return true;
  }
    else {
      return getParent().Define_boolean_handlesException(this, caller, exceptionType);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:262
   * @apilevel internal
   */
  public boolean Define_boolean_mayBePublic(ASTNode caller, ASTNode child) {
    if (caller == getModifiersNoTransform()) {
      return true;
    }
    else {
      return getParent().Define_boolean_mayBePublic(this, caller);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:263
   * @apilevel internal
   */
  public boolean Define_boolean_mayBeProtected(ASTNode caller, ASTNode child) {
    if (caller == getModifiersNoTransform()) {
      return true;
    }
    else {
      return getParent().Define_boolean_mayBeProtected(this, caller);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:264
   * @apilevel internal
   */
  public boolean Define_boolean_mayBePrivate(ASTNode caller, ASTNode child) {
    if (caller == getModifiersNoTransform()) {
      return true;
    }
    else {
      return getParent().Define_boolean_mayBePrivate(this, caller);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:265
   * @apilevel internal
   */
  public boolean Define_boolean_mayBeStatic(ASTNode caller, ASTNode child) {
    if (caller == getModifiersNoTransform()) {
      return true;
    }
    else {
      return getParent().Define_boolean_mayBeStatic(this, caller);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:266
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
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:267
   * @apilevel internal
   */
  public boolean Define_boolean_mayBeTransient(ASTNode caller, ASTNode child) {
    if (caller == getModifiersNoTransform()) {
      return true;
    }
    else {
      return getParent().Define_boolean_mayBeTransient(this, caller);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:268
   * @apilevel internal
   */
  public boolean Define_boolean_mayBeVolatile(ASTNode caller, ASTNode child) {
    if (caller == getModifiersNoTransform()) {
      return true;
    }
    else {
      return getParent().Define_boolean_mayBeVolatile(this, caller);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/SyntacticClassification.jrag:78
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
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:260
   * @apilevel internal
   */
  public TypeDecl Define_TypeDecl_declType(ASTNode caller, ASTNode child) {
    if (caller == getInitOptNoTransform()) {
      return type();
    }
    else {
      return getParent().Define_TypeDecl_declType(this, caller);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeHierarchyCheck.jrag:168
   * @apilevel internal
   */
  public boolean Define_boolean_inStaticContext(ASTNode caller, ASTNode child) {
    if (caller == getInitOptNoTransform()) {
      return isStatic() || hostType().isInterfaceDecl();
    }
    else {
      return getParent().Define_boolean_inStaticContext(this, caller);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Annotations.jrag:80
   * @apilevel internal
   */
  public boolean Define_boolean_mayUseAnnotationTarget(ASTNode caller, ASTNode child, String name) {
    if (caller == getModifiersNoTransform()) {
      return name.equals("FIELD");
    }
    else {
      return getParent().Define_boolean_mayUseAnnotationTarget(this, caller, name);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/GenericMethodsInference.jrag:35
   * @apilevel internal
   */
  public TypeDecl Define_TypeDecl_assignConvertedType(ASTNode caller, ASTNode child) {
    if (caller == getInitOptNoTransform()) {
      return type();
    }
    else {
      return getParent().Define_TypeDecl_assignConvertedType(this, caller);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:91
   * @apilevel internal
   */
  public SmallSet<CFGNode> Define_SmallSet_CFGNode__following(ASTNode caller, ASTNode child) {
    if (caller == exit_value) {
      return getFollowingFieldOrInitializer(isStatic());
    }
    else if (caller == getInitOptNoTransform()) {
      return SmallSet.<CFGNode>singleton(exit());
    }
    else if (caller == entry_value) {
      return SmallSet.<CFGNode>singleton(hasInit() ? getInit() : exit());
    }
    else {
      return getParent().Define_SmallSet_CFGNode__following(this, caller);
    }
  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {    return super.rewriteTo();
  }  /**
   * @attribute coll
   * @aspect Java_CFG_1_4
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:19
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
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/JavaDeadAssigns.jrag:9
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
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/JavaLiveness1.4.jrag:17
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
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:23
   */
      for(java.util.Iterator iter = (succ()).iterator(); iter.hasNext(); ) {
        CFGNode ref = (CFGNode) iter.next();
        if (ref != null) {
          ref.CFGNode_collPred_contributors().add(this);
        }
      }
    super.collect_contributors_CFGNode_collPred();
  }
  protected void contributeTo_CFGNode_CFGNode_collPred(SmallSet<CFGNode> collection) {
    super.contributeTo_CFGNode_CFGNode_collPred(collection);
    collection.add(this);
  }

}
