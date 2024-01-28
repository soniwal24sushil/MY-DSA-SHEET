public class P_073_Longest_Common_Prefix {

    // Todo: https://leetcode.com/problems/longest-common-prefix/

    // * T.C = O(n*m) & S.C = O(m).
    public static String longestCommonPrefix(String[] arr) {
        // Check if the array is empty
        if (arr == null || arr.length == 0) {
            return "";
        }

        int minLen = Integer.MAX_VALUE;
        int minIdx = -1;

        // Find the minimum length and the corresponding index
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() < minLen) {
                minLen = arr[i].length();
                minIdx = i;
            }
        }

        StringBuilder result = new StringBuilder();

        // Iterate over characters until a mismatch is found or the minimum length is
        // reached
        for (int i = 0; i < minLen; i++) {
            char ch = arr[minIdx].charAt(i);

            for (int j = 0; j < arr.length; j++) {
                if (arr[j].charAt(i) != ch) {
                    return result.toString();
                }
            }

            result.append(ch);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String[] arr = { "flower", "flow", "flight" };
        System.out.println(longestCommonPrefix(arr));
    }
}
