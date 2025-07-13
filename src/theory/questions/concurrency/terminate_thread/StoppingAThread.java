package theory.questions.concurrency.terminate_thread;

public class StoppingAThread implements Runnable {
    private volatile boolean running = true;

    @Override
    public void run() {
        while (running) {
            // Perform the task's work
            System.out.println("Task is running...");
            try {
                Thread.sleep(1000); // Simulate work
            } catch (InterruptedException e) {
                // Handle interruption if the thread is blocked (e.g., during sleep)
                Thread.currentThread()
                      .interrupt(); // Restore the interrupted status
                running = false; // Stop the thread
            }
        }
        System.out.println("Task stopped.");
    }

    public void stopTask() {
        running = false;
    }

    public static void main(String[] args)
            throws InterruptedException {
        StoppingAThread task = new StoppingAThread();
        Thread thread = new Thread(task);
        thread.start();

        Thread.sleep(5000); // Let the thread run for 5 seconds
        task.stopTask(); // Signal the thread to stop
    }
}
