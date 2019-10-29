/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.me;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author iahmed
 */
public class HashMapTest {
public static void main(String[] args)
    {
     Map errors = new HashMap();

    errors.put("404", "A.");
    errors.put("403", "B.");
    errors.put("500", "C.");

    String errorDesc = (String) errors.get("404");
    System.out.println("Error 404: " + errorDesc);

    Iterator iterator = errors.keySet().iterator();
    while (iterator.hasNext()) {
      String key = (String) iterator.next();
      System.out.println("Error " + key + " means " + errors.get(key));
    }

   HashMap<Integer,String> map = new HashMap<Integer,String>();

    map.put(1, "Ian");
    map.put(42, "Scott");
    map.put(123, "Somebody else");

    String name = map.get(42);
    System.out.println(name);


    }
}
