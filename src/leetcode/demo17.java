package leetcode;

import java.util.ArrayList;
import java.util.List;

public class demo17 {


    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (!digits.equals("")) dfs(0, digits, "", res);
        return res;
    }


    public static void dfs(int start, String digits, String temp, List<String> res) {
        if (start == digits.length()) {
            res.add(temp);
            return;
        }
        char key = digits.charAt(start);
        String val = getVal(key);
        for (int i = 0; i < val.length(); i++) {
            dfs(start + 1, digits, temp + val.charAt(i), res);
        }
    }

    public static String getVal(char key) {
        switch (key) {
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':
                return "tuv";
            case '9':
                return "wxyz";
        }
        return "";
    }


    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
