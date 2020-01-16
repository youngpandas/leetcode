package leetcode;

public class demo5 {
    //todo
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len == 0) return s;
        String reverse = new StringBuffer(s).reverse().toString();
        int[][] matrix = new int[len][len];
        for (int i = 0; i < len; i++) matrix[i][0] = s.charAt(i) == reverse.charAt(0) ? 1 : 0;
        for (int j = 0; j < len; j++) matrix[0][j] = s.charAt(0) == reverse.charAt(j) ? 1 : 0;
        for (int i = 1; i < len; i++) {
            for (int j = 1; j < len; j++) {
                matrix[i][j] = s.charAt(i) == reverse.charAt(j) ? 1 + matrix[i - 1][j - 1] : 0;
            }
        }
        int x = 0, v = matrix[0][0];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (v < matrix[i][j]) {
                    v = matrix[i][j];
                    x = i;
                }
            }
        }
        x++;
        return s.substring(x - v, x);
    }

    public static void main(String[] args) {
        System.out.println(new demo5().longestPalindrome("babad"));
        System.out.println(new demo5().longestPalindrome("abcda"));
    }

}
