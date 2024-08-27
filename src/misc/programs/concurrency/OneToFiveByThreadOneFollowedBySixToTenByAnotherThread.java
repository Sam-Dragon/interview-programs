package misc.programs.concurrency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

public class OneToFiveByThreadOneFollowedBySixToTenByAnotherThread {

    AtomicInteger number = new AtomicInteger(1);

    public static void main(String[] args) {
        OneToFiveByThreadOneFollowedBySixToTenByAnotherThread range = new OneToFiveByThreadOneFollowedBySixToTenByAnotherThread();
        Thread oneToFiveThread = new Thread(() -> range.printNumbers(i -> i <= 5));
        oneToFiveThread.setName("oneToFiveThread");
        oneToFiveThread.start();

        Thread sixToTenThread = new Thread(() -> range.printNumbers(i -> i > 5 && i <= 10));
        sixToTenThread.setName("sixToTenThread");
        sixToTenThread.start();
    }

    private synchronized void printNumbers(Predicate<Integer> predicate) {
        while (predicate.test(number.get())) {
            System.out.println(Thread.currentThread()
                .getName() + " - " + number.get());
            number.getAndIncrement();
            notify();
        }
        try {
            wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
