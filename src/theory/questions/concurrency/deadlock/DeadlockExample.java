package theory.questions.concurrency.deadlock;

public class DeadlockExample {
    static final Object lock1 = new Object();
    static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                }
                synchronized (lock2) {
                    System.out.println("T1 finished");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                }
                synchronized (lock1) {
                    System.out.println("T2 finished");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
