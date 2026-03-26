package com.demo.practice;

/**
 * @author shijianwei
 * @date 2025/12/29
 * https://leetcode.cn/problems/valid-palindrome/submissions/151042923/
 */
public class PalindromeTest {
    // 双指针法 时间复杂度 O(n)，空间复杂度 O(1)（原地操作）
    public static boolean isPalindrome(String s) {
        if (s == null) return false;

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // 跳过非字母数字字符
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // 比较字符（忽略大小写）
            if (Character.toLowerCase(s.charAt(left)) !=
                    Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }
        return true;
    }
}
