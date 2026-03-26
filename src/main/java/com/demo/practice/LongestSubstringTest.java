package com.demo.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 *
 * @author shijianwei
 * @date 2026/1/23
 */
public class LongestSubstringTest {
    // 时间复杂度：O(n) 空间复杂度：O(min(n, m))
    public int lengthOfLongestSubstring(String s) {
        // 哈希表存储字符最近出现的位置
        Map<Character, Integer> charIndex = new HashMap<>();
        int maxLength = 0;
        int left = 0; // 滑动窗口左边界

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // 如果字符已存在且位置在窗口内，则移动左边界
            if (charIndex.containsKey(currentChar) && charIndex.get(currentChar) >= left) {
                left = charIndex.get(currentChar) + 1;
            }

            // 更新字符最新位置
            charIndex.put(currentChar, right);

            // 计算当前窗口长度并更新最大值
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
