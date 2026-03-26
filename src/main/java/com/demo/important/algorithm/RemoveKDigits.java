package com.demo.important.algorithm;

import java.util.Stack;

/**
 * RemoveKDigits
 * @@@@@
 * 删去k个数字后的最小值
 * see https://mp.weixin.qq.com/s/B22d7S_8IC3J3H7RbCVXxA
 *
 * 当栈顶数字大于遍历到的当前数字，栈顶数字出栈
 * O(n)
 *
 * @author shijianwei
 * @since 2019/02/19
 */
public class RemoveKDigits {

    public static void main(String[] args) {
        System.out.println(removeKDigits("1593212", 3));
        System.out.println(removeKDigits("30200", 1));
        System.out.println(removeKDigits("10", 2));
        System.out.println(removeKDigits("541270936", 3));
        System.out.println(removeKDigits("112", 1));
        System.out.println(removeKDigits("30200", 2));
    }

    public static String removeKDigits(String num, int k) {
        if (k >= num.length()) {
            return "0";
        }

        char[] stack = new char[num.length()];
        int top = -1; // 栈顶指针

        for (char digit : num.toCharArray()) {
            // 当还有删除次数，且栈不为空，且当前数字小于栈顶数字时
            while (k > 0 && top >= 0 && digit < stack[top]) {
                top--; // 弹出栈顶
                k--;
            }

            stack[++top] = digit; // 压入栈
        }

        System.out.println("top=" + top + ":k=" + k);

        // 如果还有剩余的k，从末尾删除
        top -= k;

        System.out.println(stack);

        // 移除前导零
        int start = 0;
        while (start <= top && stack[start] == '0') {
            start++;
        }

        System.out.println("start=" + start + ":top=" + top);

        // 处理结果
        if (start > top) {
            return "0";
        }

        return new String(stack, start, top - start + 1);
    }
}
