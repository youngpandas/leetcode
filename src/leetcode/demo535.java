package leetcode;

import java.util.HashMap;
import java.util.Map;

public class demo535 {

    private static Map<String, String> encoder = new HashMap<>();
    private static Map<String, String> decoder = new HashMap<>();
    private static int id = 0;

    // Encodes a URL to a shortened URL.
    public static String encode(String longUrl) {
        String res = String.valueOf(id++);
        encoder.put(longUrl, res);
        decoder.put(res, longUrl);
        return res;
    }

    // Decodes a shortened URL to its original URL.
    public static String decode(String shortUrl) {
        return decoder.get(shortUrl);
    }

}
