package interview.programs.java_8_and_above.concurrency.java_8.print_number_1_to_10_odd_even;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class TwoThreadsJoinMethod {

    public static void main(String[] args)
            throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        IntStream.rangeClosed(1, 10)
                 .forEach(i -> {
                     // Even Execution
                     CompletableFuture<Integer> evenFuture = CompletableFuture.supplyAsync(
                             () -> {
                                 if (i % 2 == 0) {
                                     System.out.println(Thread.currentThread()
                                                              .getName() + " - " + i);
                                 }
                                 return i;
                             }, executorService);
                     evenFuture.join();

                     // Odd Execution
                     CompletableFuture<Integer> oddFuture = CompletableFuture.supplyAsync(
                             () -> {
                                 if (i % 2 != 0) {
                                     System.out.println(Thread.currentThread()
                                                              .getName() + " - " + i);
                                 }
                                 return i;
                             }, executorService);
                     oddFuture.join();
                 });

        executorService.shutdown();
    }
}
