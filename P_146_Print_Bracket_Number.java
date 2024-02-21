import java.util.ArrayList;
import java.util.Stack;

public class P_146_Print_Bracket_Number {

    // Todo: https://www.geeksforgeeks.org/problems/print-bracket-number4058/1

    // * T.C = O(n) & S.C = O(n)
    public static ArrayList<Integer> bracketNumbers(String s) {
        ArrayList<Integer> ans = new ArrayList<>();
        int open = 0;
        Stack<Integer> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                ans.add(++open);
                st.add(open);
            } else if (ch == ')') {
                ans.add(st.pop());
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "(aa(bdc))p(dee)";
        System.out.println(bracketNumbers(str));
    }
}
