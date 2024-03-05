import java.util.Arrays;
import java.util.Stack;

public class P_147_Next_Greater_Element {

    // Todo: https://www.geeksforgeeks.org/problems/next-larger-element-1587115620/1

    // * T.C = O(n) & S.C = O(n).
    public static long[] nextLargerElement(long[] arr, int n) {
        Stack<Integer> st = new Stack<>();
        long[] ans = new long[n];
        Arrays.fill(ans, -1);
        for (int i = n - 1; i >= 0; i--) {
            long num = arr[i];
            while (!st.isEmpty() && arr[st.peek()] <= num) {
                st.pop();
            }
            if (st.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = arr[st.peek()];
            }
            st.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        long[] arr = { 1, 3, 2, 4 };
        System.out.println(Arrays.toString(nextLargerElement(arr, arr.length)));
    }
}