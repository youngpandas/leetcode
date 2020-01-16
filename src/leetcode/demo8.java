package leetcode;

public class demo8 {

    public static int myAtoi(String str) {
        str = str.trim();
        if (str.equals("")) return 0;
        char e = str.charAt(0);
        boolean tag = true;
        if (e != '+' && e != '-' && (e - '0' < 0 || e - '9' > 0)) return 0;
        if (e == '+') str = str.substring(1);
        if (e == '-') {
            str = str.substring(1);
            tag = false;
        }
        if (str.equals("")) return 0;
        int i = 0;
        for (; i < str.length(); i++) {
            e = str.charAt(i);
            if (e - '0' < 0 || e - '9' > 0) break;
        }
        if (i == 0) return 0;
        str = str.substring(0, i);
        str = str.replaceFirst("^0", "");
        if (str.equals("")) return 0;
        if (!tag && str.equals("2147483648")) return Integer.MIN_VALUE;
        try {
            int res = Integer.parseInt(str);
            if (!tag) res = -res;
            return res;
        } catch (Exception error) {
            if (tag) return Integer.MAX_VALUE;
            return Integer.MIN_VALUE;
        }
    }

}
