package com.me.string;

import com.sun.deploy.util.StringUtils;

public class StringUtilsTests {
    public static void main(String[] args) {

        String str1 = "";
        String str2 = null;
        String str3 = "A string";

        if (str1 == null || str1.isEmpty())
            System.out.println("String " + str1 + " is blank");
        if (str2 == null || str2.isEmpty())
            System.out.println("String " + str2 + " is blank");
        if (str3 == null || str3.isEmpty())
            System.out.println("String " + str3 + " is blank");

    }
}
