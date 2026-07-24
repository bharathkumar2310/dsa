package dsa.graph;

import java.util.*;

public class L50_Accounts_Merge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> map = new HashMap<>();
        int[] parent = new int[accounts.size()];
        int[] size = new int[accounts.size()];

        for(int i=0; i<accounts.size(); i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for(int i=0; i<accounts.size(); i++) {
            for(int j=1; j<accounts.get(i).size(); j++) {
                String name = accounts.get(i).get(j);
                if(!map.containsKey(name)) {
                    map.put(name, i);
                }

                else {
                    union(map.get(name), i, parent, size);
                }
            }
        }

        List<Set<String>> mergedList = new ArrayList<>();
        for(int i=0; i<accounts.size(); i++) {
            mergedList.add(new TreeSet<>());
        }
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            int parent1 = findParent(value, parent);
            mergedList.get(parent1).add(key);
        }

        List<List<String>> ans = new ArrayList<>();
        for(int i=0; i<mergedList.size(); i++) {
            if(mergedList.get(i).isEmpty()) {
                continue;
            }
            List<String> ans1 = new ArrayList<>();
            ans1.add(accounts.get(i).get(0));
            ans1.addAll(mergedList.get(i));
            ans.add(ans1);
        }

        return ans;
    }


    void union(int i, int j, int[] parent, int[] size) {
        int upI = findParent(i, parent);
        int upJ = findParent(j, parent);

        if(upI == upJ) {
            return;
        }

        if(size[upI] >= size[upJ]) {
            parent[upJ] = upI;
            size[upI] += size[upJ];
        } else {
            parent[upI] = upJ;
            size[upJ] += size[upI];
        }

    }

    int findParent(int i, int[] parent) {
        if(parent[i] == i) {
            return parent[i];
        }

        return parent[i] = findParent(parent[i], parent);
    }
}

//TC : O(E log E)
//SC : O(E + V)