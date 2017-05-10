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
public class Example4 {
    static public void main(String[] args) {
        System.out.print(IntStream.iterate(0, i -> i+1)
                .limit(12).sum());
    }
}
