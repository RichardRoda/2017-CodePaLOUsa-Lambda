/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.richard.roda.lambda.stream;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.*;
import java.util.stream.IntStream;

/**
 *
 * @author Richard
 */
public class StreamPartition {
    public static void main(String[] arg) {
    IntSummaryStatistics summaryStatistics = 
        IntStream.range(0, 1000) // Data Source
        .filter(i -> i %4 == 0) // Intermediate Operation
        .summaryStatistics(); // Terminal Operation
    System.out.println(summaryStatistics);
    
    Map<Boolean,Integer> summap = IntStream.range(0, 1000).boxed()
        .collect(partitioningBy(i -> i % 4 == 0, summingInt(i -> i)));
    System.out.println(summap);
    }
}
