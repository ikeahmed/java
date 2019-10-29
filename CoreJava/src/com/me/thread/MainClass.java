/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.me.thread;

import java.io.IOException;

/**
 *
 * @author iahmed
 */
public class MainClass {
  public static void main(String[] args) {
    Thread first = new TryThread("A ", "a  ", 2000L);
    Thread second = new TryThread("B ", "b ", 3000L);
    Thread third = new TryThread("C ", "c ", 5000L);
    System.out.println("Press Enter when you have had enough...\n");
    first.start();
    second.start();
    third.start();
    try {
      System.in.read();
      System.out.println("Enter pressed...\n");
    } catch (IOException e) {
      System.out.println(e);
    }
    return;
  }
}