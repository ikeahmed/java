package com.me.array;

import java.util.*;

public class ArrayListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

   genericVsNonGeneric();



 ArrayList<Integer> al = new ArrayList<Integer>();

    al.add(new Integer(1));
    al.add(new Integer(2));
    al.add(new Integer(3));
    al.add(new Integer(4));
    al.add(new Integer(5));
    al.add(new Integer(6));
    al.add(new Integer(7));
    al.add(new Integer(8));
    al.add(new Integer(9));
    al.add(new Integer(10));

   al.set(5, new Integer(66));

    for (Iterator i = al.iterator(); i.hasNext();) {
      Integer integer = (Integer) i.next();
      System.out.println(integer);
    }


            
	   }

    private static void genericVsNonGeneric() {
	ArrayList al1 = new ArrayList(2);

        al1.add("Hi");
        al1.add(7);

            System.out.println(al1.size());
            System.out.println(al1.get(0));
            System.out.println(al1.get(1));

        ArrayList<String> al2 = new ArrayList<String>(2);
        al2.add("Hi");
        //wont let you do it now
        //al2.add(7);
            System.out.println(al2.size());
            System.out.println(al2.get(0));

    }

	}

