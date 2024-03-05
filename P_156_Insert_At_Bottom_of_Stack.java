import java.util.Stack;

public class P_156_Insert_At_Bottom_of_Stack {

    // Todo: https://www.geeksforgeeks.org/problems/insert-an-element-at-the-bottom-of-a-stack/1
    
    // * T.C = O(n) & S.C = O(n).
    public static Stack<Integer> insertAtBottom(Stack<Integer> stack, int x) {
        solve(stack, x);
        return stack;
    }

    // Helper function to insert element at bottom.
    public static void solve(Stack<Integer> stack, int x) {
        if (stack.isEmpty()) {
            stack.add(x);
            return;
        }
        int num = stack.pop();
        solve(stack, x);
        stack.push(num);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(1);
        stack.push(5);

        stack = insertAtBottom(stack, 7);
        System.out.println(stack);
    }
}
