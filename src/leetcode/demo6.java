package leetcode;

public class demo6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuffer[] rowStr = new StringBuffer[numRows];
        for (int i = 0; i < numRows; i++) rowStr[i] = new StringBuffer();
        int row = 0, add = 1;
        for (int i = 0; i < s.length(); i++) {
            rowStr[row].append(s.charAt(i));
            if (row == 0) add = 1;
            else if (row == numRows - 1) add = -1;
            row += add;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuffer sb : rowStr) res.append(sb);
        return res.toString();
    }

}
