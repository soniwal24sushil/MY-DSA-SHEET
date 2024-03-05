import java.util.Stack;

public class P_154_Redundant_Bracket {

    // Todo: https://www.geeksforgeeks.org/problems/expression-contains-redundant-bracket-or-not/1

    // * T.C = O(n) & S.C = O(n).
    public static int checkRedundancy(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                stack.push(ch);
            } else {
                if (ch == ')') {
                    boolean isRedundant = true;
                    while (stack.peek() != '(') {
                        char top = stack.peek();
                        if (top == '+' || top == '-' || top == '*' || top == '/') {
                            isRedundant = false;
                        }
                        stack.pop();
                    }
                    if (isRedundant) {
                        return 1;
                    } else {
                        stack.pop();
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String str = "(a+b+(c+d))";
        System.out.println(checkRedundancy(str));
    }
}
