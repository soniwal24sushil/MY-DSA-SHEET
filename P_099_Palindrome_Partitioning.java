import java.util.ArrayList;
import java.util.List;

public class P_099_Palindrome_Partitioning {

    // Todo: https://leetcode.com/problems/palindrome-partitioning/

    // * T.C = O(2^n) & S.C = O(n).
    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        solve(s, 0, ans, res);
        return res;
    }

    private static void solve(String str, int idx, List<String> temp, List<List<String>> res) {
        if (idx == str.length()) {
            res.add(new ArrayList<>(temp));
        }

        for (int i = idx; i < str.length(); i++) {
            if (isPalindrome(str, idx, i)) {
                temp.add(str.substring(idx, i + 1));
                solve(str, i + 1, temp, res);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String s, int low, int high) {
        while (low < high)
            if (s.charAt(low++) != s.charAt(high--))
                return false;
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> result = partition("AAB");
        System.out.println(result);
    }
}
