package com.example.leetcode.binarytreenode;

import java.util.*;

/**
 * @Description:
 * @Auther: 覃钰栋
 * @Date: 2019/5/29 18:12
 */
public class BinaryTree {

    //前序
    public static void preOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.print(treeNode.getData() + "\t");
        preOrder(treeNode.getLeft());
        preOrder(treeNode.getRight());
    }

    //中序
    public static void inOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        inOrder(treeNode.getLeft());
        System.out.print(treeNode.getData() + "\t");
        inOrder(treeNode.getRight());
    }

    //后序
    public static void postOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        postOrder(treeNode.getLeft());
        postOrder(treeNode.getRight());
        System.out.print(treeNode.getData() + "\t");
    }

    //层遍历
    public static List<List<Integer>> levelOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }

        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        //此处用队列，是使用队列“先进先出”的特点
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(treeNode);

        while (!queue.isEmpty()) {
            TreeNode root = queue.peek();
            queue.poll();
            list.add(root.getData());
            if (root.getLeft() != null) {
                queue.offer(root.getLeft());
            }
            if (root.getRight() != null) {
                queue.offer(root.getRight());
            }
        }
        resultList.add(list);
        return resultList;

    }

    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(7, null, null);
        TreeNode node4 = new TreeNode(15, null, null);
        TreeNode node3 = new TreeNode(20, node4, node5);
        TreeNode node2 = new TreeNode(9, null, null);
        TreeNode node1 = new TreeNode(3, node2, node3);


        //[3,9,20,null,null,15,7],
        //采用递归的方式进行遍历
        List<List<Integer>> resultList = BinaryTree.levelOrder(node1);
        System.out.println(Arrays.toString(resultList.toArray()));

    }

}
