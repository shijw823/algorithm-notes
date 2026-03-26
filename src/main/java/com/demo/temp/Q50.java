package com.demo.temp;

import java.util.*;

/**
 * **********************??
 * 第一个只出现一次的字符
 * 387
 * 时间复杂度O(n)，空间复杂度O(1)
 */
public class Q50 {

    public static void main(String[] args) {
//        String str = "abaccdeff";
        String str = "ffedccaba";
        System.out.println(getCharacter(str));
        System.out.println(getCharacter2(str));
        System.out.println(getCharacter3(str));

        System.out.println("---------------");
        String reusltStr = delSecondString("We are students", "aeiou");
        System.out.println(reusltStr);
    }

    // 时间复杂度O(n)，空间复杂度O(1)
    private static Character getCharacter3(String str) {
        // 假设字符集只包含小写字母（26个）
        // 如果字符集更大，但仍然是固定大小的，空间复杂度仍然是O(1)
        int[] count = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            count[c - 'a'] ++;
        }

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (count[c - 'a'] == 1) {
                return c;
            }
        }
        return null;
    }

    // 空间复杂度O(k)， 不同字符的个数，最大26
    private static String getCharacter2(String str) {
        Map<String, Integer> resultMap = new LinkedHashMap<>();
        String[] strArray = str.split("");
        for (int i = 0; i < strArray.length; i++) {
            String s = strArray[i];
            resultMap.put(s, resultMap.getOrDefault(s, 0) + 1);
        }
        for (int i = 0; i < strArray.length; i++) {
            if (resultMap.get(strArray[i]) == 1) {
                return strArray[i];
            }
        }
        return "";
    }

    private static Character getCharacter(String str) {
        Map<Character, Integer> resultMap = buildMap(str);
        System.out.println(resultMap);
        if (resultMap.isEmpty()) {
            return null;
        }
        for (int i = 0; i < str.length(); i++) {
            if (resultMap.get(str.charAt(i)) == 1) {
                return str.charAt(i);
            }
        }
        return null;
    }

    private static Map<Character, Integer> buildMap(String str) {
        Map<Character, Integer> resultMap = new HashMap<>();

        if (Objects.isNull(str)) {
            return resultMap;
        }

        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            resultMap.put(c, resultMap.getOrDefault(c, 0) + 1);
        }
        return resultMap;
    }

    public static String delSecondString(String firstStr, String secondStr) {
        Map<Character, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < secondStr.length(); i++) {
            Character c = secondStr.charAt(i);
            resultMap.put(c, resultMap.getOrDefault(c, 0) + 1);
        }

        String resultStr = "";
        for (int j = 0; j < firstStr.length(); j++) {
            if (resultMap.get(firstStr.charAt(j)) == null) {
                resultStr += firstStr.charAt(j);
            }
        }
        return resultStr;
    }
}
