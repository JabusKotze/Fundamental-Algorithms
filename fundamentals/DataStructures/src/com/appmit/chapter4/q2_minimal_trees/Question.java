package com.appmit.chapter4.q2_minimal_trees;

public class Question {



    public static void main(String[] args){
        //int[] array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,88,45};
        int[] array = {1,2,3,4,5,6,7,8,9,4};

        TreeNode tree = TreeNode.createMinimalTree(array);
        TreeNode.printInOrder(tree);
        System.out.println("\nHeight is " + tree.height());
        System.out.println("\nIs BST " + tree.isBST());

    }

}
