public class P_085_Power_Of_Four {

    // Todo: https://leetcode.com/problems/power-of-four/

    // * T.C = O(log n) & S.C = O(n).
    public static boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false;
        }
        return solve(n, 1);
    }

    private static boolean solve(long n, long num) {
        if (num > n) {
            return false;
        }
        if (num == n) {
            return true;
        }
        return solve(n, num * 4);
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfFour(16));
    }
}
