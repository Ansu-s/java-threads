package com.java.Threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class invokeAnyExample {

        public static void main(String[] args) {
            ExecutorService executorService = Executors.newFixedThreadPool(4);

            try {
                List<Callable<Integer>> list1 = new ArrayList<>();
                list1.add(new SquareCalculator1(2));
                list1.add(new SquareCalculator1(4));
                list1.add(new SquareCalculator1(6));
                list1.add(new SquareCalculator1(8));

                int result = executorService.invokeAny(list1);

                System.out.println("Result of the first completed square: " + result);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                executorService.shutdown();
            }
        }
    }

    class SquareCalculator1 implements Callable<Integer> {
        private int number;

        public SquareCalculator1(int number) {
            this.number = number;
        }

        @Override
        public Integer call() throws Exception {
            return number * number;
        }
    }


