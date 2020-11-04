package rlnitsua.contest;

import java.util.HashMap;
import java.util.Map;

public class HTMLEntityParser {
    public String entityParser(String text) {
        Map<String, Character> info = new HashMap<>();
        info.put("&quot;", '\"');
        info.put("&apos;", '\'');
        info.put("&amp;", '&');
        info.put("&gt;", '>');
        info.put("&lt;", '<');
        info.put("&frasl;", '/');

        for (Map.Entry<String, Character> entry : info.entrySet()) {
            text = text.replace(entry.getKey(), entry.getValue().toString());
        }

        return text;
    }
}
