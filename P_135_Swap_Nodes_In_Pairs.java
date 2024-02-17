public class P_135_Swap_Nodes_In_Pairs {

    // Todo: https://leetcode.com/problems/swap-nodes-in-pairs/

    // * T.C = O(n) & S.C = O(1).
    public static ListNode swapPairs(ListNode head) {
        return reverseKGroup(head, 2);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        // Step 1: Calculate the length of the linked list
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        // Base case: If the remaining nodes are less than k, return head
        if (length < k) {
            return head;
        }

        // Base case: If the linked list is empty, return null
        if (head == null) {
            return null;
        }

        // Step 2: Reverse the first k nodes in the current group
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        int count = 0;
        while (curr != null && count < k) {
            next = curr.next; // Store the next node
            curr.next = prev; // Reverse the current node
            prev = curr; // Move prev to the current node
            curr = next; // Move curr to the next node
            count++;
        }

        // Step 3: Recursively reverse the next group
        if (next != null) {
            head.next = reverseKGroup(next, k);
        }

        // Step 4: Return the new head of the reversed group
        return prev;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(2);
        head1.next = new ListNode(5);
        head1.next.next = new ListNode(13);
        head1.next.next.next = new ListNode(15);
        head1.next.next.next.next = new ListNode(16);
        head1.next.next.next.next.next = new ListNode(24);

        ListNode current = swapPairs(head1);
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
