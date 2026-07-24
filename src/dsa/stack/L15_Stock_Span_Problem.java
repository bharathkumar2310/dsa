package dsa.stack;

import java.util.Stack;

public class L15_Stock_Span_Problem {

    class Pair {
        int ele;
        int index;

        Pair(int ele, int index) {
            this.ele = ele;
            this.index = index;
        }
    }

    Stack<Pair> stack;
    int ind;

    public L15_Stock_Span_Problem() {
        stack = new Stack<>();
        ind = 0;
    }

    public int next(int price) {
        while(!stack.isEmpty() &&  price >= stack.peek().ele) {
            stack.pop();
        }

        int peekIndex = stack.isEmpty() ? -1 : stack.peek().index;
        stack.add(new Pair(price, ind));
        int ans = ind -peekIndex;
        ind++;
        return ans;


    }
}

//TC : O(1)
//SC : O(n)