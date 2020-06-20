package leetcode;

public class demo125 {

    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (char e : s.toLowerCase().toCharArray()) {
            if ((e - 'a' >= 0 && e - 'z' <= 0) || (e - '0' >= 0 && e - '9' <= 0)) sb.append(e);
        }
        return sb.toString().equals(sb.reverse().toString());
    }

    public static void main(String[] args) {
        System.out.println(new demo125().isPalindrome("0P"));
    }

}
