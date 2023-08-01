package com.java.Threads;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class runAsync {


        public static void main(String[] args) {

            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> printMessage("Hello, World!"));


            try {
                future.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private static void printMessage(String message) {

            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println(message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


}
