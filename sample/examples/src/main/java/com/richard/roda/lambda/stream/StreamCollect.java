/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.richard.roda.lambda.stream;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author Richard
 */
public class StreamCollect {
    public static void main(String[] args) throws Exception {
        List<Integer> ints = IntStream.of(1,2,2,3,4,5).boxed()
            .collect(Collectors.toList());
        System.out.println(ints);
        
        Set<Integer> intSet = IntStream.of(1,2,2,3,4,5).boxed()
            .collect(Collectors.toSet());
        System.out.println(intSet);

        // Custom collection type with a sort applied to it.
        LinkedHashSet<Integer> sortedSet = IntStream.of(1,2,2,3,4,5).boxed()
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println(sortedSet);

    }
}
