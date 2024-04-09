package com.demo.study.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 栈应用demo
 * 判断括号字符串是否有效
 */
public class StackDemo {

    public static void main(String[] args) {
        String str = "](([]))";

        System.out.println(isValid(str));
    }

    /**
     * 优选选择这种
     *
     * @param str 要验证的字符串
     * @return 括号是否匹配
     */
    public static boolean isValid(String str) {
        Map<String, String> map = new HashMap<>();
        map.put(")", "(");
        map.put("]", "[");
        map.put("}", "{");

        String[] strArray = str.split("");

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < strArray.length; i++) {
            String key = strArray[i];
            if (map.values().contains(key)) {
                stack.push(key);
            } else {
                if (stack.isEmpty() || !map.get(key).equals(stack.pop())) {
                    System.out.println("匹配失败");
                    return false;
                } 
            }

        }
        return stack.isEmpty();
    }

    // 空间复杂度为o(1)
    // https://mp.weixin.qq.com/s/UGb5B75W3r2yYL673E6LTQ
    public static boolean isValid3(String s) {
        if (s == null || s.length() < 1) {
            return true;
        }
        int n = s.length();// 字符串长度
        // 用来记录遇到的 "(" 的个数
        int sum = 0;
        // 遍历字符串
        for (int i = 0; i < n; i++) {
            // 获取字符串的第 i 个字符
            char c = s.charAt(i);
            if (c == '(') {
                sum++;
            } else {
                if (sum == 0) {
                    return false;
                } else {
                    sum--;
                }
            }
        }
        return sum == 0;
    }

    public static boolean isValid2(String str) {
        int len;
        do {
            len = str.length();
            str = str.replace("()", "").replace("[]", "")
                    .replace("{}", "");
        } while (len != str.length());
        return str.length() == 0;
    }
}
