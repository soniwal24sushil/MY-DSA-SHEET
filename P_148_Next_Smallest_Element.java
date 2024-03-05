import java.util.Arrays;
import java.util.Stack;

public class P_148_Next_Smallest_Element {

    // Todo: https://www.geeksforgeeks.org/problems/help-classmates--141631/1

    // * T.C = O(n) & S.C = O(n).
    public static int[] nextSmallerElement(int[] arr, int n) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for (int i = n - 1; i >= 0; i--) {
            int num = arr[i];
            while (!st.isEmpty() && arr[st.peek()] >= num) {
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
        int[] arr = { 1, 3, 2, 4 };
        System.out.println(Arrays.toString(nextSmallerElement(arr, arr.length)));
    }
}
