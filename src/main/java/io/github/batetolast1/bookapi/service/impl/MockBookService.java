package io.github.batetolast1.bookapi.service.impl;

import io.github.batetolast1.bookapi.domain.entity.Book;
import io.github.batetolast1.bookapi.domain.dao.BookDao;
import io.github.batetolast1.bookapi.dtos.BookDTO;
import io.github.batetolast1.bookapi.mapper.BookMapper;
import io.github.batetolast1.bookapi.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MockBookService implements BookService {

    private final Logger log = LoggerFactory.getLogger(MockBookService.class);

    private final BookDao bookDao;

    @Autowired
    public MockBookService(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public List<BookDTO> getAllBooks() {
        log.info("Converted all books to DTOs");
        return bookDao.findAll()
                .stream()
                .map(BookMapper::toBookDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BookDTO saveNewBook(BookDTO bookDTO) {
        log.info("BookDTO to save: {}", bookDTO);
        Book savedBook = bookDao.save(BookMapper.toBook(bookDTO));
        return BookMapper.toBookDTO(savedBook);
    }

    @Override
    public BookDTO editBook(BookDTO bookDTO) {
        log.info("BookDTO to edit: {}", bookDTO);
        Book editedBook = bookDao.edit(BookMapper.toBook(bookDTO));
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
        Optional<Book> optionalBook = bookDao.getById(id);
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
        boolean isDeleted = bookDao.deleteById(id);
        if (isDeleted) {
            log.info("Book with id: {} is deleted", id);
        } else {
            log.debug("Book with id: {} is not deleted", id);
        }
        return isDeleted;
    }
}
