package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class topKFrequent {

    public int[] topKFrequentElements(int[] nums, int k) {

        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        int[] result = new int[k];
        int counter = 0;

        for (int position = bucket.length -1; position >= 0 && counter < k; position--) {
            if (bucket[position] != null) {
                for (Integer integer : bucket[position]) {
                    result[counter++] = integer;
                }
            }
        }

        return result;


    }



}
