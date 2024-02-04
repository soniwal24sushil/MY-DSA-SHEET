import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_097_Combination_Sum_2 {

    // Todo: https://leetcode.com/problems/combination-sum-ii/

    // * T.C = O(2^n) & S.C = O(n).
    public static List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums, target, 0);
        return result;
    }

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
                if (i > start && nums[i] == nums[i - 1])
                    continue;
                tempList.add(nums[i]); // Include the current element in the combination
                backtrack(result, tempList, nums, remain - nums[i], i + 1); // Recursive call with updated parameters
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = { 10,1,2,7,6,1,5 };
        int target = 8;
        List<List<Integer>> result = combinationSum2(candidates, target);
        System.out.println(result);
    }
}
