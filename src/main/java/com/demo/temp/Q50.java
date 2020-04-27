package com.demo.temp;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 第一个只出现一次的字符
 * 时间复杂度O(n)，空间复杂度O(1)
 */
public class Q50 {

    public static void main(String[] args) {
        String str = "abaccdeff";
        System.out.println(getCharacter(str));

        System.out.println("---------------");
        String reusltStr = delSecondString("We are students", "aeiou");
        System.out.println(reusltStr);
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
            Integer count = resultMap.putIfAbsent(c, 1);
            if (count != null) {
                resultMap.put(c, resultMap.get(c) + 1);
            }
        }
        return resultMap;
    }

    public static String delSecondString(String firstStr, String secondStr) {
        Map<Character, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < secondStr.length(); i++) {
            Character c = secondStr.charAt(i);
            Integer count = resultMap.putIfAbsent(c, 1);
            if (count != null) {
                resultMap.put(c, resultMap.get(c) + 1);
            }
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
