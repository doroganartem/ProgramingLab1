package com.kpi;

import com.kpi.model.*;
import com.kpi.Service.Service;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("1. Додати книгу");
            System.out.println("2. Додати читача");
            System.out.println("3. Взяти книгу");
            System.out.println("4. Повернути книгу");
            System.out.println("5. Показати книги");
            System.out.println("0. Вихід");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("ID:");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Назва:");
                    String title = scanner.nextLine();

                    System.out.println("Автор:");
                    String author = scanner.nextLine();

                    library.addBook(new Book(id, title, author));
                    break;

                case 2:
                    System.out.println("ID:");
                    int rId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Ім'я:");
                    String name = scanner.nextLine();

                    library.addReader(new Reader(rId, name));
                    break;

                case 3:
                    System.out.println("Reader ID:");
                    int readerId = scanner.nextInt();

                    System.out.println("Book ID:");
                    int bookId = scanner.nextInt();

                    System.out.println(library.borrowBook(readerId, bookId));
                    break;

                case 4:
                    System.out.println("Reader ID:");
                    readerId = scanner.nextInt();

                    System.out.println("Book ID:");
                    bookId = scanner.nextInt();

                    System.out.println(library.returnBook(readerId, bookId));
                    break;

                case 5:
                    library.getBooks().forEach(b ->
                            System.out.println(b.getTitle() + " " + b.isAvailable()));
                    break;

                case 0:
                    return;
            }
        }
    }
}