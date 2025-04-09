package com.company;

import java.util.Stack;

public class validParentheses {

    public static boolean isValidParenthesis(String s) {

        char[] sArray = s.toCharArray();
        Stack<Character> expectedParen = new Stack<Character>();

        for (char c : sArray) {
            if (c == '(') {
                expectedParen.push(')');
            } else if (c == '{') {
                expectedParen.push('}');
            } else if (c == '[') {
                expectedParen.push(']');
            } else if (expectedParen.isEmpty() || expectedParen.pop() != c) {
                return false;
            }
        }

        return expectedParen.isEmpty();

    }

}
