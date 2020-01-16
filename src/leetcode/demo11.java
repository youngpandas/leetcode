package leetcode;

public class demo11 {

    public int maxArea(int[] height) {
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int val = Math.min(height[i], height[j]) * (j - i);
                if (res < val) res = val;
            }
        }
        return res;
    }

}
