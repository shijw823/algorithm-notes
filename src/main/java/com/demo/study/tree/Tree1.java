package com.demo.study.tree;

import java.util.*;

/**
 * 广度优先搜索 BFS 一层一层扫
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
        List<List<Integer>> resultList = tree1.levelOrder(root);
        System.out.println(resultList);
        Map<Integer, Integer> resultMap = new LinkedHashMap<>();
        tree1.getTreeNodeFirstNodeVal(root, 1, resultMap);
        System.out.println(resultMap.values());
        Map<Integer, Integer> result = new LinkedHashMap<>();
        tree1.getTreeNodeFirstNodeVal2(root, result);
        System.out.println(result.values());

        Map<Integer, List<Integer>> map = new LinkedHashMap<>();
        tree1.dfsLevelOrder(root, 1, map);
        System.out.println(map.values());
        //System.out.println("-------------");
        //tree1.levelOrderPrint(root);
        //System.out.println("-------------");
        //tree1.levelOrderPrint2(root);
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
            int levelSize = queue.size();
            List<Integer> currentLevelList = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode treeNode = queue.poll();
                currentLevelList.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            results.add(currentLevelList);
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

    /**
     * 使用dfs实现按层打印
     * @param node
     * @param level
     * @param map
     */
    public void dfsLevelOrder(TreeNode node, int level, Map<Integer, List<Integer>> map) {
        if (node != null) {
            List<Integer> list = map.computeIfAbsent(level, k -> new ArrayList<>());
            list.add(node.val);
            level++;
            dfsLevelOrder(node.left, level, map);
            dfsLevelOrder(node.right, level, map);
        }
    }

    // 深度优先搜索，递归 DFS
    // 获取每一层首节点
    private void getTreeNodeFirstNodeVal(TreeNode node, int level, Map<Integer, Integer> resultMap) {
        if(node != null) {
            resultMap.putIfAbsent(level, node.val);
            level++;
            getTreeNodeFirstNodeVal(node.left, level, resultMap);
            getTreeNodeFirstNodeVal(node.right, level, resultMap);
        }
    }

    // BFS
    private void getTreeNodeFirstNodeVal2(TreeNode root, Map<Integer, Integer> result) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 1;

        while (!queue.isEmpty()) {
           int currentLevelSize = queue.size();
            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode node = queue.poll();

                //if (i == 0) {
                //    result.add(node.val);
                //}

                result.putIfAbsent(level, node.val);

                if (node != null && node.left != null) {
                    queue.add(node.left);
                }

                if (node != null &&  node.right != null) {
                    queue.add(node.right);
                }
            }
            level++;
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
