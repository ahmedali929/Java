package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum {

    public List<List<Integer>> three_sum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int target = -nums[i];
            int[] twoSumsArray = nums[:i+1];
            int[] twoSumResult = twoSum(nums[i], target);

        }





        return result;
    }


    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int total = numbers[left] + numbers[right];

            if (total == target) {
                return new int[]{left + 1, right + 1};
            } else if (total > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{-1, -1}; // If no solution is found
    }
}
