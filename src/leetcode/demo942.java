package leetcode;

public class demo942 {

    public int[] diStringMatch(String S) {
        int[] nums = new int[S.length() + 1];
        char[] chs = S.toCharArray();
        for (int i = 0; i < chs.length; i++) nums[i + 1] = nums[i] + chs[i] == 'I' ? 1 : -1;

        int min = 0;
        for (int e : nums) if (min > e) min = e;
        for (int i = 0; i < nums.length; i++) nums[i] -= min;

        int[] count = new int[nums.length];
        for (int e : nums) count[e]++;

        for (int i = 1; i < count.length; i++) {
            if (count[i] == 0) break;
            count[i] += count[i - 1];
        }

        for (int i = count.length - 1; i > 0; i--) count[i] = count[i - 1];
        count[0] = 0;
        for (int i = 0; i < nums.length; i++) nums[i] = count[nums[i]]++;
        return nums;
    }

}
