package dsa.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L23_Merge_Intervals {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (x, y)->x[0] - y[0]);

        int start = intervals[0][0];
        int end = intervals[0][1];
        List<int[]> ans = new ArrayList<>();
        for(int i=1; i<intervals.length; i++) {
            int newStart = intervals[i][0];
            int newEnd = intervals[i][1];

            if(newStart <= end) {
                end = Math.max(end, newEnd);
            }

            else if(newStart > end) {
                ans.add(new int[]{start, end});
                start = newStart;
                end = newEnd;
            }
        }

        ans.add(new int[] {start, end});
        int[][] ans1 = new int[ans.size()][2];
        for(int i=0; i<ans.size(); i++) {
            ans1[i][0] = ans.get(i)[0];
            ans1[i][1] = ans.get(i)[1];
        }

        return ans1;
    }
}

//TC : O(nlogn + n)
//SC : O(n)