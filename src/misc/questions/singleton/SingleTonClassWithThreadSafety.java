package misc.questions.singleton;

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
        SingleTonClass result = instance;
        if (result == null) {
            synchronized (mutex) {
                result = instance;
                if (result == null)
                    instance = result = new SingleTonClass();
            }
        }
        return result;
    }
}