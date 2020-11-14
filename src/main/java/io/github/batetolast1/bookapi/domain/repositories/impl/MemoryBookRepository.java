package io.github.batetolast1.bookapi.domain.repositories.impl;

import io.github.batetolast1.bookapi.domain.entities.Book;
import io.github.batetolast1.bookapi.domain.repositories.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class MemoryBookRepository implements BookRepository {

    private final Logger log = LoggerFactory.getLogger(MemoryBookRepository.class);

    private final List<Book> books;
    private Long id;

    public MemoryBookRepository() {
        books = new ArrayList<>();
        id = 1L;
        initializeRepository();
        log.info("DB initialized");
    }

    private void initializeRepository() {
        Book book1 = new Book();
        book1.setIsbn("9788324631766");
        book1.setTitle("Thinking in Java");
        book1.setAuthor("Bruce Eckel");
        book1.setPublisher("Helion");
        book1.setType("programming");
        save(book1);

        Book book2 = new Book();
        book2.setIsbn("9788324627738");
        book2.setTitle("Rusz głową Java");
        book2.setAuthor("Sierra Kathy, Bates Bert");
        book2.setPublisher("Helion");
        book2.setType("programming");
        save(book2);

        Book book3 = new Book();
        book3.setIsbn("9780130819338");
        book3.setTitle("Java 2. Podstawy");
        book3.setAuthor("Cay Horstmann, Gary Cornell");
        book3.setPublisher("Helion");
        book3.setType("programming");
        save(book3);
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
        book.setCreatedOn(LocalDateTime.now());
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
            book.setUpdatedOn(LocalDateTime.now());
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
