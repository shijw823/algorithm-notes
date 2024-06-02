package com.demo.study.tree;

/**
 * 二叉搜索树的最近公共祖先
 * 235,236
 * **********************ok
 * O(n)
 *
 * shipin
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
            return lowestCommonAncestor2(root.left, p, q);
        }

        // 都在右子树
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor2(root.right, p, q);
        }

        // 在左右子树中
        return root;
    }

    // 二叉搜索树 非递归
    TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null) {
            // 都在左子树
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                // 都在右子树
                root = root.right;
            } else {
                // 在左右子树中
                return root;
            }
        }
        return null;
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
