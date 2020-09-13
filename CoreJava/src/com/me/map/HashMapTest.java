/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.me.map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class HashMapTest {
public static void main(String[] args)
    {
    Map<String, String>studentsCourses = new HashMap<>();
    studentsCourses.put("1","JSB102");
    studentsCourses.put("2","JSB102");
    studentsCourses.put("1","ANG101");

    studentsCourses.forEach((k,v)->System.out.println("student Id : " + k + " Course : " + v));

    Map<String, String>map2 = new Hashtable<>();
    map2.put("1","JSB102");
    map2.put("2","JSB102");
    map2.put("1","ANG101");
    map2.forEach((k,v)->System.out.println("student Id : " + k + " Course : " + v));
    System.out.println(map2.size());


    }
}
