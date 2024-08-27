package misc.questions.exception.handling;

public class OutOfMemoryErrorExample {
    public static void main(String[] args) {
        Integer[] myArray = new Integer[1000 * 1000 * 1000 * 100];
    }
}
