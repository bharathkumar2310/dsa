package dsa.slidingWindow2pointer;

class L2_Max_Cards_You_Can_Obtain_From_Cards {
    public int maxScore(int[] cardPoints, int k) {

        int n = cardPoints.length;
        int sum = 0;

        for (int i = n - k; i < n; i++) {
            sum += cardPoints[i];
        }

        int maxPoints = sum;

        int left = 0;
        int right = n - k;

        for (int i = 0; i < k; i++) {
            sum -= cardPoints[right];
            sum += cardPoints[left];

            right++;
            left++;

            maxPoints = Math.max(maxPoints, sum);
        }

        return maxPoints;
    }
}

//TC : O(2k)
//SC : O(1)
