package leetcode;

import java.util.Arrays;

public class demo1051 {

    public int heightChecker(int[] heights) {
        int[] temp = heights.clone();
        Arrays.sort(temp);
        int res = 0;
        for (int i = 0; i < temp.length; i++) if (temp[i] != heights[i]) res++;
        return res;
    }

}
