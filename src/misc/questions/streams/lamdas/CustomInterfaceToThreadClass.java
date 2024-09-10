package misc.questions.streams.lamdas;

public class CustomInterfaceToThreadClass {

    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println(
                Thread.currentThread().getName() + " :: Runnable Lamda");
        Thread runnableThread = new Thread(runnable);
        runnableThread.setName("Runnable Thread");
        runnableThread.start();

        /* Error: Thread class only accepts Runnable/Callable interface
         *  But you can pass direct lamda expression */
//        MyFunctionInterface myFunctionInterface = () -> System.out.println("MyFunctionInterface");
//        Thread myFunctionInterfaceThread = new Thread(myFunctionInterface);
//        myFunctionInterfaceThread.start();

        Thread myFunctionInterfaceThread = new Thread(() -> System.out.println(
                Thread.currentThread().getName() + " :: Custom Lamda"));
        myFunctionInterfaceThread.setName("My Function Interface Thread");
        myFunctionInterfaceThread.start();
    }
}

@FunctionalInterface
interface MyFunctionInterface {
    void jump();
}