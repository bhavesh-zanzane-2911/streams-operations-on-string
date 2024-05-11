package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        String s1="Bhavesh zanzane";
        //Reverse a String
        String reveredString =s1.chars()
                .mapToObj(c->String.valueOf((char)c))
                .reduce((s2, s3)-> s3 + s2)
                .orElse("");
        System.out.println(reveredString);

        //count character
        LinkedHashMap<Character, Long> collect = s1.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        System.out.println(collect);

        //First repeatating character
        Optional<Character> first = collect.entrySet().stream()
                .filter(entry -> entry.getValue() >= 2)
                .map(entry -> entry.getKey())
                .findFirst();
        Character character = first.get();
        System.out.println("First Repeated Character "+character);

        //First N0n repeated charatcer
        Character singleCharatcer=collect.entrySet().stream()
                .filter(entry-> entry.getValue()==1)
                .map(entry->entry.getKey())
                .findFirst()
                .orElseThrow(()-> new RuntimeException("Not Found"));
        System.out.println(singleCharatcer);


        String s2="Bhavesh zanzane ABCD";
        String concat = s2.concat(" ");
        String [] words=concat.split(" ");
        int maxLengthWord = Arrays.stream(words).mapToInt(String::length).max().getAsInt();
        System.out.println("maximun length "+maxLengthWord);

        String maxLengthWord1 = Arrays.stream(words).reduce((word1, word2) ->
                word1.length() > word2.length() ? word1 : word2
        ).orElse("");

        System.out.println("Max Length Word "+maxLengthWord1);


        List<Integer> integers=Arrays.asList(1,2,3,4,5);
        String combinedResult = integers.stream().map(i -> i+"").collect(Collectors.joining(", "));
        System.out.println("CombinedResult "+combinedResult);


    }
}