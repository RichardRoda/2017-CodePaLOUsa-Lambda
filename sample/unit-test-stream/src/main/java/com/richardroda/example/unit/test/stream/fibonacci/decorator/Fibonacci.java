/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.richardroda.example.unit.test.stream.fibonacci.decorator;

import java.math.BigInteger;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/**
 *
 * @author Richard
 */
public class Fibonacci {
    // builder which allows steps to be inserted into the stream.
    protected static interface FibonacciDecorator {
        /**
         * Allow for the decoration of the lambda that is used to generate
         * the next fibonacci number.
         * @param f lambda to calculate the next fibonacci number.
         * @return f, or f decorated for unit testing.
         */
        default UnaryOperator<BigInteger[]> decorateIterator(UnaryOperator<BigInteger[]> f) 
        { return f; }
    }
    
    static final FibonacciDecorator DEFAULT = new FibonacciDecorator(){};    
    private FibonacciDecorator decorator = DEFAULT;
    
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
                Stream.iterate(ONE, decorator.decorateIterator(i -> new BigInteger[]
                    {i[1],i[0].add(i[1])})).limit(n);
        return fibonacci.max((a,b) -> a[1].compareTo(b[1])).get()[1];
    }
    
    public static void main(String[] arg) {
        Fibonacci f = new Fibonacci();
        System.out.println(f.computeFibonacci(10));
    }
    
    void setBuilder(FibonacciDecorator decorator) {
        this.decorator = decorator == null ? DEFAULT : decorator;
    }
}
