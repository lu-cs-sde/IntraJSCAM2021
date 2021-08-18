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
 * @aspect Constant
 * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/jastaddj/java4/frontend/Constant.jadd:11
 */
 class Constant extends java.lang.Object {

    static class ConstantInt extends Constant {
      private int value;
      public ConstantInt(int i) { this.value = i; }
      int intValue() { return value; }
      long longValue() { return value; }
      float floatValue() { return value; }
      double doubleValue() { return value; }
      String stringValue() { return new Integer(value).toString(); }
      Literal buildLiteral() { return new IntegerLiteral(stringValue()); }
    }


    static class ConstantLong extends Constant {
      private long value;
      public ConstantLong(long l) { this.value = l; }
      int intValue() { return (int)value; }
      long longValue() { return value; }
      float floatValue() { return value; }
      double doubleValue() { return value; }
      String stringValue() { return new Long(value).toString(); }
      Literal buildLiteral() { return new LongLiteral(stringValue()); }
    }


    static class ConstantFloat extends Constant {
      private float value;
      public ConstantFloat(float f) { this.value = f; }
      int intValue() { return (int)value; }
      long longValue() { return (long)value; }
      float floatValue() { return value; }
      double doubleValue() { return value; }
      String stringValue() { return new Float(value).toString(); }
      Literal buildLiteral() { return new FloatingPointLiteral(stringValue()); }
    }


    static class ConstantDouble extends Constant {
      private double value;
      public ConstantDouble(double d) { this.value = d; }
      int intValue() { return (int)value; }
      long longValue() { return (long)value; }
      float floatValue() { return (float)value; }
      double doubleValue() { return value; }
      String stringValue() { return new Double(value).toString(); }
      Literal buildLiteral() { return new DoubleLiteral(stringValue()); }
    }


    static class ConstantChar extends Constant {
      private char value;
      public ConstantChar(char c) { this.value = c; }
      int intValue() { return value; }
      long longValue() { return value; }
      float floatValue() { return value; }
      double doubleValue() { return value; }
      String stringValue() { return new Character(value).toString(); }
      Literal buildLiteral() { return new CharacterLiteral(stringValue()); }
    }


    static class ConstantBoolean extends Constant {
      private boolean value;
      public ConstantBoolean(boolean b) { this.value = b; }
      boolean booleanValue() { return value; }
      String stringValue() { return new Boolean(value).toString(); }
      Literal buildLiteral() { return new BooleanLiteral(stringValue()); }
    }


    static class ConstantString extends Constant {
      private String value;
      public ConstantString(String s) { this.value = s; }
      String stringValue() { return value; }
      Literal buildLiteral() { return new StringLiteral(stringValue()); }
    }



    int intValue() { throw new UnsupportedOperationException(); }


    long longValue() { throw new UnsupportedOperationException(); }


    float floatValue() { throw new UnsupportedOperationException(); }


    double doubleValue() { throw new UnsupportedOperationException(); }


    boolean booleanValue() { throw new UnsupportedOperationException(getClass().getName()); }


    String stringValue() { throw new UnsupportedOperationException(); }


    Literal buildLiteral() { throw new UnsupportedOperationException(); }



    protected Constant() {
    }



    public boolean error = false;



    static Constant create(int i) { return new ConstantInt(i); }


    static Constant create(long l) { return new ConstantLong(l); }


    static Constant create(float f) { return new ConstantFloat(f); }


    static Constant create(double d) { return new ConstantDouble(d); }


    static Constant create(boolean b) { return new ConstantBoolean(b); }


    static Constant create(char c) { return new ConstantChar(c); }


    static Constant create(String s) { return new ConstantString(s); }


}
