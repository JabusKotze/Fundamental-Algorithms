package com.appmit.chapter2.q3_delete_node;

import com.appmit.utils.LinkedListNode;

public class Question {

    boolean deleteNode(LinkedListNode node){
        if(node == null || node.next == null) return false;

        LinkedListNode next = node.next;
        node.data = next.data;
        node.next = next.next;
        return true;
    }

    public static void main(String[] args){

    }

}
