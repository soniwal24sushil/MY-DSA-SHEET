import java.util.HashMap;
import java.util.Map;

public class P_076_Valid_Anagram {

    // Todo: https://leetcode.com/problems/valid-anagram/

    // * T.C = O(n) & S.C = O(n).
    public static boolean isAnagram(String s, String t) {
        // Check if the lengths of the strings are different
        if (s.length() != t.length()) {
            return false;
        }

        // Map to store character frequencies (positive for string s, negative for
        // string t)
        Map<Character, Integer> charCount = new HashMap<>();

        // Count character frequencies in string s (positive)
        // and in string t (negative)
        for (char ch : s.toCharArray()) {
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }
        for (char ch : t.toCharArray()) {
            charCount.put(ch, charCount.getOrDefault(ch, 0) - 1);
        }

        // Check if all frequencies are zero
        for (int count : charCount.values()) {
            if (count != 0) {
                return false;
            }
        }

        // If all characters have the same frequency, the strings are valid anagrams
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        boolean result = isAnagram(s, t);

        // Print the result
        System.out.println("Are '" + s + "' and '" + t + "' valid anagrams? " + result);
    }
}
