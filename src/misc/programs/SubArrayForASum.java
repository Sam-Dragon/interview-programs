package misc.programs;

import java.util.Scanner;

public class SubArrayForASum {

    public static void main(String[] args) {
        int[] arr;
        arr = new int[]{15, 2, 4, 8, 9, 5, 10, 23};
//      arr = new int[]{1, 4, 0, 0, 3, 10, 5};
//      arr = new int[]{1, 4};

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the sum :: ");

        int sum = sc.nextInt();
        System.out.println("Entered sum :: " + sum);

        System.out.println("Indexes from :: " + subArrayForSum(arr, sum));
    }

    private static String subArrayForSum(int[] arr, int sum) {
        int firstIndex = -1;
        int lastIndex = -1;

        for (int i = 0; i < arr.length; i++) {
            firstIndex = i + 1;
            int accumalated = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                accumalated += arr[j];
                if (accumalated == sum) {
                    lastIndex = j + 1;
                    return firstIndex + " " + lastIndex;
                } else if (accumalated > sum) {
                    break;
                }
            }
        }
        return "-1";
    }
}
