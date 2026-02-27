package dsa.greedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class L6_Job_Sequencing_Problem {

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        // code here

        int maxDeadLine = Arrays.stream(deadline).max().getAsInt();
        int[] maxProfitOnADay =  new int[maxDeadLine + 1];
        Arrays.fill(maxProfitOnADay, -1);

        int maxProfit = 0;
        int noOfDays = 0;

        Integer[] indexes = new Integer[profit.length];
        for(int i=0; i< indexes.length; i++) {
            indexes[i] = i;
        }

        Arrays.sort(indexes, (a,b) -> profit[b] - profit[a]);

        for(int i=0; i<indexes.length; i++) {
            int currDeadline = deadline[indexes[i]];
            while(currDeadline > 0) {
                if(maxProfitOnADay[currDeadline] == -1) {
                    maxProfitOnADay[currDeadline] = profit[indexes[i]];
                    maxProfit += profit[indexes[i]];
                    noOfDays += 1;
                    break;
                }
                currDeadline--;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(noOfDays);
        ans.add(maxProfit);
        return ans;


    }
}
