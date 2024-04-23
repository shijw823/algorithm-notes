package com.demo.mianshishu;

import java.util.*;

/**
 * *********************ok
 * 打印二叉树中和为某一值的路径
 * 10
 * 5 12
 * 4    7
 *
 * 153
 */
public class Tree1 {
    private List<List<Integer>> result = new ArrayList<>();
    private LinkedList<Integer> list = new LinkedList<>();

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
        List<List<Integer>> resultList = new ArrayList<>();
        tree1.dfs(root, 19);
        System.out.println(tree1.result);
    }

    private void dfs(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        //根节点的值加入路径
        list.add(root.val);
        //计算出target还需要满足多少
        target -= root.val;
        //如果target为0，且左右子树都为空，说明找到了一条路径
        if (target == 0 && root.left == null && root.right == null) {
            result.add(new LinkedList<>(list));
        }

        //左子树作为根节点，继续寻找
        dfs(root.left, target);
        // 如果root.left为空，这个函数就会直接返回，不会执行下面的语句，也是递归的终止条件
        dfs(root.right, target);
        //回溯到上一层，删除当前层的元素
        list.removeLast();
    }

    //public void dfs(TreeNode node, int level, Map<Integer, List<Integer>> map, Stack<Integer> stack, int sum) {
    //    if (node != null) {
    //        List<Integer> list = map.get(level);
    //        if (list == null) {
    //            list = new ArrayList<>();
    //            map.put(level, list);
    //        }
    //        list.add(node.val);
    //        stack.add(node.val);
    //        sum += node.val;
    //
    //        if (node.left == null && node.right == null) {
    //            if (sum == 22) {
    //                System.out.println(Arrays.toString(stack.toArray()));
    //                stack.pop();
    //            } else {
    //                stack.pop();
    //            }
    //
    //        }
    //
    //        level++;
    //        dfs(node.left, level, map, stack, sum);
    //        dfs(node.right, level, map, stack, sum);
    //    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


