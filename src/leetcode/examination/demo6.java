package leetcode.examination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class demo6 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            int target = -nums[i];
            int p = i + 1, q = nums.length - 1;
            while (p < q) {
                int val = nums[p] + nums[q];
                if (val < target) p++;
                else if (val > target) q--;
                else {
                    res.add(Arrays.asList(nums[i], nums[p], nums[q]));
                    val = nums[p];
                    while (p < q && nums[p] == val) p++;
                    val = nums[q];
                    while (p < q && nums[q] == val) q--;
                }
            }
        }
        return res;
    }

}
