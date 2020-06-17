package leetcode;

public class demo115 {

    int res = 0;

    public int numDistinct(String s, String t) {
        dfs(s.toCharArray(), t.toCharArray(), 0, 0);
        return res;
    }

    public void dfs(char[] s, char[] t, int sp, int tp) {
        if (t.length == tp) {
            res++;
            return;
        }
        for (int i = sp; i < s.length; i++) {
            if (s[i] == t[tp]) {
                dfs(s, t, i + 1, tp + 1);
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(new demo115().numDistinct("rabbbit", "rabbit"));
    }
}
