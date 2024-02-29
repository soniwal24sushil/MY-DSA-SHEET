import java.util.Arrays;
import java.util.Stack;

public class P_151_Stock_Span_Problem {

    // Todo: https://practice.geeksforgeeks.org/problems/stock-span-problem-1587115621/1

    // * T.C = O(n) & S.C = O(n).
    public static int[] calculateSpan(int arr[], int n) {
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                res[st.pop()] = i;
            }
            st.push(i);
        }

        for (int i = 0; i < n; i++)
            res[i] = i - res[i];
        return res;
    }

    public static void main(String[] args) {
        int[] prices = { 100, 80, 60, 70, 60, 75, 85 };
        int n = prices.length;

        int[] span = calculateSpan(prices, n);

        System.out.println("Prices: " + java.util.Arrays.toString(prices));
        System.out.println("Spans: " + java.util.Arrays.toString(span));
    }

}
