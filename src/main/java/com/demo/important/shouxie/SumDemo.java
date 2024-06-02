package com.demo.important.shouxie;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两个数求和等于某一值 1,15,18
 */
public class SumDemo {

    public static void main(String[] args) {
        int[] array = new int[] {2, 7, 11, 15};
        System.out.println(Arrays.toString(new SumDemo().twoSum(array, 17)));
        System.out.println(Arrays.toString(new SumDemo().twoSum2(array, 17)));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            resultMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int y = target - nums[i];
            if (resultMap.containsKey(y) && i != resultMap.get(y)) {
                return new int[] {i, resultMap.get(y)};
            }
        }

        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> resultMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int y = target - nums[i];
            if (resultMap.containsKey(y) && i != resultMap.get(y)) {
                return new int[]{i, resultMap.get(y)};
            }
            resultMap.put(nums[i], i);
        }
        return null;
    }

}

