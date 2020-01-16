package leetcode;

public class demo334 {

    public boolean increasingTriplet(int[] nums) {
        int first, second;
        first = second = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > second) return true;
            if (nums[i] > nums[i - 1]) {
                first = nums[i - 1];
                second = nums[i];
                continue;
            }
            if (nums[i] > first && nums[i] < second) second = nums[i];
        }
        return false;
    }

}
