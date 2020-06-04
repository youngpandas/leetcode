package leetcode;

public class demo238 {

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] pre = new int[len];
        int[] post = new int[len];
        int val = 1;
        for (int i = 0; i < len; i++) {
            pre[i] = val;
            val *= nums[i];
        }
        val = 1;
        for (int i = len - 1; i >= 0; i--) {
            post[i] = val;
            val *= nums[i];
        }
        for (int i = 0; i < len; i++) {
            nums[i] = pre[i] * post[i];
        }
        return nums;
    }

}
