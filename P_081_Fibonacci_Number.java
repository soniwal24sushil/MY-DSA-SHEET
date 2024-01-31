public class P_081_Fibonacci_Number {

    // Todo: https://leetcode.com/problems/fibonacci-number/

    // * T.C = O(2^n) & S.C = O(n).
    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(fib(7));
    }
}
