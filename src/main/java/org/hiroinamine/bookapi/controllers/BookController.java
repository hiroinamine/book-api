package org.hiroinamine.bookapi.controllers;

import org.hiroinamine.bookapi.models.Book;
import org.hiroinamine.bookapi.services.BookService;
import org.hiroinamine.bookapi.utils.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RequestMapping("/api/books")
@RestController
public class BookController {
    private final BookService service;

    @Autowired
    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping
    public Page<Book> list(
            @RequestParam(defaultValue = "5") Integer size,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam Optional<String> sortBy) {
        return service.findAll(size, page, sortBy);
    }

    @GetMapping(path = "{id}")
    public Book get(@PathVariable("id") String id) {
        return service.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    @PostMapping
    public Book create(@Valid @RequestBody Book book) {
        return service.insert(book);
    }

    @PutMapping(path = "{id}")
    public Book update(@PathVariable("id") String id, @Valid @RequestBody Book bookToUpdate) {
        return service.findById(id)
                .map(book -> service.updateById(id, bookToUpdate))
                .orElseThrow(() -> new BookNotFoundException(id));
    }


    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable("id") String id) {
        service.findById(id)
                .map(book -> service.deleteById(id))
                .orElseThrow(() -> new BookNotFoundException(id));
    }


}
