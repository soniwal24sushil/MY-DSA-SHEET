public class P_080_Pangram_Checking {

    // Todo: https://leetcode.com/problems/check-if-the-sentence-is-pangram/

    // * T.C = O(n) & S.C = O(1).
    public static boolean checkIfPangram(String str) {
        int[] arr = new int[26];
        for (char ch : str.toCharArray()) {
            arr[ch - 'a'] = 1;
        }
        for (int i = 0; i < 26; i++) {
            if (arr[i] == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
    }
}
