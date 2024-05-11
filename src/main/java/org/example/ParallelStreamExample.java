package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ParallelStreamExample {
    public static void main(String[] args) {
        List<Integer> numbers=new ArrayList<>();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        for(int i=0;i<=1000;i++){
            numbers.add(i);
        }
        //System.out.println(availableProcessors);
        Set<Integer> collect = numbers.parallelStream().filter(i ->
        {
            System.out.println(" " + Thread.currentThread().getName());
            return i < 100000;
        }).collect(Collectors.toSet());
        System.out.println(collect);


    }
}