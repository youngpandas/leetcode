package leetcode;

public class demo45 {

    public int jump(int[] nums) {
        int len = nums.length;
        int[] s = new int[len];
        for (int i = len - 2; i >= 0; i--) {
            int min = len;
            for (int j = i + 1; j <= i + nums[i] && j < len; j++) {
                if (min > s[j]) min = s[j] - 1;
                j += nums[j];
            }
            s[i] = min + 1;
        }
        return s[0];
    }

}
