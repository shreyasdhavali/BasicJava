package com.sand.java.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
    public static void main(String[] args) {
        // Create a thread pool with 4 worker threads
        ExecutorService executor = Executors.newFixedThreadPool(4);

        // Submit tasks to the thread pool
        for (int i = 1; i <= 10; i++) {
            Runnable task = new Task(i);
            executor.execute(task);
        }

        // Shut down the thread pool
        executor.shutdown();
    }
}

class Task implements Runnable {
    private int taskId;

    public Task(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("Task " + taskId + " is being executed by thread " + Thread.currentThread().getName());
        // Task logic here
    }
}

