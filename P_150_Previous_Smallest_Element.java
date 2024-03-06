import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class P_150_Previous_Smallest_Element {

    // Todo: https://www.geeksforgeeks.org/problems/smallest-number-on-left3403/1

    // * T.C = O(n) & S.C = O(n).
    public static List<Integer> leftSmaller(int n, int arr[]) {
        List<Integer> res = new ArrayList<>();
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

        for (int num : ans) {
            res.add(num);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 5, 0, 3, 4, 5 };
        List<Integer> sol = leftSmaller(arr.length, arr);
        System.out.println(sol);
    }

}
