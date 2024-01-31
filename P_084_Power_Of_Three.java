public class P_084_Power_Of_Three {

    // Todo: https://leetcode.com/problems/power-of-three/

    // * T.C = O(log n) & S.C = O(n).
    public static boolean isPowerOfThree(int n) {
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
        return solve(n, num * 3);
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(27));
    }
}
