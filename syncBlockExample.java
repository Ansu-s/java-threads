package com.java.Threads;
import java.util.function.Consumer;
public class syncBlockExample {


    public static class SynchronizedExample {

        public static void main(String[] args) {

            Consumer<String> func = (String exp) -> {

                synchronized(SynchronizedExample.class) {

                    System.out.println(
                            Thread.currentThread().getName() +
                                    " step 1: " + exp);

                    try {
                        Thread.sleep( (long) (Math.random() * 1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(
                            Thread.currentThread().getName() +
                                    " step 2: " + exp);
                }

            };


            Thread thread1 = new Thread(() -> func.accept("It is being executed"), "Thread 1");
            Thread thread3 = new Thread(() -> func.accept("executed"), "Thread 3");

            Thread thread2 = new Thread(() -> {
                func.accept("executed");
            }, "Thread 2");

            thread1.start();
            thread2.start();
            thread3.start();
        }
    }
}
