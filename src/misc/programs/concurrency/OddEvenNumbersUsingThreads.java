package misc.programs.concurrency;

import java.util.concurrent.*;

public class OddEvenNumbersUsingThreads {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int j : array) {
            Callable<Integer> task = new OddEvenTask(j);
            Future<Integer> result = executorService.submit(task);
            System.out.println(j + " = " + ((result.get() == 0) ? "EVEN" : "ODD"));
        }

        executorService.shutdown();
    }
}


class OddEvenTask implements Callable<Integer> {
    public int number;

    public OddEvenTask(int number) {
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("Running Thread :: " + Thread.currentThread()
            .getName());
        return number % 2;
    }
}