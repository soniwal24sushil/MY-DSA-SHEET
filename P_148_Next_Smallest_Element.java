import java.util.Arrays;
import java.util.Stack;

public class P_148_Next_Smallest_Element {

    // Todo: https://www.geeksforgeeks.org/problems/help-classmates--141631/1

    // * T.C = O(n) & S.C = O(n).
    public static int[] nextSmallerElement(int[] arr, int n) {
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                // The nse for the element at the top of the stack is the current element in the
                // input array.
                res[st.pop()] = arr[i];
            }
            // Push the current index into the stack.
            st.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 2, 4 };
        System.out.println(Arrays.toString(nextSmallerElement(arr, arr.length)));
    }
}
