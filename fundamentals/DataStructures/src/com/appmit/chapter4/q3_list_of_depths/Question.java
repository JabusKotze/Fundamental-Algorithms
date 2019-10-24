package com.appmit.chapter4.q3_list_of_depths;

import com.appmit.chapter4.q2_minimal_trees.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Question {

    public static void listOfDepths(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level){

        if(root == null) return;

        LinkedList<TreeNode> list = null;

        if(lists.size() == level){
            list = new LinkedList<TreeNode>();
            lists.add(list);
        }else{
            list = lists.get(level);
        }
        list.add(root);
        listOfDepths(root.left, lists, level + 1);
        listOfDepths(root.right, lists, level + 1);
    }

    public static ArrayList<LinkedList<TreeNode>> listOfDepths(TreeNode root){
        ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
        listOfDepths(root,lists,0);
        return lists;
    }

    public static void printResult(ArrayList<LinkedList<TreeNode>> result){
        int depth = 0;
        for(LinkedList<TreeNode> entry : result) {
            Iterator<TreeNode> i = entry.listIterator();
            System.out.print("Link list at depth " + depth + ":");
            while(i.hasNext()){
                System.out.print(" " + ((TreeNode)i.next()).getData());
            }
            System.out.println();
            depth++;
        }
    }

    public static void main(String[] args){
        //int[] array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23};
        int[] array = new int[200000];
        int j = 199999;

        for(int i = 0; i < array.length; i++){
            array[i] = j;
            j--;
        }

        TreeNode tree = TreeNode.createMinimalTree(array);
        System.out.println("Height of tree is: " + tree.height());
        System.out.println("isBST: " + tree.isBST());

        ArrayList<LinkedList<TreeNode>> result = listOfDepths(tree);
        printResult(result);
    }

}
