package com.appmit.chapter1.q5_one_away;

public class Question {

    static boolean oneEditAway(String s1, String s2){
        if(s1.length() == s2.length()){
            return oneEditReplace(s1,s2);
        }else if(s1.length() + 1 == s2.length()){
            return oneEditInsert(s1,s2);
        }else if(s2.length() + 1 == s1.length()){
            return oneEditInsert(s2,s1);
        }

        return false;
    }

    static boolean oneEditInsert(String s1, String s2){
        int index1 = 0;
        int index2 = 0;

        while(index1 < s1.length() && index2 < s2.length()){
            if(s1.charAt(index1) != s2.charAt(index2)){
                if(index1 != index2){
                    return false;
                }
                index2++;
            }else{
                index1++;
                index2++;
            }
        }

        return true;
    }

    static boolean oneEditReplace(String s1, String s2){
        boolean replaced = false;
        for(int i = 0; i<s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                if(replaced){
                    return false;
                }
                replaced = true;
            }
        }

        return true;
    }

    public static void main(String[] args){
        System.out.println(oneEditAway("Jabus","Rabus"));
    }
}
