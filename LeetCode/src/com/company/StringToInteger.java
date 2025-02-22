package com.company;

public class StringToInteger {

    public static int myAtoi(String s) {
        if(s == null) {
            return 0;
        }

        int length = s.length();
        int index = 0;

        while(index < length && s.charAt(index) == ' ') {
            index++;
        }
        if(index == length) {
            return 0;
        }

        boolean isNegative = false;

        if(s.charAt(index) == '-' && index < length - 1) {
            isNegative = true;
            index++;
        } else if (s.charAt(index) == '+' && index<length-1) {
            isNegative = false;
            index++;
        }

        long result = 0;

        while(index < length) {
            char c = s.charAt(index);
            if(c < '0' || c > '9') {
                break;
            }
            result = result * 10 + (c - '0');
            if(result > Integer.MAX_VALUE) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            index++;
        }
        return (int) (isNegative ? -result : result);


    }

}
