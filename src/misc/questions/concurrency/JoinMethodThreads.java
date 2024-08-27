package misc.questions.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class JoinMethodThreads {

    private static int volatileCounter = 1;
    private static final AtomicInteger atomicCounter = new AtomicInteger(1);

    public static void main(String[] args) throws InterruptedException {
        JoinMethodThreads threads = new JoinMethodThreads();

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                try {
                    threads.incrementVolatileCounter();
                    threads.incrementAtomicCounter();

                    System.out.println();
                    System.out.println(Thread.currentThread()
                        .getName() + " > slept for 3 secs");
                    Thread.sleep(3000);
                    System.out.println(Thread.currentThread()
                        .getName() + " > waked up after 3 secs");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            thread.setName("Thread - " + i);
            thread.start();
            thread.join();
        }

        System.out.println("Final Volatile counter: " + volatileCounter);
        System.out.println("Final Atomic counter: " + atomicCounter);
    }

    private void incrementAtomicCounter() {
        System.out.println("AtomicCounter: " + JoinMethodThreads.atomicCounter.accumulateAndGet(1, Integer::sum));
    }

    private void incrementVolatileCounter() {
        JoinMethodThreads.volatileCounter = JoinMethodThreads.volatileCounter + 1;
        System.out.println("VolatileCounter: " + JoinMethodThreads.volatileCounter);
    }
}
