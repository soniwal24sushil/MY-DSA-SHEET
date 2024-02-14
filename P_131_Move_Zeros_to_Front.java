public class P_131_Move_Zeros_to_Front {

    // Todo: https://www.geeksforgeeks.org/problems/move-all-zeros-to-the-front-of-the-linked-list/1
    
    // * T.C = O(n) & S.C = O(1).
    public static Node moveZeroes(Node head) {
        Node zeros = new Node(-1);
        Node zh = zeros;
        Node nonZeros = new Node(-1);
        Node nh = nonZeros;

        Node temp = head;
        while (temp != null) {
            int val = temp.data;
            if (val == 0) {
                zh.next = temp;
                zh = zh.next;
            } else {
                nh.next = temp;
                nh = nh.next;
            }
            temp = temp.next;
        }
        nh.next = null;
        if (zeros.next == null) {
            return nonZeros.next;
        }
        zh.next = nonZeros.next;
        return zeros.next;
    }

    public static void main(String[] args) {
        // Creating a linked list: 1 -> 0 -> 3 -> 0 -> 4 -> null
        Node head = new Node(1);
        head.next = new Node(0);
        head.next.next = new Node(3);
        head.next.next.next = new Node(0);
        head.next.next.next.next = new Node(4);

        System.out.println("Original linked list:");
        printLinkedList(head);

        // Moving zeroes to the beginning
        Node newHead = moveZeroes(head);

        System.out.println("Linked list after moving zeroes:");
        printLinkedList(newHead);
    }

    public static void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

}
