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
 * Concrete subclass of FolderPath. Represents a classfile folder.
 * @ast class
 * @aspect PathPart
 * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/PathPart.jadd:460
 */
public class ClassFolderPath extends FolderPath {

    /**
     * Construct a new classfile folder path.
     * @param path
     */
    public ClassFolderPath(String path) {
      super(path, false);
    }


}