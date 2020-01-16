package leetcode;

public class demo4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i1 = 0, i2 = 0, len = 0;
        int[] nums = new int[nums1.length + nums2.length];
        while (i1 < nums1.length && i2 < nums2.length) nums[len++] = nums1[i1] < nums2[i2] ? nums1[i1++] : nums2[i2++];
        while (i1 < nums1.length) nums[len++] = nums1[i1++];
        while (i2 < nums2.length) nums[len++] = nums2[i2++];
        return len % 2 == 0 ? (double) (nums[len / 2] + nums[len / 2 - 1]) / 2 : nums[len / 2];
    }

    public static void main(String[] args) {
        System.out.println(new demo4().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }

}
