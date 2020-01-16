package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class demo18 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) continue;
                int aim = target - nums[i] - nums[j];
                int start = j + 1, end = nums.length - 1;
                while (start < end) {
                    int val = nums[start] + nums[end];
                    if (val == aim) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[start]);
                        temp.add(nums[end]);
                        res.add(temp);
                        start++;
                        while (start < end) {
                            if (nums[start] != nums[start - 1]) break;
                            start++;
                        }
                    }
                    if (val < aim) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }

}
