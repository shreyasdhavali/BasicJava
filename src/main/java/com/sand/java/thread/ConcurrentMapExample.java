package com.sand.java.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentMapExample {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> threadSafeMap = new ConcurrentHashMap<>();
        Map<String, Integer> notThreadSafeMap = new HashMap<>();
        Runnable writeTask = () -> {
            for (int i = 0; i < 1000; i++) {
                threadSafeMap.put("Key" + i, i);
                notThreadSafeMap.put("key" + i, i);
            }
        };

        Runnable readTask = () -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("Key - safe - " + i + ": " + threadSafeMap.get("Key" + i));
                System.out.println("Key - not safe" + i + ": " + notThreadSafeMap.get("Key" + i));
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

