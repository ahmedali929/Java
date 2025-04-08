package com.company;

public class trappingRainWater {

    public static void main(String[] args) {

        int[] test = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(test));
    }

    public static int trap(int[] height) {

        if (height.length < 1) {
            return 0;
        }

        int result = 0;

        int leftPointer = 0;
        int rightPointer = height.length-1;

        int maxLeft = 0;
        int maxRight = 0;

        while(leftPointer < rightPointer) {
            if (height[leftPointer] <= height[rightPointer]) {

                int units = maxLeft - height[leftPointer];
                result += Math.max(units, 0);

                if (height[leftPointer] > maxLeft) {
                    maxLeft = height[leftPointer];
                }
                leftPointer++;
            } else if (height[rightPointer] < height[leftPointer]) {

                int units = maxRight - height[rightPointer];
                result += Math.max(units, 0);

                if (height[rightPointer] > maxRight) {
                    maxRight = height[rightPointer];
                }

                rightPointer--;
            }
        }

        return result;


    }

}
