package leetcode;

public class demo807 {


    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int len = grid.length;
        int[] rows = new int[len], cols = new int[len];
        for (int i = 0; i < len; i++) {
            int rowMax = 0, colMax = 0;
            for (int j = 0; j < len; j++) {
                if (rowMax < grid[i][j]) rowMax = grid[i][j];
                if (colMax < grid[j][i]) colMax = grid[j][i];
            }
            rows[i] = rowMax;
            cols[i] = colMax;
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                res += (rows[i] < cols[j] ? rows[i] : cols[j]) - grid[i][j];
            }
        }
        return res;
    }

}
