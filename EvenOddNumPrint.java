package com.java.Threads;

public class EvenOddNumPrint {

        private static final Object lock = new Object();
        private static int number = 1;
        private static final int maxNum = 10;

        public static void main(String[] args) {
            Thread evenThread = new Thread(() -> printEvenNumbers());
            Thread oddThread = new Thread(() -> printOddNumbers());

            evenThread.start();
            oddThread.start();
        }

        private static void printEvenNumbers() {
            while (number <= maxNum) {
                synchronized (lock) {
                    if (number % 2 == 0) {
                        System.out.print(number + " ");
                        number++;
                        lock.notify();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        private static void printOddNumbers() {
            while (number <= maxNum) {
                synchronized (lock) {
                    if (number % 2 == 1) {
                        System.out.print(number + " ");
                        number++;
                        lock.notify();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }


