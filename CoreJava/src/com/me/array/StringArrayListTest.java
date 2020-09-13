package com.me.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringArrayListTest {
    private static final String PUERTO_RICO = "PR";
    private static final String US_VIRGIN_ISLANDS = "VI";
    private static final List<String> NON_ELIGIBLE_STATES = new ArrayList<>(Arrays.asList(PUERTO_RICO, US_VIRGIN_ISLANDS));
    public static void main(String[] args) {
        System.out.println("Ineligble state:"+ NON_ELIGIBLE_STATES);
    }
}
