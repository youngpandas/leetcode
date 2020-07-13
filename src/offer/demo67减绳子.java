package offer;

import java.util.Arrays;
import java.util.Scanner;

public class demo67减绳子 {

    public static int cutRope(int target) {
        int[] nums = new int[target + 1];
        nums[1] = 1;
        for (int i = 2; i <= target; i++) {
            int val = i;
            for (int j = 2; j < i; j++) {
                int temp = nums[i - j] * j;
                if (temp > val) val = temp;
            }
            nums[i] = val;
        }
        System.out.println(Arrays.toString(nums));
        return nums[target];
    }

    public static void main(String[] args) {
        System.out.println(cutRope(60));
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        sc.close();
//        System.out.print(cutRope(n));
    }

}
