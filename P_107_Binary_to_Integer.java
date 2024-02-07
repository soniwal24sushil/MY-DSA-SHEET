public class P_107_Binary_to_Integer {

    // Todo: https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/

    // * T.C = O(n) & S.C = O(1).
    public static int getDecimalValue(ListNode head) {
        int num = 0;
        ListNode temp = head;
        while (temp != null) {
            num = num * 2 + temp.val; // Use base 2 for binary conversion
            temp = temp.next;
        }
        return num;
    }

    public static void main(String[] args) {
        // Create the linked list: 1 -> 0 -> 1
        ListNode node3 = new ListNode(1);
        ListNode node2 = new ListNode(0, node3);
        ListNode node1 = new ListNode(1, node2);

        System.out.println(getDecimalValue(node1));
    }

}
