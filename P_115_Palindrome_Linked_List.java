public class P_115_Palindrome_Linked_List {

    // Todo: https://leetcode.com/problems/palindrome-linked-list/

    // * T.C = O(n) & S.C = O(1).
    public static boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;

        // Find the middle of the list using fast and slow pointers
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // Reverse the second half of the list
        ListNode reversedSecondHalf = reverseList(slow);

        // Compare the first half with the reversed second half
        ListNode current = head;
        while (current != null && reversedSecondHalf != null) {
            if (current.val != reversedSecondHalf.val) {
                return false;
            }
            current = current.next;
            reversedSecondHalf = reversedSecondHalf.next;
        }

        return true;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        // Reverse the list
        while (current != null) {
            ListNode nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }

        return prev; // Return the new head of the reversed list
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        System.out.println(isPalindrome(head));
    }
}
