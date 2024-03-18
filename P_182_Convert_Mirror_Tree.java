import java.util.LinkedList;
import java.util.Queue;
import TreeClasses.Node;

public class P_182_Convert_Mirror_Tree {

    // Todo: https://practice.geeksforgeeks.org/problems/mirror-tree/1

    // * T.C = O(n) & S.C = O(n).
    public static void mirror(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            Node temp = current.left;
            current.left = current.right;
            current.right = temp;

            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        mirror(root);
        System.out.println(root);
    }
}
