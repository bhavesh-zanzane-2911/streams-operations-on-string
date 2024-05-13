package org.coding.practice.streamsapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;

public class StreamsOperationsOnArrayOfString {
    private static final Logger LOG = LoggerFactory.getLogger(StreamsOperationsOnString.class);
    public static void main(String[] args) {
        String s1 = "Bhavesh Zanzane";

        String s2="Bhavesh zanzane ABCD";
        String concat = s2.concat(" ");
        String [] words=concat.split(" ");
        int maxLengthWord = Arrays.stream(words).mapToInt(String::length).max().getAsInt();
        LOG.info("maximun length {}",maxLengthWord);

        String maxLengthWord1 = Arrays.stream(words).reduce((word1, word2) ->
                word1.length() > word2.length() ? word1 : word2
        ).orElse("");

        LOG.info("Max Length Word {}",maxLengthWord1);


        List<Integer> integers=Arrays.asList(1,2,3,4,5);
        String combinedResult = integers.stream().map(i -> i+"").collect(Collectors.joining(", "));
        LOG.info("CombinedResult {}",combinedResult);


    }
}