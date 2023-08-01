package com.java.Threads;

public class ThreadRunnable implements Runnable {

    @Override
    public void run() {

    }
}
     class first extends ThreadRunnable {
        public void run() {
            for (int i = 1; i < 100; i++)
                System.out.println("one ");
        }
    }

     class second extends first {
        public void run() {
            for (int i = 1; i < 100; i++)
                System.out.println("two ");
        }

        public static void main(String[] args) {


            first o1 = new first();
            second o2 = new second();
            Thread t1 = new Thread(o1);
            Thread t2 = new Thread(o2);
            t1.start();
            t2.start();

        }

    }
