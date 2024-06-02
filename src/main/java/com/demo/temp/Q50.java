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
        String str = "abaccdeff";
        //String str = "ffedccaba";
        System.out.println(getCharacter(str));
        System.out.println(getCharacter2(str));

        System.out.println("---------------");
        String reusltStr = delSecondString("We are students", "aeiou");
        System.out.println(reusltStr);
    }

    // 空间复杂度O(k)， 不同字符的个数，最大26
    private static String getCharacter2(String str) {
        Map<String, Integer> resultMap = new LinkedHashMap<>();
        String[] strArray = str.split("");
        for (int i = 0; i < strArray.length; i++) {
            String s = strArray[i];
            resultMap.put(s, resultMap.getOrDefault(s, 0) + 1);
            //Integer num = resultMap.putIfAbsent(s, 1);
            //if (num != null) {
            //    resultMap.put(s, resultMap.get(s) + 1);
            //}
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
