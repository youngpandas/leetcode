package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class demo37 {

    HashSet<Integer>[] rows = new HashSet[9];
    HashSet<Integer>[] cols = new HashSet[9];
    HashSet<Integer>[][] boxes = new HashSet[3][3];
    char[][] board;
    boolean tag = false;

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet();
            cols[i] = new HashSet();
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boxes[i][j] = new HashSet();
            }
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int e = board[i][j] - '0';
                rows[i].add(e);
                cols[j].add(e);
                boxes[i / 3][j / 3].add(e);
            }
        }
//        for (int i = 0; i < 9; i++) {
//            System.out.println("row[" + i + "]=" + rows[i]);
//        }
//        for (int i = 0; i < 9; i++) {
//            System.out.println("col[" + i + "]=" + cols[i]);
//        }
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                System.out.println("row[" + i + "][" + i + "]=" + boxes[i][j]);
//            }
//        }
        this.board = board;
        dfs(0, 0);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + ",");
            }
            System.out.println();
        }
    }

    public void dfs(int row, int col) {
        if (tag) return;
        if (row == 9) {
            tag = true;
            return;
        }
        if (col == 9) {
            dfs(row + 1, 0);
            return;
        }
        if (board[row][col] != '.') {
            dfs(row, col + 1);
            return;
        }
        List<Integer> children = getChildren(row, col);
        System.out.println("row=" + row + ", col=" + col + ", children=" + children);
        for (int e : children) {
            if (tag) break;
            rows[row].add(e);
            cols[col].add(e);
            boxes[row / 3][col / 3].add(e);
            board[row][col] = (char) ('0' + e);
            dfs(row, col + 1);
            if (tag) break;
            rows[row].remove(e);
            cols[col].remove(e);
            boxes[row / 3][col / 3].remove(e);
            board[row][col] = '.';
        }
    }

    public List<Integer> getChildren(int row, int col) {
        HashSet<Integer> nums = new HashSet<>();

        nums.addAll(rows[row]);
        nums.addAll(cols[col]);
        nums.addAll(boxes[row / 3][col / 3]);
        System.out.println("\trow[" + row + "]=" + rows[row]);
        System.out.println("\tcol[" + col + "]=" + cols[col]);
        System.out.println("\tboxes[i][j]=" + boxes[row / 3][col / 3]);
        System.out.println("\tnums=" + nums);
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            if (nums.contains(i)) continue;
            res.add(i);
        }
        return res;
    }


    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        new demo37().solveSudoku(board);
    }

}
