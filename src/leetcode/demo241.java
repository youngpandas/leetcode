package leetcode;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.*;

public class demo241 {

    private Map<String, List<Integer>> map = new HashMap<>();

    public List<Integer> diffWaysToCompute(String input) {
        if (map.containsKey(input)) return map.get(input);
        List<Integer> res = new ArrayList<>();
        if (input.isEmpty()) return res;
        for (int i = 0; i < input.length(); i++) {
            char e = input.charAt(i);
            if (e == '+' || e == '-' || e == '*') {
                for (int l : diffWaysToCompute(input.substring(0, i))) {
                    for (int r : diffWaysToCompute(input.substring(i + 1))) {
                        switch (e) {
                            case '+':
                                res.add(l + r);
                                break;
                            case '-':
                                res.add(l - r);
                                break;
                            case '*':
                                res.add(l * r);
                                break;
                        }
                    }
                }
            }
        }
        if (res.isEmpty()) res.add(Integer.parseInt(input));
        map.put(input, res);
        return res;
    }

    public static void main(String[] args) {

    }

}
