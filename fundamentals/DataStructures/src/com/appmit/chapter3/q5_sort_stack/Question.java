package com.appmit.chapter3.q5_sort_stack;

import java.util.Stack;

public class Question {


    private static void sortStack(Stack<Integer> stack){
        Stack<Integer> helper = new Stack<>();

        while(!stack.isEmpty()){
            int temp = stack.pop();
            while (!helper.isEmpty() && helper.peek() > temp){
                stack.push(helper.pop());
            }
            helper.push(temp);
        }

        while (!helper.isEmpty()){
            stack.push(helper.pop());
        }
    }

    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        stack.push(9);
        stack.push(12);
        stack.push(4);
        stack.push(34);

        sortStack(stack);

        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }

}
