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
 * A file specified explicitly on the commandline as a source file.
 * Must point to a .java file.
 * @ast class
 * @aspect PathPart
 * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/PathPart.jadd:554
 */
public class SourceFilePath extends PathPart {

    private final String filePath;



    public SourceFilePath(String path) {
      super(true);
      this.filePath = path;
    }



    @Override
    public String getPath() {
      return filePath;
    }



    /**
     * <b>Use the parsed CompilationUnit to find the package name of the file!
     */
    @Override
    public boolean hasPackage(String name) {
      return false;
    }



    @Override
    public ClassSource findSource(String name) {
      if (filePath.equals(name)) {
        File file = new File(filePath);
        if (file.isFile() && file.canRead()) {
          return new FileClassSource(this, filePath);
        }
      }
      return ClassSource.NONE;
    }



    @Override
    public String toString() {
      return filePath;
    }


}
