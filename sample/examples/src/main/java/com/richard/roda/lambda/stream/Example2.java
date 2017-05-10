/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.richard.roda.lambda.stream;

/**
 *
 * @author Richard
 */
@FunctionalInterface // Optional
public interface Example2 {
    int myMethod(); // Functional Method.
    boolean equals(Object other); // In Object
    int hashCode(); // In Object
    default int myMethod2() {return myMethod();}
    static int myMethod3() {return 0;}
}
