package com.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Main {

    private static final int TARGET_LENGTH = 6;

    public static void main(String[] args) throws IOException {
        Set<String> words = new LinkedHashSet<>();

        for (String line : Files.readAllLines(Path.of("input.txt"))) {
            String word = line.trim();

            if (!word.isEmpty()) {
                words.add(word);
            }
        }

        findCombinations(words, TARGET_LENGTH)
                .forEach(System.out::println);
    }

    public static List<String> findCombinations(
            Set<String> words, int targetLength) {

        List<String> results = new ArrayList<>();

        for (String word : words) {
            if (word.length() == targetLength) {
                findCombinations(
                        word, 0, words, new ArrayList<>(), results);
            }
        }

        return results;
    }

    private static void findCombinations(
            String target,
            int start,
            Set<String> words,
            List<String> parts,
            List<String> results) {

        if (start == target.length()) {
            if (parts.size() >= 2) {
                results.add(String.join("+", parts) + "=" + target);
            }
            return;
        }

        for (int end = start + 1; end <= target.length(); end++) {
            String part = target.substring(start, end);

            if (words.contains(part)) {
                parts.add(part);
                findCombinations(target, end, words, parts, results);
                parts.removeLast();
            }
        }
    }
}