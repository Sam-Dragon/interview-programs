package misc.questions.concurrency;

public class ClassMethodLevelLock {

    public static void main(String[] args) {
        for (int i = 5; i < 10; i++) {
            Thread thread = new Thread(StaticMethodLock::lock);
            thread.setName("Thread - " + i);
            thread.start();
        }
    }
}


class StaticMethodLock implements Runnable {

    @Override
    public void run() {
        lock();
    }

    public static synchronized void lock() {
        try {
            System.out.println();
            System.out.println("Start Lock acquired by :: " + Thread.currentThread()
                .getName());
            System.out.println("Do some work for 3 secs :: " + Thread.currentThread()
                .getName());
            Thread.sleep(3000);
            System.out.println("Released Lock acquired by :: " + Thread.currentThread()
                .getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}