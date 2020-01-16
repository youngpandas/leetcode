package leetcode;

public class demo292 {


    public static boolean canWinNim(int n) {
        boolean a = false, b = false, c = false;
        for (int i = 0; i < n; i++) {
            boolean e = !(a && b && c);
            a = b;
            b = c;
            c = e;
            System.out.print((c ? 1 : 0) + " ");
        }
        return c;
    }

    public static void main(String[] args) {
        int n = 100;
        canWinNim(20);
    }

}
