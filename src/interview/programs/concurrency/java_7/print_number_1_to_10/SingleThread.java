package interview.programs.concurrency.java_7.print_number_1_to_10;

class MyThread extends Thread {
    int limit;

    public MyThread(int limit) {
        this.limit = limit;
    }

    @Override
    public void run() {
        for (int i = 1; i <= limit; i++) {
            System.out.println(Thread.currentThread()
                                     .getName() + " -> " + i);
        }
    }
}

public class SingleThread {

    public static void main(String[] args) {
        int count = 10;
        System.out.println("Running in Thread :: " + Thread.currentThread()
                                                           .getName());
        MyThread thread = new MyThread(count);
        thread.setName("custom-thread");
        thread.start();
    }
}
