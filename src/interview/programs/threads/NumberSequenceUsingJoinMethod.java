package interview.programs.threads;

import java.util.Scanner;

class NumberThread extends Thread {
    private final int item;

    public NumberThread(int item) {
        this.item = item;
    }

    @Override
    public void run() {
        System.out.println(this.item);
    }
}

// Print Numbers from 1 to 10
public class NumberSequenceUsingJoinMethod {

    public static void main(String[] args)
            throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number for Threads to execute");
        int number = sc.nextInt();
        System.out.println("Numbers to be printed upto " + number);

        for (int i = 1; i <= number; i++) {
            NumberThread thread = new NumberThread(i);
            thread.start();

            // If you don't use thread.join, the output of numbers is unpredictable
            thread.join();
        }
    }
}
