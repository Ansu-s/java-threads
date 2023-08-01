package com.java.Threads;
import java.util.concurrent.CompletableFuture;

public class thenApply {



        public static void main(String[] args) {
            int number = 5;

            CompletableFuture<Integer> squareFuture = CompletableFuture.supplyAsync(() -> calculateSquare(number));
            CompletableFuture<Integer> cubeFuture = squareFuture.thenApply(thenApply::calculateCube);

            try {
                int cube = cubeFuture.get();
                System.out.println("Cube of the square of " + number + " is: " + cube);
            } catch (Exception e) {
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
