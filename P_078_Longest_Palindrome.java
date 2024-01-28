public class P_078_Longest_Palindrome {

    // Todo: https://leetcode.com/problems/longest-palindrome/

    // * T.C = O(n) & S.C = O(1).
    public static int longestPalindrome(String s) {
        int[] frequency = new int[58]; // 'z' - 'A' + 1 = 58

        for (char ch : s.toCharArray()) {
            frequency[ch - 'A']++;
        }

        int count = 0;
        int odd = 0;

        for (int freq : frequency) {
            if (freq % 2 == 0) {
                count += freq;
            } else {
                count += freq - 1;
            }

            if (freq % 2 != 0) {
                odd = 1;
            }
        }

        return count + odd;
    }

    public static void main(String[] args) {
        String input = "abccccdd";
        int result = longestPalindrome(input);

        // Print the result
        System.out.println("Input: " + input);
        System.out.println("Longest Palindrome Length: " + result);
    }
}