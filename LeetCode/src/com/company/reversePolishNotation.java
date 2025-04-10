package com.company;

import java.util.Stack;

public class reversePolishNotation {


    public static int evalPRN(String[] tokens) {

        Stack<Integer> numStack = new Stack<>();


        if (tokens.length <= 0) {
            return 0;
        } else {

            for(String s : tokens) {
                if (s.equals("-")) {
                    int integer1 = numStack.pop();
                    int integer2 = numStack.pop();
                    int newValue = integer2 - integer1;
                    numStack.push(newValue);
                } else if(s.equals("+")) {
                    int integer1 = numStack.pop();
                    int integer2 = numStack.pop();
                    int newValue = integer2 + integer1;
                    numStack.push(newValue);
                } else if(s.equals("*")) {
                    int integer1 = numStack.pop();
                    int integer2 = numStack.pop();
                    int newValue = integer2 * integer1;
                    numStack.push(newValue);
                } else if(s.equals("/")) {
                    int integer1 = numStack.pop();
                    int integer2 = numStack.pop();
                    int newValue = integer2 / integer1;
                    numStack.push(newValue);
                }
                else {
                    numStack.push(Integer.parseInt(s));
                }
            }

        }
        return numStack.pop();
    }

}
