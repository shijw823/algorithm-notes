package com.demo.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shijianwei
 * @date 2025/12/29
 * https://leetcode.cn/problems/binary-tree-paths/
 */
public class BTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        dfs(root, "", result);
        return result;
    }

    private void dfs(TreeNode root, String path, List<String> result) {
        // 构建当前路径
        if ("".equals(path)) {
            path += root.val;
        } else {
            path += "->" + root.val;
        }

        // 如果是叶子节点，添加路径到结果
        if (root.left == null && root.right == null) {
            result.add(path);
            return;
        }

        // 递归遍历左右子树
        if (root.left != null) {
            dfs(root.left, path, result);
        }

        if (root.right != null) {
            dfs(root.right, path, result);
        }
    }

    public static void main(String[] args) {
        // [1,2,3,null,5]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        BTreePaths demo = new BTreePaths();
        System.out.println(demo.binaryTreePaths(root));
    }
}
