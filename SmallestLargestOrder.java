public class SmallestLargestOrder {
    public static void main(String[] args) {
        int[] arr = {4, 7, 1, 9, 2, 5, 8, 3, 6};
        int n = arr.length;

        // Find the maximum element
        int maxIndex = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }

        // Find the minimum element
        int minIndex = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }

        // Initialize the result array
        int[] result = new int[n];

        // Arrange elements in the specified order
        int resultIndex = 0;
        for (int i = 0; i < n / 2; i++) {
            result[resultIndex++] = arr[i];
            result[resultIndex++] = arr[n - 1 - i];
        }

        // Handle the case when the array length is odd
        if (n % 2 != 0) {
            result[resultIndex] = arr[n / 2];
        }

        // Print the result
        System.out.println("Array in the specified order:");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
