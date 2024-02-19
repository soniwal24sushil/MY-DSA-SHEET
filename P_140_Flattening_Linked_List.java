public class P_140_Flattening_Linked_List {

    static class Node {
        int data;
        Node next;
        Node bottom;

        Node(int d) {
            data = d;
            next = null;
            bottom = null;
        }
    }

    // Todo: geeksforgeeks.org/problems/flattening-a-linked-list/1

    // * T.C = O(n) & S.C = O(n).
    public static Node flatten(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        head.next = flatten(head.next);
        head = merge(head, head.next);
        return head;
    }

    // Function to merge two linked lists
    public static Node merge(Node l1, Node l2) {
        Node dummy = new Node(0);
        Node current = dummy;

        // Traverse both lists until either one becomes null
        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                // Append the smaller value node to the merged list
                dummy.bottom = l1;
                dummy = dummy.bottom;
                l1 = l1.bottom;
            } else {
                dummy.bottom = l2;
                dummy = dummy.bottom;
                l2 = l2.bottom;
            }
        }

        // Attach the remaining nodes of the non-empty list (if any)
        if (l1 != null) {
            dummy.bottom = l1;
        } else {
            dummy.bottom = l2;
        }

        // Return the merged sorted list, skipping the dummy node
        return current.bottom;
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        // Create a sample linked list with bottom pointers
        Node head = new Node(5);
        head.bottom = new Node(7);
        head.bottom.bottom = new Node(8);
        head.bottom.bottom.bottom = new Node(30);

        head.next = new Node(10);
        head.next.bottom = new Node(20);

        head.next.next = new Node(19);
        head.next.next.bottom = new Node(22);
        head.next.next.bottom.bottom = new Node(50);

        head.next.next.next = new Node(28);
        head.next.next.next.bottom = new Node(35);
        head.next.next.next.bottom.bottom = new Node(40);
        head.next.next.next.bottom.bottom.bottom = new Node(45);

        // Flatten the linked list
        head = flatten(head);

        // Print the flattened linked list
        System.out.println("Flattened Linked List:");
        printList(head);
    }

    // Function to print the flattened linked list
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.bottom;
        }
        System.out.println();
    }
}
