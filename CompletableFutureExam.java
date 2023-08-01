package com.java.Threads;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExam {
    public static void main(String[] args) {
        int number = 5;

        CompletableFuture<Integer> futureResult = CompletableFuture.supplyAsync(() -> calculateSquare(number));

        futureResult.thenAccept(square -> System.out.println("Square of " + number + " is: " + square));

        try {

            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static int calculateSquare(int number) {
        return number * number;
    }
}
