package leetcode;

import java.util.Arrays;

public class demo561 {

    public int arrayPairSum(int[] nums) {
        int[] hash = new int[20001];
        for (int e : nums) hash[e + 10000]++;
        boolean tag = false;
        int res = 0;
        for (int i = 0; i < 20001; i++) {
            if (hash[i] == 0) continue;
            res += (hash[i] + (tag ? 0 : 1)) / 2 * (i - 10000);
            if (hash[i] % 2 == 1) tag = !tag;
        }
        return res;
    }

}
