1. Longest SubArraySUm = K ======> TwoPointer approach
2. 2 Sum ====> Sort and two pointer / Use Map approach
3. Sort 0 1 2 ====> Dutch National Flag Algorithm
4. MajortiyElement ===> Use ans ans count logic
5. Maximum_SubArray_Sum ===> Kadane'sAlgo (single loop go on calculate sum if less than 0 then sum is 0)
6. Rearrange arrayelements by sign ===> if both are eqaul use O(n) without space if not use arrays to spit neg and pos and merge
7. Best Time to buy and sell stock ====> Use logic keep buy always small and calculate profit
8. Next Permutation =====> find the first ascending no from last and sawp that with the fisrt no greater than that from last and sort the remaining no
9. LeaderInArray(Eements which is grater than ele present In right) ====> Kepp max element while looping from last if no is gretae then add to ans
10. Longest COnsecutive No sequence ====> Add all elements into set , iterate set then check if it is the samallest value of the consecutive one and then check for next elemnesnts
11. SetMatrixZero : we try to set the first col and first row as indicator to know which row and col to update but mat[0][0] wi be acting for both first row and first col , so we keep seprate row0 for first row
12. RotateBy90degress : reverse each row and then swap mat[i][j] = mat[j][i] or use formula newMat[i][j] = mat[j][n-i-1]














1. Max_Points_Obtain_From Cards (Pick card either from start or end) : sum first k elements and then slide window backward and find ans
2. Longest_SubString_Without_Repeating_Characters : Use map or array to store index if it is already present put i pointer to the prev + 1 (Edge case : abcdbae) when second time b comes eft pointer will be at c then when a comes it should not go back to b
3. MaxConsecutiveOnes3(flip k 0 to 1): Use pointer left and rightt move right till u flip k 0's then move left pointer til you can fip other 0
4. Fruits_Into_Basket(Only 2 basket ocnsecutive fruits to put of same type in each basket): Take 2 pointers move right right pointer and put eah fruit and count in the map if map size gretaer than 2 remove the left pointer fruit in map
5. Longest Substring With At Most K Distinct Characters : Same as Fruit In_to_Basket (Instead of 2 K)
6. No of substrings cotaining all 3 characters(a,b,c) : keep var a =-1, b=-1, c= -1 loop each char and set the index for a, b,c and sum the min index of a,b,c +1
7. Longest Repeating Character With Replacement : keep count of max count and total count if  totalcount - max count > k the traverse left pointer andr ecalculate max and total till total - max <=k
8. No of BinarySubArray with sum = K : no of subarraylessthan=tok - no of subarraylessthanorequaltok-1(add sum using right pointer if sum > k use leftpointer to subtract, count right -left+1 to sum on exch step lessthan or equal to k)
9. Count Number of Nice Subarrays (no of sub arrays which contians exactly k odd nos) : Similar to above sum no of sub array with sum = k (trret even as 0 and ood as 1)
10. SubArray_With_K_Diff_Integers : subarraysWithLessThanOrEqualToKDistinct(nums, k) - subarraysWithLessThanOrEqualToKDistinct(nums, k-1) (keep map and add elements and their count if map.size() excceds k use left pointer tot reduce count and decrease map size)
11. Min Window Substring(Given a string t and s need to find the min window from s which contains t) : in map first count the freq of t , then loop s and subract, if count of char greater than 0 then add it as cnt , if cnt == t.length() start calcuating ans and iterate left and add freq



8. Trapping_Rain_Water: Approach 1 : for a element find the largesteement from both left and right and ans += Math.min(rl[i], ll[i]) - height[i]
                        Approach2 : Use left and right pointers find left max and right max whichever is min cal ans+=leftmin-height[left] or ans+=rightmin-height[i]
9. Sum Of SubArrayMinimum : Find pse and nse for all elements and ans += (i-pse[i])(nse[i] - i)(arr[i])
10. Sum of sub array arranges : Similar concept of 9. SUm of Subarray min 
11. Asteroid Collision : If negative and st.peek is positive and less than abs then pop , if negative and st.peek() is positive and abs is same pop and continue for others add into stack
12. Largest Rectangle in Histogram : Find the preSmaller element and nextsmaller element in soingle loop and calculate
13. Maximal Rectangle : same as Largest rectangle in histagram but as a matrix
14. Remove K digits : Pop from stack if the current eement is less than or equal to st.peek() and trim front 0s
15. StackSpanProblem : Same as finding prevGreaterIndex
16. Sliding Window Maximum : Use array deque and add elements at last such that front should have the max winodw if the stack size excecds window size remove from front
17. 