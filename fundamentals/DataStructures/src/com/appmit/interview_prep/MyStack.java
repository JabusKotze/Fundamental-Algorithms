package com.appmit.interview_prep;

import java.util.EmptyStackException;

public class MyStack<T> {
    private static class StackNode<T> {
        private StackNode<T> next;
        private T data;

        public StackNode(T data){
            this.data = data;
        }
    }

    private StackNode<T> top;

    public T pop(){
        if(top == null) throw new EmptyStackException();

        T item = top.data;
        top = top.next;
        return item;
    }

    public void push(T data){
        StackNode<T> node = new StackNode<T>(data);
        node.next = top;
        top = node;
    }

    public T peek(){
        if(top == null) throw new EmptyStackException();

        return top.data;
    }

    public boolean isEmpty(){
        return top == null;
    }
}
