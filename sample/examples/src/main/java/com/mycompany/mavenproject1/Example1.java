/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.util.function.Predicate;

/**
 *
 * @author Richard
 */
public class Example1 {
    static public void main(String[] args) throws Exception {
        

    }
    
    static void exampleA() {
Predicate<Integer> isFive = n -> n == 5;
System.out.println(isFive.test(4)); // false        
    }
    
    static void exampleB() {
        Predicate<Integer> isFour = mkTestFunc(4);
        System.out.println(isFour.test(4)); // true        
    }
    
    public static Predicate<Integer> mkTestFunc(int value) {
        return n -> n == value;
    }
}
