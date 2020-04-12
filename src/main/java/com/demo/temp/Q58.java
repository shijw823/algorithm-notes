package com.demo.temp;

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

        StringBuilder result = new StringBuilder();
        for (String sentenceTemp : sentenceArray) {
            result.append(sentenceTemp).append(" ");
        }
        return result.toString();
    }
}
