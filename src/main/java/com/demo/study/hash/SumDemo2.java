package com.demo.study.hash;

import java.util.*;

/**
 * *********************ok
 * @author shijianwei
 * @since 2020/04/01
 */
public class SumDemo2 {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 2, 2, 3, 4};
        List<List<Integer>> result = twoSum(array, 5);

        for (List<Integer> list : result) {
            System.out.println(list);
        }

        System.out.println("---------------");

        result = twoSum_(array, 5);

        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

    private static List<List<Integer>> twoSum_(int[] array, int sum) {
        Map<Integer, Integer> valueToIndex = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            int complement = sum - array[i];

            if (valueToIndex.containsKey(complement)) {
                int prevIndex = valueToIndex.get(complement);
                List<Integer> pair = Arrays.asList(prevIndex, i);
                result.add(pair);
            }

            valueToIndex.put(array[i], i);
        }

        return result;
    }


    private static List<List<Integer>> twoSum(int[] array, int sum) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
//            Integer key = array[i];
//            map.putIfAbsent(key, new HashSet<>());
//            map.get(key).add(i);
            map.computeIfAbsent(array[i], k -> new HashSet<>()).add(i);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int j = 0; j < array.length; j++) {
            int remain = sum - array[j];
            Set<Integer> indexSet = map.get(remain);
            if (indexSet != null && !indexSet.contains(j)) {
                for (Integer index : indexSet) {
                     //去掉重复，比如，1,2；2,1
                    if (j > index) {
                        result.add(Arrays.asList(index, j));
                    }
                }
            }
        }
        return result;
    }
}
