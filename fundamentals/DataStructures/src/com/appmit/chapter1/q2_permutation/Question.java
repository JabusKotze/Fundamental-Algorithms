package com.appmit.chapter1.q2_permutation;

public class Question {

    private static boolean isPermutation(String s1, String s2){

        if(s1.length() != s2.length()) return false;

        int[] values = new int[128];
        for(int i = 0; i<s1.length(); i++){
            char c = s1.charAt(i);
            values[c]++;
        }

        for(int j = 0; j<s2.length(); j++){
            char c = s2.charAt(j);
            values[c]--;
            if(values[c] < 0){
                return false;
            }
        }

        return true;

    }

    public static void main(String[] args){
        System.out.println(isPermutation("Jabus","SubaJ"));
    }
}
