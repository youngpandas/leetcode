package leetcode;

public class demo52 {

    int res = 0;

    public int totalNQueens(int n) {
        int[] nums = new int[n];
        solve(n, 0, nums);
        return res;
    }

    public void solve(int n, int row, int[] nums) {
        if (row == n) {
            res++;
            return;
        }
        for (int i = 0; i < n; i++) {
            int a = i, c = i;
            boolean tag = true;
            for (int j = row - 1; j >= 0; j--) {
                a--;
                c++;
                int e = nums[j];
                if (e != a && e != i && e != c) continue;
                tag = false;
            }
            if (tag) {
                nums[row] = i;
                solve(n, row + 1, nums);
            }
        }
    }

}
