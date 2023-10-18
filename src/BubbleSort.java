//this is O(n^2) type of sorting

public class BubbleSort {
    private static Measurement measurement = new Measurement();

    public static void sort(int[] array) {
        measurement = new Measurement();
        int length = array.length;
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < length - 1; i++) {
            // Iterate through the unsorted portion of the array
            for (int j = 0; j < length - i - 1; j++) {
                // If the current element is greater than the next element, swap them
                if (array[j] > array[j + 1]) {

                    measurement.incrementComparisons();

                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        long endTime = System.currentTimeMillis();
        measurement.setTimeTaken(endTime - startTime);
    }

    public static Measurement getMeasurement() {
        return measurement;
    }
}