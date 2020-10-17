package io.github.batetolast1.bookapi.controllers;

import io.github.batetolast1.bookapi.domain.entities.Response;
import io.github.batetolast1.bookapi.domain.entities.enums.Status;
import io.github.batetolast1.bookapi.dtos.BookDTO;
import io.github.batetolast1.bookapi.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public Response<List<BookDTO>> getAllBooks() {
        return new Response<>(Status.OK, bookService.getAllBooks());
    }

    @PostMapping("")
    public Response<BookDTO> saveNewBook(@RequestBody BookDTO bookDTO) {
        return new Response<>(Status.OK, bookService.saveNewBook(bookDTO));
    }

    @PutMapping("")
    public Response<BookDTO> editBook(@RequestBody BookDTO bookDTO) {
        BookDTO editedBookDTO = bookService.editBook(bookDTO);
        if (editedBookDTO == null) {
            return new Response<>(Status.NOT_FOUND, null);
        }
        return new Response<>(Status.OK, editedBookDTO);
    }

    @GetMapping("/{id:\\d+}")
    public Response<BookDTO> getBookById(@PathVariable("id") Long id) {
        BookDTO bookDTO = bookService.getBookById(id);
        if (bookDTO == null) {
            return new Response<>(Status.NOT_FOUND, null);
        }
        return new Response<>(Status.OK, bookDTO);
    }

    @DeleteMapping("/{id:\\d+}")
    public Response<Boolean> deleteBookById(@PathVariable("id") Long id) {
        boolean isDeleted = bookService.deleteBookById(id);
        return isDeleted ? new Response<>(Status.OK, Boolean.TRUE) : new Response<>(Status.NOT_FOUND, Boolean.FALSE);
    }
}
