package leetcode;

import java.util.HashMap;
import java.util.Map;

public class demo3 {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0, start = 0, i = 0;
        for (; i < s.length(); i++) {
            char e = s.charAt(i);
            if (map.containsKey(e)) {
                int pos = map.get(e);
                if (pos >= start) {
                    int val = i - start;
                    if (res < val) res = val;
                    start = pos + 1;
                }
            }
            map.put(e, i);
        }
        int val = i - start;
        if (res < val) res = val;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new demo3().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new demo3().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new demo3().lengthOfLongestSubstring("pwwkew"));
    }
}
