package misc.questions.concurrency;

public class ObjectMethodLevelLock {

    public static void main(String[] args) {
        MethodLock lockObj = new MethodLock();
        for (int i = 15; i < 20; i++) {
            Thread thread = new Thread(lockObj::lock);
            thread.setName("Thread - " + i);
            thread.start();
        }
    }
}


class MethodLock implements Runnable {

    @Override
    public void run() {
        lock();
    }

    public synchronized void lock() {
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