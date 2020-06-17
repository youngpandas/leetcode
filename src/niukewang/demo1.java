package niukewang;

import java.util.Scanner;
import java.util.Stack;

public class demo1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().trim();
        sc.close();

        Stack<Character> stack = new Stack<>();
        boolean tag = false;
        for (char e : str.toCharArray()) {
            if (e == '<') {
                if (!stack.isEmpty()) stack.pop();
            } else if (e == ')') {
                while (stack.pop() != '(') continue;
            } else {
                stack.push(e);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb.reverse().toString());
    }

}
