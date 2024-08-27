package misc.programs.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class CountMethodAccessThreads {
    AtomicInteger counter = new AtomicInteger(0);
    AtomicInteger modCounter = new AtomicInteger(0);
    static int limit = 10;

    public static void main(String[] args) throws InterruptedException {
        CountMethodAccessThreads threads = new CountMethodAccessThreads();

        Thread thread = new Thread(() -> threads.modThreeMethod(limit));
        thread.start();
        thread.join();

        System.out.println("count :: " + threads.modCounter.get());
    }

    public void modThreeMethod(int limit) {
        while (counter.get() < limit)
            if (counter.addAndGet(1) % 3 != 0)
                modCounter.addAndGet(1);
    }
}
