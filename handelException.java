package com.java.Threads;
import java.util.concurrent.CompletableFuture;

public class handelException {


        public static void main(String[] args) {
            CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> calculateSquare(0));

            CompletableFuture<Integer> resultFuture = future.thenApply(square -> square * 2)
                    .handle(handelException::handleResultAndException);

            resultFuture.thenAccept(result -> System.out.println("Result: " + result));
        }

        private static int calculateSquare(int number) {
            if (number == 0) {
                throw new RuntimeException("Error: Cannot calculate the square of 5.");
            }
            return number * number;
        }

        private static int handleResultAndException(Integer result, Throwable ex) {
            if (ex != null) {
                System.out.println("Caught exception: " + ex.getMessage());
                return 0;
            }
            return result * 10;
        }


}
