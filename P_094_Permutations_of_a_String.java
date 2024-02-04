import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class P_094_Permutations_of_a_String {

    // Todo:
    // https://www.geeksforgeeks.org/problems/permutations-of-a-given-string2041/1

    // * T.C = O(N * N!), S.C = O(N).
    public static List<String> find_permutation(String S) {
        TreeSet<String> res = new TreeSet<>();
        permutations("", S, res);
        return new ArrayList<>(res);
    }

    public static void permutations(String ans, String str, TreeSet<String> res) {
        if (str.isEmpty()) {
            res.add(ans);
            return;
        }

        char ch = str.charAt(0);
        for (int i = 0; i <= ans.length(); i++) {
            String first = ans.substring(0, i);
            String second = ans.substring(i);
            permutations(first + ch + second, str.substring(1), res);
        }
    }

    public static void main(String[] args) {
        System.out.println(find_permutation("ABC"));
    }
}
