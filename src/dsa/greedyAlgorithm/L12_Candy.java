package dsa.greedyAlgorithm;

class L12_Candy {
    public int candy(int[] arr) {

        int last = arr[0];

        int i =1;

        int sum = 1;

        while(i<arr.length) {

            if(i< arr.length && arr[i] == arr[i-1]) {
                sum+=1;
                i++;
                continue;
            }

            int peak = 1;
            int down = 1;

            while(i< arr.length && arr[i] > arr[i-1]) {
                peak++;
                sum += peak;
                i++;

            }

            while(i< arr.length && arr[i] < arr[i-1]) {
                sum += down;
                down++;
                i++;
            }

            if(down > peak) {
                sum += down - peak;
            }

        }
        return sum;
    }
}

//TC : O(n) //SC : O(1)

// non optimal approach
//public int candy(int[] arr) {
//    int[] left = new int[arr.length];
//    int[] right = new int[arr.length];
//    int ans = 0;
//    left[0] = 1;
//    right[arr.length - 1] = 1;
//
//    for(int i=1; i<left.length; i++) {
//        if(arr[i] > arr[i-1]) {
//            left[i] = left[i-1] + 1;
//        }
//        else{
//            left[i] = 1;
//        }
//    }
//
//    for(int i=right.length -2; i>=0; i--) {
//        if(arr[i] > arr[i+1]) {
//            right[i] = right[i+1] + 1;
//        }
//        else{
//            right[i] = 1;
//        }
//    }
//
//    for(int i=right.length -1; i>=0; i--) {
//        ans += Math.max(right[i], left[i]);
//    }
//    return ans;
//}