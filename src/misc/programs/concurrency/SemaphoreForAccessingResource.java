package misc.programs.concurrency;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class SemaphoreForAccessingResource {

    public static void main(String[] args) {
        SemaphoreForAccessingResource resource = new SemaphoreForAccessingResource();
        Semaphore semaphore = new Semaphore(2);

        Random random = new Random();
        int min = 1;
        int max = 5;
        for (int i = 0; i < 5; i++) {
            int sleep = random.nextInt(max - min + 1) + min;
            Thread thread = new Thread(() -> resource.sharedResource(semaphore, sleep));
            thread.setName("Thread - " + i);
            thread.start();
        }
    }

    public void sharedResource(Semaphore semaphore, int sleep) {
        try {
            semaphore.acquire(1);
            System.out.println("Acquired by : " + Thread.currentThread()
                .getName());
            long secs = sleep * 1000L;
            System.out.println("Do some work for " + secs + " secs :: " + Thread.currentThread()
                .getName());
            Thread.sleep(secs);
            System.out.println("Released by : " + Thread.currentThread()
                .getName());
            semaphore.release(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
