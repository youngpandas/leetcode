package leetcode;

public class demo980 {

    private int res = 0;

    public int uniquePathsIII(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int curI = 0, curJ = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    curI = i;
                    curJ = j;
                    grid[i][j] = 0;
                    break;
                }
            }
        }
        int tol = 0;
        for (int[] ee : grid) for (int e : ee) if (e == -1) tol++;
        dfs(grid, curI, curJ, 0, row * col - tol - 1);
        return res;
    }


    public void dfs(int[][] grid, int curI, int curJ, int step, int tol) {
        if (curI < 0 || curI >= grid.length || curJ < 0 || curJ >= grid[0].length || grid[curI][curJ] == -1) return;
        if (grid[curI][curJ] == 2) {
            if (step == tol) res++;
            return;
        }
        grid[curI][curJ] = -1;
        dfs(grid, curI + 1, curJ, step + 1, tol);
        dfs(grid, curI - 1, curJ, step + 1, tol);
        dfs(grid, curI, curJ + 1, step + 1, tol);
        dfs(grid, curI, curJ - 1, step + 1, tol);
        grid[curI][curJ] = 0;
    }
}
