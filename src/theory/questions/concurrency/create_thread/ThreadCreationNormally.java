package theory.questions.concurrency.create_thread;


import java.util.concurrent.*;

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Create Thread Using Thread Class. Thread :: " + Thread.currentThread()
                                                                                  .getName());
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Create Thread Using Runnable Interface. Thread :: " + Thread.currentThread()
                                                                                        .getName());
    }
}

class MyCallable implements Callable<String> {
    @Override
    public String call() {
        System.out.println("Create Thread Using Runnable Interface. Thread :: " + Thread.currentThread()
                                                                                        .getName());
        return "Callable Interface Called";
    }
}

public class ThreadCreationNormally {

    public static void main(String[] args)
            throws ExecutionException, InterruptedException, TimeoutException {
        System.out.println("Main Thread :: " + Thread.currentThread()
                                                     .getName());

        MyThread thread = new MyThread();
        thread.setName("ThreadClass");
        thread.start();

        MyRunnable runnable = new MyRunnable();
        Thread runnableThread = new Thread(runnable);
        runnableThread.setName("RunnableInterface");
        runnableThread.start();

        MyCallable callable = new MyCallable();
        FutureTask<String> callableFuture = new FutureTask<>(callable);
        Thread callableThread = new Thread(callableFuture);
        callableThread.setName("CallableInterface");
        callableThread.start();
        System.out.printf("Return of callable task :: " + callableFuture.get(1000, TimeUnit.SECONDS));
    }
}
