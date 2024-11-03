package com.kumar.datastructures;

import java.util.PriorityQueue;

public class PriorityQueueWorkshop {
    private final PriorityQueue<Integer> priorityQueue;

    public PriorityQueueWorkshop() {
        priorityQueue = new PriorityQueue<Integer>();
    }

    public PriorityQueue<Integer> getpriorityQueue() {
        return priorityQueue;
    }
    
    public static void main(String[] args) {
        // Creates a PriorityQueue with the default initial capacity (11) that orders its elements according to their natural ordering.
        PriorityQueueWorkshop pq = new PriorityQueueWorkshop();
        

        pq.getpriorityQueue().add(10);
        pq.getpriorityQueue().add(2);
        pq.getpriorityQueue().add(17);
        
        System.out.println(pq.getpriorityQueue());


        PriorityQueueWorkshop pq1 = new PriorityQueueWorkshop();
        
        
        pq1.getpriorityQueue().offer(10);
        pq1.getpriorityQueue().offer(2);
        pq1.getpriorityQueue().offer(17);
        
        System.out.println(pq1.getpriorityQueue());

        System.out.println("Element to be removed: " + pq.getpriorityQueue().poll());
        System.out.println("PriorityQueue after removal: " + pq.getpriorityQueue());

        System.out.println("Element at top: " + pq.getpriorityQueue().peek());
        System.out.println("PriorityQueue after removal: " + pq.getpriorityQueue());
    }

}


/**
 * Output :
 * [2, 10, 17]
 * [2, 10, 17]
 * Element to be removed: 2
 * PriorityQueue after removal: [10, 17]
 * Element at top: 10
 * PriorityQueue after removal: [10, 17]
 */