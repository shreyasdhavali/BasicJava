package com.sand.java.thread;

import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteListExample {
    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> copyOnWriteList = new CopyOnWriteArrayList<>();

        Runnable writeTask = () -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("writing task " + i);
                copyOnWriteList.add(i);
            }
        };

        Runnable readTask = () -> {
            for (Integer value : copyOnWriteList) {
                System.out.println(value);
            }
        };

        Thread writerThread = new Thread(writeTask);
        Thread readerThread = new Thread(readTask);

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

