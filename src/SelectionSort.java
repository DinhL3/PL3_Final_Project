// this is O(n^2) type of sorting
public class SelectionSort {
    private static Measurement measurement = new Measurement();

    public static void sort(int[] array) {
        measurement = new Measurement();
        int length = array.length;
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < length - 1; i++) {
            // Find the index of the minimum element in the unsorted part of the array
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                measurement.incrementComparisons();

                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the element at the current position (i)
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }

        long endTime = System.currentTimeMillis();
        measurement.setTimeTaken(endTime - startTime);
    }

    public static Measurement getMeasurement() {
        return measurement;
    }
}
