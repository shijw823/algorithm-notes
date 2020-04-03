package com.demo.study;

import java.util.ArrayList;
import java.util.List;

/**
 **********************
 * 22
 */
public class ParenthesisDemo {

    public static void main(String[] args) {
        ParenthesisDemo parenthesisDemo = new ParenthesisDemo();
        parenthesisDemo.generateParenthesis(3);
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>(2 * n);
        generate("", result, n, n);
        System.out.println(result);
        return result;
    }

    /**
     *
     * @param subList
     * @param result 结果
     * @param left 左括号还剩的
     * @param right 右括号还剩的
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

        if (right > left) {
            System.out.println("right:" + subList);
            generate(subList + ")", result, left, right - 1);
        }
    }


}

