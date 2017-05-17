/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.richard.roda.lambda.stream;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 *
 * @author Richard
 */
public class Example1 {

    static public void main(String[] args) throws Exception {
        exampleA();
        exampleB();
        staticMethodReference();
        specificInstanceMethodReference();
        System.out.println();
        constructorMethodReference();
        instanceMethodReference();
    }

    static void exampleA() {
        Predicate<Integer> isFive = n -> n == 5;
        System.out.println(isFive.test(4)); // false        
    }

    static void exampleB() {
        Predicate<Integer> isFour = mkTestFunc(4);
        System.out.println(isFour.test(4)); // true        
    }

    static void staticMethodReference() {
        Function<char[],String> valueOf = String::valueOf;
        String value = valueOf.apply(new char[] {'H','e','l','l','o'});
        System.out.println(value); // Hello
    }
    
    static void specificInstanceMethodReference() {
        Consumer<Object> printer = System.out::print;
        Arrays.asList(1,2,3,4).forEach(printer);
    }
    
    static void constructorMethodReference() {
        Supplier<StringBuilder> supplier = StringBuilder::new;
        // supplier = () -> new StringBuilder();
        StringBuilder sb = supplier.get().append("Hi!");
        System.out.println(sb); // Hi!
    }
    
    static void instanceMethodReference() {
        UnaryOperator<String> toUpperCase = String::toUpperCase;
        // toUpperCase -> s -> s.toUpperCase();
        System.out.println(toUpperCase.apply("abc"));
    }
    
    public static Predicate<Integer> mkTestFunc(int value) {
        return n -> n == value;
    }
}
