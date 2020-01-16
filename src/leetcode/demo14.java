package leetcode;

public class demo14 {

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        int minLenIndex = 0;
        for (int i = 1; i < strs.length; i++) {
            if (strs[minLenIndex].length() > strs[i].length()) minLenIndex = i;
        }
        StringBuffer res = new StringBuffer();
        String aimStr = strs[minLenIndex];
        for (int i = 0; i < aimStr.length(); i++) {
            char aimChar = aimStr.charAt(i);
            for (String s : strs) {
                if (s.charAt(i) != aimChar) {
                    return res.toString();
                }
            }
            res.append(aimChar);
        }
        return res.toString();
    }


    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }
}
