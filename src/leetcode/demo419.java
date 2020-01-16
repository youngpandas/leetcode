package leetcode;

public class demo419 {

    public int countBattleships(char[][] board) {
        int row = board.length;
        if (row == 0) return 0;
        int col = board[0].length, res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == '.') continue;
                for (int k = i + 1; k < row; k++) {
                    if (board[k][j] == '.') break;
                    board[k][j] = '.';
                }
                for (; j < col; j++) {
                    if (board[i][j] == '.') break;
                    board[i][j] = '.';
                }
                res++;
            }
        }
        return res;
    }


}
