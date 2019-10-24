package com.appmit.route;

import java.util.LinkedList;


public class RouteBetweenNodes {

    public enum State {Unvisited, Visited, Visiting}

    public static Graph createNewGraph(){
        Graph g = new Graph();

        Node[] temp = new Node[6];
        temp[0] = new Node("a",3);
        temp[1] = new Node("b",0);
        temp[2] = new Node("c",0);
        temp[3] = new Node("d",1);
        temp[4] = new Node("e",1);
        temp[5] = new Node("f",0);

        temp[0].addAdjacent(temp[1]);
        temp[0].addAdjacent(temp[2]);
        temp[0].addAdjacent(temp[3]);
        temp[3].addAdjacent(temp[4]);
        temp[4].addAdjacent(temp[1]);
        for(int i = 0; i<temp.length; i++){
            g.addNode(temp[i]);
        }

        return g;
    }


    public static boolean search(Graph g, Node start, Node end){
        if(start == end) return true;

        LinkedList<Node> queue = new LinkedList<>();

        for(Node u: g.getNodes()){
            u.state = State.Unvisited;
        }

        start.state = State.Visiting;
        queue.add(start);
        Node u;
        while (!queue.isEmpty()){
            u = queue.removeFirst();
            if(u != null){
                for (Node v: u.getAdjacent()){
                    if(v.state == State.Unvisited){
                        if(v == end){
                            return true;
                        }else{
                            v.state = State.Visited;
                            queue.add(v);
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args){
        Graph g = createNewGraph();
        Node[] n = g.getNodes();
        Node start = n[4];
        Node end = n[1];

        System.out.println(search(g,start,end));
    }
}
