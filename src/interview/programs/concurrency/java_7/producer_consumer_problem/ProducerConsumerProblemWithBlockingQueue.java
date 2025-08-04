package interview.programs.concurrency.java_7.producer_consumer_problem;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class ProducerBlockingQueue implements Runnable {
    private final BlockingQueue<Integer> queue;

    public ProducerBlockingQueue(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        var i = 1;
        while (i <= 10) {
            try {
                queue.put(i++);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class ConsumerBlockingQueue implements Runnable {
    private final BlockingQueue<Integer> queue;

    public ConsumerBlockingQueue(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                var value = queue.take();
                System.out.println(value + " ");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

public class ProducerConsumerProblemWithBlockingQueue {

    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(16);
        new ProducerBlockingQueue(queue).run();
        new ConsumerBlockingQueue(queue).run();
    }

}
