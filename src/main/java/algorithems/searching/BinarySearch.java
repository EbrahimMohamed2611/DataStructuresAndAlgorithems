package algorithems.searching;

public class BinarySearch {

    // First implement Lower-Bound  (first element >= key)
    // [ 1, 2, 3, 3, 4, 5, 6, 6, 6, 8]   key = 5       lower bound will be at index 5     because [5] =5 the first element that >= key
    // [ 1, 2, 3, 3, 4, 5, 6, 6, 6, 8]   key = 7       lower bound will be at index 9     because [9] =8 the first element that >= key
    // when fail will return (arr.length) as index, or we can return -1
    public static int lowerBound(int[] arr, int key) {
        int low = 0, high = arr.length - 1, lowerBoundIndex = arr.length, mid;
        while (high >= low) {
            mid = low + (high - low) / 2;
            if (arr[mid] >= key) {
                lowerBoundIndex = mid;
                high = mid - 1;
            } else { 
                low = mid + 1;
            }
        }
        return lowerBoundIndex;
    }

    // Second implement Upper-Bound  (first element > key)
    // [ 1, 2, 3, 3, 4, 5, 6, 6, 6, 8]   key = 5       lower bound will be at index 6     because [6] = 6 the first element that >= key
    // [ 1, 2, 3, 3, 4, 5, 6, 6, 6, 8]   key = 7       lower bound will be at index 9     because [9] = 8 the first element that >= key
    // when fail will return (arr.length) as index, or we can return -1
    public static int upperBound(int[] arr, int key) {
        int low = 0, high = arr.length - 1, upperBoundIndex = arr.length, mid;
        while (high >= low) {
            mid = low + (high - low) / 2;
            if (arr[mid] > key) {
                upperBoundIndex = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return upperBoundIndex;
    }



    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 4, 5, 6, 6, 6, 8};
        System.out.println(lowerBound(arr, 5)); // 5
        System.out.println(lowerBound(arr, 7)); // 9

        System.out.println(upperBound(arr, 5)); // 6
        System.out.println(upperBound(arr, 7)); // 9
    }
}
