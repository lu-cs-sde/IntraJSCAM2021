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
 * @aspect BytecodeCONSTANT
 * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/BytecodeCONSTANT.jrag:245
 */
 class CONSTANT_Utf8_Info extends CONSTANT_Info {

    public String string;



    public CONSTANT_Utf8_Info(BytecodeParser parser) {
      super(parser);
      string = p.readUTF();
    }



    public String toString() {
      return "Utf8Info: " + string;
    }



    public Expr expr() {
      return Literal.buildStringLiteral(string);
    }



    public String string() {
      return string;
    }


}
