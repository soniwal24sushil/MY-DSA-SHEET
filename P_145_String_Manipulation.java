import java.util.ArrayList;
import java.util.Stack;

public class P_145_String_Manipulation {

    // Todo: https://www.geeksforgeeks.org/problems/string-manipulation3706/1

    // * T.C = O(n) & S.C = O(n).
    public static int removeConsecutiveSame(ArrayList<String> list) {
        Stack<String> st = new Stack<>();
        for (String str : list) {
            if (st.isEmpty()) {
                st.push(str);
            } else {
                if (st.peek().equals(str)) {
                    st.pop();
                } else {
                    st.push(str);
                }
            }
        }
        return st.size();
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Tom");
        list.add("Jerry");
        list.add("Jerry");
        list.add("Tom");
        System.out.println(removeConsecutiveSame(list));
    }
}
