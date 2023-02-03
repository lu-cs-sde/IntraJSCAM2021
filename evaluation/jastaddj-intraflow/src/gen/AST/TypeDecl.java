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
 * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/grammar/Java.ast:40
 * @production TypeDecl : {@link ASTNode} ::= <span class="component">{@link Modifiers}</span> <span class="component">&lt;ID:String&gt;</span> <span class="component">{@link BodyDecl}*</span>;

 */
public abstract class TypeDecl extends ASTNode<ASTNode> implements Cloneable, SimpleSet, Iterator, VariableScope {
  /**
   * @aspect AnonymousClasses
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/AnonymousClasses.jrag:29
   */
  public int anonymousIndex = 0;
  /**
   * @aspect AnonymousClasses
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/AnonymousClasses.jrag:46
   */
  public int nextAnonymousIndex() {
    if(isNestedType())
      return enclosingType().nextAnonymousIndex();
    return anonymousIndex++;
  }
  /**
   * @aspect BoundNames
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/BoundNames.jrag:24
   */
  public MethodDecl addMemberMethod(MethodDecl m) {
    addBodyDecl(m);
    return (MethodDecl)getBodyDecl(getNumBodyDecl()-1);
    /*
    HashMap map = methodsNameMap();
    ArrayList list = (ArrayList)map.get(m.name());
    if(list == null) {
      list = new ArrayList(4);
      map.put(m.name(), list);
    }
    list.add(m);
    if(!memberMethods(m.name()).contains(m))
      throw new Error("The method " + m.signature() + " added to " + typeName() + " can not be found using lookupMemberMethod");
    */
  }
  /**
   * @aspect BoundNames
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/BoundNames.jrag:40
   */
  public ConstructorDecl addConstructor(ConstructorDecl c) {
    addBodyDecl(c);
    return (ConstructorDecl)getBodyDecl(getNumBodyDecl()-1);
  }
  /**
   * @aspect BoundNames
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/BoundNames.jrag:45
   */
  public ClassDecl addMemberClass(ClassDecl c) {
    addBodyDecl(new MemberClassDecl(c));
    return ((MemberClassDecl)getBodyDecl(getNumBodyDecl()-1)).getClassDecl();
  }
  /**
   * @aspect BoundNames
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/BoundNames.jrag:52
   */
  public FieldDeclaration addMemberField(FieldDeclaration f) {
    addBodyDecl(f);
    return (FieldDeclaration)getBodyDecl(getNumBodyDecl()-1);
    //if(!memberFields(f.name()).contains(f))
    //  throw new Error("The field " + f.name() + " added to " + typeName() + " can not be found using lookupMemberField");
  }
  /**
   * @aspect BoundNames
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/BoundNames.jrag:90
   */
  public TypeAccess createBoundAccess() {
    return new BoundTypeAccess("", name(), this);
  }
  /**
   * @aspect DataStructures
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DataStructures.jrag:135
   */
  public SimpleSet add(Object o) {
    return new SimpleSetImpl().add(this).add(o);
  }
  /**
   * @aspect DataStructures
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DataStructures.jrag:139
   */
  public boolean isSingleton() { return true; }
  /**
   * @aspect DataStructures
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DataStructures.jrag:140
   */
  public boolean isSingleton(Object o) { return contains(o); }
  /**
   * @aspect DataStructures
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DataStructures.jrag:143
   */
  private TypeDecl iterElem;
  /**
   * @aspect DataStructures
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DataStructures.jrag:144
   */
  public Iterator iterator() { iterElem = this; return this; }
  /**
   * @aspect DataStructures
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DataStructures.jrag:145
   */
  public boolean hasNext() { return iterElem != null; }
  /**
   * @aspect DataStructures
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DataStructures.jrag:146
   */
  public Object next() { Object o = iterElem; iterElem = null; return o; }
  /**
   * @aspect DataStructures
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DataStructures.jrag:147
   */
  public void remove() { throw new UnsupportedOperationException(); }
  /**
   * @aspect DeclareBeforeUse
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DeclareBeforeUse.jrag:41
   */
  public boolean declaredBeforeUse(Variable decl, ASTNode use) {
    int indexDecl = ((ASTNode)decl).varChildIndex(this);
    int indexUse = use.varChildIndex(this);
    return indexDecl < indexUse;
  }
  /**
   * @aspect DeclareBeforeUse
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DeclareBeforeUse.jrag:46
   */
  public boolean declaredBeforeUse(Variable decl, int indexUse) {
    int indexDecl = ((ASTNode)decl).varChildIndex(this);
    return indexDecl < indexUse;
  }
  /**
   * @aspect ConstructorLookup
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupConstructor.jrag:93
   */
  public ConstructorDecl lookupConstructor(ConstructorDecl signature) {
    for (Iterator iter = constructors().iterator(); iter.hasNext(); ) {
      ConstructorDecl decl = (ConstructorDecl)iter.next();
      if (decl.sameSignature(signature)) {
        return decl;
      }
    }
    return null;
  }
  /**
   * @return true if the method access may access the method
   * @aspect MethodDecl
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupMethod.jrag:234
   */
  public boolean mayAccess(MethodAccess access, MethodDecl method) {
    if (instanceOf(method.hostType())
        && access.qualifier().type().instanceOf(this))
        return true;

    if (isNestedType())
      return enclosingType().mayAccess(access, method);
    else
      return false;
  }
  /**
   * Iterate over all local methods in the type.
   * @return method iterator
   * @aspect MemberMethods
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupMethod.jrag:285
   */
  public Iterator<MethodDecl> localMethodsIterator() {
    return new Iterator<MethodDecl>() {
      private Iterator<SimpleSet> outer = localMethodsSignatureMap().values().iterator();
      private Iterator inner = null;
      public boolean hasNext() {
        if ((inner == null || !inner.hasNext()) && outer.hasNext()) {
          inner = outer.next().iterator();
        }
        return inner == null ? false : inner.hasNext();
      }
      public MethodDecl next() {
        return (MethodDecl) inner.next();
      }
      public void remove() { throw new UnsupportedOperationException(); }
    };
  }
  /**
   * Iterate over all member methods in the type.
   * @return method iterator
   * @aspect MemberMethods
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupMethod.jrag:371
   */
  public Iterator<MethodDecl> methodsIterator() {
    return new Iterator<MethodDecl>() {
      private Iterator<SimpleSet> outer = methodsSignatureMap().values().iterator();
      private Iterator inner = null;
      public boolean hasNext() {
        if((inner == null || !inner.hasNext()) && outer.hasNext())
          inner = outer.next().iterator();
        return inner != null ? inner.hasNext() : false;
      }
      public MethodDecl next() {
        return (MethodDecl) inner.next();
      }
      public void remove() { throw new UnsupportedOperationException(); }
    };
  }
  /**
   * @aspect MemberMethods
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupMethod.jrag:452
   */
  protected boolean allMethodsAbstract(SimpleSet set) {
    if (set == null) {
      return true;
    }
    for (Iterator iter = set.iterator(); iter.hasNext(); ) {
      MethodDecl m = (MethodDecl)iter.next();
      if (!m.isAbstract()) {
        return false;
      }
    }
    return true;
  }
  /**
   * @return true if the expression may access the field
   * @aspect VariableScope
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupVariable.jrag:213
   */
  public boolean mayAccess(Expr expr, FieldDeclaration field) {
    if (instanceOf(field.hostType())) {
      if (!field.isInstanceVariable()
          || expr.isSuperAccess()
          || expr.type().instanceOf(this))
        return true;
    }

    if (isNestedType()) {
      return enclosingType().mayAccess(expr, field);
    } else {
      return false;
    }
  }
  /**
   * @aspect Fields
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupVariable.jrag:315
   */
  public Iterator fieldsIterator() {
    return new Iterator() {
      private Iterator outer = memberFieldsMap().values().iterator();
      private Iterator inner = null;
      public boolean hasNext() {
        if((inner == null || !inner.hasNext()) && outer.hasNext())
          inner = ((SimpleSet)outer.next()).iterator();
        return inner != null ? inner.hasNext() : false;
      }
      public Object next() {
        return inner.next();
      }
      public void remove() { throw new UnsupportedOperationException(); }
    };
  }
  /**
   * @aspect Modifiers
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:68
   */
  public void checkModifiers() {
    super.checkModifiers();
    // 8.1.1
    if(isPublic() && !isTopLevelType() && !isMemberType())
      error("public pertains only to top level types and member types");

    // 8.1.1
    if((isProtected() || isPrivate()) && !(isMemberType() && enclosingType().isClassDecl()))
      error("protected and private may only be used on member types within a directly enclosing class declaration");

    // 8.1.1
    if(isStatic() && !isMemberType())
      error("static pertains only to member types");


    // 8.4.3.1
    // 8.1.1.1
    if (!isAbstract() && hasAbstract()) {
      StringBuilder sb = new StringBuilder();
      sb.append("" + name() + " is not declared abstract but contains abstract members: \n");
      for (Iterator iter = unimplementedMethods().iterator(); iter.hasNext(); ) {
        MethodDecl m = (MethodDecl)iter.next();
        sb.append("  " + m.signature() + " in " + m.hostType().typeName() + "\n");
      }
      error(sb.toString());
    }
  }
  /**
   * @aspect NameCheck
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/NameCheck.jrag:277
   */
  public void nameCheck() {
    if(isTopLevelType() && lookupType(packageName(), name()) != this)
      error("duplicate type " + name() + " in package " + packageName());

    if(!isTopLevelType() && !isAnonymous() && !isLocalClass() && extractSingleType(enclosingType().memberTypes(name())) != this)
      error("duplicate member type " + name() + " in type " + enclosingType().typeName());

    // 14.3
    if(isLocalClass()) {
      TypeDecl typeDecl = extractSingleType(lookupType(name()));
      if(typeDecl != null && typeDecl != this && typeDecl.isLocalClass() && enclosingBlock() == typeDecl.enclosingBlock())
        error("local class named " + name() + " may not be redeclared as a local class in the same block");
    }

    if(!packageName().equals("") && hasPackage(fullName()))
      error("type name conflicts with a package using the same name: " + name());

    // 8.1 & 9.1
    if(hasEnclosingTypeDecl(name())) {
      error("type may not have the same simple name as an enclosing type declaration");
    }
  }
  /**
   * @aspect PrettyPrint
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/PrettyPrint.jadd:78
   */
  protected void ppBodyDecls(StringBuffer sb) {
    sb.append(" {");
    for(int i=0; i < getNumBodyDecl(); i++) {
      getBodyDecl(i).prettyPrint(sb);
    }
    sb.append(indent() + "}");
  }
  /**
   * @aspect CreateQualifiedAccesses
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/QualifiedNames.jrag:97
   */
  public Access createQualifiedAccess() {
    if(isLocalClass() || isAnonymous()) {
      return new TypeAccess(name());
    }
    else if(!isTopLevelType()) {
      return enclosingType().createQualifiedAccess().qualifiesAccess(new TypeAccess(name()));
    }
    else {
      return new TypeAccess(packageName(), name());
    }
  }
  /**
   * @aspect TypeAnalysis
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:234
   */
  public FieldDeclaration findSingleVariable(String name) {
    return (FieldDeclaration)memberFields(name).iterator().next();
  }
  /**
   * @aspect TypeHierarchyCheck
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeHierarchyCheck.jrag:184
   */
  public void refined_TypeHierarchyCheck_TypeDecl_typeCheck() {
    // 8.4.6.4 & 9.4.1
    for (Iterator iter1 = localMethodsIterator(); iter1.hasNext(); ) {
      MethodDecl m = (MethodDecl)iter1.next();
      ASTNode target = m.hostType() == this ? (ASTNode)m : (ASTNode)this;

      for (Iterator i2 = ancestorMethods(m.signature()).iterator(); i2.hasNext(); ) {
        MethodDecl decl = (MethodDecl)i2.next();
        if (m.overrides(decl)) {
          // 8.4.6.1
          if (!m.isStatic() && decl.isStatic()) {
            target.error("an instance method may not override a static method");
          }

          // regardless of overriding
          // 8.4.6.3
          if (!m.mayOverride(decl)) {
            target.error("the return type of method " + m.fullSignature() +
                " in " + m.hostType().typeName() +
                " does not match the return type of method " +
                decl.fullSignature() + " in " + decl.hostType().typeName() +
                " and may thus not be overriden");
          }

          // regardless of overriding
          // 8.4.4
          for (int i = 0; i < m.getNumException(); i++) {
            Access e = m.getException(i);
            boolean found = false;
            for (int j = 0; !found && j < decl.getNumException(); j++) {
              if (e.type().instanceOf(decl.getException(j).type())) {
                found = true;
              }
            }
            if (!found && e.type().isUncheckedException()) {
              target.error(m.fullSignature() + " in " + m.hostType().typeName() +
                  " may not throw more checked exceptions than overridden method " +
                  decl.fullSignature() + " in " + decl.hostType().typeName());
            }
          }
          // 8.4.6.3
          if (decl.isPublic() && !m.isPublic()) {
            target.error("overriding access modifier error");
          }
          // 8.4.6.3
          if (decl.isProtected() && !(m.isPublic() || m.isProtected())) {
            target.error("overriding access modifier error");
          }
          // 8.4.6.3
          if ((!decl.isPrivate() && !decl.isProtected() && !decl.isPublic()) && m.isPrivate()) {
            target.error("overriding access modifier error");
          }
          // regardless of overriding
          if (decl.isFinal()) {
            target.error("method " + m.fullSignature() + " in " +
                hostType().typeName() + " can not override final method " +
                decl.fullSignature() + " in " + decl.hostType().typeName());
          }
        }
        if (m.hides(decl)) {
          // 8.4.6.2
          if(m.isStatic() && !decl.isStatic()) {
            target.error("a static method may not hide an instance method");
          }
          // 8.4.6.3
          if (!m.mayOverride(decl)) {
            target.error("can not hide a method with a different return type");
          }
          // 8.4.4
          for (int i = 0; i < m.getNumException(); i++) {
            Access e = m.getException(i);
            boolean found = false;
            for (int j = 0; !found && j < decl.getNumException(); j++) {
              if (e.type().instanceOf(decl.getException(j).type())) {
                found = true;
              }
            }
            if (!found) {
              target.error("may not throw more checked exceptions than hidden method");
            }
          }
          // 8.4.6.3
          if (decl.isPublic() && !m.isPublic()) {
            target.error("hiding access modifier error: public method " +
                decl.fullSignature() + " in " + decl.hostType().typeName() +
                " is hidden by non public method " + m.fullSignature() + " in " +
                m.hostType().typeName());
          }
          // 8.4.6.3
          if (decl.isProtected() && !(m.isPublic() || m.isProtected())) {
            target.error("hiding access modifier error: protected method " +
                decl.fullSignature() + " in " + decl.hostType().typeName() +
                " is hidden by non (public|protected) method " +
                m.fullSignature() + " in " + m.hostType().typeName());
          }
          // 8.4.6.3
          if ((!decl.isPrivate() && !decl.isProtected() && !decl.isPublic()) && m.isPrivate()) {
            target.error("hiding access modifier error: default method " +
                decl.fullSignature() + " in " + decl.hostType().typeName() +
                " is hidden by private method " + m.fullSignature() + " in " +
                m.hostType().typeName());
          }
          if (decl.isFinal()) {
            target.error("method " + m.fullSignature() + " in " +
                hostType().typeName() + " can not hide final method " +
                decl.fullSignature() + " in " + decl.hostType().typeName());
          }
        }
      }
    }
  }
  /**
   * Error-check two interface method declarations.
   * @aspect TypeHierarchyCheck
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeHierarchyCheck.jrag:416
   */
  protected void refined_TypeHierarchyCheck_TypeDecl_checkAbstractMethodDecls(MethodDecl m1, MethodDecl m2) {
    if (!m1.mayOverride(m2) && !m2.mayOverride(m1)) {
      StringBuilder err = new StringBuilder();
      TypeDecl host1 = m1.hostType();
      TypeDecl host2 = m2.hostType();
      if (host1 != this || host2 != this) {
        err.append("inherited ");
      }
      err.append("method " + m1.fullSignature() + " is multiply declared " +
          "with incompatible return types in " + fullName());
      error(err.toString());
    }
  }
  /**
   * @aspect Generics
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Generics.jrag:198
   */
  public TypeDecl makeGeneric(Signatures.ClassSignature s) {
    return this;
  }
  /**
   * @aspect LookupParTypeDecl
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Generics.jrag:706
   */
  public TypeDecl substitute(TypeVariable typeVariable) {
    if(isTopLevelType())
      return typeVariable;
    return enclosingType().substitute(typeVariable);
  }
  /**
   * @aspect LookupParTypeDecl
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Generics.jrag:744
   */
  public Access substitute(Parameterization parTypeDecl) {
    if(parTypeDecl instanceof ParTypeDecl && ((ParTypeDecl)parTypeDecl).genericDecl() == this)
      return ((TypeDecl)parTypeDecl).createBoundAccess();
    if(isTopLevelType())
      return createBoundAccess();
    return enclosingType().substitute(parTypeDecl).qualifiesAccess(new TypeAccess(name()));
  }
  /**
   * @aspect LookupParTypeDecl
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Generics.jrag:784
   */
  public Access substituteReturnType(Parameterization parTypeDecl) {
    return substitute(parTypeDecl);
  }
  /**
   * @aspect LookupParTypeDecl
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Generics.jrag:828
   */
  public Access substituteParameterType(Parameterization parTypeDecl) {
    return substitute(parTypeDecl);
  }
  /**
   * @declaredat ASTNode:1
   */
  public TypeDecl() {
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
    setChild(new List(), 1);
  }
  /**
   * @declaredat ASTNode:14
   */
  public TypeDecl(Modifiers p0, String p1, List<BodyDecl> p2) {
    setChild(p0, 0);
    setID(p1);
    setChild(p2, 1);
  }
  /**
   * @declaredat ASTNode:19
   */
  public TypeDecl(Modifiers p0, beaver.Symbol p1, List<BodyDecl> p2) {
    setChild(p0, 0);
    setID(p1);
    setChild(p2, 1);
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:27
   */
  protected int numChildren() {
    return 2;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:33
   */
  public boolean mayHaveRewrite() {
    return false;
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:39
   */
  public void flushCache() {
    super.flushCache();
    accessibleFromPackage_String_values = null;
    accessibleFromExtend_TypeDecl_values = null;
    accessibleFrom_TypeDecl_values = null;
    dimension_computed = false;
    elementType_computed = false;
    elementType_value = null;
    arrayType_computed = false;
    arrayType_value = null;
    isException_computed = false;
    isCheckedException_computed = false;
    isUncheckedException_computed = false;
    mayCatch_TypeDecl_values = null;
    constructors_computed = false;
    constructors_value = null;
    unqualifiedLookupMethod_String_values = null;
    methodsNameMap_computed = false;
    methodsNameMap_value = null;
    localMethodsSignatureMap_computed = false;
    localMethodsSignatureMap_value = null;
    methodsSignatureMap_computed = false;
    methodsSignatureMap_value = null;
    ancestorMethods_String_values = null;
    localTypeDecls_String_values = null;
    memberTypes_String_values = null;
    localFields_String_values = null;
    localFieldsMap_computed = false;
    localFieldsMap_value = null;
    memberFieldsMap_computed = false;
    memberFieldsMap_value = null;
    memberFields_String_values = null;
    hasAbstract_computed = false;
    unimplementedMethods_computed = false;
    unimplementedMethods_value = null;
    isPublic_computed = false;
    isStatic_computed = false;
    fullName_computed = false;
    fullName_value = null;
    typeName_computed = false;
    typeName_value = null;
    narrowingConversionTo_TypeDecl_values = null;
    methodInvocationConversionTo_TypeDecl_values = null;
    castingConversionTo_TypeDecl_values = null;
    isString_computed = false;
    isObject_computed = false;
    instanceOf_TypeDecl_values = null;
    isCircular_visited = -1;
    isCircular_computed = false;
    isCircular_initialized = false;
    boxed_computed = false;
    boxed_value = null;
    unboxed_computed = false;
    unboxed_value = null;
    isIterable_computed = false;
    involvesTypeParameters_visited = -1;
    involvesTypeParameters_computed = false;
    involvesTypeParameters_initialized = false;
    erasure_computed = false;
    erasure_value = null;
    implementedInterfaces_computed = false;
    implementedInterfaces_value = null;
    usesTypeVariable_visited = -1;
    usesTypeVariable_computed = false;
    usesTypeVariable_initialized = false;
    sourceTypeDecl_computed = false;
    sourceTypeDecl_value = null;
    containedIn_TypeDecl_values = null;
    sameStructure_TypeDecl_values = null;
    subtype_TypeDecl_values = null;
    emptyBitSet_computed = false;
    emptyBitSet_value = null;
    componentType_computed = false;
    componentType_value = null;
    isDAbefore_Variable_values = null;
    isDUbefore_Variable_values = null;
    typeException_computed = false;
    typeException_value = null;
    typeRuntimeException_computed = false;
    typeRuntimeException_value = null;
    typeError_computed = false;
    typeError_value = null;
    lookupMethod_String_values = null;
    typeObject_computed = false;
    typeObject_value = null;
    lookupType_String_values = null;
    lookupVariable_String_values = null;
    packageName_computed = false;
    packageName_value = null;
    isAnonymous_computed = false;
    unknownType_computed = false;
    unknownType_value = null;
    inExplicitConstructorInvocation_computed = false;
    inStaticContext_computed = false;
        collect_contributors_CFGNode_collPred = false;
        collect_contributors_CFGNode_coll_liveness_out = false;
        collecting_contributors_CFGNode_coll_liveness_out = false;
        collect_contributors_CFGNode_collPred = false;
        collect_contributors_CFGNode_coll_liveness_out = false;
        collecting_contributors_CFGNode_coll_liveness_out = false;
        collect_contributors_CFGNode_collPred = false;
        collect_contributors_CFGNode_coll_liveness_out = false;
        collecting_contributors_CFGNode_coll_liveness_out = false;
        collect_contributors_CFGNode_collPred = false;
        collect_contributors_CFGNode_coll_liveness_out = false;
        collecting_contributors_CFGNode_coll_liveness_out = false;
        collect_contributors_CFGNode_collPred = false;
        collect_contributors_CFGNode_coll_liveness_out = false;
        collecting_contributors_CFGNode_coll_liveness_out = false;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:152
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
        collect_contributors_CFGNode_collPred = false;
        collect_contributors_CFGNode_coll_liveness_out = false;
        collecting_contributors_CFGNode_coll_liveness_out = false;
        collect_contributors_CFGNode_collPred = false;
        collect_contributors_CFGNode_coll_liveness_out = false;
        collecting_contributors_CFGNode_coll_liveness_out = false;
        collect_contributors_CFGNode_collPred = false;
        collect_contributors_CFGNode_coll_liveness_out = false;
        collecting_contributors_CFGNode_coll_liveness_out = false;
        collect_contributors_CFGNode_collPred = false;
        collect_contributors_CFGNode_coll_liveness_out = false;
        collecting_contributors_CFGNode_coll_liveness_out = false;
        collect_contributors_CFGNode_collPred = false;
        collect_contributors_CFGNode_coll_liveness_out = false;
        collecting_contributors_CFGNode_coll_liveness_out = false;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:173
   */
  public TypeDecl clone() throws CloneNotSupportedException {
    TypeDecl node = (TypeDecl) super.clone();
    node.accessibleFromPackage_String_values = null;
    node.accessibleFromExtend_TypeDecl_values = null;
    node.accessibleFrom_TypeDecl_values = null;
    node.dimension_computed = false;
    node.elementType_computed = false;
    node.elementType_value = null;
    node.arrayType_computed = false;
    node.arrayType_value = null;
    node.isException_computed = false;
    node.isCheckedException_computed = false;
    node.isUncheckedException_computed = false;
    node.mayCatch_TypeDecl_values = null;
    node.constructors_computed = false;
    node.constructors_value = null;
    node.unqualifiedLookupMethod_String_values = null;
    node.methodsNameMap_computed = false;
    node.methodsNameMap_value = null;
    node.localMethodsSignatureMap_computed = false;
    node.localMethodsSignatureMap_value = null;
    node.methodsSignatureMap_computed = false;
    node.methodsSignatureMap_value = null;
    node.ancestorMethods_String_values = null;
    node.localTypeDecls_String_values = null;
    node.memberTypes_String_values = null;
    node.localFields_String_values = null;
    node.localFieldsMap_computed = false;
    node.localFieldsMap_value = null;
    node.memberFieldsMap_computed = false;
    node.memberFieldsMap_value = null;
    node.memberFields_String_values = null;
    node.hasAbstract_computed = false;
    node.unimplementedMethods_computed = false;
    node.unimplementedMethods_value = null;
    node.isPublic_computed = false;
    node.isStatic_computed = false;
    node.fullName_computed = false;
    node.fullName_value = null;
    node.typeName_computed = false;
    node.typeName_value = null;
    node.narrowingConversionTo_TypeDecl_values = null;
    node.methodInvocationConversionTo_TypeDecl_values = null;
    node.castingConversionTo_TypeDecl_values = null;
    node.isString_computed = false;
    node.isObject_computed = false;
    node.instanceOf_TypeDecl_values = null;
    node.isCircular_visited = -1;
    node.isCircular_computed = false;
    node.isCircular_initialized = false;
    node.boxed_computed = false;
    node.boxed_value = null;
    node.unboxed_computed = false;
    node.unboxed_value = null;
    node.isIterable_computed = false;
    node.involvesTypeParameters_visited = -1;
    node.involvesTypeParameters_computed = false;
    node.involvesTypeParameters_initialized = false;
    node.erasure_computed = false;
    node.erasure_value = null;
    node.implementedInterfaces_computed = false;
    node.implementedInterfaces_value = null;
    node.usesTypeVariable_visited = -1;
    node.usesTypeVariable_computed = false;
    node.usesTypeVariable_initialized = false;
    node.sourceTypeDecl_computed = false;
    node.sourceTypeDecl_value = null;
    node.containedIn_TypeDecl_values = null;
    node.sameStructure_TypeDecl_values = null;
    node.subtype_TypeDecl_values = null;
    node.emptyBitSet_computed = false;
    node.emptyBitSet_value = null;
    node.componentType_computed = false;
    node.componentType_value = null;
    node.isDAbefore_Variable_values = null;
    node.isDUbefore_Variable_values = null;
    node.typeException_computed = false;
    node.typeException_value = null;
    node.typeRuntimeException_computed = false;
    node.typeRuntimeException_value = null;
    node.typeError_computed = false;
    node.typeError_value = null;
    node.lookupMethod_String_values = null;
    node.typeObject_computed = false;
    node.typeObject_value = null;
    node.lookupType_String_values = null;
    node.lookupVariable_String_values = null;
    node.packageName_computed = false;
    node.packageName_value = null;
    node.isAnonymous_computed = false;
    node.unknownType_computed = false;
    node.unknownType_value = null;
    node.inExplicitConstructorInvocation_computed = false;
    node.inStaticContext_computed = false;
    node.in$Circle(false);
    node.is$Final(false);
    return node;
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
   * Replaces the BodyDecl list.
   * @param list The new list node to be used as the BodyDecl list.
   * @apilevel high-level
   */
  public void setBodyDeclList(List<BodyDecl> list) {
    setChild(list, 1);
  }
  /**
   * Retrieves the number of children in the BodyDecl list.
   * @return Number of children in the BodyDecl list.
   * @apilevel high-level
   */
  public int getNumBodyDecl() {
    return getBodyDeclList().getNumChild();
  }
  /**
   * Retrieves the number of children in the BodyDecl list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the BodyDecl list.
   * @apilevel low-level
   */
  public int getNumBodyDeclNoTransform() {
    return getBodyDeclListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the BodyDecl list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the BodyDecl list.
   * @apilevel high-level
   */
  public BodyDecl getBodyDecl(int i) {
    return (BodyDecl) getBodyDeclList().getChild(i);
  }
  /**
   * Check whether the BodyDecl list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasBodyDecl() {
    return getBodyDeclList().getNumChild() != 0;
  }
  /**
   * Append an element to the BodyDecl list.
   * @param node The element to append to the BodyDecl list.
   * @apilevel high-level
   */
  public void addBodyDecl(BodyDecl node) {
    List<BodyDecl> list = (parent == null || state == null) ? getBodyDeclListNoTransform() : getBodyDeclList();
    list.addChild(node);
  }
  /**
   * @apilevel low-level
   */
  public void addBodyDeclNoTransform(BodyDecl node) {
    List<BodyDecl> list = getBodyDeclListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the BodyDecl list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setBodyDecl(BodyDecl node, int i) {
    List<BodyDecl> list = getBodyDeclList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the BodyDecl list.
   * @return The node representing the BodyDecl list.
   * @apilevel high-level
   */
  public List<BodyDecl> getBodyDeclList() {
    List<BodyDecl> list = (List<BodyDecl>) getChild(1);
    list.getNumChild();
    return list;
  }
  /**
   * Retrieves the BodyDecl list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the BodyDecl list.
   * @apilevel low-level
   */
  public List<BodyDecl> getBodyDeclListNoTransform() {
    return (List<BodyDecl>) getChildNoTransform(1);
  }
  /**
   * Retrieves the BodyDecl list.
   * @return The node representing the BodyDecl list.
   * @apilevel high-level
   */
  public List<BodyDecl> getBodyDecls() {
    return getBodyDeclList();
  }
  /**
   * Retrieves the BodyDecl list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the BodyDecl list.
   * @apilevel low-level
   */
  public List<BodyDecl> getBodyDeclsNoTransform() {
    return getBodyDeclListNoTransform();
  }
  /**
   * @aspect GenericsTypeCheck
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Generics.jrag:373
   */
    public void typeCheck() {
    refined_TypeHierarchyCheck_TypeDecl_typeCheck();
    ArrayList list = new ArrayList();
    list.addAll(implementedInterfaces());
    for(int i = 0; i < list.size(); i++) {
      InterfaceDecl decl = (InterfaceDecl)list.get(i);
      if(decl instanceof ParInterfaceDecl) {
        ParInterfaceDecl p = (ParInterfaceDecl)decl;
        for(Iterator i2 = list.listIterator(i); i2.hasNext(); ) {
          InterfaceDecl decl2 = (InterfaceDecl)i2.next();
          if(decl2 instanceof ParInterfaceDecl) {
            ParInterfaceDecl q = (ParInterfaceDecl)decl2;
            if(p != q && p.genericDecl() == q.genericDecl() && !p.sameArgument(q))
              error(p.genericDecl().name() + " cannot be inherited with different arguments: " +
                p.typeName() + " and " + q.typeName());
          }
        }
      }
    }
  }
  /**
   * @aspect TypeCheck
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/GenericMethods.jrag:125
   */
    protected void checkAbstractMethodDecls(MethodDecl m1, MethodDecl m2) {

    if (!m1.sameSignature(m2)) {
      error("method declarations " + m1.fullSignature() + " and " +
          m2.fullSignature() + " in interface " + fullName() +
          " are incompatible");
    } else {
      refined_TypeHierarchyCheck_TypeDecl_checkAbstractMethodDecls(m1, m2);
    }
  }
  /**
   * @aspect TypeConversion
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:59
   */
  private boolean refined_TypeConversion_TypeDecl_assignConversionTo_TypeDecl_Expr(TypeDecl type, Expr expr)
{
    //System.out.println("@@@ " + fullName() + " assign conversion to " + type.fullName() + ", expr: " + expr);
    boolean sourceIsConstant = expr != null ? expr.isConstant() : false;
    //System.out.println("@@@ sourceIsConstant: " + sourceIsConstant);
    if(identityConversionTo(type) || wideningConversionTo(type))
      return true;
    //System.out.println("@@@ narrowing conversion needed");
    //System.out.println("@@@ value: " + expr.value());
    if(sourceIsConstant && (isInt() || isChar() || isShort() || isByte()) &&
        (type.isByte() || type.isShort() || type.isChar()) &&
        narrowingConversionTo(type) && expr.representableIn(type))
      return true;
    //System.out.println("@@@ false");
    return false;
  }
  /**
   * @aspect TypeConversion
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:76
   */
  private boolean refined_TypeConversion_TypeDecl_methodInvocationConversionTo_TypeDecl(TypeDecl type)
{
    return identityConversionTo(type) || wideningConversionTo(type);
  }
  /**
   * @aspect TypeConversion
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:81
   */
  private boolean refined_TypeConversion_TypeDecl_castingConversionTo_TypeDecl(TypeDecl type)
{ return identityConversionTo(type) ||
    wideningConversionTo(type) || narrowingConversionTo(type); }
  /**
   * @aspect <NoAspect>
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:19
   */
    private boolean collect_contributors_CFGNode_collPred = false;
  protected void collect_contributors_CFGNode_collPred() {
    if(collect_contributors_CFGNode_collPred) return;
    super.collect_contributors_CFGNode_collPred();
    collect_contributors_CFGNode_collPred = true;
  }

  /**
   * @aspect <NoAspect>
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/JavaLiveness1.4.jrag:17
   */
    private boolean collect_contributors_CFGNode_coll_liveness_out = false;

  public boolean collecting_contributors_CFGNode_coll_liveness_out = false;

  protected void collect_contributors_CFGNode_coll_liveness_out() {
    if (!collect_contributors_CFGNode_coll_liveness_out) {
      collecting_contributors_CFGNode_coll_liveness_out = true;
      super.collect_contributors_CFGNode_coll_liveness_out();
      collecting_contributors_CFGNode_coll_liveness_out = false;
      collect_contributors_CFGNode_coll_liveness_out = true;
    }
  }

  protected java.util.Map accessibleFromPackage_String_values;
  /**
   * @attribute syn
   * @aspect AccessControl
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/AccessControl.jrag:15
   */
  public boolean accessibleFromPackage(String packageName) {
    Object _parameters = packageName;
    if (accessibleFromPackage_String_values == null) accessibleFromPackage_String_values = new org.jastadd.util.RobustMap(new java.util.HashMap());
    if(accessibleFromPackage_String_values.containsKey(_parameters)) {
      return ((Boolean)accessibleFromPackage_String_values.get(_parameters)).booleanValue();
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    boolean accessibleFromPackage_String_value = accessibleFromPackage_compute(packageName);
    if (isFinal && num == state().boundariesCrossed) {
      accessibleFromPackage_String_values.put(_parameters, Boolean.valueOf(accessibleFromPackage_String_value));
    } else {
    }

    return accessibleFromPackage_String_value;
  }
  /**
   * @apilevel internal
   */
  private boolean accessibleFromPackage_compute(String packageName) {  return !isPrivate() && (isPublic() || hostPackage().equals(packageName));  }
  protected java.util.Map accessibleFromExtend_TypeDecl_values;
  /**
   * @attribute syn
   * @aspect AccessControl
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/AccessControl.jrag:18
   */
  public boolean accessibleFromExtend(TypeDecl type) {
    Object _parameters = type;
    if (accessibleFromExtend_TypeDecl_values == null) accessibleFromExtend_TypeDecl_values = new org.jastadd.util.RobustMap(new java.util.HashMap());
    if(accessibleFromExtend_TypeDecl_values.containsKey(_parameters)) {
      return ((Boolean)accessibleFromExtend_TypeDecl_values.get(_parameters)).booleanValue();
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    boolean accessibleFromExtend_TypeDecl_value = accessibleFromExtend_compute(type);
    if (isFinal && num == state().boundariesCrossed) {
      accessibleFromExtend_TypeDecl_values.put(_parameters, Boolean.valueOf(accessibleFromExtend_TypeDecl_value));
    } else {
    }

    return accessibleFromExtend_TypeDecl_value;
  }
  /**
   * @apilevel internal
   */
  private boolean accessibleFromExtend_compute(TypeDecl type) {
      if(type == this)
        return true;
      if(isInnerType()) {
        if(!enclosingType().accessibleFrom(type)) {
          return false;
        }
      }
      if(isPublic())
        return true;
      else if(isProtected()) {
        // isProtected implies a nested type
        if(hostPackage().equals(type.hostPackage())) {
          return true;
        }
        if(type.isNestedType() && type.enclosingType().withinBodyThatSubclasses(enclosingType()) != null)
          return true;
        return false;
      }
      else if(isPrivate()) {
        return topLevelType() == type.topLevelType();
      }
      else
        return hostPackage().equals(type.hostPackage());
    }
  protected java.util.Map accessibleFrom_TypeDecl_values;
  /**
   * @attribute syn
   * @aspect AccessControl
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/AccessControl.jrag:44
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
      if(type == this)
        return true;
      if(isInnerType()) {
        if(!enclosingType().accessibleFrom(type)) {
          return false;
        }
      }
      if(isPublic()) {
        return true;
      }
      else if(isProtected()) {
        if(hostPackage().equals(type.hostPackage())) {
          return true;
        }
        if(isMemberType()) {
          TypeDecl typeDecl = type;
          while(typeDecl != null && !typeDecl.instanceOf(enclosingType()))
            typeDecl = typeDecl.enclosingType();
          if(typeDecl != null) {
            return true;
          }
        }
        return false;
      }
      else if(isPrivate()) {
        return topLevelType() == type.topLevelType();
      }
      else {
        return hostPackage().equals(type.hostPackage());
      }
    }
  /**
   * @apilevel internal
   */
  protected boolean dimension_computed = false;
  /**
   * @apilevel internal
   */
  protected int dimension_value;
  /**
   * @attribute syn
   * @aspect Arrays
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Arrays.jrag:11
   */
  public int dimension() {
    if(dimension_computed) {
      return dimension_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    dimension_value = dimension_compute();
    if (isFinal && num == state().boundariesCrossed) {
      dimension_computed = true;
    } else {
    }

    return dimension_value;
  }
  /**
   * @apilevel internal
   */
  private int dimension_compute() {  return 0;  }
  /**
   * @apilevel internal
   */
  protected boolean elementType_computed = false;
  /**
   * @apilevel internal
   */
  protected TypeDecl elementType_value;
  /**
   * @attribute syn
   * @aspect Arrays
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Arrays.jrag:15
   */
  public TypeDecl elementType() {
    if(elementType_computed) {
      return elementType_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    elementType_value = elementType_compute();
    if (isFinal && num == state().boundariesCrossed) {
      elementType_computed = true;
    } else {
    }

    return elementType_value;
  }
  /**
   * @apilevel internal
   */
  private TypeDecl elementType_compute() {  return this;  }
  /**
   * @apilevel internal
   */
  protected boolean arrayType_computed = false;
  /**
   * @apilevel internal
   */
  protected TypeDecl arrayType_value;
  /**
   * @attribute syn
   * @aspect GenericsArrays
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/GenericsArrays.jrag:11
   */
  public TypeDecl arrayType() {
    if(arrayType_computed) {
      return arrayType_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    arrayType_value = arrayType_compute();
    arrayType_value.setParent(this);
    arrayType_value.is$Final = true;
    if (true) {
      arrayType_computed = true;
    } else {
    }

    return arrayType_value;
  }
  /**
   * @apilevel internal
   */
  private TypeDecl arrayType_compute() {
      String name = name() + "[]";
  
      List body = new List();
      body.add(
        new FieldDeclaration(
          new Modifiers(new List().add(new Modifier("public")).add(new Modifier("final"))),
          new PrimitiveTypeAccess("int"),
          "length",
          new Opt() // [Init:Expr]
        )
      );
      MethodDecl clone = null;
      TypeDecl typeObject = typeObject();
      for(int i = 0; clone == null && i < typeObject.getNumBodyDecl(); i++) {
        if(typeObject.getBodyDecl(i) instanceof MethodDecl) {
          MethodDecl m = (MethodDecl)typeObject.getBodyDecl(i);
          if(m.name().equals("clone"))
            clone = m;
        }
      }
      if(clone != null) {
        body.add(
            // we create a substituted method that substitutes the clone method in object
            // this has the following two consequences: the return value will be cast to the
            // expected return type rather than object, and the invoked method will be the
            // method in object rather in the array
            new MethodDeclSubstituted(
              new Modifiers(new List().add(new Modifier("public"))),
              new ArrayTypeAccess(createQualifiedAccess()),
              "clone",
              new List(),
              new List(),
              new Opt(new Block()),
              (MethodDecl)typeObject().memberMethods("clone").iterator().next()
            )
        );
      }
      TypeDecl typeDecl =
        new ArrayDecl(
          new Modifiers(new List().add(new Modifier("public"))),
          name,
          new Opt(typeObject().createQualifiedAccess()), // [SuperClass]
          new List().add(typeCloneable().createQualifiedAccess()).add(typeSerializable().createQualifiedAccess()), // Implements*
          body // BodyDecl*
        );
      return typeDecl;
    }
  /**
   * @attribute syn
   * @aspect ConstantExpression
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ConstantExpression.jrag:51
   */
  public Constant cast(Constant c) {
    ASTNode$State state = state();
    try {
        throw new UnsupportedOperationException("ConstantExpression operation cast" +
          " not supported for type " + getClass().getName());
      }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect ConstantExpression
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ConstantExpression.jrag:65
   */
  public Constant plus(Constant c) {
    ASTNode$State state = state();
    try {
        throw new UnsupportedOperationException("ConstantExpression operation plus" +
          " not supported for type " + getClass().getName());
      }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect ConstantExpression
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ConstantExpression.jrag:74
   */
  public Constant minus(Constant c) {
    ASTNode$State state = state();
    try {
        throw new UnsupportedOperationException("ConstantExpression operation minus" +
          " not supported for type " + getClass().getName());
      }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect ConstantExpression
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ConstantExpression.jrag:83
   */
  public Constant bitNot(Constant c) {
    ASTNode$State state = state();
    try {
        throw new UnsupportedOperationException("ConstantExpression operation bitNot" +
          " not supported for type " + getClass().getName());
      }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect ConstantExpression
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ConstantExpression.jrag:90
   */
  public Constant mul(Constant c1, Constant c2) {
    ASTNode$State state = state();
    try {
        throw new UnsupportedOperationException("ConstantExpression operation mul" +
          " not supported for type " + getClass().getName());
      }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect ConstantExpression
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ConstantExpression.jrag:99
   */
  public Constant div(Constant c1, Constant c2) {
    ASTNode$State state = state();
    try {
        throw new UnsupportedOperationException("ConstantExpression operation div" +
          " not supported for type " + getClass().getName());
      }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect ConstantExpression
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ConstantExpression.jrag:108
   */
  public Constant mod(Constant c1, Constant c2) {
    ASTNode$State state = state();
    try {
        throw new UnsupportedOperationException("ConstantExpression operation mod" +
          " not supported for type " + getClass().getName());
      }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect ConstantExpression
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ConstantExpression.jrag:117
   */
  public Constant add(Constant c1, Constant c2) {
    ASTNode$State state = state();
    try {
        throw new UnsupportedOperationException("ConstantExpression operation add" +
          " not supported for type " + getClass().getName());
      }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect ConstantExpression
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ConstantExpression.jrag:127
   */
  public Constant sub(Constant c1, Constant c2) {
    ASTNode$State state = state();
    try {
        throw new UnsupportedOperationException("ConstantExpression operation sub" +
          " not supported for type " + getClass().getName());
      }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect ConstantExpression
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ConstantExpression.jrag:136
   */
  public Constant lshift(Constant c1, Constant c2) {
    ASTNode$State state = state();
    try {
        throw new UnsupportedOperationException("ConstantExpression operation lshift" +
          " not supported for type " + getClass().getName());
      }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect ConstantExpression
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ConstantExpression.jrag:143
   */
  public Constant rshift(Constant c1, Constant c2) {
    ASTNode$State state = state();
    try {
        throw new UnsupportedOperationException("ConstantExpression operation rshift" +
          " not supported for type " + getClass().getName());
      }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect ConstantExpression
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ConstantExpression.jrag:150
   */
  public Constant urshift(Constant c1, Constant c2) {
    ASTNode$State state = state();
    try {
        throw new UnsupportedOperationException("ConstantExpression operation urshift" +
          " not supported for type " + getClass().getName());
      }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect ConstantExpression
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ConstantExpression.jrag:157
   */
  public Constant andBitwise(Constant c1, Constant c2) {
    ASTNode$State state = state();
    try {
        throw new UnsupportedOperationException("ConstantExpression operation andBitwise" +
          " not supported for type " + getClass().getName());
      }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect ConstantExpression
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ConstantExpression.jrag:165
   */
  public Constant xorBitwise(Constant c1, Constant c2) {
    ASTNode$State state = state();
    try {
        throw new UnsupportedOperationException("ConstantExpression operation xorBitwise" +
          " not supported for type " + getClass().getName());
      }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect ConstantExpression
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ConstantExpression.jrag:173
   */
  public Constant orBitwise(Constant c1, Constant c2) {
    ASTNode$State state = state();
    try {
        throw new UnsupportedOperationException("ConstantExpression operation orBitwise" +
          " not supported for type " + getClass().getName());
      }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect ConstantExpression
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ConstantExpression.jrag:181
   */
  public Constant questionColon(Constant cond, Constant c1, Constant c2) {
    ASTNode$State state = state();
    try {
        throw new UnsupportedOperationException("ConstantExpression operation questionColon" +
          " not supported for type " + getClass().getName());
      }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect ConstantExpression
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ConstantExpression.jrag:295
   */
  public boolean eqIsTrue(Expr left, Expr right) {
    ASTNode$State state = state();
    try {
        System.err.println("Evaluation eqIsTrue for unknown type: " + getClass().getName());
        return false;
      }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect ConstantExpression
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ConstantExpression.jrag:306
   */
  public boolean ltIsTrue(Expr left, Expr right) {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect ConstantExpression
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ConstantExpression.jrag:312
   */
  public boolean leIsTrue(Expr left, Expr right) {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect DataStructures
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DataStructures.jrag:133
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
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DataStructures.jrag:134
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
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DataStructures.jrag:138
   */
  public boolean contains(Object o) {
    ASTNode$State state = state();
    try {  return this == o;  }
    finally {
    }
  }
  /**
   * @apilevel internal
   */
  protected boolean isException_computed = false;
  /**
   * @apilevel internal
   */
  protected boolean isException_value;
  /**
   * @attribute syn
   * @aspect ExceptionHandling
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ExceptionHandling.jrag:30
   */
  public boolean isException() {
    if(isException_computed) {
      return isException_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    isException_value = isException_compute();
    if (isFinal && num == state().boundariesCrossed) {
      isException_computed = true;
    } else {
    }

    return isException_value;
  }
  /**
   * @apilevel internal
   */
  private boolean isException_compute() {  return instanceOf(typeException());  }
  /**
   * @apilevel internal
   */
  protected boolean isCheckedException_computed = false;
  /**
   * @apilevel internal
   */
  protected boolean isCheckedException_value;
  /**
   * Unfortunately the concept of checked vs. unchecked exceptions
   * has been inverted in JastAddJ compared to the Java specification.
   * This is a slightly unfortunate design flaw which we cannot change
   * at this time.
   * @attribute syn
   * @aspect ExceptionHandling
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ExceptionHandling.jrag:38
   */
  public boolean isCheckedException() {
    if(isCheckedException_computed) {
      return isCheckedException_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    isCheckedException_value = isCheckedException_compute();
    if (isFinal && num == state().boundariesCrossed) {
      isCheckedException_computed = true;
    } else {
    }

    return isCheckedException_value;
  }
  /**
   * @apilevel internal
   */
  private boolean isCheckedException_compute() {  return isException() &&
      (instanceOf(typeRuntimeException()) || instanceOf(typeError()));  }
  /**
   * @apilevel internal
   */
  protected boolean isUncheckedException_computed = false;
  /**
   * @apilevel internal
   */
  protected boolean isUncheckedException_value;
  /**
   * Unfortunately the concept of checked vs. unchecked exceptions
   * has been inverted in JastAddJ compared to the Java specification.
   * This is a slightly unfortunate design flaw which we cannot change
   * at this time.
   * @attribute syn
   * @aspect ExceptionHandling
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ExceptionHandling.jrag:47
   */
  public boolean isUncheckedException() {
    if(isUncheckedException_computed) {
      return isUncheckedException_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    isUncheckedException_value = isUncheckedException_compute();
    if (isFinal && num == state().boundariesCrossed) {
      isUncheckedException_computed = true;
    } else {
    }

    return isUncheckedException_value;
  }
  /**
   * @apilevel internal
   */
  private boolean isUncheckedException_compute() {  return isException() && !isCheckedException();  }
  protected java.util.Map mayCatch_TypeDecl_values;
  /**
   * @attribute syn
   * @aspect ExceptionHandling
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ExceptionHandling.jrag:251
   */
  public boolean mayCatch(TypeDecl thrownType) {
    Object _parameters = thrownType;
    if (mayCatch_TypeDecl_values == null) mayCatch_TypeDecl_values = new org.jastadd.util.RobustMap(new java.util.HashMap());
    if(mayCatch_TypeDecl_values.containsKey(_parameters)) {
      return ((Boolean)mayCatch_TypeDecl_values.get(_parameters)).booleanValue();
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    boolean mayCatch_TypeDecl_value = mayCatch_compute(thrownType);
    if (isFinal && num == state().boundariesCrossed) {
      mayCatch_TypeDecl_values.put(_parameters, Boolean.valueOf(mayCatch_TypeDecl_value));
    } else {
    }

    return mayCatch_TypeDecl_value;
  }
  /**
   * @apilevel internal
   */
  private boolean mayCatch_compute(TypeDecl thrownType) {  return thrownType.instanceOf(this) || this.instanceOf(thrownType);  }
  /**
   * @attribute syn
   * @aspect ConstructScope
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupConstructor.jrag:21
   */
  public Collection lookupSuperConstructor() {
    ASTNode$State state = state();
    try {  return Collections.EMPTY_LIST;  }
    finally {
    }
  }
  /**
   * @apilevel internal
   */
  protected boolean constructors_computed = false;
  /**
   * @apilevel internal
   */
  protected Collection<ConstructorDecl> constructors_value;
  /**
   * @attribute syn
   * @aspect ConstructorLookup
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupConstructor.jrag:103
   */
  public Collection<ConstructorDecl> constructors() {
    if(constructors_computed) {
      return constructors_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    constructors_value = constructors_compute();
    if (isFinal && num == state().boundariesCrossed) {
      constructors_computed = true;
    } else {
    }

    return constructors_value;
  }
  /**
   * @apilevel internal
   */
  private Collection<ConstructorDecl> constructors_compute() {
      Collection<ConstructorDecl> c = new ArrayList();
      for (int i = 0; i < getNumBodyDecl(); i++) {
        if (getBodyDecl(i) instanceof ConstructorDecl) {
          c.add((ConstructorDecl) getBodyDecl(i));
        }
      }
      return c;
    }
  protected java.util.Map unqualifiedLookupMethod_String_values;
  /**
   * @attribute syn
   * @aspect LookupMethod
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupMethod.jrag:56
   */
  public Collection unqualifiedLookupMethod(String name) {
    Object _parameters = name;
    if (unqualifiedLookupMethod_String_values == null) unqualifiedLookupMethod_String_values = new org.jastadd.util.RobustMap(new java.util.HashMap());
    if(unqualifiedLookupMethod_String_values.containsKey(_parameters)) {
      return (Collection)unqualifiedLookupMethod_String_values.get(_parameters);
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    Collection unqualifiedLookupMethod_String_value = unqualifiedLookupMethod_compute(name);
    if (isFinal && num == state().boundariesCrossed) {
      unqualifiedLookupMethod_String_values.put(_parameters, unqualifiedLookupMethod_String_value);
    } else {
    }

    return unqualifiedLookupMethod_String_value;
  }
  /**
   * @apilevel internal
   */
  private Collection unqualifiedLookupMethod_compute(String name) {
      Collection c = memberMethods(name);
      if(!c.isEmpty()) return c;
      if(isInnerType())
        return lookupMethod(name);
      return removeInstanceMethods(lookupMethod(name));
    }
  /**
   * @attribute syn
   * @aspect MemberMethods
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupMethod.jrag:255
   */
  public Collection<MethodDecl> memberMethods(String name) {
    ASTNode$State state = state();
    try {
        Collection<MethodDecl> c = methodsNameMap().get(name);
        if (c != null) {
          return c;
        } else {
          return Collections.emptyList();
        }
      }
    finally {
    }
  }
  /**
   * @apilevel internal
   */
  protected boolean methodsNameMap_computed = false;
  /**
   * @apilevel internal
   */
  protected Map<String,Collection<MethodDecl>> methodsNameMap_value;
  /**
   * @return map from method name to method declarations
   * @attribute syn
   * @aspect MemberMethods
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupMethod.jrag:266
   */
  public Map<String,Collection<MethodDecl>> methodsNameMap() {
    if(methodsNameMap_computed) {
      return methodsNameMap_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    methodsNameMap_value = methodsNameMap_compute();
    if (isFinal && num == state().boundariesCrossed) {
      methodsNameMap_computed = true;
    } else {
    }

    return methodsNameMap_value;
  }
  /**
   * @apilevel internal
   */
  private Map<String,Collection<MethodDecl>> methodsNameMap_compute() {
      Map<String,Collection<MethodDecl>> map =
        new HashMap<String,Collection<MethodDecl>>();
      for (Iterator<MethodDecl> iter = methodsIterator(); iter.hasNext(); ) {
        MethodDecl m = iter.next();
        Collection<MethodDecl> methods = map.get(m.name());
        if (methods == null) {
          methods = new ArrayList<MethodDecl>(4);
          map.put(m.name(), methods);
        }
        methods.add(m);
      }
      return map;
    }
  /**
   * @attribute syn
   * @aspect MemberMethods
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupMethod.jrag:302
   */
  public SimpleSet localMethodsSignature(String signature) {
    ASTNode$State state = state();
    try {
        SimpleSet set = localMethodsSignatureMap().get(signature);
        if (set != null) {
          return set;
        }
        return SimpleSet.emptySet;
      }
    finally {
    }
  }
  /**
   * @apilevel internal
   */
  protected boolean localMethodsSignatureMap_computed = false;
  /**
   * @apilevel internal
   */
  protected Map<String,SimpleSet> localMethodsSignatureMap_value;
  /**
   * @return a mapping of method signature to method declaration
   * @attribute syn
   * @aspect MemberMethods
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupMethod.jrag:313
   */
  public Map<String,SimpleSet> localMethodsSignatureMap() {
    if(localMethodsSignatureMap_computed) {
      return localMethodsSignatureMap_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    localMethodsSignatureMap_value = localMethodsSignatureMap_compute();
    if (isFinal && num == state().boundariesCrossed) {
      localMethodsSignatureMap_computed = true;
    } else {
    }

    return localMethodsSignatureMap_value;
  }
  /**
   * @apilevel internal
   */
  private Map<String,SimpleSet> localMethodsSignatureMap_compute() {
      Map<String,SimpleSet> map = new HashMap<String,SimpleSet>(getNumBodyDecl());
      for (int i = 0; i < getNumBodyDecl(); i++) {
        if (getBodyDecl(i) instanceof MethodDecl) {
          MethodDecl decl = (MethodDecl) getBodyDecl(i);
          map.put(decl.signature(), decl);
        }
      }
      return map;
    }
  /**
   * @attribute syn
   * @aspect MemberMethods
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupMethod.jrag:387
   */
  public SimpleSet methodsSignature(String signature) {
    ASTNode$State state = state();
    try {
        SimpleSet set = (SimpleSet)methodsSignatureMap().get(signature);
        if(set != null) return set;
        return SimpleSet.emptySet;
      }
    finally {
    }
  }
  /**
   * @apilevel internal
   */
  protected boolean methodsSignatureMap_computed = false;
  /**
   * @apilevel internal
   */
  protected Map<String,SimpleSet> methodsSignatureMap_value;
  /**
   * @attribute syn
   * @aspect MemberMethods
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupMethod.jrag:394
   */
  public Map<String,SimpleSet> methodsSignatureMap() {
    if(methodsSignatureMap_computed) {
      return methodsSignatureMap_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    methodsSignatureMap_value = methodsSignatureMap_compute();
    if (isFinal && num == state().boundariesCrossed) {
      methodsSignatureMap_computed = true;
    } else {
    }

    return methodsSignatureMap_value;
  }
  /**
   * @apilevel internal
   */
  private Map<String,SimpleSet> methodsSignatureMap_compute() {  return localMethodsSignatureMap();  }
  protected java.util.Map ancestorMethods_String_values;
  /**
   * @attribute syn
   * @aspect AncestorMethods
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupMethod.jrag:469
   */
  public SimpleSet ancestorMethods(String signature) {
    Object _parameters = signature;
    if (ancestorMethods_String_values == null) ancestorMethods_String_values = new org.jastadd.util.RobustMap(new java.util.HashMap());
    if(ancestorMethods_String_values.containsKey(_parameters)) {
      return (SimpleSet)ancestorMethods_String_values.get(_parameters);
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    SimpleSet ancestorMethods_String_value = ancestorMethods_compute(signature);
    if (isFinal && num == state().boundariesCrossed) {
      ancestorMethods_String_values.put(_parameters, ancestorMethods_String_value);
    } else {
    }

    return ancestorMethods_String_value;
  }
  /**
   * @apilevel internal
   */
  private SimpleSet ancestorMethods_compute(String signature) {  return SimpleSet.emptySet;  }
  /**
   * @attribute syn
   * @aspect TypeScopePropagation
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:330
   */
  public SimpleSet localLookupType(String name) {
    ASTNode$State state = state();
    try {
        SimpleSet c = memberTypes(name);
        if(!c.isEmpty())
          return c;
        if(name().equals(name))
          return SimpleSet.emptySet.add(this);
    
        c = lookupType(name);
        // 8.5.2
        if(isClassDecl() && isStatic() && !isTopLevelType()) {
          SimpleSet newSet = SimpleSet.emptySet;
          for(Iterator iter = c.iterator(); iter.hasNext(); ) {
            TypeDecl d = (TypeDecl)iter.next();
            //if(d.isStatic() || d.isTopLevelType() || this.instanceOf(d.enclosingType())) {
              newSet = newSet.add(d);
            //}
          }
          c = newSet;
        }
        return c;
      }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect TypeScopePropagation
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:450
   */
  public boolean hasType(String name) {
    ASTNode$State state = state();
    try {  return !memberTypes(name).isEmpty();  }
    finally {
    }
  }
  protected java.util.Map localTypeDecls_String_values;
  /**
   * @attribute syn
   * @aspect TypeScopePropagation
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:461
   */
  public SimpleSet localTypeDecls(String name) {
    Object _parameters = name;
    if (localTypeDecls_String_values == null) localTypeDecls_String_values = new org.jastadd.util.RobustMap(new java.util.HashMap());
    if(localTypeDecls_String_values.containsKey(_parameters)) {
      return (SimpleSet)localTypeDecls_String_values.get(_parameters);
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    SimpleSet localTypeDecls_String_value = localTypeDecls_compute(name);
    if (isFinal && num == state().boundariesCrossed) {
      localTypeDecls_String_values.put(_parameters, localTypeDecls_String_value);
    } else {
    }

    return localTypeDecls_String_value;
  }
  /**
   * @apilevel internal
   */
  private SimpleSet localTypeDecls_compute(String name) {
      SimpleSet set = SimpleSet.emptySet;
      for(int i = 0; i < getNumBodyDecl(); i++)
        if(getBodyDecl(i).declaresType(name))
          set = set.add(getBodyDecl(i).type(name));
      return set;
    }
  protected java.util.Map memberTypes_String_values;
  /**
   * @attribute syn
   * @aspect TypeScopePropagation
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:469
   */
  public SimpleSet memberTypes(String name) {
    Object _parameters = name;
    if (memberTypes_String_values == null) memberTypes_String_values = new org.jastadd.util.RobustMap(new java.util.HashMap());
    if(memberTypes_String_values.containsKey(_parameters)) {
      return (SimpleSet)memberTypes_String_values.get(_parameters);
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    SimpleSet memberTypes_String_value = memberTypes_compute(name);
    if (isFinal && num == state().boundariesCrossed) {
      memberTypes_String_values.put(_parameters, memberTypes_String_value);
    } else {
    }

    return memberTypes_String_value;
  }
  /**
   * @apilevel internal
   */
  private SimpleSet memberTypes_compute(String name) {  return SimpleSet.emptySet;  }
  protected java.util.Map localFields_String_values;
  /**
   * @attribute syn
   * @aspect Fields
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupVariable.jrag:266
   */
  public SimpleSet localFields(String name) {
    Object _parameters = name;
    if (localFields_String_values == null) localFields_String_values = new org.jastadd.util.RobustMap(new java.util.HashMap());
    if(localFields_String_values.containsKey(_parameters)) {
      return (SimpleSet)localFields_String_values.get(_parameters);
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    SimpleSet localFields_String_value = localFields_compute(name);
    if (isFinal && num == state().boundariesCrossed) {
      localFields_String_values.put(_parameters, localFields_String_value);
    } else {
    }

    return localFields_String_value;
  }
  /**
   * @apilevel internal
   */
  private SimpleSet localFields_compute(String name) {  return localFieldsMap().containsKey(name) ? (SimpleSet)localFieldsMap().get(name) : SimpleSet.emptySet;  }
  /**
   * @apilevel internal
   */
  protected boolean localFieldsMap_computed = false;
  /**
   * @apilevel internal
   */
  protected HashMap localFieldsMap_value;
  /**
   * @attribute syn
   * @aspect Fields
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupVariable.jrag:269
   */
  public HashMap localFieldsMap() {
    if(localFieldsMap_computed) {
      return localFieldsMap_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    localFieldsMap_value = localFieldsMap_compute();
    if (isFinal && num == state().boundariesCrossed) {
      localFieldsMap_computed = true;
    } else {
    }

    return localFieldsMap_value;
  }
  /**
   * @apilevel internal
   */
  private HashMap localFieldsMap_compute() {
      HashMap map = new HashMap();
      for(int i = 0; i < getNumBodyDecl(); i++) {
        if(getBodyDecl(i) instanceof FieldDeclaration) {
          FieldDeclaration decl = (FieldDeclaration)getBodyDecl(i);
          SimpleSet fields = (SimpleSet)map.get(decl.name());
          if(fields == null) fields = SimpleSet.emptySet;
          fields = fields.add(decl);
          map.put(decl.name(), fields);
        }
      }
      return map;
    }
  /**
   * @apilevel internal
   */
  protected boolean memberFieldsMap_computed = false;
  /**
   * @apilevel internal
   */
  protected HashMap memberFieldsMap_value;
  /**
   * @attribute syn
   * @aspect Fields
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupVariable.jrag:282
   */
  public HashMap memberFieldsMap() {
    if(memberFieldsMap_computed) {
      return memberFieldsMap_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    memberFieldsMap_value = memberFieldsMap_compute();
    if (isFinal && num == state().boundariesCrossed) {
      memberFieldsMap_computed = true;
    } else {
    }

    return memberFieldsMap_value;
  }
  /**
   * @apilevel internal
   */
  private HashMap memberFieldsMap_compute() {  return localFieldsMap();  }
  protected java.util.Map memberFields_String_values;
  /**
   * @attribute syn
   * @aspect Fields
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupVariable.jrag:331
   */
  public SimpleSet memberFields(String name) {
    Object _parameters = name;
    if (memberFields_String_values == null) memberFields_String_values = new org.jastadd.util.RobustMap(new java.util.HashMap());
    if(memberFields_String_values.containsKey(_parameters)) {
      return (SimpleSet)memberFields_String_values.get(_parameters);
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    SimpleSet memberFields_String_value = memberFields_compute(name);
    if (isFinal && num == state().boundariesCrossed) {
      memberFields_String_values.put(_parameters, memberFields_String_value);
    } else {
    }

    return memberFields_String_value;
  }
  /**
   * @apilevel internal
   */
  private SimpleSet memberFields_compute(String name) {  return localFields(name);  }
  /**
   * @apilevel internal
   */
  protected boolean hasAbstract_computed = false;
  /**
   * @apilevel internal
   */
  protected boolean hasAbstract_value;
  /**
   * @attribute syn
   * @aspect Modifiers
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:14
   */
  public boolean hasAbstract() {
    if(hasAbstract_computed) {
      return hasAbstract_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    hasAbstract_value = hasAbstract_compute();
    if (isFinal && num == state().boundariesCrossed) {
      hasAbstract_computed = true;
    } else {
    }

    return hasAbstract_value;
  }
  /**
   * @apilevel internal
   */
  private boolean hasAbstract_compute() {  return false;  }
  /**
   * @apilevel internal
   */
  protected boolean unimplementedMethods_computed = false;
  /**
   * @apilevel internal
   */
  protected Collection unimplementedMethods_value;
  /**
   * @attribute syn
   * @aspect Modifiers
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:16
   */
  public Collection unimplementedMethods() {
    if(unimplementedMethods_computed) {
      return unimplementedMethods_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    unimplementedMethods_value = unimplementedMethods_compute();
    if (isFinal && num == state().boundariesCrossed) {
      unimplementedMethods_computed = true;
    } else {
    }

    return unimplementedMethods_value;
  }
  /**
   * @apilevel internal
   */
  private Collection unimplementedMethods_compute() {  return Collections.EMPTY_LIST;  }
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
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:200
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
  private boolean isPublic_compute() {  return getModifiers().isPublic() || isMemberType() && enclosingType().isInterfaceDecl();  }
  /**
   * @attribute syn
   * @aspect Modifiers
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:202
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
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:203
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
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:204
   */
  public boolean isAbstract() {
    ASTNode$State state = state();
    try {  return getModifiers().isAbstract();  }
    finally {
    }
  }
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
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:206
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
  private boolean isStatic_compute() {  return getModifiers().isStatic() || isMemberType() && enclosingType().isInterfaceDecl();  }
  /**
   * @attribute syn
   * @aspect Modifiers
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:209
   */
  public boolean isFinal() {
    ASTNode$State state = state();
    try {  return getModifiers().isFinal();  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect Modifiers
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:210
   */
  public boolean isStrictfp() {
    ASTNode$State state = state();
    try {  return getModifiers().isStrictfp();  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect Modifiers
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:212
   */
  public boolean isSynthetic() {
    ASTNode$State state = state();
    try {  return getModifiers().isSynthetic();  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect NameCheck
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/NameCheck.jrag:300
   */
  public boolean hasEnclosingTypeDecl(String name) {
    ASTNode$State state = state();
    try {
        TypeDecl enclosingType = enclosingType();
        if(enclosingType != null) {
          return enclosingType.name().equals(name) || enclosingType.hasEnclosingTypeDecl(name);
        }
        return false;
      }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect NameCheck
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/NameCheck.jrag:456
   */
  public boolean assignableToInt() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect PrettyPrint
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/PrettyPrint.jadd:777
   */
  public boolean addsIndentationLevel() {
    ASTNode$State state = state();
    try {  return true;  }
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
   * @aspect TypeName
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/QualifiedNames.jrag:69
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
  protected boolean fullName_computed = false;
  /**
   * @apilevel internal
   */
  protected String fullName_value;
  /**
   * @attribute syn
   * @aspect TypeName
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/QualifiedNames.jrag:71
   */
  public String fullName() {
    if(fullName_computed) {
      return fullName_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    fullName_value = fullName_compute();
    if (isFinal && num == state().boundariesCrossed) {
      fullName_computed = true;
    } else {
    }

    return fullName_value;
  }
  /**
   * @apilevel internal
   */
  private String fullName_compute() {
      if(isNestedType())
        return enclosingType().fullName() + "." + name();
      String packageName = packageName();
      if(packageName.equals(""))
        return name();
      return packageName + "." + name();
    }
  /**
   * @apilevel internal
   */
  protected boolean typeName_computed = false;
  /**
   * @apilevel internal
   */
  protected String typeName_value;
  /**
   * @attribute syn
   * @aspect TypeName
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/QualifiedNames.jrag:80
   */
  public String typeName() {
    if(typeName_computed) {
      return typeName_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    typeName_value = typeName_compute();
    if (isFinal && num == state().boundariesCrossed) {
      typeName_computed = true;
    } else {
    }

    return typeName_value;
  }
  /**
   * @apilevel internal
   */
  private String typeName_compute() {
      if(isNestedType())
        return enclosingType().typeName() + "." + name();
      String packageName = packageName();
      if(packageName.equals("") || packageName.equals(PRIMITIVE_PACKAGE_NAME))
        return name();
      return packageName + "." + name();
    }
  /**
   * @attribute syn
   * @aspect TypeConversion
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:15
   */
  public boolean identityConversionTo(TypeDecl type) {
    ASTNode$State state = state();
    try {  return this == type;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect TypeConversion
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:17
   */
  public boolean wideningConversionTo(TypeDecl type) {
    ASTNode$State state = state();
    try {  return instanceOf(type);  }
    finally {
    }
  }
  protected java.util.Map narrowingConversionTo_TypeDecl_values;
  /**
   * @attribute syn
   * @aspect TypeConversion
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:18
   */
  public boolean narrowingConversionTo(TypeDecl type) {
    Object _parameters = type;
    if (narrowingConversionTo_TypeDecl_values == null) narrowingConversionTo_TypeDecl_values = new org.jastadd.util.RobustMap(new java.util.HashMap());
    if(narrowingConversionTo_TypeDecl_values.containsKey(_parameters)) {
      return ((Boolean)narrowingConversionTo_TypeDecl_values.get(_parameters)).booleanValue();
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    boolean narrowingConversionTo_TypeDecl_value = narrowingConversionTo_compute(type);
    if (isFinal && num == state().boundariesCrossed) {
      narrowingConversionTo_TypeDecl_values.put(_parameters, Boolean.valueOf(narrowingConversionTo_TypeDecl_value));
    } else {
    }

    return narrowingConversionTo_TypeDecl_value;
  }
  /**
   * @apilevel internal
   */
  private boolean narrowingConversionTo_compute(TypeDecl type) {  return instanceOf(type);  }
  /**
   * @attribute syn
   * @aspect TypeConversion
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:55
   */
  public boolean stringConversion() {
    ASTNode$State state = state();
    try {  return true;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect TypeConversion
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:59
   */
  public boolean assignConversionTo(TypeDecl type, Expr expr) {
    ASTNode$State state = state();
    try {
        if(refined_TypeConversion_TypeDecl_assignConversionTo_TypeDecl_Expr(type, expr))
          return true;
        boolean canBoxThis = this instanceof PrimitiveType;
        boolean canBoxType = type instanceof PrimitiveType;
        boolean canUnboxThis = !unboxed().isUnknown();
        boolean canUnboxType = !type.unboxed().isUnknown();
        TypeDecl t = !canUnboxThis && canUnboxType ? type.unboxed() : type;
        boolean sourceIsConstant = expr != null ? expr.isConstant() : false;
        if(sourceIsConstant && (isInt() || isChar() || isShort() || isByte()) &&
            (t.isByte() || t.isShort() || t.isChar()) &&
            narrowingConversionTo(t) && expr.representableIn(t))
          return true;
        if(canBoxThis && !canBoxType && boxed().wideningConversionTo(type))
          return true;
        else if(canUnboxThis && !canUnboxType && unboxed().wideningConversionTo(type))
          return true;
    
        return false;
      }
    finally {
    }
  }
  protected java.util.Map methodInvocationConversionTo_TypeDecl_values;
  /**
   * @attribute syn
   * @aspect AutoBoxing
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/AutoBoxing.jrag:99
   */
  public boolean methodInvocationConversionTo(TypeDecl type) {
    Object _parameters = type;
    if (methodInvocationConversionTo_TypeDecl_values == null) methodInvocationConversionTo_TypeDecl_values = new org.jastadd.util.RobustMap(new java.util.HashMap());
    if(methodInvocationConversionTo_TypeDecl_values.containsKey(_parameters)) {
      return ((Boolean)methodInvocationConversionTo_TypeDecl_values.get(_parameters)).booleanValue();
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    boolean methodInvocationConversionTo_TypeDecl_value = methodInvocationConversionTo_compute(type);
    if (isFinal && num == state().boundariesCrossed) {
      methodInvocationConversionTo_TypeDecl_values.put(_parameters, Boolean.valueOf(methodInvocationConversionTo_TypeDecl_value));
    } else {
    }

    return methodInvocationConversionTo_TypeDecl_value;
  }
  /**
   * @apilevel internal
   */
  private boolean methodInvocationConversionTo_compute(TypeDecl type) {
      if(refined_TypeConversion_TypeDecl_methodInvocationConversionTo_TypeDecl(type))
        return true;
      boolean canBoxThis = this instanceof PrimitiveType;
      boolean canBoxType = type instanceof PrimitiveType;
      boolean canUnboxThis = !unboxed().isUnknown();
      boolean canUnboxType = !type.unboxed().isUnknown();
      if(canBoxThis && !canBoxType)
        return boxed().wideningConversionTo(type);
      else if(canUnboxThis && !canUnboxType)
        return unboxed().wideningConversionTo(type);
      return false;
    }
  protected java.util.Map castingConversionTo_TypeDecl_values;
  /**
   * @attribute syn
   * @aspect AutoBoxing
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/AutoBoxing.jrag:114
   */
  public boolean castingConversionTo(TypeDecl type) {
    Object _parameters = type;
    if (castingConversionTo_TypeDecl_values == null) castingConversionTo_TypeDecl_values = new org.jastadd.util.RobustMap(new java.util.HashMap());
    if(castingConversionTo_TypeDecl_values.containsKey(_parameters)) {
      return ((Boolean)castingConversionTo_TypeDecl_values.get(_parameters)).booleanValue();
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    boolean castingConversionTo_TypeDecl_value = castingConversionTo_compute(type);
    if (isFinal && num == state().boundariesCrossed) {
      castingConversionTo_TypeDecl_values.put(_parameters, Boolean.valueOf(castingConversionTo_TypeDecl_value));
    } else {
    }

    return castingConversionTo_TypeDecl_value;
  }
  /**
   * @apilevel internal
   */
  private boolean castingConversionTo_compute(TypeDecl type) {
      if(refined_TypeConversion_TypeDecl_castingConversionTo_TypeDecl(type))
        return true;
      boolean canBoxThis = this instanceof PrimitiveType;
      boolean canBoxType = type instanceof PrimitiveType;
      boolean canUnboxThis = !unboxed().isUnknown();
      boolean canUnboxType = !type.unboxed().isUnknown();
      if(canBoxThis && !canBoxType)
        return boxed().wideningConversionTo(type);
      else if(canUnboxThis && !canUnboxType)
        return unboxed().wideningConversionTo(type);
      return false;
      /*
      else if(boxingConversionTo(type))
        return true;
      else if(unboxingConversionTo(type))
        return true;
      return false;
      */
    }
  /**
   * @attribute syn
   * @aspect NumericPromotion
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:146
   */
  public TypeDecl unaryNumericPromotion() {
    ASTNode$State state = state();
    try {  return this;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect NumericPromotion
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:154
   */
  public TypeDecl binaryNumericPromotion(TypeDecl type) {
    ASTNode$State state = state();
    try {  return unknownType();  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:165
   */
  public boolean isReferenceType() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:168
   */
  public boolean isPrimitiveType() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:173
   */
  public boolean isNumericType() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:177
   */
  public boolean isIntegralType() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:181
   */
  public boolean isBoolean() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:185
   */
  public boolean isByte() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:187
   */
  public boolean isChar() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:189
   */
  public boolean isShort() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:191
   */
  public boolean isInt() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:195
   */
  public boolean isFloat() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:197
   */
  public boolean isLong() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:199
   */
  public boolean isDouble() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:202
   */
  public boolean isVoid() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:205
   */
  public boolean isNull() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:209
   */
  public boolean isClassDecl() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:211
   */
  public boolean isInterfaceDecl() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:213
   */
  public boolean isArrayDecl() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:221
   */
  public boolean isPrimitive() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @apilevel internal
   */
  protected boolean isString_computed = false;
  /**
   * @apilevel internal
   */
  protected boolean isString_value;
  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:224
   */
  public boolean isString() {
    if(isString_computed) {
      return isString_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    isString_value = isString_compute();
    if (isFinal && num == state().boundariesCrossed) {
      isString_computed = true;
    } else {
    }

    return isString_value;
  }
  /**
   * @apilevel internal
   */
  private boolean isString_compute() {  return false;  }
  /**
   * @apilevel internal
   */
  protected boolean isObject_computed = false;
  /**
   * @apilevel internal
   */
  protected boolean isObject_value;
  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:227
   */
  public boolean isObject() {
    if(isObject_computed) {
      return isObject_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    isObject_value = isObject_compute();
    if (isFinal && num == state().boundariesCrossed) {
      isObject_computed = true;
    } else {
    }

    return isObject_value;
  }
  /**
   * @apilevel internal
   */
  private boolean isObject_compute() {  return false;  }
  /**
   * @attribute syn
   * @aspect TypeAnalysis
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:230
   */
  public boolean isUnknown() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  protected java.util.Map instanceOf_TypeDecl_values;
  /**
   * @attribute syn
   * @aspect GenericsSubtype
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/GenericsSubtype.jrag:386
   */
  public boolean instanceOf(TypeDecl type) {
    Object _parameters = type;
    if (instanceOf_TypeDecl_values == null) instanceOf_TypeDecl_values = new org.jastadd.util.RobustMap(new java.util.HashMap());
    if(instanceOf_TypeDecl_values.containsKey(_parameters)) {
      return ((Boolean)instanceOf_TypeDecl_values.get(_parameters)).booleanValue();
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    boolean instanceOf_TypeDecl_value = instanceOf_compute(type);
    if (isFinal && num == state().boundariesCrossed) {
      instanceOf_TypeDecl_values.put(_parameters, Boolean.valueOf(instanceOf_TypeDecl_value));
    } else {
    }

    return instanceOf_TypeDecl_value;
  }
  /**
   * @apilevel internal
   */
  private boolean instanceOf_compute(TypeDecl type) { return subtype(type); }
  /**
   * @attribute syn
   * @aspect TypeWideningAndIdentity
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:422
   */
  public boolean isSupertypeOfClassDecl(ClassDecl type) {
    ASTNode$State state = state();
    try {  return type == this;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect TypeWideningAndIdentity
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:441
   */
  public boolean isSupertypeOfInterfaceDecl(InterfaceDecl type) {
    ASTNode$State state = state();
    try {  return type == this;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect TypeWideningAndIdentity
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:456
   */
  public boolean isSupertypeOfArrayDecl(ArrayDecl type) {
    ASTNode$State state = state();
    try {  return this == type;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect TypeWideningAndIdentity
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:480
   */
  public boolean isSupertypeOfPrimitiveType(PrimitiveType type) {
    ASTNode$State state = state();
    try {  return type == this;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect TypeWideningAndIdentity
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:487
   */
  public boolean isSupertypeOfNullType(NullType type) {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect TypeWideningAndIdentity
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:491
   */
  public boolean isSupertypeOfVoidType(VoidType type) {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect NestedTypes
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:505
   */
  public TypeDecl topLevelType() {
    ASTNode$State state = state();
    try {
        if(isTopLevelType())
          return this;
        return enclosingType().topLevelType();
      }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect NestedTypes
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:531
   */
  public boolean isTopLevelType() {
    ASTNode$State state = state();
    try {  return !isNestedType();  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect NestedTypes
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:542
   */
  public boolean isInnerClass() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect NestedTypes
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:544
   */
  public boolean isInnerType() {
    ASTNode$State state = state();
    try {  return (isLocalClass() || isAnonymous() || (isMemberType() && !isStatic())) && !inStaticContext();  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect NestedTypes
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:546
   */
  public boolean isInnerTypeOf(TypeDecl typeDecl) {
    ASTNode$State state = state();
    try {  return typeDecl == this || (isInnerType() && enclosingType().isInnerTypeOf(typeDecl));  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect NestedTypes
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:553
   */
  public TypeDecl withinBodyThatSubclasses(TypeDecl type) {
    ASTNode$State state = state();
    try {
        if(instanceOf(type))
          return this;
        if(!isTopLevelType())
          return enclosingType().withinBodyThatSubclasses(type);
        return null;
      }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect NestedTypes
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:561
   */
  public boolean encloses(TypeDecl type) {
    ASTNode$State state = state();
    try {  return type.enclosedBy(this);  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect NestedTypes
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:563
   */
  public boolean enclosedBy(TypeDecl type) {
    ASTNode$State state = state();
    try {
        if(this == type)
          return true;
        if(isTopLevelType())
          return false;
        return enclosingType().enclosedBy(type);
      }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect NestedTypes
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:577
   */
  public TypeDecl hostType() {
    ASTNode$State state = state();
    try {  return this;  }
    finally {
    }
  }
  /**
   * @apilevel internal
   */
  protected int isCircular_visited = -1;
  /**
   * @apilevel internal
   */
  protected boolean isCircular_computed = false;
  /**
   * @apilevel internal
   */
  protected boolean isCircular_initialized = false;
  /**
   * @apilevel internal
   */
  protected boolean isCircular_value;
  /**
   * @attribute syn
   * @aspect Circularity
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:683
   */
  public boolean isCircular() {
    if(isCircular_computed) {
      return isCircular_value;
    }
    ASTNode$State state = state();
    if (!isCircular_initialized) {
      isCircular_initialized = true;
      isCircular_value = true;
    }
    if (!state.IN_CIRCLE) {
      state.IN_CIRCLE = true;
      int num = state.boundariesCrossed;
      boolean isFinal = this.is$Final();
      // TODO: fixme
      // state().CIRCLE_INDEX = 1;
      do {
        isCircular_visited = state.CIRCLE_INDEX;
        state.CHANGE = false;
        boolean new_isCircular_value = isCircular_compute();
        if (new_isCircular_value != isCircular_value) {
          state.CHANGE = true;
        }
        isCircular_value = new_isCircular_value;
        state.CIRCLE_INDEX++;
      } while (state.CHANGE);
      if (isFinal && num == state().boundariesCrossed) {
        isCircular_computed = true;
      } else {
        state.RESET_CYCLE = true;
        isCircular_compute();
        state.RESET_CYCLE = false;
        isCircular_computed = false;
        isCircular_initialized = false;
      }
      state.IN_CIRCLE = false;
      return isCircular_value;
    }
    if(isCircular_visited != state.CIRCLE_INDEX) {
      isCircular_visited = state.CIRCLE_INDEX;
      if (state.RESET_CYCLE) {
        isCircular_computed = false;
        isCircular_initialized = false;
        isCircular_visited = -1;
        return isCircular_value;
      }
      boolean new_isCircular_value = isCircular_compute();
      if (new_isCircular_value != isCircular_value) {
        state.CHANGE = true;
      }
      isCircular_value = new_isCircular_value;
      return isCircular_value;
    }
    return isCircular_value;
  }
  /**
   * @apilevel internal
   */
  private boolean isCircular_compute() {  return false;  }
  /**
   * @attribute syn
   * @aspect Annotations
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Annotations.jrag:121
   */
  public boolean isValidAnnotationMethodReturnType() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect Annotations
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Annotations.jrag:233
   */
  public Annotation annotation(TypeDecl typeDecl) {
    ASTNode$State state = state();
    try {  return getModifiers().annotation(typeDecl);  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect Annotations
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Annotations.jrag:291
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
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Annotations.jrag:330
   */
  public boolean isDeprecated() {
    ASTNode$State state = state();
    try {  return getModifiers().hasDeprecatedAnnotation();  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect Annotations
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Annotations.jrag:484
   */
  public boolean commensurateWith(ElementValue value) {
    ASTNode$State state = state();
    try {  return value.commensurateWithTypeDecl(this);  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect Annotations
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Annotations.jrag:562
   */
  public boolean isAnnotationDecl() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect AutoBoxing
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/AutoBoxing.jrag:31
   */
  public boolean boxingConversionTo(TypeDecl typeDecl) {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @apilevel internal
   */
  protected boolean boxed_computed = false;
  /**
   * @apilevel internal
   */
  protected TypeDecl boxed_value;
  /**
   * @attribute syn
   * @aspect AutoBoxing
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/AutoBoxing.jrag:35
   */
  public TypeDecl boxed() {
    if(boxed_computed) {
      return boxed_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    boxed_value = boxed_compute();
    if (isFinal && num == state().boundariesCrossed) {
      boxed_computed = true;
    } else {
    }

    return boxed_value;
  }
  /**
   * @apilevel internal
   */
  private TypeDecl boxed_compute() {  return unknownType();  }
  /**
   * @attribute syn
   * @aspect AutoBoxing
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/AutoBoxing.jrag:47
   */
  public boolean unboxingConversionTo(TypeDecl typeDecl) {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @apilevel internal
   */
  protected boolean unboxed_computed = false;
  /**
   * @apilevel internal
   */
  protected TypeDecl unboxed_value;
  /**
   * @attribute syn
   * @aspect AutoBoxing
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/AutoBoxing.jrag:51
   */
  public TypeDecl unboxed() {
    if(unboxed_computed) {
      return unboxed_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    unboxed_value = unboxed_compute();
    if (isFinal && num == state().boundariesCrossed) {
      unboxed_computed = true;
    } else {
    }

    return unboxed_value;
  }
  /**
   * @apilevel internal
   */
  private TypeDecl unboxed_compute() {  return unknownType();  }
  /**
   * @apilevel internal
   */
  protected boolean isIterable_computed = false;
  /**
   * @apilevel internal
   */
  protected boolean isIterable_value;
  /**
   * True if type is java.lang.Iterable or subtypeAs long as we use the 1.4 API we check for java.util.Collection instead.
   * @attribute syn
   * @aspect EnhancedFor
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/EnhancedFor.jrag:40
   */
  public boolean isIterable() {
    if(isIterable_computed) {
      return isIterable_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    isIterable_value = isIterable_compute();
    if (isFinal && num == state().boundariesCrossed) {
      isIterable_computed = true;
    } else {
    }

    return isIterable_value;
  }
  /**
   * @apilevel internal
   */
  private boolean isIterable_compute() {  return instanceOf(lookupType("java.lang", "Iterable"));  }
  /**
   * @attribute syn
   * @aspect Enums
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Enums.jrag:16
   */
  public boolean isEnumDecl() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect GenericMethodsInference
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/GenericMethodsInference.jrag:13
   */
  public boolean isUnboxedPrimitive() {
    ASTNode$State state = state();
    try {  return this instanceof PrimitiveType && isPrimitive();  }
    finally {
    }
  }
  /**
   * @apilevel internal
   */
  protected int involvesTypeParameters_visited = -1;
  /**
   * @apilevel internal
   */
  protected boolean involvesTypeParameters_computed = false;
  /**
   * @apilevel internal
   */
  protected boolean involvesTypeParameters_initialized = false;
  /**
   * @apilevel internal
   */
  protected boolean involvesTypeParameters_value;
  /**
   * @attribute syn
   * @aspect GenericMethodsInference
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/GenericMethodsInference.jrag:15
   */
  public boolean involvesTypeParameters() {
    if(involvesTypeParameters_computed) {
      return involvesTypeParameters_value;
    }
    ASTNode$State state = state();
    if (!involvesTypeParameters_initialized) {
      involvesTypeParameters_initialized = true;
      involvesTypeParameters_value = false;
    }
    if (!state.IN_CIRCLE) {
      state.IN_CIRCLE = true;
      int num = state.boundariesCrossed;
      boolean isFinal = this.is$Final();
      // TODO: fixme
      // state().CIRCLE_INDEX = 1;
      do {
        involvesTypeParameters_visited = state.CIRCLE_INDEX;
        state.CHANGE = false;
        boolean new_involvesTypeParameters_value = involvesTypeParameters_compute();
        if (new_involvesTypeParameters_value != involvesTypeParameters_value) {
          state.CHANGE = true;
        }
        involvesTypeParameters_value = new_involvesTypeParameters_value;
        state.CIRCLE_INDEX++;
      } while (state.CHANGE);
      if (isFinal && num == state().boundariesCrossed) {
        involvesTypeParameters_computed = true;
      } else {
        state.RESET_CYCLE = true;
        involvesTypeParameters_compute();
        state.RESET_CYCLE = false;
        involvesTypeParameters_computed = false;
        involvesTypeParameters_initialized = false;
      }
      state.IN_CIRCLE = false;
      return involvesTypeParameters_value;
    }
    if(involvesTypeParameters_visited != state.CIRCLE_INDEX) {
      involvesTypeParameters_visited = state.CIRCLE_INDEX;
      if (state.RESET_CYCLE) {
        involvesTypeParameters_computed = false;
        involvesTypeParameters_initialized = false;
        involvesTypeParameters_visited = -1;
        return involvesTypeParameters_value;
      }
      boolean new_involvesTypeParameters_value = involvesTypeParameters_compute();
      if (new_involvesTypeParameters_value != involvesTypeParameters_value) {
        state.CHANGE = true;
      }
      involvesTypeParameters_value = new_involvesTypeParameters_value;
      return involvesTypeParameters_value;
    }
    return involvesTypeParameters_value;
  }
  /**
   * @apilevel internal
   */
  private boolean involvesTypeParameters_compute() {  return false;  }
  /**
   * @attribute syn
   * @aspect Generics
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Generics.jrag:193
   */
  public boolean isGenericType() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect Generics
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Generics.jrag:267
   */
  public boolean isParameterizedType() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect Generics
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Generics.jrag:270
   */
  public boolean isRawType() {
    ASTNode$State state = state();
    try {  return isNestedType() && enclosingType().isRawType();  }
    finally {
    }
  }
  /**
   * @apilevel internal
   */
  protected boolean erasure_computed = false;
  /**
   * @apilevel internal
   */
  protected TypeDecl erasure_value;
  /**
   * @attribute syn
   * @aspect GenericsErasure
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Generics.jrag:357
   */
  public TypeDecl erasure() {
    if(erasure_computed) {
      return erasure_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    erasure_value = erasure_compute();
    if (isFinal && num == state().boundariesCrossed) {
      erasure_computed = true;
    } else {
    }

    return erasure_value;
  }
  /**
   * @apilevel internal
   */
  private TypeDecl erasure_compute() {
      if(isAnonymous() || isLocalClass())
        return this;
      if(!isNestedType())
        return this;
      return extractSingleType(enclosingType().erasure().memberTypes(name()));
    }
  /**
   * @apilevel internal
   */
  protected boolean implementedInterfaces_computed = false;
  /**
   * @apilevel internal
   */
  protected HashSet implementedInterfaces_value;
  /**
   * @attribute syn
   * @aspect GenericsTypeCheck
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Generics.jrag:413
   */
  public HashSet implementedInterfaces() {
    if(implementedInterfaces_computed) {
      return implementedInterfaces_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    implementedInterfaces_value = implementedInterfaces_compute();
    if (isFinal && num == state().boundariesCrossed) {
      implementedInterfaces_computed = true;
    } else {
    }

    return implementedInterfaces_value;
  }
  /**
   * @apilevel internal
   */
  private HashSet implementedInterfaces_compute() {  return new HashSet();  }
  /**
   * @attribute syn
   * @aspect LookupParTypeDecl
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Generics.jrag:584
   */
  public boolean sameSignature(Access a) {
    ASTNode$State state = state();
    try {
        if(a instanceof ParTypeAccess) return false;
        if(a instanceof AbstractWildcard) return false;
        return this == a.type();
      }
    finally {
    }
  }
  /**
   * @apilevel internal
   */
  protected int usesTypeVariable_visited = -1;
  /**
   * @apilevel internal
   */
  protected boolean usesTypeVariable_computed = false;
  /**
   * @apilevel internal
   */
  protected boolean usesTypeVariable_initialized = false;
  /**
   * @apilevel internal
   */
  protected boolean usesTypeVariable_value;
  /**
   * @attribute syn
   * @aspect LookupParTypeDecl
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Generics.jrag:935
   */
  public boolean usesTypeVariable() {
    if(usesTypeVariable_computed) {
      return usesTypeVariable_value;
    }
    ASTNode$State state = state();
    if (!usesTypeVariable_initialized) {
      usesTypeVariable_initialized = true;
      usesTypeVariable_value = false;
    }
    if (!state.IN_CIRCLE) {
      state.IN_CIRCLE = true;
      int num = state.boundariesCrossed;
      boolean isFinal = this.is$Final();
      // TODO: fixme
      // state().CIRCLE_INDEX = 1;
      do {
        usesTypeVariable_visited = state.CIRCLE_INDEX;
        state.CHANGE = false;
        boolean new_usesTypeVariable_value = usesTypeVariable_compute();
        if (new_usesTypeVariable_value != usesTypeVariable_value) {
          state.CHANGE = true;
        }
        usesTypeVariable_value = new_usesTypeVariable_value;
        state.CIRCLE_INDEX++;
      } while (state.CHANGE);
      if (isFinal && num == state().boundariesCrossed) {
        usesTypeVariable_computed = true;
      } else {
        state.RESET_CYCLE = true;
        usesTypeVariable_compute();
        state.RESET_CYCLE = false;
        usesTypeVariable_computed = false;
        usesTypeVariable_initialized = false;
      }
      state.IN_CIRCLE = false;
      return usesTypeVariable_value;
    }
    if(usesTypeVariable_visited != state.CIRCLE_INDEX) {
      usesTypeVariable_visited = state.CIRCLE_INDEX;
      if (state.RESET_CYCLE) {
        usesTypeVariable_computed = false;
        usesTypeVariable_initialized = false;
        usesTypeVariable_visited = -1;
        return usesTypeVariable_value;
      }
      boolean new_usesTypeVariable_value = usesTypeVariable_compute();
      if (new_usesTypeVariable_value != usesTypeVariable_value) {
        state.CHANGE = true;
      }
      usesTypeVariable_value = new_usesTypeVariable_value;
      return usesTypeVariable_value;
    }
    return usesTypeVariable_value;
  }
  /**
   * @apilevel internal
   */
  private boolean usesTypeVariable_compute() {  return isNestedType() && enclosingType().usesTypeVariable();  }
  /**
   * @attribute syn
   * @aspect LookupParTypeDecl
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Generics.jrag:1102
   */
  public TypeDecl original() {
    ASTNode$State state = state();
    try {  return this;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect LookupParTypeDecl
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Generics.jrag:1190
   */
  public TypeDecl asWildcardExtends() {
    ASTNode$State state = state();
    try {  return lookupWildcardExtends(this);  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect LookupParTypeDecl
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Generics.jrag:1203
   */
  public TypeDecl asWildcardSuper() {
    ASTNode$State state = state();
    try {  return lookupWildcardSuper(this);  }
    finally {
    }
  }
  /**
   * @apilevel internal
   */
  protected boolean sourceTypeDecl_computed = false;
  /**
   * @apilevel internal
   */
  protected TypeDecl sourceTypeDecl_value;
  /**
   * @attribute syn
   * @aspect SourceDeclarations
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Generics.jrag:1299
   */
  public TypeDecl sourceTypeDecl() {
    if(sourceTypeDecl_computed) {
      return sourceTypeDecl_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    sourceTypeDecl_value = sourceTypeDecl_compute();
    if (isFinal && num == state().boundariesCrossed) {
      sourceTypeDecl_computed = true;
    } else {
    }

    return sourceTypeDecl_value;
  }
  /**
   * @apilevel internal
   */
  private TypeDecl sourceTypeDecl_compute() {  return this;  }
  /**
   * @attribute syn
   * @aspect GenericsParTypeDecl
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/GenericsParTypeDecl.jrag:71
   */
  public boolean isTypeVariable() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect GenericsSubtype
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/GenericsSubtype.jrag:14
   */
  public boolean supertypeGenericClassDecl(GenericClassDecl type) {
    ASTNode$State state = state();
    try {  return supertypeClassDecl(type);  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect GenericsSubtype
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/GenericsSubtype.jrag:20
   */
  public boolean supertypeGenericInterfaceDecl(GenericInterfaceDecl type) {
    ASTNode$State state = state();
    try {  return this == type || supertypeInterfaceDecl(type);  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect GenericsSubtype
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/GenericsSubtype.jrag:26
   */
  public boolean supertypeRawClassDecl(RawClassDecl type) {
    ASTNode$State state = state();
    try {  return supertypeParClassDecl(type);  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect GenericsSubtype
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/GenericsSubtype.jrag:30
   */
  public boolean supertypeRawInterfaceDecl(RawInterfaceDecl type) {
    ASTNode$State state = state();
    try {  return supertypeParInterfaceDecl(type);  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect GenericsSubtype
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/GenericsSubtype.jrag:46
   */
  public boolean supertypeWildcard(WildcardType type) {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect GenericsSubtype
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/GenericsSubtype.jrag:57
   */
  public boolean supertypeWildcardExtends(WildcardExtendsType type) {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect GenericsSubtype
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/GenericsSubtype.jrag:66
   */
  public boolean supertypeWildcardSuper(WildcardSuperType type) {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect GenericsSubtype
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/GenericsSubtype.jrag:102
   */
  public boolean isWildcard() {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect GenericsSubtype
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/GenericsSubtype.jrag:125
   */
  public boolean supertypeParClassDecl(ParClassDecl type) {
    ASTNode$State state = state();
    try {  return supertypeClassDecl(type);  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect GenericsSubtype
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/GenericsSubtype.jrag:129
   */
  public boolean supertypeParInterfaceDecl(ParInterfaceDecl type) {
    ASTNode$State state = state();
    try {  return supertypeInterfaceDecl(type);  }
    finally {
    }
  }
  protected java.util.Map containedIn_TypeDecl_values;
  /**
   * @attribute syn
   * @aspect GenericsSubtype
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/GenericsSubtype.jrag:141
   */
  public boolean containedIn(TypeDecl type) {
    Object _parameters = type;
    if (containedIn_TypeDecl_values == null) containedIn_TypeDecl_values = new org.jastadd.util.RobustMap(new java.util.HashMap());
    ASTNode$State.CircularValue _value;
    if(containedIn_TypeDecl_values.containsKey(_parameters)) {
      Object _o = containedIn_TypeDecl_values.get(_parameters);
      if(!(_o instanceof ASTNode$State.CircularValue)) {
        return ((Boolean)_o).booleanValue();
      } else {
        _value = (ASTNode$State.CircularValue) _o;
      }
    } else {
      _value = new ASTNode$State.CircularValue();
      containedIn_TypeDecl_values.put(_parameters, _value);
      _value.value = Boolean.valueOf(true);
    }
    ASTNode$State state = state();
    if (!state.IN_CIRCLE) {
      state.IN_CIRCLE = true;
      int num = state.boundariesCrossed;
      boolean isFinal = this.is$Final();
      // TODO: fixme
      // state().CIRCLE_INDEX = 1;
      boolean new_containedIn_TypeDecl_value;
      do {
        _value.visited = new Integer(state.CIRCLE_INDEX);
        state.CHANGE = false;
        new_containedIn_TypeDecl_value = containedIn_compute(type);
        if (new_containedIn_TypeDecl_value != ((Boolean)_value.value).booleanValue()) {
          state.CHANGE = true;
          _value.value = Boolean.valueOf(new_containedIn_TypeDecl_value);
        }
        state.CIRCLE_INDEX++;
      } while (state.CHANGE);
      if (isFinal && num == state().boundariesCrossed) {
        containedIn_TypeDecl_values.put(_parameters, new_containedIn_TypeDecl_value);
      } else {
        containedIn_TypeDecl_values.remove(_parameters);
        state.RESET_CYCLE = true;
        containedIn_compute(type);
        state.RESET_CYCLE = false;
      }
      state.IN_CIRCLE = false;
      return new_containedIn_TypeDecl_value;
    }
    if (!new Integer(state.CIRCLE_INDEX).equals(_value.visited)) {
      _value.visited = new Integer(state.CIRCLE_INDEX);
      boolean new_containedIn_TypeDecl_value = containedIn_compute(type);
      if (state.RESET_CYCLE) {
        containedIn_TypeDecl_values.remove(_parameters);
      }
      else if (new_containedIn_TypeDecl_value != ((Boolean)_value.value).booleanValue()) {
        state.CHANGE = true;
        _value.value = new_containedIn_TypeDecl_value;
      }
      return new_containedIn_TypeDecl_value;
    }
    return ((Boolean)_value.value).booleanValue();
  }
  /**
   * @apilevel internal
   */
  private boolean containedIn_compute(TypeDecl type) {
      if(type == this || type instanceof WildcardType)
        return true;
      else if(type instanceof WildcardExtendsType)
        return this.subtype(((WildcardExtendsType)type).extendsType());
      else if(type instanceof WildcardSuperType)
        return ((WildcardSuperType)type).superType().subtype(this);
      else if(type instanceof TypeVariable)
        return subtype(type);
      return sameStructure(type);
      //return false;
    }
  protected java.util.Map sameStructure_TypeDecl_values;
  /**
   * @attribute syn
   * @aspect GenericsSubtype
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/GenericsSubtype.jrag:178
   */
  public boolean sameStructure(TypeDecl t) {
    Object _parameters = t;
    if (sameStructure_TypeDecl_values == null) sameStructure_TypeDecl_values = new org.jastadd.util.RobustMap(new java.util.HashMap());
    ASTNode$State.CircularValue _value;
    if(sameStructure_TypeDecl_values.containsKey(_parameters)) {
      Object _o = sameStructure_TypeDecl_values.get(_parameters);
      if(!(_o instanceof ASTNode$State.CircularValue)) {
        return ((Boolean)_o).booleanValue();
      } else {
        _value = (ASTNode$State.CircularValue) _o;
      }
    } else {
      _value = new ASTNode$State.CircularValue();
      sameStructure_TypeDecl_values.put(_parameters, _value);
      _value.value = Boolean.valueOf(true);
    }
    ASTNode$State state = state();
    if (!state.IN_CIRCLE) {
      state.IN_CIRCLE = true;
      int num = state.boundariesCrossed;
      boolean isFinal = this.is$Final();
      // TODO: fixme
      // state().CIRCLE_INDEX = 1;
      boolean new_sameStructure_TypeDecl_value;
      do {
        _value.visited = new Integer(state.CIRCLE_INDEX);
        state.CHANGE = false;
        new_sameStructure_TypeDecl_value = sameStructure_compute(t);
        if (new_sameStructure_TypeDecl_value != ((Boolean)_value.value).booleanValue()) {
          state.CHANGE = true;
          _value.value = Boolean.valueOf(new_sameStructure_TypeDecl_value);
        }
        state.CIRCLE_INDEX++;
      } while (state.CHANGE);
      if (isFinal && num == state().boundariesCrossed) {
        sameStructure_TypeDecl_values.put(_parameters, new_sameStructure_TypeDecl_value);
      } else {
        sameStructure_TypeDecl_values.remove(_parameters);
        state.RESET_CYCLE = true;
        sameStructure_compute(t);
        state.RESET_CYCLE = false;
      }
      state.IN_CIRCLE = false;
      return new_sameStructure_TypeDecl_value;
    }
    if (!new Integer(state.CIRCLE_INDEX).equals(_value.visited)) {
      _value.visited = new Integer(state.CIRCLE_INDEX);
      boolean new_sameStructure_TypeDecl_value = sameStructure_compute(t);
      if (state.RESET_CYCLE) {
        sameStructure_TypeDecl_values.remove(_parameters);
      }
      else if (new_sameStructure_TypeDecl_value != ((Boolean)_value.value).booleanValue()) {
        state.CHANGE = true;
        _value.value = new_sameStructure_TypeDecl_value;
      }
      return new_sameStructure_TypeDecl_value;
    }
    return ((Boolean)_value.value).booleanValue();
  }
  /**
   * @apilevel internal
   */
  private boolean sameStructure_compute(TypeDecl t) {  return t == this;  }
  /**
   * @attribute syn
   * @aspect GenericsSubtype
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/GenericsSubtype.jrag:291
   */
  public boolean supertypeTypeVariable(TypeVariable type) {
    ASTNode$State state = state();
    try {
        if(type == this)
          return true;
        for(int i = 0; i < type.getNumTypeBound(); i++)
          if(type.getTypeBound(i).type().subtype(this))
            return true;
        return false;
      }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect GenericsSubtype
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/GenericsSubtype.jrag:347
   */
  public boolean supertypeLUBType(LUBType type) {
    ASTNode$State state = state();
    try {
        for(int i = 0; i < type.getNumTypeBound(); i++)
          if(!type.getTypeBound(i).type().subtype(this))
            return false;
        return true;
      }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect GenericsSubtype
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/GenericsSubtype.jrag:366
   */
  public boolean supertypeGLBType(GLBType type) {
    ASTNode$State state = state();
    try {
        // T1 && .. && Tn <: this, if exists  0 < i <= n Ti <: this
        for(int i = 0; i < type.getNumTypeBound(); i++)
          if(type.getTypeBound(i).type().subtype(this))
            return true;
        return false;
      }
    finally {
    }
  }
  protected java.util.Map subtype_TypeDecl_values;
  /**
   * @attribute syn
   * @aspect GenericsSubtype
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/GenericsSubtype.jrag:405
   */
  public boolean subtype(TypeDecl type) {
    Object _parameters = type;
    if (subtype_TypeDecl_values == null) subtype_TypeDecl_values = new org.jastadd.util.RobustMap(new java.util.HashMap());
    ASTNode$State.CircularValue _value;
    if(subtype_TypeDecl_values.containsKey(_parameters)) {
      Object _o = subtype_TypeDecl_values.get(_parameters);
      if(!(_o instanceof ASTNode$State.CircularValue)) {
        return ((Boolean)_o).booleanValue();
      } else {
        _value = (ASTNode$State.CircularValue) _o;
      }
    } else {
      _value = new ASTNode$State.CircularValue();
      subtype_TypeDecl_values.put(_parameters, _value);
      _value.value = Boolean.valueOf(true);
    }
    ASTNode$State state = state();
    if (!state.IN_CIRCLE) {
      state.IN_CIRCLE = true;
      int num = state.boundariesCrossed;
      boolean isFinal = this.is$Final();
      // TODO: fixme
      // state().CIRCLE_INDEX = 1;
      boolean new_subtype_TypeDecl_value;
      do {
        _value.visited = new Integer(state.CIRCLE_INDEX);
        state.CHANGE = false;
        new_subtype_TypeDecl_value = subtype_compute(type);
        if (new_subtype_TypeDecl_value != ((Boolean)_value.value).booleanValue()) {
          state.CHANGE = true;
          _value.value = Boolean.valueOf(new_subtype_TypeDecl_value);
        }
        state.CIRCLE_INDEX++;
      } while (state.CHANGE);
      if (isFinal && num == state().boundariesCrossed) {
        subtype_TypeDecl_values.put(_parameters, new_subtype_TypeDecl_value);
      } else {
        subtype_TypeDecl_values.remove(_parameters);
        state.RESET_CYCLE = true;
        subtype_compute(type);
        state.RESET_CYCLE = false;
      }
      state.IN_CIRCLE = false;
      return new_subtype_TypeDecl_value;
    }
    if (!new Integer(state.CIRCLE_INDEX).equals(_value.visited)) {
      _value.visited = new Integer(state.CIRCLE_INDEX);
      boolean new_subtype_TypeDecl_value = subtype_compute(type);
      if (state.RESET_CYCLE) {
        subtype_TypeDecl_values.remove(_parameters);
      }
      else if (new_subtype_TypeDecl_value != ((Boolean)_value.value).booleanValue()) {
        state.CHANGE = true;
        _value.value = new_subtype_TypeDecl_value;
      }
      return new_subtype_TypeDecl_value;
    }
    return ((Boolean)_value.value).booleanValue();
  }
  /**
   * @apilevel internal
   */
  private boolean subtype_compute(TypeDecl type) {  return type == this;  }
  /**
   * @attribute syn
   * @aspect GenericsSubtype
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/GenericsSubtype.jrag:421
   */
  public boolean supertypeClassDecl(ClassDecl type) {
    ASTNode$State state = state();
    try {  return type == this;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect GenericsSubtype
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/GenericsSubtype.jrag:439
   */
  public boolean supertypeInterfaceDecl(InterfaceDecl type) {
    ASTNode$State state = state();
    try {  return type == this;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect GenericsSubtype
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/GenericsSubtype.jrag:454
   */
  public boolean supertypeArrayDecl(ArrayDecl type) {
    ASTNode$State state = state();
    try {  return this == type;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect GenericsSubtype
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/GenericsSubtype.jrag:478
   */
  public boolean supertypePrimitiveType(PrimitiveType type) {
    ASTNode$State state = state();
    try {  return type == this;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect GenericsSubtype
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/GenericsSubtype.jrag:485
   */
  public boolean supertypeNullType(NullType type) {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect GenericsSubtype
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/GenericsSubtype.jrag:489
   */
  public boolean supertypeVoidType(VoidType type) {
    ASTNode$State state = state();
    try {  return false;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect GenericsSubtype
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/GenericsSubtype.jrag:499
   */
  public boolean supertypeClassDeclSubstituted(ClassDeclSubstituted type) {
    ASTNode$State state = state();
    try {  return type.original() == this || supertypeClassDecl(type);  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect GenericsSubtype
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/GenericsSubtype.jrag:509
   */
  public boolean supertypeInterfaceDeclSubstituted(InterfaceDeclSubstituted type) {
    ASTNode$State state = state();
    try {  return type.original() == this || supertypeInterfaceDecl(type);  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect GenericsSubtype
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/GenericsSubtype.jrag:519
   */
  public boolean supertypeGenericClassDeclSubstituted(GenericClassDeclSubstituted type) {
    ASTNode$State state = state();
    try {  return type.original() == this || supertypeGenericClassDecl(type);  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect GenericsSubtype
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/GenericsSubtype.jrag:529
   */
  public boolean supertypeGenericInterfaceDeclSubstituted(GenericInterfaceDeclSubstituted type) {
    ASTNode$State state = state();
    try {  return type.original() == this || supertypeGenericInterfaceDecl(type);  }
    finally {
    }
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
   * @attribute syn
   * @aspect Helpers
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/Helpers.jrag:13
   */
  public BitSet emptyBitSet() {
    if(emptyBitSet_computed) {
      return emptyBitSet_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    emptyBitSet_value = emptyBitSet_compute();
    if (isFinal && num == state().boundariesCrossed) {
      emptyBitSet_computed = true;
    } else {
    }

    return emptyBitSet_value;
  }
  /**
   * @apilevel internal
   */
  private BitSet emptyBitSet_compute() {  return new BitSet();  }
  /**
   * @attribute syn
   * @aspect Java_CFG_1_4
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:61
   */
  public BodyDecl getFieldOrInitializerAfter(int i, boolean statik) {
    ASTNode$State state = state();
    try {
    		for(;i<getNumBodyDecl();++i) {
    			BodyDecl bd = getBodyDecl(i);
    			if(statik && bd instanceof StaticInitializer ||
    			   !statik && bd instanceof InstanceInitializer ||
    			   bd instanceof FieldDeclaration && ((FieldDeclaration)bd).isStatic() == statik)
    				return bd;
    		}
    		return null;
    	}
    finally {
    }
  }
  /**
   * @attribute inh
   * @aspect Arrays
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Arrays.jrag:21
   */
  public TypeDecl componentType() {
    if(componentType_computed) {
      return componentType_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    componentType_value = getParent().Define_TypeDecl_componentType(this, null);
    if (isFinal && num == state().boundariesCrossed) {
      componentType_computed = true;
    } else {
    }

    return componentType_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean componentType_computed = false;
  /**
   * @apilevel internal
   */
  protected TypeDecl componentType_value;
  /**
   * @attribute inh
   * @aspect Arrays
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Arrays.jrag:50
   */
  public TypeDecl typeCloneable() {
    ASTNode$State state = state();
    TypeDecl typeCloneable_value = getParent().Define_TypeDecl_typeCloneable(this, null);

    return typeCloneable_value;
  }
  /**
   * @attribute inh
   * @aspect Arrays
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Arrays.jrag:51
   */
  public TypeDecl typeSerializable() {
    ASTNode$State state = state();
    TypeDecl typeSerializable_value = getParent().Define_TypeDecl_typeSerializable(this, null);

    return typeSerializable_value;
  }
  /**
   * @attribute inh
   * @aspect ClassPath
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ClassPath.jrag:52
   */
  public CompilationUnit compilationUnit() {
    ASTNode$State state = state();
    CompilationUnit compilationUnit_value = getParent().Define_CompilationUnit_compilationUnit(this, null);

    return compilationUnit_value;
  }
  /**
   * @attribute inh
   * @aspect DA
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DefiniteAssignment.jrag:240
   */
  public boolean isDAbefore(Variable v) {
    Object _parameters = v;
    if (isDAbefore_Variable_values == null) isDAbefore_Variable_values = new org.jastadd.util.RobustMap(new java.util.HashMap());
    if(isDAbefore_Variable_values.containsKey(_parameters)) {
      return ((Boolean)isDAbefore_Variable_values.get(_parameters)).booleanValue();
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    boolean isDAbefore_Variable_value = getParent().Define_boolean_isDAbefore(this, null, v);
    if (isFinal && num == state().boundariesCrossed) {
      isDAbefore_Variable_values.put(_parameters, Boolean.valueOf(isDAbefore_Variable_value));
    } else {
    }

    return isDAbefore_Variable_value;
  }
  protected java.util.Map isDAbefore_Variable_values;
  /**
   * @attribute inh
   * @aspect DU
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DefiniteAssignment.jrag:718
   */
  public boolean isDUbefore(Variable v) {
    Object _parameters = v;
    if (isDUbefore_Variable_values == null) isDUbefore_Variable_values = new org.jastadd.util.RobustMap(new java.util.HashMap());
    if(isDUbefore_Variable_values.containsKey(_parameters)) {
      return ((Boolean)isDUbefore_Variable_values.get(_parameters)).booleanValue();
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    boolean isDUbefore_Variable_value = getParent().Define_boolean_isDUbefore(this, null, v);
    if (isFinal && num == state().boundariesCrossed) {
      isDUbefore_Variable_values.put(_parameters, Boolean.valueOf(isDUbefore_Variable_value));
    } else {
    }

    return isDUbefore_Variable_value;
  }
  protected java.util.Map isDUbefore_Variable_values;
  /**
   * @attribute inh
   * @aspect ExceptionHandling
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ExceptionHandling.jrag:20
   */
  public TypeDecl typeException() {
    if(typeException_computed) {
      return typeException_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    typeException_value = getParent().Define_TypeDecl_typeException(this, null);
    if (isFinal && num == state().boundariesCrossed) {
      typeException_computed = true;
    } else {
    }

    return typeException_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean typeException_computed = false;
  /**
   * @apilevel internal
   */
  protected TypeDecl typeException_value;
  /**
   * @attribute inh
   * @aspect ExceptionHandling
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ExceptionHandling.jrag:22
   */
  public TypeDecl typeRuntimeException() {
    if(typeRuntimeException_computed) {
      return typeRuntimeException_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    typeRuntimeException_value = getParent().Define_TypeDecl_typeRuntimeException(this, null);
    if (isFinal && num == state().boundariesCrossed) {
      typeRuntimeException_computed = true;
    } else {
    }

    return typeRuntimeException_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean typeRuntimeException_computed = false;
  /**
   * @apilevel internal
   */
  protected TypeDecl typeRuntimeException_value;
  /**
   * @attribute inh
   * @aspect ExceptionHandling
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/ExceptionHandling.jrag:24
   */
  public TypeDecl typeError() {
    if(typeError_computed) {
      return typeError_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    typeError_value = getParent().Define_TypeDecl_typeError(this, null);
    if (isFinal && num == state().boundariesCrossed) {
      typeError_computed = true;
    } else {
    }

    return typeError_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean typeError_computed = false;
  /**
   * @apilevel internal
   */
  protected TypeDecl typeError_value;
  /**
   * @attribute inh
   * @aspect LookupMethod
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupMethod.jrag:46
   */
  public Collection lookupMethod(String name) {
    Object _parameters = name;
    if (lookupMethod_String_values == null) lookupMethod_String_values = new org.jastadd.util.RobustMap(new java.util.HashMap());
    if(lookupMethod_String_values.containsKey(_parameters)) {
      return (Collection)lookupMethod_String_values.get(_parameters);
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    Collection lookupMethod_String_value = getParent().Define_Collection_lookupMethod(this, null, name);
    if (isFinal && num == state().boundariesCrossed) {
      lookupMethod_String_values.put(_parameters, lookupMethod_String_value);
    } else {
    }

    return lookupMethod_String_value;
  }
  protected java.util.Map lookupMethod_String_values;
  /**
   * @attribute inh
   * @aspect SpecialClasses
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:62
   */
  public TypeDecl typeInt() {
    ASTNode$State state = state();
    TypeDecl typeInt_value = getParent().Define_TypeDecl_typeInt(this, null);

    return typeInt_value;
  }
  /**
   * @attribute inh
   * @aspect SpecialClasses
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:65
   */
  public TypeDecl typeObject() {
    if(typeObject_computed) {
      return typeObject_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    typeObject_value = getParent().Define_TypeDecl_typeObject(this, null);
    if (isFinal && num == state().boundariesCrossed) {
      typeObject_computed = true;
    } else {
    }

    return typeObject_value;
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
   * @attribute inh
   * @aspect LookupFullyQualifiedTypes
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:101
   */
  public TypeDecl lookupType(String packageName, String typeName) {
    ASTNode$State state = state();
    TypeDecl lookupType_String_String_value = getParent().Define_TypeDecl_lookupType(this, null, packageName, typeName);

    return lookupType_String_String_value;
  }
  /**
   * @attribute inh
   * @aspect TypeScopePropagation
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:226
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
   * @aspect VariableScope
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupVariable.jrag:14
   */
  public SimpleSet lookupVariable(String name) {
    Object _parameters = name;
    if (lookupVariable_String_values == null) lookupVariable_String_values = new org.jastadd.util.RobustMap(new java.util.HashMap());
    if(lookupVariable_String_values.containsKey(_parameters)) {
      return (SimpleSet)lookupVariable_String_values.get(_parameters);
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    SimpleSet lookupVariable_String_value = getParent().Define_SimpleSet_lookupVariable(this, null, name);
    if (isFinal && num == state().boundariesCrossed) {
      lookupVariable_String_values.put(_parameters, lookupVariable_String_value);
    } else {
    }

    return lookupVariable_String_value;
  }
  protected java.util.Map lookupVariable_String_values;
  /**
   * @attribute inh
   * @aspect NameCheck
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/NameCheck.jrag:268
   */
  public boolean hasPackage(String packageName) {
    ASTNode$State state = state();
    boolean hasPackage_String_value = getParent().Define_boolean_hasPackage(this, null, packageName);

    return hasPackage_String_value;
  }
  /**
   * @attribute inh
   * @aspect NameCheck
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/NameCheck.jrag:271
   */
  public ASTNode enclosingBlock() {
    ASTNode$State state = state();
    ASTNode enclosingBlock_value = getParent().Define_ASTNode_enclosingBlock(this, null);

    return enclosingBlock_value;
  }
  /**
   * @attribute inh
   * @aspect TypeName
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/QualifiedNames.jrag:90
   */
  public String packageName() {
    if(packageName_computed) {
      return packageName_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    packageName_value = getParent().Define_String_packageName(this, null);
    if (isFinal && num == state().boundariesCrossed) {
      packageName_computed = true;
    } else {
    }

    return packageName_value;
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
   * @attribute inh
   * @aspect TypeAnalysis
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:216
   */
  public boolean isAnonymous() {
    if(isAnonymous_computed) {
      return isAnonymous_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    isAnonymous_value = getParent().Define_boolean_isAnonymous(this, null);
    if (isFinal && num == state().boundariesCrossed) {
      isAnonymous_computed = true;
    } else {
    }

    return isAnonymous_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean isAnonymous_computed = false;
  /**
   * @apilevel internal
   */
  protected boolean isAnonymous_value;
  /**
   * @attribute inh
   * @aspect NestedTypes
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:504
   */
  public TypeDecl enclosingType() {
    ASTNode$State state = state();
    TypeDecl enclosingType_value = getParent().Define_TypeDecl_enclosingType(this, null);

    return enclosingType_value;
  }
  /**
   * @attribute inh
   * @aspect NestedTypes
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:520
   */
  public BodyDecl enclosingBodyDecl() {
    ASTNode$State state = state();
    BodyDecl enclosingBodyDecl_value = getParent().Define_BodyDecl_enclosingBodyDecl(this, null);

    return enclosingBodyDecl_value;
  }
  /**
   * @attribute inh
   * @aspect NestedTypes
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:526
   */
  public boolean isNestedType() {
    ASTNode$State state = state();
    boolean isNestedType_value = getParent().Define_boolean_isNestedType(this, null);

    return isNestedType_value;
  }
  /**
   * @attribute inh
   * @aspect NestedTypes
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:534
   */
  public boolean isMemberType() {
    ASTNode$State state = state();
    boolean isMemberType_value = getParent().Define_boolean_isMemberType(this, null);

    return isMemberType_value;
  }
  /**
   * @attribute inh
   * @aspect NestedTypes
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:548
   */
  public boolean isLocalClass() {
    ASTNode$State state = state();
    boolean isLocalClass_value = getParent().Define_boolean_isLocalClass(this, null);

    return isLocalClass_value;
  }
  /**
   * @attribute inh
   * @aspect NestedTypes
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:573
   */
  public String hostPackage() {
    ASTNode$State state = state();
    String hostPackage_value = getParent().Define_String_hostPackage(this, null);

    return hostPackage_value;
  }
  /**
   * @attribute inh
   * @aspect Circularity
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:682
   */
  public TypeDecl unknownType() {
    if(unknownType_computed) {
      return unknownType_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    unknownType_value = getParent().Define_TypeDecl_unknownType(this, null);
    if (isFinal && num == state().boundariesCrossed) {
      unknownType_computed = true;
    } else {
    }

    return unknownType_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean unknownType_computed = false;
  /**
   * @apilevel internal
   */
  protected TypeDecl unknownType_value;
  /**
   * @attribute inh
   * @aspect TypeCheck
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeCheck.jrag:405
   */
  public TypeDecl typeVoid() {
    ASTNode$State state = state();
    TypeDecl typeVoid_value = getParent().Define_TypeDecl_typeVoid(this, null);

    return typeVoid_value;
  }
  /**
   * @attribute inh
   * @aspect TypeCheck
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeCheck.jrag:509
   */
  public TypeDecl enclosingInstance() {
    ASTNode$State state = state();
    TypeDecl enclosingInstance_value = getParent().Define_TypeDecl_enclosingInstance(this, null);

    return enclosingInstance_value;
  }
  /**
   * @attribute inh
   * @aspect TypeHierarchyCheck
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeHierarchyCheck.jrag:146
   */
  public boolean inExplicitConstructorInvocation() {
    if(inExplicitConstructorInvocation_computed) {
      return inExplicitConstructorInvocation_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    inExplicitConstructorInvocation_value = getParent().Define_boolean_inExplicitConstructorInvocation(this, null);
    if (isFinal && num == state().boundariesCrossed) {
      inExplicitConstructorInvocation_computed = true;
    } else {
    }

    return inExplicitConstructorInvocation_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean inExplicitConstructorInvocation_computed = false;
  /**
   * @apilevel internal
   */
  protected boolean inExplicitConstructorInvocation_value;
  /**
   * @attribute inh
   * @aspect TypeHierarchyCheck
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeHierarchyCheck.jrag:162
   */
  public boolean inStaticContext() {
    if(inStaticContext_computed) {
      return inStaticContext_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    inStaticContext_value = getParent().Define_boolean_inStaticContext(this, null);
    if (isFinal && num == state().boundariesCrossed) {
      inStaticContext_computed = true;
    } else {
    }

    return inStaticContext_value;
  }
  /**
   * @apilevel internal
   */
  protected boolean inStaticContext_computed = false;
  /**
   * @apilevel internal
   */
  protected boolean inStaticContext_value;
  /**
   * @attribute inh
   * @aspect Annotations
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Annotations.jrag:289
   */
  public boolean withinSuppressWarnings(String annot) {
    ASTNode$State state = state();
    boolean withinSuppressWarnings_String_value = getParent().Define_boolean_withinSuppressWarnings(this, null, annot);

    return withinSuppressWarnings_String_value;
  }
  /**
   * @attribute inh
   * @aspect Annotations
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Annotations.jrag:389
   */
  public boolean withinDeprecatedAnnotation() {
    ASTNode$State state = state();
    boolean withinDeprecatedAnnotation_value = getParent().Define_boolean_withinDeprecatedAnnotation(this, null);

    return withinDeprecatedAnnotation_value;
  }
  /**
   * @attribute inh
   * @aspect LookupParTypeDecl
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Generics.jrag:1176
   */
  public TypeDecl typeWildcard() {
    ASTNode$State state = state();
    TypeDecl typeWildcard_value = getParent().Define_TypeDecl_typeWildcard(this, null);

    return typeWildcard_value;
  }
  /**
   * @attribute inh
   * @aspect LookupParTypeDecl
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Generics.jrag:1189
   */
  public TypeDecl lookupWildcardExtends(TypeDecl typeDecl) {
    ASTNode$State state = state();
    TypeDecl lookupWildcardExtends_TypeDecl_value = getParent().Define_TypeDecl_lookupWildcardExtends(this, null, typeDecl);

    return lookupWildcardExtends_TypeDecl_value;
  }
  /**
   * @attribute inh
   * @aspect LookupParTypeDecl
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Generics.jrag:1202
   */
  public TypeDecl lookupWildcardSuper(TypeDecl typeDecl) {
    ASTNode$State state = state();
    TypeDecl lookupWildcardSuper_TypeDecl_value = getParent().Define_TypeDecl_lookupWildcardSuper(this, null, typeDecl);

    return lookupWildcardSuper_TypeDecl_value;
  }
  /**
   * @attribute inh
   * @aspect LookupParTypeDecl
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Generics.jrag:1222
   */
  public LUBType lookupLUBType(Collection bounds) {
    ASTNode$State state = state();
    LUBType lookupLUBType_Collection_value = getParent().Define_LUBType_lookupLUBType(this, null, bounds);

    return lookupLUBType_Collection_value;
  }
  /**
   * @attribute inh
   * @aspect LookupParTypeDecl
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Generics.jrag:1262
   */
  public GLBType lookupGLBType(ArrayList bounds) {
    ASTNode$State state = state();
    GLBType lookupGLBType_ArrayList_value = getParent().Define_GLBType_lookupGLBType(this, null, bounds);

    return lookupGLBType_ArrayList_value;
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Arrays.jrag:20
   * @apilevel internal
   */
  public TypeDecl Define_TypeDecl_componentType(ASTNode caller, ASTNode child) {
    if (caller == arrayType_value) {
      return this;
    }
    else {
      return getParent().Define_TypeDecl_componentType(this, caller);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DefiniteAssignment.jrag:20
   * @apilevel internal
   */
  public boolean Define_boolean_isDest(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return false;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DefiniteAssignment.jrag:30
   * @apilevel internal
   */
  public boolean Define_boolean_isSource(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return true;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DefiniteAssignment.jrag:252
   * @apilevel internal
   */
  public boolean Define_boolean_isDAbefore(ASTNode caller, ASTNode child, Variable v, BodyDecl b) {
     {
      int childIndex = this.getIndexOfChild(caller);
{
    //if(b instanceof MethodDecl || b instanceof MemberTypeDecl) {
    if(!v.isInstanceVariable() && !v.isClassVariable()) {
      if(v.hostType() != this)
        return isDAbefore(v);
      return false;
    }
    if(b instanceof FieldDeclaration && !((FieldDeclaration)b).isStatic() && v.isClassVariable())
      return true;

    if(b instanceof MethodDecl) {
      return true;
    }
    if(b instanceof MemberTypeDecl && v.isBlank() && v.isFinal() && v.hostType() == this)
      return true;
    if(v.isClassVariable() || v.isInstanceVariable()) {
      if(v.isFinal() &&  v.hostType() != this && instanceOf(v.hostType()))
        return true;

      boolean search = true;
      if (b instanceof ConstructorDecl) {
        search = false;
      }

      for (int i = getNumBodyDecl() - 1; i >= 0; --i) {
        BodyDecl decl = getBodyDecl(i);
        if (b == decl) {
          search = false;
          continue;
        }
        if (search) {
          continue;
        }
        if (decl instanceof FieldDeclaration) {
          FieldDeclaration f = (FieldDeclaration) decl;
          if ((v.isClassVariable() && f.isStatic()) || (v.isInstanceVariable() && !f.isStatic())) {
            boolean c = f.isDAafter(v);
            //System.err.println("DefiniteAssignment: is " + v.name() + " DA after index " + i + ", " + f + ": " + c);
            return c;
            //return f.isDAafter(v);
          }
        } else if (decl instanceof StaticInitializer && v.isClassVariable()) {
          StaticInitializer si = (StaticInitializer) decl;
          return si.isDAafter(v);
        } else if (decl instanceof InstanceInitializer && v.isInstanceVariable()) {
          InstanceInitializer ii = (InstanceInitializer) decl;
          return ii.isDAafter(v);
        }
      }
    }
    return isDAbefore(v);
  }
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DefiniteAssignment.jrag:732
   * @apilevel internal
   */
  public boolean Define_boolean_isDUbefore(ASTNode caller, ASTNode child, Variable v, BodyDecl b) {
     {
      int childIndex = this.getIndexOfChild(caller);
{
    if (b instanceof MethodDecl || b instanceof MemberTypeDecl) {
      return false;
    }
    if (v.isClassVariable() || v.isInstanceVariable()) {
      boolean search = true;
      if (b instanceof ConstructorDecl) {
        search = false;
      }

      for (int i = getNumBodyDecl() - 1; i >= 0; --i) {
        BodyDecl decl = getBodyDecl(i);
        if (b == decl) {
          search = false;
          continue;
        }
        if (search) {
          continue;
        }
        if (decl instanceof FieldDeclaration) {
          FieldDeclaration f = (FieldDeclaration) decl;
          //System.err.println("  working on field " + f.name() + " which is child " + i);
          if (f == v)
            return !f.hasInit();
          if ((v.isClassVariable() && f.isStatic()) || (v.isInstanceVariable() && !f.isStatic()))
            return f.isDUafter(v);
          //System.err.println("  field " + f.name() + " can not affect " + v.name());
        } else if (decl instanceof StaticInitializer && v.isClassVariable()) {
          StaticInitializer si = (StaticInitializer) decl;
          //System.err.println("  working on static initializer which is child " + i);
          return si.isDUafter(v);
        } else if (decl instanceof InstanceInitializer && v.isInstanceVariable()) {
          InstanceInitializer ii = (InstanceInitializer) decl;
          //System.err.println("  working on instance initializer which is child " + i);
          return ii.isDUafter(v);
        }
      }
    }
    //System.err.println("Reached TypeDecl when searching for DU for variable");
    return isDUbefore(v);
  }
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupConstructor.jrag:16
   * @apilevel internal
   */
  public Collection Define_Collection_lookupConstructor(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return constructors();
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupConstructor.jrag:20
   * @apilevel internal
   */
  public Collection Define_Collection_lookupSuperConstructor(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return lookupSuperConstructor();
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupMethod.jrag:54
   * @apilevel internal
   */
  public Collection Define_Collection_lookupMethod(ASTNode caller, ASTNode child, String name) {
    if (caller == getBodyDeclListNoTransform()) {
      int i = caller.getIndexOfChild(child);
      return unqualifiedLookupMethod(name);
    }
    else {
      return getParent().Define_Collection_lookupMethod(this, caller, name);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupType.jrag:324
   * @apilevel internal
   */
  public SimpleSet Define_SimpleSet_lookupType(ASTNode caller, ASTNode child, String name) {
    if (caller == getBodyDeclListNoTransform()) {
      int index = caller.getIndexOfChild(child);
      return localLookupType(name);
    }
    else {
      return getParent().Define_SimpleSet_lookupType(this, caller, name);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/LookupVariable.jrag:27
   * @apilevel internal
   */
  public SimpleSet Define_SimpleSet_lookupVariable(ASTNode caller, ASTNode child, String name) {
    if (caller == getBodyDeclListNoTransform()) {
      int i = caller.getIndexOfChild(child);
      {
    SimpleSet list = memberFields(name);
    if(!list.isEmpty()) return list;
    list = lookupVariable(name);
    if(inStaticContext() || isStatic())
      list = removeInstanceVariables(list);
    return list;
  }
    }
    else {
      return getParent().Define_SimpleSet_lookupVariable(this, caller, name);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:301
   * @apilevel internal
   */
  public boolean Define_boolean_mayBePublic(ASTNode caller, ASTNode child) {
    if (caller == getBodyDeclListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
      return false;
    }
    else if (caller == getModifiersNoTransform()) {
      return true;
    }
    else {
      return getParent().Define_boolean_mayBePublic(this, caller);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:302
   * @apilevel internal
   */
  public boolean Define_boolean_mayBeProtected(ASTNode caller, ASTNode child) {
    if (caller == getBodyDeclListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
      return false;
    }
    else if (caller == getModifiersNoTransform()) {
      return true;
    }
    else {
      return getParent().Define_boolean_mayBeProtected(this, caller);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:303
   * @apilevel internal
   */
  public boolean Define_boolean_mayBePrivate(ASTNode caller, ASTNode child) {
    if (caller == getBodyDeclListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
      return false;
    }
    else if (caller == getModifiersNoTransform()) {
      return true;
    }
    else {
      return getParent().Define_boolean_mayBePrivate(this, caller);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:306
   * @apilevel internal
   */
  public boolean Define_boolean_mayBeAbstract(ASTNode caller, ASTNode child) {
    if (caller == getBodyDeclListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
      return false;
    }
    else if (caller == getModifiersNoTransform()) {
      return true;
    }
    else {
      return getParent().Define_boolean_mayBeAbstract(this, caller);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:304
   * @apilevel internal
   */
  public boolean Define_boolean_mayBeStatic(ASTNode caller, ASTNode child) {
    if (caller == getBodyDeclListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
      return false;
    }
    else if (caller == getModifiersNoTransform()) {
      return true;
    }
    else {
      return getParent().Define_boolean_mayBeStatic(this, caller);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:309
   * @apilevel internal
   */
  public boolean Define_boolean_mayBeStrictfp(ASTNode caller, ASTNode child) {
    if (caller == getBodyDeclListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
      return false;
    }
    else if (caller == getModifiersNoTransform()) {
      return true;
    }
    else {
      return getParent().Define_boolean_mayBeStrictfp(this, caller);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:305
   * @apilevel internal
   */
  public boolean Define_boolean_mayBeFinal(ASTNode caller, ASTNode child) {
    if (caller == getBodyDeclListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
      return false;
    }
    else {
      return getParent().Define_boolean_mayBeFinal(this, caller);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:307
   * @apilevel internal
   */
  public boolean Define_boolean_mayBeVolatile(ASTNode caller, ASTNode child) {
    if (caller == getBodyDeclListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
      return false;
    }
    else {
      return getParent().Define_boolean_mayBeVolatile(this, caller);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:308
   * @apilevel internal
   */
  public boolean Define_boolean_mayBeTransient(ASTNode caller, ASTNode child) {
    if (caller == getBodyDeclListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
      return false;
    }
    else {
      return getParent().Define_boolean_mayBeTransient(this, caller);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:310
   * @apilevel internal
   */
  public boolean Define_boolean_mayBeSynchronized(ASTNode caller, ASTNode child) {
    if (caller == getBodyDeclListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
      return false;
    }
    else {
      return getParent().Define_boolean_mayBeSynchronized(this, caller);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:311
   * @apilevel internal
   */
  public boolean Define_boolean_mayBeNative(ASTNode caller, ASTNode child) {
    if (caller == getBodyDeclListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
      return false;
    }
    else {
      return getParent().Define_boolean_mayBeNative(this, caller);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/NameCheck.jrag:323
   * @apilevel internal
   */
  public VariableScope Define_VariableScope_outerScope(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return this;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/NameCheck.jrag:396
   * @apilevel internal
   */
  public boolean Define_boolean_insideLoop(ASTNode caller, ASTNode child) {
    if (caller == getBodyDeclListNoTransform()) {
      int i = caller.getIndexOfChild(child);
      return false;
    }
    else {
      return getParent().Define_boolean_insideLoop(this, caller);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/NameCheck.jrag:403
   * @apilevel internal
   */
  public boolean Define_boolean_insideSwitch(ASTNode caller, ASTNode child) {
    if (caller == getBodyDeclListNoTransform()) {
      int i = caller.getIndexOfChild(child);
      return false;
    }
    else {
      return getParent().Define_boolean_insideSwitch(this, caller);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/SyntacticClassification.jrag:118
   * @apilevel internal
   */
  public NameType Define_NameType_nameType(ASTNode caller, ASTNode child) {
    if (caller == getBodyDeclListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
      return NameType.EXPRESSION_NAME;
    }
    else {
      return getParent().Define_NameType_nameType(this, caller);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:218
   * @apilevel internal
   */
  public boolean Define_boolean_isAnonymous(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return false;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:500
   * @apilevel internal
   */
  public TypeDecl Define_TypeDecl_enclosingType(ASTNode caller, ASTNode child) {
    if (caller == getBodyDeclListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
      return this;
    }
    else {
      return getParent().Define_TypeDecl_enclosingType(this, caller);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:528
   * @apilevel internal
   */
  public boolean Define_boolean_isNestedType(ASTNode caller, ASTNode child) {
    if (caller == getBodyDeclListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
      return true;
    }
    else {
      return getParent().Define_boolean_isNestedType(this, caller);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:550
   * @apilevel internal
   */
  public boolean Define_boolean_isLocalClass(ASTNode caller, ASTNode child) {
    if (caller == getBodyDeclListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
      return false;
    }
    else {
      return getParent().Define_boolean_isLocalClass(this, caller);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeAnalysis.jrag:579
   * @apilevel internal
   */
  public TypeDecl Define_TypeDecl_hostType(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return this;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeCheck.jrag:407
   * @apilevel internal
   */
  public TypeDecl Define_TypeDecl_returnType(ASTNode caller, ASTNode child) {
    if (caller == getBodyDeclListNoTransform()) {
      int childIndex = caller.getIndexOfChild(child);
      return typeVoid();
    }
    else {
      return getParent().Define_TypeDecl_returnType(this, caller);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeCheck.jrag:513
   * @apilevel internal
   */
  public TypeDecl Define_TypeDecl_enclosingInstance(ASTNode caller, ASTNode child) {
    if (caller == getBodyDeclListNoTransform()) {
      int index = caller.getIndexOfChild(child);
      {
    if(getBodyDecl(index) instanceof MemberTypeDecl && !((MemberTypeDecl)getBodyDecl(index)).typeDecl().isInnerType())
      return null;
    if(getBodyDecl(index) instanceof ConstructorDecl)
      return enclosingInstance();
    return this;
  }
    }
    else {
      return getParent().Define_TypeDecl_enclosingInstance(this, caller);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeHierarchyCheck.jrag:12
   * @apilevel internal
   */
  public String Define_String_methodHost(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return typeName();
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/TypeHierarchyCheck.jrag:165
   * @apilevel internal
   */
  public boolean Define_boolean_inStaticContext(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return isStatic() || inStaticContext();
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/UnreachableStatements.jrag:159
   * @apilevel internal
   */
  public boolean Define_boolean_reportUnreachable(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return true;
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Annotations.jrag:74
   * @apilevel internal
   */
  public boolean Define_boolean_mayUseAnnotationTarget(ASTNode caller, ASTNode child, String name) {
    if (caller == getModifiersNoTransform()) {
      return name.equals("TYPE");
    }
    else {
      return getParent().Define_boolean_mayUseAnnotationTarget(this, caller, name);
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/Helpers.jrag:19
   * @apilevel internal
   */
  public BitSet Define_BitSet_emptyBitSet(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return emptyBitSet();
    }
  }
  /**
   * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.4.jrag:38
   * @apilevel internal
   */
  public SmallSet<CFGNode> Define_SmallSet_CFGNode__following(ASTNode caller, ASTNode child) {
     {
      int childIndex = this.getIndexOfChild(caller);
      return SmallSet.empty();
    }
  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {    return super.rewriteTo();
  }}
