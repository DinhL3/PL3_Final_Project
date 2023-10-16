import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice;
        int[] listDefault = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        while (true) {
            System.out.println("\nMenu of Searching and Sorting Testbed.\n");
            System.out.println("1) Linear searching");
            System.out.println("2) Binary searching");
            System.out.println("3) O(n^2) type of sorting");
            System.out.println("4) O(n*log(n)) type of sorting");
            System.out.println("5) Sorting performance");
            System.out.println("\nq/Q) Quit");
            System.out.print("\nYour choice: ");

            choice = scanner.nextLine();

            switch (choice.toLowerCase()) {
                case "1":
                    System.out.print("In the list are values 0 - 9. \nWhich value would you like to search with linear search? ");
                    int searchValue = scanner.nextInt();
                    scanner.nextLine();
                    boolean found = false;
                    for (int value : listDefault) {
                        if (value == searchValue) {
                            found = true;
                            break;
                        }
                    }
                    if (found)
                        System.out.println("Found");
                    else
                        System.out.println("Not found");
                    break;

                case "2":
                    System.out.print("In the list are values 0 - 9. \nWhich value would you like to search with binary search? ");
                    int target = scanner.nextInt();
                    scanner.nextLine();
                    int left = 0;
                    int right = listDefault.length - 1;
                    boolean isFound = false;
                    while (left <= right) {
                        int mid = left + (right - left) / 2;
                        if (listDefault[mid] == target) {
                            isFound = true;
                            break;
                        }
                        if (listDefault[mid] < target)
                            left = mid + 1;
                        else
                            right = mid - 1;
                    }
                    if (isFound)
                        System.out.println("Found");
                    else
                        System.out.println("Not found");
                    break;

                case "3":
                    Random randBubbleSort = new Random();
                    int[] listBubbleSort = new int[10];
                    for (int i = 0; i < listBubbleSort.length; i++) {
                        // Generate random integers in range 0 to 99
                        listBubbleSort[i] = randBubbleSort.nextInt(100);
                    }

                    System.out.println("\nData set before bubble sort:");
                    for (int value : listBubbleSort) {
                        System.out.print(value + " ");
                    }
                    System.out.println();

                    int n = listBubbleSort.length;
                    for (int i = 0; i < n-1; i++) {
                        for (int j = 0; j < n-i-1; j++) {
                            if (listBubbleSort[j] > listBubbleSort[j+1]) {
                                // swap list[j+1] and list[j]
                                int temp = listBubbleSort[j];
                                listBubbleSort[j] = listBubbleSort[j+1];
                                listBubbleSort[j+1] = temp;
                            }
                        }
                    }

                    System.out.println("\nData set after bubble sort:");
                    for (int value : listBubbleSort) {
                        System.out.print(value + " ");
                    }
                    System.out.println();
                    break;


                case "4":
                    Random rand = new Random();
                    int[] listQuickSort = new int[10];
                    for (int i = 0; i < listQuickSort.length; i++) {
                        // Generate random integers in range 0 to 99
                        listQuickSort[i] = rand.nextInt(100);
                    }

                    System.out.println("\nData set before quick sort:");
                    for (int value : listQuickSort) {
                        System.out.print(value + " ");
                    }
                    System.out.println();

                    quickSort(listQuickSort, 0, listQuickSort.length - 1);

                    System.out.println("\nData set after quick sort:");
                    for (int value : listQuickSort) {
                        System.out.print(value + " ");
                    }
                    System.out.println();
                    break;

                case "5":
                    System.out.println("Choice 5 not implemented.");
                    break;

                case "q":
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}


