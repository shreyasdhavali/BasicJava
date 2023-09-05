package com.sand.java.thread;

public class VolatileExample {
    private static volatile boolean flag = false;

    public static void main(String[] args) {
        Thread writerThread = new Thread(() -> {
            System.out.println("Writer thread is starting...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag = true;
            System.out.println("Flag set to true.");
        });

        Thread readerThread = new Thread(() -> {
            System.out.println("Reader thread is starting...");

            while (!flag) {
                // Spin until flag becomes true
            }
            System.out.println("Reader thread: Flag is true now.");
        });

        writerThread.start();
        readerThread.start();

        try {
            writerThread.join();
            readerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
