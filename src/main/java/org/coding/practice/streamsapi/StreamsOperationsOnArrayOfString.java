package org.coding.practice.streamsapi;

import java.util.*;
import java.util.stream.Collectors;

public class StreamsOperationsOnArrayOfString {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        String s1 = "Bhavesh Zanzane";

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