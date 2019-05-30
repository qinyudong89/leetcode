package com.example.leetcode.binarytreenode;

import java.util.*;

/**
 * @Description:
 * @Auther: 覃钰栋
 * @Date: 2019/5/29 18:12
 */
public class BinaryTree {

    //前序
    public static void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getData() + "\t");
        preOrder(node.getLeft());
        preOrder(node.getRight());
    }

    //中序
    public static void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.getLeft());
        System.out.print(node.getData() + "\t");
        inOrder(node.getRight());
    }

    //后序
    public static void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.getLeft());
        postOrder(node.getRight());
        System.out.print(node.getData() + "\t");
    }

    //层遍历
    public static List<List<Integer>> levelOrder(Node node) {
        if (node == null) {
            return null;
        }

        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        //此处用队列，是使用队列“先进先出”的特点
        Queue<Node> queue = new LinkedList();
        queue.offer(node);

        while (!queue.isEmpty()) {
            Node root = queue.peek();
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
        Node node5 = new Node(7, null, null);
        Node node4 = new Node(15, null, null);
        Node node3 = new Node(20, node4, node5);
        Node node2 = new Node(9, null, null);
        Node node1 = new Node(3, node2, node3);


        //[3,9,20,null,null,15,7],
        //采用递归的方式进行遍历
        List<List<Integer>> resultList = BinaryTree.levelOrder(node1);
        System.out.println(Arrays.toString(resultList.toArray()));

    }

}
