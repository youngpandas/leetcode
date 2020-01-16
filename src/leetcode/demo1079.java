package leetcode;

import java.util.HashMap;
import java.util.Map;

public class demo1079 {

    Map<Integer, Integer> map = new HashMap<>();

    public int numTilePossibilities(String tiles) {
        Map<Character, Integer> map = new HashMap<>();
        for (char e : tiles.toCharArray()) map.put(e, map.containsKey(e) ? map.get(e) + 1 : 1);
        int[] count = new int[map.size()];
        int len = 0;
        for (int e : map.values()) count[len++] = e;
        return solve(count) - 1;
    }

    public int solve(int[] count) {
        int key = 0;
        for (int e : count) key = key * 7 + e;
        if (map.containsKey(key)) return map.get(key);

        int res = 1;
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) continue;
            count[i]--;
            res += solve(count);
            count[i]++;
        }
        map.put(key, res);
        return res;
    }

}
