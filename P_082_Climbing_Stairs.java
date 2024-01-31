public class P_082_Climbing_Stairs {

    // Todo: https://leetcode.com/problems/climbing-stairs/

    // * T.C = O(2^n) & S.C = O(n) {TLE}.
    public static int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }

        int takeOne = climbStairs(n - 1);
        int takeTwo = climbStairs(n - 2);
        return takeOne + takeTwo;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }
}
