package com.kpi.model;

import java.util.*;

public class Library {

    private List<Book> books = new ArrayList<>();
    private List<Reader> readers = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void addReader(Reader reader) {
        readers.add(reader);
    }

    public boolean borrowBook(int readerId, int bookId) {

        Book book = findBook(bookId);
        Reader reader = findReader(readerId);

        if (book == null || reader == null || !book.isAvailable()) {
            return false;
        }

        book.borrowBook();
        reader.borrowBook(book);

        return true;
    }

    public boolean returnBook(int readerId, int bookId) {

        Book book = findBook(bookId);
        Reader reader = findReader(readerId);

        if (book == null || reader == null) {
            return false;
        }

        book.returnBook();
        reader.returnBook(book);

        return true;
    }

    public Book findBook(int id) {
        return books.stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Reader findReader(int id) {
        return readers.stream()
                .filter(r -> r.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Reader> getReaders() {
        return readers;
    }
}
