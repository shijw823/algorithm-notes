package com.demo.practice;

/**
 * @author shijianwei
 * @date 2025/12/29
 * https://leetcode-cn.com/problems/symmetric-tree/
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        // 两个都为空
        if(left == null && right == null) {
            return true;
        }
        // 只有一个为空
        if (left == null || right == null) {
            return false;
        }
        // 值不相等
        if (left.val != right.val) {
            return false;
        }
        // 递归比较：left的左子树和right的右子树，left的右子树和right的左子树
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
