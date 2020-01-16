package leetcode;

public class demo977 {

    public int[] sortedSquares(int[] A) {
        int i = 0, len = A.length;
        for (; i < len; i++) if (A[i] >= 0) break;
        int[] res = new int[len];
        int j = i - 1, idx = 0;
        while (i < len && j >= 0) res[idx++] = A[A[i] + A[j] < 0 ? i++ : j--];
        while (i < len) res[idx++] = A[i++];
        while (j >= 0) res[idx++] = A[j--];
        for (i = 0; i < len; i++) res[i] = res[i] * res[i];
        return res;
    }

}
