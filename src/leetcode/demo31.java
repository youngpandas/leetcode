package leetcode;

public class demo31 {

    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if (len == 0) return;
        int i = len - 2;
        for (; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) break;
        }
        for (int j = i + 1, k = len - 1; j < k; j++, k--) {
            int temp = nums[j];
            nums[j] = nums[k];
            nums[k] = temp;
        }
        if (i == -1) return;
        for (int j = i + 1; j < len; j++) {
            if (nums[j] > nums[i]) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                break;
            }
        }
    }

}
