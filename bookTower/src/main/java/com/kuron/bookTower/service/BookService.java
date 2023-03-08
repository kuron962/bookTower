package com.kuron.bookTower.service;

import com.kuron.bookTower.entity.Book;
import com.kuron.bookTower.form.AddBookForm;
import com.kuron.bookTower.form.EditBookForm;
import com.kuron.bookTower.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookService {

    @Autowired
    BookRepository bookRepository;

    // DBに登録済のレコードを全件取得
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    // 入力した内容をDBに登録
    public void add(AddBookForm fm) {
        // DBに登録する値を保持するインスタンス
        Book book = new Book();

        // 入力から受け取った値をDBに保存するインスタンスに渡す
        book.setTitle(fm.getTitle());
        book.setCategory(fm.getCategory());
        book.setStatus(fm.getStatus());

        // DBに登録する
        bookRepository.save(book);
    }

    // 受け取ったidからデータを取得して、Formを返却する
    public EditBookForm getOneBook(Integer id) {

        // idを指定して本の情報を取得する
        Book book = bookRepository.findById(id).orElseThrow();

        // 画面返却用のFormに値を設定する
        EditBookForm fm = new EditBookForm();
        fm.setId(book.getId());
        fm.setTitle(book.getTitle());
        book.setCategory(book.getCategory());
        book.setStatus(book.getStatus());

        return fm;
    }

    // 本を更新する
    public void edit(EditBookForm fm) {

        // データベースに登録する値を保持するインスタンスの作成
        Book book = new Book();

        // 画面から受け取った値を設定する
        book.setId(fm.getId());
        book.setTitle(fm.getTitle());
        book.setCategory(fm.getCategory());
        book.setStatus(fm.getStatus());

        // データベースを更新する
        bookRepository.save(book);
    }

    // 本を削除する
    public void delete(Integer id) {

        // idを指定して、データベースからデータを削除する
        bookRepository.deleteById(id);
    }
}
