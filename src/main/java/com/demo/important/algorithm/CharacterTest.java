package com.demo.important.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 优化：https://mp.weixin.qq.com/s/UGb5B75W3r2yYL673E6LTQ
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
    }

    private static boolean isMatch(String strs) {
        if(strs == null || "".equals(strs)) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        char[] chars = strs.toCharArray();
        for(char ch : chars) {
            // 左括号入栈
            if(map.values().contains(ch)) {
                stack.push(ch);
            }
            // 右括号出栈
            else if(map.containsKey(ch)) {
                if(stack.empty() || !stack.pop().equals(map.get(ch))) {
                    return false;
                }
            }
        }

        return stack.empty();
    }
}
