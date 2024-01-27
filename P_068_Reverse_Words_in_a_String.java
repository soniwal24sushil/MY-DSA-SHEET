public class P_068_Reverse_Words_in_a_String {

    // Todo: https://leetcode.com/problems/reverse-words-in-a-string/

    // * T.C = O(n) & S.C = O(n).
    public static String reverseWords(String s) {
        s = s.trim();
        String[] st = s.split(" ");
        String res = "";
        for (int i = st.length - 1; i >= 0; i--) {
            res += " " + st[i];
            res = res.trim();
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
    }

}
