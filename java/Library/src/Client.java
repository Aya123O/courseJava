import java.util.ArrayList;
import java.util.List;

public class Client {
    private int id;
    private String name;
    private String email;
    private List<LibraryItem> borrowedItems; // New field for borrowed items

    public Client(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.borrowedItems = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClientDetails() {
        return "Client [ID=" + id + ", Name=" + name + ", Email=" + email + "]";
    }

    // Method to borrow an item
    public void borrowItem(LibraryItem item) {
        borrowedItems.add(item);
        System.out.println("Item borrowed: " + item.getItemDetails());
    }

    // Method to return an item
    public void returnItem(LibraryItem item) {
        if (borrowedItems.remove(item)) {
            System.out.println("Item returned: " + item.getItemDetails());
        } else {
            System.out.println("Item not found in borrowed list.");
        }
    }

    // List of borrowed items
    public List<LibraryItem> getBorrowedItems() {
        return borrowedItems;
    }
}
