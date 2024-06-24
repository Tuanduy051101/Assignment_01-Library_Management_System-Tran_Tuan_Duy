import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        int chose = 0;

        System.out.println("Library Management System is running: ");
        do {
            System.out.println("Danh sách các mục:");

            System.out.println("1. Books");
            System.out.println("2. Client");
            System.out.println("0. Exit");
            System.out.println("Chọn một trong các mục sau để thao tác: ");
            chose = scanner.nextInt();
            scanner.nextLine();

            if (chose == 1) {
                int choseTask;
                System.out.println("Bạn đã chọn thao tác với Books !");
                System.out.println("1. Thêm sách");
                System.out.println("2. Sửa sách");
                System.out.println("3. Xoá sách");
                System.out.println("4. Xem danh sách sách");
                System.out.println("Chọn một trong các chức năng sau để thực hiện: ");
                choseTask = scanner.nextInt();
                scanner.nextLine();
                switch (choseTask) {
                    case 1:
                        int exit = 1;
                        while (exit == 1) {
                            Book book = new Book();
                            System.out.println("Chức năng thêm sách");
                            System.out.print("Nhập stt: ");
                            book.setStt(scanner.nextInt());
                            scanner.nextLine();
                            System.out.print("Nhập name: ");
                            book.setName(scanner.nextLine());
                            System.out.print("Nhập author: ");
                            book.setAuthor(scanner.nextLine());
                            System.out.print("Nhập số lượng hiện tại: ");
                            book.setCountCurrent(scanner.nextInt());
                            scanner.nextLine();
                            if (!library.findBookByStt(book.getStt())) {
                                if(library.findBookByName(book.getName())) {
                                    System.out.println("Ten sach da ton tai");
                                    if(!library.findBookByAuthor(book.getAuthor())) {
                                        library.addBook(book);
                                        library.displayBooks();
                                    } else {
                                        System.out.println("Book đã tồn tại !");
                                    }
                                } else {
                                    library.addBook(book);
                                    library.displayBooks();
                                }

                            } else {
                                System.out.println("Book đã tồn tại !");
                            }
                            System.out.println("1. Nhập tiếp");
                            System.out.println("2. Thoát");
                            System.out.print("Chọn thao tác: ");
                            exit = scanner.nextInt();
                            scanner.nextLine();
                        }
                        break;
                    case 2:
                        System.out.println("Chức năng sửa sách");
                        System.out.print("Nhập vào số thứ tự cần sửa: ");
                        int idEdit = scanner.nextInt();
                        scanner.nextLine();
                        if (library.findBookByStt(idEdit)) {
                            int choseTypeEdit = 0;
                            do {
                                System.out.println("Danh sách cập nhật: ");
                                System.out.println("1. Cập nhật tên sách");
                                System.out.println("2. Cập nhật tên tên tác giả");
                                System.out.println("3. Cập nhật số lượng hiện tại");
                                System.out.println("0. Thoát");

                                System.out.print("\nChọn thuộc tính cần cập nhật: ");
                                choseTypeEdit = scanner.nextInt();
                                scanner.nextLine();

                                switch (choseTypeEdit) {
                                    case 1:
                                        System.out.println("Cập nhật tên sách: ");
                                        System.out.print("Nhập vào tên sách mới: ");
                                        String newName = scanner.nextLine();
                                        library.updateName(idEdit, newName);
                                        System.out.println("Đã cập nhật thành công !");
                                        library.displayBooks();
                                        break;
                                    case 2:
                                        System.out.println("Cập nhật tên tác giả: ");
                                        System.out.print("Nhập vào tên tác giả mới: ");
                                        String newAuthor = scanner.nextLine();
                                        library.updateAuthor(idEdit, newAuthor);
                                        System.out.println("Đã cập nhật thành công !");
                                        library.displayBooks();
                                        break;
                                    case 3:
                                        System.out.println("Cập nhật số lượng sách hiện tại: ");
                                        System.out.print("Nhập số sách nhập kho : ");
                                        int newNumber = scanner.nextInt();
                                        library.updateCountCurrent(idEdit, newNumber);
                                        System.out.println("Đã cập nhật thành công !");
                                        library.displayBooks();
                                        break;
                                }

                            }while (choseTypeEdit != 0);

                        } else {
                            System.out.println("Số thứ tự không hợp lệ");
                        }
                        break;
                    case 3:
                        System.out.println("Chức năng xoá sách");
                        System.out.print("Nhập vào số thứ tự cần xoá: ");
                        int idDelete = scanner.nextInt();
                        scanner.nextLine();
                        if (library.findBookByStt(idDelete)) {
                            library.removeBook(idDelete);
                            System.out.println("Đã xoá thành công book có stt = " + idDelete);
                            library.displayBooks();
                        } else {
                            System.out.println("Số thứ tự không hợp lệ");
                        }
                        break;
                    case 4:
                        System.out.println("Danh sách sách: ");
                        library.displayBooks();
                        break;
                    default:
                        System.out.println("Chương trình đã kết thúc !");
                }
            } else if (chose == 2) {
                int choseTask;
                System.out.println("Bạn đã chọn thao tác với Clients !");
                System.out.println("1. Thêm thông tin người thuê");
                System.out.println("2. Sửa thông tin người thuê");
                System.out.println("3. Danh sách người thuê");
                System.out.println("Chọn một trong các chức năng sau để thực hiện: ");
                choseTask = scanner.nextInt();
                scanner.nextLine();
                switch (choseTask) {
                    case 1:
                        int exit = 1;
                        while (exit == 1) {
                            Client client = new Client();
                            System.out.println("Thêm thông tin người thuê:");
                            System.out.print("Nhập số thứ tự: ");
                            client.setStt(scanner.nextInt());
                            scanner.nextLine();
                            System.out.print("Nhập tên: ");
                            client.setName(scanner.nextLine());
                            System.out.print("Nhập tuổi: ");
                            int age = scanner.nextInt();
                            scanner.nextLine();
                            if (age > 16) {
                                client.setAge(age);
                            } else {
                                break;
                            }
                            client.setDateStart();
                            System.out.println("Ngày đăng ký: " + client.getDateStart());
                            System.out.print("Nhập ngày trả sách [yyyy-MM-dd]: ");
                            client.setDateEnd(scanner.nextLine());

                            System.out.println("Danh sách sách: ");

                            library.displayBooks();

                            System.out.print("Nhập stt sách muốn thuê: ");

                            int sttBookHire = scanner.nextInt();

                            System.out.print("Nhập số lượng sách muốn thuê: ");

                            int countBookHire = scanner.nextInt();
                            Book book = library.getBook(sttBookHire);

                            if (countBookHire!=0 && countBookHire <= book.getCountCurrent()) {
                                book.setCountCurrent(book.getCountCurrent() - countBookHire);

                                BookHired bookHired = new BookHired();
                                bookHired.setBook(book);
                                bookHired.setCount(countBookHire);

                                client.setListHiredBooks(bookHired);

                                library.addClient(client);

                                library.displayClients();
                            } else {
                                break;
                            }

                            System.out.println("1. Nhập tiếp");
                            System.out.println("2. Thoát");
                            System.out.print("Chọn thao tác: ");
                            exit = scanner.nextInt();
                            scanner.nextLine();
                        }
                        break;
                    case 2:
                        System.out.println("Sửa thông tin người thuê");
                        System.out.print("Nhập vào số thứ tự cần sửa: ");
                        int idEdit = scanner.nextInt();
                        scanner.nextLine();
                        if (library.findClientByStt(idEdit)) {
                            int choseTypeEdit = 0;
                            do {
                                System.out.println("Danh sách cập nhật: ");
                                System.out.println("1. Cập nhật tên");
                                System.out.println("2. Cập nhật tuổi");
                                System.out.println("0. Thoát");

                                System.out.print("\nChọn thuộc tính cần cập nhật: ");
                                choseTypeEdit = scanner.nextInt();
                                scanner.nextLine();

                                switch (choseTypeEdit) {
                                    case 1:
                                        System.out.println("Cập nhật tên người thuê: ");
                                        System.out.print("Nhập vào tên mới: ");
                                        String newName = scanner.nextLine();
                                        library.updateClientName(idEdit, newName);
                                        System.out.println("Đã cập nhật thành công !");
                                        library.displayClients();
                                        break;
                                    case 2:
                                        System.out.println("Cập nhật số tuổi người thuê: ");
                                        System.out.print("Nhập số tuổi người thuê : ");
                                        int newAge = scanner.nextInt();
                                        scanner.nextLine();
                                        library.updateClientAge(idEdit, newAge);
                                        System.out.println("Đã cập nhật thành công !");
                                        library.displayClients();
                                        break;
                                }

                            }while (choseTypeEdit != 0);

                        } else {
                            System.out.println("Số thứ tự không hợp lệ");
                        }
                        break;
                    case 3:
                        System.out.println("Danh sách người thuê: ");
                        library.displayClients();
                        break;
                    default:
                        System.out.println("Chương trình đã kết thúc !");
                }
            }
        }while (chose != 0);

    }
}

