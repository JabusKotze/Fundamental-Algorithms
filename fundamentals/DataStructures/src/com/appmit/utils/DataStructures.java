package com.appmit.utils;

import java.util.*;

public class DataStructures {

    // LIFO of Stack - Stack
    public static void stackLIFO(){
        Stack<String> stack = new Stack<>();

        stack.push("Geeks");

        stack.push("for");

        String s = stack.pop();

        System.out.println(s);

        stack.push("Another Geek");

        System.out.println(stack);
    }


    // FIFO of linkedlist - Queue impl
    public static void linkedListFIFO(){
        LinkedList<String> queue = new LinkedList<>();

        queue.add("Geeks");

        queue.add("for");

        String s = queue.removeFirst();

        System.out.println(s);

        queue.add("Another Geek");

        System.out.println(queue);

    }

    //LIFO of linkedlist - Stack imp
    public static void linkedListLIFO()
    {

        // Creating a LinkedList object to represent a stack.
        LinkedList<String> stack = new LinkedList<>();

        // Pushing an element in the stack
        stack.push("Geeks");

        // Pushing an element in the stack
        stack.push("for");

        // Pop an element from stack
        String s = stack.pop();

        // Printing the popped element.
        System.out.println(s);

        // Pushing an element in the stack
        stack.push("Another Geek");

        // Printing the complete stack.
        System.out.println(stack);
    }

    // FIFO
    public static void linkedList(){
        // Uninitialized list
        LinkedList<Integer> list = new LinkedList<>();
        // Initialized list
        LinkedList<Integer> list_ini = new LinkedList<>(Arrays.asList(1,2,3,4,5));

        // Get value
        int val = list_ini.get(1);

        // add value to front - Stack
        list_ini.push(2);

        // Add value to
        list_ini.add(1);

        // Pop value at start of queue
        int pop = list_ini.pop();

        // Peek value at start of queue
        int peek = list_ini.peek();

        // Is empty
        boolean isEmpty = list_ini.isEmpty();

        // Get size
        int size = list_ini.size();

        // O(n) iterator
        Iterator<Integer> iter = list_ini.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
        // or foreach
        list_ini.forEach(v -> System.out.println(v));
        // or enhanced for loop
        for(int item: list_ini){
            System.out.println(item);
        }

        // O(n^2) iterators using get(i)
        for(int i = 0; i < list_ini.size(); i++){
            System.out.println(list_ini.get(i));
        }
        // or while
        int i = 0;
        while(i < list_ini.size()){
            System.out.println(list_ini.get(i));
            i++;
        }
    }

    public static void arrayList(){
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));

        // Get value at index
        int val = list.get(1);

        // Add value
        list.add(4);

        // Remove at index -- very slow
        list.remove(0);

        // Size
        int size = list.size();

        // Is empty
        boolean isEmpty = list.isEmpty();

        // Iterate
        Iterator<Integer> iter = list.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
        // For each
        list.forEach(i -> System.out.println(i));
        // Enhanced for each
        for(int i: list){
            System.out.println(i);
        }

    }

    // LIFO - using Stack
    public static void stackSample(){
        Stack<Integer> stack = new Stack<>();

        // Add to stack
        stack.push(1);

        // Peek stack
        int i = stack.peek();

        // Pop stack
        int pop = stack.pop();

        // Size of stack
        int size = stack.size();

        // is empty
        boolean isEmpty = stack.isEmpty();

        // Iterate
        Iterator<Integer> iter = stack.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }

    }

    public static void stringManipulation(){
        String s = "Jabus Kotze";

        // To char array
        char[] chars = s.toCharArray();

        // Length of string
        int len = s.length();

        // get char at position
        char i = s.charAt(0);

    }

    public static void stringBuilder(){
        StringBuilder sb = new StringBuilder();
        sb.append("Jabus");
        sb.append(" Kotze");

        // to string
        String result = sb.toString();
    }

    public static void linkedListPop(){
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1,2,3,4));

        System.out.println(list);

        // Add to tail
        list.add(5);
        System.out.println(list);

        // Remove / pop from head
        int item = list.pop();
        System.out.println(item);
        System.out.println(list);

        // Remove from tail
        item = list.removeLast();
        System.out.println(item);
        System.out.println(list);

        // Push to head
        list.push(10);
        System.out.println(list);

        // Push to head
        item = list.remove();
        System.out.println(item);
    }

    public static void main(String[] args){
//        linkedListLIFO();
//
//        linkedListFIFO();
//
//        stackLIFO();

         linkedListPop();

    }
}
