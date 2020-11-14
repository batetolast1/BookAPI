package io.github.batetolast1.bookapi.controller;

import io.github.batetolast1.bookapi.dtos.BookDTO;
import io.github.batetolast1.bookapi.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
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

    @GetMapping("/add")
    public String displayAddForm(Model model) {
        model.addAttribute("bookDTO", new BookDTO());
        return "books/add";
    }

    @PostMapping("/add")
    public String processAddForm(@Valid BookDTO bookDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "books/add";
        }

        bookService.saveNewBook(bookDTO);
        return "redirect:/admin/books/all";
    }
}
