package interview.programs.threads;

import java.util.Scanner;


class AlternateNumberThread {
    private final int max;
    private int number = 1;

    public AlternateNumberThread(int max) {
        this.max = max;
    }

    public synchronized void printEven() {
        while (number <= max) {
            while (number % 2 != 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    /*Thread.currentThread()
                          .interrupt();*/
                }
            }
            if (number <= max) {
                System.out.println(Thread.currentThread()
                                         .getName() + " -> " + this.number);
                number++;
                notify();
            }
        }
    }

    public synchronized void printOdd() {
        while (number <= max) {
            while (number % 2 == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    /*Thread.currentThread()
                          .interrupt();*/
                }
            }
            if (number <= max) {
                System.out.println(Thread.currentThread()
                                         .getName() + " -> " + this.number);
                number++;
                notify();
            }
        }
    }
}

// Print Numbers from 1 to 10
public class NumberSequenceUsingTwoThreads {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number for Threads to execute");
        int number = sc.nextInt();
        System.out.println("Numbers to be printed up to " + number);

        AlternateNumberThread alternateNumberThread = new AlternateNumberThread(number);
        // If you don't use thread.join, the output of numbers is unpredictable
        Thread oddThread = new Thread(alternateNumberThread::printOdd, "odd-thread");
        oddThread.start();

        Thread evenThread = new Thread(alternateNumberThread::printEven, "even-thread");
        evenThread.start();
    }
}
