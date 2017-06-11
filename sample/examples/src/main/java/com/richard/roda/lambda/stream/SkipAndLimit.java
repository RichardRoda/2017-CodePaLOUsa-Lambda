/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.richard.roda.lambda.stream;

import java.util.stream.IntStream;

/**
 * Show difference between skip before limit, and skip after limit.
 * @author Richard
 */
public class SkipAndLimit {
    public static void skipBeforeLimit() {
        IntStream.iterate(0, i -> i+1).skip(4).limit(6).forEach(System.out::print);
    }
    
    public static void skipAfterLimit() {
        IntStream.iterate(0, i -> i+1).limit(6).skip(4).forEach(System.out::print);        
    }
    
    public static void main(String[] args) {
        System.out.print("Skip before limit: ");
        skipBeforeLimit();
        System.out.println();
        System.out.print("Skip after limit: ");
        skipAfterLimit();
        System.out.println();
    }
}
