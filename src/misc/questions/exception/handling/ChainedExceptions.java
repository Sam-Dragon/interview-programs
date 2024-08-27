package misc.questions.exception.handling;

public class ChainedExceptions {

    public static void main(String[] args) {
        new ChainedExceptions().handleException();
    }

    public void handleException() {
        try {
            method();
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException");
            throw new InvalidRuntimeTimeException("Custom Exception");
        } catch (Exception e) {
            System.out.println("Exception");
            System.out.println("Exception: " + e);
        }
    }

    public void method() {
        System.out.println("Start Method");
        System.out.println(1 / 0);
        System.out.println("End Method");
    }
}
