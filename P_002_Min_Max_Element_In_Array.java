public class P_002_Min_Max_Element_In_Array {

    // ? T.C = O(n) & S.C = O(1).
    public static int[] findMinMax(int[] arr) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }
        return new int[] { min, max };
    }

    public static void main(String[] args) {
        int[] arr = { 3, 7, 2, 4, 1 };
        int[] res = findMinMax(arr);
        System.out.println("The minimum element of the array is: " + res[0]);
        System.out.println("The maximum element of the array is: " + res[1]);
    }
}
