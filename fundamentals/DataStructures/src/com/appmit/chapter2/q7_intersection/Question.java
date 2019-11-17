package com.appmit.chapter2.q7_intersection;

public class Question {

    private class Node {
        Node next;
        int data;

        public Node(int data){
            this.data = data;
        }
    }

    private class Results {
        Node tail;
        int length;

        public Results(Node tail, int length){
            this.tail = tail;
            this.length = length;
        }
    }

    Results findTailAndSize(Node list){
        if(list == null)
            return null;

        int size = 0;
        Node current = list;
        while(current.next != null){
            size++;
            current = current.next;
        }

        return new Results(current,size);
    }

    Node findIntersection(Node head1, Node head2){
        if(head1 == null || head2 == null) return null;

        Results results1 = findTailAndSize(head1);
        Results results2 = findTailAndSize(head2);

        if(results1.tail != results2.tail)
            return null;

        Node longer = results1.length > results2.length ? head1 : head2;
        Node shorter = results2.length > results1.length ? head1 : head2;
        int delta = Math.abs(results1.length - results2.length);

        longer = getKthNode(longer,delta);

        while (shorter != longer){
            shorter = shorter.next;
            longer = longer.next;
        }

        return longer;
    }

    Node getKthNode(Node list, int k){
        Node current = list;
        while(k > 0 && current != null){
            current = current.next;
            k--;
        }

        return current;
    }

    public static void main(String[] args){

    }
}
