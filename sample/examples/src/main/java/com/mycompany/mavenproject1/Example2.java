/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author Richard
 */
@FunctionalInterface // Optional
public interface Example2 {
    boolean equals(Object other); // In Object
    int hashCode(); // In Object
    int myMethod(); // Functional Method.
    default int myMethod2() {return myMethod();}
    static int myMethod3() {return 0;}
}
