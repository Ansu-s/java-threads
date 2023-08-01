package com.java.Threads;
import java.util.concurrent.CompletableFuture;

public class thenAcceptThenRun {


        public static void main(String[] args) {

            CompletableFuture<Integer> squareFuture = CompletableFuture.supplyAsync(() -> calculateSquare(5));
            squareFuture.thenAccept(square -> System.out.println("Square: " + square));


            CompletableFuture<Integer> cubeFuture = CompletableFuture.supplyAsync(() -> calculateCube(5));
            cubeFuture.thenRun(() -> System.out.println("Cube calculation completed."));
        }

        private static int calculateSquare(int number) {
            return number * number;
        }

        private static int calculateCube(int number) {
            return number * number * number;
        }


}
