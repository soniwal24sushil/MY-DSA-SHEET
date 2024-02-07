public class P_109_Delete_Node_Without_Head_Pointer {

    // Todo: https://www.geeksforgeeks.org/problems/delete-without-head-pointer/1

    // * T.C = O(1) & S.C = O(1).
    public static void deleteNode(Node node) {
        node.data = node.next.data;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        // Create the linked list: 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Delete 3 from linked list.
        deleteNode(head.next.next);

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
