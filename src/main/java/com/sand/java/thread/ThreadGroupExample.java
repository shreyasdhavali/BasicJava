package com.sand.java.thread;

public class ThreadGroupExample {
    public static void main(String[] args) {
        // Create a thread group
        ThreadGroup myThreadGroup = new ThreadGroup("MyThreadGroup");

        // Create threads within the thread group
        Thread thread1 = new Thread(myThreadGroup, new MyRunnable(), "Thread 1");
        Thread thread2 = new Thread(myThreadGroup, new MyRunnable(), "Thread 2");

        // Start the threads
        thread1.start();
        thread2.start();

        // Display information about the thread group
        myThreadGroup.list();
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

