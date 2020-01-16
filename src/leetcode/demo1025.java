package leetcode;

public class demo1025 {

    public static boolean[] hash = {false, true, false, false, false, true, false, true, true, true, false, true, false, true, true, true, false, true, false, true, true, true, false, true, true, true, true, true, false, true, false, true, true, true, true, true, false, true, true, true, false, true, false, true, true, true, false, true, true, true, true, true, false, true, true, true, true, true, false, true, false, true, true, true, true, true, false, true, true, true, false, true, false, true, true, true, true, true, false, true, true, true, false, true, true, true, true, true, false, true, true, true, true, true, true, true, false, true, true, true, false, true, false, true, true, true, false, true, false, true, true, true, false, true, true, true, true, true, true, true, true, true, true, true, true, true, false, true, true, true, false, true, true, true, true, true, false, true, false, true, true, true, true, true, true, true, true, true, false, true, false, true, true, true, true, true, false, true, true, true, true, true, false, true, true, true, false, true, true, true, true, true, false, true, true, true, true, true, false, true, false, true, true, true, true, true, true, true, true, true, false, true, false, true, true, true, false, true, false, true, true, true, true, true, true, true, true, true, true, true, false, true, true, true, true, true, true, true, true, true, true, true, false, true, true, true, false, true, false, true, true, true, false, true, true, true, true, true, false, true, false, true, true, true, true, true, true, true, true, true, false, true, true, true, true, true, false, true, true, true, true, true, false, true, true, true, true, true, false, true, false, true, true, true, true, true, false, true, true, true, false, true, false, true, true, true, true, true, true, true, true, true, false, true, true, true, true, true, true, true, true, true, true, true, true, true, false, true, true, true, false, true, false, true, true, true, false, true, true, true, true, true, true, true, true, true, true, true, true, true, false, true, true, true, true, true, false, true, true, true, true, true, true, true, true, true, false, true, false, true, true, true, false, true, true, true, true, true, false, true, true, true, true, true, true, true, false, true, true, true, true, true, false, true, true, true, true, true, false, true, true, true, false, true, true, true, true, true, false, true, true, true, true, true, true, true, false, true, true, true, false, true, true, true, true, true, true, true, false, true, true, true, true, true, true, true, true, true, false, true, false, true, true, true, true, true, true, true, true, true, false, true, false, true, true, true, true, true, false, true, true, true, false, true, true, true, true, true, false, true, true, true, true, true, true, true, false, true, true, true, false, true, false, true, true, true, false, true, true, true, true, true, true, true, true, true, true, true, false, true, true, true, true, true, true, true, false, true, true, true, false, true, true, true, true, true, true, true, false, true, true, true, false, true, true, true, true, true, false, true, true, true, true, true, true, true, true, true, true, true, false, true, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, true, true, true, true, true, false, true, true, true, true, true, true, true, true, true, false, true, true, true, true, true, false, true, true, true, true, true, false, true, false, true, true, true, true, true, false, true, true, true, true, true, true, true, true, true, false, true, true, true, true, true, false, true, true, true, true, true, false, true, false, true, true, true, true, true, false, true, true, true, true, true, false, true, true, true, false, true, false, true, true, true, true, true, true, true, true, true, true, true, false, true, true, true, true, true, true, true, true, true, false, true, false, true, true, true, false, true, true, true, true, true, false, true, true, true, true, true, false, true, false, true, true, true, true, true, true, true, true, true, true, true, false, true, true, true, false, true, true, true, true, true, false, true, true, true, true, true, true, true, false, true, true, true, true, true, true, true, true, true, false, true, true, true, true, true, true, true, false, true, true, true, true, true, true, true, true, true, false, true, true, true, true, true, true, true, false, true, true, true, true, true, false, true, true, true, true, true, false, true, true, true, false, true, true, true, true, true, true, true, false, true, true, true, true, true, false, true, true, true, false, true, true, true, true, true, true, true, false, true, true, true, false, true, true, true, true, true, true, true, true, true, true, true, true, true, false, true, true, true, true, true, true, true, true, true, false, true, true, true, true, true, true, true, true, true, true, true, false, true, false, true, true, true, true, true, true, true, true, true, false, true, false, true, true, true, false, true, false, true, true, true, true, true, true, true, true, true, false, true, true, true, true, true, true, true, true, true, true, true, true, true, false, true, true, true, false, true, false, true, true, true, false, true, true, true, true, true, true, true, true, true, true, true, true, true, false, true, true, true, false, true, false, true, true, true, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, true, true, true, false, true, true, true, true, true, true, true, false, true, true, true, true, true, true, true, true, true, false, true, true, true, true, true, true, true, false, true, true, true, false, true, true, true, true, true, false, true, true, true, true, true, false, true, true, true, true, true, true, true, true, true, true, true, true, true, false, true, true, true, false, true, true, true, true, true, false, true, true, true, true, true, false, true, true, true, true, true, true, true, false, true, true, true, true, true, false, true, true,};

    public static boolean divisorGame(int N) {
        boolean[] hash = new boolean[N + 1];
        hash[0] = true;
        for (int i = 4; i <= N; i++) {
            for (int j = (int) Math.sqrt(i); j > 0; j--) {
                if (i % j != 0 || (hash[i - j] && hash[i - i / j])) continue;
                hash[i] = true;
                break;
            }
        }
        return hash[N];
    }

    public static void main(String[] args) {
        int N = 1000;
        boolean[] hash = new boolean[N + 1];
        hash[2] = true;
        for (int i = 4; i <= N; i++) {
            for (int j = (int) Math.sqrt(i); j > 1; j--) {
                if (i % j != 0 || (hash[j] && hash[i / j])) continue;
                hash[i] = true;
                break;
            }
        }

        for (int i = 1; i < 1000; i++) {
            System.out.print(hash[i] + ",");
        }
    }

}
