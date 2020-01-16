package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class demo15 {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) return res;
        Arrays.sort(nums);
        for (int k = 0; k < nums.length; k++) {
            if (k != 0 && nums[k] == nums[k - 1]) continue;
            int aim = -nums[k];
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int val = nums[i] + nums[j];
                if (val == aim) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[k]);
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    res.add(temp);
                    while (i < j) {
                        i++;
                        if (nums[i] != nums[i - 1]) break;
                    }
                } else if (val < aim) i++;
                else j--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{0, 0, 0, 0}));
    }

}
