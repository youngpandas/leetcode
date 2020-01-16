package leetcode;

public class demo1221 {


    public int balancedStringSplit(String s) {
        int count = 0, len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == 'R') count++;
            else count--;
            if (count == 0) return 1 + balancedStringSplit(s.substring(i + 1));
        }
        return 0;
    }

}
