public class P_134_Swap_Nodes {

    // Todo: https://leetcode.com/problems/swapping-nodes-in-a-linked-list/

    // * T.C = O(n) & S.C = O(1).
    public static ListNode swapNodes(ListNode head, int k) {
        // Count the total number of nodes in the list
        int count = 0;
        ListNode current = head;
        while (current != null) {
            current = current.next;
            count++;
        }

        // If k is greater than the total number of nodes, no swap needed
        if (count < k) {
            return head;
        }

        // Initialize pointers for the first and last nodes to be swapped
        ListNode preFirst = null, firstNode = head;
        ListNode preSecond = null, secondNode = head;

        // Move pointers to the respective nodes
        for (int i = 0; i < k - 1; i++) {
            preFirst = firstNode;
            firstNode = firstNode.next;
        }

        for (int i = 0; i < count - k; i++) {
            preSecond = secondNode;
            secondNode = secondNode.next;
        }

        // Update pointers to perform the swap
        if (preFirst != null) {
            preFirst.next = secondNode;
        }
        if (preSecond != null) {
            preSecond.next = firstNode;
        }

        // Perform the swap of the nodes
        ListNode temp = firstNode.next;
        firstNode.next = secondNode.next;
        secondNode.next = temp;

        // Update head pointer if k is 1 or n
        if (k == 1) {
            head = secondNode;
        }
        if (count == k) {
            head = firstNode;
        }
        return head;
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
