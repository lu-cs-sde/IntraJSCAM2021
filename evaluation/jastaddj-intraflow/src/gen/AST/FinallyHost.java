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
 * @ast interface
 * @aspect DU
 * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/DefiniteAssignment.jrag:948
 */
 interface FinallyHost {

    //public Block getFinally();
     
    //public Block getFinally();
    public boolean isDUafterFinally(Variable v);

     
    public boolean isDAafterFinally(Variable v);

     
    public FinallyHost enclosingFinally(Stmt branch);

     
    public Block getFinallyBlock();
}
