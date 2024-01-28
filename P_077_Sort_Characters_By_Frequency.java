import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_077_Sort_Characters_By_Frequency {

    // Todo: https://leetcode.com/problems/sort-characters-by-frequency/

    // * T.C = O(n) & S.C = O(n).
    public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        @SuppressWarnings("unchecked")
        List<Character>[] arr = new List[s.length() + 1];
        for (char key : map.keySet()) {
            int freq = map.get(key);
            if (arr[freq] == null) {
                arr[freq] = new ArrayList<>();
            }
            arr[freq].add(key);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] != null) {
                for (char ch : arr[i]) {
                    for (int j = 0; j < map.get(ch); j++) {
                        sb.append(ch);
                    }
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "tree";
        String result = frequencySort(input);

        // Print the result
        System.out.println("Input: " + input);
        System.out.println("Sorted by Frequency: " + result);
    }
}
