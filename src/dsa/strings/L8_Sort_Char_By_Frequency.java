package dsa.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L8_Sort_Char_By_Frequency {
    public String frequencySort(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Character> chars = new ArrayList<>(map.keySet());

        chars.sort((a, b) -> map.get(b) - map.get(a));

        StringBuilder sb = new StringBuilder();

        for(char c : chars) {
            for(int i = 0; i < map.get(c); i++) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}


//Counting: O(n)
//Sorting distinct chars: O(k log k)
//Building answer: O(n)


//TC : O(n + k log k)
//SC : O(52)