package com.sand.java.DataStructures;

public class Node {
    int data;
    public Node next;
    Node previous;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }
}
