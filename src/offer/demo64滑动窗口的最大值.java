package offer;

import java.util.ArrayList;

public class demo64滑动窗口的最大值 {

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (size <= 0) return res;
        for (int i = size; i <= num.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i - size; j < i; j++) if (max < num[j]) max = num[j];
            res.add(max);
        }
        return res;
    }

}
