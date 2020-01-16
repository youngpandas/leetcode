package leetcode;

import java.util.ArrayList;
import java.util.List;

public class demo77 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, n, k, new boolean[n + 1], new ArrayList<>(), res);
        return res;
    }

    public void dfs(int cur, int n, int k, boolean[] tags, List<Integer> temp, List<List<Integer>> res) {
        if (k == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        int max = n - k + 1;
        for (int i = cur + 1; i <= max; i++) {
            temp.add(i);
            tags[i] = true;
            dfs(i, n, k - 1, tags, temp, res);
            tags[i] = false;
            temp.remove(temp.size() - 1);
        }
    }

}

