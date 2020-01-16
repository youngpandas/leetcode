package leetcode;

public class demo28 {

    public int strStr(String haystack, String needle) {
        if (needle.equals("")) return 0;
        int len2 = needle.length();
        int step = haystack.length() - len2;
        for (int i = 0; i <= step; i++) {
            if (haystack.substring(i, i + len2).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

}
