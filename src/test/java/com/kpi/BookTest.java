package com.kpi;

import com.kpi.model.Book;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void borrowBookSuccess() {

        Book book = new Book(1, "Java", "Author");

        boolean result = book.borrowBook();

        assertTrue(result);
        assertFalse(book.isAvailable());
    }

    @Test
    void borrowBookWhenAlreadyBorrowed() {

        Book book = new Book(1, "Java", "Author");

        book.borrowBook();
        boolean result = book.borrowBook();

        assertFalse(result);
    }

    @Test
    void returnBookMakesAvailable() {

        Book book = new Book(1, "Java", "Author");

        book.borrowBook();
        book.returnBook();

        assertTrue(book.isAvailable());
    }
}

