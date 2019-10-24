package com.appmit.chapter3.q2_stack_min;

public class Question {
    public static void main(String[] args){

        StackWithMin stack = new StackWithMin();
        stack.push(5);
        System.out.println("New min is: " + stack.min());
        stack.push(4);
        System.out.println("New min is: " + stack.min());
        stack.push(10);
        System.out.println("New min is: " + stack.min());
        stack.push(1);
        System.out.println("New min is: " + stack.min());
        stack.push(78);
        System.out.println("New min is: " + stack.min());
        stack.pop();
        System.out.println("New min is: " + stack.min());
        stack.pop();
        System.out.println("New min is: " + stack.min());
        stack.pop();
        System.out.println("New min is: " + stack.min());
        stack.pop();
        System.out.println("New min is: " + stack.min());

    }
}
