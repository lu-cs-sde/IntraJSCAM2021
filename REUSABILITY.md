# IntraJ and IntraCFG Reusability
**IntraJ** and **IntraCFG** were designed, taking into consideration reusability.
In this file, will describe how **IntraJ** and **IntraCFG** can be reused.


## Apply the IntraCFG framework to a new language
The intraprocedural framework **IntraCFG** is language-independent. 
Therfore, can be applied to any imperative langauge.

## Extending the language with a new constructor
An example is the feature added in each Java version. Le us consider the differences between _Java 4_ and _Java 5_.
The only constructor that affects the Control Flow Graph construction is the _enhanced for_ statement. 
In _ExtendJ_ abstract grammar, this is defined as follow:

```
EnhancedFor:BranchTargetStmt::=VarDecl Expr Stmt;
```

Extending _Java 4_ to support _Java 5_ requires adding these new few lines of code:
```
aspect CFG_java5 {
  EnhancedForStmt implements CFGNode;
  EnumConstant implements CFGNode;

  eq EnhancedForStmt.firstNodes() = getExpr().firstNodes();
  eq EnhancedForStmt.getExpr().nextNodesTT() = getVariableDecl().firstNodes();
  eq EnhancedForStmt.getExpr().nextNodesFF() = nextNodes();
  eq EnhancedForStmt.getExpr().nextNodes() = getExpr().jointTrueFalse();
  eq EnhancedForStmt.getStmt().nextNodes() = getExpr().firstNodes();
  eq EnhancedForStmt.getVariableDecl().nextNodes() = getStmt().firstNodes();
  eq EnhancedForStmt.nextContinue() = getExpr().firstNodes();
}

```
We can reuse _Java 4_ module combined with the new _Java 5_ module to analyze any Java 5 programs.


## Use IntraJ for analyzing Java projects
You can use **IntraJ** to analyze any Java [4-7] project. 
Evaluation projects can be found in `IntraJSCAM2021/evaluation`.

We analysed several projects ([Table I](https://github.com/lu-cs-sde/IntraJSCAM2021/blob/main/intraj-preprint.pdf)), such as:

| Project      | Version          |      LOC  |
| :---         |     :---:        | :---:     |
| ANTRL        |  2.7.2           |     33737 |
| PMD          |  4.2             |     49610 |
| JFreeChart   |  1.0             |     95664 |
| FOP          |  0.95            |     97288 |

More can be read about the evaluation in Section IV of the **IntraJ** and **IntraCFG** [paper](https://github.com/lu-cs-sde/IntraJSCAM2021/blob/main/intraj-preprint.pdf).


## Use the CFG to write your analysis
In **IntraJ**, you can easily create your own analysis. 


### Example: counting non-reachable CFGNodes (NRCFG)
We want to define a new analysis that for each CFGRoots counts the number of CFGNodes
that are not reachable from the entry point.

In order:

1) Navigate to `IntraJSCAM2021/`
2)  Open `src/jastadd/DataFlow/Analysis.jrag`
3) Add to the Analysis enumeration the identifier of your analysis, i.e., `NRCFG`
```java
public
  enum Analysis {
    DAA,
    NPA,
    NRCFG;

    //...
  }
```
To the same file add the collection attribute that collects all the warning generated in a compilation unit.
```java
 coll Set<WarningMsg> CompilationUnit.NRCFG()[new TreeSet<WarningMsg>()] with add root CompilationUnit;
```

5) Create a new file in `src/jastadd/DataFlow/` called `NonReachabelCFG.jrag`
```java
aspect NumbOfSuccessors {
  //Collects all the CFGNodes that are not in the CFG.
  coll SmallSet<CFGNode> CFGRoot.nonReachableNodes()[SmallSet.<CFGNode>mutable()] with add root CompilationUnit;
  CFGNode contributes this when !isCFGNode() to CFGRoot.nonReachableNodes() for getRoot();

  //Each CFGRoot generates a warning with the number of non-reachable CFGNodes
  CFGRoot contributes warning(getCompilationUnit().pathName(),
      "The method '" + name() + "' has " + nonReachableNodes().size() +" non-reachableble nodes.", Analysis.NRCFG) 
      to CompilationUnit.NRCFG();

  //The CFGRoot reference is inherited by all its CFGNode children
  inh CFGRoot CFGNode.getRoot();
  eq CFGRoot.getChild().getRoot() = this;
  eq Program.getChild().getRoot() = null;

  //The CompilationUnit reference is inherited by all its CFGRoot children
  inh CompilationUnit CFGRoot.getCompilationUnit();
  eq CompilationUnit.getChild().getCompilationUnit() = this;
}
```

Run `./gradlew build`  to compile **IntraJ**.

Now run and test your extension:
```
java -jar intraj.jar PATH/TO/Example.java -WNRCFG -succ -pred
```
**IntraJ** will print, for each `CFGRoot`, a warning starting with the `NRCFG` identifier.

## Use the results of existing analyses to write a new one
It is possible to reuse results and attributes defined in other analyses to create a new one.

For example, we can modify the previous analysis and count the number of `VarAccess` that might be bull
and report it with the total number of non-reachable nodes.

```java
aspect NumbOfSuccessors {
  //Colects all the CFGNodes that are not in the CFG.
  coll SmallSet<CFGNode> CFGRoot.nonReachableNodes()[SmallSet.<CFGNode>mutable()] with add root CompilationUnit;
  CFGNode contributes this when !isCFGNode() to CFGRoot.nonReachableNodes() for getRoot();
 
  //The attribute `isNullable` is defined in src/jastadd/DataFlow/NullAnlaysis.jrag
  coll SmallSet<CFGNode> CFGRoot.nullableNodes()[SmallSet.<CFGNode>mutable()] with add root CompilationUnit;
  VarAccess contributes this when isNullable() to CFGRoot.nullableNodes() for getRoot();

  //Each CFGRoot generates a warning with the total number of nodes that are not reachable and at the same time nullable.
  CFGRoot contributes warning(getCompilationUnit().pathName(),
       "The method '" + name() + "' has " + nonReachableNodes().size() +" non-reachable node and "+ nullableNodes().size() + " nodes that might be null",
        Analysis.NRCFG) to CompilationUnit.NRCFG();

  ...
}
```
As before, run `./gradlew build`  to compile **IntraJ**.

Now run and test your extension:
```
java -jar intraj.jar PATH/TO/Example.java -WNRCFG -succ -pred
```
**IntraJ** will print, for each `CFGRoot`, a warning starting with the `NRCFG` identifier.