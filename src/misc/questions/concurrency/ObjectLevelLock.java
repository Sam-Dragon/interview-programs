package misc.questions.concurrency;

public class ObjectLevelLock {

    public static void main(String[] args) {
        ObjectLock objectLock = new ObjectLock();
        for (int i = 10; i < 15; i++) {
            Thread thread = new Thread(objectLock::lock);
            thread.setName("Thread - " + i);
            thread.start();
        }
    }
}

class ObjectLock implements Runnable {

    @Override
    public void run() {
        lock();
    }

    public void lock() {
        synchronized (this) {
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