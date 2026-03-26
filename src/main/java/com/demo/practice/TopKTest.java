package com.demo.practice;

import com.demo.TopK;

import java.util.*;

/**
 * @author shijianwei
 * @date 2025/12/29
 * https://leetcode.cn/problems/top-k-frequent-words/
 */
public class TopKTest {

    public List<String> topKFrequent(String[] words, int k) {
        // 1. 统计单词频率
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        // 2. 创建优先队列（最小堆），自定义比较器
        // 堆中保持k个元素，堆顶是"最小"的元素（根据我们的比较规则）
        PriorityQueue<String> minHeap = new PriorityQueue<>((i,j) -> {
            int freqCompare = frequencyMap.get(i).compareTo(frequencyMap.get(j));
            if (freqCompare != 0) {
                // 频率升序（因为是最小堆，频率小的在堆顶）
                return freqCompare;
            }
            // 频率相同则按字典序降序（这样字典序小的会在堆顶下面）
            return j.compareTo(i);
        });

        // 3. 维护大小为k的最小堆
        for (String word : frequencyMap.keySet()) {
            minHeap.offer(word);
            if (minHeap.size() > k) {
                minHeap.poll(); // 移除堆顶（当前"最小"的元素）
            }
        }

        // 4. 构建结果列表（需要反转顺序，因为堆顶是最小的）
        List<String> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }
        Collections.reverse(result);

        return result;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        List<String> list = new TopKTest().topKFrequent(words, k);
        System.out.println(list);
    }
}
