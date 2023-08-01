package com.java.Threads;
import java.util.concurrent.CompletableFuture;

public class exceptionallyExceptionHandel {




        public static void main(String[] args) {
            CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> calculateSquare(0));

            CompletableFuture<Integer> resultFuture = future.thenApply(square -> square * 2)
                    .exceptionally(ex -> handleException(ex));

            resultFuture.thenAccept(result -> System.out.println("Result: " + result));
        }

        private static int calculateSquare(int number) {
            if (number == 0) {
                throw new RuntimeException("Error: Cannot calculate the square of .");
            }
            return number * number;
        }

        private static int handleException(Throwable ex) {
            System.out.println("Caught exception: " + ex.getMessage());
            return 0;
        }
}


