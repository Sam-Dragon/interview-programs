package interview.programs.java_8_and_above.numbers.two_sum;

import java.util.Arrays;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 11, 7, 15};
        int target = 9;

        TwoSum ts = new TwoSum();
        System.out.println(Arrays.toString(Arrays.stream(ts.twoSum(nums, target))
                .toArray()));
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < target) {
                System.out.println(i + " " + nums[i]);
                int difference = target - nums[i];
                int second = Arrays.binarySearch(nums, difference);
                System.out.println(difference + "," + second);
                if (second > 0) {
                    result[0] = i;
                    result[1] = second;
                }
            }
        }

        return result;
    }
}
