package dsa.BinarySearchProg;

public class L20_Medium_Of_Sorted_Arrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n1 = nums1.length;
        int n2 = nums2.length;

        if(n1> n2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int start = 0;
        int end = n1;
        int median = (n1 + n2 + 1)/2 ;

        while(start <= end) {
            int mid1 = (start + end) / 2;
            int mid2 = median - mid1;

            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;

            if(mid1 - 1 >= 0) {
                l1 = nums1[mid1 - 1];
            }
            if(mid1 < n1) {
                r1 = nums1[mid1];
            }
            if(mid2 - 1 >= 0) {
                l2 = nums2[mid2 - 1];
            }
            if(mid2 < n2) {
                r2 = nums2[mid2];
            }


            if(l1<= r2 && l2 <= r1) {
                if ((n1 + n2) % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2))/2.0;
                }
                else {
                    return Math.max(l1, l2);
                }
            }
            else if(l1 > r2) {
                end = mid1 - 1;
            }
            else{
                start = mid1 + 1;
            }
        }

        return 0;


    }
}

// TC : O(log(min(n1, n2)))
//SC : O(1)

//public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//    int ind1 = 0;
//    int ind2 = 0;
//    int sum = (nums1.length + nums2.length);
//    int medInd1 = (nums1.length + nums2.length) / 2;
//    int medInd2 = medInd1 - 1;
//    int med1 = 0;
//    int med2 = 0;
//    int count = 0;
//
//    while(ind1<nums1.length && ind2<nums2.length) {
//        if(nums1[ind1] <= nums2[ind2]) {
//            if(count == medInd1) {
//                med1 = nums1[ind1];
//            }
//            else if(count == medInd2) {
//                med2 = nums1[ind1];
//            }
//            ind1++;
//            count++;
//
//        }
//        else {
//            if(count == medInd1) {
//                med1 = nums2[ind2];
//            }
//            else if(count == medInd2) {
//                med2 = nums2[ind2];;
//            }
//            ind2++;
//            count++;
//        }
//    }
//
//    while( ind1< nums1.length) {
//        if(count == medInd1) {
//            med1 = nums1[ind1];
//        }
//        else if(count == medInd2) {
//            med2 = nums1[ind1];
//        }
//        ind1++;
//        count++;
//    }
//    while( ind2< nums2.length) {
//        if(count == medInd1) {
//            med1 = nums2[ind2];
//        }
//        else if(count == medInd2) {
//            med2 = nums2[ind2];
//        }
//        ind2++;
//        count++;
//    }
//
//    if (sum % 2 == 0) {
//        return (double)(med1 + med2) / 2.0;
//    }
//    return med1;
//}

//TC : O(n1 + n2)
//SC : O(1)