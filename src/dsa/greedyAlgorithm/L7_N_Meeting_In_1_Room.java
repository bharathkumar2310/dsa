package dsa.greedyAlgorithm;

import java.util.Arrays;

class L7_N_Meeting_In_1_Room {

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
            if (startDay > lastEndDay) {
                ans++;
                lastEndDay = end[indexes[i]];
            }
        }
        return ans;
    }
}


//TC : O(nlogn + 2n)
//SC : O(n)
