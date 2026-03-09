package com.kpi;

import com.kpi.model.Library;
import com.kpi.model.Book;
import com.kpi.model.Reader;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    @Test
    void borrowBookSuccess() {

        Library library = new Library();

        Book book = new Book(1, "Java", "Author");
        Reader reader = new Reader(1, "Artem");

        library.addBook(book);
        library.addReader(reader);

        boolean result = library.borrowBook(1, 1);

        assertTrue(result);
    }

    @Test
    void borrowBookWhenBookNotFound() {

        Library library = new Library();
        Reader reader = new Reader(1, "Artem");

        library.addReader(reader);

        boolean result = library.borrowBook(1, 99);

        assertFalse(result);
    }

    @Test
    void borrowBookWhenReaderNotFound() {

        Library library = new Library();
        Book book = new Book(1, "Java", "Author");

        library.addBook(book);

        boolean result = library.borrowBook(99, 1);

        assertFalse(result);
    }

    @Test
    void returnBookSuccess() {

        Library library = new Library();

        Book book = new Book(1, "Java", "Author");
        Reader reader = new Reader(1, "Artem");

        library.addBook(book);
        library.addReader(reader);

        library.borrowBook(1,1);

        boolean result = library.returnBook(1,1);

        assertTrue(result);
        assertTrue(book.isAvailable());
    }
}
