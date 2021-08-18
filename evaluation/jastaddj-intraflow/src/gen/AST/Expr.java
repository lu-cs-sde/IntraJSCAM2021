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
 * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/grammar/Java.ast:103
 * @production Expr : {@link ASTNode};

 */
public abstract class Expr extends ASTNode<ASTNode> implements Cloneable, CFGNode {
  /**
   * @aspect TypeScopePropagation
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:433
   */
  public SimpleSet keepAccessibleTypes(SimpleSet oldSet) {
    SimpleSet newSet = SimpleSet.emptySet;
    TypeDecl hostType = hostType();
    for(Iterator iter = oldSet.iterator(); iter.hasNext(); ) {
      TypeDecl t = (TypeDecl)iter.next();
      if((hostType != null && t.accessibleFrom(hostType)) || (hostType == null && t.accessibleFromPackage(hostPackage())))
        newSet = newSet.add(t);
    }
    return newSet;
  }
  /**
   * Remove fields that are not accessible when using this Expr as qualifier
   * @return a set containing the accessible fields
   * @aspect VariableScope
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupVariable.jrag:169
   */
  public SimpleSet keepAccessibleFields(SimpleSet oldSet) {
    SimpleSet newSet = SimpleSet.emptySet;
    for(Iterator iter = oldSet.iterator(); iter.hasNext(); ) {
      Variable v = (Variable)iter.next();
      if(v instanceof FieldDeclaration) {
        FieldDeclaration f = (FieldDeclaration)v;
        if(mayAccess(f))
          newSet = newSet.add(f);
      }
    }
    return newSet;
  }
  /**
   * @see "JLS $6.6.2.1"
   * @return true if the expression may access the given field
   * @aspect VariableScope
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupVariable.jrag:196
   */
  public boolean mayAccess(FieldDeclaration f) {
    if(f.isPublic()) {
      return true;
    } else if(f.isProtected()) {
      if(f.hostPackage().equals(hostPackage()))
        return true;
      return hostType().mayAccess(this, f);
    } else if(f.isPrivate()) {
      return f.hostType().topLevelType() == hostType().topLevelType();
    } else {
      return f.hostPackage().equals(hostType().hostPackage());
    }
  }
  /**
   * @aspect QualifiedNames
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ResolveAmbiguousNames.jrag:106
   */
  public Dot qualifiesAccess(Access access) {
    Dot dot = new Dot(this, access);
    dot.setStart(this.getStart());
    dot.setEnd(access.getEnd());
    return dot;
  }
  /**
   * @aspect MethodSignature15
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/MethodSignature.jrag:91
   */
  protected SimpleSet chooseConstructor(Collection constructors, List argList) {
    SimpleSet potentiallyApplicable = SimpleSet.emptySet;
    // select potentially applicable constructors
    for(Iterator iter = constructors.iterator(); iter.hasNext(); ) {
      ConstructorDecl decl = (ConstructorDecl)iter.next();
      if(decl.potentiallyApplicable(argList) && decl.accessibleFrom(hostType()))
        potentiallyApplicable = potentiallyApplicable.add(decl);
    }
    // first phase
    SimpleSet maxSpecific = SimpleSet.emptySet;
    for(Iterator iter = potentiallyApplicable.iterator(); iter.hasNext(); ) {
      ConstructorDecl decl = (ConstructorDecl)iter.next();
      if(decl.applicableBySubtyping(argList))
        maxSpecific = mostSpecific(maxSpecific, decl);
    }

    // second phase
    if(maxSpecific.isEmpty()) {
      for(Iterator iter = potentiallyApplicable.iterator(); iter.hasNext(); ) {
        ConstructorDecl decl = (ConstructorDecl)iter.next();
        if(decl.applicableByMethodInvocationConversion(argList))
          maxSpecific = mostSpecific(maxSpecific, decl);
      }
    }

    // third phase
    if(maxSpecific.isEmpty()) {
      for(Iterator iter = potentiallyApplicable.iterator(); iter.hasNext(); ) {
        ConstructorDecl decl = (ConstructorDecl)iter.next();
        if(decl.isVariableArity() && decl.applicableVariableArity(argList))
          maxSpecific = mostSpecific(maxSpecific, decl);
      }
    }
    return maxSpecific;
  }
  /**
   * @aspect MethodSignature15
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/MethodSignature.jrag:128
   */
  protected static SimpleSet mostSpecific(SimpleSet maxSpecific, ConstructorDecl decl) {
    if(maxSpecific.isEmpty())
      maxSpecific = maxSpecific.add(decl);
    else {
      if(decl.moreSpecificThan((ConstructorDecl)maxSpecific.iterator().next()))
        maxSpecific = SimpleSet.emptySet.add(decl);
      else if(!((ConstructorDecl)maxSpecific.iterator().next()).moreSpecificThan(decl))
        maxSpecific = maxSpecific.add(decl);
    }
    return maxSpecific;
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
  public Expr() {
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
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:15
   */
  protected int numChildren() {
    return 0;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:21
   */
  public boolean mayHaveRewrite() {
    return false;
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:27
   */
  public void flushCache() {
    super.flushCache();
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
    uncheckedExceptionTarget_computed = false;
    uncheckedExceptionTarget_value = null;
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
   * @declaredat ASTNode:65
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
   * @declaredat ASTNode:82
   */
  public Expr clone() throws CloneNotSupportedException {
    Expr node = (Expr) super.clone();
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
    node.uncheckedExceptionTarget_computed = false;
    node.uncheckedExceptionTarget_value = null;
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
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:276
   */
  public abstract TypeDecl type();
  /**
   * @attribute syn
   * @aspect ConstantExpression
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ConstantExpression.jrag:11
   */
  public Constant constant() {
    ASTNode$State state = state();
    try {
        throw new UnsupportedOperationException("ConstantExpression operation constant" +
          " not supported for type " + getClass().getName());
      }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect ConstantExpression
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ConstantExpression.jrag:199
   */
  public boolean representableIn(TypeDecl t) {
    ASTNode$State state = state();
    try {
        if (!type().isByte() && !type().isChar() && !type().isShort() && !type().isInt()) {
          return false;
        }
        if (t.isByte())
          return constant().intValue() >= Byte.MIN_VALUE && constant().intValue() <= Byte.MAX_VALUE;
        if (t.isChar())
          return constant().intValue() >= Character.MIN_VALUE && constant().intValue() <= Character.MAX_VALUE;
        if (t.isShort())
          return constant().intValue() >= Short.MIN_VALUE && constant().intValue() <= Short.MAX_VALUE;
        if(t.isInt())
          return constant().intValue() >= Integer.MIN_VALUE && constant().intValue() <= Integer.MAX_VALUE;
        return false;
      }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect ConstantExpression
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ConstantExpression.jrag:227
   */
  public boolean isConstant() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect ConstantExpression
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ConstantExpression.jrag:256
   */
  public boolean isTrue() {
    ASTNode$State state = state();
    try {  return isConstant() && type() instanceof BooleanType && constant().booleanValue();  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect ConstantExpression
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ConstantExpression.jrag:257
   */
  public boolean isFalse() {
    ASTNode$State state = state();
    try {  return isConstant() && type() instanceof BooleanType && !constant().booleanValue();  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect DefiniteAssignment
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DefiniteAssignment.jrag:58
   */
  public Variable varDecl() {
    ASTNode$State state = state();
    try {  return null;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect DA
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DefiniteAssignment.jrag:346
   */
  public boolean isDAafterFalse(Variable v) {
    ASTNode$State state = state();
    try {  return isTrue() || isDAbefore(v);  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect DA
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DefiniteAssignment.jrag:345
   */
  public boolean isDAafterTrue(Variable v) {
    ASTNode$State state = state();
    try {  return isFalse() || isDAbefore(v);  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect DA
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DefiniteAssignment.jrag:235
   */
  public boolean isDAafter(Variable v) {
    ASTNode$State state = state();
    try {  return (isDAafterFalse(v) && isDAafterTrue(v)) || isDAbefore(v);  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect DU
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DefiniteAssignment.jrag:716
   */
  public boolean isDUafterFalse(Variable v) {
    ASTNode$State state = state();
    try {
        if(isTrue())
          return true;
        return isDUbefore(v);
      }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect DU
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DefiniteAssignment.jrag:715
   */
  public boolean isDUafterTrue(Variable v) {
    ASTNode$State state = state();
    try {
        if(isFalse())
          return true;
        return isDUbefore(v);
      }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect DU
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DefiniteAssignment.jrag:707
   */
  public boolean isDUafter(Variable v) {
    ASTNode$State state = state();
    try {  return isDUbefore(v);  }
    finally {
    }
  }
  /**
   * Compute the most specific constructor in a collection
   * the constructor is invoked with the arguments specified in argList
   * the curent context (this) is used to evaluate the hostType for accessibility
   * @attribute syn
   * @aspect ConstructScope
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupConstructor.jrag:34
   */
  public SimpleSet mostSpecificConstructor(Collection constructors) {
    ASTNode$State state = state();
    try {
        SimpleSet maxSpecific = SimpleSet.emptySet;
        for(Iterator iter = constructors.iterator(); iter.hasNext(); ) {
          ConstructorDecl decl = (ConstructorDecl)iter.next();
          if(applicableAndAccessible(decl)) {
            if(maxSpecific.isEmpty())
              maxSpecific = maxSpecific.add(decl);
            else {
              if(decl.moreSpecificThan((ConstructorDecl)maxSpecific.iterator().next()))
                maxSpecific = SimpleSet.emptySet.add(decl);
              else if(!((ConstructorDecl)maxSpecific.iterator().next()).moreSpecificThan(decl))
                maxSpecific = maxSpecific.add(decl);
            }
          }
        }
        return maxSpecific;
      }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect ConstructScope
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupConstructor.jrag:52
   */
  public boolean applicableAndAccessible(ConstructorDecl decl) {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect LookupFullyQualifiedTypes
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:86
   */
  public boolean hasQualifiedPackage(String packageName) {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect TypeScopePropagation
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:402
   */
  public SimpleSet qualifiedLookupType(String name) {
    ASTNode$State state = state();
    try {  return keepAccessibleTypes(type().memberTypes(name));  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect VariableScope
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupVariable.jrag:148
   */
  public SimpleSet qualifiedLookupVariable(String name) {
    ASTNode$State state = state();
    try {
        if(type().accessibleFrom(hostType()))
          return keepAccessibleFields(type().memberFields(name));
        return SimpleSet.emptySet;
      }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect PositiveLiterals
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/PositiveLiterals.jrag:15
   */
  public boolean isPositive() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect Names
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/QualifiedNames.jrag:25
   */
  public String packageName() {
    ASTNode$State state = state();
    try {  return "";  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect Names
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/QualifiedNames.jrag:63
   */
  public String typeName() {
    ASTNode$State state = state();
    try {  return "";  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect AccessTypes
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ResolveAmbiguousNames.jrag:13
   */
  public boolean isTypeAccess() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect AccessTypes
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ResolveAmbiguousNames.jrag:17
   */
  public boolean isMethodAccess() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect AccessTypes
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ResolveAmbiguousNames.jrag:21
   */
  public boolean isFieldAccess() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect AccessTypes
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ResolveAmbiguousNames.jrag:25
   */
  public boolean isSuperAccess() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect AccessTypes
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ResolveAmbiguousNames.jrag:31
   */
  public boolean isThisAccess() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect AccessTypes
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ResolveAmbiguousNames.jrag:37
   */
  public boolean isPackageAccess() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect AccessTypes
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ResolveAmbiguousNames.jrag:41
   */
  public boolean isArrayAccess() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect AccessTypes
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ResolveAmbiguousNames.jrag:45
   */
  public boolean isClassAccess() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect AccessTypes
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ResolveAmbiguousNames.jrag:49
   */
  public boolean isSuperConstructorAccess() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect QualifiedNames
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ResolveAmbiguousNames.jrag:55
   */
  public boolean isLeftChildOfDot() {
    ASTNode$State state = state();
    try {  return hasParentDot() && parentDot().getLeft() == this;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect QualifiedNames
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ResolveAmbiguousNames.jrag:56
   */
  public boolean isRightChildOfDot() {
    ASTNode$State state = state();
    try {  return hasParentDot() && parentDot().getRight() == this;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect QualifiedNames
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ResolveAmbiguousNames.jrag:69
   */
  public AbstractDot parentDot() {
    ASTNode$State state = state();
    try {  return getParent() instanceof AbstractDot ? (AbstractDot)getParent() : null;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect QualifiedNames
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ResolveAmbiguousNames.jrag:70
   */
  public boolean hasParentDot() {
    ASTNode$State state = state();
    try {  return parentDot() != null;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect QualifiedNames
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ResolveAmbiguousNames.jrag:72
   */
  public Access nextAccess() {
    ASTNode$State state = state();
    try {  return parentDot().nextAccess();  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect QualifiedNames
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ResolveAmbiguousNames.jrag:73
   */
  public boolean hasNextAccess() {
    ASTNode$State state = state();
    try {  return isLeftChildOfDot();  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect NestedTypes
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:511
   */
  public Stmt enclosingStmt() {
    ASTNode$State state = state();
    try {
        ASTNode node = this;
        while(node != null && !(node instanceof Stmt))
          node = node.getParent();
        return (Stmt)node;
      }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect TypeCheck
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeCheck.jrag:15
   */
  public boolean isVariable() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect TypeHierarchyCheck
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeHierarchyCheck.jrag:20
   */
  public boolean isUnknown() {
    ASTNode$State state = state();
    try {  return type().isUnknown();  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect TypeHierarchyCheck
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeHierarchyCheck.jrag:177
   */
  public boolean staticContextQualifier() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect Enums
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Enums.jrag:503
   */
  public boolean isEnumConstant() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect DotGraphSpec
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/DotGraphSpec.jrag:39
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
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/DotGraphSpec.jrag:56
   */
  public String dotAttributes() {
    ASTNode$State state = state();
    try {  return "shape=record, label=\"<name> " + dumpString() + " | {<pred> pred | <succ> succ}\"";  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect Helpers
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/Helpers.jrag:43
   */
  public boolean isLocalStore() {
    ASTNode$State state = state();
    try {  return false;  }
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
   * @aspect DefiniteAssignment
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DefiniteAssignment.jrag:15
   */
  public boolean isDest() {
    ASTNode$State state = state();
    boolean isDest_value = getParent().Define_boolean_isDest(this, null);

    return isDest_value;
  }
  /**
   * @attribute inh
   * @aspect DefiniteAssignment
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DefiniteAssignment.jrag:25
   */
  public boolean isSource() {
    ASTNode$State state = state();
    boolean isSource_value = getParent().Define_boolean_isSource(this, null);

    return isSource_value;
  }
  /**
   * @attribute inh
   * @aspect DefiniteAssignment
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DefiniteAssignment.jrag:49
   */
  public boolean isIncOrDec() {
    ASTNode$State state = state();
    boolean isIncOrDec_value = getParent().Define_boolean_isIncOrDec(this, null);

    return isIncOrDec_value;
  }
  /**
   * @attribute inh
   * @aspect DA
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DefiniteAssignment.jrag:234
   */
  public boolean isDAbefore(Variable v) {
    ASTNode$State state = state();
    boolean isDAbefore_Variable_value = getParent().Define_boolean_isDAbefore(this, null, v);

    return isDAbefore_Variable_value;
  }
  /**
   * @attribute inh
   * @aspect DU
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DefiniteAssignment.jrag:706
   */
  public boolean isDUbefore(Variable v) {
    ASTNode$State state = state();
    boolean isDUbefore_Variable_value = getParent().Define_boolean_isDUbefore(this, null, v);

    return isDUbefore_Variable_value;
  }
  /**
   * @attribute inh
   * @aspect LookupMethod
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupMethod.jrag:43
   */
  public Collection lookupMethod(String name) {
    ASTNode$State state = state();
    Collection lookupMethod_String_value = getParent().Define_Collection_lookupMethod(this, null, name);

    return lookupMethod_String_value;
  }
  /**
   * @attribute inh
   * @aspect SpecialClasses
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:49
   */
  public TypeDecl typeBoolean() {
    ASTNode$State state = state();
    TypeDecl typeBoolean_value = getParent().Define_TypeDecl_typeBoolean(this, null);

    return typeBoolean_value;
  }
  /**
   * @attribute inh
   * @aspect SpecialClasses
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:50
   */
  public TypeDecl typeByte() {
    ASTNode$State state = state();
    TypeDecl typeByte_value = getParent().Define_TypeDecl_typeByte(this, null);

    return typeByte_value;
  }
  /**
   * @attribute inh
   * @aspect SpecialClasses
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:51
   */
  public TypeDecl typeShort() {
    ASTNode$State state = state();
    TypeDecl typeShort_value = getParent().Define_TypeDecl_typeShort(this, null);

    return typeShort_value;
  }
  /**
   * @attribute inh
   * @aspect SpecialClasses
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:52
   */
  public TypeDecl typeChar() {
    ASTNode$State state = state();
    TypeDecl typeChar_value = getParent().Define_TypeDecl_typeChar(this, null);

    return typeChar_value;
  }
  /**
   * @attribute inh
   * @aspect SpecialClasses
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:53
   */
  public TypeDecl typeInt() {
    ASTNode$State state = state();
    TypeDecl typeInt_value = getParent().Define_TypeDecl_typeInt(this, null);

    return typeInt_value;
  }
  /**
   * @attribute inh
   * @aspect SpecialClasses
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:54
   */
  public TypeDecl typeLong() {
    ASTNode$State state = state();
    TypeDecl typeLong_value = getParent().Define_TypeDecl_typeLong(this, null);

    return typeLong_value;
  }
  /**
   * @attribute inh
   * @aspect SpecialClasses
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:55
   */
  public TypeDecl typeFloat() {
    ASTNode$State state = state();
    TypeDecl typeFloat_value = getParent().Define_TypeDecl_typeFloat(this, null);

    return typeFloat_value;
  }
  /**
   * @attribute inh
   * @aspect SpecialClasses
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:56
   */
  public TypeDecl typeDouble() {
    ASTNode$State state = state();
    TypeDecl typeDouble_value = getParent().Define_TypeDecl_typeDouble(this, null);

    return typeDouble_value;
  }
  /**
   * @attribute inh
   * @aspect SpecialClasses
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:57
   */
  public TypeDecl typeString() {
    ASTNode$State state = state();
    TypeDecl typeString_value = getParent().Define_TypeDecl_typeString(this, null);

    return typeString_value;
  }
  /**
   * @attribute inh
   * @aspect SpecialClasses
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:58
   */
  public TypeDecl typeVoid() {
    ASTNode$State state = state();
    TypeDecl typeVoid_value = getParent().Define_TypeDecl_typeVoid(this, null);

    return typeVoid_value;
  }
  /**
   * @attribute inh
   * @aspect SpecialClasses
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:59
   */
  public TypeDecl typeNull() {
    ASTNode$State state = state();
    TypeDecl typeNull_value = getParent().Define_TypeDecl_typeNull(this, null);

    return typeNull_value;
  }
  /**
   * @attribute inh
   * @aspect SpecialClasses
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:72
   */
  public TypeDecl unknownType() {
    ASTNode$State state = state();
    TypeDecl unknownType_value = getParent().Define_TypeDecl_unknownType(this, null);

    return unknownType_value;
  }
  /**
   * @attribute inh
   * @aspect LookupFullyQualifiedTypes
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:89
   */
  public boolean hasPackage(String packageName) {
    ASTNode$State state = state();
    boolean hasPackage_String_value = getParent().Define_boolean_hasPackage(this, null, packageName);

    return hasPackage_String_value;
  }
  /**
   * @attribute inh
   * @aspect LookupFullyQualifiedTypes
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:98
   */
  public TypeDecl lookupType(String packageName, String typeName) {
    ASTNode$State state = state();
    TypeDecl lookupType_String_String_value = getParent().Define_TypeDecl_lookupType(this, null, packageName, typeName);

    return lookupType_String_String_value;
  }
  /**
   * @attribute inh
   * @aspect TypeScopePropagation
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:230
   */
  public SimpleSet lookupType(String name) {
    ASTNode$State state = state();
    SimpleSet lookupType_String_value = getParent().Define_SimpleSet_lookupType(this, null, name);

    return lookupType_String_value;
  }
  /**
   * @attribute inh
   * @aspect VariableScope
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupVariable.jrag:19
   */
  public SimpleSet lookupVariable(String name) {
    ASTNode$State state = state();
    SimpleSet lookupVariable_String_value = getParent().Define_SimpleSet_lookupVariable(this, null, name);

    return lookupVariable_String_value;
  }
  /**
   * @attribute inh
   * @aspect SyntacticClassification
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/SyntacticClassification.jrag:20
   */
  public NameType nameType() {
    ASTNode$State state = state();
    NameType nameType_value = getParent().Define_NameType_nameType(this, null);

    return nameType_value;
  }
  /**
   * @attribute inh
   * @aspect NestedTypes
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:518
   */
  public BodyDecl enclosingBodyDecl() {
    ASTNode$State state = state();
    BodyDecl enclosingBodyDecl_value = getParent().Define_BodyDecl_enclosingBodyDecl(this, null);

    return enclosingBodyDecl_value;
  }
  /**
   * @attribute inh
   * @aspect NestedTypes
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:575
   */
  public String hostPackage() {
    ASTNode$State state = state();
    String hostPackage_value = getParent().Define_String_hostPackage(this, null);

    return hostPackage_value;
  }
  /**
   * @attribute inh
   * @aspect NestedTypes
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:591
   */
  public TypeDecl hostType() {
    ASTNode$State state = state();
    TypeDecl hostType_value = getParent().Define_TypeDecl_hostType(this, null);

    return hostType_value;
  }
  /**
   * @attribute inh
   * @aspect TypeHierarchyCheck
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeHierarchyCheck.jrag:11
   */
  public String methodHost() {
    ASTNode$State state = state();
    String methodHost_value = getParent().Define_String_methodHost(this, null);

    return methodHost_value;
  }
  /**
   * @attribute inh
   * @aspect TypeHierarchyCheck
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeHierarchyCheck.jrag:161
   */
  public boolean inStaticContext() {
    ASTNode$State state = state();
    boolean inStaticContext_value = getParent().Define_boolean_inStaticContext(this, null);

    return inStaticContext_value;
  }
  /**
   * @attribute inh
   * @aspect GenericMethodsInference
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/GenericMethodsInference.jrag:33
   */
  public TypeDecl assignConvertedType() {
    ASTNode$State state = state();
    TypeDecl assignConvertedType_value = getParent().Define_TypeDecl_assignConvertedType(this, null);

    return assignConvertedType_value;
  }
  /**
   * @attribute inh
   * @aspect GenericsTypeAnalysis
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Generics.jrag:285
   */
  public boolean inExtendsOrImplements() {
    ASTNode$State state = state();
    boolean inExtendsOrImplements_value = getParent().Define_boolean_inExtendsOrImplements(this, null);

    return inExtendsOrImplements_value;
  }
  /**
   * @attribute inh
   * @aspect Java_CFG_1_4
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:431
   */
  public SmallSet<CFGNode> throwTarget(TypeDecl type) {
    ASTNode$State state = state();
    SmallSet<CFGNode> throwTarget_TypeDecl_value = getParent().Define_SmallSet_CFGNode__throwTarget(this, null, type);

    return throwTarget_TypeDecl_value;
  }
  /**
   * @attribute inh
   * @aspect Java_CFG_1_4
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:516
   */
  public SmallSet<CFGNode> followingWhenTrue() {
    ASTNode$State state = state();
    SmallSet<CFGNode> followingWhenTrue_value = getParent().Define_SmallSet_CFGNode__followingWhenTrue(this, null);

    return followingWhenTrue_value;
  }
  /**
   * @attribute inh
   * @aspect Java_CFG_1_4
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:517
   */
  public SmallSet<CFGNode> followingWhenFalse() {
    ASTNode$State state = state();
    SmallSet<CFGNode> followingWhenFalse_value = getParent().Define_SmallSet_CFGNode__followingWhenFalse(this, null);

    return followingWhenFalse_value;
  }
  /**
   * @attribute inh
   * @aspect Java_CFG_1_4
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:707
   */
  public SmallSet<CFGNode> uncheckedExceptionTarget() {
    if(uncheckedExceptionTarget_computed) {
      return uncheckedExceptionTarget_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    uncheckedExceptionTarget_value = getParent().Define_SmallSet_CFGNode__uncheckedExceptionTarget(this, null);
    if (isFinal && num == state().boundariesCrossed) {
      uncheckedExceptionTarget_computed = true;
    } else {
    }

    return uncheckedExceptionTarget_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean uncheckedExceptionTarget_computed = false;
  /**
   * @apilevel internal
   */
  protected SmallSet<CFGNode> uncheckedExceptionTarget_value;
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
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:21
   */
      for(java.util.Iterator iter = (succ()).iterator(); iter.hasNext(); ) {
        CFGNode ref = (CFGNode) iter.next();
        if (ref != null) {
          ref.CFGNode_collPred_contributors().add(this);
        }
      }
    super.collect_contributors_CFGNode_collPred();
  }
  protected void collect_contributors_CFGNode_coll_liveness_out() {
  /**
   * @attribute coll
   * @aspect JavaLiveness14
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaLiveness1.4.jrag:19
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

  protected void contributeTo_CFGNode_CFGNode_coll_liveness_out(BitSet collection) {
    super.contributeTo_CFGNode_CFGNode_coll_liveness_out(collection);
    collection.add(liveness_in());
  }

}
