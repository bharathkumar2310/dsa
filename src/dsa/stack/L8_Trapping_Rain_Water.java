package dsa.stack;

public class L8_Trapping_Rain_Water {
    public int trap(int[] height) {

        int leftMax = 0;
        int rightMax = 0;
        int left = 0;
        int right = height.length - 1;
        int ans = 0;

        while(left <= right) {
            if(height[left] <= height[right]) {
                if(height[left] < leftMax) {
                    ans += leftMax - height[left];
                } else {
                    leftMax = height[left];
                }
                left++;
            } else {
                if(height[right] < rightMax) {
                    ans += rightMax - height[right];

                }
                else{
                    rightMax = height[right];

                }
                right--;

            }
        }

        return ans;

    }
}

//TC : O(n)
//SC : O(1)


//public int trap(int[] height) {
//    int leftMax = -1;
//    int rightMax = -1;
//    int n = height.length;
//    int[] ls = new int[n];
//    int[] rs = new int[n];
//    for(int i=0; i<n; i++) {
//        if(height[i] > leftMax) {
//            ls[i] = -1;
//        }
//        else {
//            ls[i] = leftMax;
//        }
//        leftMax = Math.max(leftMax,height[i]);
//    }
//
//    for(int i = n-1; i>=0; i--) {
//        if(height[i] > rightMax) {
//            rs[i] = -1;
//        }
//        else {
//            rs[i] = rightMax;
//        }
//        rightMax = Math.max(rightMax,height[i]);
//    }
//
//    int ans = 0;
//
//    for(int i=0;i<n; i++) {
//        if(ls[i] != -1 && rs[i] != -1) {
//            ans += Math.min(ls[i], rs[i]) - height[i];
//        }
//    }
//
//    return ans;
//}


//TC : O(3n)
//SC : O(2n)