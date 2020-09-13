package com.me.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeSet;

public class ListTreeSetExample {

        public static void main(String[] args) {
            ArrayList<String> al = new ArrayList<>();
            al.add("A");
            al.add("D");
            al.add("B");
            al.add("C");
            print(al);


            TreeSet<String> ts = new TreeSet<>();
            ts.add("A");
            ts.add("D");
            ts.add("B");
            ts.add("C");
            print(ts);

        }
        public static void print(Collection<String> collection) {
            for (String s : collection) {
                System.out.println(s);
            }
        }
    }


