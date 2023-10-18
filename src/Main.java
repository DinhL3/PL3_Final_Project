import java.util.Random;
import java.util.Scanner;

public class Main {
    //function to return an array of random integer, take number of ints as arg, if 10 ints, range is 0-99, if 100 ints, range is 0-999 and so on
    public static int[] randomInts(int numInts) {
        Random rand = new Random();
        int[] list = new int[numInts];
        for (int i = 0; i < list.length; i++) {
            list[i] = rand.nextInt(numInts * 10);
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
//                    int[] fiveThousandInts = randomInts(1000);


//                    System.out.print("\nbubbleSort,comparisons:");
//                    BubbleSort.sort(fiveThousandInts);
//                    System.out.print(BubbleSort.getMeasurement().getNumComparisons());
//                    System.out.print(" ,time:");
//                    System.out.println(BubbleSort.getMeasurement().getTimeTaken());
                    break;

                case "q":
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}


