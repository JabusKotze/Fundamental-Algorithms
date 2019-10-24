package com.appmit.chapter1.q1_is_unique;

import java.util.LinkedList;
import java.util.List;

public class Question2 {
    private static List<Integer> complete(int[] states, int days){
        LinkedList<Integer> result = new LinkedList<>();

        for(int i=1;i<=days; i++){
            int prev_state = 0;
            for(int j=0; j<states.length; j++){

                int left = prev_state;
                int right = 0;

                if(j != states.length - 1){
                    right = states[j+1];
                }

                prev_state = states[j];

                if(left == right){
                    states[j] = 0;
                }else{
                    states[j] = 1;
                }

            }
        }

        for (int i : states)
        {
            result.add(i);
        }

        return result;

    }

    public static void main(String[] args){

        int[] states = {1,1,1,0,1,1,1,1};
        for(int val: complete(states,2))
            System.out.print(val);

    }
}
