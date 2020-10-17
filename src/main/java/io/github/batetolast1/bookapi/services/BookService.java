package io.github.batetolast1.bookapi.services;

import io.github.batetolast1.bookapi.dtos.BookDTO;

import java.util.List;

public interface BookService {

    List<BookDTO> getAllBooks();

    BookDTO saveNewBook(BookDTO bookDTO);

    BookDTO editBook(BookDTO bookDTO);

    BookDTO getBookById(Long id);

    boolean deleteBookById(Long id);
}
