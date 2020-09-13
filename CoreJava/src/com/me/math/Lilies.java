package com.me.math;

public class Lilies {
    public static void main(String[] args) {
    int days = 30;
    int day = 1;
    double lilies = 1;
    double total_lilies = Math.pow(2,days-1);
    for (day=2; day <= days; day++) {
        lilies = 2 * lilies;
        if (lilies >= total_lilies/2)
            break;
    }
    System.out.println("On Day " + day +" number of lilies: " + lilies);
    System.out.println("Total lilies in 30 days: " + total_lilies);
    System.out.println("Area per square foot: " + Math.sqrt(total_lilies));
    }
}
