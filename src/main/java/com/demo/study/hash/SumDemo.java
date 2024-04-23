package com.demo.study.hash;

import java.util.*;

/**
 * 两个数求和等于某一值 1,15,18
 */
public class SumDemo {

    public static void main(String[] args) {
        int[] array = new int[] {2, 7, 11, 15};
        System.out.println(Arrays.toString(new SumDemo().twoSum(array, 18)));
        System.out.println(Arrays.toString(new SumDemo().twoSum2(array, 18)));

    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int y = target - nums[i];
            if (map.containsKey(y) && map.get(y) != i) {
                return new int[] {i, map.get(y)};
            }
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int y = target - nums[i];
            if (map.containsKey(y) && map.get(y) != i) {
                return new int[] {i, map.get(y)};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

}

