package com.demo.study.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 判断一棵树是否是二叉搜索树 98
 * O(N)
 */
public class BSTDemo {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(27);
        TreeNode level2Left = new TreeNode(14);
        TreeNode level2Right = new TreeNode(35);
        root.left = level2Left;
        root.right = level2Right;

        TreeNode level3Left = new TreeNode(10);
        TreeNode level3Right = new TreeNode(19);
        level2Left.left = level3Left;
        level2Left.right = level3Right;
        TreeNode level3Left2 = new TreeNode(31);
        TreeNode level3Right2 = new TreeNode(42);
        level2Right.left = level3Left2;
        level2Right.right = level3Right2;

        BSTDemo demo = new BSTDemo();
        System.out.println(demo.isValidBST(root));
        System.out.println(demo.isValidBST2(root));
    }

    // Binary Search Tree
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min) {
            return false;
        }
        if (max != null && root.val >= max) {
            return false;
        }

        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    // 中序遍历出来的数据是有序的
    public boolean isValidBST2(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        inOrder(root, resultList);
        System.out.println(resultList);
        for (int i = 0; i < resultList.size()-1; i++) {
            if (resultList.get(i) > resultList.get(i+1)) {
                return false;
            }
        }
        return true;
    }

    private void inOrder(TreeNode root, List<Integer> resultList) {
        if (root != null) {
            inOrder(root.left, resultList);
            resultList.add(root.val);
            inOrder(root.right, resultList);
        }
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
