package com.company;

import java.util.Locale;

public class validPalindrome {

    public static void main(String[] args) {

        String testS = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(testS));

    }

    public static boolean isPalindrome(String s) {
        if (s.isEmpty() || s.length() == 1) {
            return true;
        }

        String strippedString = "";
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c) || Character.isLetter(c)) {
                strippedString += c;
            }
        }

        strippedString = strippedString.toLowerCase();

        int left = 0;
        int right = strippedString.length()-1;

        while(left <= right) {
            if (strippedString.charAt(left) != strippedString.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;

    }

}
