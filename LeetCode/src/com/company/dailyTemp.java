package com.company;

import java.util.Stack;

public class dailyTemp {

    public static int[] dailyTemperatures(int[] temperatures) {

        Stack<Integer> helperStack = new Stack<>();

        int length = temperatures.length;
        int[] resultArray = new int[length];

        if (temperatures.length <= 0) {
            resultArray = null;
        } else {
            for (int n = length - 1; n >= 0; n--) {

                while (!helperStack.isEmpty() && temperatures[n] >= temperatures[helperStack.peek()]) {
                    helperStack.pop();
                }

                if(!helperStack.isEmpty()) {
                    resultArray[n] = helperStack.peek() - n;
                }

                helperStack.push(n);
            }
        }

        return resultArray;

    }

}
