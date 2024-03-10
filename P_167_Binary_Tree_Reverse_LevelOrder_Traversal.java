import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import TreeClasses.TreeNode;

public class P_167_Binary_Tree_Reverse_LevelOrder_Traversal {

    // Todo: https://leetcode.com/problems/binary-tree-level-order-traversal-ii/

    // * T.C = O(n) & S.C = O(n).
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            // Process all nodes at the current level.
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);

                // Add the child nodes to the queue for processing in the next level.
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            result.add(0, currentLevel);
        }

        return result;
    }

    public static void main(String[] args) {
        // Create a sample binary tree for testing.
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // Get the level order traversal of the binary tree.
        List<List<Integer>> result = levelOrderBottom(root);

        // Print the result.
        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }
}
