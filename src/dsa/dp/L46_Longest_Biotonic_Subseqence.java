package dsa.dp;

public class L46_Longest_Biotonic_Subseqence {
    public static int longestBitonicSequence(int n, int[] nums) {

        int[] lis = new int[n];
        int[] lds = new int[n];

        // LIS from left
        for (int i = 0; i < n; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }

        // LDS from right
        for (int i = n - 1; i >= 0; i--) {
            lds[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            if (lis[i] > 1 && lds[i] > 1) {
                max = Math.max(max, lis[i] + lds[i] - 1);
            }
        }

        return max;
    }
}
