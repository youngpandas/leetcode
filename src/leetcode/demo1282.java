package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class demo1282 {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int e = groupSizes[i];
            if (map.containsKey(e)) {
                map.get(e).add(i);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                map.put(e, temp);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int key : map.keySet()) {
            List<Integer> nums = map.get(key);
            int len = nums.size();
            int i = key;
            for (; i < len; i += key) res.add(nums.subList(i - key, i));
            res.add(nums.subList(i, len));
        }
        return res;
    }

}
