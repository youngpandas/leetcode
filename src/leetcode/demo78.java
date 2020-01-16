package leetcode;

import java.util.ArrayList;
import java.util.List;

public class demo78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        solve(0, nums, new ArrayList<>(), res);
        return res;
    }

    public void solve(int step, int[] nums, List<Integer> temp, List<List<Integer>> res) {
        if (step == nums.length) {
            res.add(temp);
            return;
        }
        solve(step + 1, nums, temp, res);
        List<Integer> copy = new ArrayList<>(temp);
        copy.add(nums[step]);
        solve(step + 1, nums, copy, res);
    }

}
