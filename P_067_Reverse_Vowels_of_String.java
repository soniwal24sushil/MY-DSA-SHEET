import java.util.ArrayList;
import java.util.Arrays;

public class P_067_Reverse_Vowels_of_String {

    // Todo: https://leetcode.com/problems/reverse-vowels-of-a-string/

    // * T.C = O(n) & S.C = O(1).
    public static String reverseVowels(String s) {
        // Create a list of vowels for easy lookup
        ArrayList<Character> vowelsList = new ArrayList<>(
                Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        // Convert the string to a character array for manipulation
        char[] charArray = s.toCharArray();

        // Initialize pointers for swapping vowels
        int left = 0, right = charArray.length - 1;

        while (left < right) {
            // Check if characters at pointers are both vowels
            if (vowelsList.contains(charArray[left]) && vowelsList.contains(charArray[right])) {
                // Swap vowels
                char temp = charArray[left];
                charArray[left] = charArray[right];
                charArray[right] = temp;
                // Move pointers towards the center
                left++;
                right--;
            } else if (vowelsList.contains(charArray[left]) && !vowelsList.contains(charArray[right])) {
                // Move right pointer towards the center if only right character is not a vowel
                right--;
            } else if (!vowelsList.contains(charArray[left]) && vowelsList.contains(charArray[right])) {
                // Move left pointer towards the center if only left character is not a vowel
                left++;
            } else {
                // Move both pointers towards the center if neither character is a vowel
                left++;
                right--;
            }
        }

        // Convert the character array back to a string
        return new String(charArray);
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("Soniwal"));
    }
}
