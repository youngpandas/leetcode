package leetcode;

import java.util.Arrays;

public class demo1014 {

    public int maxScoreSightseeingPair(int[] A) {
        int len = A.length;
        int[] temp1 = new int[len];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int val = A[i] + i;
            if (max < val) max = val;
            temp1[i] = max;
        }

        int[] temp2 = new int[len];
        max = Integer.MIN_VALUE;
        for (int i = len - 1; i >= 0; i--) {
            temp2[i] = max;
            int val = A[i] - i;
            if (max < val) max = val;
        }
        max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int val = temp1[i] + temp2[i];
            if (max < val) max = val;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new demo1014().maxScoreSightseeingPair(new int[]{8, 1, 5, 2, 6}));
    }

}
