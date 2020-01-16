package leetcode;

import java.util.ArrayList;
import java.util.List;

public class demo22 {

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        char[] temp = new char[2 * n];
        dfs(0, 0, 0, n, temp, res);
        return res;
    }


    public static void dfs(int start, int left, int right, int n, char[] temp, List<String> res) {
        if (left > n || right > n || right > left) return;
        if (start == temp.length) {
            res.add(new String(temp));
            return;
        }
        temp[start] = '(';
        dfs(start + 1, left + 1, right, n, temp, res);
        temp[start] = ')';
        dfs(start + 1, left, right + 1, n, temp, res);
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
