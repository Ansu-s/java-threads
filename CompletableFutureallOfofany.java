package com.java.Threads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
public class CompletableFutureallOfofany {



        public static void main(String[] args) {

            CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(() -> Square(5));
            CompletableFuture<Integer> f2 = CompletableFuture.supplyAsync(() -> Square(3));

            CompletableFuture<Void> allOfFuture = CompletableFuture.allOf(f1, f2);

            allOfFuture.thenRun(() -> System.out.println("All computations completed."));


            CompletableFuture<Integer> f3 = CompletableFuture.supplyAsync(() -> Square(7));
            CompletableFuture<Integer> f4 = CompletableFuture.supplyAsync(() -> Square(9));

            CompletableFuture<Object> anyOfFuture = CompletableFuture.anyOf(f3, f4);

            anyOfFuture.thenAccept(result -> System.out.println("Any computation completed with result: " + result));


            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private static int Square(int number) {
            try {
                TimeUnit.SECONDS.sleep(number);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return number * number;
        }


}
