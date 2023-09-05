package com.sand.java.thread;

public class ThreadLocalExample {
    private static ThreadLocal<Integer> threadLocalCounter = ThreadLocal.withInitial(() -> 0);

    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyRunnable());
        Thread thread2 = new Thread(new MyRunnable());

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            int count = threadLocalCounter.get();
            count++;
            threadLocalCounter.set(count);

            System.out.println("Thread " + Thread.currentThread().getId() +
                    ": Counter value = " + threadLocalCounter.get());

            try {
                Thread.sleep(500); // Simulate some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            threadLocalCounter.remove(); // Clean up the ThreadLocal value
        }
    }
}

