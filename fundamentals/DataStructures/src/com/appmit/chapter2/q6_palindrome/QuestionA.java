package com.appmit.chapter2.q6_palindrome;

public class QuestionA {

    static class Node{
        public Node next;
        public int data;

        public Node(int d){
            data = d;
        }
    }

    static boolean isPalindrome(Node head){
        Node reversed = reverseAndClone(head);
        return isEqual(head, reversed);
    }

    static Node reverseAndClone(Node node){
        Node head = null;
        while (node != null){
            Node n = new Node(node.data);
            n.next = head;
            head = n;
            node = node.next;
        }
        return head;
    }

    static boolean isEqual(Node one, Node two){
        while (one != null && two != null){
            if(one.data != two.data){
                return false;
            }
            one = one.next;
            two = two.next;
        }

        return one == null && two == null;
    }

    public static void main(String[] args){
        Node head = new Node(1);
        Node n1 = new Node(2);
        Node n2 = new Node(2);
        Node n3 = new Node(2);

        n3.next = new Node(1);
        n2.next = n3;
        n1.next = n2;
        head.next = n1;

        System.out.println(isPalindrome(head));
    }
}
