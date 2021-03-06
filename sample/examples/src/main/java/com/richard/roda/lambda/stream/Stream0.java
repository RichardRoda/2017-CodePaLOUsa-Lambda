/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.richard.roda.lambda.stream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author Richard
 */
public class Stream0 {
    protected static Collection<Integer> getNumbers() {
        Collection<Integer> numbers = IntStream.rangeClosed(1, 1000).boxed().collect(Collectors.toList());
        return numbers;
    }
    
    
    public static void main (String[] args) {
        final Collection<Integer> numbers = getNumbers();
        printResult("For Loop ", forLoop(numbers));
        printResult("Stream ", stream(numbers));
        printResult("Parallel Stream ", parallelStream(numbers));
        printResult("Int Stream ", intStream());
        printResult("", summaryStatistics());
        replaceForLoop();
        mapStream();
        mapToString();
    }

    public static void printResult(String name, Object total) {
        System.out.print(name);
        System.out.println(total);
    }
    
    protected static int stream(Collection<Integer> numbers) {
        return numbers.stream()
            .reduce(0, (i,sum) -> i+sum); // 500500
    }

    protected static int parallelStream(Collection<Integer> numbers) {
        return numbers.parallelStream()
            .reduce(0, (i,sum) -> i+sum); // 500500
    }

    protected static int intStream() {
        return IntStream.rangeClosed(1, 1000).sum(); // 500500
    }
    
    protected static IntSummaryStatistics summaryStatistics() { 
        return IntStream.range(0, 1000) // Data Source
        .filter(i -> i %4 == 0) // Intermediate Operation
        .summaryStatistics(); // Terminal Operation   
    }
    
    protected static void replaceForLoop() {
        IntStream.range(0, 10).forEach(System.out::println); // Print 0-9
    }
    
    protected static void mapStream() {
        IntStream.range(0, 10).map(i -> i*10)
	.forEach(System.out::println); // Print 0-90

    }
    
    protected static void mapToString() {
        Stream<Character> s = IntStream.range(65, 75)
            .mapToObj(i -> (char)i); // Stream<Character>
        s.forEach(System.out::print); // ABCDEFGHIJ
    }
    
    protected static int forLoop(Collection<Integer> numbers) {
        int total = 0;
        for(Integer number : numbers) {
            total += number;
        }
        return total; // 500500
    }
}
