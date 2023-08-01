package com.java.Threads;


    public class Threadjoin {

        public static void  main(String[] args) {
            SharedResource sharedResource = new SharedResource();

            Thread thread1 = new Thread(() -> {
                for (int i = 0; i < 10000; i++) {
                    sharedResource.increment();
                }
            });

            Thread thread2 = new Thread(() -> {
                for (int i = 0; i < 10000; i++) {
                    sharedResource.increment();
                }
            });

            thread1.start();
            thread2.start();

            try {
                thread1.join();
                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Final count: " + sharedResource.getCount());
        }
    }

    class SharedResource {
        private int count = 0;

        public int getCount() {
            return count;
        }

        public void increment() {
            synchronized (this) {
                count++;
            }
        }
    }


