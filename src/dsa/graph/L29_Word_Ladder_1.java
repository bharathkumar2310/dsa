package dsa.graph;

import java.util.*;

public class L29_Word_Ladder_1 {
    class Pair {
        String word;
        int count;

        Pair(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if(!wordList.contains(endWord)) {
            return 0;
        }
        Set<String> visited = new HashSet<>(wordList);
        Queue<Pair> pq = new LinkedList<>();
        pq.add(new Pair(beginWord, 1));
        visited.remove(beginWord);

        while(!pq.isEmpty()) {

            Pair pair = pq.poll();
            String word = pair.word;
            int count = pair.count;

            if(word.equals(endWord)) {
                return count;
            }

            char[] arr = word.toCharArray();

            for(int i=0;i<word.length(); i++) {
                char org = arr[i];
                for(char ch = 'a'; ch<='z'; ch++) {

                    arr[i] = ch;
                    String next = new String(arr);


                    if(visited.contains(next) ) {
                        pq.add(new Pair(next, count + 1));
                        visited.remove(next);
                    }
                }
                arr[i] = org;
            }
        }

        return 0;

    }
}


//TC : O(n * l *26) // l = length of each word

//SC : O(n)