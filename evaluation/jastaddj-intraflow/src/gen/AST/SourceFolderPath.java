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
 * Concrete subclass of FolderPath. Represents a source file folder.
 * @ast class
 * @aspect PathPart
 * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/PathPart.jadd:447
 */
public class SourceFolderPath extends FolderPath {

    /**
     * Construct a new source file folder path.
     * @param path
     */
    public SourceFolderPath(String path) {
      super(path, true);
    }


}
