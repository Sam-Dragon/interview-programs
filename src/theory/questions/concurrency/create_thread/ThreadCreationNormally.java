package theory.questions.concurrency.create_thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

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

class MyCallable implements Callable {
    @Override
    public Object call() {
        System.out.println("Create Thread Using Runnable Interface. Thread :: " + Thread.currentThread()
                                                                                        .getName());
        return null;
    }
}

public class ThreadCreationNormally {

    public static void main(String[] args) {
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
        FutureTask callableFuture = new FutureTask(callable);
        Thread callableThread = new Thread(callableFuture);
        callableThread.setName("CallableInterface");
        callableThread.start();
    }
}
