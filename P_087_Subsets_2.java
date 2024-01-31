import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_087_Subsets_2 {

    // Todo: https://leetcode.com/problems/subsets-ii/

    // * T.C = O(2^n) & S.C = O(n).
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort the array to handle duplicates
        generateSubsets(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private static void generateSubsets(int[] nums, int index, List<Integer> currentSubset,
            List<List<Integer>> result) {
        result.add(new ArrayList<>(currentSubset));

        for (int i = index; i < nums.length; i++) {
            // Skip duplicates to ensure distinct subsets
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            currentSubset.add(nums[i]);
            generateSubsets(nums, i + 1, currentSubset, result);
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
