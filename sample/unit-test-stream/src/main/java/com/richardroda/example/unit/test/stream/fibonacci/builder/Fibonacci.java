/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.richardroda.example.unit.test.stream.fibonacci.builder;

import java.math.BigInteger;
import java.util.stream.Stream;

/**
 *
 * @author Richard
 */
public class Fibonacci {
    // builder which allows steps to be inserted into the stream.
    protected static interface FibonacciBuilder {
        /**
         * Allow for insertion of steps necessary for unit testing
         * after the iterator is completed.
         * @param s The stream.
         * @return The stream, or a stream with steps added for unit testing.
         */
        default Stream<BigInteger[]> afterIterator(Stream<BigInteger[]> s) 
        { return s; }
    }
    
    static final FibonacciBuilder DEFAULT = new FibonacciBuilder(){};    
    private FibonacciBuilder builder = DEFAULT;
    
    /**
     * Constant for the first two fibonacci numbers in the series.  Used as
     * the seed for the fibonacci series.
     */
    static private final BigInteger[] ONE = {BigInteger.ZERO,BigInteger.ONE};
    
    /**
     * Compute the nth fibonacci number.
     * @param n Which number to compute.
     * @return The computed number.
     */
    public BigInteger computeFibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Fibonacci not defined for negative numbers: " + n);
        }

        if (n == 0) {
            return BigInteger.ZERO;
        }
        Stream<BigInteger[]> fibonacci = 
                builder.afterIterator(Stream.iterate(ONE, i -> new BigInteger[]
                    {i[1],i[0].add(i[1])})).limit(n);
        return fibonacci.max((a,b) -> a[1].compareTo(b[1])).get()[1];
    }
    
    public static void main(String[] arg) {
        Fibonacci f = new Fibonacci();
        System.out.println(f.computeFibonacci(10));
    }
    
     void setBuilder(FibonacciBuilder builder) {
        this.builder = builder == null ? DEFAULT : builder;
    }
}
