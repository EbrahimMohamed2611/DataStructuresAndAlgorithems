package algorithems.techniques;

public class FlexibleSlidingWindow {

    // First Without Flexible Sliding Window (Without two pointers)
    // we have some books in row, and we have for every book his Reading time , we need the max number of books in k time
    private static int maximumNumberOfBooks(int[] booksWithTime, int time){
        int maxLength = 0;
        for (int i = 0; i < booksWithTime.length; i++) {
            int currentSum = 0, currentMaxLength =0;
            for (int j = i; j < booksWithTime.length; j++) {
                if(currentSum + booksWithTime[j] <= time){
                    currentSum += booksWithTime[j];
                    currentMaxLength++;
                }else{
                    break;
                }
            }
            if(currentMaxLength > maxLength)
                maxLength = currentMaxLength;
        }
        return maxLength;
    }


    public static void main(String[] args) {
        System.out.println(maximumNumberOfBooks(new int[]{2,4,1,5,7,1,2,3,2,4,7},10));
    }
}
