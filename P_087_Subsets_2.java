import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_087_Subsets_2 {

    // Todo: https://leetcode.com/problems/subsets-ii/

    // * T.C = O(2^n) & S.C = O(n*2^n).
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        // Sort the input array to handle duplicates efficiently
        Arrays.sort(nums);

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
            // Skip duplicates to avoid duplicate subsets
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            // Include the current element in the subset
            currentSubset.add(nums[i]);

            // Recursively generate subsets with the current element included
            generateSubsets(nums, i + 1, currentSubset, result);

            // Exclude the current element to backtrack and explore other subsets
            currentSubset.remove(currentSubset.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 2 };
        List<List<Integer>> subsets = subsetsWithDup(nums);

        // Print the result
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}
