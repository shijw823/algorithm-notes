package com.demo.study.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 前中后序遍历
 *
 * @author shijianwei
 * @since 2020/04/05
 */
public class Tree5 {

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

        Tree5 tree5 = new Tree5();
        List<Integer> resultList = new ArrayList<>();
        //tree5.preOrder(root, resultList);
        //System.out.println(resultList);
        tree5.postOrder(root, resultList);
        System.out.println(resultList);

        Integer[] array = new Integer[] {1,6,3,4,7,5};
        System.out.println(tree5.isPreOrder(array));
    }

    // 判断数组的顺序是否是二叉搜索树的前序遍历结果???
    public boolean isPreOrder(Integer[] array) {
        if (array.length <= 1) {
            return true;
        }
        int root = array[0];
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

        for (int i = 1; i < array.length; i++) {
            if (array[i] < root) {
                leftList.add(array[i]);
            } else {
                rightList.add(array[i]);
            }
        }
        return isPreOrder(leftList.toArray(new Integer[0])) &&
                isPreOrder(rightList.toArray(new Integer[0]));
    }

    // 前序遍历
    public void preOrder(TreeNode root, List<Integer> resultList) {
        if (root != null) {
            resultList.add(root.val);
            preOrder(root.left, resultList);
            preOrder(root.right, resultList);
        }
    }

    // 中序遍历
    public void inOrder(TreeNode root, List<Integer> resultList) {
        if (root != null) {
            inOrder(root.left, resultList);
            resultList.add(root.val);
            inOrder(root.right, resultList);
        }
    }

    // 后序遍历
    public void postOrder(TreeNode root, List<Integer> resultList) {
        if (root != null) {
            postOrder(root.left, resultList);
            postOrder(root.right, resultList);
            resultList.add(root.val);
        }
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
