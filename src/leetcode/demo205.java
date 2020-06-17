package leetcode;

import java.util.HashMap;
import java.util.Map;

public class demo205 {

    public boolean isIsomorphic(String s, String t) {
        int[] sTrans = trans(s);
        int[] tTrans = trans(t);
        for(int i=0;i<sTrans.length;i++) {
            if(sTrans[i]!=tTrans[i]) return false;
        }
        return true;
    }

    public int[] trans(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int[] res = new int[s.length()];
        int len  = 0,idx = 0;
        for(char e:s.toCharArray()){
            if (map.containsKey(e)) {
                res[len++] = map.get(e);
            }else{
                map.put(e,idx);
                res[len++] = idx++;
            }
        }
        return res;
    }


}
