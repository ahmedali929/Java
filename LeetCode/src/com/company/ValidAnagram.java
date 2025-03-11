package com.company;

import java.util.*;

public class ValidAnagram {

    public static void main(String[] args) {

        String test1 = "anagram";
        String test2 = "nagaram";
        System.out.print(isAnagram(test1, test2));
    }


    public static boolean isAnagram(String s,String t) {

        char[] sArray = s.toCharArray();
        Arrays.sort(sArray);
        char[] tArray = t.toCharArray();
        Arrays.sort(tArray);
        if (Arrays.equals(sArray, tArray)) {
            return true;
        }
        return false;

    }

}
