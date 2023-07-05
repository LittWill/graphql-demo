package com.example.graphql;

import jakarta.validation.Valid;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.Arguments;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Collection;

@Controller
public class BookController {

    @MutationMapping("bookSave")
    public Book save(@Arguments @Valid SaveBookDTO saveBookDTO) {
        return Book.save(saveBookDTO.name(), saveBookDTO.pageCount(), saveBookDTO.authorId());
    }

    @QueryMapping("bookById")
    public Book findById(@Argument String id) {
        return Book.getById(id);
    }

    @QueryMapping("bookFindAll")
    public Collection<Book> findAll() {
        return Book.findAll();
    }

}
