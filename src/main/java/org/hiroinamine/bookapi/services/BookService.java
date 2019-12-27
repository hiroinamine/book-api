package org.hiroinamine.bookapi.services;

import org.hiroinamine.bookapi.models.Book;
import org.hiroinamine.bookapi.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {
    private final BookRepository repo;

    @Autowired
    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    public Page<Book> findAll(int size, int page, Optional<String> sortBy) {
        Pageable pageable = sortBy
                .map(s -> PageRequest.of(page, size, Sort.by(s)))
                .orElse(PageRequest.of(page, size));

        return repo.findAll(pageable);
    }

    public Optional<Book> findById(String id) {
        return repo.findById(id);
    }

    public Book insert(Book book) {
        return repo.insert(book);
    }

    public int deleteById(String id) {
        repo.deleteById(id);
        return 1;
    }

    public Book updateById(String id, Book bookToUpdate) {
        bookToUpdate.setId(id);
        return repo.save(bookToUpdate);
    }

    public void deleteAll() {
        repo.deleteAll();
    }
}
