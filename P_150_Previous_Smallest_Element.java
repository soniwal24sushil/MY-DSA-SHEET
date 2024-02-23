import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class P_150_Previous_Smallest_Element {

    // Todo: https://www.geeksforgeeks.org/problems/smallest-number-on-left3403/1

    // * T.C = O(n) & S.C = O(n).
    public static List<Integer> leftSmaller(int n, int arr[]) {
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {

                res[st.pop()] = arr[i];
            }
            // Push the current index into the stack.
            st.push(i);
        }
        List<Integer> ans = new ArrayList<>();
        for (int num : res) {
            ans.add(num);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 5, 0, 3, 4, 5 };
        List<Integer> sol = leftSmaller(arr.length, arr);
        System.out.println(sol);
    }

}
