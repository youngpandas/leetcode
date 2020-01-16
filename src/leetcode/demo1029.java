package leetcode;


import java.util.Arrays;

public class demo1029 {

    public int twoCitySchedCost(int[][] costs) {
        int res = 0, len = costs.length;
        int[] costA = new int[len], costB = new int[len];
        int lenA = 0, lenB = 0;
        for (int[] e : costs) {
            int a = e[0], b = e[1];
            if (a > b) {
                res += b;
                costA[lenA++] = a - b;
            } else {
                res += a;
                costB[lenB++] = b - a;
            }
        }
        len /= 2;
        if (lenA > len) {
            Arrays.sort(costA, 0, lenA);
            for (int i = 0; i < lenA - len; i++) res += costA[i];
        } else {
            Arrays.sort(costB, 0, lenB);
            for (int i = 0; i < lenB - len; i++) res += costB[i];
        }
        return res;
    }

}
