package test;

import java.util.Arrays;

public class demo1 {

    public static void main(String[] args) {
        String[] a = {"aaa", "bbb", "ccc"};
        String[][][][] b = {{{{"aaa", "bbb", "ccc"}}}};
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.deepToString(a));
        System.out.println(String.join(" ", new String[]{"1", "2"}));
    }

}
