/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.richard.roda.lambda.stream;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author Richard
 */
public class Example4 {
    static public void main(String[] args) {
        System.out.print(IntStream.iterate(0, i -> i+1)
                .limit(12).sum());
        System.out.println();
        Stream.of("ab","cd","ef").map(String::toUpperCase)
                .forEach(System.out::print);

        System.out.println();
        Stream.of("ab","cd","ef").map(i->i.toUpperCase())
                .forEach(i->System.out.print(i));
    }
}
