package leetcode;

public class demo27 {

    public int removeElement(int[] nums, int val) {
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) continue;
            nums[len++] = nums[i];
        }
        return len;
    }

}
