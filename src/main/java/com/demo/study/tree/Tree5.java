package com.demo.study.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 前中后序遍历
 * **********************ok
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
        tree5.preOrder(root, resultList);
        System.out.println(resultList);
        resultList = new ArrayList<>();
        tree5.postOrder(root, resultList);
        System.out.println(resultList);

        //Integer[] array = new Integer[] {1,6,3,4,7,5};
        //Integer[] array = new Integer[] {5,2,6,1,3};
        Integer[] array = new Integer[] {5,2,1,3,6};
        Integer[] array2 = new Integer[] {1,3,2,6,5};
        //Integer[] array = new Integer[] {7, 4, 1, 6, 5, 10, 8, 11};
        System.out.println(tree5.isPreOrder(array));
        System.out.println(tree5.isPostOrder(array2));
    }

    // shipin
    // 判断数组的顺序是否是二叉搜索树的前序遍历结果???
    // https://www.bilibili.com/video/BV1QR4y137G4?p=1&vd_source=c0d8eeb8eb3d1738b23ed3000979acdc
    // https://www.bilibili.com/video/BV1cG4y1m7si/?spm_id_from=333.337.search-card.all.click&vd_source=c0d8eeb8eb3d1738b23ed3000979acdc
    // 5,2,6,1,3  : false
    // 5,2,1,3,6  : true
    // 7 4 1 6 5 10 8 11 : true
    // O(n)
    public boolean isPreOrder(Integer[] array) {
        Stack<Integer> stack = new Stack<>();
        int min = -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                return false;
            }

            while (!stack.isEmpty() && array[i] > stack.peek()) {
                min = stack.pop();
            }

            stack.push(array[i]);
        }
        return true;
    }

    public boolean isPostOrder(Integer[] array) {
        Stack<Integer> stack = new Stack<>();
        int max = Integer.MAX_VALUE;

        for (int i = array.length-1; i >= 0; i--) {
            if (array[i] > max) {
                return false;
            }

            while (!stack.isEmpty() && array[i] < stack.peek()) {
                max = stack.pop();
            }

            stack.push(array[i]);
        }
        return true;
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
