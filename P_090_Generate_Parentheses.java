import java.util.ArrayList;
import java.util.List;

public class P_090_Generate_Parentheses {

    // Todo: https://leetcode.com/problems/generate-parentheses/

    // * T.C = O(2^n) & S.C = O(n).
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    // Backtracking function to generate valid combinations
    private static void backtrack(List<String> result, String current, int open, int close, int max) {
        // Base case: if the length of the current combination is equal to 2 * n
        if (current.length() == 2 * max) {
            result.add(current); // Valid combination found, add to the result
            return;
        }

        // Add an open parenthesis if the count of open parentheses is less than n
        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }

        // Add a close parenthesis if the count of close parentheses is less than the
        // count of open parentheses
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }

    public static void main(String[] args) {
        // Example usage
        int n = 3;
        List<String> result = generateParenthesis(n);

        // Display the generated combinations
        System.out.println(result);
    }

}
