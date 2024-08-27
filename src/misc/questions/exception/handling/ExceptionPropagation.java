package misc.questions.exception.handling;

public class ExceptionPropagation {

    public static void main(String[] args) {
        methodA();
    }

    static void methodA() {
        try {
            System.out.println("Start MethodA");
            methodB();
        } catch (Exception e) {
            System.out.println("Exception in MethodA :: " + e.getMessage());
        }
        System.out.println("End MethodA");
    }

    static void methodB() {
        System.out.println("Start MethodB");
        methodC();
        System.out.println("End MethodB");
    }

    static void methodC() {
        System.out.println("Start MethodC");
        throw new InvalidRuntimeTimeException("Exception Propagation from C to A");
    }
}
