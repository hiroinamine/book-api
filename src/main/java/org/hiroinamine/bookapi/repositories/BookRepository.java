package org.hiroinamine.bookapi.repositories;

import org.hiroinamine.bookapi.models.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {
}
