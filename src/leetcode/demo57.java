package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class demo57 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] res = new int[intervals.length + 1][2];
        int i = 0, len = 0;
        for (; i < intervals.length; i++) {
            if (intervals[i][0] >= newInterval[0]) break;
            res[len++] = intervals[i];
        }
        res[len++] = newInterval;
        for (; i < intervals.length; i++) {
            if (intervals[i][1] <= newInterval[1]) continue;
            res[len++] = intervals[i];
        }
        System.out.println(Arrays.deepToString(res));
        for (i = 1; i < len; i++) {
            if (res[i - 1][1] >= res[i][0]) {
                res[i - 1][1] = Math.max(res[i][1], res[i - 1][1]);
                for (int j = i; j < len - 1; j++) {
                    res[j] = res[j + 1];
                }
                i--;
                len--;
            }
        }
        return Arrays.copyOfRange(res, 0, len);
    }


    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new demo57().insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5})));
        System.out.println(Arrays.deepToString(new demo57().insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8})));
        System.out.println(Arrays.deepToString(new demo57().insert(new int[][]{{1, 5}}, new int[]{2, 3})));
    }


}
