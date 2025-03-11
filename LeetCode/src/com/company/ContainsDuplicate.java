package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public boolean containDuplicate(int[] nums) {

        Set<Integer> uniqueInt = new HashSet<Integer>();

        if (nums.length > 0) {
            for (int integer : nums) {
                if (!uniqueInt.add(integer)) {
                    return true;
                }
                uniqueInt.add(integer);
            }
        }

        return false;
    }

}
