package leetcode;

public class demo29 {


    //Todo
    //超时
    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (dividend == 0) return 0;
        int res = 0;
        int factor = (dividend > 0 == divisor > 0) ? 1 : -1;
        divisor = factor * divisor;
        if (dividend > 0) {
            while (dividend >= divisor) {
                dividend -= divisor;
                res += factor;
            }
        } else {
            while (dividend <= divisor) {
                dividend -= divisor;
                res += factor;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(divide(10, 3));
        System.out.println(divide(7, -3));
        System.out.println(divide(-1, 1));
    }

}
