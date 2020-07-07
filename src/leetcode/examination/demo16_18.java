package leetcode.examination;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class demo16_18 {

    public Map<Character, String> map = new HashMap<>();

    public boolean patternMatching(String pattern, String value) {
        if (pattern.equals("")) return value.equals("");
        char key = pattern.charAt(0);
        if (map.containsKey(key)) {
            String val = map.get(key);
            return value.startsWith(val) && patternMatching(pattern.substring(1), value.substring(val.length()));
        }
        for (int i = 0; i <= value.length(); i++) {
            String val = value.substring(0, i);
            if (map.containsValue(val)) continue;
            map.put(key, val);
            if (patternMatching(pattern.substring(1), value.substring(val.length()))) return true;
            map.remove(key);
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(new demo16_18().patternMatching("bbaba", "ajocitdfyhohchqvilvdjjocitdfyhohchqvilvdj"));
    }

}
