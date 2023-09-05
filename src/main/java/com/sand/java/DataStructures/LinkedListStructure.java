package com.sand.java.DataStructures;

class LinkedListStructure{

    static Node head;
    static int len = 0;

    static void printList(Node head) {
        System.out.println();
        Node list = head;
        while (list != null) {
            System.out.print(list.data + " ");
            list = list.next;
        }
        System.out.println("len " + len);
    }

    static void reverseList() {
        Node prev = null;
        Node current = head;
        Node next = null;

        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        printList(prev);

    }

    static void pushAtEnding(int data) {
        len +=1;
        if (head == null) {
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

    private static void pushAtBeginning(int data) {
        len +=1;
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node node = new Node(data);
        node.next = head;
        head = node;
    }
    private static void remove(int data) {
        if (head.data == data) {
            len -=1;
            head = head.next;
            return;
        }
        Node list = head;
        while (head.next != null) {
            if (head.next.data == data) {
                len -=1;
                head.next = head.next.next;
                break;
            }
            head = head.next;
        }
        head = list;
    }

    public static void main(String[] args) {
        pushAtEnding(10);
        pushAtEnding(20);
        pushAtEnding(30);
        pushAtEnding(40);
        pushAtEnding(50);
        pushAtEnding(60);
        pushAtEnding(70);
        pushAtEnding(80);
        printList(head);
        pushAtBeginning(100);
        pushAtBeginning(200);
        pushAtBeginning(300);
        pushAtBeginning(400);
        pushAtBeginning(500);
        pushAtBeginning(600);
        printList(head);
        remove(200);
        remove(600);
        printList(head);
        reverseList();
    }

}