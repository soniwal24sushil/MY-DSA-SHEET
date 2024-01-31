public class P_083_Power_Of_Two {

    // Todo: https://leetcode.com/problems/power-of-two/

    // * T.C = O(log n) & S.C = O(n).
    public static boolean isPowerOfTwo(int n) {
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
        return solve(n, num * 2);
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(56));
    }
}
