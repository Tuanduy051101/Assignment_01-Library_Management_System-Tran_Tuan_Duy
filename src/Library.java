import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books;
    private List<Client> clients;

    public Library() {
        this.books = new ArrayList<>();
        this.clients = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void updateName(int stt, String newName) {
        for (Book book : books) {
            if(book.getStt() == stt) {
                book.setName(newName);
            }
        }
    }

    public void updateAuthor(int stt, String newAuthor) {
        for (Book book : books) {
            if(book.getStt() == stt) {
                book.setAuthor(newAuthor);
            }
        }
    }

    public void updateCountCurrent(int stt, int newNumber) {
        for (Book book : books) {
            if(book.getStt() == stt) {
                book.setCountCurrent(book.getCountCurrent() + newNumber);
            }
        }
    }


    public void removeBook(int stt) {
        books.removeIf(book -> book.getStt() == stt);
    }

    public void removeAllBook() {
        books.clear();
    }

    public boolean findBookByName(String name) {
        for (Book book : books) {
            if (book.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean findBookByStt(int stt) {
        for (Book book : books) {
            if(book.getStt() == stt) {
                return true;
            }
        }
        return false;
    }

    public boolean findBookByAuthor(String author) {
        for (Book book : books) {
            if(book.getAuthor().equalsIgnoreCase(author)) {
                return true;
            }
        }
        return false;
    }

    public Book getBook(int id) {
        for (Book book : books) {
            if(book.getStt() == id) {
                return book;
            }
        }
        return null;
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void addClient(Client client) {
        this.clients.add(client);
    }

    public List<Client>  sortClient() {
        List<Client> list = clients.stream().sorted(Comparator.comparing(Client::getDateEnd)).collect(Collectors.toList());
        return list;
    }

    public void displayClients() {
        for (Client client : clients) {

            client.display();
        }
    }

    public void updateClientName(int id, String name) {
        this.clients = sortClient();
        for (Client client : clients) {
            if(client.getStt() == id) {
                client.setName(name);
            }
        }
    }

    public void updateClientAge(int id, int age) {
        for (Client client : clients) {
            if(client.getStt() == id) {
                client.setAge(age);
            }
        }
    }

    public void updateDateEnd(int id, String date) {
        for (Client client : clients) {
            if(client.getStt() == id) {
                client.setDateEnd(date);
            }
        }
    }

    public boolean findClientByStt(int stt) {
        for (Client client : clients) {
            if(client.getStt() == stt) {
                return true;
            }
        }
        return false;
    }


}
