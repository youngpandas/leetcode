package leetcode.mianshi;

import org.omg.CORBA.INITIALIZE;

import java.util.HashMap;
import java.util.Map;

public class demo46 {

    Map<String, Integer> map = new HashMap<>();

    public int translateNum(int num) {
        return solve(String.valueOf(num));
    }

    public int solve(String str) {
        if (str.equals("")) return 1;
        if (str.length() == 1) return 1;
        if (map.containsKey(str)) return map.get(str);
        int b = Integer.valueOf(str.substring(0, 2));
        int res = 0;
        res += solve(str.substring(1));
        if (b > 9 && b < 26) res += solve(str.substring(2));
        map.put(str, res);
        return res;
    }


}
