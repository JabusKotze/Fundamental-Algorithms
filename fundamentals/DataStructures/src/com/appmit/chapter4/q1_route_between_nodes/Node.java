package com.appmit.chapter4.q1_route_between_nodes;

public class Node {

    Node[] adjacent;
    String data;
    int count;
    Question.State state;

    public Node(String data, int size){
        this.data = data;
        adjacent = new Node[size];
        count = 0;
    }

    public void addAdjacent(Node n){
        if(count < adjacent.length){
            adjacent[count] = n;
            count++;
        }else{
            System.out.println("GraphNode is full");
        }
    }

    public String getData(){
        return data;
    }

    public Node[] getAdjacent(){return adjacent;}

    public Question.State getState(){return state;}

}
