package dsa.greedyAlgorithm;

import java.util.Arrays;

class L8_Non_Overlapping_Intervals {
    public int minRemoval(int intervals[][]) {
        // similar to L7_N_Meeting_In_1_Room
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];

        for(int i=0; i<intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        return intervals.length - maxMeetings(start, end);
    }

    public int maxMeetings(int start[], int end[]) {

        int n = start.length;
        Integer[] indexes = new Integer[n];

        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }

        Arrays.sort(indexes, (a, b) -> end[a] - end[b]);

        int ans = 1;
        int lastEndDay = end[indexes[0]];

        for (int i = 1; i < n; i++) {
            int startDay = start[indexes[i]];
            if (startDay >= lastEndDay) {
                ans++;
                lastEndDay = end[indexes[i]];
            }
        }
        return ans;
    }
}

//TC : O(nlogn + 3n)
//SC : O(n)

// without splitting into start and end
//import java.util.Arrays;
//
//class L8_Non_Overlapping_Intervals {
//    public int minRemoval(int[][] intervals) {
//        if (intervals.length == 0) return 0;
//
//        // Sort intervals by end time
//        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
//
//        int count = 1; // first interval is always included
//        int lastEnd = intervals[0][1];
//
//        for (int i = 1; i < intervals.length; i++) {
//            if (intervals[i][0] >= lastEnd) {
//                count++;
//                lastEnd = intervals[i][1];
//            }
//        }
//
//        return intervals.length - count; // intervals to remove
//    }
//}
