package dsa.LeetCode.Partition_On_DP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_241_Diff_Way_To_Add_Paranthesis {
    public List<Integer> diffWaysToCompute(String expression) {

        Map<String, List<Integer>> map = new HashMap<>();

        return rec(0, expression.length() -1, expression, map);
    }

    List<Integer> rec(int i, int j, String s, Map<String, List<Integer>> map) {

        String key = i + "," + j;

        if(map.containsKey(key)) {
            return map.get(key);
        }
        boolean isNumber = true;

        for(int k = i; k <= j; k++) {
            if(s.charAt(k) == '+' ||
                    s.charAt(k) == '-' ||
                    s.charAt(k) == '*') {
                isNumber = false;
                break;
            }
        }

        if(isNumber) {
            List<Integer> ans = new ArrayList<>();
            ans.add(Integer.parseInt(s.substring(i, j + 1)));
            return ans;
        }


        List<Integer> ans = new ArrayList<>();

        for(int ind = i+1; ind < j; ind++) {

            if(s.charAt(ind)== '+' || s.charAt(ind) == '-' || s.charAt(ind) == '*') {

                List<Integer> lA = rec(i, ind - 1, s, map);
                List<Integer> rA= rec(ind + 1, j, s, map);



                if(s.charAt(ind) == '*') {
                    List<Integer> ans2 = multiplyLaRa(lA,rA);
                    for(Integer k : ans2) {
                        ans.add(k);
                    }
                }

                else if(s.charAt(ind) == '+') {
                    List<Integer> ans2 =  addLaRa(lA, rA);
                    for(Integer k : ans2) {
                        ans.add(k);
                    }
                }

                else if (s.charAt(ind) == '-')  {
                    List<Integer> ans2 =  subLaRa(lA,rA);
                    for(Integer k : ans2) {
                        ans.add(k);
                    }
                }
            }

        }

        map.put(key, ans);
        return  ans;

    }


    List<Integer> multiplyLaRa(List<Integer> lA, List<Integer> rA) {

        List<Integer> ans = new ArrayList<>();
        for(int i =0; i<lA.size(); i++) {
            for(int j=0;j<rA.size(); j++) {
                ans.add(lA.get(i) * rA.get(j));
            }
        }
        return ans;
    }

    List<Integer> addLaRa(List<Integer> lA, List<Integer> rA) {

        List<Integer> ans = new ArrayList<>();
        for(int i =0; i<lA.size(); i++) {
            for(int j=0;j<rA.size(); j++) {
                ans.add(lA.get(i) + rA.get(j));
            }
        }
        return ans;
    }

    List<Integer> subLaRa(List<Integer> lA, List<Integer> rA) {

        List<Integer> ans = new ArrayList<>();
        for(int i =0; i<lA.size(); i++) {
            for(int j=0;j<rA.size(); j++) {
                ans.add(lA.get(i) - rA.get(j));
            }
        }
        return ans;
    }

}

//public List<Integer> diffWaysToCompute(String expression) {
//    return rec(0, expression.length() -1, expression);
//}
//
//List<Integer> rec(int i, int j, String s) {
//    boolean isNumber = true;
//
//    for(int k = i; k <= j; k++) {
//        if(s.charAt(k) == '+' ||
//                s.charAt(k) == '-' ||
//                s.charAt(k) == '*') {
//            isNumber = false;
//            break;
//        }
//    }
//
//    if(isNumber) {
//        List<Integer> ans = new ArrayList<>();
//        ans.add(Integer.parseInt(s.substring(i, j + 1)));
//        return ans;
//    }
//    List<Integer> ans = new ArrayList<>();
//
//    for(int ind = i+1; ind < j; ind++) {
//
//        if(s.charAt(ind)== '+' || s.charAt(ind) == '-' || s.charAt(ind) == '*') {
//
//            List<Integer> lA = rec(i, ind - 1, s);
//            List<Integer> rA= rec(ind + 1, j, s);
//
//
//
//            if(s.charAt(ind) == '*') {
//                List<Integer> ans2 = multiplyLaRa(lA,rA);
//                for(Integer k : ans2) {
//                    ans.add(k);
//                }
//            }
//
//            else if(s.charAt(ind) == '+') {
//                List<Integer> ans2 =  addLaRa(lA, rA);
//                for(Integer k : ans2) {
//                    ans.add(k);
//                }
//            }
//
//            else if (s.charAt(ind) == '-')  {
//                List<Integer> ans2 =  subLaRa(lA,rA);
//                for(Integer k : ans2) {
//                    ans.add(k);
//                }
//            }
//        }
//
//    }
//
//    return ans;
//
//}
//
//
//List<Integer> multiplyLaRa(List<Integer> lA, List<Integer> rA) {
//
//    List<Integer> ans = new ArrayList<>();
//    for(int i =0; i<lA.size(); i++) {
//        for(int j=0;j<rA.size(); j++) {
//            ans.add(lA.get(i) * rA.get(j));
//        }
//    }
//    return ans;
//}
//
//List<Integer> addLaRa(List<Integer> lA, List<Integer> rA) {
//
//    List<Integer> ans = new ArrayList<>();
//    for(int i =0; i<lA.size(); i++) {
//        for(int j=0;j<rA.size(); j++) {
//            ans.add(lA.get(i) + rA.get(j));
//        }
//    }
//    return ans;
//}
//
//List<Integer> subLaRa(List<Integer> lA, List<Integer> rA) {
//
//    List<Integer> ans = new ArrayList<>();
//    for(int i =0; i<lA.size(); i++) {
//        for(int j=0;j<rA.size(); j++) {
//            ans.add(lA.get(i) - rA.get(j));
//        }
//    }
//    return ans;
//}