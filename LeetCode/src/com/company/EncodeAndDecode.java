package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeAndDecode {

    public static void main(String[] args) {
        List<String> testStrings = new ArrayList<>(Arrays.asList("this","is","a","test", "string"));
        String encodeTest = encode((testStrings));
        System.out.println("This is the encoded string: " + encodeTest);
        System.out.println("This is the decoded string: " + decode(encodeTest));
    }

    public static String encode(List<String> s) {
        StringBuilder result = new StringBuilder();
        for (String string : s) {
            result.append(string.length()).append("#").append(string);
        }
        return result.toString();
    }


    public static List<String> decode(String s) {
        List<String> result = new ArrayList<>();

        int i = 0;
        while( i < s.length()) {
            int j = i;
            while (s.charAt(j) != '#') {
                j += 1;
            }
            int length = Integer.parseInt(s.substring(i, j));
            result.add(s.substring(j+1, j + 1 + length));
            i = j + 1 + length;
        }
        return result;
    }


}
