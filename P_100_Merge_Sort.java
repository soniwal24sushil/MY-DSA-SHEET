import java.util.Arrays;

public class P_100_Merge_Sort {

    // Todo: https://www.geeksforgeeks.org/problems/merge-sort/1

    // * T.C = O(n*logn) & S.C = O(n).
    public static void mergeSort(int[] arr, int left_idx, int right_idx) {
        if (left_idx >= right_idx) {
            return;
        }

        int mid_idx = left_idx + (right_idx - left_idx) / 2;

        mergeSort(arr, left_idx, mid_idx);
        mergeSort(arr, mid_idx + 1, right_idx);

        merge(arr, left_idx, mid_idx, right_idx);
    }

    public static void merge(int[] arr, int start_idx, int mid_idx, int end_idx) {
        int[] temp = new int[end_idx - start_idx + 1];

        int i = start_idx, j = mid_idx + 1, k = 0;

        while (i <= mid_idx && j <= end_idx) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid_idx) {
            temp[k++] = arr[i++];
        }

        while (j <= end_idx) {
            temp[k++] = arr[j++];
        }

        // * Modifying original array.
        for (int index = start_idx; index <= end_idx; index++) {
            arr[index] = temp[index - start_idx];
        }
    }

    public static void main(String[] args) {
        int[] arr = { 4, 1, 3, 9, 7 };
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

}
