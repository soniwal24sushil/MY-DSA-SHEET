import java.util.Arrays;
import java.util.Stack;

public class P_147_Next_Greater_Element {

    // Todo: https://www.geeksforgeeks.org/problems/next-larger-element-1587115620/1

    // * T.C = O(n) & S.C = O(n).
    public static long[] nextLargerElement(long[] arr, int n) {
        long[] res = new long[n];
        Arrays.fill(res, -1);
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                // The nge for the element at the top of the stack is the current element in the
                // input array.
                res[st.pop()] = arr[i];
            }
            // Push the current index into the stack.
            st.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        long[] arr = { 1, 3, 2, 4 };
        System.out.println(Arrays.toString(nextLargerElement(arr, arr.length)));
    }
}