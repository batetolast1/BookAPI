package io.github.batetolast1.bookapi.mappers;

import io.github.batetolast1.bookapi.domain.entities.Book;
import io.github.batetolast1.bookapi.dtos.BookDTO;

public class BookMapper {

    private BookMapper() {
    }

    public static BookDTO toBookDTO(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setIsbn(book.getIsbn());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setAuthor(book.getAuthor());
        bookDTO.setPublisher(book.getPublisher());
        bookDTO.setType(book.getType());
        return bookDTO;
    }

    public static Book toBook(BookDTO bookDTO) {
        Book book = new Book();
        book.setId(bookDTO.getId());
        book.setIsbn(bookDTO.getIsbn());
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setPublisher(bookDTO.getPublisher());
        book.setType(bookDTO.getType());
        return book;
    }
}
