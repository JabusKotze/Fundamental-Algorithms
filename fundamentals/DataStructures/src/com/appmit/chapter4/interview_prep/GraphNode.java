package com.appmit.chapter4.interview_prep;

import java.util.LinkedList;
import java.util.List;

public class GraphNode {

    String data;
    List<GraphNode> adjacent;
    int count;
    boolean visited = false;

    public GraphNode(String data){
        this.data = data;
        adjacent = new LinkedList<>();
        count = 0;
    }

    public void addAdjacent(GraphNode n){
        // Check if not already added => O(count)
        if(!adjacent.contains(n)){
            adjacent.add(n);
            count++;
        }
    }

    public List<GraphNode> getAdjacent(){
        return adjacent;
    }

    public String getData(){
        return this.data;
    }

    public void setVisited(boolean visited){
        this.visited = visited;
    }

    public boolean isVisited(){
        return this.visited;
    }

}
