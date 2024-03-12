import java.util.LinkedList;
import java.util.Queue;

import TreeClasses.TreeNode;

public class P_177_Count_Nodes_in_Binary_Tree {

    // Todo: https://leetcode.com/problems/count-complete-tree-nodes/

    // * Using BFS => T.C = O(n) & S.C = O(n).
    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            count++;
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
        return count;
    }

    // ^ Using DFS => T.C = O(n) & S.C = O(n).
    public static int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = countNodes2(root.left);
        int right = countNodes2(root.right);
        return left + right + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(countNodes2(root));
    }
}
