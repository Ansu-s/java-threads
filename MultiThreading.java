import java.util.LinkedList;
import java.util.Queue;

public class MultiThreading {


    public static class ProducerConsumer {
        private static final int MAX_CAPACITY = 5;
        private final Queue<Integer> buffer = new LinkedList<>();

        public void produce() throws InterruptedException {
            int item = 0;
            while (true) {
                synchronized (this) {
                    while (buffer.size() == MAX_CAPACITY) {
                        System.out.println("Buffer is full. Producer is waiting...");
                        wait();
                    }
                    System.out.println("Producing: " + item);
                    buffer.add(item++);
                    notify();
                    Thread.sleep(1000);
                }
            }
        }

        public void consume() throws InterruptedException {
            while (true) {
                synchronized (this) {
                    while (buffer.isEmpty()) {
                        System.out.println("Buffer is empty. Consumer is waiting...");
                        wait();
                    }
                    int item = buffer.poll();
                    System.out.println("Consuming: " + item);
                    notify();
                    Thread.sleep(1000);
                }
            }
        }

        public static void main(String[] args) {
            ProducerConsumer pc = new ProducerConsumer();

            Thread producerThread = new Thread(() -> {
                try {
                    pc.produce();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });

            Thread consumerThread = new Thread(() -> {
                try {
                    pc.consume();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });

            producerThread.start();
            consumerThread.start();
        }
    }

}
