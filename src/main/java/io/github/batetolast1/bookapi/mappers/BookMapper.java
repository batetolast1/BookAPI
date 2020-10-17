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
        return new Book(
                bookDTO.getId(),
                bookDTO.getIsbn(),
                bookDTO.getTitle(),
                bookDTO.getAuthor(),
                bookDTO.getPublisher(),
                bookDTO.getType()
        );
    }
}
