package com.sand.java.thread;

public class InterruptExample {
    public static void main(String[] args) {
        Thread myThread = new Thread(new MyRunnable());
        myThread.start();

        try {
            Thread.sleep(2000); // Let the thread run for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        myThread.interrupt(); // Interrupt the thread
    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Thread is running...");
                try {
                    Thread.sleep(500); // Simulate some work
                } catch (InterruptedException e) {
                    System.out.println("Thread got interrupted!");
                    Thread.currentThread().interrupt(); // Set the interrupted flag again
                }
            }
        }
    }
}

