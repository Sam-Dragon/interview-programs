package interview.programs.threads;

import java.util.Scanner;


class AlternateNumber3Thread {
    private final int max;
    private int counter = 1;

    public AlternateNumber3Thread(int max) {
        this.max = max;
    }

    public synchronized void printOne() {
        while (counter <= max) {
            while (counter % 2 == 0 || counter % 3 == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread()
                          .interrupt();
                }
            }
            if (counter <= max) {
                System.out.println(Thread.currentThread()
                                         .getName() + " -> " + counter);
                counter++;
                // Reset Counter
                if (counter > max) {
                    counter = 1;
                }
                notifyAll();
            }
        }
    }

    public synchronized void printTwo() {
        while (counter <= max) {
            while (counter % 2 != 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread()
                          .interrupt();
                }
            }
            if (counter <= max) {
                System.out.println(Thread.currentThread()
                                         .getName() + " -> " + counter);
                counter++;
                // Reset Counter
                if (counter > max) {
                    counter = 1;
                }
                notifyAll();
            }
        }
    }

    public synchronized void printThree() {
        while (counter <= max) {
            while (counter % 3 != 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread()
                          .interrupt();
                }
            }
            if (counter <= max) {
                System.out.println(Thread.currentThread()
                                         .getName() + " -> " + counter);
                counter++;
                // Reset Counter
                if (counter > max) {
                    counter = 1;
                }
                notifyAll();
            }
        }
    }

}

// Print Numbers from 1 to 10
public class NumberSequenceUsingThreeThreads {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number for Threads to execute");
        int number = sc.nextInt();
        System.out.println("Numbers to be printed up to " + number);

        AlternateNumber3Thread alternateNumberThread = new AlternateNumber3Thread(number);

        Thread thread_1 = new Thread(alternateNumberThread::printOne, "first-thread");
        thread_1.start();

        Thread thread_2 = new Thread(alternateNumberThread::printTwo, "second-thread");
        thread_2.start();

        Thread thread_3 = new Thread(alternateNumberThread::printThree, "third-thread");
        thread_3.start();
    }
}
