package dsa.strings;

public class L6_Rotate_String {
    public boolean rotateString(String s, String goal) {

        if(s.length() != goal.length()) {
            return false;
        }
        String s1 = s + s;
        if(s1.contains(goal)) {
            return true;
        }

        return false;
    }
}

//TC : O(2n)
//SC : O(2n)

