import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import TreeClasses.Node;

public class P_175_Left_View_of_Binary_Tree {

    // Todo: https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1

    // * T.C = O(n) & S.C = O(n).
    public static ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                if (i == 0) {
                    ans.add(current.data);
                }

                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }

            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(leftView(root));
    }
}
