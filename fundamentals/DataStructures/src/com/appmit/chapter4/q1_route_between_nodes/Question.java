package com.appmit.chapter4.q1_route_between_nodes;

import java.util.LinkedList;
import java.util.Stack;

public class Question {


    public enum State{Unvisited, Visited, Visiting}


    public static Boolean search(Graph g, Node start, Node end){

        LinkedList<Node> queue = new LinkedList<>();

        for(Node u: g.getVertices()){
            u.state = State.Unvisited;
        }

        start.state = State.Visiting;
        queue.add(start);
        Node current;
        while(!queue.isEmpty()){
            current = queue.removeFirst();
            for(Node n: current.getAdjacent()){
                if(n.state == State.Unvisited){
                    if(n == end){
                        return true;
                    }else{
                        n.state = State.Visited;
                        queue.add(n);
                    }
                }
            }
        }

        return false;
    }

    private static Boolean searchDFS(Node root, Node test){

        root.state = State.Visiting;
        for(Node u: root.getAdjacent()){
            if(u.state == State.Unvisited){
                if(u == test){
                    return true;
                }else{
                    u.state = State.Visited;
                    searchDFS(u,test);
                }
            }
        }

        return false;
    }

    public static void main(String[] args){
        Graph g = new Graph(7);

        Node[] temp = new Node[7];

        temp[0] = new Node("a",2);
        temp[1] = new Node("b",1);
        temp[2] = new Node("c",0);
        temp[3] = new Node("d",1);
        temp[4] = new Node("e",1);
        temp[5] = new Node("f",1);
        temp[6] = new Node("g",1);

        temp[0].addAdjacent(temp[1]);
        temp[0].addAdjacent(temp[2]);
        temp[1].addAdjacent(temp[3]);
        temp[3].addAdjacent(temp[5]);
        temp[4].addAdjacent(temp[2]);
        temp[5].addAdjacent(temp[4]);
        temp[6].addAdjacent(temp[4]);

        for(int i = 0; i < temp.length; i++){
            g.addNode(temp[i]);
        }

        System.out.println(search(g,temp[0],temp[1]));

        System.out.println(searchDFS(temp[0],temp[1]));
    }
}
