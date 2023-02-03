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
 * @ast class
 * @aspect PathPart
 * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/PathPart.jadd:199
 */
public class FileBytecodeClassSource extends BytecodeClassSource {

    private final String filePath;



    public FileBytecodeClassSource(PathPart sourcePath, String path) {
      super(sourcePath);
      this.filePath = path;
    }



    @Override
    public long getAge() {
      // last modification time computed only when needed
      File file = new File(filePath);
      return file.lastModified();
    }



    @Override
    public InputStream openInputStream() throws IOException {
      File file = new File(filePath);
      return new FileInputStream(file);
    }



    @Override
    public String pathName() {
      return filePath;
    }


}
