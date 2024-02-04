import java.util.ArrayList;

public class P_089_Subset_Sums_2 {

    // Todo: https://www.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1

    // * T.C = O(2^n) & S.C = O(2^n) {TLE},
    public static Boolean isSubsetSum(int n, int arr[], int target) {
        // Generate all subset sums
        ArrayList<Integer> sums = subsetSums(arr, n);

        // Check if the target sum exists in the subset sums
        for (Integer sum : sums) {
            if (sum == target) {
                return true;
            }
        }
        return false;
    }

    private static ArrayList<Integer> subsetSums(int[] arr, int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        // Recursive function to generate subset sums
        solve(arr, 0, n, ans, 0);
        return ans;
    }

    private static void solve(int[] arr, int idx, int n, ArrayList<Integer> ans, int sum) {
        // Base case: Add the current sum to the result when reaching the end of the
        // array
        if (idx == n) {
            ans.add(sum);
            return;
        }

        // Include the current element in the subset and recurse
        solve(arr, idx + 1, n, ans, sum + arr[idx]);

        // Exclude the current element and recurse
        solve(arr, idx + 1, n, ans, sum);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        int target = 5;
        boolean result = isSubsetSum(arr.length, arr, target);
        System.out.println("Subset with sum " + target + " exists: " + result);
    }
}
