import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Client {
    private int stt;
    private String name;
    private int age;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private List<BookHired> listHiredBooks;

    public Client() {
        this.listHiredBooks = new ArrayList<>();
    }

    // setter, getter

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

    //age
    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public void setDateStart() {
        this.dateStart = LocalDate.now();
        this.dateStart = dateStart.plusDays(0);
    }

    public String getDateStart() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return this.dateStart.format(formatter);
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = LocalDate.parse(dateEnd, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public String getDateEnd() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return this.dateEnd.format(formatter);
    }

    // listHiredBooks
    public void setListHiredBooks(BookHired book) {
        this.listHiredBooks.add(book);
    }


    @Override
    public String toString() {

        return "Client{" +
                "stt='" + stt + '\'' +
                "name='" + name + '\'' +
                ", age=" + age +
                ", dateStart=" + dateStart +
                ", dateEnd=" + dateEnd;
//        +
//                '}';
    }

    public void display() {
        String temp = "";
        for (BookHired listHiredBook : listHiredBooks) {
            temp += listHiredBook.getBook() + ", countHired:" + listHiredBook.getCount() + "}, ";
        }
        System.out.println(toString() + ", listHiredBooks =[{" + temp + "]");
    }
}
