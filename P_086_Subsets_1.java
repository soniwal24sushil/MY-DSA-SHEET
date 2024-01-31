import java.util.ArrayList;
import java.util.List;

public class P_086_Subsets_1 {

    // Todo: https://leetcode.com/problems/subsets/

    // * T.C = O(2^n) & S.C = O(n).
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        solve(nums, 0, ans, result);
        return result;
    }

    private static void solve(int[] arr, int idx, List<Integer> ans, List<List<Integer>> result) {
        if (idx == arr.length) {
            result.add(new ArrayList<>(ans));
            return;
        }
        ans.add(arr[idx]);
        solve(arr, idx + 1, ans, result);

        ans.remove(ans.size() - 1);
        solve(arr, idx + 1, ans, result);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        List<List<Integer>> sol = subsets(arr);
        System.out.println(sol);
    }
}
