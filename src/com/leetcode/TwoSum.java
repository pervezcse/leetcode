package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numIndexmap = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            int complement = target - nums[i];
            if(numIndexmap.containsKey(complement)) {
                return new int[] {i, numIndexmap.get(complement)};
            } else {
                numIndexmap.put(nums[i], i);
            }
        }
        return new int[0];
    }
}
