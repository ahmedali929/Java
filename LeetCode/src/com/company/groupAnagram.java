package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class groupAnagram {

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};

        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> solutionSet = new ArrayList<>();
        HashMap<String, List<String>> stringCollections = new HashMap<>();

        for(String s : strs) {
            String frequency = getFrequency(s); //get freqString
            if (stringCollections.containsKey(frequency)) {
                stringCollections.get(frequency).add(s);
            } else {
                List<String> stringList = new ArrayList<String>(); //if the frequency is not already in the hashmap, then have to add it in along with a new List<String> which is what this line is for
                stringCollections.put(frequency, stringList);
                stringCollections.get(frequency).add(s);
            }
        }

        solutionSet.addAll(stringCollections.values());

        return solutionSet;

    }

    public static String getFrequency(String s) { //returns something like a4b2c4d0e0f0g4h1i0j0k...

        int[] charFrequency = new int[26];
        char[] charList = s.toCharArray();

        for (char c : charList) {
            charFrequency[c - 'a']++; //this increases the value by 1 of the letter place in the array, i.e. c-a finds the letter, and ++ increases it by 1
        }

        StringBuilder frequencyString = new StringBuilder("");
        char c = 'a';
        for (int i : charFrequency) {
            frequencyString.append(c); //adds letter i.e. 'a'
            frequencyString.append(i); //adds number to letter i.e 'a3'
            c++; //goes to next letter
        }

        return frequencyString.toString();

    }

}
