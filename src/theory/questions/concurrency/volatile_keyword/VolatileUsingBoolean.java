package theory.questions.concurrency.volatile_keyword;

class SharedData {
    volatile boolean running = true;
}

class StartThread extends Thread {
    SharedData sharedData;

    public StartThread(SharedData running) {
        this.sharedData = running;
    }

    @Override
    public void run() {
        var sequencer = 1;
        System.out.println("Started By Thread :: " + Thread.currentThread()
                                                           .getName());
        while (this.sharedData.running) {
            System.out.println("Run - " + sequencer++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class StopThread extends Thread {
    volatile SharedData sharedData;

    public StopThread(SharedData running) {
        this.sharedData = running;
    }

    @Override
    public void run() {
        System.out.println("Stopped By Thread :: " + Thread.currentThread()
                                                           .getName());
        this.sharedData.running = false;
    }
}

public class VolatileUsingBoolean {

    public static void main(String[] args)
            throws InterruptedException {
        SharedData data = new SharedData();

        StartThread startThread = new StartThread(data);
        startThread.setName("Start Thread");
        startThread.start();

        Thread.sleep(5000);

        StopThread stopThread = new StopThread(data);
        stopThread.setName("Stop Thread");
        stopThread.start();
    }
}
