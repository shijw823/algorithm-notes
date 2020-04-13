package com.demo.important.algorithm;

/**
 * *********************
 * RemoveKDigits
 * 删去k个数字后的最小值
 * see https://mp.weixin.qq.com/s/B22d7S_8IC3J3H7RbCVXxA
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
    }

    private static String removeKDigits(String nums, int k) {
        char[] result = new char[nums.length() - k];

        if (nums.length() == k) {
            return "0";
        }

        int length = result.length;
        int topIndex = 0;
        for (int i = 0; i<nums.length(); i++) {
            char c = nums.charAt(i);

            if(topIndex > 0 && result[topIndex - 1] > c && k > 0) {
                topIndex -= 1;
                k -= 1;
            }

            result[topIndex++] = c;
        }

        int offset = 0;
        while(offset < length && result[offset] == '0') {
            offset ++;
        }

        return new String(result).substring(offset);

        // return new String(result, offset, length - offset);
    }
}
