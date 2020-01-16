package leetcode;

import java.util.ArrayList;
import java.util.List;

public class demo728 {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) if (solve(i)) res.add(i);
        return res;
    }

    public boolean solve(int num) {
        int temp = num;
        while (temp != 0) {
            int last = temp % 10;
            if (last == 0 ||num % last != 0) return false;
            temp /= 10;
        }
        return true;
    }

}
