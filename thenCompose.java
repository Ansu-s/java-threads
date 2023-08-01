package com.java.Threads;
import java.util.concurrent.CompletableFuture;

public class thenCompose {




        public static void main(String[] args) {
            CompletableFuture<Integer> firstFuture = CompletableFuture.supplyAsync(() -> calculateSquare(10));

            CompletableFuture<Integer> composedFuture = firstFuture.thenCompose(square -> CompletableFuture.supplyAsync(() -> calculateCube(square)));

            composedFuture.thenAccept(cube -> System.out.println("Cube of the square: " + cube));


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
