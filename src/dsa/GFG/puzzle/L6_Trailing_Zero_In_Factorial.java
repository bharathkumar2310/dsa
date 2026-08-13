package dsa.GFG.puzzle;

public class L6_Trailing_Zero_In_Factorial {
    public static int trailingZeroes(int n) {
        // code here
        int ans  = 0;
        while(n>0) {
            n/=5;
            ans+= n;
        }

        return ans;
    }
}

//TC: O(log₅ n)
//SC: O(1)




//Step 1: What creates a trailing zero?
//
//A trailing zero comes from multiplying by 10.
//
//        10=2×5
//
//So every pair of (2, 5) gives one trailing zero.
//
//Example:
//
//        2 × 5 = 10 → 1 trailing zero
//Step 2: Where do these 2s and 5s come from?
//
//Take 10!
//
//        10! = 1 × 2 × 3 × 4 × 5 × 6 × 7 × 8 × 9 × 10
//
//Prime factors:
//
//        2 = 2
//        4 = 2 × 2
//        5 = 5
//        6 = 2 × 3
//        8 = 2 × 2 × 2
//        10 = 2 × 5
//
//Notice:
//
//Lots of 2s
//Very few 5s
//
//So the 5s run out first.
//
//That means:
//
//Trailing zeros are limited by the number of 5s.
//
//We don't need to count 2s.
//
//Step 3: Count how many 5s exist
//
//For 10!
//
//Numbers divisible by 5 are:
//
//        5
//        10
//
//Each contributes one factor of 5.
//
//        5  → one 5
//        10 → one 5
//
//Total = 2 trailing zeros.
//
//Step 4: What about 25?
//
//Now consider 25!
//
//Multiples of 5 are:
//
//        5
//        10
//        15
//        20
//        25
//
//At first glance:
//
//        5 numbers → 5 fives
//
//But look carefully:
//
//        25 = 5 × 5
//
//It contributes two factors of 5.
//
//So total becomes:
//
//        5
//        10
//        15
//        20
//        25 (two 5s)
//
//Total = 6 fives
//
//That's why we add:
//
//        25/5 = 5
//        25/25 = 1
//
//Total = 6
//Step 5: What about 125?
//        125 = 5 × 5 × 5
//
//It contributes three factors of 5.
//
//That's why we keep dividing by powers of 5:
//
//n/5
//n/25
//n/125
//n/625
//        ...
//
//Each division counts additional factors of 5 from numbers that contain multiple 5s.
//
//        Visual Intuition
//
//For 100!
//
//Multiples of 5
//
//        5
//        10
//        15
//        20
//        25
//        30
//        35
//        40
//        45
//        50
//        55
//        60
//        65
//        70
//        75
//        80
//        85
//        90
//        95
//        100
//
//There are:
//
//        100/5 = 20
//
//But among them,
//
//        25
//        50
//        75
//        100
//
//contain an extra 5.
//
//So add
//
//100/25 = 4
//
//Total = 24.