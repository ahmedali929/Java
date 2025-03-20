package com.company;

import java.util.HashMap;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] numbers = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(numbers));
    }

    public static int longestConsecutive(int[] nums) {

        int longestLength = 0;
        HashMap<Integer, Boolean> numsMap = new HashMap<>();
        for (int num : nums) {
            numsMap.put(num, Boolean.FALSE);
        }

        for (int num : nums) {
            int currentLength = 1;

            //Check in the positive direction
            int nextNum = num + 1;
            while (numsMap.containsKey(nextNum) && !numsMap.get(nextNum)) {

                currentLength++;
                numsMap.put(nextNum, Boolean.TRUE);;

                nextNum++;
            }

            //Check in the negative direction
            int prevNum = num--;
            while (numsMap.containsKey(prevNum) && !numsMap.get(prevNum)) {

                currentLength++;
                numsMap.put(prevNum, Boolean.TRUE);

                prevNum--;
            }

            longestLength = Math.max(longestLength, currentLength);
        }

        return longestLength;

    }

}
