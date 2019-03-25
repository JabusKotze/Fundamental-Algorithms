package com.appmit;

import java.lang.reflect.Array;
import java.util.Arrays;

public class UF {

    private int[] ids;

    public UF(int size){
        ids = new int[size];
        for(int i = 0; i<size; i++){
            ids[i] = i;
        }

        System.out.println(Arrays.toString(ids));
    }

    public void union(int p, int q){

        int size = ids.length;

        if(p >= size || q >= size) return;

        int qid = ids[q];
        int pid = ids[p];
        for(int i=0; i<ids.length; i++)
            if(ids[i] == pid) ids[i] = qid;

        System.out.println(Arrays.toString(ids));

    }

    /**
     *
     * @param p
     * @param q
     * @return
     */
    public boolean connected(int p, int q){
        int size = ids.length;
        if(p >= size || q >= size) return false;

        return ids[p] == ids[q];
    }

}
