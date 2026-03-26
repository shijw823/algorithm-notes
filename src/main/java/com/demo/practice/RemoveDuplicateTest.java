package com.demo.practice;

/**
 * @author shijianwei
 * @date 2025/12/31
 * https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string/description/
 */
public class RemoveDuplicateTest {
    // 使用 StringBuilder 模拟栈
    // 时间复杂度：O(n)
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            int len = sb.length();
            // 检查当前字符是否与栈顶字符相同
            if (len > 0 &&  c == sb.charAt(len-1)) {
                sb.deleteCharAt(len-1); // 删除栈顶字符
            } else {
                sb.append(c); // 入栈
            }
        }
        return sb.toString();
    }

    // 时间复杂度：O(n)， 空间复杂度：O(1)
    public String removeDuplicates2(String s) {
        char[] chars = s.toCharArray();
        int top = -1; // 栈顶指针

        for (int i = 0; i < chars.length; i++) {
            // 如果栈不为空且栈顶字符与当前字符相同，则弹出栈顶
            if (top >= 0 && chars[top] == chars[i]) {
                top--;
            } else {
                // 否则将当前字符压入栈
                chars[++top] = chars[i];
            }
        }

        return new String(chars, 0, top + 1);
    }
}
