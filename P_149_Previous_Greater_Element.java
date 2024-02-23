import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class P_149_Previous_Greater_Element {

    // Todo: https://www.geeksforgeeks.org/previous-greater-element/

    // * T.C = O(n) & S.C = O(n).
    public static int[] leftLargest(int[] arr, int n) {
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                res[st.pop()] = arr[i];
            }
            st.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 40, 30, 20, 10 };
        System.out.println(Arrays.toString(leftLargest(arr, arr.length)));
    }
}
