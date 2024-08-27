package misc.questions.exception.handling;

public class ExitExecutionInTryCatch {

    public static void main(String[] args) {
        try {
            System.out.println("try Called");
//            Anything after exception code is unreachable
//            throw new Exception();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Catch Called");
            System.exit(1);
        } finally {
            System.out.println("Finally Called");
        }
    }
}
