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
 * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java5/grammar/Enums.ast:3
 * @production EnumConstant : {@link FieldDeclaration} ::= <span class="component">{@link Modifiers}</span> <span class="component">&lt;ID:String&gt;</span> <span class="component">Arg:{@link Expr}*</span> <span class="component">[Init:{@link Expr}]</span> <span class="component">TypeAccess:{@link Access}</span>;

 */
public class EnumConstant extends FieldDeclaration implements Cloneable {
  /**
   * @aspect Enums
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Enums.jrag:200
   */
  public EnumConstant(Modifiers mods, String name, List<Expr> args, List<BodyDecl> bds) {
    this(mods, name, args, new Opt<Expr>(new EnumInstanceExpr(createOptAnonymousDecl(bds))));
  }
  /**
   * @aspect Enums
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Enums.jrag:239
   */
  private static Opt<TypeDecl> createOptAnonymousDecl(List<BodyDecl> bds) {
    if(bds.getNumChildNoTransform() == 0)
      return new Opt<TypeDecl>();
    return new Opt<TypeDecl>(
      new AnonymousDecl(
        new Modifiers(),
        "Anonymous",
        bds
      )
    );
  }
  /**
   * @aspect Enums
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Enums.jrag:252
   */
  public int getNumBodyDecl() {
    int cnt = 0;
    ClassInstanceExpr init = (ClassInstanceExpr)getInit();
    if(!init.hasTypeDecl())
      return 0;
    for(BodyDecl bd : init.getTypeDecl().getBodyDecls())
      if(!(bd instanceof ConstructorDecl))
        ++cnt;
    return cnt;
  }
  /**
   * @aspect Enums
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Enums.jrag:263
   */
  public BodyDecl getBodyDecl(int i) {
    ClassInstanceExpr init = (ClassInstanceExpr)getInit();
    if(init.hasTypeDecl())
      for(BodyDecl bd : init.getTypeDecl().getBodyDecls())
        if(!(bd instanceof ConstructorDecl))
          if(i-- == 0)
            return bd;
    throw new ArrayIndexOutOfBoundsException(i);
  }
  /**
   * @aspect Enums
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Enums.jrag:595
   */
  public void prettyPrint(StringBuffer sb) {
    sb.append(indent());
    getModifiers().prettyPrint(sb);
    sb.append(getID());
    sb.append("(");
    if (getNumArg() > 0) {
      getArg(0).prettyPrint(sb);
      for (int i = 1; i < getNumArg(); i++) {
        sb.append(", ");
        getArg(i).prettyPrint(sb);
      }
    }
    sb.append(")");
    if (getNumBodyDecl() > 0) {
      sb.append(" {");
      for (int i=0; i < getNumBodyDecl(); i++) {
        BodyDecl d = getBodyDecl(i);
        d.prettyPrint(sb);
      }
      sb.append(indent() + "}");
    }
    sb.append(",\n");
  }
  /**
   * @declaredat ASTNode:1
   */
  public EnumConstant() {
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
    children = new ASTNode[4];
    setChild(new List(), 1);
    setChild(new Opt(), 2);
  }
  /**
   * @declaredat ASTNode:15
   */
  public EnumConstant(Modifiers p0, String p1, List<Expr> p2, Opt<Expr> p3) {
    setChild(p0, 0);
    setID(p1);
    setChild(p2, 1);
    setChild(p3, 2);
  }
  /**
   * @declaredat ASTNode:21
   */
  public EnumConstant(Modifiers p0, beaver.Symbol p1, List<Expr> p2, Opt<Expr> p3) {
    setChild(p0, 0);
    setID(p1);
    setChild(p2, 1);
    setChild(p3, 2);
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:30
   */
  protected int numChildren() {
    return 3;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:36
   */
  public boolean mayHaveRewrite() {
    return false;
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:42
   */
  public void flushCache() {
    super.flushCache();
    getTypeAccess_computed = false;
    getTypeAccess_value = null;
    localMethodsSignatureMap_computed = false;
    localMethodsSignatureMap_value = null;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:52
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:58
   */
  public EnumConstant clone() throws CloneNotSupportedException {
    EnumConstant node = (EnumConstant) super.clone();
    node.getTypeAccess_computed = false;
    node.getTypeAccess_value = null;
    node.localMethodsSignatureMap_computed = false;
    node.localMethodsSignatureMap_value = null;
    node.in$Circle(false);
    node.is$Final(false);
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:71
   */
  public EnumConstant copy() {
    try {
      EnumConstant node = (EnumConstant) clone();
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
   * @declaredat ASTNode:89
   */
  public EnumConstant fullCopy() {
    EnumConstant tree = (EnumConstant) copy();
    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
        switch (i) {
        case 3:
          tree.children[i] = null;
          continue;
        }
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
   * Replaces the lexeme ID.
   * @param value The new value for the lexeme ID.
   * @apilevel high-level
   */
  public void setID(String value) {
    tokenString_ID = value;
  }
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
   * Replaces the Arg list.
   * @param list The new list node to be used as the Arg list.
   * @apilevel high-level
   */
  public void setArgList(List<Expr> list) {
    setChild(list, 1);
  }
  /**
   * Retrieves the number of children in the Arg list.
   * @return Number of children in the Arg list.
   * @apilevel high-level
   */
  public int getNumArg() {
    return getArgList().getNumChild();
  }
  /**
   * Retrieves the number of children in the Arg list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the Arg list.
   * @apilevel low-level
   */
  public int getNumArgNoTransform() {
    return getArgListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the Arg list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the Arg list.
   * @apilevel high-level
   */
  public Expr getArg(int i) {
    return (Expr) getArgList().getChild(i);
  }
  /**
   * Check whether the Arg list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasArg() {
    return getArgList().getNumChild() != 0;
  }
  /**
   * Append an element to the Arg list.
   * @param node The element to append to the Arg list.
   * @apilevel high-level
   */
  public void addArg(Expr node) {
    List<Expr> list = (parent == null || state == null) ? getArgListNoTransform() : getArgList();
    list.addChild(node);
  }
  /**
   * @apilevel low-level
   */
  public void addArgNoTransform(Expr node) {
    List<Expr> list = getArgListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the Arg list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setArg(Expr node, int i) {
    List<Expr> list = getArgList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the Arg list.
   * @return The node representing the Arg list.
   * @apilevel high-level
   */
  public List<Expr> getArgList() {
    List<Expr> list = (List<Expr>) getChild(1);
    list.getNumChild();
    return list;
  }
  /**
   * Retrieves the Arg list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Arg list.
   * @apilevel low-level
   */
  public List<Expr> getArgListNoTransform() {
    return (List<Expr>) getChildNoTransform(1);
  }
  /**
   * Retrieves the Arg list.
   * @return The node representing the Arg list.
   * @apilevel high-level
   */
  public List<Expr> getArgs() {
    return getArgList();
  }
  /**
   * Retrieves the Arg list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Arg list.
   * @apilevel low-level
   */
  public List<Expr> getArgsNoTransform() {
    return getArgListNoTransform();
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
  /**
   * Replaces the TypeAccess child.
   * @param node The new node to replace the TypeAccess child.
   * @apilevel high-level
   */
  public void setTypeAccess(Access node) {
    setChild(node, 3);
  }
  /**
   * Retrieves the TypeAccess child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the TypeAccess child.
   * @apilevel low-level
   */
  public Access getTypeAccessNoTransform() {
    return (Access) getChildNoTransform(3);
  }
  /**
   * Retrieves the child position of the optional child TypeAccess.
   * @return The the child position of the optional child TypeAccess.
   * @apilevel low-level
   */
  protected int getTypeAccessChildPosition() {
    return 3;
  }
  /**
   * @attribute syn
   * @aspect Enums
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Enums.jrag:26
   */
  public boolean isEnumConstant() {
    ASTNode$State state = state();
    try {  return true;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect Modifiers
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:239
   */
  public boolean isPublic() {
    ASTNode$State state = state();
    try {  return true;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect Modifiers
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:242
   */
  public boolean isStatic() {
    ASTNode$State state = state();
    try {  return true;  }
    finally {
    }
  }
  /**
   * @attribute syn
   * @aspect Modifiers
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Modifiers.jrag:244
   */
  public boolean isFinal() {
    ASTNode$State state = state();
    try {  return true;  }
    finally {
    }
  }
  /**
   * @apilevel internal
   */
  protected boolean getTypeAccess_computed = false;
  /**
   * @apilevel internal
   */
  protected Access getTypeAccess_value;
  /**
   * @attribute syn nta
   * @aspect Enums
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Enums.jrag:196
   */
  public Access getTypeAccess() {
    if(getTypeAccess_computed) {
      return (Access) getChild(getTypeAccessChildPosition());
    }
    if(getTypeAccess_computed) {
      return getTypeAccess_value;
    }
    ASTNode$State state = state();
    int num = state.boundariesCrossed;
    boolean isFinal = this.is$Final();
    getTypeAccess_value = getTypeAccess_compute();
      setTypeAccess(getTypeAccess_value);
    if (isFinal && num == state().boundariesCrossed) {
      getTypeAccess_computed = true;
    } else {
    }

    Access node = (Access) this.getChild(getTypeAccessChildPosition());
    return node;
  }
  /**
   * @apilevel internal
   */
  private Access getTypeAccess_compute() {
      return hostType().createQualifiedAccess();
    }
  /**
   * @attribute syn
   * @aspect Enums
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Enums.jrag:692
   */
  public SimpleSet localMethodsSignature(String signature) {
    ASTNode$State state = state();
    try {
        SimpleSet set = (SimpleSet)localMethodsSignatureMap().get(signature);
        if(set != null) return set;
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
  protected HashMap localMethodsSignatureMap_value;
  /**
   * @attribute syn
   * @aspect Enums
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Enums.jrag:699
   */
  public HashMap localMethodsSignatureMap() {
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
  private HashMap localMethodsSignatureMap_compute() {
      HashMap map = new HashMap(getNumBodyDecl());
      for(int i = 0; i < getNumBodyDecl(); i++) {
        if(getBodyDecl(i) instanceof MethodDecl) {
          MethodDecl decl = (MethodDecl)getBodyDecl(i);
          map.put(decl.signature(), decl);
        }
      }
      return map;
    }
  /**
   * @attribute syn
   * @aspect Enums
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Enums.jrag:710
   */
  public boolean implementsMethod(MethodDecl method) {
    ASTNode$State state = state();
    try {
        SimpleSet set = (SimpleSet)localMethodsSignature(method.signature());
        if (set.size() == 1) {
          MethodDecl n = (MethodDecl)set.iterator().next();
          if (!n.isAbstract())
      return true;
        }
        return false;
      }
    finally {
    }
  }
  /**
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/Enums.jrag:492
   * @apilevel internal
   */
  public NameType Define_NameType_nameType(ASTNode caller, ASTNode child) {
    if (caller == getTypeAccessNoTransform()) {
      return NameType.TYPE_NAME;
    }
    else {
      return super.Define_NameType_nameType(caller, child);
    }
  }
  /**
   * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/JavaCFG1.5.jrag:15
   * @apilevel internal
   */
  public SmallSet<CFGNode> Define_SmallSet_CFGNode__following(ASTNode caller, ASTNode child) {
    if (caller == getInitOptNoTransform()) {
      return SmallSet.<CFGNode>singleton(exit());
    }
    else if (caller == getArgListNoTransform()) {
      int i = caller.getIndexOfChild(child);
      return i + 1 < getNumArg() ?
			SmallSet.<CFGNode>singleton(getArg(i + 1)) : 
                hasInit() ? SmallSet.<CFGNode>singleton(getInit()) : 
                    SmallSet.<CFGNode>singleton(exit());
    }
    else if (caller == entry_value) {
      return getNumArg() > 0 ? 
        SmallSet.<CFGNode>singleton(getArg(0)) : 
            hasInit() ? SmallSet.<CFGNode>singleton(getInit()) : 
                SmallSet.<CFGNode>singleton(exit());
    }
    else {
      return super.Define_SmallSet_CFGNode__following(caller, child);
    }
  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {    return super.rewriteTo();
  }}
