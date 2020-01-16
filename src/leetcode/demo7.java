package leetcode;

public class demo7 {

    public static int subReverse(int x) {
        int res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res;
    }

    public static int reverse(int x) {
        int res = subReverse(x);
        String temp = String.valueOf(x).replaceAll("0+$", "");
        if (temp.equals("")) temp = "0";
        x = Integer.parseInt(temp);
        return x == subReverse(subReverse(x)) ? res : 0;
    }


}
