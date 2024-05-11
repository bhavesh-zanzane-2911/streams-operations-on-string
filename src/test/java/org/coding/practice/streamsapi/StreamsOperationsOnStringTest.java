package org.coding.practice.streamsapi;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.*;

class StreamsOperationsOnStringTest {

    @Test
    void testReverseString_1() {
        //Given
        String inputString = "BHAVESH";
        //When
        String reversedString = StreamsOperationsOnString.getReversedString(inputString);
        //Then
        assertEquals("HSEVAHB", reversedString);
    }

    @Test
    void testReverseString_2() {
        //Given
        String inputString = "BHAVESH ZANZANE";
        //When
        String reversedString = StreamsOperationsOnString.getReversedString(inputString);
        //Then
        assertEquals("ENAZNAZ HSEVAHB", reversedString);
    }

    @Test
    void testCharacterLongLinkedHashMap_1() {

        //Given
        String inputString = "BHAVESH";
        //When
        LinkedHashMap<Character, Long> characterAndTheirCountMap
                = StreamsOperationsOnString.getCharacterLongLinkedHashMap(inputString);
        //Then
        assertEquals(1, characterAndTheirCountMap.get('B'));
        assertEquals(2, characterAndTheirCountMap.get('H'));
        assertNull(characterAndTheirCountMap.get('Z'));
    }

    @Test
    void testCharacterLongLinkedHashMap_2() {

        //Given
        String inputString = "AaBbbCcccDddddEeeeee";
        //When
        LinkedHashMap<Character, Long> characterAndTheirCountMap
                = StreamsOperationsOnString.getCharacterLongLinkedHashMap(inputString);
        //Then
        assertEquals(1, characterAndTheirCountMap.get('A'));
        assertEquals(1, characterAndTheirCountMap.get('B'));
        assertEquals(2, characterAndTheirCountMap.get('b'));
        assertNull(characterAndTheirCountMap.get('Z'));
    }


    @Test
    void testGetFirstRepeatatingCharacter_1() {

        //Given
        String inputString = "AaBbbCcccDddddEeeeee";;
        //When
        Character firstRepeatatingCharacter
                = StreamsOperationsOnString.getFirstRepeatatingCharacter(inputString);
        //Then
        assertEquals('b', firstRepeatatingCharacter);
    }

    @Test
    void testGetFirstRepeatatingCharacter_2() {

        //Given
        String inputString = "BHAVESH";
        //When
        Character firstRepeatatingCharacter
                = StreamsOperationsOnString.getFirstRepeatatingCharacter(inputString);
        //Then
        assertEquals('H', firstRepeatatingCharacter);
    }

    @Test
    void testGetFirstNonRepeatatingCharacter_1() {

        //Given
        String inputString = "AaBbbCcccDddddEeeeee";;
        //When
        Character firstNonRepeatatingCharacter
                = StreamsOperationsOnString.getFirstNonRepeatedCharacter(inputString);
        //Then
        assertEquals('A', firstNonRepeatatingCharacter);
    }
}