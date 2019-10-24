package com.appmit.chapter1.q1_is_unique;

public class Question {

    public static boolean isUnique(String word){
        if(word.length() > 128) return false;

        boolean[] char_set = new boolean[128];
        for(int i = 0; i<word.length();i++){
            char c = word.charAt(i);
            if(char_set[c]){
                return false;
            }
            char_set[c] = true;
        }
        return true;
    }

    public static void main(String[] args){
            System.out.println(isUnique("Ronney"));
    }

}
