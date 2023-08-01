package com.java.Threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class InvokeAllExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        try {
            List<Callable<Integer>> list = new ArrayList<>();
            list.add(new SquareCalculator1(2));
            list.add(new SquareCalculator1(4));
            list.add(new SquareCalculator1(6));
            list.add(new SquareCalculator1(8));

            List<Future<Integer>> futures = executorService.invokeAll(list);

            for (int i = 0; i < futures.size(); i++) {
                Future<Integer> future = futures.get(i);
                int number = 2 * (i + 1);
                int square = future.get();
                System.out.println("Square of " + number + " is: " + square);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}

class SquareCalculator implements Callable<Integer> {
    private int number;

    public SquareCalculator(int number) {
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {
        return number * number;
    }
}
