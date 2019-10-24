package com.appmit.chapter4.q10_check_subtree;

import com.appmit.chapter4.q2_minimal_trees.TreeNode;

public class Question {

    public static Boolean isSubtree(TreeNode t1, TreeNode t2){
        StringBuilder string1 = new StringBuilder();
        StringBuilder string2 = new StringBuilder();

        preOrderTraverse(t1,string1);
        preOrderTraverse(t2,string2);

        System.out.println(string1.toString());
        System.out.println(string2.toString());

        return string1.indexOf(string2.toString()) != -1;
    }

    private static void preOrderTraverse(TreeNode node, StringBuilder sb){
        if(node == null){
            sb.append("X");
            return;
        }

        sb.append(node.getData() + " ");
        preOrderTraverse(node.left,sb);
        preOrderTraverse(node.right,sb);
    }


    public static void main(String[] args){
        //int[] array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23};
        int[] array = new int[20];
        int j = 19;

        for(int i = 0; i < array.length; i++){
            array[i] = i;
            j--;
        }

        int[] array2 = {4,8,9,10,11};

        TreeNode t1 = TreeNode.createMinimalTree(array);
        TreeNode t2 = TreeNode.createMinimalTree(array);

        System.out.println("Is T2 subtree of T1: " + isSubtree(t1,t2));
    }

}
