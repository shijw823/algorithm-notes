package com.demo.practice;

/**
 * @author shijianwei
 * @date 2025/12/31
 * https://leetcode-cn.com/problems/remove-outermost-parentheses/
 * @@@@@
 */
public class RemoveOuterParenthesesTest {
    // 时间复杂度：O(n)， 空间复杂度O(1)
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int balance = 0; // 平衡计数器

        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (balance > 0) { // 不是最外层的左括号
                    result.append(c);
                }
                balance++; // 增加深度
            } else { // c == ')'
                balance--; // 减少深度
                if (balance > 0) { // 不是最外层的右括号
                    result.append(c);
                }
            }
        }

        return result.toString();
    }
}
