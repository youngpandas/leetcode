package leetcode;

public class demo921 {

    public int minAddToMakeValid(String S) {
        int i = 0;
        char[] chs = S.toCharArray();
        for (; i < chs.length; i++) if (chs[i] == '(') break;
        int res = i,count = 0;
        for (; i < chs.length; i++) {
            if (chs[i] == '(') count++;
            else if (--count == 0) return res + minAddToMakeValid(S.substring(i + 1));
        }
        return res + count;
    }

}
