import javax.swing.*;
import java.util.Random;
import java.util.Scanner;

public class Main {
    //function to return an array of random integer, take number of ints as arg, if 10 ints, range is 0-99, if 100 ints, range is 0-999 and so on
    public static int[] randomInts(int numInts) {
        Random rand = new Random();
        int[] list = new int[numInts];
        for (int i = 0; i < list.length; i++) {
            list[i] = rand.nextInt(numInts * 10) - numInts * 5;
        }
        return list;
    }

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
                    int[] listForCaseThree = randomInts(10);
                    System.out.println("\nData set before bubble sort:");
                    for (int value : listForCaseThree) {
                        System.out.print(value + " ");
                    }
                    System.out.println();

                    BubbleSort.sort(listForCaseThree);

                    System.out.println("\nData set after bubble sort:");
                    for (int value : listForCaseThree) {
                        System.out.print(value + " ");
                    }
                    System.out.println();
                    break;


                case "4":
                    int[] listForCaseFour = randomInts(10);
                    System.out.println("\nData set before merge sort:");
                    for (int value : listForCaseFour) {
                        System.out.print(value + " ");
                    }
                    System.out.println();

                    MergeSort.sort(listForCaseFour);

                    System.out.println("\nData set after merge sort:");
                    for (int value : listForCaseFour) {
                        System.out.print(value + " ");
                    }
                    System.out.println();
                    break;

                case "5":
                    String[] columnNames = {"Type | No. of ints", "1000", "2000", "3000", "4000", "5000", "6000", "7000", "8000", "9000", "10000"};
                    Table table = new Table(columnNames);

                    int[] numberOfIntsToSort = {1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000};
                    String[] algorithms = {"BubbleSort", "SelectionSort", "MergeSort", "HeapSort"};

                    for (String algorithm : algorithms) {
                        for (int j = 0; j < 2; j++) {
                            Object[] data = new Object[11];
                            data[0] = algorithm + (j == 0 ? ", ms" : ", comparisons");

                            for (int i = 0; i < numberOfIntsToSort.length; i++) {
                                int[] list = randomInts(numberOfIntsToSort[i]);
                                switch (algorithm) {
                                    case "BubbleSort":
                                        BubbleSort.sort(list);
                                        data[i + 1] = j == 0 ? BubbleSort.getMeasurement().getTimeTaken() : BubbleSort.getMeasurement().getNumComparisons();
                                        break;
                                    case "SelectionSort":
                                        SelectionSort.sort(list);
                                        data[i + 1] = j == 0 ? SelectionSort.getMeasurement().getTimeTaken() : SelectionSort.getMeasurement().getNumComparisons();
                                        break;
                                    case "MergeSort":
                                        MergeSort.sort(list);
                                        data[i + 1] = j == 0 ? MergeSort.getMeasurement().getTimeTaken() : MergeSort.getMeasurement().getNumComparisons();
                                        break;
                                    case "HeapSort":
                                        HeapSort.sort(list);
                                        data[i + 1] = j == 0 ? HeapSort.getMeasurement().getTimeTaken() : HeapSort.getMeasurement().getNumComparisons();
                                        break;
                                }
                            }

                            table.addRow(data);
                        }
                    }

                    JFrame frame = new JFrame();
                    frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    frame.add(new JScrollPane(table.getTable()));
                    frame.pack();
                    frame.setVisible(true);
                    break;

                case "q":
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}


