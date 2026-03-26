package com.demo.study.hash;

import java.util.*;

/**
 * *********************ok
 * 三个数求和为零 15
 * <p>
 * https://leetcode.cn/problems/3sum/
 * O(n * n)
 */
public class ThreeSumDemo {

    public static void main(String[] args) {
        int[] array = new int[]{-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
        List<List<Integer>> result = new ThreeSumDemo().threeSum(array);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
        System.out.println("------------------");
        result = new ThreeSumDemo().threeSum_(array);
        for (List<Integer> list : result) {
            System.out.println(list);
        }

        System.out.println("------------------");
        result = new ThreeSumDemo().threeSum_2(array);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> threeSum_2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        // 存储每个数最后出现的位置
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length - 1; i++) {
//            // 跳过重复
//            if (i > 0 && nums[i] == nums[i - 1]) {
//                continue;
//            }

            for (int j = i + 1; j < nums.length; j++) {
//                // 跳过重复
//                if (j > i + 1 && nums[j] == nums[j - 1]) {
//                    continue;
//                }
                int target = -nums[i] - nums[j];
                // 确保第三个数的索引大于j，避免重复
                if (map.containsKey(target) && map.get(target) > j) {
                    // 去重
                    if (!result.contains(Arrays.asList(nums[i], nums[j], target))) {
                        result.add(Arrays.asList(nums[i], nums[j], target));
                    }
                }
            }
        }

        return result;
    }

    // 使用HashMap（更通用的N数之和解法）
    public List<List<Integer>> threeSum_(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        // 存储每个数最后出现的位置
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length - 1; i++) {
            // 跳过重复
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length; j++) {
                // 跳过重复
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int target = -nums[i] - nums[j];
                // 确保第三个数的索引大于j，避免重复
                if (map.containsKey(target) && map.get(target) > j) {
                    result.add(Arrays.asList(nums[i], nums[j], target));
                }
            }
        }

        return result;
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

