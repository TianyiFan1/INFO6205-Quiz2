public class BinarySearchRotatedArray {

    /**
     * Searches for a target value in a rotated sorted array.
     *
     * @param arr            The rotated sorted array to search in
     * @param target         The value to search for
     * @param rotationIndex  The index at which the array is rotated
     * @return               The index of the target value if found, -1 otherwise
     */
    public int search(int[] arr, int target, int rotationIndex) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int n = arr.length;

        // If rotationIndex is 0, perform a normal binary search
        if (rotationIndex == 0) {
            return binarySearch(arr, 0, n - 1, target);
        }

        // Determine which part of the rotated array to search
        if (target >= arr[rotationIndex] && target <= arr[n - 1]) {
            return binarySearch(arr, rotationIndex, n - 1, target);
        } else {
            return binarySearch(arr, 0, rotationIndex - 1, target);
        }
    }

    /**
     * Performs a binary search on a sorted array within the specified range.
     *
     * @param arr     The sorted array to search in
     * @param left    The left boundary of the search range (inclusive)
     * @param right   The right boundary of the search range (inclusive)
     * @param target  The value to search for
     * @return        The index of the target value if found, -1 otherwise
     */
    private int binarySearch(int[] arr, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // Target not found
    }

    public static void main(String[] args) {
        BinarySearchRotatedArray searcher = new BinarySearchRotatedArray();
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int target = 6;
        int rotationIndex = 4; // The index where the array is rotated

        int result = searcher.search(arr, target, rotationIndex);
        System.out.println("Index of " + target + ": " + result);
    }
}