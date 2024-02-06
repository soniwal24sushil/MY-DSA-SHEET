import java.util.ArrayList;
import java.util.List;

public class P_103_Letter_Combinations_of_a_Phone_Number {

    // Todo: https://leetcode.com/problems/letter-combinations-of-a-phone-number/

    // * T.C = O(3^N * 4^M) & S.C = O(N+M).
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) {
            return result;
        }
        String[] codes = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        backtrack(digits, 0, new StringBuilder(), result, codes);
        return result;
    }

    private static void backtrack(String digits, int index, StringBuilder current, List<String> result,
            String[] codes) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        char digit = digits.charAt(index);
        String letters = codes[digit - '0'];

        for (char letter : letters.toCharArray()) {
            current.append(letter);
            backtrack(digits, index + 1, current, result, codes);
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {
        List<String> sol = letterCombinations("23");
        System.out.println(sol);
    }
}
