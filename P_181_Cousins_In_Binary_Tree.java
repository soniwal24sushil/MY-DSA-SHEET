import java.util.LinkedList;
import java.util.Queue;

import TreeClasses.TreeNode;

public class P_181_Cousins_In_Binary_Tree {

    // Todo: https://leetcode.com/problems/cousins-in-binary-tree/

    // * T.C = O(n) & S.C = O(n).
    public static boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean foundX = false;
            boolean foundY = false;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                // Check if current node's children are x and y
                if (node.left != null && node.right != null) {
                    if ((node.left.val == x && node.right.val == y) ||
                            (node.left.val == y && node.right.val == x))
                        return false; // x and y are siblings
                }

                // Check if x or y is found in current level
                if (node.val == x)
                    foundX = true;
                if (node.val == y)
                    foundY = true;

                // Add children of current node to the queue
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }

            // If both x and y are found in current level
            if (foundX && foundY)
                return true;
            // If only one of x or y is found in current level
            if (foundX || foundY)
                return false;
        }

        return false; // x or y not found in the tree
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(isCousins(root, 5, 6));
    }
}
