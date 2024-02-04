public class P_095_Ways_To_Sum_N {

    // Todo: https://www.geeksforgeeks.org/problems/ways-to-sum-to-n5759/1
    
    // * T.C = O(M^N) & S.C = O(N). {T.L.E}
    public static int countWays(int arr[], int m, int N) {
        if (N == 0) {
            return 1;
        }
        if (N < 0) {
            return 0;
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            ans += countWays(arr, m, N - arr[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 5, 6 };
        System.out.println(countWays(arr, 3, 7));
    }
}
