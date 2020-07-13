package offer;

import java.util.List;
import java.util.ArrayList;

public class demo63数据流中的中位数 {
    private List<Integer> nums = new ArrayList<>();

    public void Insert(Integer num) {
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) > num) {
                nums.add(i, num);
                return;
            }
        }
        nums.add(num);
    }

    public Double GetMedian() {
        int pos = nums.size() / 2;
        if (nums.size() % 2 == 1) return (double) nums.get(pos);
        return (double) (nums.get(pos) + nums.get(pos - 1)) / 2;
    }
}
