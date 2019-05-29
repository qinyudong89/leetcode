package com.example.leetcode.binarytreenode;

/**
 * @Description:
 * @Auther: 覃钰栋
 * @Date: 2019/5/29 18:12
 */
public class BinaryTree {

    //前序
    public static void preOrder(Node root){
        if (root == null){
            return;
        }
        System.out.print(root.getData()+"\t");
        preOrder(root.getLeft());
        preOrder(root.getRight());

    }

    //中序
    public static void inOrder(Node root){

    }

    //后序
    public static void postOrder(Node root){


    }

    public static void main(String[] args) {
        Node node10=new Node(10,null,null);
        Node node8=new Node(8,null,null);
        Node node9=new Node(9,null,node10);
        Node node4=new Node(4,null,null);
        Node node5=new Node(5,node8,node9);
        Node node6=new Node(6,null,null);
        Node node7=new Node(7,null,null);
        Node node2=new Node(2,node4,node5);
        Node node3=new Node(3,node6,node7);
        Node node1=new Node(1,node2,node3);
        //采用递归的方式进行遍历
        System.out.println("-----前序遍历------");
        BinaryTree.preOrder(node1);
        System.out.println();
    }

}
