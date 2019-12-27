package org.hiroinamine.bookapi.models;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Book {
    @Id
    private String id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String publisher;
    @NotEmpty
    private String category;
    @NotNull
    private Integer year;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getCategory() {
        return category;
    }

    public Integer getYear() {
        return year;
    }

    public Book() {
    }

    public Book(String id, String name, String publisher, String category, Integer year) {
        this.id = id;
        this.name = name;
        this.publisher = publisher;
        this.category = category;
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format(
                "Book[id=%s, name='%s', publisher='%s', category='%s', year='%d']",
                id, name, publisher, category, year);
    }
}
