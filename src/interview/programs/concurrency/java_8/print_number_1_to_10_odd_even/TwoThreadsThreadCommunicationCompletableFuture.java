package interview.programs.concurrency.java_8.print_number_1_to_10_odd_even;

import java.util.concurrent.CompletableFuture;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class TwoThreadsThreadCommunicationCompletableFuture {

    private static final Object object = new Object();

    static IntPredicate oddPredicate = x -> x % 2 != 0;
    static IntPredicate evenPredicate = x -> x % 2 == 0;

    public static void print(IntPredicate predicate) {
        IntStream.rangeClosed(1, 10)
                 .filter(predicate)
                 .forEach(TwoThreadsThreadCommunicationCompletableFuture::execute);
    }

    private static void execute(int i) {
        synchronized (object) {
            System.out.println(Thread.currentThread()
                                     .getName() + " - " + i);
            object.notify();
            try {
                Thread.sleep(1000);
                object.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args)
            throws InterruptedException {
        CompletableFuture.runAsync(() -> TwoThreadsThreadCommunicationCompletableFuture.print(oddPredicate));
        CompletableFuture.runAsync(() -> TwoThreadsThreadCommunicationCompletableFuture.print(evenPredicate));
        Thread.sleep(10000);
    }
}
