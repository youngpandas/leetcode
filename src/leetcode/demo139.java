package leetcode;

import java.util.*;

public class demo139 {

    Set<String> set = new HashSet<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.equals("")) return true;
        if (set.contains(s)) return false;
        for (String e : wordDict) {
            if (s.startsWith(e) && wordBreak(s.substring(e.length()), wordDict)) {
                return true;
            }
        }
        set.add(s);
        return false;
    }


    public static void main(String[] args) {
        System.out.println(new demo139().wordBreak("leetcode", Arrays.asList(new String[]{"leet", "code"})));
    }

}
