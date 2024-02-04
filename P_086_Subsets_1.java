import java.util.ArrayList;
import java.util.List;

public class P_086_Subsets_1 {

    // Todo: https://leetcode.com/problems/subsets/

    // * T.C = O(2^n) & S.C = O(n*2^n).
    public static List<List<Integer>> subsets(int[] nums) {
        // Result list to store all subsets
        List<List<Integer>> result = new ArrayList<>();

        // Start with an empty subset
        List<Integer> currentSubset = new ArrayList<>();

        // Begin the recursive process to generate subsets
        generateSubsets(nums, 0, currentSubset, result);

        return result;
    }

    private static void generateSubsets(int[] nums, int index, List<Integer> currentSubset,
            List<List<Integer>> result) {
        // Add the current subset to the result list
        result.add(new ArrayList<>(currentSubset));

        // Explore all possible subsets by iterating through the array
        for (int i = index; i < nums.length; i++) {
            // Include the current element in the subset
            currentSubset.add(nums[i]);

            // Recursively generate subsets with the current element included
            generateSubsets(nums, i + 1, currentSubset, result);

            // Exclude the current element to backtrack and explore other subsets
            currentSubset.remove(currentSubset.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        List<List<Integer>> sol = subsets(arr);
        System.out.println(sol);
    }
}
