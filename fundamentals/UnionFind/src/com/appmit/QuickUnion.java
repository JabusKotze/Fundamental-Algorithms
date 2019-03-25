package com.appmit;

import java.util.Arrays;

public class QuickUnion {

    private int[] ids;
    private int[] sz;

    public QuickUnion(int size){
        ids = new int[size];
        sz = new int[size];
        for(int i = 0; i<size; i++){
            ids[i] = i;
            sz[i] = 1;
        }

        System.out.println(Arrays.toString(ids));
    }

    private int root(int i){
        while(i != ids[i]) i = ids[i];
        return i;
    }

    private int rootCompression(int i){
        while(i != ids[i]) {
            ids[i] = ids[ids[i]];
            i = ids[i];
        }
        return i;
    }

    public boolean connected(int p, int q){
        return root(p) == root(q);
    }

    public void union(int p, int q){
        int i = root(p);
        int j = root(q);
        ids[i] = j;
    }

    /**
     * Weighted Quick Union method, always put smaller tree below
     * @param p
     * @param q
     */
    public void unionWieghted(int p, int q){
        int i = root(p);
        int j = root(q);
        if(i == j) return;

        if(sz[i] < sz[j]){ids[i] = j; sz[j] += sz[i];}
        else {ids[j] = i; sz[i] += sz[j];}
    }



}
