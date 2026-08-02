package dsa.GFG.puzzle;

public class L8_No_Of_Open_Doors {
    static int noOfOpenDoors(int n) {
        // code here
        return (int)(Math.sqrt(n));
    }
}

//TC : O(1)
//SC : O(1)


//
//here are n doors.
//
//Initially:
//
//All doors are closed.
//
//Pass 1:
//
//Toggle every door.
//
//        Pass 2:
//
//Toggle every 2nd door.
//
//Pass 3:
//
//Toggle every 3rd door.
//
//        ...
//
//Pass n:
//
//Toggle only door n.
//
//Find how many doors remain open.
//
//Example (n = 10)
//
//Initially
//
//C C C C C C C C C C
//
//Pass 1
//
//O O O O O O O O O O
//
//Pass 2
//
//        1 2 3 4 5 6 7 8 9 10
//
//O C O C O C O C O C
//
//Pass 3
//
//Toggle
//
//3 6 9
//
//Continue...
//
//Key Observation
//
//Let's see Door 12.
//
//It gets toggled when:
//
//        1 divides 12
//
//        2 divides 12
//
//        3 divides 12
//
//        4 divides 12
//
//        6 divides 12
//
//        12 divides 12
//
//So
//
//Door 12
//
//toggles 6 times
//
//because it has
//
//1,2,3,4,6,12
//
//divisors.
//
//        Door 15
//
//        1
//
//        3
//
//        5
//
//        15
//
//        4 divisors
//
//toggles 4 times.
//
//        Rule
//
//A door is
//
//        Open
//
//if it is toggled an
//
//Odd
//
//number of times.
//
//Closed otherwise.
//
//Which numbers have an odd number of divisors?
//
//Normally divisors occur in pairs.
//
//        Example
//
//12
//
//        1 × 12
//
//        2 × 6
//
//        3 × 4
//
//Pairs
//
//        (1,12)
//
//(2,6)
//
//        (3,4)
//
//Total = 6 divisors (Even)
//
//Take
//
//16
//
//Divisors
//
//1 ×16
//
//        2 ×8
//
//        4 ×4
//
//Notice
//
//4 pairs with itself
//
//        because
//
//√16 = 4
//
//So divisors are
//
//1
//
//2
//
//4
//
//8
//
//16
//
//Total = 5 (Odd)
//
//Another
//
//25
//        1
//
//        5
//
//        25
//
//        3 divisors.
//
//        Only
//
//Perfect Squares
//
//have an odd number of divisors.
//
//Therefore
//
//Open doors are
//
//1
//
//4
//
//9
//
//16
//
//25
//
//...
//
//Answer
//
//Number of perfect squares ≤ n
//
//which is
//
//⌊√n⌋