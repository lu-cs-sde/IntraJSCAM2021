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
 * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/PathPart.jadd:226
 */
public class JarClassSource extends BytecodeClassSource {

    private final ZipFile jar;


    private final ZipEntry entry;


    private final String jarPath;



    public JarClassSource(PathPart sourcePath, ZipFile jar, ZipEntry entry,
        String jarPath) {
      super(sourcePath);
      this.jar = jar;
      this.entry = entry;
      this.jarPath = jarPath;
    }



    public String jarFilePath() {
      return entry.getName();
    }



    @Override
    public long getAge() {
      return entry.getTime();
    }



    @Override
    public InputStream openInputStream() throws IOException {
      return jar.getInputStream(entry);
    }



    @Override
    public String pathName() {
      return jarPath;
    }



    @Override
    public String relativeName() {
      return entry.getName();
    }



    @Override
    public String sourceName() {
      return pathName() + ":" + relativeName();
    }


}
