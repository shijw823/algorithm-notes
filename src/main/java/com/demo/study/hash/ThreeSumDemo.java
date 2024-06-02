package com.demo.study.hash;

import java.util.*;

/**
 * *********************ok
 * 三个数求和为零 15
 * O(n * n)
 */
public class ThreeSumDemo {

    public static void main(String[] args) {
        int[] array = new int[]{-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
        List<List<Integer>> result = new ThreeSumDemo().threeSum(array);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Set<String>> map = new HashMap<>();

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int z = nums[i] + nums[j];
                map.putIfAbsent(-z, new HashSet<>());
                map.get(-z).add(i + ":" + j);
            }
        }

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i])) {
                Set<String> tempStrSet = map.get(nums[i]);
                for (String str : tempStrSet) {
                    List<Integer> list = new ArrayList<>();
                    String[] indexArray = str.split(":");
                    if (!indexArray[0].equals(String.valueOf(i)) && !indexArray[1].equals(String.valueOf(i))) {
                        list.add(nums[i]);
                        list.add(nums[Integer.parseInt(indexArray[0])]);
                        list.add(nums[Integer.parseInt(indexArray[1])]);
                    }

                    if (list.size() > 0) {
                        // 去重
                        boolean repeatFlag = false;
                        for (List<Integer> resultList : result) {
                            if (new HashSet<>(resultList).equals(new HashSet<>(list))) {
                                repeatFlag = true;
                                break;
                            }
                        }
                        if (!repeatFlag) {
                            result.add(list);
                        }
                    }
                }
            }
        }
        return result;
    }

}

