package misc.programs.concurrency;

import java.util.function.Predicate;

public class PrintEvenOddNumbersUsingTwoThreads {

    volatile int number = 1;
    int limit;

    public PrintEvenOddNumbersUsingTwoThreads(int limit) {
        this.limit = limit;
    }

    synchronized void printNumbers(Predicate<Integer> condition) {
        while (number <= limit)
            if (condition.test(number)) {
                System.out.println(Thread.currentThread()
                    .getName() + " --> " + number);
                number++;
                notify();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
    }

    synchronized void printOddNumbers() {
        while (number <= limit)
            if (number % 2 != 0) {
                System.out.println("Odd > " + Thread.currentThread()
                    .getName() + " --> " + number);
                number++;
                notify();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
    }

    synchronized void printEvenNumbers() {
        while (number <= limit)
            if (number % 2 == 0) {
                System.out.println("Even > " + Thread.currentThread()
                    .getName() + " --> " + number);
                number++;
                notify();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
    }

    public static void main(String[] args) throws InterruptedException {
        PrintEvenOddNumbersUsingTwoThreads object = new PrintEvenOddNumbersUsingTwoThreads(10);

//        Thread threadA = new Thread(object::printOddNumbers);
//        threadA.setName("Odd Thread");
//        threadA.start();
//
//        Thread threadB = new Thread(object::printEvenNumbers);
//        threadB.setName("Even Thread");
//        threadB.start();

        Thread threadA = new Thread(() -> object.printNumbers(number -> number % 2 != 0));
        threadA.setName("Odd Thread");
        threadA.start();

        Thread threadB = new Thread(() -> object.printNumbers(number -> number % 2 == 0));
        threadB.setName("Even Thread");
        threadB.start();
    }
}
