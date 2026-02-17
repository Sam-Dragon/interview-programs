package interview.programs.java_8_and_above.concurrency.java_7.print_number_1_to_10_odd_even;

class EvenOddThreadUsingCommunication implements Runnable {
    static int count = 1;
    final Object object;

    public EvenOddThreadUsingCommunication(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread()
                                  .getName();

        while (count <= 10) {
            if (count % 2 == 0 && "even-thread".equals(threadName)) {
                synchronized (object) {
                    System.out.println(Thread.currentThread()
                                             .getName() + " - " + count);
                    count++;
                    try {
                        Thread.sleep(3000);
                        object.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            if (count % 2 != 0 && "odd-thread".equals(threadName)) {
                synchronized (object) {
                    System.out.println(Thread.currentThread()
                                             .getName() + " - " + count);
                    count++;
                    object.notify();
                }
            }
        }
    }
}

public class TwoThreadsUsingThreadCommunication {

    public static void main(String[] args)
            throws InterruptedException {
        System.out.println("Running in Thread :: " + Thread.currentThread()
                                                           .getName());

        Object object = new Object();

        EvenOddThreadUsingCommunication evenRunnable = new EvenOddThreadUsingCommunication(object);
        Thread evenThread = new Thread(evenRunnable);
        evenThread.setName("even-thread");
        evenThread.start();

        EvenOddThreadUsingCommunication oddRunnable = new EvenOddThreadUsingCommunication(object);
        Thread oddThread = new Thread(oddRunnable);
        oddThread.setName("odd-thread");
        oddThread.start();
    }
}
