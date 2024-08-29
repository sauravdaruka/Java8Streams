package com.sauravdaruka;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Streams {
    public static void main(String[] args) {

        // Find the word with maximum length in a sentence
        String sentence = "Find the word with maximum length in a sentence. The words might contain double vowels!";
        String maxLengthWord = Arrays.stream(sentence.split(" ")).max(Comparator.comparing(String::length)).get();
        System.out.println("\nmaxLengthWord: " + (maxLengthWord.isEmpty() ? 0 : maxLengthWord));
        System.out.println();

        // Remove duplicates from the String and preserving the order
        String duplicateLetters = "DuplicateDuplicate";
        System.out.print("After removing duplicate characters: ");
        duplicateLetters.chars().mapToObj(character -> (char) character).distinct().forEach(System.out::print);
        System.out.print("\nAfter removing duplicate characters (Alternate Approach): ");
        Arrays.stream(duplicateLetters.split("")).distinct().forEach(System.out::print);
        System.out.println();

        // Find the word that has the 2nd maximum length
        String maxSecondWord = Arrays.stream(sentence.split(" ")).sorted(Comparator.comparing(String::length).reversed()).skip(1).findFirst().get();
        System.out.println("\nmaxSecondWord: " + (maxSecondWord.isEmpty() ? 0 : maxSecondWord));
        System.out.println();

        // Find the length of 2nd maximum word in the given sentence
        Optional<Integer> maxSecondWordLength = Arrays.stream(sentence.split(" ")).map(String::length).sorted(Comparator.reverseOrder()).skip(1).findFirst();
        System.out.println("maxSecondWordLength: " + (maxSecondWordLength.orElse(0)));
        System.out.println();

        // Find the occurrence of each word in the given sentence
        Map<String, Long> wordOccurrence = Arrays.stream(sentence.split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("wordOccurrence: " + wordOccurrence);

        Map<String, Long> wordOccurrenceAlternate = Arrays.stream(sentence.split(" ")).collect(Collectors.groupingBy(word -> word, Collectors.counting()));
        System.out.println("wordOccurrence (Alternate Approach): " + wordOccurrenceAlternate);
        System.out.println();

        // Find the words with a specified number of vowels(3) in a sentence
        System.out.print("Words with specified Vowels:\n");
        Arrays.stream(sentence.split(" ")).filter(word -> word.replaceAll("[^aeiouAEIOU]", "").length() == 3).forEach(System.out::println);

        // Divide given integer list into lists of even and odd numbers
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        List<Integer> list = Arrays.stream(arr).boxed().toList();
        List<List<Integer>> evenOddList = list.stream().collect(Collectors.partitioningBy(num -> num % 2 == 0, Collectors.toList())).values().stream().toList();
        System.out.println("evenOddList: " + evenOddList);
        System.out.println();

        // Find the occurrence of each character
        String stringOccurrence = "Mississippi";
        Map<String, Long> charOccurrence = Arrays.stream(stringOccurrence.toLowerCase().split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("charOccurrence: " + charOccurrence);
        System.out.println();

        // Re-arrange elements to form the highest/lowest value
        System.out.print("Array elements with lowest values: ");
        Arrays.stream(arr).boxed().sorted().forEach(System.out::print);
        System.out.println();
        System.out.print("Array elements with highest values: ");
        Arrays.stream(arr).boxed().sorted(Collections.reverseOrder()).forEach(System.out::print);
        System.out.println();

        // Find the sum of unique elements
        int sumOfUniqueElements = Arrays.stream(arr).distinct().sum();
        System.out.println("\nsumOfUniqueElements: " + sumOfUniqueElements);

        // Find the first non-repeated character in a given string -> For non-repeating character - first index and last index of character will be same
        String firstNonRepeatedCharacter= Arrays.stream(sentence.split("")).filter(character -> sentence.indexOf(character) == sentence.lastIndexOf(character)).findFirst().get();
        System.out.println("\nfirstNonRepeatedCharacter: " + (firstNonRepeatedCharacter.isEmpty() ? 0 : firstNonRepeatedCharacter));

        char firstNonRepeatedCharacterAlternateApproach = sentence.chars().mapToObj(character -> (char) character).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())).entrySet().stream().filter(entry -> entry.getValue() == 1).map(Map.Entry::getKey).findFirst().get();
        System.out.println("firstNonRepeatedCharacterAlternateApproach: " + firstNonRepeatedCharacterAlternateApproach);
        System.out.println();

        // Find the first repeated character in a given string
        char firstRepeatedCharacter = sentence.chars().mapToObj(character -> (char) character).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())).entrySet().stream().filter(entry -> entry.getValue() > 1).map(Map.Entry::getKey).findFirst().get();
        System.out.println("firstRepeatedCharacter: " + firstRepeatedCharacter);
        System.out.println();

        // Group the numbers by the range in a given array of integers
        int[] rangeArray = {2, 3, 10, 14, 20, 24, 30, 34, 40, 44, 50, 55, 60};
        Map<Integer, List<Integer>> groupedByRange = Arrays.stream(rangeArray).boxed().collect(Collectors.groupingBy(num -> (num / 10) * 10, LinkedHashMap:: new, Collectors.toList()));
        System.out.println("groupedByRange: " + groupedByRange);
        System.out.println();

    }
}