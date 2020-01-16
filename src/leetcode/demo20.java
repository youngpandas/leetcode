package leetcode;

import java.util.Queue;
import java.util.Stack;

public class demo20 {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if (s.equals("")) return true;
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            char e = s.charAt(i);
            if (stack.isEmpty() || isLeft(e)) {
                stack.push(e);
            } else if (getVal(e) == stack.peek()) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static boolean isLeft(char e) {
        switch (e) {
            case '{':
                return true;
            case '[':
                return true;
            case '(':
                return true;
        }
        return false;
    }

    public static char getVal(char e) {
        switch (e) {
            case '}':
                return '{';
            case ']':
                return '[';
            case ')':
                return '(';
        }
        return ' ';
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));

    }

}
