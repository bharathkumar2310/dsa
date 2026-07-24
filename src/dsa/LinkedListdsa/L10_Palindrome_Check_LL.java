package dsa.LinkedListdsa;

public class L10_Palindrome_Check_LL {

    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }



        fast = reverseList(slow.next);
        slow = head;
        while(fast !=  null) {
            if(slow.val != fast.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }

        return true;
    }


    public ListNode reverseList(ListNode head) {
        ListNode node = head;
        ListNode prev = null;
        while(node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }
}


// or you can pop all element in stack and compare st.top() from head