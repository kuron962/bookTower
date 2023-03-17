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
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    // 本の一覧を取得
    @GetMapping("/books")
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    // 本をIDで取得
    @GetMapping("/books/{id}")
    public Optional<Book> getBookById(@PathVariable("id") int id) {
        return bookService.getBookById(id);
    }

    // 本を追加
    @PostMapping("/book/add")
    public void addBook(@RequestBody @Validated AddBookForm fm) {
        bookService.addBook(fm);
    }

    // 本を編集
    @PostMapping("/book/edit/{id}")
    public void editBook(@PathVariable("id") int id, @RequestBody @Validated EditBookForm fm) {
        bookService.editBook(id,fm);
    }

    // 本を削除
    @DeleteMapping("/book/delete/{id}")
    public void deleteBook(@PathVariable("id") int id) {
        bookService.deleteBook(id);
    }
}

