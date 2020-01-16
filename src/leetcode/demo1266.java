package leetcode;

public class demo1266 {

    public int minTimeToVisitAllPoints(int[][] points) {
        int res = 0;
        int[] pre = points[0];
        for (int[] cur : points) {
            int x = pre[0] - cur[0];
            int y = pre[1] - cur[1];
            if (x < 0) x = -x;
            if (y < 0) y = -y;
            res += x > y ? x : y;
            pre = cur;
        }
        return res;
    }

}
