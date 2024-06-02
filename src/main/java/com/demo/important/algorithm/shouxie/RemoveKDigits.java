package com.demo.important.algorithm.shouxie;

/**
 * @author shijianwei
 */
public class RemoveKDigits {
    public static void main(String[] args) {
        System.out.println(removeKDigits("1593212", 3));
        System.out.println(removeKDigits("30200", 1));
        System.out.println(removeKDigits("10", 2));
        System.out.println(removeKDigits("541270936", 3));
    }

    private static String removeKDigits(String str, int count) {
        if (str.length() == count) {
            return "0";
        }

        char[] result = new char[str.length() - count];

        char[] chars = str.toCharArray();
        int topIndex = 0;

        for(char ch : chars) {
            if(topIndex-1 >=0 && result[topIndex-1] > ch && count > 0) {
                topIndex--;
                count--;
            }

            result[topIndex++] = ch;
        }

        int begingIndex = 0;
        while(result[begingIndex] == '0') {
            begingIndex++;
        }

        return new String(result).substring(begingIndex);
    }
}
