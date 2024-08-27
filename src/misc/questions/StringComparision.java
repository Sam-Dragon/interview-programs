package misc.questions;

public class StringComparision {

    public static void main(String[] args) {
        String str = "Hello";
        String str2 = new String("Hello");

        System.out.println(str == str2);
        System.out.println(str.equals(str2));

        str2.intern();
        System.out.println(str == str2);
    }
}
