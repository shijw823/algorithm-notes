package com.demo.important.shouxie;

import java.util.*;

/**
 * 广度优先搜索
 *
 * @author shijianwei
 * @since 2020/04/04
 */
public class TreeDemo {

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

        TreeDemo treeDemo = new TreeDemo();
        List<List<Integer>> resultList = treeDemo.bfs(root);
        System.out.println(resultList);

        Map<Integer, Integer> resultMap = new HashMap<>();
        treeDemo.dfs(root, 1, resultMap);
        System.out.println(resultMap.values());
    }

    public List<List<Integer>> bfs(TreeNode node) {
        List<List<Integer>> resultList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                list.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }

            resultList.add(list);
        }
        return resultList;
    }

    public void dfs(TreeNode node, int level, Map<Integer, Integer> resultMap) {
        if (node != null) {
            resultMap.putIfAbsent(level, node.val);
            level++;
            dfs(node.left, level, resultMap);
            dfs(node.right, level, resultMap);
        }
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }



}


