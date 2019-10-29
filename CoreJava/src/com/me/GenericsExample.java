/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.me;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author iahmed
 */
public class GenericsExample {

  public static void main(String[] args) {
  List<Integer> myIntList = new LinkedList<Integer>();
  myIntList.add(new Integer(1));
  Integer x = myIntList.iterator().next();
  System.out.println("x = " + x);

  List<String> myStrList = new LinkedList<String>();
  myStrList.add("Hello");
  myStrList.add("World");

  Iterator lIterator = myStrList.iterator();
  while (lIterator.hasNext())
      System.out.println(lIterator.next());

  }


}
