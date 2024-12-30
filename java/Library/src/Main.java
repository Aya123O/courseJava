import java.util.Scanner;

public class Main {
    private static final String RESET = "\u001B[0m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String RED = "\u001B[31m";
    private static final String CYAN = "\u001B[36m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library<LibraryItem> library = new Library<>();
        LibraryItemManager itemManager = new LibraryItemManager(library);
        LibraryClientManager clientManager = new LibraryClientManager();

        while (true) {
            printMainMenu();
            int choice = getValidChoice(scanner, 1, 3);

            switch (choice) {
                case 1:
                    manageLibraryItems(scanner, itemManager);
                    break;
                case 2:
                    manageClients(scanner, clientManager, library);
                    break;
                case 3:
                    if (confirmExit(scanner)) {
                        System.out.println(GREEN + "Thank you for using the Library Management System. Goodbye!" + RESET);
                        return;
                    }
                    break;
            }
        }
    }

    private static void printMainMenu() {
        System.out.println("\n" + CYAN + "=================================");
        System.out.println("       Library Management       ");
        System.out.println("=================================" + RESET);
        System.out.println(GREEN + "1. Manage Library Items    " + YELLOW + " [Add/View/Update/Delete]");
        System.out.println(GREEN + "2. Manage Clients          " + YELLOW + " [Add/View/Update/Delete/Borrow/Return]");
        System.out.println(RED + "3. Exit the System" + RESET);
        System.out.println(CYAN + "=================================" + RESET);
        System.out.print("Enter your choice: ");
    }

    private static void manageLibraryItems(Scanner scanner, LibraryItemManager itemManager) {
        while (true) {
            printLibraryItemsMenu();
            int choice = getValidChoice(scanner, 1, 5);

            switch (choice) {
                case 1:
                    itemManager.addItem();
                    waitForUser(scanner);
                    break;
                case 2:
                    itemManager.viewItems();
                    waitForUser(scanner);
                    break;
                case 3:
                    itemManager.updateItem();
                    waitForUser(scanner);
                    break;
                case 4:
                    itemManager.deleteItem();
                    waitForUser(scanner);
                    break;
                case 5:
                    return;
            }
        }
    }

    private static void printLibraryItemsMenu() {
        System.out.println("\n" + CYAN + "=================================");
        System.out.println("      Manage Library Items       ");
        System.out.println("=================================" + RESET);
        System.out.println(GREEN + "1. Add Item          " + YELLOW + " [Add books or magazines]");
        System.out.println(GREEN + "2. View Items        " + YELLOW + " [List all items]");
        System.out.println(GREEN + "3. Update Item       " + YELLOW + " [Modify existing items]");
        System.out.println(GREEN + "4. Delete Item       " + YELLOW + " [Remove items by ID]");
        System.out.println(RED + "5. Back to Main Menu" + RESET);
        System.out.println(CYAN + "=================================" + RESET);
        System.out.print("Enter your choice: ");
    }

    private static void manageClients(Scanner scanner, LibraryClientManager clientManager, Library<LibraryItem> library) {
        while (true) {
            printClientsMenu();
            int choice = getValidChoice(scanner, 1, 7);

            switch (choice) {
                case 1:
                    clientManager.addClient();
                    waitForUser(scanner);
                    break;
                case 2:
                    clientManager.viewClients();
                    waitForUser(scanner);
                    break;
                case 3:
                    clientManager.updateClient();
                    waitForUser(scanner);
                    break;
                case 4:
                    clientManager.deleteClient();
                    waitForUser(scanner);
                    break;
                case 5:
                    clientManager.borrowItem(library);
                    waitForUser(scanner);
                    break;
                case 6:
                    clientManager.returnItem(library);
                    waitForUser(scanner);
                    break;
                case 7:
                    return;
            }
        }
    }

    private static void printClientsMenu() {
        System.out.println("\n" + CYAN + "=================================");
        System.out.println("          Manage Clients          ");
        System.out.println("=================================" + RESET);
        System.out.println(GREEN + "1. Add Client      " + YELLOW + " [Add new clients]");
        System.out.println(GREEN + "2. View Clients    " + YELLOW + " [List all clients]");
        System.out.println(GREEN + "3. Update Client   " + YELLOW + " [Modify existing clients]");
        System.out.println(GREEN + "4. Delete Client   " + YELLOW + " [Remove clients by ID]");
        System.out.println(GREEN + "5. Borrow Item     " + YELLOW + " [Clients can borrow items]");
        System.out.println(GREEN + "6. Return Item     " + YELLOW + " [Clients can return items]");
        System.out.println(RED + "7. Back to Main Menu" + RESET);
        System.out.println(CYAN + "=================================" + RESET);
        System.out.print("Enter your choice: ");
    }

    private static int getValidChoice(Scanner scanner, int min, int max) {
        while (true) {
            try {
                int choice = scanner.nextInt();
                if (choice >= min && choice <= max) {
                    return choice;
                } else {
                    System.out.print(RED + "Invalid choice! Please enter a number between " + min + " and " + max + ": " + RESET);
                }
            } catch (Exception e) {
                System.out.print(RED + "Invalid input! Please enter a valid number: " + RESET);
                scanner.next();
            }
        }
    }

    private static void waitForUser(Scanner scanner) {
        System.out.print(CYAN + "Press Enter to continue..." + RESET);
        scanner.nextLine();
        scanner.nextLine();
    }

    private static boolean confirmExit(Scanner scanner) {
        System.out.print(YELLOW + "Are you sure you want to exit? (y/n): " + RESET);
        String response = scanner.next().trim().toLowerCase();
        return response.equals("y") || response.equals("yes");
    }
}
