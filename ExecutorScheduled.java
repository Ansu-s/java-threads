package com.java.Threads;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
public class ExecutorScheduled {



        public static void main(String[] args) {
            ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

            try {
                scheduledExecutorService.scheduleAtFixedRate(() -> System.out.println("Hello, world!"), 5, 2, TimeUnit.SECONDS);

                Thread.sleep(10000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {

                scheduledExecutorService.shutdown();
            }
        }

}
