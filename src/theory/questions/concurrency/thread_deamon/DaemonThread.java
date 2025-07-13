package theory.questions.concurrency.thread_deamon;

public class DaemonThread {

    public static void main(String[] args) {
        Runnable schedulerTask = () -> System.out.println("Invoke Scheduler");

        Thread thread = new Thread(schedulerTask);
        thread.setName("Daemon");
        thread.setDaemon(true);
        thread.start();
    }
}
