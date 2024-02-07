public class P_110_Length_of_Linked_List {

    // Todo: https://www.geeksforgeeks.org/problems/linked-list-length-even-or-odd/1

    // * T.C = O(n) & S.C = O(1).
    public static int isLengthEvenorOdd1(Node head1) {
        int c = 0;
        Node temp = head1;
        while (temp != null) {
            c++;
            temp = temp.next;
        }
        if (c % 2 == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    // ^ T.C = O(n) & S.C = O(1).
    public static int isLengthEvenorOdd2(Node head1) {
        Node slow = head1, fast = head1;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == null) {
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        // Create the linked list: 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        int num = isLengthEvenorOdd2(head);
        if (num == 1) {
            System.out.println("Odd");
        } else {
            System.out.println("Even");
        }
    }
}
