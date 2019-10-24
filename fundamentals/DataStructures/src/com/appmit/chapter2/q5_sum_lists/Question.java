package com.appmit.chapter2.q5_sum_lists;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Question {

    public static int listToNum(LinkedList<Integer> list){

        int counter = 0;
        int result = 0;
        while(!list.isEmpty()){
            result += list.pop()*((int)Math.pow(10,counter));
            counter++;
        }

        return result;
    }

    public static List<Integer> sumOfLists(int n1, int n2){
        int sum = n1+n2;
        System.out.println(sum);
        LinkedList<Integer> list = new LinkedList<>();

        int count = 1;
        int power = (int)Math.pow(10,count);
        int res = sum%power;
        while(res < 10){
            count++;
            list.push(res);
            System.out.println(power);
            power = (int)Math.pow(10,count);
            res = sum%power;
        }

        return list;
    }

    public static void main(String[] args){
        LinkedList<Integer> list1 = new LinkedList<>(Arrays.asList(1,2,3));
        LinkedList<Integer> list2 = new LinkedList<>(Arrays.asList(1,2,3));
        System.out.println(sumOfLists(listToNum(list1),listToNum(list2)));
    }
}
