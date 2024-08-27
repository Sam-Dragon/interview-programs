package misc.programs.concurrency;

import java.util.stream.Stream;

public class ProducerConsumerProblem {

    public static void main(String[] args) {

        ProducerConsumerProblem producerConsumerProblem = new ProducerConsumerProblem();
        Stream.of("Hello", "How are you", "Khana", "Khake", "Jana")
            .forEach(producerConsumerProblem::method);
    }

    public void method(String message) {
        Thread producerThread = new Thread(() -> produce(message));
        producerThread.setName("producer-thread");
        producerThread.start();

        try {
            producerThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Thread consumerThread = new Thread(() -> consume(message));
        consumerThread.setName("consumer-thread");
        consumerThread.start();
    }

    synchronized void produce(String message) {
        if (message != null || !message.isEmpty()) {
            System.out.println("Produced message :: " + message);
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    synchronized void consume(String message) {
        if (message != null || !message.isEmpty()) {
            System.out.println("Consumed message :: " + message);
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
