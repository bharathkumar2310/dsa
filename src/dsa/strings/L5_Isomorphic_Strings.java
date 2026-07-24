package dsa.strings;

import java.util.HashMap;
import java.util.Map;

public class L5_Isomorphic_Strings {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();

        if(s.length() != t.length()) {
            return false;
        }

        for(int i=0; i<s.length(); i++) {
            if(map1.containsKey(s.charAt(i))) {
                if(t.charAt(i) != map1.get(s.charAt(i))) {
                    return false;
                }
            }
            else {
                map1.put(s.charAt(i), t.charAt(i));
            }
            if(map2.containsKey(t.charAt(i))) {
                if(s.charAt(i) != map2.get(t.charAt(i))) {
                    return false;
                }
            }
            else {
                map2.put(t.charAt(i), s.charAt(i));
            }
        }

        return true;

    }

}

//TC : O(n)
//SC : O(2n)