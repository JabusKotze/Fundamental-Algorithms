package com.appmit.interview_prep;

public class BinaryTreeNode {

    public BinaryTreeNode left;
    public BinaryTreeNode right;
    public BinaryTreeNode parent;
    public int data;

    public BinaryTreeNode(int data){
        this.data = data;
    }

    public void setLeftChild(BinaryTreeNode left){
        this.left = left;
        if(left != null){
            left.parent = this;
        }
    }

    public void setRightChild(BinaryTreeNode right){
        this.right = right;
        if(right != null){
            right.parent = this;
        }
    }

    public void insertInOrder(int d){
        if(d <= data){
            if(left == null){
                setLeftChild(new BinaryTreeNode(d));
            }else{
                left.insertInOrder(d);
            }
        }else{
            if(right == null){
                setRightChild(new BinaryTreeNode(d));
            }else{
                right.insertInOrder(d);
            }
        }
    }

    public boolean isBST(){
        if(left != null){
            if(data < left.data || !left.isBST()){
                return false;
            }
        }

        if(right != null){
            if(data >= right.data || !right.isBST()){
                return false;
            }
        }

        return true;
    }

    public BinaryTreeNode findBST(int d){
        if(d == data){
            return this;
        }else if(d <= data){
            return left != null ? left.findBST(d): null;
        }else if(d > data){
            return right != null ? right.findBST(d): null;
        }

        return null;
    }

    public int height(){
        int leftHeight = left != null ? left.height(): 0;
        int rightHeight = right != null ? right.height(): 0;
        return 1 + Math.max(leftHeight,rightHeight);
    }

    public static BinaryTreeNode createMinBST(int[] arr, int start, int end){
        if(end < start)
            return null;

        int mid = (end + start) / 2;
        BinaryTreeNode n = new BinaryTreeNode(arr[mid]);

        n.setLeftChild(createMinBST(arr, start, mid - 1));
        n.setRightChild(createMinBST(arr,mid + 1, end));
        return n;
    }

    public static BinaryTreeNode createMinBST(int[] arr){
        return createMinBST(arr, 0, arr.length - 1);
    }

    public void printInOrder(BinaryTreeNode n){
        if(n == null)
            return;

        printInOrder(n.left);
        System.out.println(n.data);
        printInOrder(n.right);
    }


}
