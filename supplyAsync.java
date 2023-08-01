package com.java.Threads;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class supplyAsync {


        public static void main(String[] args) {
            CompletableFuture<Integer> futureResult = CompletableFuture.supplyAsync(() -> calculateSum(5, 10));

            try {
                int result = futureResult.get();
                System.out.println("Result of the asynchronous : " + result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private static int calculateSum(int a, int b) {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return a + b;
        }



}
