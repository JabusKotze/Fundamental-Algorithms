package com.appmit.chapter2.q6_palindrome;

import java.util.Stack;

public class QuestionB {

    static class Node{
        public Node next;
        public int data;

        public Node(int d){
            data = d;
        }
    }

    public static boolean isPalindrome(Node head){
        Node fast = head;
        Node slow = head;

        Stack<Integer> stack = new Stack<>();

        while (fast != null && fast.next != null){
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast != null){
            slow = slow.next;
        }

        while(slow != null){
            int top = stack.pop();

            if(top != slow.data){
                return false;
            }

            slow = slow.next;
        }

        return true;
    }

    public static void main(String[] args){
        Node head = new Node(1);
        Node n1 = new Node(2);
        Node n2 = new Node(6);
        Node n3 = new Node(3);

        n3.next = new Node(1);
        n2.next = n3;
        n1.next = n2;
        head.next = n1;

        System.out.println(isPalindrome(head));
    }
}
