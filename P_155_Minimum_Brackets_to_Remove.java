import java.util.ArrayList;
import java.util.Stack;

public class P_155_Minimum_Brackets_to_Remove {

    // Todo: https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/

    // * T.C = O(n) & S.C = O(n)
    public static String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    list.add(i);
                } else {
                    stack.pop();
                }
            }
        }

        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!list.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "lee(t(c)o)de)";
        System.out.println(minRemoveToMakeValid(str));
    }
}
