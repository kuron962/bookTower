package com.kuron.bookTower.controller;

import com.kuron.bookTower.entity.Book;
import com.kuron.bookTower.form.AddBookForm;
import com.kuron.bookTower.service.BookService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping(value = "/hello")
    public String getTest(HttpServletRequest request) {
        return "こんにちは!!";
    }

    @GetMapping("/books")
    public String getBooks(Model model) {
        // serviceを使って、本の一覧をDBから取得する
        List<Book> bookList = bookService.findAll();
        // modelに本の一覧を設定して、画面に渡す
        model.addAttribute("bookList", bookList);
        // bookList.htmlの表示
        return "books";
    }

    @GetMapping("/add-book")
    public String getBookForm(Model model) {
        model.addAttribute("addBookForm", new AddBookForm());
        return "add";
    }

    @PostMapping("/add-book")
    public String addBook(@ModelAttribute @Validated AddBookForm addBookForm, BindingResult result, Model model) {

        // バリデーションエラーの場合
        if(result.hasErrors()) {
            // 新規登録画面に遷移
            return "add";
        }
        // 本を登録する
        bookService.add(addBookForm);

        // 本の一覧表示画面にリダイレクト
        return "redirect:/books";
    }
}

