package com.appmit.chapter4.q4_balanced;

import com.appmit.chapter4.q2_minimal_trees.TreeNode;

public class Question {



    public static void main(String[] args){


        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(2);

        int[] array = new int[200];
        int j = 199;

        for(int i = 0; i < array.length; i++){
            array[i] = i;
            j--;
        }

        TreeNode tree = TreeNode.createMinimalTree(array);
        System.out.println("Height of tree is: " + root.height());
        System.out.println("isBST: " + root.isBST());
        System.out.println("Is Balanced Tree: " + TreeNode.isBalancedTree(root));


    }

}
