/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.richard.roda.lambda.stream;

import java.util.stream.IntStream;

/**
 *
 * @author Richard
 */
public class Stream1 {
    public static void main(String[] arg) {
        int sum = IntStream.range(0, 1000).filter(i -> i %4 == 0).sum();
        System.out.println(sum);
    }
}
