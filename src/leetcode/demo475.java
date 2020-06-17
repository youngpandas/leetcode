package leetcode;

import java.util.Arrays;
import java.util.Map;

public class demo475 {

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        if (houses.length == 0) return 0;
        if (heaters.length == 0) return Integer.MAX_VALUE;
        int len = 0;
        if (heaters[0] > houses[0]) {
            int val = heaters[0] - houses[0];
            if (len < val) len = val;
        }
        if (heaters[heaters.length - 1] > houses[houses.length - 1]) {
            int val = heaters[heaters.length - 1] - houses[houses.length - 1];
            if (len < val) len = val;
        }
        for (int i = 1; i < heaters.length; i++) {

        }
        return 0;
        //todo
    }

}
