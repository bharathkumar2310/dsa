package dsa.stack;

import java.util.Stack;

public class L4_Implement_Min_Stack {
    private Stack<Long> st;
    private long min;

    public L4_Implement_Min_Stack() {
        st = new Stack<>();
    }

    public void push(int val) {

        if(st.isEmpty()) {
            st.push((long) val);
            min = val;
            return;
        }

        if(val >= min) {
            st.push((long) val);
        } else {

            long encoded = 2L * val - min;

            st.push(encoded);
            min = val;
        }
    }

    public void pop() {

        long top = st.pop();

        if(top < min) {
            min = 2 * min - top;
        }
    }

    public int top() {

        long top = st.peek();

        if(top < min) {
            return (int) min;
        }

        return (int) top;
    }

    public int getMin() {
        return (int) min;
    }
}

//ALL op _> O(1)