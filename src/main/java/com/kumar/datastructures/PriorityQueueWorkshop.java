package com.kumar.datastructures;

import java.util.PriorityQueue;

public class PriorityQueueWorkshop<T> {
    private final PriorityQueue<T> priorityQueue;

    public PriorityQueueWorkshop() {
        priorityQueue = new PriorityQueue<T>();
    }

    public PriorityQueue<T> getpriorityQueue() {
        return priorityQueue;
    }
    
    public static void main(String[] args) {
        // Creates a PriorityQueue with the default initial capacity (11) that orders its elements according to their natural ordering.
        PriorityQueueWorkshop<Integer> pq = new PriorityQueueWorkshop<Integer>();

        ////////add()/////////////
        pq.getpriorityQueue().add(10);
        pq.getpriorityQueue().add(2);
        pq.getpriorityQueue().add(17);
        
        System.out.println(pq.getpriorityQueue());


        PriorityQueueWorkshop<Integer> pq1 = new PriorityQueueWorkshop<Integer>();
        
        ////////offer()/////////////
        pq1.getpriorityQueue().offer(10);
        pq1.getpriorityQueue().offer(2);
        pq1.getpriorityQueue().offer(17);
        
        System.out.println(pq1.getpriorityQueue());

        ////////pool()/////////////
        System.out.println("Element to be removed: " + pq.getpriorityQueue().poll());
        System.out.println("PriorityQueue after removal: " + pq.getpriorityQueue());
        
        ////////peek()/////////////
        System.out.println("Element at top: " + pq.getpriorityQueue().peek());
        System.out.println("PriorityQueue after removal: " + pq.getpriorityQueue());



        /////////////////Custom Object///////////
        PriorityQueueWorkshop<Node> pq2 = new PriorityQueueWorkshop<Node>();
        pq2.getpriorityQueue().offer(new Node(1, 5));
        pq2.getpriorityQueue().offer(new Node(3, 2));
        pq2.getpriorityQueue().offer(new Node(7, 1));
        pq2.getpriorityQueue().offer(new Node(4, 3));
        System.out.println("Custom PriorityQueue: " + pq2.getpriorityQueue());

        ////////pool()/////////////
        System.out.println("Element to be removed: " + pq2.getpriorityQueue().poll());
        System.out.println("PriorityQueue after removal: " + pq2.getpriorityQueue());
        
        ////////peek()/////////////
        System.out.println("Element at top: " + pq2.getpriorityQueue().peek());
        System.out.println("PriorityQueue after removal: " + pq2.getpriorityQueue());

        pq2.getpriorityQueue().offer(new Node(7, 1));
        System.out.println("PriorityQueue after addition: " + pq2.getpriorityQueue());
        pq2.getpriorityQueue().offer(new Node(7, 1));
        System.out.println("PriorityQueue after addition: " + pq2.getpriorityQueue());
        pq2.getpriorityQueue().offer(new Node(21, 0));
        System.out.println("PriorityQueue after addition: " + pq2.getpriorityQueue());
    }
}