package com.kuron.bookTower.controller;

import com.kuron.bookTower.entity.Book;
import com.kuron.bookTower.form.AddBookForm;
import com.kuron.bookTower.form.EditBookForm;
import com.kuron.bookTower.service.BookService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    // 本の一覧を取得
    @GetMapping("/books")
    public List<Book> getBooks(HttpServletRequest request) {
        List<Book> bookList = bookService.getBooks();
        return bookList;
    }

    // categoryごとに本の一覧を取得
    @GetMapping("/books/{category}")
    public List<Book> getBooksByCategory(HttpServletRequest request, @PathVariable("category") String category) {
        List<Book> bookList = bookService.getBooksByCategory(category);
        return bookList;
    }

    @GetMapping("/books/{status}")
    public List<Book> getBooksByStatus(HttpServletRequest request, @PathVariable("status") String status) {
        List<Book> bookList = bookService.getBooksByStatus(status);
        return bookList;
    }

    // 本を追加
    @PostMapping("/book/add")
    public void addBook(@RequestBody @Validated AddBookForm fm) {
        bookService.addBook(fm);
    }

    // 本を編集
    @PostMapping("/book/edit")
    public void editBook(@RequestBody @Validated EditBookForm fm) {
        bookService.editBook(fm);
    }

    // 本を削除
    @DeleteMapping("/book/delete")
    public void deleteBook(@ModelAttribute int id) {
        bookService.deleteBook(id);
    }
}

