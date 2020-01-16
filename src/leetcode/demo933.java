package leetcode;

public class demo933 {

    class RecentCounter {

        private int[] nums;
        private int len, low;

        public RecentCounter() {
            nums = new int[10000];
            len = low = 0;
        }

        public int ping(int t) {
            int high = len, val = t - 3000;
            nums[len++] = t;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (nums[mid] == val) {
                    low = mid;
                    break;
                }
                if (nums[mid] > val) high = mid - 1;
                else low = mid + 1;
            }
            return len - low;
        }

    }

    class RecentCounter1 {

        private int[] nums;
        private int len, low;

        public RecentCounter1() {
            nums = new int[3001];
            len = low = 0;
        }

        public int ping(int t) {
            int high = len, val = t - 3000;
            nums[len++] = t;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (nums[mid] == val) {
                    low = mid;
                    break;
                }
                if (nums[mid] > val) high = mid - 1;
                else low = mid + 1;
            }
            return len - low;
        }

    }

}
