package com.demo.important.shouxie;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 字符串中括号是否匹配
 *
 * @author shijianwei
 * @since 2019/03/02
 */
public class CharacterTest {
    private static Map<Character, Character> map = new HashMap<>();

    public static void main(String[] args) {
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        System.out.println(isMatch("(abc)a)("));
        System.out.println(isMatch2("(abc)a)("));
    }

    private static boolean isMatch(String strs) {
       Stack<Character> stack = new Stack<>();
        char[] chars = strs.toCharArray();
        for (char c : chars) {
            if (map.values().contains(c)) {
                stack.push(c);
            }

            else if (map.containsKey(c)) {
                if (stack.empty() || !stack.pop().equals(map.get(c))) {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    private static boolean isMatch2(String strs) {
        int sum = 0;
        for (int i = 0; i < strs.length(); i++) {
            char c = strs.charAt(i);
            if (c == '(') {
                sum++;
            } else if (c == ')') {
                if (sum == 0) {
                    return false;
                } else {
                    sum--;
                }
            }
        }
        return sum == 0;
    }
}
