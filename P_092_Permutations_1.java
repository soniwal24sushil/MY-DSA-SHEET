import java.util.ArrayList;
import java.util.List;

public class P_092_Permutations_1 {

    // Todo: https://leetcode.com/problems/permutations/

    // * T.C = O(N * N!), S.C = O(N).
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPermutation = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        generatePermutations(nums, used, currentPermutation, result);

        return result;
    }

    private static void generatePermutations(int[] nums, boolean[] used, List<Integer> currentPermutation,
            List<List<Integer>> result) {
        // Base case: If the current permutation is of the same size as the input array,
        // add it to the result.
        if (currentPermutation.size() == nums.length) {
            result.add(new ArrayList<>(currentPermutation));
            return;
        }

        // Iterate through the numbers and try to add each unused number to the current
        // permutation.
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                // Include the current number in the permutation.
                currentPermutation.add(nums[i]);
                used[i] = true; // Mark the current number as used.

                // Recursively generate permutations with the updated state.
                generatePermutations(nums, used, currentPermutation, result);

                // Backtrack: Remove the last added number to try a different permutation.
                currentPermutation.remove(currentPermutation.size() - 1);
                used[i] = false; // Mark the current number as unused for the next iteration.
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        List<List<Integer>> result = permute(nums);

        System.out.println("All permutations:");
        for (List<Integer> permutation : result) {
            System.out.println(permutation);
        }
    }
}
