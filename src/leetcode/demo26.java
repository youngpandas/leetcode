package leetcode;

public class demo26 {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int len = 1;
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int e = nums[i];
            if (e != pre) {
                nums[len++] = e;
            }
            pre = e;
        }
        return len;
    }

}
