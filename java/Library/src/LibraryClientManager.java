import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryClientManager {
    private List<Client> clients;
    private Scanner scanner;

    public LibraryClientManager() {
        clients = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // Method to add a new client
    public void addClient() {
        System.out.print("Enter client ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume the newline
        System.out.print("Enter client name: ");
        String name = scanner.nextLine();
        System.out.print("Enter client email: ");
        String email = scanner.nextLine();

        clients.add(new Client(id, name, email));
        System.out.println("Client added successfully!");
    }

    // Method to view all clients
    public void viewClients() {
        if (clients.isEmpty()) {
            System.out.println("No clients found.");
        } else {
            for (Client client : clients) {
                System.out.println(client.getClientDetails());
                System.out.println("Borrowed Items: " + client.getBorrowedItems());
            }
        }
    }

    // Method to update client information
    public void updateClient() {
        System.out.print("Enter the ID of the client to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume the newline
        Client client = clients.stream().filter(c -> c.getId() == id).findFirst().orElse(null);

        if (client != null) {
            System.out.println("Current client: " + client.getClientDetails());
            System.out.print("Enter new name: ");
            String newName = scanner.nextLine();
            System.out.print("Enter new email: ");
            String newEmail = scanner.nextLine();
            client.setName(newName);
            client.setEmail(newEmail);
            System.out.println("Client updated successfully!");
        } else {
            System.out.println("Client not found.");
        }
    }

    // Method to delete a client
    public void deleteClient() {
        System.out.print("Enter the ID of the client to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume the newline
        clients.removeIf(client -> client.getId() == id);
        System.out.println("Client deleted successfully!");
    }

    // Method to borrow an item for a client
    public void borrowItem(Library<LibraryItem> library) {
        System.out.print("Enter client ID to borrow item: ");
        int clientId = scanner.nextInt();
        System.out.print("Enter item ID to borrow: ");
        int itemId = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        Client client = clients.stream().filter(c -> c.getId() == clientId).findFirst().orElse(null);

        try {
            // Fetch item from library (this can throw NotItemFound)
            LibraryItem item = library.getItemById(itemId);

            if (client != null) {
                client.borrowItem(item);
                System.out.println("Item borrowed successfully!");
            } else {
                System.out.println("Client not found.");
            }
        } catch (NotItemFound e) {
            // Handle exception if item is not found
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Method to return an item for a client
    public void returnItem(Library<LibraryItem> library) {
        System.out.print("Enter client ID to return item: ");
        int clientId = scanner.nextInt();
        System.out.print("Enter item ID to return: ");
        int itemId = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        Client client = clients.stream().filter(c -> c.getId() == clientId).findFirst().orElse(null);

        try {
            // Fetch item from library (this can throw NotItemFound)
            LibraryItem item = library.getItemById(itemId);

            if (client != null) {
                client.returnItem(item);
                System.out.println("Item returned successfully!");
            } else {
                System.out.println("Client not found.");
            }
        } catch (NotItemFound e) {
            // Handle exception if item is not found
            System.out.println("Error: " + e.getMessage());
        }
    }
}
