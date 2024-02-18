public class P_138_Intersection_of_Two_Linked_Lists {

    // Todo: https://leetcode.com/problems/intersection-of-two-linked-lists/

    // * T.C = O(n) & S.C = O(1).
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Base case: if any of the lists is empty, there is no intersection
        if (headA == null || headB == null)
            return null;

        // Pointers for both lists
        ListNode pointerA = headA;
        ListNode pointerB = headB;

        // Traverse both lists until they intersect or reach the end
        while (pointerA != pointerB) {
            // If pointerA reaches the end of listA, move it to the beginning of listB
            if (pointerA == null)
                pointerA = headB;
            else
                pointerA = pointerA.next;

            // If pointerB reaches the end of listB, move it to the beginning of listA
            if (pointerB == null)
                pointerB = headA;
            else
                pointerB = pointerB.next;
        }
        return pointerA;
    }

    public static void main(String[] args) {
        // Create example linked lists
        ListNode intersectionNode = new ListNode(8);
        intersectionNode.next = new ListNode(4);
        intersectionNode.next.next = new ListNode(5);

        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = intersectionNode;

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = intersectionNode;

        // Find the intersection node
        ListNode intersection = getIntersectionNode(headA, headB);

        // Print the value of the intersection node if found, otherwise print null
        if (intersection != null)
            System.out.println("Intersection node value: " + intersection.val);
        else
            System.out.println("No intersection node found.");
    }
}
