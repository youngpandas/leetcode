package leetcode;

public class demo59 {

    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int num = 1, i = 0, j = 0, step = n - 1, circle = n / 2;
        if (n % 2 == 1) res[circle][circle] = n * n;
        for (int k = 0; k < circle; i++, j++, k++, step -= 2) {
            for (int l = 0; l < step; l++) res[i][j++] = num++;
            for (int l = 0; l < step; l++) res[i++][j] = num++;
            for (int l = 0; l < step; l++) res[i][j--] = num++;
            for (int l = 0; l < step; l++) res[i--][j] = num++;
        }
        for (int[] a : res) {
            for (int e : a) {
                System.out.print("\t" + e);
            }
            System.out.println();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(generateMatrix(3));
    }

}
