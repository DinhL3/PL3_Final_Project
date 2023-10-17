//this is O(n*log(n)) type of sorting

public class HeapSort {
    private static int numComparisons = 0;

    public static void sort(int[] array) {
        numComparisons = 0;
        int length = array.length;

        // Build a max heap
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(array, length, i);
        }

        // Extract elements from the heap one by one
        for (int i = length - 1; i > 0; i--) {
            // Swap the current root (maximum element) with the last element
            swap(array, 0, i);

            // Call heapify on the reduced heap
            heapify(array, i, 0);
        }
    }

    private static void heapify(int[] array, int size, int rootIndex) {
        int largest = rootIndex;

        int leftChild = 2 * rootIndex + 1;
        int rightChild = 2 * rootIndex + 2;

        if (leftChild < size) {
            numComparisons++; // increment the counter here
            if (array[leftChild] > array[largest]) {
                largest = leftChild;
            }
        }

        if (rightChild < size) {
            numComparisons++; // increment the counter here
            if (array[rightChild] > array[largest]) {
                largest = rightChild;
            }
        }

        if (largest != rootIndex) {
            swap(array, rootIndex, largest);
            heapify(array, size, largest);
        }
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static int getNumComparisons() {
        return numComparisons;
    }
}
