package dsa.greedyAlgorithm;

import java.util.ArrayList;
import java.util.List;

class L9_Insert_Intervals {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int start = newInterval[0];
        int end = newInterval[1];

        List<int[]> ansList = new ArrayList<>();
        int i = 0;
        while(i < intervals.length && start > intervals[i][1]) {
            ansList.add(intervals[i]);
            i++;
        }
        while(i < intervals.length && end >= intervals[i][0]) {
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }
        ansList.add(new int[] {start, end});

        while(i<intervals.length) {
            ansList.add(intervals[i]);
            i++;
        }


        int[][] ans = new int[ansList.size()][2];

        for(int j=0; j<ansList.size(); j++) {
            int[] arr = ansList.get(j);
            ans[j][0] = arr[0];
            ans[j][1] = arr[1];

        }

        return ans;
    }
}

//Tc : O(n + n) => O(n)
//SC : O(n*2)