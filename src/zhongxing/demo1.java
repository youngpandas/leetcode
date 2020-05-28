package zhongxing;

import java.util.Scanner;

public class demo1 {

    int longestPrefix(String key, String dataText) {
        dataText += dataText;
        int low = 0, high = key.length() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            String subStr = key.substring(0, mid + 1);
            boolean tag = dataText.contains(subStr);
            if (tag) low = mid + 1;
            else high = mid - 1;
        }
        if (dataText.contains(key.substring(0, high + 1))) return high + 1;
        return low + 1;
    }

    public static void main(String[] args) {
        System.out.println(new demo1().longestPrefix("a2abccc", "bddda2a"));
    }


}
