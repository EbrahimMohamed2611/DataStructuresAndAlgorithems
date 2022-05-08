package algorithems.techniques;


/**
 * To deal with range in array
 * every step will add new Element from the right and remove Element from the left
 */


public class FixedSlidingWindow {


    private static int maximumSumOfkConsecutiveElementsWithNaiveSolution(int[] array, int k) {
        int maxSum = 0;
        for (int i = 0; i < array.length - k + 1; i++) {
            int currentMax = 0;
            for (int j = i; j < i + k; j++) {
                currentMax += array[j];
            }
            if(currentMax > maxSum)
                maxSum = currentMax;
        }
        return maxSum;
    }

    //Using Fixed Sliding window Technique
    // (1) find the maximum sum of k consecutive elements
    private static int maximumSumOfkConsecutiveElements(int[] array, int k) {
        // first we assume the range from start to k index will be the max
        int currentSum = 0, maxSum = 0;
        for (int i = 0; i < k; i++)
            currentSum += array[i];

        // now we need to start from k to (i + k) until reach the full size
        // [ 0, 1, 2, 3, 4, 5]
        //                 i
        for (int i = k; i < array.length; i++) {
            // ech step we need to add new element tot current window and remove the most left element from the current wind
            currentSum = currentSum + array[i] - array[i - k];
            if (currentSum > maxSum)
                maxSum = currentSum;
        }
        System.out.println(maxSum);
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maximumSumOfkConsecutiveElements(new int[]{4, 2, 1, 5, 4, 6, 3}, 3));
        System.out.println(maximumSumOfkConsecutiveElementsWithNaiveSolution(new int[]{4, 2, 1, 5, 4, 6, 3}, 3));
    }

}
