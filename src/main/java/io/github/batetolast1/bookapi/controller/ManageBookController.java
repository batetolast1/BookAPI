package io.github.batetolast1.bookapi.controller;

import io.github.batetolast1.bookapi.dtos.BookDTO;
import io.github.batetolast1.bookapi.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/books")
@RequiredArgsConstructor
public class ManageBookController {

    private final BookService bookService;

    @GetMapping("/all")
    public String displayAll(Model model) {
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

    @GetMapping("/confirm-delete")
    public String confirmDelete(Model model, @RequestParam(name = "id") Long id) {
        model.addAttribute("id", id);
        return "books/delete";
    }

    @GetMapping("/delete")
    public String processDelete(@RequestParam(name = "id") Long id) {
        bookService.deleteBookById(id);
        return "redirect:/admin/books/all";
    }

    @GetMapping("/edit")
    public String displayEditForm(Model model, @RequestParam(name = "id") Long id) {
        BookDTO bookDTO = bookService.getBookById(id);

        if (bookDTO != null) {
            model.addAttribute("bookDTO", bookDTO);
            return "books/edit";
        }

        return "redirect:/admin/books/all";
    }

    @PostMapping("/edit")
    public String processEditForm(@Valid BookDTO bookDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "books/edit";
        }

        bookService.editBook(bookDTO);
        return "redirect:/admin/books/all";
    }

    @GetMapping("/details")
    public String displayDetails(Model model, @RequestParam(name = "id") Long id) {
        BookDTO bookDTO = bookService.getBookById(id);

        if (bookDTO != null) {
            model.addAttribute("bookDTO", bookDTO);
            return "books/details";
        }

        return "redirect:/admin/books/all";
    }
}
