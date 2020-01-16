package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class demo890 {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        int[] p = solve(pattern);
        List<String> res = new ArrayList<>();
        for (String word : words) if (same(solve(word), p)) res.add(word);
        return res;
    }

    public boolean same(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) if (a[i] != b[i]) return false;
        return true;
    }

    public int[] solve(String word) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chs = word.toCharArray();
        int index = 0, len = 0;
        int[] temp = new int[chs.length];
        for (int i = 0; i < chs.length; i++) {
            char e = chs[i];
            if (map.containsKey(e)) {
                temp[len++] = map.get(e);
            } else {
                temp[len++] = index;
                map.put(e, index++);
            }
        }
        return temp;
    }

}
