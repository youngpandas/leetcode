package haier;

public class demo1 {

    public static void main(String[] args) {
        incrementPatternPrint(4, 3);

    }

    public static void incrementPatternPrint(int N, int start) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print(start + i);
            }
            System.out.println();
        }
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print(start + i);
            }
            System.out.println();
        }
    }

}
