package misc.questions.concurrency;

public class ThreadRunMethodCall {

    public static void main(String[] args) {
        ThreadClass thread = new ThreadClass();

        // thread.run() executes the method but in same thread
        System.out.println("thread.run() call");
        System.out.println("MainClass > " + Thread.currentThread()
            .getName());
        thread.run();

        // thread.start() executes the method but in new thread
        System.out.println("\nthread.start() call");
        System.out.println("MainClass > " + Thread.currentThread()
            .getName());
        thread.start();
    }
}

class ThreadClass extends Thread {
    public void run() {
        System.out.println("ThreadClass > " + Thread.currentThread()
            .getName());
    }
}