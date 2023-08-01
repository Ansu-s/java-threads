package com.java.Threads;

public class MyThreads extends Thread {

@Override
    public  void run() {
    int i = 0;
    while (i < 100) {
        System.out.println("hello");
        i++;

    }
}}
    class  Therads2 extends MyThreads{

@Override
        public  void run() {
            int i = 0;
            while (i < 100) {
                System.out.println("java");
                i++;

            }
        }
//       int i = 0;
//        while (i < 100) {
//            System.out.println("hello ");
//            i++;
//        }
//
//
//        i = 0;
//        while (i < 100) {
//            System.out.println("Java ");
//            i++;
public static void main(String[] args) {

            MyThreads o1 = new MyThreads();
            Therads2 o2 = new Therads2();
            o1.start();
             o2.start();
        }
    }

