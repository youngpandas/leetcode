package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class demo447 {

    public int numberOfBoomerangs(int[][] points) {
        int len = points.length;
        int[][] matrix = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                matrix[i][j] = x * x + y * y;
            }
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int[] ee : matrix) {
            Map<Integer, Integer> temp = new HashMap<>();
            for (int e : ee) {
                temp.put(e, temp.containsKey(e) ? temp.get(e) + 1 : 1);
            }
            for (int e : temp.values()) {
                map.put(e, map.containsKey(e) ? map.get(e) + 1 : 1);
            }
        }

        int res = 0;
        for (int key : map.keySet()) {
            res += (key - 1) * key * map.get(key);
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new demo447().numberOfBoomerangs(new int[][]{{0, 0}, {1, 0}, {2, 0}}));
    }
}
