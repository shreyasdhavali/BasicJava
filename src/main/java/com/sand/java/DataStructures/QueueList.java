package com.sand.java.DataStructures;

public class QueueList {

    static Node head;

    private static void enqueue(int data) {
        if(head == null) {
            head = new Node(data);
            return;
        }
        Node node = new Node(data);
        Node list = head;
        while (head.next !=null) {
            head = head.next;
        }
        head.next = node;
        head = list;
    }

    private static void deque() {
        if (head.next == null) {
            System.out.println(head.data);
            head = null;
            return;
        }
        System.out.println(head.data);
        head = head.next;
    }

    public static void main(String[] args) {
        enqueue(10);
        enqueue(20);
        enqueue(30);
        enqueue(40);
        enqueue(50);
        deque();
        deque();
        deque();
        deque();
        deque();
    }
}
