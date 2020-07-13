package haier;

public class demo2 {

    public static void main(String[] args) {

    }

    public static int[] cellCompete(int[] cells, int days) {
        if (cells.length == 1) {
            if (days == 0) return cells;
            return new int[]{1};
        }
        for (int i = 0; i < days; i++) {
            int[] temp = new int[cells.length];
            for (int j = 0; j < cells.length; j++) {
                if (j == 0) {
                    if (cells[j + 1] == 0) temp[j] = 1;
                    else temp[j] = 0;
                } else if (j == cells.length - 1) {
                    if (cells[j - 1] == 0) temp[j] = 1;
                    else temp[j] = 0;
                } else {
                    if (cells[j - 1] == cells[j + 1]) temp[j] = 1;
                    else temp[j] = 0;
                }
            }
            cells = temp;
        }
        return cells;
    }

}
