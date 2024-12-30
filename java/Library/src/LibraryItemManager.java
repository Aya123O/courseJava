import java.util.Scanner;

public class LibraryItemManager {
    private Library<LibraryItem> library;
    private Scanner scanner;

    public LibraryItemManager(Library<LibraryItem> library) {
        this.library = library;
        this.scanner = new Scanner(System.in);
    }

    public void addItem() {
        try {
            System.out.println("Choose Type => ");
            System.out.println("[1] Book");
            System.out.println("[2] Magazine");
            System.out.print("Enter Choice : ");
            int type = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter item ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter item title: ");
            String title = scanner.nextLine();

            if (type == 1) {
                System.out.print("Enter Author Name: ");
                String author = scanner.nextLine();
                library.addItem(new Book(id, title, author));
            } else if (type == 2) {
                System.out.print("Enter Issue Number: ");
                int issueNumber = scanner.nextInt();
                library.addItem(new Magazine(id, title, issueNumber));
            } else {
                System.out.println("Invalid item type.");
            }
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please try again.");
            scanner.nextLine();
        }
    }

    public void viewItems() {
        library.displayItems();
    }

    public void updateItem() {
        try {
            System.out.print("Enter the ID of the item: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            LibraryItem item = library.getItemById(id);

            System.out.println("Current Item: " + item.getItemDetails());
            System.out.print("Enter new title: ");
            String newTitle = scanner.nextLine();
            item.setTitle(newTitle);

            if (item instanceof Book) {
                System.out.print("Enter new author: ");
                String newAuthor = scanner.nextLine();
                ((Book) item).setAuthor(newAuthor);
            } else if (item instanceof Magazine) {
                System.out.print("Enter new issue number: ");
                int newIssueNumber = scanner.nextInt();
                ((Magazine) item).setIssueNumber(newIssueNumber);
            }

            System.out.println("Item updated successfully!");
        } catch (NotItemFound e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please try again.");
            scanner.nextLine();
        }
    }

    public void deleteItem() {
        try {
            System.out.print("Enter the ID of the item to delete: ");
            int id = scanner.nextInt();
            if (library.removeItemById(id)) {
                System.out.println("Item deleted successfully!");
            } else {
                System.out.println("Item with ID " + id + " not found.");
            }
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please try again.");
            scanner.nextLine();
        }
    }
}
