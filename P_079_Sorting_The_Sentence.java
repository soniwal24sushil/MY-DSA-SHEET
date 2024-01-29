import java.util.HashMap;

public class P_079_Sorting_The_Sentence {

    // Todo: https://leetcode.com/problems/sorting-the-sentence/

    // * T.C = O(n) & S.C = O(n).
    public static String sortSentence(String s) {
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, String> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            if (ch >= '1' && ch <= '9') {
                int idx = ch - '0';
                map.put(idx, sb.toString());
                sb.setLength(0); // Clear StringBuilder for the next word
            } else if (ch != ' ') {
                sb.append(ch);
            }
        }

        for (int i = 1; i <= map.size(); i++) {
            sb.append(map.get(i));
            if (i < map.size()) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "is2 sentence4 This1 a3";
        System.out.println(sortSentence(str));
    }
}
