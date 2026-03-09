package com.kpi.Service;

import com.kpi.model.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Service {

    public void exportBooks(List<Book> books, String path) throws IOException {

        books.sort(Comparator.comparing(Book::getTitle));

        BufferedWriter writer = new BufferedWriter(new FileWriter(path));

        for (Book b : books) {
            writer.write(b.getId() + "," + b.getTitle() + "," + b.getAuthor());
            writer.newLine();
        }

        writer.close();
    }

    public List<Book> importBooks(String path) throws IOException {

        List<Book> books = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(path));

        String line;

        while ((line = reader.readLine()) != null) {

            String[] parts = line.split(",");

            int id = Integer.parseInt(parts[0]);
            String title = parts[1];
            String author = parts[2];

            books.add(new Book(id, title, author));
        }

        reader.close();

        return books;
    }
}
