package com.demo.study.tree;

import java.util.*;

/**
 * 广度优先搜索
 * 32
 *
 * @author shijianwei
 * @since 2020/04/04
 */
public class Tree1 {
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

        Tree1 tree1 = new Tree1();
        //List<List<Integer>> resultList = tree1.levelOrder(root);
        //System.out.println(resultList);
        Map<Integer, Integer> resultMap = new LinkedHashMap<>();
        tree1.getTreeNodeFirstNodeVal(root, 1, resultMap);
        System.out.println(resultMap.values());
        Map<Integer, List<Integer>> map = new LinkedHashMap<>();
        tree1.dfs(root, 1, map);
        System.out.println(map.values());
        System.out.println("-------------");
        tree1.levelOrderPrint(root);
        System.out.println("-------------");
        tree1.levelOrderPrint2(root);
    }

    // 广度优先搜索
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
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
            results.add(list);
        }
        return results;
    }

    public void levelOrderPrint(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                System.out.print(treeNode.val + " ");
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
        }
    }

    public void levelOrderPrint2(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                System.out.print(treeNode.val + " ");
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            System.out.println();
        }
    }

    public void dfs(TreeNode node, int level, Map<Integer, List<Integer>> map) {
        if (node != null) {
            List<Integer> list = map.get(level);
            if (list == null) {
                list = new ArrayList<>();
                map.put(level, list);
            }
            list.add(node.val);
            level++;
            dfs(node.left, level, map);
            dfs(node.right, level, map);
        }
    }

    // 深度优先搜索，递归
    private void getTreeNodeFirstNodeVal(TreeNode node, int level, Map<Integer, Integer> resultMap) {
        if(node != null) {
            resultMap.putIfAbsent(level, node.val);
            level++;
            getTreeNodeFirstNodeVal(node.left, level, resultMap);
            getTreeNodeFirstNodeVal(node.right, level, resultMap);
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
