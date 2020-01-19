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
                if (stack.isEmpty() || !map.get(key).equals(stack.peek())) {
                    System.out.println("匹配失败");
                    return false;
                } else {
                    stack.pop();
                }
            }

        }
        return stack.isEmpty();
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
