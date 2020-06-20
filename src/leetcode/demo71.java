package leetcode;

import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

public class demo71 {


    public String simplifyPath(String path) {
        String[] tags = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String e : tags) {
            if (e.equals("") || e.equals(".")) continue;
            if (!e.equals("..")) stack.push(e);
            else if (!stack.empty()) stack.pop();
        }
        return "/" + String.join("/", stack.stream().collect(Collectors.toList()));
    }

    public static void main(String[] args) {
        System.out.println(new demo71().simplifyPath("/a/../../b/../c//.//"));
    }

}
