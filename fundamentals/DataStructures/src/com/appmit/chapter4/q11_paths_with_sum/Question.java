package com.appmit.chapter4.q11_paths_with_sum;

import com.appmit.chapter4.q2_minimal_trees.TreeNode;

public class Question {


    private static int countPathsWithSum(TreeNode root, int targetSum){
        if(root == null) return 0;

        int pathsOnRoot = countPathsWithSumOnRoot(root,targetSum,0);

        int pathsOnLeft = countPathsWithSum(root.left,targetSum);
        int pathsOnRight = countPathsWithSum(root.right,targetSum);

        return  pathsOnRoot + pathsOnLeft + pathsOnRight;
    }

    private static int countPathsWithSumOnRoot(TreeNode root, int targetSum, int sum){
        if(root == null) return 0;

        sum+= root.getData();

        int totalPaths = 0;
        if(sum == targetSum){
            totalPaths++;
        }

        totalPaths+= countPathsWithSumOnRoot(root.left,targetSum,sum);
        totalPaths+= countPathsWithSumOnRoot(root.right,targetSum,sum);

        return totalPaths;
    }


    public static void main(String[] args){
        //int[] array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23};
        int[] array = new int[20];
        int j = 19;

        for(int i = 0; i < array.length; i++){
            array[i] = 5;
            j--;
        }

        TreeNode tree = TreeNode.createMinimalTree(array);

        int target = 25;
        System.out.println("Total paths counting to " + target + ": " + countPathsWithSum(tree,target));
    }
}
