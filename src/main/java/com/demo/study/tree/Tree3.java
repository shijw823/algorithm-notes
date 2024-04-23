package com.demo.study.tree;

/**
 * 104\111
 * 求二叉树的最小和最大深度 O(n)
 *
 * @author shijianwei
 * @since 2020/04/04
 */
public class Tree3 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode level2Left = new TreeNode(9);
        TreeNode level2Right = new TreeNode(20);
        root.left = level2Left;
        root.right = level2Right;

        TreeNode level3Left = new TreeNode(15);
        TreeNode level3Right = new TreeNode(7);
        level2Right.left = level3Left;
        level2Right.right = level3Right;

        Tree3 tree3 = new Tree3();
        System.out.println(tree3.maxDepth(root));
        System.out.println(tree3.minDepth(root));
    }

    // 递归 or BFS
    int maxDepth(TreeNode node) {
        return node == null ? 0 : 1 + Math.max(maxDepth(node.left), maxDepth(node.right));

        //int level = 0;
        //Queue<TreeNode> queue = new LinkedList<>();
        //queue.add(node);
        //
        //while (!queue.isEmpty()) {
        //    int size = queue.size();
        //    level++;
        //    for (int i = 0; i < size; i++) {
        //        TreeNode currentNode = queue.poll();
        //        if (currentNode.left != null) {
        //            queue.add(currentNode.left);
        //        }
        //        if (currentNode.right != null) {
        //            queue.add(currentNode.right);
        //        }
        //    }
        //}
        //return level;
    }

    // 递归 or BFS
    int minDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftMin = minDepth(node.left);
        int rightMin = minDepth(node.right);

        // 没有左子树或者右子树
        if (leftMin == 0 || rightMin == 0) {
            return leftMin + rightMin + 1;
        }

        return 1 + Math.min(leftMin, rightMin);

        //int level = 0;
        //Queue<TreeNode> queue = new LinkedList<>();
        //queue.add(node);
        //
        //while (!queue.isEmpty()) {
        //    int size = queue.size();
        //    level++;
        //    for (int i = 0; i < size; i++) {
        //        TreeNode currentNode = queue.poll();
        //        if (currentNode.left == null && currentNode.right == null) { // 叶子节点
        //            return level;
        //        }
        //        if (currentNode.left != null) {
        //            queue.add(currentNode.left);
        //        }
        //        if (currentNode.right != null) {
        //            queue.add(currentNode.right);
        //        }
        //    }
        //}
        //return level;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
