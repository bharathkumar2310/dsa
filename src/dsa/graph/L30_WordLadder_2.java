package dsa.graph;

import java.util.*;

public class L30_WordLadder_2 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Queue<List<String>> q = new LinkedList<>();
        Set<String> visited = new HashSet<>(wordList);
        Set<String> levelWiseRemove = new HashSet<>();
        List<List<String>> ans = new ArrayList<>();
        if (!visited.contains(endWord)) {
            return new ArrayList<>();
        }


        List<String>strList = new ArrayList<>();
        strList.add(beginWord);
        q.add(strList);
        visited.remove(beginWord);
        boolean found = false;

        while(!q.isEmpty()) {
            int size = q.size();
            for(int k=0; k<size; k++) {
                List<String> list = q.poll();
                String word = list.get(list.size() -1);
                char[] arr = word.toCharArray();
                if(endWord.equals(word)) {
                    if(ans.size() == 0) {
                        found = true;
                        ans.add(list);
                    }
                    else if(ans.get(0).size() == list.size()) {
                        ans.add(list);
                    }
                    ;
                }

                if(found) {
                    continue;
                }
                for(int i=0; i<arr.length; i++) {
                    char org = arr[i];
                    for(char ch = 'a'; ch<='z'; ch++) {
                        arr[i] = ch;
                        String next = new String(arr);
                        if(visited.contains(next)) {
                            List<String> newList = new ArrayList<>(list);
                            newList.add(next);
                            q.add(newList);
                            levelWiseRemove.add(next);
                        }
                    }
                    arr[i]= org;
                }

            }

            if(found) {
                break;
            }

            for(String it : levelWiseRemove) {
                visited.remove(it);
            }
            levelWiseRemove.clear();
        }

        return ans;
    }
}


//TC : O(n*l*26)
//SC : O(n^2)