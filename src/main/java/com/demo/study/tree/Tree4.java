package com.demo.study.tree;

/**
 * 二叉搜索树的最近公共祖先
 * 235,236
 * **********************
 *
 * @author shijianwei
 * @since 2020/04/05
 */
public class Tree4 {
    public static void main(String[] args) {

    }

    // 普通的树
    TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode leftTreeNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightTreeNode = lowestCommonAncestor(root.right, p, q);

        if (leftTreeNode == null) {
            return rightTreeNode;
        }

        if (rightTreeNode == null) {
            return leftTreeNode;
        }

        return root;
    }

    // 二叉搜索树
    TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        // 都在左子树
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        // 都在右子树
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        // 在左右子树中
        return root;
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
