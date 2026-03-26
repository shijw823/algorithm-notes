package com.demo.practice;

/**
 * @author shijianwei
 * @date 2025/12/30
 * https://leetcode.cn/problems/linked-list-cycle/
 */
public class DetectCycleTest {
    // 时间复杂度：O(n)， 空间复杂度：O(1)
    public ListNode detectCycle(ListNode head) {
        // 边界条件处理
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        // 第一步：检测是否有环
        while (fast != null && fast.next != null) {
            slow = slow.next;          // 慢指针每次走一步
            fast = fast.next.next;     // 快指针每次走两步

            // 快慢指针相遇，说明有环
            if (slow == fast) {
                // 第二步：找到环的入口
                ListNode entry = head;

                // 从头节点和相遇点同时出发，每次走一步
                // 当它们相遇时，就是环的入口
                while (entry != slow) {
                    entry = entry.next;
                    slow = slow.next;
                }
                return entry;  // 返回环的入口节点
            }
        }

        // 无环
        return null;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
