package com.java.Threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableThreadIntrface {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        try {
            int number = 10;


            Future<Integer> futureResult = executorService.submit(new SumCalculator(number));

            int sumResult = futureResult.get();

            System.out.println("Sum of numbers from 1 to " + number + " is: " + sumResult);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            executorService.shutdown();
        }
    }
}

class SumCalculator implements Callable<Integer> {
    private int number;

    public SumCalculator(int number) {
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {
        if (number < 0) {
            throw new IllegalArgumentException("Number must be non-negative.");
        }

        int sum = 0;
        for (int i = 1; i <= number; i++) {
            sum += i;
        }

        return sum;
    }
}
