package misc.questions.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class IncrementCounterInMultithreading {

    private static final AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> System.out.println("Thread :: " + Thread.currentThread()
                .getName() + " > Incrementing Counter :: " + counter.addAndGet(1)));
            thread.setName("Thread - " + i);
            thread.start();
            thread.join();
        }
    }
}