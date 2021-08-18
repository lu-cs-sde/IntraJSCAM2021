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
 * @declaredat /Users/idrissr/git/lund/research/artifacts/IntraJ/evaluation/jastaddj-intraflow/src/jastadd/Sets.jrag:10
 */
public class BitSet extends java.lang.Object {

    protected HashMap elementMap;


    protected ArrayList elementList;


    public BitSet() {
      this(new HashMap(), new ArrayList(), new int[1]);
    }


    protected BitSet(HashMap elementMap, ArrayList elementList, int[] bits) {
      this.elementMap = elementMap;
      this.elementList = elementList;
      this.bits = bits;
    }


    protected BitSet(BitSet set) {
      this(set, set.bits.length);
    }


    protected BitSet(BitSet set, int size) {
      this(set.elementMap, set.elementList, new int[size]);
      for(int i = 0; i < set.bits.length; i++)
        bits[i] = set.bits[i];
    }


    protected int index(Object element) {
      if(!elementMap.containsKey(element)) {
        elementMap.put(element, new Integer(elementList.size()));
        elementList.add(element);
      }
      return ((Integer)elementMap.get(element)).intValue();
    }



    protected Object element(int index) {
      return elementList.get(index);
    }



    // represent set using a bit field
    int[] bits;



    // iterate over the set by searching the bit field linearly for one bits
    // use the array to perform the reverse lookup
    public Iterator iterator() {
      return new Iterator() {
        private int nextElement;
        {
          // make nextElement refer to the first element
          nextElement = 0;
          hasNext();
        }
        public boolean hasNext() {
          while((nextElement >> 5) < bits.length) {   // while (nextElement / 32 < bits.length)
            int offset = nextElement >> 5;            //   nextElement / 32
            int bit = 1 << (nextElement & 0x1f);      //   nextElement % 32
            if((bits[offset] & bit) == bit)           
              return true;
            nextElement++;
          }
          return false;
        }
        public Object next() {
          return element(nextElement++);
        }
        public void remove() {
          throw new Error("remove not supported for " + BitSet.this.getClass().getName());
        }
      };
    }



    public static BitSet full() { return fullSet; }


    // override set operations when operating on the full set 
    private static BitSet fullSet = new BitSet(null, null, null) {
      public BitSet union(BitSet set) { return this; }
      public BitSet union(Object element) { return this; }
      public BitSet compl(BitSet set) { throw new Error("compl not supported for the full set"); }
      public BitSet compl(Object element) { throw new Error("compl not supported for the full set"); }
      public BitSet intersect(BitSet set) { return set; }
      public boolean isEmpty() { return false; }
    };



    private BitSet convert(BitSet set) {
      if(set.elementMap == elementMap) return set;
  //    System.err.println("Warning: need to convert set");
      BitSet newSet = new BitSet(elementMap, elementList, new int[bits.length + 1]);
      for(Iterator iter = set.iterator(); iter.hasNext(); )
        newSet.add(iter.next());
      return newSet;
    }



    public BitSet union(BitSet set) {
      set = convert(set);
      if(set.isEmpty() || this.equals(set)) return this;
        
      BitSet min, max;
      if(bits.length >= set.bits.length) {
        max = this;
        min = set;
      }
      else {
        max = set;
        min = this;
      }
      int length = min.bits.length;
      int i = 0;
      // search for elements in the smaller set that are missing in the larger set
      while(i < length && (max.bits[i] & min.bits[i]) == min.bits[i])
        i++;
      if(i != length) {
        // copy the larger set and store missing elements from smaller set
        max = new BitSet(max);
        for(; i < length; i++)
          max.bits[i] |= min.bits[i];
      }
      return max;
    }


    
    public BitSet union(Object element) {
      int index = index(element);
      int offset = index >> 5;
      int bit = 1 << (index & 0x1f);
      if(bits.length > offset && (bits[offset] & bit) == bit)
        return this;
      // copy the set and store the missing element
      BitSet set = new BitSet(this, Math.max(offset + 1, bits.length));
      set.bits[offset] |= bit;
      return set;
    }


    
    public BitSet compl(BitSet set) {
      set = convert(set);
      if(set.isEmpty()) return this;
      // copy this
      BitSet res = new BitSet(this);
      int i = 0;
      int length = Math.min(bits.length, set.bits.length);
      // find first hit
      while (i < length && (bits[i] & set.bits[i]) == 0) 
        i++;
      if (i != length) {
        // remove 
        for (; i < length; i++) {
          res.bits[i] &= ~set.bits[i];
        }	 
      }
      return res;
    }


    
    public BitSet compl(Object element) {
      int index = index(element);
      int offset = index >> 5;
      int bit = 1 << (index & 0x1f);
      if(bits.length > offset && (bits[offset] & bit) == 0)
        return this;
      // copy the set and remove element
      BitSet set = new BitSet(this, Math.max(offset + 1, bits.length));
      set.bits[offset] &= ~bit;
      return set;
    }


    
    public BitSet intersect(BitSet set) {
      set = convert(set);
      if(this.equals(set) || set == fullSet)
        return this;
      int length = Math.min(this.bits.length, set.bits.length);
      BitSet newSet = new BitSet(elementMap, elementList, new int[length]);
      for(int i = 0; i < length; i++)
        newSet.bits[i] = this.bits[i] & set.bits[i];
      return newSet;
    }



    public boolean contains(Object o) {
      int index = index(o);
      int offset = index >> 5;
      int bit = 1 << (index & 0x1f);
      return offset < bits.length && (bits[offset] & bit) != 0;
    }



    public boolean equals(Object o) {
      if (o == null) return false;
      if(this == o) return true;
      if(o instanceof BitSet) {
        BitSet set = (BitSet)o;
        if(elementMap != set.elementMap)
          return false;
        int length = set.bits.length > bits.length ? bits.length : set.bits.length;
        int i = 0;
        for(; i < length; i++)
          if(bits[i] != set.bits[i])
            return false;
        for(; i < bits.length; i++)
          if(bits[i] != 0)
            return false;
        for(; i < set.bits.length; i++)
          if(set.bits[i] != 0)
            return false;
        return true;
      }
      return super.equals(o);
    }



    public boolean isEmpty() {
      for(int i = 0; i < bits.length; i++)
        if(bits[i] != 0)
          return false;
      return true;
    }


    public void add(BitSet set) {
      set = convert(set);
      if(set.bits.length > bits.length) {
        int[] newBits = new int[set.bits.length];
        for(int i = 0; i < bits.length; i++)
          newBits[i] = bits[i] | set.bits[i];
        for(int i = bits.length; i < set.bits.length; i++)
          newBits[i] = set.bits[i];
        bits = newBits;
      }
      else {
        for(int i = 0; i < set.bits.length; i++)
          bits[i] |= set.bits[i];
      }
    }


    public void add(Object o) {
      int index = index(o);
      int offset = index >> 5;
      int bit = 1 << (index & 0x1f);
      if(offset >= bits.length) {
        int[] newBits = new int[offset+1];
        for(int i = 0; i < bits.length; i++)
          newBits[i] = bits[i];
        bits = newBits;
      }
      bits[offset] |= bit;
    }


    public BitSet mutable() {
      return new BitSet(this);
    }


}
