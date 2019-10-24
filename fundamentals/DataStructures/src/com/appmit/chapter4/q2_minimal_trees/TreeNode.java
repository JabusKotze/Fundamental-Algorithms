package com.appmit.chapter4.q2_minimal_trees;

import java.util.*;

public class TreeNode {
    private int data;
    public TreeNode left;
    public TreeNode right;
    int size = 0;

    public TreeNode(int data){
        this.data = data;
        size = 1;

        LinkedList<Integer> list = new LinkedList<>();
        ArrayList<Integer> alist = new ArrayList<>();
        HashMap<String,TreeNode> hm = new HashMap<>();
        hm.put("hi",this);
        hm.getOrDefault("hi",this);

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.pop();

        list.push(1);
        list.poll();
    }

    public static TreeNode createMinimalTree(int[] array){
        return createMinimalTree(array,0,array.length - 1);
    }

    public void setLeftChild(TreeNode left){
        this.left = left;
    }

    public void setRightChild(TreeNode right){
        this.right = right;
    }

    private static TreeNode createMinimalTree(int[] array, int start, int end){

        if(end < start) {
            return null;
        }

        int mid = (start + end)/2;
        TreeNode n = new TreeNode(array[mid]);
        n.setLeftChild(createMinimalTree(array,start,mid - 1));
        n.setRightChild(createMinimalTree(array,mid+1,end));

        return n;
    }

    public static void printInOrder(TreeNode root){
        if(root == null) return;

        printInOrder(root.left);
        System.out.print(root.data + ",");
        printInOrder(root.right);
    }

    public int height(){
        int leftHeight = left != null ? left.height(): 0;
        int rightHeight = right != null ? right.height(): 0;
        return 1 + Math.max(leftHeight,rightHeight);
    }

    public static Boolean isBalancedTree(TreeNode root){
        if(root == null) return true;

        int leftHeight = root.left != null ? root.left.height(): 0;
        int rightHeight = root.right != null ? root.right.height(): 0;

        if(Math.abs(leftHeight - rightHeight) > 1){
            return false;
        }else{
            return isBalancedTree(root.left) && isBalancedTree(root.right);
        }
    }

    public Boolean isBST(){
        if(left != null){
            if(data < left.data || !left.isBST()){
                return false;
            }
        }

        if(right != null){
            if(data > right.data || !right.isBST()){
                return false;
            }
        }

        return true;
    }

    public int getData(){return data;}
}
