package com.me.list;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
         List<String> list = new ArrayList<String>();
         list.add("green");
         list.add("red");
         list.add("yellow");

         for (int i=0; i< list.size(); i++)
             System.out.println(list.get(i));
    }


	
}
