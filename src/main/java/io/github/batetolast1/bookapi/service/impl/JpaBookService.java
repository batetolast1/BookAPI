package io.github.batetolast1.bookapi.service.impl;

import io.github.batetolast1.bookapi.domain.entity.Book;
import io.github.batetolast1.bookapi.domain.repository.BookRepository;
import io.github.batetolast1.bookapi.dtos.BookDTO;
import io.github.batetolast1.bookapi.service.BookService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Primary
@RequiredArgsConstructor
public class JpaBookService implements BookService {

    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<BookDTO> getAllBooks() {
        return bookRepository
                .findAll()
                .stream()
                .map(b -> modelMapper.map(b, BookDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public BookDTO saveNewBook(BookDTO bookDTO) {
        Book bookToSave = modelMapper.map(bookDTO, Book.class);
        Book savedBook = bookRepository.save(bookToSave);
        return modelMapper.map(savedBook, BookDTO.class);
    }

    @Override
    public BookDTO editBook(BookDTO bookDTO) {
        Book bookToEdit = modelMapper.map(bookDTO, Book.class);

        if (bookRepository.existsById(bookToEdit.getId())) {
            Book editedBook = bookRepository.save(bookToEdit);
            return modelMapper.map(editedBook, BookDTO.class);
        }

        return null;
    }

    @Override
    public BookDTO getBookById(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        return optionalBook
                .map(b -> modelMapper.map(b, BookDTO.class))
                .orElse(null);
    }

    @Override
    public boolean deleteBookById(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);

        if (optionalBook.isPresent()) {
            bookRepository.deleteById(id);
            return true;
        }

        return false;
    }
}
