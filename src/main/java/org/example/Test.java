package org.example;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        printDuplicateCharacter("bhaveshzanzane");
    }

    public static void printDuplicateCharacter(String str){

        Map<Character, Long> characterCountMap=str.chars()
                .mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        System.out.println(characterCountMap);

        List<Character> duplicateCharacters = characterCountMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();
        System.out.println("duplicate "+duplicateCharacters);
    }
}


