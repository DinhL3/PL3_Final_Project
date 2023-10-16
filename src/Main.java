import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice;
        int[] list = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

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
                    for (int value : list) {
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
                    System.out.println("Choice 2 not implemented.");
                    break;
                case "3":
                    System.out.println("Choice 3 not implemented.");
                    break;
                case "4":
                    System.out.println("Choice 4 not implemented.");
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
}
