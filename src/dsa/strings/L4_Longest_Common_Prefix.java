package dsa.strings;

public class L4_Longest_Common_Prefix {
    public String longestCommonPrefix(String[] strs) {
        for(int i=0; i<strs[0].length(); i++) {
            char first = strs[0].charAt(i);
            for(int j=0; j<strs.length; j++) {
                if(i>= strs[j].length() || first != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];

    }
}

//TC : O(n*m)
//SC : O(1)

//public String longestCommonPrefix(String[] strs) {
//    Arrays.sort(strs);
//    String first = strs[0];
//    String last = strs[strs.length -1];
//    int i=0;
//    int j= 0;
//
//    while(i < first.length() && j<last.length()) {
//        if(first.charAt(i) != last.charAt(i)) {
//            return first.substring(0, i);
//        }
//        i++;
//        j++;
//    }
//    return first;
//
//}

//TC : O(n log n * m + m) because string sortign takes *m