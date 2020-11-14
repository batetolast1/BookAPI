package io.github.batetolast1.bookapi.controller;

import io.github.batetolast1.bookapi.domain.entity.Response;
import io.github.batetolast1.bookapi.domain.entity.enums.ResponseStatus;
import io.github.batetolast1.bookapi.dtos.BookDTO;
import io.github.batetolast1.bookapi.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @GetMapping("")
    public Response<List<BookDTO>> getAllBooks() {
        return new Response<>(ResponseStatus.OK, bookService.getAllBooks());
    }

    @PostMapping("")
    public Response<BookDTO> saveNewBook(@RequestBody BookDTO bookDTO) {
        return new Response<>(ResponseStatus.OK, bookService.saveNewBook(bookDTO));
    }

    @PutMapping("")
    public Response<BookDTO> editBook(@RequestBody BookDTO bookDTO) {
        BookDTO editedBookDTO = bookService.editBook(bookDTO);
        if (editedBookDTO == null) {
            return new Response<>(ResponseStatus.NOT_FOUND, null);
        }
        return new Response<>(ResponseStatus.OK, editedBookDTO);
    }

    @GetMapping("/{id:\\d+}")
    public Response<BookDTO> getBookById(@PathVariable("id") Long id) {
        BookDTO bookDTO = bookService.getBookById(id);
        if (bookDTO == null) {
            return new Response<>(ResponseStatus.NOT_FOUND, null);
        }
        return new Response<>(ResponseStatus.OK, bookDTO);
    }

    @DeleteMapping("/{id:\\d+}")
    public Response<Boolean> deleteBookById(@PathVariable("id") Long id) {
        boolean isDeleted = bookService.deleteBookById(id);
        return isDeleted ? new Response<>(ResponseStatus.OK, Boolean.TRUE) : new Response<>(ResponseStatus.NOT_FOUND, Boolean.FALSE);
    }
}
