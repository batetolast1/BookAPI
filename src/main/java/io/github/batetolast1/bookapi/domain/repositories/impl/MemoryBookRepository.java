package io.github.batetolast1.bookapi.domain.repositories.impl;

import io.github.batetolast1.bookapi.domain.entities.Book;
import io.github.batetolast1.bookapi.domain.repositories.BookRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class MemoryBookRepository implements BookRepository {

    private final Logger log = LogManager.getLogger(MemoryBookRepository.class);

    private final List<Book> books;
    private Long id;

    public MemoryBookRepository() {
        books = new ArrayList<>();
        id = 1L;
        initializeRepository();
        log.info("DB initialized");
    }

    private void initializeRepository() {
        save(new Book(null, "9788324631766", "Thinking in Java", "Bruce Eckel", "Helion", "programming"));
        save(new Book(null, "9788324627738", "Rusz głową Java", "Sierra Kathy, Bates Bert", "Helion", "programming"));
        save(new Book(null, "9780130819338", "Java 2. Podstawy", "Cay Horstmann, Gary Cornell", "Helion", "programming"));
    }

    @Override
    public List<Book> findAll() {
        log.info("Returned all books from DB");
        return Collections.unmodifiableList(books);
    }

    @Override
    public Book save(Book book) {
        log.info("Book to save: {}", book);
        book.setId(id++);
        books.add(book);
        log.info("Book successfully saved: {}", book);
        return book;
    }

    @Override
    public Book edit(Book book) {
        log.info("Book to edit: {}", book);
        Optional<Book> optionalBook = getById(book.getId());
        if (optionalBook.isPresent()) {
            Book bookToEdit = optionalBook.get();
            log.info("Book with id: {} is found: {}", book.getId(), bookToEdit);

            int index = books.indexOf(bookToEdit);
            books.set(index, book);

            Book bookAfterEdit = books.get(index);
            log.info("Book after edit: {}", book);
            return bookAfterEdit;
        }
        log.debug("Book not found: {}", book);
        return null;
    }

    @Override
    public Optional<Book> getById(Long id) {
        return books.stream()
                .filter(b -> id.equals(b.getId()))
                .findFirst();
    }

    @Override
    public boolean deleteById(Long id) {
        Optional<Book> optionalBook = getById(id);
        if (optionalBook.isPresent()) {
            books.remove(optionalBook.get());
            log.info("Book with id: {} is deleted", id);
            return true;
        }
        log.debug("Book with id: {} not found", id);
        return false;
    }
}
