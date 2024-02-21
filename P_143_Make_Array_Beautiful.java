import java.util.ArrayList;
import java.util.Stack;

public class P_143_Make_Array_Beautiful {

    // Todo: https://www.geeksforgeeks.org/problems/make-the-array-beautiful--170647/1

    // * T.C = O(n) & S.C = O(n)
    public static ArrayList<Integer> makeBeautiful(int[] arr) {
        Stack<Integer> st = new Stack<>();
        for (int num : arr) {
            if (st.isEmpty()) {
                st.push(num);
            } else {
                if ((st.peek() >= 0 && num < 0) || (st.peek() < 0 && num >= 0)) {
                    st.pop();
                } else {
                    st.push(num);
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        if (st.isEmpty())
            return ans;
        for (int num : st) {
            ans.add(num);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { -1, -3, -4, 2, 5 };
        System.out.println(makeBeautiful(arr));
    }
}
