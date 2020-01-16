package leetcode;

public class demo13 {
    public static int romanToInt(String s) {
        s += "I";
        int res = 0, pre = 0;
        for (int i = 0; i < s.length(); i++) {
            int val = getVal(s.charAt(i));
            res += pre < val ? -pre : pre;
            pre = val;
        }
        return res;
    }

    public static int getVal(char key) {
        switch (key) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }


    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }

}
