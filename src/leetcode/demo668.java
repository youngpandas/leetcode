package leetcode;

public class demo668 {

    public static int findKthNumber(int m, int n, int k) {
        int low = 1, high = m * n;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (litter(m, n, mid) < k) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }

    public static int litter(int m, int n, int val) {
        int res = 0;
        for (int i = 1; i <= m; i++) {
            int num = val / i;
            res += num < n ? num : n;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findKthNumber(3, 3, 5));
        System.out.println(findKthNumber(2, 3, 6));
        System.out.println(findKthNumber(42, 34, 401));

        System.out.println(litter(42, 34, 127));
    }


}
