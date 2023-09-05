package com.sand.java.thread;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerExample {
    public static void main(String[] args) {
        final Queue<Integer> buffer = new LinkedList<>();
        final int BUFFER_CAPACITY = 5;

        Thread producerThread = new Thread(() -> {
            int value = 0;
            while (value <=10) {
                synchronized (buffer) {
                    while (buffer.size() == BUFFER_CAPACITY) {
                        try {
                            buffer.wait(); // Wait if buffer is full
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Producing: " + value);
                    buffer.add(value++);
                    buffer.notify(); // Notify waiting consumers
                }
            }
        });

        Thread consumerThread = new Thread(() -> {
            int value = 0;
            while (value <= 10) {
                synchronized (buffer) {
                    while (buffer.isEmpty()) {
                        try {
                            buffer.wait(); // Wait if buffer is empty
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    value = buffer.poll();
                    System.out.println("Consuming: " + value);
                    buffer.notify(); // Notify waiting producers
                }
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}

