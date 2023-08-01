package com.java.Threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

 class ArrayBlockingQueueExample {
    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(5);


        new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    blockingQueue.put(i);
                    System.out.println("Produced: " + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    int element = blockingQueue.take();
                    System.out.println("Consumed: " + element);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
