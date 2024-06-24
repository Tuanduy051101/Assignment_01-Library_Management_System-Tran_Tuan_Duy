public class BookHired {
    private Book book;
    private int count;

    public BookHired() {}

    // setter, getter

    public void setBook(Book book) {
        this.book = book;
    }

    public String getBook() {
        return this.book.toString();
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return this.count;
    }

}
