package com.java.Threads;
import java.util.concurrent.CompletableFuture;

public class thenCombine {




        public static void main(String[] args) {
            CompletableFuture<Integer> squareFuture = CompletableFuture.supplyAsync(() -> calculateSquare(5));
            CompletableFuture<Integer> cubeFuture = CompletableFuture.supplyAsync(() -> calculateCube(5));

            CompletableFuture<Integer> combinedFuture = squareFuture.thenCombine(cubeFuture, (square, cube) -> square + cube);

            combinedFuture.thenAccept(sum -> System.out.println("Sum of square and cube: " + sum));


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private static int calculateSquare(int number) {
            return number * number;
        }

        private static int calculateCube(int number) {
            return number * number * number;
        }


}
