package lesson31;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by MM on 14.01.2018.
 */
public class Solution {
    /**
     *
     * @param text
     * @return
     */
    public Map<String, Integer> countSymbols(String text){
        Map<String, Integer> map = new HashMap<>();
        if (text == null || text.isEmpty())
            return map;

        char[] lines = text.toCharArray();
        String symbol;

        for (int i = 0; i < lines.length; i++) {
            symbol = String.valueOf(lines[i]);

            if (!symbol.matches("[a-zA-Zа-яА-Я]"))
                continue;

            if (map.containsKey(symbol)){
                map.put(symbol, map.get(symbol) + 1);
            } else map.put(symbol, 1);
        }
        return map;
    }

    /**
     *
     * @param text
     * @return
     */
    public Map<String, Integer>  words(String text){
        Map<String, Integer> map = new HashMap<>();

        if (text == null || text.isEmpty())
            return map;

        String[] wordsLine = text.split(" ");

        for (int i = 0; i < wordsLine.length; i++) {
            if (wordsLine[i].length() < 3)
                continue;

            if (!wordsLine[i].matches("[a-zA-Zа-яА-Я-]+")) {
                continue;
            }

            if (map.containsKey(wordsLine[i])){
                map.put(wordsLine[i], map.get(wordsLine[i]) + 1);
            } else map.put(wordsLine[i], 1);
        }
        return map;
    }
}
