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
 * @aspect Sets
 * @declaredat /Users/idrissr/phd/git/lund/research/artifacts/IntraJSCAM2021/evaluation/jastaddj-intraflow/src/jastadd/Sets.jrag:246
 */
public class SmallSet<T> extends java.lang.Object implements Iterable<T> {

    HashSet<T> set = new HashSet<T>();


    public String toString() { return set.toString(); }


    public Iterator<T> iterator() { return set.iterator(); }


    public int size() { return set.size(); }


    public boolean subsetOf(SmallSet<? extends T> that) {
        for(T x : set)
            if(!that.contains(x))
                return false;
        return true;
    }


    @SuppressWarnings("unchecked")
    public static <T> SmallSet<T> empty() {
      return new SmallSet<T>() {
        public boolean equals(Object o) { return o instanceof SmallSet && ((SmallSet)o).isEmpty(); }
        public SmallSet union(SmallSet set) { return set; }
        public SmallSet union(Object element) { return new SmallSet().union(element); }
        public SmallSet compl(SmallSet set) { return this; }
        public SmallSet compl(Object element) { return this; }
        public SmallSet intersect(SmallSet set) { return this; }
        public boolean isEmpty() { return true; }
        public boolean isSingleton() { return false; }
        public void add(T t) { throw new UnsupportedOperationException("emptySet.add(T)"); }
        public void add(SmallSet<T> x) { throw new UnsupportedOperationException("emptySet.add(SmallSet<T>)"); }
        public int size() { return 0; }
        public boolean subsetOf(SmallSet<? extends T> that) { return true; }
      };
    }


    @SuppressWarnings("unchecked")
    public static <T> SmallSet<T> full() { return fullSet; }


    @SuppressWarnings("unchecked")
    private static SmallSet fullSet = new SmallSet() {
      public String toString() { return "full set"; }
      public SmallSet union(SmallSet set) { return this; }
      public SmallSet union(Object element) { return this; }
      public SmallSet compl(SmallSet set) {
    	  throw new Error("compl not supported for the full set");
      }
      public SmallSet compl(Object element) {
        throw new Error("compl not supported for the full set");
      }
      public SmallSet intersect(SmallSet set) { return set; }
      public boolean isEmpty() { return false; }
      public boolean isSingleton() { return false; }
      public int size() { throw new UnsupportedOperationException("fullSet.size()"); }
      public boolean subsetOf(SmallSet that) { throw new UnsupportedOperationException("fullSet.subsetOf"); }
    };



    protected SmallSet() {
    }


    public SmallSet<T> union(SmallSet<T> set) {
      if(set.isEmpty() || this.equals(set))
        return this;
      SmallSet<T> newSet = new SmallSet<T>();
      newSet.set.addAll(this.set);
      newSet.set.addAll(set.set);
      return newSet;
    }


    
    public SmallSet<T> union(T element) {
      if(contains(element))
        return this;
      SmallSet<T> newSet = new SmallSet<T>();
      newSet.set.addAll(this.set);
      newSet.set.add(element);
      return newSet;
    }


    
    public SmallSet<T> compl(SmallSet<T> set) {
      if(set.isEmpty())
        return this;
      SmallSet<T> newSet = new SmallSet<T>();
      newSet.set.addAll(this.set);
      newSet.set.removeAll(set.set);
      return newSet;
    }


    
    public SmallSet<T> compl(Object element) {
      if(!set.contains(element))
        return this;
      SmallSet<T> newSet = new SmallSet<T>();
      newSet.set.addAll(this.set);
      newSet.set.remove(element);
      return newSet;
    }



    public SmallSet<T> intersect(SmallSet<T> set) {
      if(this.equals(set) || set == fullSet)
        return this;
      SmallSet<T> newSet = new SmallSet<T>();
      newSet.set.addAll(this.set);
      newSet.set.retainAll(set.set);
      return newSet;
    }



    public boolean contains(Object o) {
      return set.contains(o);
    }



    @SuppressWarnings("unchecked")
    public boolean equals(Object o) {
      if (o == null) return false;
      if(this == o) return true;
      if(o instanceof SmallSet) {
        SmallSet<T> set = (SmallSet)o;
        return this.set.equals(set.set);
      }
      return super.equals(o);
    }



    public boolean isEmpty() {
      return set.isEmpty();
    }


    public boolean isSingleton() {
      return set.size() == 1;
    }


    public void add(SmallSet<T> set) {
      this.set.addAll(set.set);
    }


    public void add(T o) {
      this.set.add(o);
    }


    public static <T> SmallSet<T> mutable() {
      return new SmallSet<T>();
    }


    public static <T> SmallSet<T> singleton(T elt) {
      SmallSet<T> res = new SmallSet<T>();
      res.add(elt);
      return res;
    }


}
