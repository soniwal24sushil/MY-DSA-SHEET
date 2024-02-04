public class P_091_Target_Sum {

    // Todo: https://leetcode.com/problems/target-sum/

    // * T.C = O(2^n) & S.C = O(n).
    public static int findTargetSumWays(int[] nums, int target) {
        // Call the helper function to recursively solve the problem
        return solve(nums, 0, 0, 0, target);
    }

    // Helper function to solve the problem recursively
    private static int solve(int[] arr, int idx, int count, int sum, int target) {
        // Base case: If we have reached the end of the array
        if (idx == arr.length) {
            // Check if the current sum is equal to the target
            if (sum == target) {
                return 1; // Valid combination found
            }
            return 0; // No valid combination found
        }

        // Recursive calls for both positive and negative scenarios
        int positive = solve(arr, idx + 1, count, sum + arr[idx], target);
        int negative = solve(arr, idx + 1, count, sum - arr[idx], target);

        // Return the sum of ways from positive and negative scenarios
        return positive + negative;
    }

    public static void main(String[] args) {
        // Example usage
        int[] nums = { 1, 1, 1, 1, 1 };
        int target = 3;

        int ways = findTargetSumWays(nums, target);
        System.out.println("Number of ways to reach target sum: " + ways);
    }
}
