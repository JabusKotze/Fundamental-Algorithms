package com.appmit.chapter1.q2_permutation;

import java.util.Arrays;

public class QuestionB {

    public static String sort(String s){
        char[] chars = s.toCharArray();
        java.util.Arrays.sort(chars);
        return new String(chars);
    }

    public static boolean isPermutation(String a, String b){
        // Check if they are equal in length first
        if(a.length() != b.length())
            return false;

        return sort(a).equals(sort(b));
    }

    public static void main(String[] args){
        System.out.println(isPermutation("cba","abc"));
    }
}
