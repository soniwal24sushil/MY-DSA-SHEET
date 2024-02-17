public class P_134_Swap_Nodes {

    // Todo: https://leetcode.com/problems/swapping-nodes-in-a-linked-list/

    // * T.C = O(n) & S.C = O(1).
    public static ListNode swapNodes(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy, slow = dummy, first = dummy, second = dummy;

        // Move fast pointer to the kth node from the beginning
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        first = fast;

        // Move fast pointer to the end, maintaining the distance of k
        while (fast != null) {
            fast = fast.next;
            second = slow;
            slow = slow.next;
        }

        // Swap the values
        int temp = first.val;
        first.val = second.next.val;
        second.next.val = temp;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(2);
        head1.next = new ListNode(5);
        head1.next.next = new ListNode(13);
        head1.next.next.next = new ListNode(15);
        head1.next.next.next.next = new ListNode(16);
        head1.next.next.next.next.next = new ListNode(24);

        ListNode current = swapNodes(head1, 3);
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
