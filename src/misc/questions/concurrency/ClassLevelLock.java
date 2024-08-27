package misc.questions.concurrency;

public class ClassLevelLock {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(ClassLock::lock);
            thread.setName("Thread - " + i);
            thread.start();
        }
    }
}

class ClassLock implements Runnable {

    public void run() {
        lock();
    }

    public static void lock() {
        synchronized (ClassLock.class) {
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
}