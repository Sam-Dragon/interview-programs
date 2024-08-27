package misc.programs.concurrency;

public class TwoThreadsPrintingNumbersOneAfterAnother {

    public static void main(String[] args) throws InterruptedException {

        for (int i = 1; i <= 10; i++) {
            int finalI = i;
            Thread first = new Thread(() -> {
                if (finalI <= 5)
                    System.out.println(Thread.currentThread()
                        .getName() + " - " + finalI);
            });
            first.setName("first");
            first.start();
            first.join();

            Thread second = new Thread(() -> {
                if (finalI > 5)
                    System.out.println(Thread.currentThread()
                        .getName() + " - " + finalI);
            });
            second.setName("second");
            second.start();
            second.join();
        }
    }
}
