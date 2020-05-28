package leetcode;

public class demo394 {

    public String decodeString(String s) {
        if (s.length() == 0) return "";
        if (s.charAt(0) - '0' >= 0 && s.charAt(0) - '9' <= 0) {
            int i = 1;
            for (; i < s.length(); i++) if (s.charAt(i) == '[') break;
            int start = i;
            int count = 0;
            for (; i < s.length(); i++) {
                if (s.charAt(i) == '[') count++;
                if (s.charAt(i) == ']') count--;
                if (count == 0) break;
            }
            int end = i;
            int times = Integer.parseInt(s.substring(0, start));
            String subStr = decodeString(s.substring(start + 1, end));
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < times; j++) sb.append(subStr);
            if (end == s.length()) return sb.toString();
            return sb.toString() + decodeString(s.substring(end + 1));
        }
        return s.charAt(0) + decodeString(s.substring(1));
    }

    public static void main(String[] args) {
        System.out.println(new demo394().decodeString("3[a2[c]]"));
    }

}
