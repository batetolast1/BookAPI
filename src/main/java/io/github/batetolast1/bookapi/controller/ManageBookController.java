package io.github.batetolast1.bookapi.controller;

import io.github.batetolast1.bookapi.dtos.BookDTO;
import io.github.batetolast1.bookapi.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/books")
@RequiredArgsConstructor
public class ManageBookController {

    private final BookService bookService;

    @GetMapping("/all")
    public String showBooks(Model model) {
        List<BookDTO> bookDTOS = bookService.getAllBooks();
        model.addAttribute("bookDTOS", bookDTOS);
        return "books/all";
    }
}
