package dsa.greedyAlgorithm;

import java.util.Arrays;

class L10_Minimum_No_Of_Platforms_Required {
    public int minPlatform(int arr[], int dep[]) {
        //  code here
        Arrays.sort(arr);
        Arrays.sort(dep);

        int i = 0;
        int j= 0;
        int ans = 0;
        int count = 0;
        while(i<arr.length) {
            if(arr[i] <= dep[j]) {
                count++;
                i++;
            }
            else{
                count--;
                j++;
            }

            ans = Math.max(ans,count);
        }

        return ans;
    }
}

//TC : O(2nlogn + n)
//SC: O(1)