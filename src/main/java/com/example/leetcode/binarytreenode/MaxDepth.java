package com.example.leetcode.binarytreenode;

/**
 * @Description:104. 二叉树的最大深度
 * @Auther: 覃钰栋
 * @Date: 2019/5/30 16:10
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int depth = Math.max(maxDepth(root.getLeft()), maxDepth(root.getRight())) + 1;
        return depth;
    }
}
