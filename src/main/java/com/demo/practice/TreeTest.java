package com.demo.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author shijianwei
 * @date 2026/1/23
 */
public class TreeTest {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        zigzagLevelOrder(root, result);
        return result;
    }

    private void zigzagLevelOrder(TreeNode root, List<List<Integer>> result) {
        if(root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean isLeft = true;
        while(!queue.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<>();
            int size = queue.size();

            for(int i=0;i<size;i++) {
                TreeNode node = queue.poll();

                if(isLeft) {
                    list.offerLast(node.val);
                } else {
                    list.offerFirst(node.val);
                }

                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            isLeft = !isLeft;
            result.add(list);
        }

    }
}
