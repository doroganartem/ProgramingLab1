package com.kpi.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Reader {

    private int id;
    private String name;
    private List<Book> borrowedBooks = new ArrayList<>();

    public Reader(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reader)) return false;
        Reader reader = (Reader) o;
        return id == reader.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
