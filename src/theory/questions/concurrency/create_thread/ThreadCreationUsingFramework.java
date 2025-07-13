package theory.questions.concurrency.create_thread;

import java.util.concurrent.*;

public class ThreadCreationUsingFramework {

    public static void main(String[] args)
            throws ExecutionException, InterruptedException, TimeoutException {
        // Create Executor Service and assign task to it
        ExecutorService service = Executors.newFixedThreadPool(2);

        Runnable runnableTask = () -> System.out.println("Running Task using Runnable :: " + Thread.currentThread());
        service.execute(runnableTask);

        Callable<String> callableTask = () -> {
            System.out.println("Running Task using Callable :: " + Thread.currentThread());
            Thread.sleep(2000);
            return "Accepted";
        };
        Future<String> task = service.submit(callableTask);
        var value = task.get(3, TimeUnit.SECONDS);
        System.out.println("Output :: " + value);
    }
}
