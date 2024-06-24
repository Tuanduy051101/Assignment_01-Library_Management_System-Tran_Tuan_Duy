public class Book {
    private int stt;
    private String name;
    private String author;
    private int countCurrent;

    public Book() {

    }

    public Book(int stt, String name, String author, int countCurrent) {
        this.stt = stt;
        this.name = name;
        this.author = author;
        this.countCurrent = countCurrent;
    }

    // getter, setter

    // stt
    public void setStt(int stt) {
        this.stt = stt;
    }

    public int getStt() {
        return this.stt;
    }

    // name
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    //author
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return this.author;
    }

    //countCurrent
    public void setCountCurrent(int countCurrent) {
        this.countCurrent = countCurrent;
    }

    public int getCountCurrent() {
        return this.countCurrent;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + stt +
                ", title='" + name + '\'' +
                ", author='" + author + '\'' +
                ", countCurrent=" + countCurrent +
                '}';
    }
}
