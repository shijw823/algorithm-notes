package com.demo.temp;

import java.util.Arrays;
import java.util.Objects;

/**
 * 翻转字符串
 *
 * @author shijianwei
 * @since 2020/04/11
 */
public class Q58 {
    public static void main(String[] args) {
        Q58 demo = new Q58();
        String sentence = "I am a students.";
        String result = demo.reverseSentence(sentence);
        System.out.println(result);

        result = demo.reverseWords(sentence);
        System.out.println(result);
    }

    private String reverseSentence(String sentence) {
        if (Objects.isNull(sentence)) {
            return null;
        }

        String[] sentenceArray = sentence.split(" ");
        for (int i = 0; i < sentenceArray.length / 2; i++) {
            String temp = sentenceArray[i];
            sentenceArray[i] = sentenceArray[sentenceArray.length - i -1];
            sentenceArray[sentenceArray.length - i -1] = temp;
        }
        //[students., a, am, I]
        //return Arrays.toString(sentenceArray);

        StringBuilder result = new StringBuilder();
        for (String sentenceTemp : sentenceArray) {
            result.append(sentenceTemp).append(" ");
        }
        return result.toString();
    }

    public static String reverseWords(String str) {
        if (str == null || str.trim().isEmpty()) {
            return str;
        }

        // 去除首尾空格，按一个或多个空格分割
        String[] words = str.trim().split("\\s+");
        StringBuilder result = new StringBuilder();

        // 从后往前添加单词
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if (i > 0) {
                result.append(" ");
            }
        }

        return result.toString();
    }
}
