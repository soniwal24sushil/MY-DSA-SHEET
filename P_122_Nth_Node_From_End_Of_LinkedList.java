public class P_122_Nth_Node_From_End_Of_LinkedList {

    // Todo: https://www.geeksforgeeks.org/problems/nth-node-from-end-of-linked-list/1

    // * T.C = O(n) & S.C = O(1).
    public static int getNthFromLast(Node head, int n) {
        Node start = new Node(-1);
        start.next = head;
        Node fast = start, slow = start;

        for (int i = 1; i <= n; i++) {
            fast = fast.next;
            if (fast == null)
                return -1;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow.next.data;
    }

    public static void main(String[] args) {
        Node head = new Node(17);
        head.next = new Node(15);
        head.next.next = new Node(8);
        head.next.next.next = new Node(9);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(4);
        head.next.next.next.next.next.next = new Node(6);

        System.out.println(getNthFromLast(head, 3));
    }

}
