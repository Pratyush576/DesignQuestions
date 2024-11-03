package com.kumar.datastructures;

public class Node implements Comparable {
    final int key;
    final int count;

    public Node(int key, int count) {
        this.key = key;
        this.count = count;
    }

    public int getKey() {
        return key;
    }

    public int getCount() {
        return count;
    }

    public String toString() {
        return "[" + key +", " + count + "]";
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     * 
     * @param node
     * @return
     */
    @Override
    public int compareTo(Object node) {
        Node inNode = (Node) node;
        if(this.count < inNode.getCount()) {
            return -1;
        }

        if (this.count == inNode.getCount()) {
            return 0;
        }

        return 1;
    }
}
