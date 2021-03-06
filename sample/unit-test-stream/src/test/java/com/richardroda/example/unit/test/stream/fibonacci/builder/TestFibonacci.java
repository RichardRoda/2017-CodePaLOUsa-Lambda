/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.richardroda.example.unit.test.stream.fibonacci.builder;

import java.math.BigInteger;
import java.util.stream.Stream;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author Richard
 */
public class TestFibonacci implements Fibonacci.FibonacciBuilder {
    static final int[] FIBONACCI_NUMBERS = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811};

    int n = 0;
    Fibonacci f = new Fibonacci();
    
    @BeforeTest 
    public void beforeTest() {
        n=0; // Reset index to fibonacci numbers.
        f.setBuilder(this); // Set this test to help build the streem.
    }
    
    @Test
    public void testAll() {
        System.out.print("Tested: ");
        int value = f.computeFibonacci(FIBONACCI_NUMBERS.length).intValue();
        Assert.assertEquals(value, FIBONACCI_NUMBERS[FIBONACCI_NUMBERS.length-1]);
        System.out.println();
    }

    @Override
    public Stream<BigInteger[]> afterIterator(Stream<BigInteger[]> s) {
        return s.peek(i -> {
            Assert.assertEquals(FIBONACCI_NUMBERS[n++], i[1].intValue());
            System.out.print(i[1]);
            System.out.print(", ");
        });
    }


}
