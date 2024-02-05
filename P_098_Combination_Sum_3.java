import java.util.ArrayList;
import java.util.List;

public class P_098_Combination_Sum_3 {

    // Todo: https://leetcode.com/problems/combination-sum-iii/

    // * T.C = O(9^k) & S.C = O(k).
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), k, n, 1);
        return result;
    }

    // Backtracking function to find combinations
    private static void backtrack(List<List<Integer>> result, List<Integer> tempList, int k, int remain, int start) {
        // Base case: if remaining sum is negative, return
        if (remain < 0) {
            return;
        }
        // Base case: if remaining sum is 0, add the current combination to the result
        else if (remain == 0 && tempList.size() == k) {
            result.add(new ArrayList<>(tempList));
        } else {
            // Explore combinations by iterating through the values from 'start' to 9
            for (int i = start; i <= 9; i++) {
                tempList.add(i); // Include the current element in the combination
                // Recursive call with updated parameters
                backtrack(result, tempList, k, remain - i, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = combinationSum3(3, 7);
        System.out.println(result);
    }
}
