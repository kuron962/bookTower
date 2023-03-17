package com.kuron.bookTower.service;

import com.kuron.bookTower.entity.Book;
import com.kuron.bookTower.form.AddBookForm;
import com.kuron.bookTower.form.EditBookForm;
import com.kuron.bookTower.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(int id) {
        return bookRepository.findById(id);
    }

    public void addBook(AddBookForm fm) {
        Book book = new Book();

        book.setTitle(fm.getTitle());
        book.setCategory(fm.getCategory());
        book.setStatus(fm.getStatus());

        bookRepository.save(book);
    }

    public void editBook(int id, EditBookForm fm) {
        Book book = new Book();

        book.setId(id);
        book.setTitle(fm.getTitle());
        book.setCategory(fm.getCategory());
        book.setStatus(fm.getStatus());

        bookRepository.save(book);
    }

    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }
}
