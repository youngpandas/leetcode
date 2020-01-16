package leetcode;

public class demo316 {

    public String removeDuplicateLetters(String s) {
        StringBuilder sb = new StringBuilder();
        boolean[] tags = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (!tags[idx]) {
                sb.append((char) ('a' + i));
                tags[idx] = true;
            }
        }
        return sb.reverse().toString();
    }

}
