package dsa.GFG.puzzle;

import java.util.*;

public class L3_Is_Square {
    boolean isSquare(int points[][]) {
        // code here
        int[] p1 = points[0];
        int[] p2 = points[1];
        int[] p3 = points[2];
        int[] p4 = points[3];
        List<Long> ans = new ArrayList<>();
        ans.add(findDistance(p1,p2));
        ans.add(findDistance(p2,p3));
        ans.add(findDistance(p3,p4));
        ans.add(findDistance(p1,p4));
        ans.add(findDistance(p1,p3));
        ans.add(findDistance(p2,p4));

        Collections.sort(ans);

        return ans.get(0) > 0 &&
                ans.get(0).equals(ans.get(1)) &&
                ans.get(1).equals(ans.get(2)) &&
                ans.get(2).equals(ans.get(3)) &&
                ans.get(4).equals(ans.get(5));




    }

    long findDistance(int[] p1, int[] p2) {

        long x1 = p1[0];
        long y1 = p1[1];
        long x2 = p2[0];
        long y2 = p2[1];

        return (y2-y1)*(y2-y1) + (x2-x1)*(x2-x1);
    }
}

//TC : O(1)
//SC : O(1)

//Calcuate the distance for all sides and diagnols sort them first 4 will be sides next 2 will be diagnols