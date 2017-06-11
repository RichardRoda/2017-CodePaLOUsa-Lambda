/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.richard.roda.lambda.stream;

import java.util.Optional;
import java.util.stream.Stream;

/**
 *
 * @author Richard
 */
public class OptionalExample {
    public static void main(String[] args) {
        Optional<Integer> found = Stream.of(1,2).max((a,b) -> a - b);
        System.out.print("Found: " + found.isPresent() + ", value = ");
        found.ifPresent(System.out::println);
        Optional<Object> notFound = Stream.of().max((a,b) -> 0);
        System.out.print("Found: " + notFound.isPresent());
        notFound.ifPresent(System.out::println);
        
    }
}
