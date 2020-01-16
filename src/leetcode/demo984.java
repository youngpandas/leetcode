package leetcode;

public class demo984 {


    public String strWithout3a3b(int A, int B) {
        char[] res = new char[A + B];
        int len = 0;
        if (A == B) {
            for (int i = 0; i < A; i++) {
                res[len++] = 'a';
                res[len++] = 'b';
            }
            return String.valueOf(res);
        }
        char a = 'a', b = 'b';
        if (A < B) {
            int temp = A;
            A = B;
            B = temp;
            a = 'b';
            b = 'a';
        }

        res[len++] = a;
        A--;
        if (2 * B < A) {
            res[len++] = a;
            A--;
        }
        int count2 = A - B;
        int count1 = B - count2;
        for (int i = 0; i < count1; i++) {
            res[len++] = b;
            res[len++] = a;
        }
        for (int i = 0; i < count2; i++) {
            res[len++] = b;
            res[len++] = a;
            res[len++] = a;
        }
        return String.valueOf(res);
    }

}
