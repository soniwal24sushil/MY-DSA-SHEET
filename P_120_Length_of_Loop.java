public class P_120_Length_of_Loop {

    // Todo: https://www.geeksforgeeks.org/problems/find-length-of-loop/1

    // * T.C = O(n) & S.C = O(1).
    public static int countNodesinLoop(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // Step 2: Cycle detected, now calculate the cycle's length.
                fast = fast.next;
                int count = 1;
                while (fast != slow) {
                    fast = fast.next;
                    count++;
                }
                return count; // Return the count.
            }
        }

        // If no cycle is found return 0.
        return 0;
    }

    public static void main(String[] args) {
        // Create a sample linked list with a cycle
        Node head = new Node(3);
        Node node1 = new Node(2);
        Node node2 = new Node(0);
        Node node3 = new Node(-4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;

        System.out.println(countNodesinLoop(head));
    }
}