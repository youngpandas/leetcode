package leetcode;

import java.util.ArrayList;
import java.util.List;

public class demo216 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        boolean[] tags = new boolean[10];
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(k, n, 0, tags, temp, res);
        return res;
    }

    public void dfs(int k, int n, int start, boolean[] tags, List<Integer> temp, List<List<Integer>> res) {
        if (n < 0) return;
        if (k == 0) {
            if (n == 0) res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start + 1; i < 10; i++) {
            if (tags[i]) continue;
            tags[i] = true;
            temp.add(i);
            dfs(k - 1, n - i, i, tags, temp, res);
            temp.remove(temp.size() - 1);
            tags[i] = false;
        }
    }


}
