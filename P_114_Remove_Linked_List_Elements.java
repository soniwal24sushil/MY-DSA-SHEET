public class P_114_Remove_Linked_List_Elements {

    // Todo: https://leetcode.com/problems/remove-linked-list-elements/

    // * T.C = O(n) & S.C = O(1).
    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        ListNode node = dummy;

        ListNode current = head;
        while (current != null) {
            if (current.val != val) {
                node.next = current;
                node = current;
            }
            current = current.next;
        }
        node.next = null;
        return dummy.next;
    }

    public static void main(String[] args) {
        // Create the linked list: 1 -> 2 -> 6 -> 3 -> 4 -> 5 -> 6
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);

        removeElements(head, 6);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
