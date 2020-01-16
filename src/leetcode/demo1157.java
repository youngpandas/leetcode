package leetcode;

public class demo1157 {


    class MajorityChecker {

        private int[] arr;

        public MajorityChecker(int[] arr) {
            this.arr = arr;
        }

        public int query(int left, int right, int threshold) {
            int num = arr[left], count = 0;
            for (int i = left; i <= right; i++) {
                if (count == 0) {
                    count = 1;
                    num = arr[i];
                } else {
                    if (num == arr[i]) count++;
                    else count--;
                }
            }
            count = 0;
            for (int i = left; i <= right; i++) if (num == arr[i]) count++;
            return count >= threshold ? num : -1;
        }
    }

}
