import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_096_Combination_Sum_1 {

    // Todo: https://leetcode.com/problems/combination-sum/

    // * T.C = O(2^n) & S.C = O(n).
    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums, target, 0);
        return result;
    }

    // Backtracking function to explore combinations
    private static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int remain,
            int start) {
        // Base case: if remaining sum is negative, return
        if (remain < 0) {
            return;
        }
        // Base case: if remaining sum is 0, add the current combination to the result
        else if (remain == 0) {
            result.add(new ArrayList<>(tempList));
        } else {
            // Explore combinations by iterating through the array starting from 'start'
            for (int i = start; i < nums.length; i++) {
                tempList.add(nums[i]); // Include the current element in the combination
                backtrack(result, tempList, nums, remain - nums[i], i); // Recursive call with updated parameters
                tempList.remove(tempList.size() - 1); // Backtrack: remove the last element to try different
                                                      // combinations
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = { 2, 3, 6, 7 };
        int target = 7;
        List<List<Integer>> result = combinationSum(candidates, target);
        System.out.println(result);
    }
}
