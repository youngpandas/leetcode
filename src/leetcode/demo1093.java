package leetcode;

public class demo1093 {

    public double[] sampleStats(int[] count) {
        int low = 0, high = count.length - 1, tol = 0;
        for (; low <= high; low++) if (count[low] != 0) break;
        for (; high >= 0; high--) if (count[high] != 0) break;
        long sum = 0;
        for (int i = low; i <= high; i++) {
            sum += i * count[i];
            tol += count[i];
        }
        double avg = (double) sum / tol, mid = 0;
        int max = low, aim = (tol + 1) / 2, cur = 0;
        for (int i = low; i <= high; i++) if (count[max] < count[i]) max = i;
        for (int i = low; i <= high; i++) {
            cur += count[i];
            if (cur >= aim) {
                mid = i;
                if (cur == aim && tol % 2 == 0) {
                    i++;
                    for (; i <= high; i++) {
                        if (count[i] != 0) {
                            mid = (mid + i) / 2;
                            break;
                        }
                    }
                }
                break;
            }
        }
        return new double[]{low, high, avg, mid, max};
    }
}
