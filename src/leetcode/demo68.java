package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class demo68 {

    String[] words;
    int maxWidth;
    List<String> res;

    public List<String> fullJustify(String[] words, int maxWidth) {
        this.res = new ArrayList<>();
        this.words = words;
        this.maxWidth = maxWidth;
        solve(0);
        return res;
    }

    public void solve(int start) {
        if (start == words.length) return;
        int pos = start, len = 0;
        for (; pos < words.length; pos++) {
            len += words[pos].length();
            if (pos - start + len > maxWidth) break;
        }

        StringBuilder sb = new StringBuilder();

        if (pos == words.length) {
            for (int i = start; i < pos; i++) {
                sb.append(words[i]);
                if (i == pos - 1) continue;
                sb.append(' ');
            }
            int l = maxWidth - sb.length();
            for (int i = 0; i < l; i++) {
                sb.append(' ');
            }
            res.add(sb.toString());
            return;
        }
        len -= words[pos].length();
        if (pos - start == 1) {
            sb.append(words[start]);
            for (int i = 0; i < maxWidth - len; i++) {
                sb.append(' ');
            }
        } else {
            int error = maxWidth - len;
            int base = error / (pos - start - 1);
            int preNum = error % (pos - start - 1);
            for (int i = start; i < start + preNum; i++) {
                sb.append(words[i]);
                for (int j = 0; j < base + 1; j++) {
                    sb.append(' ');
                }
            }
            for (int i = start + preNum; i < pos; i++) {
                sb.append(words[i]);
                if (i == pos - 1) continue;
                for (int j = 0; j < base; j++) {
                    sb.append(' ');
                }
            }
        }
        res.add(sb.toString());
        solve(pos);
    }


    public static void main(String[] args) {
        String[] words = {
                "This", "is", "an", "example", "of", "text", "justification."
        };

        System.out.println(new demo68().fullJustify(words, 16));
    }
}
