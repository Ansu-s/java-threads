package com.java.Threads;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class ExecutorThreadpool {
    public static void main(String[] args) {



                int numThreads = 4;
                ExecutorService executorService = Executors.newFixedThreadPool(numThreads);

                try {

                    for (int i = 1; i <= 10; i++) {
                        int number = i;
                        executorService.submit(() -> calculateSquare(number));
                    }
                } finally {

                    executorService.shutdown();
                }
            }

            private static void calculateSquare(int number) {
                int square = number * number;
                System.out.println("Square of " + number + " = " + square);
            }

}



