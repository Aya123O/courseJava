import java.util.ArrayList;
import java.util.List;

public class Library<T extends LibraryItem> {
    private List<T> items;

    public Library() {
        items = new ArrayList<>();
    }

    public void addItem(T item) {
        items.add(item);
        System.out.println("Item added successfully!");
    }

    public T getItemById(int id) throws NotItemFound {
        for (T item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        throw new NotItemFound("No item found with ID: " + id);
    }

    public boolean removeItemById(int id) {
        return items.removeIf(item -> item.getId() == id);
    }

    public void displayItems() {
        if (items.isEmpty()) {
            System.out.println("No items found.");
        } else {
            System.out.println("Library Items:");
            for (T item : items) {
                System.out.println(item.getItemDetails());
            }
        }
    }
}
