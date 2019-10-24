package com.appmit.chapter1.q6_compression;

public class Question {

    private static String compressed(String s){
        StringBuilder builder = new StringBuilder();
        char[] chars = s.toCharArray();
        char previous = chars[0];
        int count = 0;


        for(char word: chars){
            if(word != previous){
                builder.append(previous);
                builder.append(count == 0 ? 1: count);
                count = 0;
            }else{
                count++;
            }

            previous = word;
        }

        builder.append(previous);
        builder.append(count + 1);

        if(builder.length() >= chars.length)
            return s;

        return builder.toString();
    }

    public static void main(String[] args){
        String test = "abcdefgggggggg";
        System.out.println(compressed(test));
    }
}
