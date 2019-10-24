package com.appmit.chapter4.interview_prep;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph<T> {
    private int count;

    private GraphNode[] vertices;

    public Graph(int v){
        count = 0;
        vertices = new GraphNode[v];
    }

    public void addNode(GraphNode n){
        if(count < vertices.length){
            vertices[count] = n;
            count++;
        }else{
            System.out.println("Graph is full");
        }
    }


    public void addEdge(GraphNode a, GraphNode b, boolean undirected){
        for(GraphNode i: vertices){
            if(i.equals(a)){
                i.addAdjacent(b);
            }
            // Also add adjacent to its pair
            if(undirected && i.equals(b)){
                i.addAdjacent(a);
            }
        }
    }

    public boolean isNodesConnectedDFS(GraphNode start, GraphNode end){
        if(start == end)
            return true;

        for(GraphNode n: this.getVertices()){
            n.visited = false;
        }

        start.visited = true;
        for(GraphNode n: this.getVertices()){
            if(!n.visited){
                if(n == end){
                    return true;
                }else{
                    n.visited = true;
                    isNodesConnectedDFS(n, end);
                }
            }
        }

        return false;

    }

    public boolean isNodesConnectedBFS(GraphNode start, GraphNode end){
        LinkedList<GraphNode> queue = new LinkedList<>();
        for(GraphNode n: this.getVertices()){
            n.visited = false;
        }

        start.visited = true;
        queue.add(start);
        GraphNode u;

        while(!queue.isEmpty()){
            u = queue.removeFirst();
            if(u != null){
                for(GraphNode v : u.getAdjacent()){
                    if(!v.visited){
                        if(v == end){
                            return true;
                        }else{
                            v.visited = true;
                            queue.add(v);
                        }
                    }
                }
            }
        }

        return false;
    }

    public GraphNode[] getVertices(){return this.vertices;}

    public int getCount(){return this.count;}
}
