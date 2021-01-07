package com.InRhythm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LongestWord {

    /**
     * the method to input data by user
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter some sentence here:");
        String s = scan.nextLine();
        System.out.println("You entered: " + s);
        List<String> output = getInput(s);
        System.out.println("Your input has " + output.get(0) + " words.");
        output.remove(0);
        System.out.println("Biggest word(s):");
        output.forEach(System.out::println);
    }

    /**
     * the method to count the words in string and to find the biggest word in this string
     *
     * @param str - input from user or test
     * @return ArrayList of String - amount of words in input and
     */
    public static List<String> getInput(String str) {
        List<String> list = new ArrayList<>();
        //replace all non words in string with one space
        String modifiedInput = str.replaceAll("\\W+", " ");
        //get array of words from modified sentence
        String[] arr = modifiedInput.split(" ");

        //if a sentence start with special symbol, we should remove first empty element from array
        if (arr.length > 0 && arr[0].equals("")) {
            List<String> toList = new ArrayList<>(Arrays.asList(arr));
            toList.remove(0);
            String[] newArray = new String[toList.size()];
            arr = toList.toArray(newArray);
        }
        //add number of words to new ArrayList for returning
        list.add(String.valueOf(arr.length));
        //check if sentence has at least one word
        if (arr.length == 0) {
            return list;
        }
        //determinate the max length of words
        int max = arr[0].length();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].length() > max) {
                max = arr[i].length();
            }
        }
        //add the words with ax length to existed ArrayList for returning
        for (String word : arr) {
            if (word.length() == max) {
                list.add(word);
            }
        }
        //return ArrayList with amount of words and words with max length
        return list;
    }


}
