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
        Predicate<Integer> isFive = n -> n == 5;
        System.out.println(isFive.test(4)); // false
    }
}
