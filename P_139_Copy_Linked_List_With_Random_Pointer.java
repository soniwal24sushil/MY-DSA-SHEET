public class P_139_Copy_Linked_List_With_Random_Pointer {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    // Todo: https://leetcode.com/problems/copy-list-with-random-pointer/

    // * T.C = O(n) & S.C = O(1).
    public static Node copyRandomList(Node head) {
        if (head == null)
            return null;

        // Step 1: Create a copy of each node and insert it between original nodes
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // Step 2: Set random pointers for the copied nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: Separate the original list from the copied list
        Node original = head;
        Node copied = head.next;
        Node copiedHead = copied;

        while (original != null) {
            original.next = original.next.next;
            if (copied.next != null) {
                copied.next = copied.next.next;
            }
            original = original.next;
            copied = copied.next;
        }

        return copiedHead;
    }

    public static void main(String[] args) {
        // Create example linked list with random pointers
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        head.random = node3; // head's random points to node3
        node2.random = head; // node2's random points to head
        node3.random = node2; // node3's random points to node2
        node4.random = node4; // node4's random points to itself

        // Copy the linked list with random pointers
        Node copiedList = copyRandomList(head);

        // Print the copied list with random pointers
        System.out.println("Original List:");
        printList(head);
        System.out.println("Copied List:");
        printList(copiedList);
    }

    // Helper method to print the linked list with random pointers
    private static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print("Value: " + current.val);
            if (current.random != null) {
                System.out.print(", Random: " + current.random.val);
            } else {
                System.out.print(", Random: null");
            }
            System.out.println();
            current = current.next;
        }
    }
}
