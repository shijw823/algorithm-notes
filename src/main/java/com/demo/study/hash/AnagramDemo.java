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
        System.out.println(anagramDemo.isAnagram_("car", "act"));;
    }

    public boolean isAnagram_(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] array = new int[26];
        for (int i = 0; i < s.length(); i++) {
            array[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            if (array[t.charAt(i) - 'a'] == 0) {
                return false;
            }
            array[t.charAt(i) - 'a']--;
        }
        return true;
    }

    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        if (s.length() != t.length()) {
            return false;
        }

        convertStr2Map(s, sMap);

        convertStr2Map(t, tMap);

        return sMap.equals(tMap);
    }

    // O(n)
    private void convertStr2Map(String s, Map<Character, Integer> sMap) {
        for (int i = 0; i < s.length(); i++) {
            Character key = s.charAt(i);
            sMap.put(key, sMap.getOrDefault(key, 0) + 1);
        }
    }

    // O(nlgn)，这个不太好
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
