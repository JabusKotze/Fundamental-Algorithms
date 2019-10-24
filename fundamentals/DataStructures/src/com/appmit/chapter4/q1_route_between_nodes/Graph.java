package com.appmit.chapter4.q1_route_between_nodes;

public class Graph {

    int count;
    Node[] vertices;

    public Graph(int size){
        vertices = new Node[size];
        count = 0;
    }

    public void addNode(Node n){
        if(count < vertices.length){
            vertices[count] = n;
            count++;
        }else{
            System.out.println("Graph is full");
        }
    }

    public int getCount(){return count;}
    public Node[] getVertices(){return vertices;}

}
