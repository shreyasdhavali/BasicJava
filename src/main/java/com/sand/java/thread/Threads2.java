package com.sand.java.thread;

public class Threads2 extends Thread {

    public static void main(String[] args) throws InterruptedException {
        Threads2 t = new Threads2();
//        Thread.MAX_PRIORITY;
        System.out.println(t.getState());
        t.start();
        System.out.println(t.getState());

    }

    @Override
    public void run() {
        System.out.println("Thread is running");
    }

}
