package leetcode;

import java.util.HashMap;
import java.util.Map;

public class demo290 {

    public boolean wordPattern(String pattern, String str) {
        if (str.split(" ").length!=pattern.length()) return false;
        int[] sTrans = trans(pattern.replace("", " ").trim());
        int[] tTrans = trans(str);
        if (sTrans.length != tTrans.length) return false;
        for (int i = 0; i < sTrans.length; i++) {
            if (sTrans[i] != tTrans[i]) return false;
        }
        return true;
    }

    public int[] trans(String s) {
        Map<String, Integer> map = new HashMap<>();
        int[] res = new int[s.split(" ").length];
        int len = 0, idx = 0;
        for (String e : s.split(" ")) {
            if (e.equals("")) continue;
            if (map.containsKey(e)) {
                res[len++] = map.get(e);
            } else {
                map.put(e, idx);
                res[len++] = idx++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("abcd".replace("", " ").trim());
    }

}
