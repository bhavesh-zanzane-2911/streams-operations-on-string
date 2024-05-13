package org.coding.practice.streamsapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsOperationsOnString {

    private static final Logger LOG = LoggerFactory.getLogger(StreamsOperationsOnString.class);
    public static String getReversedString(String inputString) {
        //Reverse a String
        String reveredString = inputString.chars()
                .mapToObj(c -> String.valueOf((char) c))
                .reduce((s1, s2) -> s2 + s1)
                .orElse("");

        LOG.info("Reversed String : {}", reveredString);

        //Step by Step return working
        IntStream chars = inputString.chars();//convert to chars to IntStream
        Stream<String> stringStream = chars.mapToObj(c -> String.valueOf((char) c));//convert from IntStream to Stream of String of each Character
        Optional<String> reversedStringOptional = stringStream.reduce((s1, s2) -> s2 + s1);
        String reversedStringToReturn = reversedStringOptional.orElse("");
        LOG.info("Reversed String After Step By Step Approach: {}",reversedStringToReturn);
        return reversedStringToReturn;
    }

    public static LinkedHashMap<Character, Long> getCharacterLongLinkedHashMap(String inputString) {
        //count character
        LinkedHashMap<Character, Long> characterAndTheirCountMap = inputString.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        LOG.info("{}", characterAndTheirCountMap);

        IntStream chars = inputString.chars();
        Stream<Character> characterStream = chars.mapToObj(c -> (char) c);
        LinkedHashMap<Character, Long> characterAndTheirCountMapAsPerInputCharacterOrder = characterStream
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        LOG.info("{}", characterAndTheirCountMapAsPerInputCharacterOrder);

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
        LOG.info("First Repeated Character {}", character);

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
        LOG.info("{}", singleCharacter);

        Set<Map.Entry<Character, Long>> entries = characterAndTheirCountMap.entrySet();
        Stream<Map.Entry<Character, Long>> stream = entries.stream();
        Stream<Map.Entry<Character, Long>> entryStreamAfterFilteringEntriesValueEqualTo1
                = stream.filter(entry -> entry.getValue() == 1);
        Stream<Character> characterStream = entryStreamAfterFilteringEntriesValueEqualTo1.map(entry -> entry.getKey());
        Optional<Character> firstNonRepeatedCharacterOptional = characterStream.findFirst();
        Character firstNonRepeatedCharacter = firstNonRepeatedCharacterOptional.get();

        return firstNonRepeatedCharacter;

    }

    public static Map.Entry<Character, Long> getMaxOccurredCharacter(String inputString) {
        LinkedHashMap<Character, Long> characterAndTheirCountMap = getCharacterLongLinkedHashMap(inputString);

        //Optional<Map.Entry<Character, Long>> maxOccuredCharacter = characterAndTheirCountMap.entrySet().stream()
        //        .max(Map.Entry.comparingByValue());

        Map.Entry<Character, Long> maxOccurredCharacter = characterAndTheirCountMap.entrySet().stream()
                .max((c1,c2)->c1.getValue().compareTo(c2.getValue()))
                .orElseThrow(() -> new RuntimeException("No character found"));;
        LOG.info("{}", maxOccurredCharacter);
        return maxOccurredCharacter;
    }

    public static Map.Entry<Character, Long> getMinOccurredCharacter(String inputString) {
        LinkedHashMap<Character, Long> characterAndTheirCountMap = getCharacterLongLinkedHashMap(inputString);

        //Optional<Map.Entry<Character, Long>> maxOccuredCharacter = characterAndTheirCountMap.entrySet().stream()
        //        .min(Map.Entry.comparingByValue());

        Map.Entry<Character, Long> minOccurredCharacter = characterAndTheirCountMap.entrySet().stream()
                .min((c1,c2)->c1.getValue().compareTo(c2.getValue()))
                .orElseThrow(() -> new RuntimeException("No character found"));;
        LOG.info("{}", minOccurredCharacter);
        return minOccurredCharacter;
    }
}