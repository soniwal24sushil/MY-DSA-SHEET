import java.util.Arrays;
import java.util.Stack;

public class P_149_Previous_Greater_Element {

    // Todo: https://www.geeksforgeeks.org/previous-greater-element/

    // * T.C = O(n) & S.C = O(n).
    public static int[] leftLargest(int[] arr, int n) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for (int i = 0; i < n; i++) {
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
        int[] arr = { 40, 30, 20, 10 };
        System.out.println(Arrays.toString(leftLargest(arr, arr.length)));
    }
}
