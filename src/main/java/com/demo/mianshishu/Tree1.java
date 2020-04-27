package com.demo.mianshishu;

import java.util.*;

/**
 * 打印二叉树中和为某一值的路径
 *   10
 *  5 12
 * 4    7
 * 有问题
 */
public class Tree1 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode level2_1 = new TreeNode(5);
        TreeNode level2_2 = new TreeNode(12);
        root.left = level2_1;
        root.right = level2_2;

        TreeNode level3_1 = new TreeNode(4);
        TreeNode level3_2 = new TreeNode(7);
        level2_1.left = level3_1;
        level2_2.right = level3_2;

        Tree1 tree1 = new Tree1();
        Map<Integer, List<Integer>> resultMap = new LinkedHashMap<>();
        tree1.dfs(root, 1, resultMap, new Stack<Integer>(), 0);
        System.out.println(resultMap);
    }

    public void dfs(TreeNode node, int level, Map<Integer, List<Integer>> map, Stack<Integer> stack, int sum) {
        if (node != null) {
            List<Integer> list = map.get(level);
            if (list == null) {
                list = new ArrayList<>();
                map.put(level, list);
            }
            list.add(node.val);
            stack.add(node.val);
            sum += node.val;

            if (node.left == null && node.right == null) {
                if (sum == 22) {
                    System.out.println(Arrays.toString(stack.toArray()));
                    stack.pop();
                } else {
                    stack.pop();
                }

            }

            level++;
            dfs(node.left, level, map, stack, sum);
            dfs(node.right, level, map, stack, sum);
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


