package com.demo.temp;

/**
 * **********************??
 * 找出两个链表中的第一个公共节点
 *
 */
public class Q52 {
    public static void main(String[] args) {
        Q52 demo = new Q52();
        Node head = new Node("4");
        Node node11 = new Node("5");
        Node node12 = new Node("3");
        Node node13 = new Node("6");
        Node node14 = new Node("7");

        head.setNext(node11);
        node11.setNext(node12);
        node12.setNext(node13);
        node13.setNext(node14);

        System.out.println(head);

        Node head2 = new Node("4");
        Node node21 = new Node("5");
        head2.setNext(node21);
        node21.setNext(node14);

        System.out.println(head2);

        Node firstCommonNode = demo.getFirstCommonNode(head, head2);
        System.out.println(firstCommonNode);

        firstCommonNode = demo.getIntersectionNodeSimple(head, head2);
        System.out.println(firstCommonNode);

        firstCommonNode = demo.getIntersectionNodeSimple2(head, head2);
        System.out.println(firstCommonNode);
    }

    /**
     * 基本原理：
     *
     * 指针A从链表A头部开始，遍历完链表A后跳到链表B头部继续遍历
     *
     * 指针B从链表B头部开始，遍历完链表B后跳到链表A头部继续遍历
     *
     * 如果两个链表有交点，两个指针会在交点处相遇
     *
     * 如果两个链表没有交点，两个指针最终会同时为null
     *
     * 数学原理：
     *
     * 假设链表A非公共部分长度为a，链表B非公共部分长度为b，公共部分长度为c
     *
     * 指针A走过的路径：a + c + b（有交点时）
     *
     * 指针B走过的路径：b + c + a（有交点时）
     *
     * 两者路径长度相同，所以会在交点处相遇
     *
     * 时间复杂度：O(m+n)，其中m和n分别是两个链表的长度
     *
     * 空间复杂度：O(1)，只使用了两个指针变量
     *
     *
     *
     *
     * 链表A: 1 → 2 → 3
     *                     ↘
     *                       6 → 7 → null
     *                     ↗
     * 链表B:       4 → 5
     *
     * 在这个例子中：
     *
     * 链表A的非公共部分长度：3（节点1,2,3）
     *
     * 链表B的非公共部分长度：2（节点4,5）
     *
     * 公共部分长度：2（节点6,7）
     *
     * 两个指针的遍历路径：
     *
     * 指针A: 1→2→3→6→7→null→4→5→6
     *
     * 指针B: 4→5→6→7→null→1→2→3→6
     *
     * 两个指针在节点6处相遇，这是第一个公共节点。
     *
     * @param headA
     * @param headB
     * @return
     */
    // 最简洁的双指针法实现，时间复杂度：O(m+n)，其中m和n分别是两个链表的长度， 空间复杂度：O(1)，只使用了两个指针变量
    public Node getIntersectionNodeSimple(Node headA, Node headB) {
        Node a = headA, b = headB;

        // 两个指针同时前进，如果到达末尾则切换到另一个链表头部
        // 这个循环最多执行 m+n 次
        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }

        return a; // 返回交点或null
    }

    public Node getIntersectionNodeSimple2(Node headA, Node headB) {
        Node a = headA, b = headB;

        while(a != b) {
            if (a == null) {
                a = headB;
            } else {
                a = a.next;
            }
            if (b == null) {
                b = headA;
            } else {
                b = b.next;
            }
        }
        return a;
    }

    public Node getFirstCommonNode(Node head1, Node head2) {
        int len1 = getNodeLength(head1);
        int len2 = getNodeLength(head2);

        int diff = 0;
        if (len1 > len2) {
            diff = len1 - len2;
            for (int i = 0; i < diff; i++) {
                head1 = head1.next;
            }
        } else {
            diff = len2 - len1;
            for (int i = 0; i < diff; i++) {
                head2 = head2.next;
            }
        }

        System.out.println("diff=" + diff);

        while(head1 != null && head2 != null) {
            if (head1 == head2) {
                return head1;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return null;
    }

    public int getNodeLength(Node head) {
        int len = 0;
        Node node = head;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }


    static class Node {
        private String value;
        private Node next;

        public Node(String value) {
            this.value = value;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value='" + value + '\'' +
                    ", next=" + next +
                    '}';
        }
    }
}
