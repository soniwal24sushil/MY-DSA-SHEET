public class P_128_Insertion_Sort_LinkedList {

    // Todo: https://leetcode.com/problems/insertion-sort-list/

    // * T.C = O(n^2) & S.C = O(1).
    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(0); // Dummy node to mark the beginning of the sorted list
        ListNode prevSorted = dummy; // Pointer to the last node of the sorted list

        while (head != null) {
            ListNode nextNode = head.next; // Store the next node to avoid losing it

            // Find the position to insert the current node in the sorted list
            while (prevSorted.next != null && prevSorted.next.val < head.val) {
                prevSorted = prevSorted.next;
            }

            // Insert the current node in the sorted list
            head.next = prevSorted.next;
            prevSorted.next = head;

            // Reset pointers for the next iteration
            head = nextNode;
            prevSorted = dummy; // Reset prevSorted to the beginning of the sorted list
        }

        return dummy.next; // Return the sorted list starting from the next of the dummy node
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(5);

        ListNode temp = insertionSortList(head);

        while (temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println("End");
    }
}
