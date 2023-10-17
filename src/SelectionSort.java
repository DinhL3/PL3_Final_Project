// this is O(n^2) type of sorting
public class SelectionSort {
    private static int numComparisons = 0;
    public static void sort(int[] array) {
        numComparisons = 0;
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            // Find the index of the minimum element in the unsorted part of the array
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                numComparisons++;

                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the element at the current position (i)
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    public static int getNumComparisons() {
        return numComparisons;
    }
}
