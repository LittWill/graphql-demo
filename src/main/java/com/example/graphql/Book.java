package com.example.graphql;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public record Book(String id, String name, int pageCount, Author author) {
    
    private static int NEXT_ID = 4;

    private static final List<Book> BOOKS = new ArrayList<>(List.of(
            new Book("book-1", "Effective Java", 416, Author.authors.get(0)),
            new Book("book-2", "Hitchihiker's Guide to the Galaxy", 208, Author.authors.get(1)),
            new Book("book-3", "Down Under", 436, Author.authors.get(2)))
    );
    
    public static Book getById(String id) {
        return BOOKS.stream().filter(book -> book.id().equals(id)).findFirst().orElse(null);
    }
    
    public static Collection<Book> findAll(){
        return BOOKS;
    }

    public static Book save(String name, int pageCount, String authorId) {
        Book book = new Book("book-" + NEXT_ID, name, pageCount,
                Author.authors.stream().filter(author -> author.id().equals(authorId)).findAny().orElseThrow());
        BOOKS.add(book);
        NEXT_ID += 1;
        return book;
    }

}
