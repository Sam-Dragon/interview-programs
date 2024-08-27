package misc.programs.concurrency;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class PrintOddEvenSumWithThreads {
    AtomicInteger sum = new AtomicInteger(0);
    CopyOnWriteArrayList<Integer> evenNumbers = new CopyOnWriteArrayList<>();
    CopyOnWriteArrayList<Integer> oddNumbers = new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        PrintOddEvenSumWithThreads threads = new PrintOddEvenSumWithThreads();
        int[] arr = {10, 24, 63, 51, 56, 22};

        for (int i = 0; i < arr.length; i++) {
            int number = arr[i];

            Thread evenThread = new Thread(() -> threads.printEven(number));
            evenThread.setName("Even-Thread");
            evenThread.start();

            evenThread.join();

            Thread oddThread = new Thread(() -> threads.printOdd(number));
            oddThread.setName("Odd-Thread");
            oddThread.start();

            oddThread.join();

            Thread sumThread = new Thread(() -> threads.printSum(number));
            sumThread.setName("Sum Thread - ");
            sumThread.start();

            sumThread.join();
        }

        System.out.println("Even Numbers :: " + threads.evenNumbers);
        System.out.println("Odd Numbers :: " + threads.oddNumbers);
        System.out.println("Sum = " + threads.sum);
    }

    public synchronized void printOdd(int number) {
        if (number % 2 != 0) {
            oddNumbers.add(number);
        }
    }

    public synchronized void printEven(int number) {
        if (number % 2 == 0) {
            evenNumbers.add(number);
        }
    }

    public synchronized void printSum(int number) {
        sum.addAndGet(number);
    }
}
