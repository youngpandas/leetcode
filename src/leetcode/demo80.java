package leetcode;

public class demo80 {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int p = 0, i = 1, count = 1;
        for (; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) count++;
            else {
                nums[p++] = nums[i - 1];
                if (count > 1) nums[p++] = nums[i - 1];
                count = 1;
            }
        }
        nums[p++] = nums[i - 1];
        if (count > 1) nums[p++] = nums[i - 1];
        return p;
    }

    public static void main(String[] args) {
        System.out.println(new demo80().removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}));
        System.out.println(new demo80().removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));
    }
}
