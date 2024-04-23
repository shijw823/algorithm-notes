package com.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 查找数组中重复的数
 * 长度为n的数组，所有的数字在0~n-1
 *
 */
public class FindRepeatNumber {

    public static void main(String[] args) {
        FindRepeatNumber test = new FindRepeatNumber();
        int[] array = new int[] {2,3,1,0,2,5,3};
        List<Integer> resultList = test.findRepeatNum2(array);
        System.out.println(resultList);

    }

    // 时间复杂度：O(n)，空间复杂度:O(1)

    /**
     * 2 3 1 0 2 5 3
     * 1 3 2 0 2 5 3
     * 3 1 2 0 2 5 3
     * 0 1 2 3 2 5 3
     *     * # *   #
     * @param array
     * @return
     */
    private List<Integer> findRepeatNum2(int[] array) {
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            while(i != array[i]) {
                if (array[i] == array[array[i]]) {
                    resultList.add(array[i]);
                    break;
                } else {
                    int temp = array[i];
                    array[i] = array[temp];
                    array[temp] = temp;
                }
            }

        }
        return resultList;
    }


    // 时间复杂度：O(n)，空间复杂度:O(n)
    private List<Integer> findRepeatNum(int[] array) {
        List<Integer> resultList = new ArrayList<>();
        Map<Integer, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            Integer result = resultMap.putIfAbsent(array[i], 1);
            if (result != null) {
                resultList.add(array[i]);
            }

        }
        return resultList;
    }
}
