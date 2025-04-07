package com.company;

public class containerMostWater {

    public int maxArea(int[] height) {
        int result = 0;

        int left = 0;
        int right = height.length-1;

        while (left < right) {
            if (height[left] < height[right]) {
                result = Math.max(result, height[left] * (right - left));
                left++;
            } else {
                result = Math.max(result, height[right] * (right - left));
                right--;
            }
        }
        return result;
    }

}
