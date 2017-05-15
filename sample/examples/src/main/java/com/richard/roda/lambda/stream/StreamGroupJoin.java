/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.richard.roda.lambda.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static com.richard.roda.lambda.stream.Stream0.printResult;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 *
 * @author Richard
 */
public class StreamGroupJoin {
    static Stream<String> aboutJack() {
        return Stream.of("All","work","and","no","play","makes","jack","a"
            ,"dull","boy","but","all","play","and","no","work"
            ,"makes","jack","a","fool");
    }
    
    static Map<Character,Set<String>> startsWith() {
        return aboutJack().collect(Collectors.groupingBy(s -> s.charAt(0),
            TreeMap::new,Collectors.toCollection(TreeSet::new)));
    }
    
    static Map<Character,Set<String>> startsWithConcurrent() {
        return aboutJack().parallel().collect(Collectors.groupingByConcurrent(s -> s.charAt(0),
            ConcurrentSkipListMap::new,Collectors.toCollection(ConcurrentSkipListSet::new)));
    }
    
    static Map<String,Long> wordCountConcurrent() {
        return aboutJack().parallel().collect(Collectors.groupingByConcurrent(
                s -> s, ConcurrentSkipListMap::new, Collectors.counting()));
    }
    
    static String join() {
        return aboutJack().collect(Collectors.joining(" "));
    }
    
    public static void main(String[] args) {
        printResult("startsWith ", startsWith());
        printResult("startsWithConcurrent ", startsWithConcurrent());
        printResult("wordCountConcurrent ", wordCountConcurrent());
        printResult("join ", join());
    }
}
