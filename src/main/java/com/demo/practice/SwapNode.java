package com.demo.practice;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/description/
 * @author shijianwei
 * @date 2025/12/26
 */
public class SwapNode {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // 方法2：实际交换节点（改变节点连接关系）
    public ListNode swapPairs(ListNode head) {
        // 创建虚拟头节点，简化边界条件处理
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {
            // 需要交换的两个节点
            ListNode first = prev.next;
            ListNode second = prev.next.next;

            // 执行交换
            // 1. 前驱节点指向第二个节点
            prev.next = second;
            // 2. 第一个节点指向第二个节点的后继
            first.next = second.next;
            // 3. 第二个节点指向第一个节点
            second.next = first;

            // 移动prev指针到下一对的前一个节点
            prev = first;
        }

        return dummy.next;
    }

    /**
     * 时间复杂度：O(n) 空间复杂度：O(1)
     *
     * 交换前：prev -> first -> second -> next
     * 交换后：prev -> second -> first -> next
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head) {
        // 创建虚拟头节点，简化边界条件处理
        ListNode prev = new ListNode(0);
        prev.next = head;
        ListNode result = head.next;

        while (prev.next != null && prev.next.next != null) {
            // 需要交换的两个节点
            ListNode first = prev.next;
            ListNode second = prev.next.next;

            // 执行交换
            // 1. 前驱节点指向第二个节点
            prev.next = second;
            // 2. 第一个节点指向第二个节点的后继
            first.next = second.next;
            // 3. 第二个节点指向第一个节点
            second.next = first;

            // 移动prev指针到下一对的前一个节点
            prev = first;
        }

        return result;
    }

    public static void main(String[] args) {
        // 创建链表 1->2->3->4
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        SwapNode solution = new SwapNode();

        System.out.println("方法2（交换节点）:");
        printList(solution.swapPairs2(head));

    }

    // 打印链表
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}
