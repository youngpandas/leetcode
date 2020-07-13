package zhongxing;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class demo3 {

    public static Map<String, Integer> map = new HashMap<>();

    public static int solve(int key) {
        if (key == 4) return 2;
        if (key < 4) return key;
        int[] nums = new int[20];
        int len = 0;
        while (key != 0) {
            nums[len++] = key % 5;
            key /= 5;
        }
        nums = Arrays.copyOfRange(nums, 0, len + 1);
        return dfs(nums);
    }

    public static int dfs(int[] nums) {
        String k = Arrays.toString(nums);
        if (map.containsKey(k)) return map.get(k);
        if (nums.length == 0) return 0;
        if (nums.length == 1) {
            if (nums[0] <= 3) return nums[0];
            return 2;
        }

        int[] list = Arrays.copyOfRange(nums, 1, nums.length);
        int res1 = nums[0] + dfs(list);
        for (int i = 0; i < list.length; i++) {
            list[i]++;
            if (list[i] != 5) break;
            list[i] = 0;
        }
        int res2 = 5 - nums[0] + dfs(list);
        int res = res1 > res2 ? res2 : res1;
        map.put(k, res);
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int key = sc.nextInt();
        sc.close();
        System.out.println(solve(key));
    }

}
