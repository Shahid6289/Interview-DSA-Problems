public class LargestSumContigiousSubArray {
    // arr: input array
    // n: size of array
    //Function to find the sum of contiguous subarray with maximum sum.
    long maxSubarraySum(int arr[], int n){
        
        // Your code here
        long maxSum = Integer.MIN_VALUE;
        long currSum = 0;

        for (int i = 0; i < n; i++) {
            currSum += arr[i];
            maxSum = Math.max(currSum, maxSum);
              if (currSum < 0) {
                currSum = 0;
            }
        }

        return maxSum;
    }   
}
