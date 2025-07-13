package theory.questions.concurrency.thread_communication;

class SharedResource {
    private String packet;
    private boolean transfer = false;

    public synchronized String receive() {
        System.out.println("Receiver >> transfer :: " + transfer + ", packet :: " + packet);
        while (transfer) {
            try {
                System.out.println("Receiver >> waiting started");
                wait();
                System.out.println("Receiver >> waiting over");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        transfer = true;
        String returnPacket = packet;
        notify();
        System.out.println("Receiver Completed >> transfer :: " + transfer + ", packet :: " + packet);
        return returnPacket;
    }

    public synchronized void send(String packet) {
        System.out.println("Sender >> transfer :: " + transfer + ", packet :: " + packet);
        while (!transfer) {
            try {
                System.out.println("Sender >> waiting started");
                wait();
                System.out.println("Sender >> waiting over");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        transfer = false;
        this.packet = packet;
        notify();
        System.out.println("Sender Completed >> transfer :: " + transfer + ", packet :: " + packet);
    }
}

class Sender implements Runnable {
    private final SharedResource data;

    public Sender(SharedResource data) {
        this.data = data;
    }

    // standard constructors
    public void run() {
        String packets[] = {
                "First packet",
                "Second packet",
                "Third packet",
                "Fourth packet",
                "End"
        };

        for (String packet : packets) {
            System.out.println("\npacket :: " + packet);
            data.send(packet);

            // Thread.sleep() to mimic heavy server-side processing
//            try {
//                Thread.sleep(ThreadLocalRandom.current()
//                                              .nextInt(1000, 5000));
//            } catch (InterruptedException e) {
//                Thread.currentThread()
//                      .interrupt();
//                System.err.println("Thread Interrupted");
//            }
        }
    }
}

class Receiver implements Runnable {
    private final SharedResource load;

    public Receiver(SharedResource data) {
        this.load = data;
    }

    public void run() {
        for (String receivedMessage = load.receive();
             !"End".equals(receivedMessage);
             receivedMessage = load.receive()) {

            System.out.println("Received Message :: " + receivedMessage);

            //Thread.sleep() to mimic heavy server-side processing
//            try {
//                Thread.sleep(ThreadLocalRandom.current()
//                                              .nextInt(1000, 5000));
//            } catch (InterruptedException e) {
//                Thread.currentThread()
//                      .interrupt();
//                System.err.println("Thread Interrupted");
//            }
        }
    }
}

public class ThreadCommunication {

    public static void main(String[] args) {
        SharedResource data = new SharedResource();
        Thread sender = new Thread(new Sender(data));
        Thread receiver = new Thread(new Receiver(data));

        sender.start();
        receiver.start();
    }
}
