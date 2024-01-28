import java.util.HashMap;
import java.util.Map;

public class P_074_Isomorphic_Strings {

    // Todo: https://leetcode.com/problems/isomorphic-strings/

    // * T.C = O(n) & S.C = O(n).
    public static boolean isIsomorphic(String s, String t) {
        // Check if either of the strings is null
        if (s == null || t == null) {
            return false;
        }

        // Check if the lengths of the strings are different
        if (s.length() != t.length()) {
            return false;
        }

        // Maps to store the last seen index of each character in the strings
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();

        // Iterate through the characters of the strings
        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            // Get the last seen index of the characters in the respective strings
            int lastIndexS = mapS.getOrDefault(charS, -1);
            int lastIndexT = mapT.getOrDefault(charT, -1);

            // Check if the last seen indices are not equal
            if (lastIndexS != lastIndexT) {
                return false;
            }

            // Update the last seen index of the characters
            mapS.put(charS, i);
            mapT.put(charT, i);
        }

        // If all characters are isomorphic, return true
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add")); // true
        System.out.println(isIsomorphic("foo", "bar")); // false
    }
}
