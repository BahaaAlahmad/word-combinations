package com.example;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {

    @Test
    void findsCombinationOfTwoWords() {
        Set<String> words = Set.of("foobar", "fo", "obar");

        List<String> results = Main.findCombinations(words, 6);

        assertEquals(List.of("fo+obar=foobar"), results);
    }

    @Test
    void findsCombinationOfMoreThanTwoWords() {
        Set<String> words = Set.of("foobar", "fo", "ob", "ar");

        List<String> results = Main.findCombinations(words, 6);

        assertEquals(List.of("fo+ob+ar=foobar"), results);
    }

    @Test
    void findsAllValidCombinations() {
        Set<String> words = Set.of(
                "foobar", "fo", "obar", "foo", "bar");

        List<String> results = Main.findCombinations(words, 6);

        assertEquals(2, results.size());
        assertEquals(
                Set.of("fo+obar=foobar", "foo+bar=foobar"),
                Set.copyOf(results));
    }

    @Test
    void requiresTheResultingWordToExistInInput() {
        Set<String> words = Set.of("fo", "obar");

        assertTrue(Main.findCombinations(words, 6).isEmpty());
    }

    @Test
    void doesNotTreatTheWholeWordAsACombination() {
        Set<String> words = Set.of("foobar");

        assertTrue(Main.findCombinations(words, 6).isEmpty());
    }

    @Test
    void allowsReusingTheSameWord() {
        Set<String> words = Set.of("abcabc", "abc");

        List<String> results = Main.findCombinations(words, 6);

        assertEquals(List.of("abc+abc=abcabc"), results);
    }

    @Test
    void supportsADifferentTargetLength() {
        Set<String> words = Set.of("hello", "he", "llo");

        List<String> results = Main.findCombinations(words, 5);

        assertEquals(List.of("he+llo=hello"), results);
    }

    @Test
    void returnsNoResultsForEmptyInput() {
        assertTrue(Main.findCombinations(Set.of(), 6).isEmpty());
    }
}