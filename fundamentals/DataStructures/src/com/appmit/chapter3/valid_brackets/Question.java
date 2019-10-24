package com.appmit.chapter3.valid_brackets;

import java.util.*;

public class Question {

    public static boolean contains(char[] chars, char c){
        for(char i: chars)
            if(c == i)
                return true;

        return false;
    }

    private static int findIndex(char myElement, char[] someArray){
        int index = 0;
        for(int n: someArray){
            if(myElement == n) return index;
            else index++;
        }

        return -1;
    }

    public static boolean isValidBrackets(String s){
        char[] open = {'{','[','('};
        char[] closed = {'}',']',')'};
        char[] chars = s.toCharArray();

        Stack<Character> openBrackets = new Stack<>();

        for (char i: chars){
            // If open bracket push to stack
            if(contains(open,i)){
                openBrackets.push(i);
            }

            // If closed bracket, check if popped value in open matches?
            if(contains(closed,i)){
                if(openBrackets.isEmpty())
                    return false;

                char popped = openBrackets.pop();
                int index_open = findIndex(popped,open);
                int index_closed = findIndex(i,closed);
                if(index_open != index_closed)
                    return false;
            }
        }

        return openBrackets.isEmpty();
    }

    public static List<List<Integer>> testing(){
        ArrayList<List<Integer>> test = new ArrayList<>();
        return test;
    }

    public static void main(String[] args){
        System.out.println(isValidBrackets("([Jabus]"));

        // Array list
        ArrayList<Integer> test = new ArrayList<>();
        test.add(1);
        int s = test.size();
        int k = test.get(1);

        for(int val: test){
            // Do something
        }

        // Linked list - Queue
        LinkedList<Integer> linked = new LinkedList<>();
        linked.push(1);
        linked.add(1);
        int i = linked.pop();
        int j = !linked.isEmpty() ? linked.peek(): 0;
        i = linked.removeFirst();


        // HashMap
        HashMap<Integer, Integer> sets = new HashMap<>();
        sets.put(1,2);
        sets.put(2,3);
        sets.get(1);
        sets.size();
        boolean empty = sets.isEmpty();
        sets.containsKey(1);
        sets.containsValue(2);
        sets.getOrDefault(1,0);

        // Stack
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        i = !stack.isEmpty() ? stack.peek(): 0;
        j = stack.pop();
        k = stack.size();

        for(int val: stack){
            // do something
        }



        stack.push(1);

    }
}
