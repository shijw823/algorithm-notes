package com.demo.study;

import java.util.ArrayList;
import java.util.List;

/**
 **********************ok
 * 22
 * 括号
 * O(2 ^ n)
 */
public class ParenthesisDemo {

    public static void main(String[] args) {
        ParenthesisDemo parenthesisDemo = new ParenthesisDemo();
        parenthesisDemo.generateParenthesis(3);
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate("", result, n, n);
        System.out.println(result);
        return result;
    }

    /**
     *
     * @param subList 拼接的括号数据
     * @param result 最终结果
     * @param left 左括号还剩几个括号可用
     * @param right 右括号还剩几个括号可用
     */
    private void generate(String subList, List<String> result, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(subList);
            return;
        }

        if (left > 0) {
            System.out.println("left:" + subList);
            generate(subList + "(", result, left - 1, right);
        }

        // 左括号剩余可用的要少于右括号
        if (right > left) {
            System.out.println("right:" + subList);
            generate(subList + ")", result, left, right - 1);
        }
    }

}

