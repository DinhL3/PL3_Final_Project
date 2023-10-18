//this is O(n*log(n)) type of sorting

public class MergeSort {
    private static Measurement measurement = new Measurement();

    public static void sort(int[] array) {
        measurement = new Measurement();
        long startTime = System.currentTimeMillis();

        sort(array, 0, array.length - 1);

        long endTime = System.currentTimeMillis();
        measurement.setTimeTaken(endTime - startTime);
    }

    static void sort(int[] array, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;

            // Sort the first and second halves
            sort(array, left, middle);
            sort(array, middle + 1, right);

            // Merge the sorted halves
            merge(array, left, middle, right);
        }
    }

    static void merge(int[] array, int left, int middle, int right) {
        int leftSize = middle - left + 1;
        int rightSize = right - middle;

        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];

        // Copy data to temporary arrays
        System.arraycopy(array, left, leftArray, 0, leftSize);
        for (int j = 0; j < rightSize; j++) {
            rightArray[j] = array[middle + 1 + j];
        }

        // Merge the temporary arrays
        int i = 0, j = 0;
        int k = left;

        while (i < leftSize && j < rightSize) {
            measurement.incrementComparisons();

            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements from the leftArray
        while (i < leftSize) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy any remaining elements from the rightArray
        while (j < rightSize) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static Measurement getMeasurement() {
        return measurement;
    }
}
