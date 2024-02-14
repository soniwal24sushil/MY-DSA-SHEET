public class P_130_Add_One_To_The_LinkedList {

    // Todo: https://practice.geeksforgeeks.org/problems/add-1-to-a-number-represented-as-linked-list/1

    // * T.C = O(n) & S.C = O(1).
    public static Node addOne(Node head) {
        Node rev_head = reverseList(head);
        Node temp = rev_head;
        while (temp != null) {
            if (temp.data >= 0 && temp.data < 9) {
                temp.data += 1;
                break;
            } else {
                temp.data = 0;
                temp = temp.next;
            }
        }
        head = reverseList(rev_head);
        if (head.data == 0) {
            Node node = new Node(1);
            node.next = head;
            head = node;
        }
        return head;
    }

    public static Node reverseList(Node head) {
        Node currNode = head;
        Node prevNode = null;
        while (currNode != null) {
            Node temp = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = temp;
        }
        return prevNode;
    }

    public static void main(String[] args) {
        Node head1 = new Node(9);
        head1.next = new Node(9);
        head1.next.next = new Node(9);

        Node res = addOne(head1);
        Node current = res;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
