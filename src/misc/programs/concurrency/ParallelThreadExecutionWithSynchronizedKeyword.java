package misc.programs.concurrency;

public class ParallelThreadExecutionWithSynchronizedKeyword {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();

        for (int i = 0; i < 10; i++) {
            Thread threadA = new Thread(a::print);
            threadA.setName("threadA");
            threadA.start();

            Thread threadB = new Thread(b::print);
            threadB.setName("threadB");
            threadB.start();
        }
    }
}

class A {
    final String strName1 = "velankani";

    public void print() {
        synchronized (strName1) {
            System.out.println(A.class.getName() + " :: " + Thread.currentThread()
                .getName() + " - synchronized for str :: " + strName1);
        }
    }
}

class B {
    final String strName = "velankani";

    public void print() {
        synchronized (strName) {
            System.out.println(B.class.getName() + " :: " + Thread.currentThread()
                .getName() + " - synchronized for str :: " + strName);
        }
    }
}
