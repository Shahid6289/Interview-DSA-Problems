public class MinimizeTheHeights {
    
    public static int minHeightDifference(int[] arr, int n, int k) {
        int maxTowerHeight = Integer.MIN_VALUE;
        int minTowerHeight = Integer.MAX_VALUE;

        // Find the maximum and minimum tower heights
        for (int i = 0; i < n; i++) {
            if (arr[i] < minTowerHeight) {
                minTowerHeight = arr[i];
            }
            if (arr[i] > maxTowerHeight) {
                maxTowerHeight = arr[i];
            }
        }

        // Calculate the potential new heights after adding or subtracting K
        int potentialMax = maxTowerHeight - k;
        int potentialMin = minTowerHeight + k;

        // Ensure potentialMin is not greater than potentialMax
        if (potentialMin > potentialMax) {
            int temp = potentialMin;
            potentialMin = potentialMax;
            potentialMax = temp;
        }

        // Check if potential heights are better than the current heights
        for (int i = 0; i < n; i++) {
            int addHeight = arr[i] + k;
            int subtractHeight = arr[i] - k;

            if (subtractHeight >= potentialMin || addHeight <= potentialMax) {
                continue;
            }

            // Adjust potentialMin and potentialMax based on the current tower height
            if (potentialMax - subtractHeight <= addHeight - potentialMin) {
                potentialMin = subtractHeight;
            } else {
                potentialMax = addHeight;
            }
        }

        // Calculate the final result
        return Math.min(maxTowerHeight - minTowerHeight, potentialMax - potentialMin);
    }

    public static void main(String[] args) {
        int[] arr = {1, 15, 10};
        int n = arr.length;
        int k = 6;
        int result = minHeightDifference(arr, n, k);
        System.out.println(result);
    }
}
