package vn.edu.likelion.library.controller;

import vn.edu.likelion.library.model.Book;
import vn.edu.likelion.library.model.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    // book methods
    public boolean findBookByTile(String name) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean findBookByStt(int stt) {
        for (Book book : books) {
            if (book.getId() == stt) {
                return true;
            }
        }
        return false;
    }

    public boolean findBookByAuthor(String author) {
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                return true;
            }
        }
        return false;
    }

    public boolean findBookByTitleAndAuthor(String title, String author) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.getAuthor().equalsIgnoreCase(author)) {
                return true;
            }
        }
        return false;
    }

    public void addBook(Book book) {
        books.add(book);
    }


    public void updateBook(int stt, String title, String author, int quantity) {
        for (Book book : books) {
            if (book.getId() == stt) {
                book.setTitle(title);
                book.setAuthor(author);
                book.setQuantity(quantity);
                break;
            }
        }
    }

    public void updateTile(int stt, String title) {
        for (Book book : books) {
            if (book.getId() == stt) {
                book.setTitle(title);
                break;
            }
        }
    }

    public void updateAuthor(int stt, String author) {
        for (Book book : books) {
            if (book.getId() == stt) {
                book.setAuthor(author);
                break;
            }
        }
    }

    public void updateQuantity(int stt, int quantity) {
        for (Book book : books) {
            if (book.getId() == stt) {
                book.setQuantity(quantity + book.getQuantity());
                break;
            }
        }
    }


    public void deleteBook(int stt) {
        // removeIf là một method của Collections
        books.removeIf(book -> book.getId() == stt);
    }


    public void listBooks() {
        if(books.isEmpty()) {
            System.out.println("Danh sách sách trống !");
            return;
        }
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public Book getBook(int stt) {
        for (Book book : books) {
            if (book.getId() == stt) {
                return book;
            }
        }
        return null;
    }

    // user methods

    public boolean findUserByStt(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public void addUser(User user) {
        users.add(user);
    }


    public void updateUser(int id, String name, int age) {
        for (User user : users) {
            if (user.getId() == id) {
                user.setName(name);
                user.setAge(age);
                break;
            }
        }
    }

    public void updateName(int id, String name) {
        for (User user : users) {
            if (user.getId() == id) {
                user.setName(name);
                break;
            }
        }
    }

    public void updateAge(int id, int age) {
        for (User user : users) {
            if (user.getId() == id) {
                user.setAge(age);
                break;
            }
        }
    }

    public void listUsers() {

        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                return u2.getRentals().get(0).getRentalDate().compareTo(u1.getRentals().get(0).getRentalDate());
            }
        });

        if (!users.isEmpty()) {
            for (User user : users) {
                System.out.println(user);
            }
        } else {
            System.out.println("Danh sách người dùng trống !");
        }
    }

}
