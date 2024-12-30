public class Book extends LibraryItem {
    private String author;

    public Book(int id, String title, String author) {
        super(id, title);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String getItemDetails() {
        return "Book Details => [ID: " + getId() + "], [Title: " + getTitle() + "], [Author: " + author + "]";
    }
}