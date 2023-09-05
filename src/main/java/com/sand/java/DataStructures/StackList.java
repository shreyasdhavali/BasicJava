package com.sand.java.DataStructures;

import java.util.Stack;

public class StackList {
    static Node tail;

    private static void push(int data) {
        if (tail == null) {
            tail = new Node(data);
            return;
        }
        Node node = new Node(data);
        node.previous = tail;
        tail = node;
    }

    private static void pop() {
        if (tail.previous == null) {
            System.out.println(tail.data);
            tail = tail.previous;
            return;
        }
        int data = tail.data;
        tail = tail.previous;
        System.out.println(data);

    }

    public static void main(String[] args) {
        push(10);
        push(20);
        push(30);
        push(40);
        push(50);
        push(60);
        push(70);
        pop();
        pop();
        pop();
        Stack<Integer> stack = new Stack<>();
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
