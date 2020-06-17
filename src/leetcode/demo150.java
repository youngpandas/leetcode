package leetcode;

import java.util.Arrays;

public class demo150 {

    public int evalRPN(String[] tokens) {
        if (tokens.length == 1) return Integer.valueOf(tokens[0]);
        if (tokens.length == 3) return calculate(Integer.valueOf(tokens[0]), Integer.valueOf(tokens[1]), tokens[2]);
        int count = 0, i = 1;
        for (; i < tokens.length; i++) {
            if ("+-*/".contains(tokens[i])) count--;
            else count++;
            if (count == 0) {
                break;
            }
        }
        String tag = tokens[tokens.length - 1];
        int left = evalRPN(Arrays.copyOfRange(tokens, 0, i + 1));
        int right = evalRPN(Arrays.copyOfRange(tokens, i + 1, tokens.length - 1));
        return calculate(left, right, tag);
    }

    public int calculate(int left, int right, String tag) {
        switch (tag) {
            case "+":
                return left + right;
            case "-":
                return left - right;
            case "*":
                return left * right;
            case "/":
                return left / right;
        }
        return -1;

    }

    public static void main(String[] args) {
        System.out.println(new demo150().evalRPN(new String[]{
                "2", "1", "+", "3", "*"
        }));
    }

}
