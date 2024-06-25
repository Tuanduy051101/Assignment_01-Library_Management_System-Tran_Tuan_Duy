package vn.edu.likelion.library.application;


import vn.edu.likelion.library.controller.Library;
import vn.edu.likelion.library.model.Book;
import vn.edu.likelion.library.model.Rental;
import vn.edu.likelion.library.model.User;

import java.util.*;

public class LibraryApp {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Library Management System is running: ");
        int chose;
        // interface level 1
        do {
            displayMainMenu();
            chose = getValidIntInput(scanner);

            switch (chose) {
                case 1:
                    handleBooks(library, scanner);
                    break;
                case 2:
                    handleUsers(library, scanner);
                    break;
                case 0:
                    System.out.println("Chương trình đã kết thúc !");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng thử lại.");
            }
        } while (chose != 0);
    }

    // show primary menu
    private static void displayMainMenu() {
        System.out.println("Danh sách các mục:");
        System.out.println("1. Books");
        System.out.println("2. Users");
        System.out.println("0. Exit");
        System.out.print("Chọn một trong các mục sau để thao tác: ");
    }

    // handle books interface level 1.1
    private static void handleBooks(Library library, Scanner scanner) {
        System.out.println("Bạn đã chọn thao tác với Books !");
        displayBookMenu();
        int choseTask = getValidIntInput(scanner);

        switch (choseTask) {
            case 1:
                // add new book
                addBook(library, scanner);
                break;
            case 2:
                // edit book
                editBook(library, scanner);
                break;
            case 3:
                // delete book
                deleteBook(library, scanner);
                break;
            case 4:
                // list all books
                library.listBooks();
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ, vui lòng thử lại.");
        }
    }

    // menu interface level 1.1
    private static void displayBookMenu() {
        System.out.println("1. Thêm sách");
        System.out.println("2. Sửa sách");
        System.out.println("3. Xoá sách");
        System.out.println("4. Xem tất cả sách");
        System.out.print("Chọn một trong các chức năng sau để thực hiện: ");
    }

    // method to add a new book
    private static void addBook(Library library, Scanner scanner) {
        int exit = 1;
        while (exit == 1) {
            Book book = new Book();
            System.out.println("Chức năng thêm sách");
            System.out.print("Nhập stt: ");
            book.setId(getValidIntInput(scanner));
            scanner.nextLine();
            System.out.print("Nhập name: ");
            book.setTitle(scanner.nextLine());
            System.out.print("Nhập author: ");
            book.setAuthor(scanner.nextLine());
            System.out.print("Nhập số lượng hiện tại: ");
            book.setQuantity(getValidIntInput(scanner));
            scanner.nextLine();

            // check book exists
            if (!library.findBookByStt(book.getId())) {
                if (library.findBookByTitleAndAuthor(book.getTitle(), book.getAuthor())) {
                    System.out.println("Sách đã tồn tại !");
                } else {
                    // add book to library
                    library.addBook(book);
                    library.listBooks();
                }
            } else {
                System.out.println("Stt đã tồn tại !");
            }

            // ask user to continue
            System.out.println("1. Tiếp tục thêm sách");
            System.out.println("0. Thoát");
            System.out.print("Chọn thao tác: ");
            exit = getValidIntInput(scanner);
            scanner.nextLine();
        }
    }

    // method to edit a book
    private static void editBook(Library library, Scanner scanner) {
        System.out.println("Chức năng sửa sách");
        System.out.print("Nhập vào số thứ tự cần sửa: ");
        int idEdit = getValidIntInput(scanner);
        scanner.nextLine();

        if (library.findBookByStt(idEdit)) {
            int choseTypeEdit;
            do {
                displayEditBookMenu();
                choseTypeEdit = getValidIntInput(scanner);
                scanner.nextLine();

                switch (choseTypeEdit) {
                    case 1:
                        // edit title
                        System.out.print("Nhập vào tên sách mới: ");
                        String newTitle = scanner.nextLine();
                        if (library.findBookByTitleAndAuthor(newTitle, library.getBook(idEdit).getAuthor())) {
                            System.out.println("Sách đã tồn tại!");
                            break;
                        }
                        library.updateTile(idEdit, newTitle);
                        System.out.println("Đã cập nhật thành công !");
                        library.listBooks();
                        break;
                    case 2:
                        // edit author
                        System.out.print("Nhập vào tên tác giả mới: ");
                        String newAuthor = scanner.nextLine();
                        if (library.findBookByTitleAndAuthor(library.getBook(idEdit).getTitle(), newAuthor)) {
                            System.out.println("Sách đã tồn tại!");
                            break;
                        }
                        library.updateAuthor(idEdit, newAuthor);
                        System.out.println("Đã cập nhật thành công !");
                        library.listBooks();
                        break;
                    case 3:
                        // edit quantity
                        System.out.print("Nhập số sách nhập kho: ");
                        int newStockQuantity = getValidIntInput(scanner);
                        library.updateQuantity(idEdit, newStockQuantity);
                        System.out.println("Đã cập nhật thành công !");
                        library.listBooks();
                        break;
                }
            } while (choseTypeEdit != 0);
        } else {
            System.out.println("Số thứ tự không hợp lệ");
        }
    }

    // menu interface level 1.1.2
    private static void displayEditBookMenu() {
        System.out.println("Danh sách cập nhật: ");
        System.out.println("1. Cập nhật tên sách");
        System.out.println("2. Cập nhật tên tác giả");
        System.out.println("3. Cập nhật số lượng hiện tại");
        System.out.println("0. Thoát");
        System.out.print("Chọn thuộc tính cần cập nhật: ");
    }

    // method to delete a book
    private static void deleteBook(Library library, Scanner scanner) {
        System.out.println("Chức năng xoá sách");
        System.out.print("Nhập vào số thứ tự cần xoá: ");
        int idDelete = getValidIntInput(scanner);
        scanner.nextLine();

        if (library.findBookByStt(idDelete)) {
            library.deleteBook(idDelete);
            System.out.println("Đã xoá thành công book có stt = " + idDelete);
            library.listBooks();
        } else {
            System.out.println("Số thứ tự không hợp lệ");
        }
    }

    // handle rental
    private static void handleUsers(Library library, Scanner scanner) {
        System.out.println("Bạn đã chọn thao tác với Clients !");
        displayClientMenu();
        int choseTask = getValidIntInput(scanner);
        scanner.nextLine();

        switch (choseTask) {
            case 1:
                // add a new user
                addClient(library, scanner);
                break;
            case 2:
                // edit a user
                editClient(library, scanner);
                break;
            case 3:
                // display all users
                library.listUsers();
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ, vui lòng thử lại.");
        }
    }

    // menu interface level 1.2
    private static void displayClientMenu() {
        System.out.println("1. Thêm thông tin người thuê");
        System.out.println("2. Sửa thông tin người thuê");
        System.out.println("3. Danh sách người thuê");
        System.out.print("Chọn một trong các chức năng sau để thực hiện: ");
    }

    // method to add a new user
    private static void addClient(Library library, Scanner scanner) {
        int exit = 1;
        while (exit == 1) {
            User user = new User();
            System.out.println("Thêm thông tin người thuê:");
            System.out.print("Nhập số thứ tự: ");
            int idUser = getValidIntInput(scanner);

            // check if id already exists in the library
            if (library.findUserByStt(idUser)) {
                System.out.println("Số thứ tự đã tồn tại!");
                break;
            }

            user.setId(idUser);
            scanner.nextLine();
            System.out.print("Nhập tên: ");
            user.setName(scanner.nextLine());
            System.out.print("Nhập tuổi: ");
            int age = getValidIntInput(scanner);
            scanner.nextLine();

            // check if age is valid
            if (age > 16) {
                user.setAge(age);
            } else {
                System.out.println("Tuổi không hợp lệ, phải lớn hơn 16.");
                break;
            }

            List<Rental> rentals = new ArrayList<>();

            do {
                System.out.println("Danh sách sách: ");
                library.listBooks();

                System.out.print("Nhập stt sách muốn thuê: ");
                int sttBookHire = getValidIntInput(scanner);

                System.out.print("Nhập số lượng sách muốn thuê: ");
                int countBookHire = getValidIntInput(scanner);
                scanner.nextLine();

                Book book = library.getBook(sttBookHire);

                // check if book is available for rental
                if (countBookHire != 0 && countBookHire <= book.getQuantity()) {
                    book.setQuantity(book.getQuantity() - countBookHire);
                    Rental rental = new Rental();
                    // set rental date
                    rental.setRentalDate();
                    System.out.println("Ngày đăng ký: " + rental.getRentalDate());
                    System.out.print("Nhập ngày trả sách [yyyy-MM-dd]: ");

                    rental.setReturnDate(scanner.nextLine());

                    rental.setBook(book);
                    rental.setQuantity(countBookHire);

                    rentals.add(rental);
                } else {
                    System.out.println("Số lượng sách không hợp lệ.");
                    break;
                }

                // ask user if they want to rent more books
                System.out.println("1. Tiếp tục đăng ký sách");
                System.out.println("0. Thoát");
                System.out.print("Chọn thao tác: ");
                exit = getValidIntInput(scanner);
                scanner.nextLine();
            } while (exit != 0);

            // add user to the library
            user.setRentals(rentals);
            library.addUser(user);
            library.listUsers();

            // ask user if they want to add more clients
            System.out.println("1. Tiếp tục thêm thông tin người thuê");
            System.out.println("0. Thoát");
            System.out.print("Chọn thao tác: ");
            exit = getValidIntInput(scanner);
            scanner.nextLine();
        }
    }

    // edit a user
    private static void editClient(Library library, Scanner scanner) {
        System.out.println("Sửa thông tin người thuê");
        System.out.print("Nhập vào số thứ tự cần sửa: ");
        int idEdit = getValidIntInput(scanner);
        scanner.nextLine();

        if (library.findUserByStt(idEdit)) {
            int choseTypeEdit;
            do {
                displayEditClientMenu();
                choseTypeEdit = getValidIntInput(scanner);
                scanner.nextLine();

                switch (choseTypeEdit) {
                    case 1:
                        System.out.print("Nhập vào tên mới: ");
                        String newName = scanner.nextLine();
                        library.updateName(idEdit, newName);
                        System.out.println("Đã cập nhật thành công !");
                        library.listUsers();
                        break;
                    case 2:
                        System.out.print("Nhập số tuổi người thuê: ");
                        int newAge = getValidIntInput(scanner);
                        scanner.nextLine();
                        library.updateAge(idEdit, newAge);
                        System.out.println("Đã cập nhật thành công !");
                        library.listUsers();
                        break;
                }
            } while (choseTypeEdit != 0);
        } else {
            System.out.println("Số thứ tự không hợp lệ");
        }
    }

    // menu interface level 1.2.2
    private static void displayEditClientMenu() {
        System.out.println("Danh sách cập nhật: ");
        System.out.println("1. Cập nhật tên");
        System.out.println("2. Cập nhật tuổi");
        System.out.println("0. Thoát");
        System.out.print("Chọn thuộc tính cần cập nhật: ");
    }

    // method to get valid value input from user
    private static int getValidIntInput(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Đầu vào không hợp lệ. Vui lòng nhập giá trị hợp lệ.");
                scanner.nextLine();
            }
        }
    }
}