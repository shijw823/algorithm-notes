package com.demo.study;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 169
 */
public class MajorityDemo {

    public int majorityElement(int[] nums) {
        Map.Entry<Integer, Integer> resultEntry = null;

        Map<Integer, Integer> map = buildMap(nums);
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (resultEntry == null || entry.getValue() > resultEntry.getValue()) {
                resultEntry = entry;
            }
        }
        return resultEntry.getKey();
    }

    Map<Integer, Integer> buildMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        System.out.println(map);
        return map;
    }

    public static void main(String[] args) {
        MajorityDemo majorityDemo = new MajorityDemo();
        int[] nums = new int[] {3, 2, 3};
        int result = majorityDemo.majorityElement(nums);
        System.out.println(result);
    }
}
