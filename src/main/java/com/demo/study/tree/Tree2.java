package com.demo.study.tree;

import java.util.*;

/**
 * 广度优先搜索 BFS  一层一层扫
 *                  9
 *               10   11
 *             12          19
 *                8    18    23
 *                             25
 *                           19 20
 *                                 12
 *
 * 打印每一层的第一个节点
 * BFS
 * [
 *  [9]
 *  [10, 11]
 *  [12, 19]
 *  ....
 * ]
 *
 *  DFS, 访问的时候额外记录层级
 *  [
 *   [9]
 *   [10,]
 *   [12, ]
 *   ...
 *  ]
 * @author shijianwei
 * @since 2020/04/04
 */
public class Tree2 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(9);
        TreeNode level2_1 = new TreeNode(10);
        TreeNode level2_2 = new TreeNode(11);
        root.left = level2_1;
        root.right = level2_2;

        TreeNode level3_1 = new TreeNode(12);
        TreeNode level3_2 = new TreeNode(19);
        level2_1.left = level3_1;
        level2_2.right = level3_2;
        TreeNode level4_1 = new TreeNode(8);
        TreeNode level4_2 = new TreeNode(18);
        TreeNode level4_3 = new TreeNode(23);
        level3_1.right = level4_1;
        level3_2.left = level4_2;
        level3_2.right = level4_3;
        TreeNode level5_1 = new TreeNode(25);
        TreeNode level6_1 = new TreeNode(19);
        TreeNode level6_2 = new TreeNode(20);
        TreeNode level7_1 = new TreeNode(12);
        level4_3.right = level5_1;
        level5_1.left = level6_1;
        level5_1.right = level6_2;
        level6_2.right = level7_1;

        Tree2 tree2 = new Tree2();
        Map<Integer, Integer> resultMap = new LinkedHashMap<>();
        tree2.getTreeNodeFirstNodeVal(root, 1, resultMap);
        System.out.println(resultMap.values());
    }

    // 深度优先搜索 DFS
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
