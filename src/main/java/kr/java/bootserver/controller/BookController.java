package kr.java.bootserver.controller;

import kr.java.bootserver.dto.BookForm;
import kr.java.bootserver.entity.Book;
import kr.java.bootserver.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping // '/'
@RequiredArgsConstructor
public class BookController {
    private final BookRepository bookRepository;

    @Value("${app.name}")
    private String appName;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        model.addAttribute("appName", appName);
        return "index";
    }

    @PostMapping
    public String create(BookForm bookForm) {
        Book newBook = new Book();
        newBook.setName(bookForm.name());
        bookRepository.save(newBook);
        return "redirect:/";
    }

}
