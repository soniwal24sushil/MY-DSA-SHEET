import java.util.ArrayList;

public class P_089_Subset_Sums_1 {

    // Todo: https://www.geeksforgeeks.org/problems/subset-sums2234/1

    // * T.C = O(2^n) & S.C = O(2^n);
    public static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        solve(arr, 0, n, ans, 0);
        return ans;
    }

    public static void solve(ArrayList<Integer> arr, int idx, int n, ArrayList<Integer> ans, int sum) {
        if (idx == n) {
            ans.add(sum);
            return;
        }
        solve(arr, idx + 1, n, ans, sum + arr.get(idx));
        solve(arr, idx + 1, n, ans, sum);
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(3);
        int n = arr.size();
        System.out.println(subsetSums(arr, n));
    }
}
