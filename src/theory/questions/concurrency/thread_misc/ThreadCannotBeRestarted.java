package theory.questions.concurrency.thread_misc;

public class ThreadCannotBeRestarted {

    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("Thread Executed :: " + Thread.currentThread()
                                                                                   .getName());
        Thread thread = new Thread(runnable);
        thread.setName("ThreadCannotBeRestarted");

        System.out.println("Thread Started For First Time");
        thread.start();

        System.out.println("Thread Started For Successive Time");
        thread.start();
    }
}
