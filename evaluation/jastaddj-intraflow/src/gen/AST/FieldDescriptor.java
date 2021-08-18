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
 * @aspect BytecodeDescriptor
 * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java5/frontend/BytecodeDescriptor.jrag:12
 */
 class FieldDescriptor extends java.lang.Object {

    private BytecodeParser p;


    String typeDescriptor;



    public FieldDescriptor(BytecodeParser parser, String name) {
      p = parser;
      int descriptor_index = p.u2();
      typeDescriptor = ((CONSTANT_Utf8_Info) p.constantPool[descriptor_index]).string();
      if(BytecodeParser.VERBOSE)
        p.println("  Field: " + name + ", " + typeDescriptor);
    }



    public Access type() {
      return new TypeDescriptor(p, typeDescriptor).type();
    }



    public boolean isBoolean() {
      return new TypeDescriptor(p, typeDescriptor).isBoolean();
    }


}
