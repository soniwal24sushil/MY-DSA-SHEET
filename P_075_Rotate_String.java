public class P_075_Rotate_String {

    // Todo: https://leetcode.com/problems/rotate-string/

    // * T.C = O(n) & S.C = O(n).
    public static boolean rotateString(String s, String goal) {
        int n = s.length();
        for (int i = 1; i <= n; i++) {
            String temp = s.substring(n - i) + s.substring(0, n - i);
            if (temp.equals(goal)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(rotateString("abcde", "cdeab"));
    }
}
