package com.demo.study;

import java.util.ArrayList;
import java.util.List;

/**
 * 22
 */
public class ParenthesisDemo {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate("", result, n, n);
        System.out.println(result);
        return result;
    }

    private void generate(String subList, List<String> result, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(subList);
            return;
        }

        if (left > 0) {
            generate(subList + "(", result, left - 1, right);
        }

        if (right > left) {
            generate(subList + ")", result, left, right - 1);
        }
    }


}

