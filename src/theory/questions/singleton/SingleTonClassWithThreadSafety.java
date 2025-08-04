package theory.questions.singleton;

public final class SingleTonClassWithThreadSafety {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(SingleTonClassWithThreadSafety::callThreadMethod);
            thread.start();
        }
    }

    private static void callThreadMethod() {
        System.out.println(Thread.currentThread()
                                 .getName() + " - " + SingleTonClass.getInstance()
                                                                    .hashCode());
    }
}

class SingleTonClass {
    private static final Object mutex = new Object();
    private static volatile SingleTonClass instance;

    private SingleTonClass() {
    }

    public static SingleTonClass getInstance() {
        if (instance == null) {
            synchronized (mutex) {
                if (instance == null)
                    instance = new SingleTonClass();
            }
        }
        return instance;
    }
}