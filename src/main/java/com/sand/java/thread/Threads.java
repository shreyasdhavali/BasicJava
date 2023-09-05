package com.sand.java.thread;

public class Threads implements Runnable{

    public static void main(String[] args) {
        Threads t = new Threads();
        Thread thread = new Thread(t);
        thread.start();
        Runnable runnable = () -> System.out.println("Thread lambda is running");
        Thread t1 = new Thread(runnable);
        t1.start();
    }


    @Override
    public void run() {
        System.out.println("Thread has begun");
    }
}

