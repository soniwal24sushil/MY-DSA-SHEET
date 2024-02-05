public class P_102_Tower_of_Hanoi {

    // Todo: https://www.geeksforgeeks.org/problems/tower-of-hanoi-1587115621/1

    // * T.C = O(2^n) & S.C = O(n).
    public static long count = 0;

    public static long toh(int n, String src, String dest, String help) {
        count = 0;
        helper(n, src, dest, help);
        return count;
    }

    public static void helper(int n, String s, String d, String h) {
        if (n == 1) {
            System.out.println("move disk 1 from rod " + s + " to rod " + d);
            count++;
            return;
        }

        helper(n - 1, s, h, d);
        count++;
        System.out.println("move disk " + n + " from rod " + s + " to rod " + d);
        helper(n - 1, h, d, s);
    }

    public static void main(String[] args) {
        System.out.println(toh(3, "A", "B", "C"));
    }

}
