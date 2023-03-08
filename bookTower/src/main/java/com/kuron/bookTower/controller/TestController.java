package com.kuron.bookTower.controller;

import com.kuron.bookTower.entity.Book;
import com.kuron.bookTower.service.BookService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    BookService bookService;

    @GetMapping(value = "/")
    public String getTest(HttpServletRequest request) {
        return "test!!";
    }

    @GetMapping("/book-list")
    public List<Book> getBooks(HttpServletRequest reques) {
        // serviceを使って、本の一覧をDBから取得する
        List<Book> bookList = bookService.findAll();
        return bookList;
    }
}
