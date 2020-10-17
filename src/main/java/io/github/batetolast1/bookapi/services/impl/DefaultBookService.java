package io.github.batetolast1.bookapi.services.impl;

import io.github.batetolast1.bookapi.domain.entities.Book;
import io.github.batetolast1.bookapi.domain.repositories.BookRepository;
import io.github.batetolast1.bookapi.dtos.BookDTO;
import io.github.batetolast1.bookapi.mappers.BookMapper;
import io.github.batetolast1.bookapi.services.BookService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DefaultBookService implements BookService {

    private final Logger log = LogManager.getLogger(DefaultBookService.class);

    private final BookRepository bookRepository;

    @Autowired
    public DefaultBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookDTO> getAllBooks() {
        log.info("Converted all books to DTOs");
        return bookRepository.findAll()
                .stream()
                .map(BookMapper::toBookDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BookDTO saveNewBook(BookDTO bookDTO) {
        log.info("BookDTO to save: {}", bookDTO);
        Book savedBook = bookRepository.save(BookMapper.toBook(bookDTO));
        return BookMapper.toBookDTO(savedBook);
    }

    @Override
    public BookDTO editBook(BookDTO bookDTO) {
        log.info("BookDTO to edit: {}", bookDTO);
        Book editedBook = bookRepository.edit(BookMapper.toBook(bookDTO));
        if (editedBook == null) {
            log.debug("Book was not edited");
            return null;
        }
        log.info("Book successfully edited");
        return BookMapper.toBookDTO(editedBook);
    }

    @Override
    public BookDTO getBookById(Long id) {
        log.info("Book id to find: {}", id);
        Optional<Book> optionalBook = bookRepository.getById(id);
        if (optionalBook.isPresent()) {
            log.info("Book with id: {} is found", id);
            return BookMapper.toBookDTO(optionalBook.get());
        }
        log.debug("Book with id: {} is not found", id);
        return null;
    }

    @Override
    public boolean deleteBookById(Long id) {
        log.info("Book id to delete: {}", id);
        boolean isDeleted = bookRepository.deleteById(id);
        if (isDeleted) {
            log.info("Book with id: {} is deleted", id);
        } else {
            log.debug("Book with id: {} is not deleted", id);
        }
        return isDeleted;
    }
}
