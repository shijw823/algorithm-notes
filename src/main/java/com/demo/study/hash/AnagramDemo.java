package com.demo.study.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 242
 */
public class AnagramDemo {

    public static void main(String[] args) {
        AnagramDemo anagramDemo = new AnagramDemo();
        System.out.println(anagramDemo.isAnagram("car", "act"));;
    }


    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            Character key = s.charAt(i);
            Integer count = sMap.putIfAbsent(key, 1);
            if (count != null) {
                sMap.put(key, sMap.get(key) + 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            Character key = t.charAt(i);
            Integer count = tMap.putIfAbsent(key, 1);
            if (count != null) {
                tMap.put(key, tMap.get(key) + 1);
            }
        }

        return sMap.equals(tMap);
    }

    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char c1[] = s.toCharArray();
        char c2[] = t.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);

        return String.valueOf(c1).equals(String.valueOf(c2));
    }
}
