package niukewang;

import java.util.*;

public class demo2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        char[][] matrix = new char[2 * n][2 * n];
        for (int i = 0; i < n; i++) {
            char[] temp = sc.nextLine().trim().toCharArray();
            for (int j = 0; j < n; j++) {
                matrix[i][j] = matrix[i + n][j] = matrix[i][j + n] = matrix[i + n][j + n] = temp[j];
            }
        }
        sc.close();

        Queue<Integer> queue1 = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 'S') {
                    queue1.add(i * matrix.length + j);
                    matrix[i][j] = '.';
                }
            }
        }

        HashSet<Integer> visited = new HashSet<>();
        System.out.println(1);
        int step = 0;
        boolean tag = false;
        while (!queue1.isEmpty()) {
            if (tag) break;
            Set<Integer> set = new HashSet<>();
            step++;
            while (!queue1.isEmpty()) {
                int temp = queue1.poll();
                visited.add(temp);
                int row = temp / matrix.length;
                int col = temp % matrix.length;
                if (matrix[row][col] == 'E') {
                    tag = true;
                    break;
                }
                if (row != 0 && matrix[row - 1][col] == '.' && !visited.contains(key(row - 1, col, matrix.length)))
                    set.add(key(row - 1, col, matrix.length));
                if (row != matrix.length - 1 && matrix[row + 1][col] == '.' && !visited.contains(key(row + 1, col, matrix.length)))
                    set.add(key(row + 1, col, matrix.length));
                if (col != 0 && matrix[row][col - 1] == '.' && !visited.contains(key(row, col - 1, matrix.length)))
                    set.add(key(row, col - 1, matrix.length));
                if (col != matrix.length - 1 && matrix[row][col + 1] == '.' && !visited.contains(key(row, col + 1, matrix.length)))
                    set.add(key(row, col + 1, matrix.length));
                queue1 = new ArrayDeque<>(set);
            }
        }
        if (!tag) System.out.println("-1");
        else System.out.println(step);
        System.out.println(step);
    }

    public static int key(int row, int col, int len) {
        return row * len + col;
    }

}
