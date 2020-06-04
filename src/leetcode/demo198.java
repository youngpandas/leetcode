package leetcode;

import java.util.HashMap;
import java.util.Map;

public class demo198 {

    Map<Integer, Integer> map = new HashMap<>();

    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int res1 = solve(nums, 0);
        int res2 = solve(nums, 1);
        return res1 > res2 ? res1 : res2;
    }

    public int solve(int[] nums, int start) {
        if (map.containsKey(start)) return map.get(start);
        if (start >= nums.length) return 0;
        int res1 = solve(nums, start + 2);
        int res2 = solve(nums, start + 3);
        int res = (res1 > res2 ? res1 : res2) + nums[start];
        map.put(start, res);
        return res;
    }

    public int rob1(int[] nums) {
        int a, b, c;
        a = b = c = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int max = a > b ? a : b;
            nums[i] += max;
            a = b;
            b = c;
            c = nums[i];
        }
        int res = 0;
        for (int i = len - 1; i >= 0; i--) if (res < nums[i]) res = nums[i];
        return res;
    }

    public static void main(String[] args) {
        int[] data = new int[]{2, 7, 9, 3, 1};
        System.out.println(new demo198().rob(data));
    }

}
