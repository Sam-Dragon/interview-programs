package interview.programs.java_7.arrays.merge;

import java.util.Arrays;

public class MergeSortedArrays {

    public static void main(String[] args) {
        int[] firstArr = {0, 3, 4, 31};
        int[] secondArr = {4, 6, 30};

        MergeSortedArrays obj = new MergeSortedArrays();

        System.out.println("\nMerge using forLoops()");
//        obj.mergeUsingForLoops(firstArr, secondArr);

        System.out.println("\nMerge using Array Copy And Sort()");
        obj.mergeUsingArraysCopyAndSort(firstArr, secondArr);

        System.out.println("\nMerge using whileLoop");
        obj.mergeArrays(firstArr, secondArr);
    }

    private void mergeUsingArraysCopyAndSort(int[] firstArr, int[] secondArr) {
        int length = firstArr.length + secondArr.length;
        int[] sortedArray = new int[length];

        // Copy all elements into the new array
        System.arraycopy(firstArr, 0, sortedArray, 0, firstArr.length);
        System.arraycopy(secondArr, 0, sortedArray, firstArr.length, secondArr.length);

        // Sort the combined array
        Arrays.sort(sortedArray);

        Arrays.stream(sortedArray).forEach(System.out::println);
    }

    private void mergeUsingForLoops(int[] firstArr, int[] secondArr) {
        int length = firstArr.length + secondArr.length;
        int[] sortedArray = new int[length];


        for (int i = 0; i < firstArr.length; i++) {
            sortedArray[i] = firstArr[i];
        }

        int firstArrLength = firstArr.length;
        for (int i = 0; i < secondArr.length; i++) {
            sortedArray[firstArrLength++] = secondArr[i];
        }

        for (int i = 0; i < sortedArray.length - 1; i++) {
            if (sortedArray[i] > sortedArray[i + 1]) {
                int temp = sortedArray[i];
                sortedArray[i] = sortedArray[i + 1];
                sortedArray[i + 1] = temp;
            }
        }

        Arrays.stream(sortedArray).forEach(System.out::println);
    }

    public int[] mergeArrays(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] arr3 = new int[n1 + n2]; // Result array of combined size

        int i = 0, j = 0, k = 0; // Pointers for arr1, arr2, and arr3

        // Traverse both arrays and insert the smaller element into arr3
        while (i < n1 && j < n2) {
            System.out.println(i + " -- " + j);
            if (arr1[i] < arr2[j]) {
                arr3[k++] = arr1[i++];
            } else {
                arr3[k++] = arr2[j++];
            }
            Arrays.stream(arr3).forEach(System.out::println);
        }
//        Arrays.stream(arr3).forEach(System.out::println);

        // Copy any remaining elements of arr1
        while (i < n1) {
            arr3[k++] = arr1[i++];
        }

        // Copy any remaining elements of arr2
        while (j < n2) {
            arr3[k++] = arr2[j++];
        }

        return arr3;
    }
}
