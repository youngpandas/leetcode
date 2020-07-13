package offer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class demo65矩阵中的路径 {

    char[][] matrix;
    char[] str;
    int rows, cols;

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || str == null) return false;
        if (rows * cols != matrix.length) return false;
        if (rows < 0 || cols < 0) return false;
        if (rows == 0 || cols == 0) return str.length == 0;
        if (str.length == 0) return true;

        char[][] newMatrix = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int index = i * cols + j;
                newMatrix[i][j] = matrix[index];
            }
        }

        this.matrix = newMatrix;
        this.str = str;
        this.rows = rows;
        this.cols = cols;

        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (this.matrix[i][j]==str[0]){
                    int key = i * cols + j;
                    visited.add(key);
                    if (dfs(i, j, 1, visited)) return true;
                    visited.remove(key);
                }
            }
        }
        return false;
    }

    public boolean dfs(int i, int j, int cur, Set<Integer> visited) {
        if (cur == str.length) return true;
        if (i < 0 || i >= rows) return false;
        if (j < 0 || j >= cols) return false;
//        System.out.println("i=" + i + ",j=" + j + ",cur=" + str[cur]);
//        for (char[] chs : matrix) System.out.println(Arrays.toString(chs));
//
//        System.out.println();

        boolean res = false;
        if (i > 0) res = join(i - 1, j, cur, visited);
        if (i < rows - 1) res = res || join(i + 1, j, cur, visited);
        if (j > 0) res = res || join(i, j - 1, cur, visited);
        if (j < cols - 1) res = res || join(i, j + 1, cur, visited);
        return res;
    }

    public boolean join(int i, int j, int cur, Set<Integer> visited) {
        boolean res = false;
        int key = i * cols + j;
        if (!visited.contains(key) && matrix[i][j] == str[cur]) {
            visited.add(key);
            res = dfs(i, j, cur + 1, visited);
            visited.remove(key);
        }
        return res;
    }

    public static void main(String[] args) {
        int a = "ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".length();
        System.out.println(new demo65矩阵中的路径().hasPath("ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray(), 5, 8, "SGGFIECVAASABCEHJIGQEMS".toCharArray()));
    }
}
