package com.kpi;

import com.kpi.Service.Service;
import com.kpi.model.Book;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {

    @Test
    void testExportAndImportBooks() throws Exception {

        Service service = new Service();

        List<Book> books = new ArrayList<>();
        books.add(new Book(2, "Java", "AuthorB"));
        books.add(new Book(1, "Algorithms", "AuthorA"));

        File tempFile = File.createTempFile("books", ".csv");

        service.exportBooks(books, tempFile.getAbsolutePath());

        List<Book> imported = service.importBooks(tempFile.getAbsolutePath());

        assertEquals(2, imported.size());
        assertEquals("Algorithms", imported.get(0).getTitle());
        assertEquals("Java", imported.get(1).getTitle());
    }
}