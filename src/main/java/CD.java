import java.time.LocalDate;

public class CD extends LibraryItem {
    // Fields
    private String length;
    // Constructor
    public CD(int id, ItemType itemType, String title, String author, double price, boolean available,
              int numberOfItemsAvailable, String length) {
        super(id, itemType, title, author, price, available, numberOfItemsAvailable);
        this.length = length;
    }

    // Getters and Setters
    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    /**
     * This method overrides toString() method and formats book info
     * @return
     */
    public String toString() {
        return String.format("\n\u001B[32mTitle:\u001B[0m %s\n" +
                        "\u001B[32mAuthor:\u001B[0m %s\n" +
                        "\u001B[32mLength:\u001B[0m%s",
                getTitle(), getAuthor(), length);
    }

    /**
     * This method implements abstract method from LibraryItem class and
     * formats book info as JSON literal
     * @return
     */
    public String formatJSON() {
        String jsonString = String.format("{\n \"id\": %d, \n \"type\": \"%s\", " +
                        "\n \"title\": \"%s\", \n \"author\": \"%s\", \n \"length\": \"%s\"," +
                        "\n \"available\": %b, \n \"itemsAvailable\": %d \n}",
                getId(), getItemType().getDisplayName(), getTitle(), getAuthor(), length, isAvailable(),
                getNumberOfItemsAvailable());
        return jsonString;
    }

    public void checkoutCD(User user) {
        checkoutItem(user);
    }
}
