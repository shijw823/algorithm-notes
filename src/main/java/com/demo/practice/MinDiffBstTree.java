package com.demo.practice;

/**
 * @author shijianwei
 * @date 2025/12/29
 * https://leetcode.cn/problems/minimum-distance-between-bst-nodes/
 */
public class MinDiffBstTree {
    private int minDiff = Integer.MAX_VALUE;
    private Integer prev = null;


    // 时间复杂度O(n)，空间复杂度O(h) h是树的高度
    public int minDiffInBST(TreeNode root) {
        inorderTraversal(root);
        return minDiff;
    }

    private void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left);

        if (prev != null) {
            minDiff = Math.min(minDiff, Math.abs(root.val - prev));
        }
        prev = root.val;


        inorderTraversal(root.right);
    }
}
