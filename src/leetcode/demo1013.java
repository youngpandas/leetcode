package leetcode;

public class demo1013 {

    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int e : A) sum += e;
        if (sum % 3 != 0) return false;
        int aim = sum / 3;
        int temp = 0;
        for (int e : A) {
            temp += e;
            if (temp == aim) {
                temp = 0;
            }
        }
        return temp == 0;
    }

}
