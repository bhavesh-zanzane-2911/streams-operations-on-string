package org.coding.practice.streamsapi;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsOperationsOnString {
    public static String getReversedString(String inputString) {
        //Reverse a String
        String reveredString = inputString.chars()
                .mapToObj(c -> String.valueOf((char) c))
                .reduce((s1, s2) -> s2 + s1)
                .orElse("");

        System.out.println("Reversed String :" + reveredString);

        //Step by Step return working
        IntStream chars = inputString.chars();//convert to chars to IntStream
        Stream<String> stringStream = chars.mapToObj(c -> String.valueOf((char) c));//convert from IntStream to Stream of String of each Character
        Optional<String> reversedStringOptional = stringStream.reduce((s1, s2) -> s2 + s1);
        String reversedStringToReturn = reversedStringOptional.orElse("");
        System.out.println("Reversed String After Step By Step Approach:" + reversedStringToReturn);
        return reversedStringToReturn;
    }

    public static LinkedHashMap<Character, Long> getCharacterLongLinkedHashMap(String inputString) {
        //count character
        LinkedHashMap<Character, Long> characterAndTheirCountMap = inputString.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        System.out.println(characterAndTheirCountMap);

        IntStream chars = inputString.chars();
        Stream<Character> characterStream = chars.mapToObj(c -> (char) c);
        LinkedHashMap<Character, Long> characterAndTheirCountMapAsPerInputCharacterOrder = characterStream
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        System.out.println(characterAndTheirCountMapAsPerInputCharacterOrder);

        return characterAndTheirCountMap;
    }

    public static Character getFirstRepeatatingCharacter(String inputString) {

        LinkedHashMap<Character, Long> characterAndTheirCountMap = getCharacterLongLinkedHashMap(inputString);

        //First repeatating character
        Optional<Character> first = characterAndTheirCountMap.entrySet().stream()
                .filter(entry -> entry.getValue() >= 2)
                .map(Map.Entry::getKey)
                .findFirst();
        Character character = first.get();
        System.out.println("First Repeated Character " + character);

        Set<Map.Entry<Character, Long>> entries = characterAndTheirCountMap.entrySet();
        Stream<Map.Entry<Character, Long>> stream = entries.stream();
        Stream<Map.Entry<Character, Long>> entryStreamAfterFilteringEntriesValueGreaterThanOrEqualTo2
                = stream.filter(entry -> entry.getValue() >= 2);
        Stream<Character> characterStream = entryStreamAfterFilteringEntriesValueGreaterThanOrEqualTo2.map(entry -> entry.getKey());
        Optional<Character> firstRepeatedCharacterOptional = characterStream.findFirst();
        Character firstRepeatedCharacter = firstRepeatedCharacterOptional.get();
        return firstRepeatedCharacter;
    }

    public static Character getFirstNonRepeatedCharacter(String inputString) {
        //First N0n repeated charatcer
        LinkedHashMap<Character, Long> characterAndTheirCountMap = getCharacterLongLinkedHashMap(inputString);

        Character singleCharacter = characterAndTheirCountMap.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(entry -> entry.getKey())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Not Found"));
        System.out.println(singleCharacter);

        Set<Map.Entry<Character, Long>> entries = characterAndTheirCountMap.entrySet();
        Stream<Map.Entry<Character, Long>> stream = entries.stream();
        Stream<Map.Entry<Character, Long>> entryStreamAfterFilteringEntriesValueEqualTo1
                = stream.filter(entry -> entry.getValue() == 1);
        Stream<Character> characterStream = entryStreamAfterFilteringEntriesValueEqualTo1.map(entry -> entry.getKey());
        Optional<Character> firstNonRepeatedCharacterOptional = characterStream.findFirst();
        Character firstNonRepeatedCharacter = firstNonRepeatedCharacterOptional.get();

        return firstNonRepeatedCharacter;

    }
}